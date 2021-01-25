package digitaltransformation.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.LogStatus;

import digitaltransformation.TestCases.BaseTest;



public class ExcelReadWrite extends BaseTest
{
	
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheetname;
	private static XSSFRow row;
	private static XSSFCell cell;

	
	

	
	//This method is to get the total row count of the data present in the excel
	public static int Excelcount(String Path,String Sheet1Name) throws IOException
	{
		
		FileInputStream Excelfilepath=new FileInputStream(Path);
		ExcelWBook=new XSSFWorkbook(Excelfilepath);
		ExcelWSheetname=ExcelWBook.getSheet(Sheet1Name);
		
		//String data0=ExcelWSheetname.getRow(0).getCell(0).getStringCellValue();
		int lastRowNum = ExcelWSheetname.getLastRowNum();
		//ExcelWSheet=ExcelWBook.getSheet(sheetname);
		//short lastCellNum = ExcelWSheet.getRow(0).getLastCellNum();
		return lastRowNum;
	}
	
	//This method will give the colunm count of that perticular row (Last cell count)
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		FileInputStream Excelfilepath=new FileInputStream(xlfile);
		ExcelWBook=new XSSFWorkbook(Excelfilepath);
		ExcelWSheetname=ExcelWBook.getSheet(xlsheet);
		row=ExcelWSheetname.getRow(rownum);
		int cellcount=row.getLastCellNum();
		ExcelWBook.close();
		Excelfilepath.close();
		return cellcount;
	}
	
	//To Open the Excel File
	public static void setExcelfile(String Path,String Sheet1Name) throws Exception 
	{
		try {
			
		FileInputStream Excelfile=new FileInputStream(Path);
		//To Access the required test data sheet 
		ExcelWBook=new XSSFWorkbook(Excelfile);
		ExcelWSheetname=ExcelWBook.getSheet(Sheet1Name);
			}
		catch(Exception e)	{
			throw(e);
		}			
	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(String excelfilepath,String Sheet1Name, int rownum,int colnum)
	{
		try {
			Excelcount(excelfilepath,Sheet1Name);
			cell=ExcelWSheetname.getRow(rownum).getCell(colnum);
			
			 //cell.setCellType(CELL_TYPE_STRING);
			
			String celData=cell.getStringCellValue();
			
			return celData;
			}
		catch(Exception e){
			System.out.println(e);
			}
	return "";		
	}
	
	public static void setCellData(String excelfilepath,String Sheet2Name,String result,int rownum,int colnum) throws Exception
	{
		
		try {
			setExcelfile(excelfilepath,Sheet2Name);
//			FileInputStream Excelfilepath=new FileInputStream(excelfilepath);
//			ExcelWBook=new XSSFWorkbook(Excelfilepath);
//			ExcelWSheetname=ExcelWBook.getSheet(Sheet2Name);
		row=ExcelWSheetname.getRow(rownum);
		cell=row.getCell(colnum);
				if(cell==null)
				{
					cell=row.createCell(colnum);
					cell.setCellValue(result);
					System.out.println(result+" updated Excel");
					
				}
				else {
					cell.setCellValue(result);
					System.out.println(result+" updated Excel ");
					
					}
		
			FileOutputStream fileout=new FileOutputStream(System.getProperty("user.dir")+"/src/test/java/digitaltransformation/TestData/MyAccountTestData.xlsx");
			ExcelWBook.write(fileout);
			logger.log(LogStatus.INFO, "Case number is Updated to Excel File ");
			fileout.flush();
			fileout.close();
		}
		catch(Exception e) {
			logger.log(LogStatus.INFO, "Case number is not  Updated to Excel File ");
			throw(e);
		}
	
	}

}
