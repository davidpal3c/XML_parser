
package appDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import implementations.MyArrayList;
import implementations.MyStack;
import utilities.ListADT;
import utilities.StackADT;

/**
 * XML parser that reads and parses XML files.
 */
public class XmlParser {
    
    public StackADT<String> stack;
    public ListADT<String> parsedE;

    /**
     * Constructor to initialize the stack and parsed elements list.
     */
    public XmlParser() {
        stack = new MyStack<>();
        parsedE = new MyArrayList<>();
    }
        
    /**
     * Parses the XML file at the given path.
     * 
     * @param path The path to the XML file.
     */
    public void parseFile(Path path) {
        int lineNum = 1;      
        try (BufferedReader reader = Files.newBufferedReader(path)) {           
            String line;
            while ((line = reader.readLine()) != null) {                                            
                parseLine(line.trim(), lineNum);                  
                lineNum++;
            }
        } catch (IOException e) {
            System.err.println("Error at line: " + lineNum);
            e.printStackTrace();
        }   
        
        System.out.println("\nParsed Tags : ");
        
        for (int i = 0; i < parsedE.size(); i++) {
            String e = parsedE.get(i);
            System.out.println(e);
        }
    }

    /**
     * Parses a single line of the XML file.
     * 
     * @param line The line to parse.
     * @param lineNum The line number.
     */
    public void parseLine(String line, int lineNum) {
        int tagStart = 0;

        while (tagStart < line.length()) {
            if (line.charAt(tagStart) == '<') {                         // tag start
                int tagEnd = line.indexOf(">", tagStart);  
                if (tagEnd == -1) {
                    break;  
                }

                String tagContent = line.substring(tagStart + 1, tagEnd).trim();  
                if (tagContent.endsWith("/") || tagContent.startsWith("?")) {       //self closing tag
                    tagStart = tagEnd + 1;  
                    continue;
                }

                if (tagContent.startsWith("/")) {                   //closing tag
                    String tagName = tagContent.substring(1).trim(); 

                    if (stack.isEmpty() || !stack.peek().equals(tagName)) {                   
                        System.out.println("Error at line " + lineNum + "\nUnmatched closing tag: <" + tagContent + ">");
                    } else {
                        parsedE.add(stack.peek());
                        stack.pop();
                    }
                } else {  
                    String tagName = tagContent.split(" ")[0].trim();       //set first word as tag name (ignore attributes)
                    stack.push(tagName);
                }

                tagStart = tagEnd + 1;  
            } else {
                tagStart++;  
            }
        }
    }
}