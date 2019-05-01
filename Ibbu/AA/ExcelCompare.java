import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;




public class ExcelCompare {
	DataFormatter formatter = new DataFormatter();
	static File excelFile1Path=new File("\\\\aacss\\cssfiles\\QA\\Automation QFund\\Docs\\Tracker\\Archive\\Core_FunctionalAreas_ForAutomationTesting.xlsx");
	static File excelFile2Path=new File("\\\\aacss\\cssfiles\\QA\\Automation QFund\\Docs\\Tracker\\TaskTracker\\Fuse Automation Master plan  9.17.2018.xlsx");
	static Workbook workbook1=null,workbook2=null;	
	
	
	public static void main(String[] args) throws Exception {
		try {
			File temp1=new File(System.getProperty("java.io.tmpdir")+"\\"+System.getProperty("user.name")+"excelFile1_Data.xlsx");
			File temp2=new File(System.getProperty("java.io.tmpdir")+"\\"+System.getProperty("user.name")+"excelFile2_Data.xlsx");
			FileUtils.copyFile( excelFile1Path,temp1, true);
			FileUtils.copyFile( excelFile2Path,temp2,true);
			
			excelFile1Path=temp1;
			excelFile2Path=temp2;
			
			workbook1= WorkbookFactory.create(excelFile1Path);
			workbook2= WorkbookFactory.create(excelFile2Path);
			ExcelCompare obj=new ExcelCompare();
			obj.compareSheet(obj.getData(workbook1,"Core",0),obj.getData(workbook2,"Master",3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void compareSheet(ArrayList<String> sheet1ColValues,ArrayList<String> sheet2ColValues) throws Exception{
		boolean found=false;
		for(String val1: sheet1ColValues){
			found=false;
			for(String val2: sheet2ColValues){
				if(val1.equalsIgnoreCase(val2)) {
					found=true;
				}
			}
			if(!found) {
				System.out.println(val1 +"is not found in destination sheet");
			}
		}			
	}
	
	public ArrayList<String> getData(Workbook workbook,String sheetName,int colNo) throws Exception{
		ArrayList<String> data=new ArrayList<String>();

		Sheet sheet = workbook.getSheet(sheetName);

		for (Row row : sheet) {
			String value=formatter.formatCellValue(row.getCell(colNo)).trim();
			if (!value.isEmpty()) {
				data.add(value);
			}
		}

		return data;
	}
	
	public int getRowNumber(Sheet sheet,int columnNo,String findValue) throws Exception {
		int rowNo=0;
		for (Row row : sheet) {
			Cell cell= row.getCell(columnNo);
			if (cell!=null && cell.getRichStringCellValue().getString().trim().equals(findValue)) {
				rowNo=row.getRowNum();
				break;
			}
		}
		return rowNo;
	}

	public int getColumnNumber(Sheet sheet,String colName) throws FrameworkException {	
		int colNo=0;
		Row colRow=sheet.getRow(0);	
		for (int cn=2; cn<colRow.getLastCellNum(); cn++) {
			String _colName = formatter.formatCellValue(colRow.getCell(cn)).trim();
			if(colName.equals(_colName)) {colNo=cn;break;}
		}  

		if(colNo==0) {
			throw new FrameworkException(colName+" Cloumn is not found in the sheet: "+sheet.getSheetName().toString());
		}
		return colNo;
	}

	public void updateDataSheet(String processName,String rowNo,String colName,String valueToUpdate) throws Exception{
		try {
//			FileInputStream fis=new FileInputStream(Driver.testDataFileLocation_Destination);
//			workbook1 = WorkbookFactory.create(fis);
//			Sheet sheet = workbook1.getSheet(processName);
//			Cell cell2Update = sheet.getRow(Integer.parseInt(rowNo)).getCell(getColumnNumber(sheet,colName),MissingCellPolicy.CREATE_NULL_AS_BLANK);
//			cell2Update.setCellValue(valueToUpdate);
//
//			FileOutputStream outputStream = new FileOutputStream(Driver.testDataFileLocation_Destination);
//			workbook1.write(outputStream);
//			outputStream.close();
//			workbook1.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class FrameworkException extends Exception{
	private static final long serialVersionUID = 1L;
	String str1;
	FrameworkException(String str2) {
		str1=str2;
	}
	public String toString(){ 
		return (str1) ;
	}
}
