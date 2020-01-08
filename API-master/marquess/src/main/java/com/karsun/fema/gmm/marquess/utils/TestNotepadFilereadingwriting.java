package com.karsun.fema.gmm.marquess.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TestNotepadFilereadingwriting {

	
	public static void main(String[] args) throws IOException {
	
//		File file = new File("/Users/seanthorson/localRepo/text.txt");
//		
//		file.createNewFile();
//		FileWriter fw = new FileWriter("/Users/seanthorson/localRepo/text.txt");
//		BufferedWriter filewriter = new BufferedWriter(fw);
//		filewriter.write("W3s soap services and it consumes more bandwidth 90% of projects using rest services http, can be text, html, https" +
//"json and xml Included, rest service very lights...highly scale ");
//		filewriter.flush();
		
		
		FileReader fr = new FileReader("/Users/seanthorson/localRepo/text.txt");
		BufferedReader filereader = new BufferedReader(fr);
		//System.out.println(filereader.readLine());
		String i = "";
		while((i = filereader.readLine()) !=null){
			
			System.out.println(i);
			
	
		}
		
		int var = 10;
		Integer obj = new  Integer(var);// wrapping ---> autoboxing 
		System.out.println(obj);
		int i1 = obj;
		
		
		
		
		
		
		
	
		
	}

//	private static BufferedReader BufferedReader(FileReader fr) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
}
