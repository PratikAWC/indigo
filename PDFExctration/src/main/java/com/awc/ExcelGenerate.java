package com.awc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.awc.dao.ExcelData;

public class ExcelGenerate {

/**
 * @author Pratik
 *
 */
	private ExcelData excelData;
	private PdfStripper stripper;
	private Map<Integer, ArrayList<String>> map;
	public ExcelGenerate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the stripper
	 */
	public PdfStripper getStripper() {
		return stripper;
	}

	/**
	 * @param stripper the stripper to set
	 */
	public void setStripper(PdfStripper stripper) {
		this.stripper = stripper;
	}
	
	public void writeExcelGoa(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Cargo GOA");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("SerialNo");row.createCell(1).setCellValue("Period");
		row.createCell(2).setCellValue("City");row.createCell(3).setCellValue("NatureOfInvoice");
		row.createCell(4).setCellValue("Invoice Number");row.createCell(5).setCellValue("Flight Date");
		row.createCell(6).setCellValue("Flight Number");row.createCell(7).setCellValue("AWB Number");
		row.createCell(8).setCellValue("Quantity");row.createCell(9).setCellValue("Rate");
		row.createCell(10).setCellValue("Total");
		
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList al=entry.getValue();
			int index=0;
			for(int j=0;j<al.size();j++) {
				if(j==0) {
					row.createCell(j).setCellValue(Integer.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==1) {
					row.createCell(j).setCellValue(excelData.getInvoicePeriod());
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j)));
				}
				else if(j==2) {
					row.createCell(j).setCellValue("GOA");
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j)));
				}
				else if(j==3) {
					row.createCell(j).setCellValue("INBOUND");
					row.createCell(j+4).setCellValue(Long.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==4) {
					row.createCell(j).setCellValue(excelData.getInvoiceNumber());
					row.createCell(j+4).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==5) {
					row.createCell(j+4).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
				}
				
				else if(j==6) {
					row.createCell(j+4).setCellValue(Integer.valueOf(String.valueOf(al.get(j))));
				}
				
			}
		}
		
		try (FileOutputStream outputStream = new FileOutputStream("GOACargo.xlsx")) {
            workbook.write(outputStream);
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
