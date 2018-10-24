package com.awc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfStripper {
	
	private Properties prop;
	private TreeMap<Integer, ArrayList<String>> map;
	private Long[] datax;
	private PdfReader pdfReader;
	private String pageContent;
	private Pattern pattern;
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
	
	public Map<Integer, ArrayList<String>> readPdf(String path,String type){
		try {
			pdfReader=new PdfReader(path);
			pattern = Pattern.compile(prop.getProperty(type));
			for(int i=1;i<pdfReader.getNumberOfPages();i++) {
				pageContent=null;
				// Extract the page content using PdfTextExtractor.
				pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
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
		return map;
	}
}
