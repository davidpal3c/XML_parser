
# XML Parser Program 
(Complexity Analysis)

**Authors:** David Palacios, Ngoc Tam Nguyen  
**Date:** October 1, 2024  


This XML Parser program is a Java-based tool designed to parse XML files and extract tags. It provides a custom implementation of data structures such as MyArrayList and MyStack to manage and store parsed elements efficiently. The application demonstrates robust handling of file input, line-by-line processing, and custom iterator functionality. This program is executed through a Java Archive file (.jar) via the command line interface.



## Features

    XML Parsing: Reads XML files and extracts tags line-by-line.
    Custom Data Structures: Utilizes custom implementations of ListADT and StackADT.
    Iterator Support: Implements a custom iterator for list traversal.
    Error Handling: Handles exceptions during file reading and parsing.

## Requirements

    Java 8 or higher
    Development environment supporting Maven or manual project setup

## Usage

	- Place the XML file to be parsed inside the res directory.
	- Access the /dist folder inside Terminal and run the Parser.jar file adding the name of the XML file to path:

	java -jar Parser.jar sample1.xml



## Output

Parsed tags from the XML file are printed to the console or can be accessed programmatically via the parsedE list.

Custom Data Structures

    MyArrayList: A resizable array-based list with iterator support.
    MyStack: A stack implementation for managing hierarchical elements during parsing.




