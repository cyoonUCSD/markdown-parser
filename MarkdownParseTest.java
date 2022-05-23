import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;

public class MarkdownParseTest {
    @Test //tester
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getlinks1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://something.com");

        assertEquals(expected, links);
    }

    @Test
    public void getlinksnew2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://something.com");

        assertEquals(expected, links);
    }

    @Test
    public void getlinksnew3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of();

        assertEquals(expected, links);
    }

    @Test
    public void getlinksnew4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of();

        assertEquals(expected, links);
    }

    @Test
    public void getlinksnew5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of();

        assertEquals(expected, links);
    }

    @Test
    public void getlinksnew6() throws IOException {
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of();

        assertEquals(expected, links);
    }

    @Test
    public void getlinksnew7() throws IOException {
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of();

        assertEquals(expected, links);
    }

    @Test
    public void getlinksnew8() throws IOException {
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of();

        assertEquals(expected, links);
    }

    @Test
    public void getlinksSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");

        assertEquals(expected, links);
    }

    @Test
    public void getlinksSnippet2() throws IOException {
        Path fileName = Path.of("Snippet2.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("a.com", "a.com(())", "example.com");

        assertEquals(expected, links);
    }

    @Test
    public void getlinksSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of(" https://www.twitter.com", "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "https://cse.ucsd.edu/");

        assertEquals(expected, links);
    }
}
