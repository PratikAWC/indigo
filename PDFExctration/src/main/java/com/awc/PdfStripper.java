package com.awc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.awc.dao.ExcelData;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfStripper {
	
	
	private ExcelData excelData;
	private Properties prop;
	private TreeMap<Integer, ArrayList<String>> map;
	private PdfReader pdfReader;
	private String pageContent;
	private Pattern pattern,invNumPat,invPerPat,boundedDataPat;
	private ArrayList<String> regexAl;
	private String invoiceNumber,invoicePeriod;
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
		try {
			pdfReader=new PdfReader(path);
			regexAl.addAll(Arrays.asList(prop.getProperty(type).split(",")));
			pattern = Pattern.compile(regexAl.get(0));
			for(int i=1;i<=pdfReader.getNumberOfPages();i++) {
				pageContent=null;
				// Extract the page content using PdfTextExtractor.
				pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
				//System.out.println(pageContent);
				//If Page is First Page
				if(i==1) {
					//Compiling Patterns
					invNumPat=Pattern.compile(regexAl.get(1));
					invPerPat=Pattern.compile(regexAl.get(2));
					boundedDataPat=Pattern.compile(regexAl.get(3));
					//Matching Patterns
					invNumMat=invNumPat.matcher(pageContent);
					invPerMat=invPerPat.matcher(pageContent);
					boundedDatamat=boundedDataPat.matcher(pageContent);
					
					
					while(invNumMat.find()) {
						excelData.setInvoiceNumber(invNumMat.group());
					}
					
					while(invPerMat.find()) {
						excelData.setInvoicePeriod(invPerMat.group());
					}
					
					while(boundedDatamat.find()) {
						excelData.setNature(boundedDatamat.group());
					}
					
				}
				
				
				Matcher matcher = pattern.matcher(pageContent);
				while(matcher.find()) {
					ArrayList<String> data=new ArrayList<>();
					data.addAll(Arrays.asList(matcher.group().split("\\s|\\n")));
					map.put(Integer.parseInt((String)data.get(0)), data);
					data=null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		excelData.setMap(map);
		//System.out.println("ExcelData :"+excelData);
		return excelData;
	}
}
