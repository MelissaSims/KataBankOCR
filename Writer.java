package com.bank.ocr;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Writer {
	private String path;
	private boolean appendToFile = false;
	
	public Writer (String filePath) {
		path = filePath;
	}
	
	public Writer (String filePath, boolean append) {
		path = filePath;
		appendToFile = append;
	}
	
	public void writeToFile( String textLine ) throws IOException {
		FileWriter write = new FileWriter(path, appendToFile);
		PrintWriter print = new PrintWriter(write);
		
		print.printf("%s" + "%n", textLine);
		print.close();
	}
}
