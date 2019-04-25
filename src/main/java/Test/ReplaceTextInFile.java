package Test;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReplaceTextInFile {
	public static String str_InputFile;
	public static void main(String[] args) throws Exception {

        BufferedReader reader;
        str_InputFile = "C:\\Users\\mibrahim\\Desktop\\1.txt";        
                        
            reader = new BufferedReader(new FileReader(str_InputFile));
            String line = reader.readLine();

            
            while (line != null) {
                if(line.contains("put(\"") && line.contains(",\"")) {
                	String a = null;
                	if(line.contains("put(\"") && line.contains(",\"")) {
                		a=line.substring(line.indexOf("put(\"")+5,line.indexOf("\","));
                	}else {
                		
                	}
                    System.out.println(a);
                }
                line = reader.readLine();
            }
	}
}
