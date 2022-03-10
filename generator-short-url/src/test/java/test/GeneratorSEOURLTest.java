package test;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class GeneratorSEOURLTest {


    private static URL LONG_URL;

    @BeforeAll
    public static void init() throws MalformedURLException {
        LONG_URL = new URL("http://looooong.com/somepath");
    }

    @Test
    public void ifSEOMore20charactersThenIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GeneratorSEOURL().generateSeoURL(LONG_URL,
                        "fmgkdfngkdjsnvnsdjkgfsfjfgjfjgjgjgkfkfdsnjsgf"));
    }

    @Test
    public void ifSeoMYNEWWSThenCorrectURL() throws MalformedURLException {
        Assertions.assertEquals(new URL("http://short.com/MY-NEW-WS"),
                new GeneratorSEOURL().generateSeoURL(LONG_URL,"MY-NEW-WS"));
    }

    @Test
    public void ifSeoPOTATOThenCorrectURL() throws MalformedURLException {
        Assertions.assertEquals(new URL("http://short.com/POTATO"),
                new GeneratorSEOURL().generateSeoURL(LONG_URL,"POTATO"));
    }

    @Test
    public void ifSeoIncorrectThenIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GeneratorSEOURL().generateSeoURL(LONG_URL, " :::"));
    }

    @Test
    public void testGenerateShortURL() {

        var shortUrl = new GeneratorSEOURL()
                .generateShortRandomURL(LONG_URL)
                .toString();

        Assertions.assertEquals("http://short.com/ZfGd".length(), shortUrl.length());

    }

    @RepeatedTest(100)
    public void checkIfPathAlphanumeric() {
        String path = new GeneratorSEOURL().generateShortRandomURL(LONG_URL)
                .getPath();
        Assertions.assertTrue(path.matches("^/[a-zA-Z0-9]{4}$"));
    }

    @Test
    public void checkGetLongURLBYShortURL() {
        GeneratorSEOURL generator = new GeneratorSEOURL();
        URL shortURL = generator.generateShortRandomURL(LONG_URL);
        Assertions.assertEquals(LONG_URL, generator.getLongURLByShortURL(shortURL));
    }

}