package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelGenerate {
	public void test() throws IOException {
		PdfConsuming cs = new PdfConsuming();

		Map<Integer, String[]> m = cs.getPdf();
		try {
			String filename = "C:\\Users\\Pratik\\Desktop\\Indigo Data\\Cargo\\GOIFile.xls";
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("InvoiceSheet");

			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.createCell(0).setCellValue("S.No.");
			rowhead.createCell(1).setCellValue("Flight date");
			rowhead.createCell(2).setCellValue("flight Number)");
			rowhead.createCell(3).setCellValue("AWB Nmber");
			rowhead.createCell(4).setCellValue("Quantity");
			rowhead.createCell(5).setCellValue("Rate");
			rowhead.createCell(6).setCellValue("TOTAL(RS.)");

			int counter = 1;

			Set<Entry<Integer, String[]>> set=m.entrySet();
			Iterator<Entry<Integer, String[]>> itr=set.iterator();
			int count=1;
			while(itr.hasNext()) {
				HSSFRow row = sheet.createRow(count++);
				Entry<Integer, String[]> entry=itr.next();
				String arr[]=entry.getValue();
				for(int j=0;j<arr.length;j++) {
					if(j==4 || j==5 || j==6) {
						row.createCell(j).setCellValue(Float.parseFloat(arr[j]));
					}
					else {
						row.createCell(j).setCellValue(arr[j]);
					}
				}
			}

			FileOutputStream fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
			System.out.println("Your excel file has been generated!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
