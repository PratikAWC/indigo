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
		//eg.writeExcelCargoGoa("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Cargo\\AAICLAS - GOI.pdf", "CargoGOI");
		//eg.writeExcelCargoBBI("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Cargo\\AAICLAS - BBI.pdf", "CargoBBI");
		//eg.writeExcelCargoDelhi("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Cargo\\Celebi-Delhi.pdf", "CargoDEL");
		//eg.writeExcelTemplate4Overfyling("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Commercial I\\Template 4 Overflying.PDF", "Template4Overfyling");
		//eg.writeExcelTemplate5Landing("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Commercial I\\Template 5 Landing.PDF", "Template5Landing");
		eg.writeExcelTemplate2RNFCOverFlying("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Commercial I\\Template 2 RNFC-Overflying.PDF", "Template2RnfcOverflying");
		//eg.Template12RNFCCommercial("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Commercial I\\Template 12 RNFC.pdf", "Template12RNFCCommercial");
		//eg.writeExcelTemplate6Landing("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Commercial I\\Template 6 Landing.pdf", "Template6Landing");
		//eg.writeExcelTemplate7AeroBridge("C:\\Users\\Pratik\\Desktop\\Indigo Data\\Commercial I\\Template 7 Aerobridge.pdf", "Template7AeroBridge");
		
		}

}
