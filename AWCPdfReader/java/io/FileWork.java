package io;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;

import excel.DataWriter;



public class FileWork {
	
	private Long rnfc=0L;
	private Long tnlc=0L;
	private Long total=0L;
	private DataWriter dw;
	private Long[] datax;
    private TreeMap<Integer, String[]> map;
    public FileWork() {
    	dw=new DataWriter();
    	map=new TreeMap<Integer,String[]>();
    	datax=new Long[3];
	}
    
    public Long[] getFileFuntionality(String data,String path) {
        try{
        	//Condition 1 completed
    		String regex1="\\d+\\s\\d{2}\\S\\D{3}\\S\\d{4}\\s[a-zA-Z0-9]*\\s[a-zA-Z0-9-]+ \\w+\\s\\d+\\s\\w+\\s\\w+\\s[0-9-]*\\s[0-9-]*\\s\\d+\\s\\d+\\s\\d+";
    		//Condition 2 complete
    		String regex2="\\d+\\s\\d{2}\\S\\D{3}\\S\\d{4}\\s[a-zA-Z0-9]*\\s[A-Za-z0-9-]+\\s{2}[A-Za-z0-9-]*\\s\\s\\w+\\s\\d+\\s\\w+\\s\\w+\\s[0-9-]*\\s[0-9-]*\\s\\d+\\s\\d+\\s\\d+";
    		//Condition 3 complete
    		String regex3="\\d+\\s\\d{2}\\S\\D{3}\\S\\d{4}\\s[a-zA-Z0-9]*\\s[A-Za-z0-9-]+\\s{2}[A-Za-z0-9-]+\\s{2}[A-Za-z0-9-]+\\s\\s\\w+\\s\\d+\\s\\w+\\s\\w+\\s[0-9-]*\\s[0-9-]*\\s\\d+\\s\\d+\\s\\d+";
    		//String regex3="\\d+\\s\\d{2}\\S\\D{3}\\S\\d{4}\\s[a-zA-Z0-9]*\\s[A-Za-z0-9-]+\\s{2}[A-Za-z0-9-]+\\s{2}[A-Za-z0-9-]*\\s\\s\\w+\\s\\d+\\s\\w+\\s\\w+\\s[0-9-]*\\s[0-9-]*\\s\\d+\\s\\d+\\s\\d+";
    		
    		//Pattern 1
    		Pattern pattern1=Pattern.compile(regex1);
    		Matcher matcher1=pattern1.matcher(data);
    		//Pattern 2
    		Pattern pattern2=Pattern.compile(regex2);
    		Matcher matcher2=pattern2.matcher(data);
    		//Pattern 3
    		Pattern pattern3=Pattern.compile(regex3);
    		Matcher matcher3=pattern3.matcher(data);
    		
    		/*Pattern cgstp=Pattern.compile("CGST @ 9 %\\s+[.0-9]+\\s+[.0-9]+\\s+[.0-9]+");
    		Matcher cgstm=cgstp.matcher(data);
    		
    		Pattern ugstp=Pattern.compile("UGST @ 9 %\\s+[.0-9]+\\s+[.0-9]+\\s+[.0-9]+");
    		Matcher ugstm=ugstp.matcher(data);
    		
    		Pattern tgstp=Pattern.compile("Total GST @ 18.0%\\s+[.0-9]+\\s+[.0-9]+\\s+[.0-9]+");
    		Matcher tgstm=tgstp.matcher(data);*/
    		
    		rnfc=0L;tnlc=0L;total=0L;
    		
    		//adding data to treemap
    		while(matcher3.find()) {
    			
    			String str=matcher3.group();
    			str=str.replaceAll("\\s{2}", " ");
    			String arr[]=str.split(" ");
    			arr[3]=arr[3]+arr[4]+arr[5];
    			arr=(String[]) ArrayUtils.remove(arr, 4);
    			arr=(String[]) ArrayUtils.remove(arr, 4);
    			map.put(Integer.parseInt(arr[0]), arr);
    		}
    		
    		while(matcher2.find()) {
    			String str=matcher2.group();
    			str=str.replaceAll("\\s{2}", " ");
    			String arr[]=str.split(" ");
    			arr[3]=arr[3]+arr[4];
    			arr[4]="";
    			arr=(String[]) ArrayUtils.remove(arr, 4);
    			map.put(Integer.parseInt(arr[0]), arr);
    		}
    		while(matcher1.find()) {
    			String arr[]=matcher1.group().split(" ");
    			map.put(Integer.parseInt(arr[0]), arr);
    		}
    		Set<Entry<Integer, String[]>> set=map.entrySet();
    		Iterator<Entry<Integer,String[]>> itr=set.iterator();
    		while(itr.hasNext()) {
    			Map.Entry<Integer,String[]> entry=itr.next();
    			
    			rnfc+=Long.parseLong(entry.getValue()[(entry.getValue().length-3)]);
    			tnlc+=Long.parseLong(entry.getValue()[(entry.getValue().length-2)]);
    			total+=Long.parseLong(entry.getValue()[(entry.getValue().length-1)]);
    		
    		}
    		  
    		    dw.writeExcel(map,path);

        		System.out.println("RNFC :"+rnfc);
        		System.out.println("TNLC :"+tnlc);
        		System.out.println("TOTAL :"+total);
        		
                datax[0]=rnfc;datax[1]=tnlc;datax[2]=total;
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return datax;
    }
    
    
}
