package com.awc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
	//private Map<Integer, ArrayList<String>> map;
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
	
	public void writeExcelCargoGoa(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Cargo GOA");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("SerialNo");row.createCell(1).setCellValue("Invoice Period");
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
			ArrayList<String> al=entry.getValue();
			//int index=0;
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
					row.createCell(j).setCellValue(excelData.getNature());
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
            workbook.write(outputStream);workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeExcelCargoBBI(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Cargo BBI");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("SerialNo");row.createCell(1).setCellValue("Invoice Period");
		row.createCell(2).setCellValue("City Name");row.createCell(3).setCellValue("NatureOfInvoice");
		row.createCell(4).setCellValue("Gst Invoice Number");row.createCell(5).setCellValue("Flight Date");
		row.createCell(6).setCellValue("Flight Number");row.createCell(7).setCellValue("AWB Number");
		row.createCell(8).setCellValue("Quantity");row.createCell(9).setCellValue("Rate");
		row.createCell(10).setCellValue("Total");		
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList<String> al=entry.getValue();
			//int index=0;
			for(int j=0;j<al.size();j++) {
				if(j==0) {
					row.createCell(j).setCellValue(Integer.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==1) {
					row.createCell(j).setCellValue(excelData.getInvoicePeriod());
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j)));
				}
				else if(j==2) {
					row.createCell(j).setCellValue("Bhubaneswar");
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j)));
				}
				else if(j==3) {
					row.createCell(j).setCellValue(excelData.getNature());
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
					row.createCell(j+4).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
				}
				
			}
		}
		try (FileOutputStream outputStream = new FileOutputStream("BBICargo.xlsx")) {
            workbook.write(outputStream);workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeExcelCargoDelhi(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Cargo DEL");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("SerialNo");row.createCell(1).setCellValue("Invoice Period");
		row.createCell(2).setCellValue("City");row.createCell(3).setCellValue("NatureOfInvoice");
		row.createCell(4).setCellValue("Invoice Number");row.createCell(5).setCellValue("AWB Number");
		row.createCell(6).setCellValue("Flight Number");row.createCell(7).setCellValue("Flight Date");
		row.createCell(8).setCellValue("Pkgs");row.createCell(9).setCellValue("Weight");
		row.createCell(10).setCellValue("Amount");
		
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList<String> al=entry.getValue();
			//int index=0;
			for(int j=0;j<al.size();j++) {
				if(j==0) {
					row.createCell(j).setCellValue(Integer.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==1) {
					String data=null;
					data=excelData.getInvoicePeriod();
					if(data.contains("From")||data.contains("from")) {
						data=data.substring(4, data.length());
					}
					row.createCell(j).setCellValue(data);
					row.createCell(j+4).setCellValue(Long.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==2) {
					row.createCell(j).setCellValue("DEL");
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j)));
				}
				else if(j==3) {
					row.createCell(j).setCellValue(excelData.getNature());
					row.createCell(j+4).setCellValue(String.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==4) {
					row.createCell(j).setCellValue(excelData.getInvoiceNumber());
					row.createCell(j+4).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==5) {
					row.createCell(j+4).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
				}
				
				else if(j==6) {
					row.createCell(j+4).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
				}
				
			}
		}
		
		try (FileOutputStream outputStream = new FileOutputStream("DELCargo.xlsx")) {
            workbook.write(outputStream);workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void writeExcelTemplate2RNFCOverFlying(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("UAE Commercial");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("Invoice Date");row.createCell(1).setCellValue("Country");
		row.createCell(2).setCellValue("Date");row.createCell(3).setCellValue("Line No");
		row.createCell(4).setCellValue("CallSign");row.createCell(5).setCellValue("Info");
		row.createCell(6).setCellValue("Type");row.createCell(7).setCellValue("From");
		row.createCell(8).setCellValue("To");row.createCell(9).setCellValue("Weight");
		row.createCell(10).setCellValue("Invoice");row.createCell(11).setCellValue("Charge");
		row.createCell(12).setCellValue("Vat %");row.createCell(13).setCellValue("Vat Amount");
		row.createCell(14).setCellValue("Total");
		
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList<String> al=entry.getValue();
			//int index=0;
			String str=null;
			str=al.get(10)+" "+al.get(11);
			al.remove(10);al.remove(10);
			al.add(10,str);
			for(int j=0;j<al.size();j++) {
				if(j==0) {
					row.createCell(0).setCellValue(excelData.getInvoiceNumber());
					row.createCell(j+2).setCellValue(String.valueOf(al.get(j)));
				}
				else if(j==1){
					row.createCell(1).setCellValue("UAE");
					row.createCell(j+2).setCellValue(String.valueOf(al.get(j)));
				}
				else {
					row.createCell(j+2).setCellValue(String.valueOf(al.get(j)));
				}
			}
		}
		
		try (FileOutputStream outputStream = new FileOutputStream("UAECommercial.xlsx")) {
            workbook.write(outputStream);workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void Template12RNFCCommercial(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Singpore");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("Invoice No");row.createCell(1).setCellValue("Invoice Date");
		row.createCell(2).setCellValue("Country Name");row.createCell(3).setCellValue("FLIGHT");
		row.createCell(4).setCellValue("TYPE");row.createCell(5).setCellValue("Flight In Date");
		row.createCell(6).setCellValue("Flight In Time");row.createCell(7).setCellValue("Flight Out Date");
		row.createCell(8).setCellValue("Flight Out Time");row.createCell(9).setCellValue("From");
		row.createCell(10).setCellValue("To");row.createCell(11).setCellValue("Sector");
		row.createCell(12).setCellValue("Rate USD");row.createCell(13).setCellValue("Route Units");
		row.createCell(14).setCellValue("Amount USD");
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList<String> al=entry.getValue();
			//int index=0;
			for(int j=0;j<al.size();j++) {
					if(j==0) {
						String invNum=null;
						invNum=excelData.getInvoiceNumber();
						if(invNum.contains("No. : ") || invNum.contains("NO. : "))
							invNum=invNum.substring(invNum.lastIndexOf(" ")+1, invNum.length());
						row.createCell(j).setCellValue(Integer.valueOf(String.valueOf(invNum)));
						row.createCell(j+3).setCellValue(String.valueOf(al.get(j)));
					}
					else if(j==1) {
						row.createCell(j).setCellValue(excelData.getInvoicePeriod());
						row.createCell(j+3).setCellValue(String.valueOf(al.get(j)));
					}
					else if(j==2) {
						row.createCell(j).setCellValue("Singapore");
						row.createCell(j+3).setCellValue(String.valueOf(al.get(j)));
					}
					else if(j==3){
						row.createCell(j+3).setCellValue(String.valueOf(al.get(j)));
					}
					else if(j==10||j==11||j==12) {
						row.createCell(j+2).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
					}
					else {
						row.createCell(j+2).setCellValue(String.valueOf(al.get(j)));
					}
			}
		}
		try (FileOutputStream outputStream = new FileOutputStream("SingporeCommercial.xlsx")) {
            workbook.write(outputStream);workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void writeExcelTemplate4Overfyling(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Bangladesh");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("S. No");row.createCell(1).setCellValue("Invoice Number");
		row.createCell(2).setCellValue("Invoice Period");row.createCell(3).setCellValue("Invoice Date");
		row.createCell(4).setCellValue("Country");
		row.createCell(5).setCellValue("Entry No");row.createCell(6).setCellValue("Arr/Entry FIR");
		row.createCell(7).setCellValue("Dept/Exit");row.createCell(8).setCellValue("Regn No.");
		row.createCell(9).setCellValue("FlightNo");row.createCell(10).setCellValue("Type");
		row.createCell(11).setCellValue("All-Up Weight");row.createCell(12).setCellValue("Landing Charges");
		row.createCell(13).setCellValue("Night Landing Charges");row.createCell(14).setCellValue("Night Take-Off Charges");
		row.createCell(15).setCellValue("Route Navigation Charges");row.createCell(16).setCellValue("Parking Charges");
		row.createCell(17).setCellValue("Hanger/Housing Charges");row.createCell(18).setCellValue("Security Charges");
		row.createCell(19).setCellValue("Boarding Charges");row.createCell(20).setCellValue("Total Charges");
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList<String> al=entry.getValue();
			Collections.swap(al, 8, 11);
			Collections.swap(al, 12, 16);
			////int index=0;
			for(int j=0;j<al.size();j++) {
				if(j==0) {
					row.createCell(j).setCellValue(Integer.valueOf(String.valueOf(al.get(j))));
				}
				if(j==1) {
					row.createCell(j).setCellValue(excelData.getInvoiceNumber());
					row.createCell(j+4).setCellValue(Integer.valueOf(String.valueOf(al.get(j))));
				}
				else if(j==2) {
					String data=null;
					data=excelData.getInvoicePeriod();
					if(data.contains("From ")) {
						data=data.substring(data.indexOf(" ")+1, data.length());
					}
					row.createCell(j).setCellValue(data);
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j))+" "+String.valueOf(al.get(17)));
					al.remove(17);
				}
				else if(j==3) {
					String data=null;
					data=excelData.getNature();
					if(data.contains("Submission Date : ")) {
						data=data.substring(data.indexOf(":")+1, data.length());
					}
					row.createCell(j).setCellValue(data);
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j))+" "+String.valueOf(al.get(17)));
					al.remove(17);
				}
				else if(j==4){
					row.createCell(j).setCellValue("Bangladesh");
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j)));
				}
				else if(j==7||j==8||j==9||j==10||j==11|j==12||j==13||j==14||j==15||j==16){
					row.createCell(j+4).setCellValue(Float.valueOf(String.valueOf(al.get(j))));
				}
				else {
					row.createCell(j+4).setCellValue(String.valueOf(al.get(j)));
				}
			}
		}
		try (FileOutputStream outputStream = new FileOutputStream("Template4OverFlying.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void writeExcelTemplate5Landing(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Bangladesh");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("S. No");row.createCell(1).setCellValue("Invoice Number");
		row.createCell(2).setCellValue("Invoice Period");row.createCell(3).setCellValue("Invoice Date");
		row.createCell(4).setCellValue("Country");
		row.createCell(5).setCellValue("Entry No");row.createCell(6).setCellValue("Arr/Entry FIR");
		row.createCell(7).setCellValue("Dept/Exit");row.createCell(8).setCellValue("Doc-In Time");
		row.createCell(9).setCellValue("Doc-Out Time");
		row.createCell(10).setCellValue("Regn No.");
		row.createCell(11).setCellValue("FlightNo");row.createCell(12).setCellValue("Type");
		row.createCell(13).setCellValue("All-Up Weight");row.createCell(14).setCellValue("Landing Charges");
		row.createCell(15).setCellValue("Night Landing Charges");row.createCell(16).setCellValue("Night Take-Off Charges");
		row.createCell(17).setCellValue("Route Navigation Charges");row.createCell(18).setCellValue("Parking Charges");
		row.createCell(19).setCellValue("Hanger/Housing Charges");row.createCell(20).setCellValue("Security Charges");
		row.createCell(21).setCellValue("Boarding Charges");row.createCell(22).setCellValue("Total Charges");
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList<String> al=entry.getValue();
			
			String data1=al.get(2)+" "+al.get(19);
			String data2=al.get(3)+" "+al.get(20);
			
			
			al.remove(19);al.remove(19);
			al.remove(2);
			al.remove(2);
			
			al.add(2, data1);
			al.add(3,data2);
			
			String data3=al.get(7)+al.get(19);
			al.remove(19);
			al.remove(7);
			al.add(7,data3);
			
			String data4=al.get(10);
			al.remove(10);
			al.add(data4);
			
			for(int j=0;j<al.size();j++) {
				if(j==0) {
					row.createCell(j).setCellValue(Integer.valueOf(al.get(j)));
				}
				else if(j==1) {
					row.createCell(j).setCellValue(excelData.getInvoiceNumber());
					row.createCell(j+4).setCellValue(Integer.valueOf(al.get(j)));
				}
				else if(j==2) {
					String data=null;
					if(excelData.getInvoicePeriod().contains("From ")) {
						data=excelData.getInvoicePeriod().substring(5, excelData.getInvoicePeriod().length());
					}
					row.createCell(j).setCellValue(data);
					row.createCell(j+4).setCellValue(al.get(j));
				}
				else if(j==3) {
					String data=null;
					if(excelData.getNature().contains("Submission Date : ")) {
						data=excelData.getNature().substring(18, excelData.getNature().length());
					}
					row.createCell(j).setCellValue(data);
					row.createCell(j+4).setCellValue(al.get(j));
				}
				else if(j==4){
					row.createCell(j).setCellValue("Bangladesh");
					row.createCell(j+4).setCellValue(al.get(j));
				}
				else {
					row.createCell(j+4).setCellValue(al.get(j));
				}
			}
		}
		try (FileOutputStream outputStream = new FileOutputStream("Template5Landing.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeExcelTemplate6Landing(String path,String type) {
		int i=0;
		ArrayList<String> temp=new ArrayList<String>();
		temp.add("");
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Template6Landing");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("Invoice No");row.createCell(1).setCellValue("Invoice Period");
		row.createCell(2).setCellValue("Invoice Date");row.createCell(3).setCellValue("City");
		row.createCell(4).setCellValue("Sales Doc No.");row.createCell(5).setCellValue("Registration Mark");
		row.createCell(6).setCellValue("Type of Aircraft");row.createCell(7).setCellValue("Take Off Weight");
		row.createCell(8).setCellValue("Flight Number");row.createCell(9).setCellValue("Arrival Date");
		row.createCell(10).setCellValue("Departure Date");row.createCell(11).setCellValue("Parking Days");
		row.createCell(12).setCellValue("Arrival Time");row.createCell(13).setCellValue("Departure Time");
		row.createCell(14).setCellValue("Free Time");row.createCell(15).setCellValue("Landing Fees");
		row.createCell(16).setCellValue("Parking Fees");
		
		TreeMap<Integer, ArrayList<String>> map=excelData.getMap();
		Set<Entry<Integer,ArrayList<String>>> set= map.entrySet();
		Iterator<Entry<Integer,ArrayList<String>>> itr=set.iterator();
		
		while(itr.hasNext()) {
			row=sheet.createRow(i++);
			Entry<Integer,ArrayList<String>> entry = itr.next();
			ArrayList<String> al=entry.getValue();
			//int index=0;
			al.removeAll(temp);
			String data=al.get(4)+" "+al.get(5);
			al.remove(4);al.remove(4);
			al.add(4, data);
			
			data=al.get(10)+" "+al.get(11);
			al.remove(10);al.remove(10);
			al.add(10,data);
			
			for(int j=0;j<al.size();j++) {
				if(j==0) {
					row.createCell(j).setCellValue(excelData.getInvoiceNumber());
					row.createCell(j+4).setCellValue(al.get(j));
				}
				else if(j==1) {
					String str=null;
					if(excelData.getInvoicePeriod().contains("From ")) {
						str=excelData.getInvoicePeriod().substring(5, excelData.getInvoicePeriod().length());
					}
					row.createCell(j).setCellValue(str);
					row.createCell(j+4).setCellValue(al.get(j));
				}
				else if(j==2) {
					String str=null;
					if(excelData.getNature().contains("Time: ")) {
						str=excelData.getNature().substring(6, excelData.getNature().length());
					}
					row.createCell(j).setCellValue(str);
					row.createCell(j+4).setCellValue(al.get(j));
				}
				else if(j==3) {
					row.createCell(j).setCellValue("Bangkok");
					row.createCell(j+4).setCellValue(al.get(j));
				}
				else {
					row.createCell(j+4).setCellValue(al.get(j));
				}
			}
		}
		
		try (FileOutputStream outputStream = new FileOutputStream("Template6Landing.xlsx")) {
            workbook.write(outputStream);workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeExcelTemplate7AeroBridge(String path,String type) {
		int i=0;
		excelData=stripper.readPdf(path, type);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Template7AeroBridge");
		Row row=sheet.createRow(i++);
		row.createCell(0).setCellValue("SerialNo");row.createCell(1).setCellValue("Invoice Period");
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
			ArrayList<String> al=entry.getValue();
			//int index=0;
			ArrayList<String> temp=new ArrayList<String>();
			temp.add("");
			al.removeAll(temp);
			for(int j=0;j<al.size();j++) {
				
					row.createCell(j).setCellValue(String.valueOf(al.get(j)));
					
			}
		}
		
		try (FileOutputStream outputStream = new FileOutputStream("Template7AeroBridge.xlsx")) {
            workbook.write(outputStream);workbook.close();
        }
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
