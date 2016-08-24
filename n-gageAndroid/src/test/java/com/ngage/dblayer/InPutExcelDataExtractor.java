package com.ngage.dblayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.ngage.automationscript.utili.PropertyHandler;
import com.ngage.bean.OneToOneConversationData;
import com.ngage.bean.RegisterData;


/*@Author=Tapana
 *@Time=4:45pm 29Nov 2014 
 *@Descrption:In this calss callaction of excel sheet opertion ,one method copy one file to another file, 
 * setExcelStringData() method to send validate data to excel sheet,
 * setErrorMessage() method to send fail data and add coler in excel sheet
 * */
public class InPutExcelDataExtractor {
	//load logger file
	private static Logger Log = Logger.getLogger(InPutExcelDataExtractor.class.getName());
	//copy data to copy input excel  sheet to output excel sheet.
	public void copyData(){
		try {
			//load file of excel sheet.
			FileInputStream file = new FileInputStream(new File(PropertyHandler.getProperty("InPutDataFile")));
			//Get the workbook instance for XLS file 
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			//Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				//For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch(cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:

						break;
					case Cell.CELL_TYPE_NUMERIC:

						break;
					case Cell.CELL_TYPE_STRING:

						break;
					}
				}
			}
			file.close();
			FileOutputStream out =new FileOutputStream(new File(PropertyHandler.getProperty("OutPutDataFile")));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			Log.info("exception in reading  data from list");
		} catch (IOException e) {
			Log.info("exception in reading  data from list");
		}
	}
	//set the data in excel sheet
	public void setExcelStringData(int sheetNo, int rowNum , int columeNum , String data) throws InvalidFormatException, IOException{
		//Property   file add
		//out put data set
		FileInputStream fis = new FileInputStream(PropertyHandler.getProperty("OutPutDataFile"));
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		Sheet sh = workbook.getSheetAt(sheetNo);
		Row r = sh.getRow(rowNum);
		Cell c = r.createCell(columeNum);
		c.setCellType(Cell.CELL_TYPE_STRING);
		c.setCellValue(data);
		//set the value in out put data(OutPutDataFile)
		FileOutputStream fos = new FileOutputStream(PropertyHandler.getProperty("OutPutDataFile"));
		workbook.write(fos);	 
	}
	public void setErrorMessage(int sheetNo, int rowNum , int columeNum , String data) throws IOException{
		// Create Workbook and Worksheet
		FileInputStream fis = new FileInputStream(PropertyHandler.getProperty("OutPutDataFile")); 
		HSSFWorkbook my_workbook = new HSSFWorkbook(fis);
		HSSFSheet my_sheet = my_workbook.getSheetAt(sheetNo);
		// Get access to HSSFCellStyl
		HSSFCellStyle my_style = my_workbook.createCellStyle();
		// We will now specify a background cell color */
		my_style.setFillPattern(HSSFCellStyle.FINE_DOTS );
		my_style.setFillForegroundColor(new HSSFColor.BLUE_GREY().getIndex());
		my_style.setFillBackgroundColor(new HSSFColor.PINK().getIndex());

		//Create a row in the sheet */
		Row row = my_sheet.getRow(rowNum);
		//Create a cell
		Cell cell = row.createCell(columeNum);
		cell.setCellValue(data);
		//Attach the style to the cell
		cell.setCellStyle(my_style);
		//Write changes to the workbook
		FileOutputStream out = new FileOutputStream(new File(PropertyHandler.getProperty("OutPutDataFile")));
		my_workbook.write(out);
	}
	/**
	 * method to load excel sheet data on input sheet number
	 * @param sheetNumber
	 * @return HSSFSheet object
	 */

	private HSSFSheet getHssfSheet(Integer sheetNumber) {
		HSSFSheet hssfSheet = null;	

		try {
			FileInputStream file = new FileInputStream(new File(PropertyHandler.getProperty("InPutDataFile")));
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file);
			hssfSheet = hssfWorkbook.getSheetAt(sheetNumber);
		} catch (FileNotFoundException e) {		
			Log.info("exception in reading  data from list");
		} catch (IOException e) {
			Log.info("exception in reading  data from list");
		}
		return hssfSheet;
	}
	
	public List<RegisterData> getResisterDataList(Integer sheetNumber)
	{		
		List<RegisterData> resisterDataList = null;		

		try{			
			HSSFSheet hssfSheet = getHssfSheet(sheetNumber);
			if(hssfSheet == null){
				return null;
			}
			//Row number starts with 0
			int totalRows = hssfSheet.getLastRowNum();			
			if(totalRows!=0)
			{
				//colummn number starts with 1				
				resisterDataList = new ArrayList<RegisterData>();				
				//0th row contains column headings
				for (int i = 1; i <=totalRows; i++)
				{
					RegisterData resisterData = new RegisterData();		
					Row row = hssfSheet.getRow(i);
					//set the data to the variables defined in AddingcontactData class
					resisterData.setName(row.getCell(0).getStringCellValue()!=null ? row.getCell(0).getStringCellValue() : null );
					resisterData.setCountry(row.getCell(1).getStringCellValue()!=null ? row.getCell(1).getStringCellValue() : null );
					String Mobile=(row.getCell(2).getStringCellValue()!=null ? row.getCell(2).getStringCellValue() : null );
					Mobile=Mobile.replace("_","");
					resisterData.setMobile(Mobile);
					//resisterData.setCountry(row.getCell(3).getStringCellValue()!=null ? row.getCell(3).getStringCellValue() : null );
					String OTP=(row.getCell(3).getStringCellValue()!=null ? row.getCell(3).getStringCellValue() : null );
					OTP=OTP.replace("_","");
					resisterData.setOTP(OTP);
					resisterDataList.add(resisterData);	
				}
			}				
		}catch(Exception e){
			Log.info("exception in reading  data from RegisterData ");
		}		
		return resisterDataList;
	}	
	public List<OneToOneConversationData> getOneToOneData(Integer sheetNumber)
	{		
		List<OneToOneConversationData> oneToOneConversationDataList = null;		

		try{			
			HSSFSheet hssfSheet = getHssfSheet(sheetNumber);
			if(hssfSheet == null){
				return null;
			}
			//Row number starts with 0
			int totalRows = hssfSheet.getLastRowNum();			
			if(totalRows!=0)
			{
				//colummn number starts with 1				
				oneToOneConversationDataList = new ArrayList<OneToOneConversationData>();				
				//0th row contains column headings
				for (int i = 1; i <=totalRows; i++)
				{
					OneToOneConversationData oneToOneConversationData = new OneToOneConversationData();		
					Row row = hssfSheet.getRow(i);
					//set the data to the variables defined in AddingcontactData class
					String ConactNumber=(row.getCell(0).getStringCellValue()!=null ? row.getCell(0).getStringCellValue() : null);
					ConactNumber=ConactNumber.replace("_","");
					oneToOneConversationData.setContactNumber(ConactNumber);
					Double NumberOfMessage=(row.getCell(1).getNumericCellValue()!=0 ? row.getCell(1).getNumericCellValue(): null );
					int messageNo= NumberOfMessage.intValue();
					oneToOneConversationData.setMessageSendingNumber(messageNo);
					oneToOneConversationData.setMessageText(row.getCell(2).getStringCellValue()!=null ? row.getCell(2).getStringCellValue() : null);
					oneToOneConversationDataList.add(oneToOneConversationData);	
				}
			}				
		}catch(Exception e){
			Log.info("exception in reading  data from oneToOneConversationDataList ");
		}		
		return oneToOneConversationDataList;
	}
	
}
