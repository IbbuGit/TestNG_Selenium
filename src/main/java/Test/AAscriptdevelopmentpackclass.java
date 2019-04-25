package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class AAscriptdevelopmentpackclass {

	public static String str_InputFile;
	public static String str_OutputFile;

	public static void main(String[] args) throws Exception {

        BufferedReader reader;
        str_InputFile = "E:\\Selenium\\SeleniumWorkSpace\\getsetgo\\inputproperties.txt";
        str_OutputFile = "E:\\Selenium\\SeleniumWorkSpace\\getsetgo\\outputcode.txt";
        

        try {
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> classlist = new ArrayList<String>();
            File file = new File(str_OutputFile);
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            reader = new BufferedReader(new FileReader(str_InputFile));
            String line = reader.readLine();


            System.setOut(ps);
            System.out.println("****************************************************************************************************************************");
            System.out.println("Test Data Column Begin");
            System.out.println("****************************************************************************************************************************");
            while (line != null) {
                if(line.contains("class")) {
                    String a=line.trim().replace("public", "").replace("class", "").replace("extends", "").replace("BasePage", "").replace("{", "").trim();
                    classlist.add(a);                                
                }else if(line.contains("WebElement")) {
                    String strCurrentElement = line.trim().replace("private WebElement ", "").replace(";","");
                    list.add(strCurrentElement);
                    System.out.println(strCurrentElement);                         
                }else if(line.contains("@FindBy")) {
                	//String strFindByLOC = line.trim();
                }

                
                line = reader.readLine();
            }

            System.out.println();
            System.out.println("****************************************************************************************************************************");
            System.out.println("Test Data Column End");
            System.out.println("****************************************************************************************************************************");

            
            System.out.println("****************************************************************************************************************************");
            System.out.println("Getter and Setter Begin");
            System.out.println("****************************************************************************************************************************");

            for (String data : list) {
            	
            	if(	(data.contains("Button"))	||(data.contains("Select"))	||(data.contains("Tab"))	||(data.contains("Menu"))	||(data.contains("SubMenu"))	) {
                    System.out.println("public void click_"+data+"(String TestData_"+data+") {");
                    System.out.println("	doIT("+data+", TestData_"+data+");");

                }else if(	(data.contains("Header"))	||(data.contains("Message"))	||(data.contains("Validation"))	||(data.contains("Error"))	||(data.contains("Checkpoint"))	||(data.contains("Successful"))	) {
                    System.out.println("public String get_"+data+"(String TestData_"+data+") {");	
                    System.out.println("	return doIT("+data+", TestData_"+data+");");
                }else {
                    System.out.println("public void set_"+data+"(String TestData_"+data+") {");
                    System.out.println("	doIT("+data+", TestData_"+data+");");
                }
                
                System.out.println("}");
                System.out.println();
                
               // System.out.println("public boolean isDisplayed_"+data+"(String TestData_"+data+") {");
                //System.out.println("	return isDisplayed("+data+", TestData_"+data+");");
                System.out.println("public boolean isDisplayed_"+data+"() {");
                System.out.println("	return isDisplayed("+data+");");
                System.out.println("}");
                System.out.println();
                
                System.out.println("****************************************************************************************************************************");
                
            }

            System.out.println("****************************************************************************************************************************");
            System.out.println("Getter and Setter End");
            System.out.println("****************************************************************************************************************************");

            
            System.out.println("****************************************************************************************************************************");
            System.out.println("Process Begin");
            System.out.println("****************************************************************************************************************************");

            String classname=classlist.get(0);                                              
            System.out.println(classname+" obj"+classname+"	=	new "+classname+"(driver,report);");
            System.out.println();
            
            System.out.println("Qfund_Navigation_PO objQfund_Navigation_PO	=	new Qfund_Navigation_PO (driver,report);");
            System.out.println("objQfund_Navigation_PO.<<Your Page Navigation>>");

            System.out.println();

            for (String data : list) {
            	if(	(data.contains("Button"))	||(data.contains("Select"))	||(data.contains("Tab"))	||(data.contains("Menu"))	||(data.contains("SubMenu"))	) {
                    System.out.println();
                    System.out.println("obj"+classname+".click_"+data+"(data("+"\""+data+"\""+"));");
                    System.out.println();
                }else if(	(data.contains("Header") )	||(data.contains("Message"))	||(data.contains("Validation"))	||(data.contains("Error"))	||(data.contains("Checkpoint"))	||(data.contains("Successful"))	) {
                    System.out.println("//obj"+classname+".get_"+data+"(data("+"\""+data+"\""+"));");
                    System.out.println("//obj"+classname+".isDisplayed_"+data+"(data("+"\""+data+"\""+"));");
                    System.out.println();
                    System.out.println("assertAreEqual(\"Verification Point\", report, obj"+classname+".get_"+data+"(data("+"\""+data+"\""+")), data("+"\""+data+"\""+"));");
                    System.out.println();
                }else {
                    System.out.println("obj"+classname+".set_"+data+"(data("+"\""+data+"\""+"));");
                }
            }
            System.out.println("****************************************************************************************************************************");
            System.out.println("Process End");
            System.out.println("****************************************************************************************************************************");
            reader.close();
        } catch (IOException e) {
                        e.printStackTrace();
        }

}

	
}
