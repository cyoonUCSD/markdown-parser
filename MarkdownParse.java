//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            //check to see if open bracket exists, break if not
            if (markdown.indexOf("[", currentIndex) == -1) {
                break;
            }
            
            //check if ! and [ follow each other; skip 2 indices to avoid catching
            //image link
            if (markdown.indexOf("!", currentIndex) == markdown.indexOf("[", currentIndex)-1 && markdown.indexOf("!", currentIndex) != -1) {
                currentIndex+=2;
                continue;
            }
            
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);

            //logic based specification: check if link is secured by checking
            //for https://
            if (markdown.indexOf("https://", openParen) == -1) {
                currentIndex++;
                continue;
            }
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
