/**
 * 
 */
package com.awc.engine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.awc.ExcelGenerate;

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
		ExcelGenerate eg=(ExcelGenerate)ctx.getBean("excelWriter");
		eg.writeExcelGoa("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Cargo\\AAICLAS - GOI.pdf", "CargoGoa");
		
		}

}
