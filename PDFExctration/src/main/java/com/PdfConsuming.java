package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfConsuming {

	private TreeMap<Integer, ArrayList<String>> map;
	private Long[] datax;

	public Map<Integer, ArrayList<String>> getPdf() throws IOException {

		Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		PdfReader pdfReader = new PdfReader("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Cargo\\AAICLAS - GOI.pdf");
		int pages = pdfReader.getNumberOfPages();

		// Iterate the pdf through pages.
		for (int i = 1; i <= pages; i++) {
			// Extract the page content using PdfTextExtractor.
			String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
			if (i == 1) {
				pageContent.contains("GST Invoice ");
				pageContent.contains("GST Invoice ");
				pageContent.contains("GST Invoice ");
			}
			String regex1 = "\\d+\\s\\d{2}\\S\\D{3}\\S\\d{4}\\s[a-zA-Z0-9]*\\s\\d{11}\\s[0-9.]+\\s[0-9.]+\\s\\d+";
			Pattern pattern = Pattern.compile(regex1);
			Matcher matcher1 = pattern.matcher(pageContent);

			while (matcher1.find()) {
				String str = matcher1.group();
				ArrayList<String> st = new ArrayList<String>();
				// st.add(str.split(" "));
				st.addAll(Arrays.asList(str.split(" ")));
				// System.out.println("Before");
				map.put(Integer.parseInt((String) st.get(0)), st);
				// System.out.println("After");
			}
			Set<Entry<Integer, ArrayList<String>>> set = map.entrySet();
			Iterator<Entry<Integer, ArrayList<String>>> itr = set.iterator();
			while (itr.hasNext()) {
				Entry entry = (Map.Entry) itr.next();
				ArrayList<String> str = (ArrayList<String>) entry.getValue();
				for (String x : str) {
					if (x.contains("\n")) {
						x = x.replace("\n", "");
					}
					System.out.print(x + ", ");
				}
				System.out.println();
			}
		}

		return map;
	}
}
