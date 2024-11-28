/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author user
 */
public class XmlParser {
    
    public StackADT<String> stack;
//    QueueADT<String> queue = new MyQueue<>();            
    public ListADT<String> parsedE;

    
    public XmlParser() {
        stack = new MyStack<>();
        parsedE = new MyArrayList<>();
    }
        
    
    public void parseFile(Path path) {
        int lineNum = 1;      
            try (BufferedReader reader = Files.newBufferedReader(path)) {           
                String line;
                while ((line = reader.readLine()) != null) {                                            
//                    System.out.println(line);
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
//                    System.out.println("closing tag: " + tagName);

                    if (stack.isEmpty() || !stack.peek().equals(tagName)) {                   
                        System.out.println("Error at line " + lineNum + "\nUnmatched closing tag: <" + tagContent + ">");
                    } else {
                        parsedE.add(stack.peek());
                        stack.pop();
                    }
                } else {  
                    String tagName = tagContent.split(" ")[0].trim();       //set first word as tag name (ignore attributes)
//                    System.out.println("opening tag: " + tagName);
                    stack.push(tagName);
                }

                tagStart = tagEnd + 1;  
            } else {
                tagStart++;  
            }
        }
       
    }
    

}

    
    

