/**
 * 
 */
package com.awc.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.awc.PdfStripper;

/**
 * @author Pratik
 *
 */
public class DriverClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		PdfStripper stripper=(PdfStripper)ctx.getBean("stripper");
		Map<Integer,ArrayList<String>> myMap=stripper.readPdf("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Cargo\\AAICLAS - GOI.pdf", "CargoGoa");
		/*Set<Entry<Integer, ArrayList<String>>> set=myMap.entrySet();
		Iterator<Entry<Integer, ArrayList<String>>> itr=set.iterator();
		while(itr.hasNext()) {
			Entry entry = (Map.Entry) itr.next();
			ArrayList<String> str = (ArrayList<String>) entry.getValue();
			for (String x : str) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}*/
	}

}
