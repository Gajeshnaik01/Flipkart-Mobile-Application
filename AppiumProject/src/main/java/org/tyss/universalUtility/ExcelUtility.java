package org.tyss.universalUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains reusable methods for Excelfile
 * @author Gajesh naik
 *
 */
public final class ExcelUtility 
{
	private Workbook workbook;
	private Sheet sheet ;

	/**
	 * This method is used to initialize the Excelfile
	 * @param filePath
	 */

	public void initializeExcelFile(String excelFilePath)
	{
		FileInputStream fisExcel=null;;

		try 
		{
			fisExcel = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			workbook=WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	/**
	 * This method is used to fetch the data from Excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getDataFromExcelSheet(String sheetName,int rowNum,int cellNum)
	{

		sheet = workbook.getSheet(sheetName);
		DataFormatter format=new DataFormatter();
		String value = format.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		return value;

	}
	/**
	 * This method is used to write the data to excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @param excelFilePath
	 */

	public void setDataToExcel(String sheetName,int rowNum,int cellNum,String value)
	{
		sheet=workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);

		cell.setCellValue(value);
		System.out.println("Data entered to excel");
	}
	/**
	 * This method is used to save the written data to excel
	 */
	public void saveWrittenDataToExcel(String excelsaveFilePath)
	{
		FileOutputStream fosExcel=null;
		try 
		{
			fosExcel=new FileOutputStream(excelsaveFilePath);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			workbook.write(fosExcel);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close the excelworkbook
	 */
	public void closeWorkbook()
	{
		try 
		{
			workbook.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to get multiple data from excel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String[][] getMultipleDataFromDataBase() throws EncryptedDocumentException, IOException
	{
		DataFormatter format=new DataFormatter();
		FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("DataProvider");
		int rowNum=sheet.getLastRowNum();
		int cellNum=sheet.getRow(0).getLastCellNum();
		
		String [][] str=new String[rowNum+1][cellNum];

		for (int i = 0; i <=rowNum; i++)
		{
			for (int j = 0; j <cellNum; j++) 
			{
				str[i][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
			}

		}
//		int m= 0;
//		for (int i = 0; i<rowNum; i++)
//		{
//			int n= 0;
//			for(int j=0;j<cellNum;j++)
//			{
//				str[i][j]=format.formatCellValue(sheet.getRow(m).getCell(n));
//				n++;
//			}
//			m++;
//		}
		
		workbook.close();
		return str;

	}

}
