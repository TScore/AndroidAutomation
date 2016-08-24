package com.ngage.dblayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.ngage.automationscript.utili.PropertyHandler;

public class CheckListHandel {
	//set the data in excel sheet
		public void setExcelStringData(String CheckListExcelSheet,int sheetNo, int rowNum , int columeNum , String data) throws InvalidFormatException, IOException{
			//Property   file add
			//out put data set
			//PropertyHandler.getProperty("CHECKLISTOFANDROID")
			FileInputStream fis = new FileInputStream(CheckListExcelSheet);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			Sheet sh = workbook.getSheetAt(sheetNo);
			Row r = sh.getRow(rowNum);
			Cell c = r.createCell(columeNum);
			c.setCellType(Cell.CELL_TYPE_STRING);
			c.setCellValue(data);
			//set the value in out put data(OutPutDataFile)
			FileOutputStream fos = new FileOutputStream(CheckListExcelSheet);
			workbook.write(fos);	 
		}
		public void setErrorMessage(String CheckListExcelSheet,int sheetNo, int rowNum , int columeNum , String data) throws IOException{
			// Create Workbook and Worksheet
			FileInputStream fis = new FileInputStream(CheckListExcelSheet); 
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
			FileOutputStream out = new FileOutputStream(new File(CheckListExcelSheet));
			my_workbook.write(out);
		}

}
