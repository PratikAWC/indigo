/**
 * 
 */
package io;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * @author Pratik
 *
 */
public class XPDFReader {

	private PDDocument document;
	private PDFTextStripper pdfStripper;
	private FileWork fw;
	
	/**
	 * @throws Exception 
	 * 
	 */
	public XPDFReader() throws Exception {
		pdfStripper=new PDFTextStripper();
		fw=new FileWork();
	}
	
	public Long[] readData(String path) throws IOException{
		document=PDDocument.load(new File(path));
		String text=pdfStripper.getText(document);
		document.close();
		return fw.getFileFuntionality(text,path);
	}
}
