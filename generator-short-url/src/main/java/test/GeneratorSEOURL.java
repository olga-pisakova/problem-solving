package test;
/*
Given as input a URL and a SEO keyword with a max length of 20 characters,
chosen by the user, generate a SEO URL.

Examples:
Input:
URL: http://looooong.com/somepath
SEO keyword: MY-NEW-WS

Output:
URL: http://short.com/MY-NEW-WS

Input:
URL: http://looooong.com/somepath
SEO keyword: POTATO

Output:
URL: http://short.com/POTATO

---------------------------------------------------
Input:
URL: http://looooong.com/somepath

Output:
URL: http://short.com/ZfGd
Given a URL as input, generate a short URL with a path made of a random sequence of
 4 alphanumeric characters.
 */

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

public class GeneratorSEOURL {

    private final HashMap<URL, URL> store = new HashMap<>();
    private final String DOMAIN = "http://short.com/";

    public URL generate(URL input, String SEO) {
        return SEO == null ? generateShortRandomURL(input) : generateSeoURL(input, SEO);
    }

    public URL generateSeoURL(final URL input, final String SEO) {

        if (SEO.length() > 20) {
            throw new IllegalArgumentException("Max length should be less then 20 characters.");
        }

        final URL seoURL;
        try {
            seoURL = new URL(DOMAIN + SEO);
            //noinspection ResultOfMethodCallIgnored
            seoURL.toURI().parseServerAuthority();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new IllegalArgumentException("URL has incorrect syntax.");
        }

        if (store.get(seoURL) != null) {
            throw new IllegalArgumentException("URL with this SEO keyword already exist.");
        }

        store.put(seoURL, input);
        return seoURL;
    }

    public URL generateShortRandomURL(URL input) {
        return generateShortRandomURLLevel(input, 0);
    }

    public URL generateShortRandomURLLevel(URL input, int level) {

        if (level > 4) {
            throw new IllegalStateException("Could not generate uniq short URL");
        }

        final String alphanumeric = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";

        final StringBuilder path = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            var index = new Random().nextInt(0, alphanumeric.length());
            var character = alphanumeric.charAt(index);
            path.append(character);
        }

        //        IntStream.range(0, 4)
        //                .map((i) -> new Random().nextInt(0, alphanumeric.length()))
        //                .mapToObj(alphanumeric::charAt)
        //                .map(String::valueOf)
        //                .collect(Collectors.joining());

        final URL shortURL;
        try {
            shortURL = new URL(DOMAIN + path);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Something went wrong, try again");
        }

        if (store.get(shortURL) != null) {
            level++;
            generateShortRandomURLLevel(input, level);
        }

        store.put(shortURL, input);

        return shortURL;

    }

    public URL getLongURLByShortURL(URL shortURL) {
        return store.get(shortURL);
    }
}
