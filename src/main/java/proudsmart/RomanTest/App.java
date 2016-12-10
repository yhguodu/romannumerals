package proudsmart.RomanTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App 
{
    public static void main( String[] args )
    {
        RomanTest roman = new RomanTest();
        roman.init();
        
        //default test enviroment and file path
        String testEnviroment = "fileTest";
        String filePath = "romantest.txt";
        
        if(args.length > 0) {
        	testEnviroment = args[0];
       
	        if(testEnviroment.equals("terminalTest")) {
	        	terminalTest(roman);
	        }
	        else {
	        	if(args.length>1) 
	        		filePath = args[1];
	        	fileTest(roman, filePath);
	        }
        }
        else
        	fileTest(roman,filePath);
        
    }
    
    public static void terminalTest(RomanTest roman) {
    	Scanner scan = new Scanner(System.in);
        
        System.out.println("please Enter you input:");
        while(true) {
        	String line = scan.nextLine();
        	if(line.equals("Quit")) {
        		System.out.println("program stop");
        		scan.close();
        	}
        	String result = roman.parse(line);
    		if(result != null)
    			System.out.println(result);
    		
        	System.out.println("please continue:");
        }
    }
    
    public static void fileTest( RomanTest roman,String filePath) {
    	try {
        	BufferedReader br = new BufferedReader(
        													new InputStreamReader(
        															new FileInputStream(
        																	new File(filePath))));
        	String line = null;
        	while(true) {
        		line = br.readLine();
        		if(line == null)
        			return;
        		
        		String result = roman.parse(line);
        		if(result != null)
        			System.out.println(result);
        	}
    	}
    	catch(FileNotFoundException fnfe){
    		fnfe.printStackTrace();
    	}
    	catch(IOException ioe) {
    		ioe.printStackTrace();
    	}	
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
