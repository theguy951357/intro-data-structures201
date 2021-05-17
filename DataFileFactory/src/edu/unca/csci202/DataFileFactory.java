package edu.unca.csci202;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random; 


public class DataFileFactory {
	
	private int numberOfFiles;
	private int elementsPerFile;
	private Random rand;
	
	public DataFileFactory(int numberOfFiles, int elementsPerFile) {
		this.elementsPerFile = elementsPerFile;
		this.numberOfFiles = numberOfFiles;
		this.rand = new Random();
	}
	
	public String getFileName(int fileNumber) throws IOException {
		if(fileNumber >= 0 && fileNumber < this.numberOfFiles ) {
			String fileName = "data_file_"+ fileNumber +".txt";
			return fileName;
		}
		throw new FileNotFoundException("index out of range");
	}
	
	public void writeFiles() throws IOException {
		writeFiles(0.0);
	}

	public void writeFiles(double errorRate) throws IOException {
		
		for(int i = 0; i< this.numberOfFiles; i++) {
			// open the file for writing
			String fileName = "data_file_"+ i +".txt";
			System.out.print("writing file "+fileName+" ");
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			// count how many error were generated
			int errorCount = 0;
			
			for(int j=0; j< this.elementsPerFile; j++) {
				// check if we should write an error to the file
				float probabilityOfError = this.rand.nextFloat();
				if( probabilityOfError < errorRate ) {
					bw.write(generateRandomString(5));
					bw.newLine();
					errorCount++;
				}
				
				// write a random number to the file
				int randNumber = this.rand.nextInt(100);
				bw.write( Integer.toString(randNumber) );
				bw.newLine();
			}
			
			// close the file
			bw.flush();
			fos.close();
			System.out.print("\t wrote " + this.elementsPerFile + " number to file, ");
			System.out.println("and " + errorCount + " errors.");
		}
	}
	
	private String generateRandomString(int length) {
		String returnString = "";
		for(int i=0; i<length; i++) {
			int asciiValue = this.rand.nextInt(26) + 97; // 'a' == 97
			returnString += Character.toString((char) asciiValue);
		}
		return returnString;
	}

	public void removeFiles() {
		for(int i = 0; i< this.numberOfFiles; i++) {
			String fileName = "data_file_"+ i +".txt";
	        File file = new File(fileName); 
	        if(file.delete()) {
	        	System.out.println(fileName+" deleted");
	        }
		}
	}
}
