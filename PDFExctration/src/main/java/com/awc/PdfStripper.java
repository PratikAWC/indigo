package com.awc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.awc.dao.ExcelData;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfStripper {
	
	private int index=0;
	private ExcelData excelData;
	private Properties prop;
	private TreeMap<Integer, ArrayList<String>> map;
	private PdfReader pdfReader;
	private String pageContent;
	private Pattern pattern,invNumPat,invPerPat,boundedDataPat;
	private ArrayList<String> regexAl;
	private Matcher invNumMat,invPerMat,boundedDatamat;
	/**
	 * @return the regexAl
	 */
	public ArrayList<String> getRegexAl() {
		return regexAl;
	}

	/**
	 * @param regexAl the regexAl to set
	 */
	public void setRegexAl(ArrayList<String> regexAl) {
		this.regexAl = regexAl;
	}

	/**
	 * @return the prop
	 */
	public Properties getProp() {
		return prop;
	}
	
	/**
	 * @param prop the prop to set
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	/**
	 * @return the map
	 */
	public TreeMap<Integer, ArrayList<String>> getMap() {
		return map;
	}
	
	/**
	 * @param map the map to set
	 */
	public void setMap(TreeMap<Integer, ArrayList<String>> map) {
		this.map = map;
	}
	
	/**
	 * @return the excelData
	 */
	public ExcelData getExcelData() {
		return excelData;
	}

	/**
	 * @param excelData the excelData to set
	 */
	public void setExcelData(ExcelData excelData) {
		this.excelData = excelData;
	}

	public ExcelData readPdf(String path,String type){
		int index=0;
		try {
			pdfReader=new PdfReader(path);
			regexAl.addAll(Arrays.asList(prop.getProperty(type).split(",")));
				try {
					pattern = Pattern.compile(regexAl.get(index++));
				} catch (PatternSyntaxException e) {
					pattern = Pattern.compile(regexAl.get(index-1)+","+regexAl.get(index));
					index++;
				}
			for(int i=1;i<=pdfReader.getNumberOfPages();i++) {
				pageContent=null;
				// Extract the page content using PdfTextExtractor.
				pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
				System.out.println(pageContent);
				//If Page is First Page
				if(i==1) {
					
					try {
						invNumPat=Pattern.compile(regexAl.get(index++));
						invNumMat=invNumPat.matcher(pageContent);
						while(invNumMat.find()) {
							excelData.setInvoiceNumber(invNumMat.group());
						}
					}
					catch(Exception e) {
						excelData.setInvoiceNumber("");
					}
					
					try {
						invPerPat=Pattern.compile(regexAl.get(index++));
						invPerMat=invPerPat.matcher(pageContent);
						while(invPerMat.find()) {
							excelData.setInvoicePeriod(invPerMat.group());
						}
					}
					catch(Exception e) {
						excelData.setInvoicePeriod("");
					}
					try {
						boundedDataPat=Pattern.compile(regexAl.get(index++));
						boundedDatamat=boundedDataPat.matcher(pageContent);
						while(boundedDatamat.find()) {
							excelData.setNature(boundedDatamat.group());
						}
					}
					catch(Exception e) {
						excelData.setNature("");
					}
				}
				
				
				Matcher matcher = pattern.matcher(pageContent);
				while(matcher.find()) {
					ArrayList<String> data=new ArrayList<>();
					data.addAll(Arrays.asList(matcher.group().split("\\s|\\n")));
					try {
					map.put(Integer.parseInt((String)data.get(0)), data);
					}
					catch(NumberFormatException e) {
						map.put(++index, data);
					}
					data=null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		excelData.setMap(map);
		//System.out.println("ExcelData :"+excelData.getMap().size());
		return excelData;
	}
	
}
