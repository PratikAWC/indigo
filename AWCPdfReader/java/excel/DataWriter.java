/**
 * 
 */
package excel;

import java.io.FileOutputStream;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Pratik
 *
 */
public class DataWriter {

	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private FileOutputStream outputStream;
	/**
	 * 
	 */
	public DataWriter() {
	}

	public void writeExcel(TreeMap<Integer, String[]> map,String path) {
		workbook=new XSSFWorkbook();
		sheet=workbook.createSheet("invoice");
		//System.out.println("======================================================");
		for(int i=0;i<map.size();i++) {
			Row row=sheet.createRow(i);
			String[] arr=map.get(i+1);
			for(int j=0;j<arr.length;j++) {
				Cell cell=row.createCell(j);
				if(j==0 || j==5 || j==10 || j==11 || j==12 ) {
				cell.setCellValue(Integer.parseInt(arr[j]));
				}
				/*else if(j==11) {
					cell.setCellValue(Integer.parseInt(arr[j]));
				}
				else if(j==12) {
					cell.setCellValue(Integer.parseInt(arr[j]));
				}*/
				else
					cell.setCellValue(arr[j]);
			}
		}
		try {
			path=path.substring(0, (path.length()-4));
			path+=".xlsx";
			outputStream = new FileOutputStream(path);
			workbook.write(outputStream);
			workbook.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
