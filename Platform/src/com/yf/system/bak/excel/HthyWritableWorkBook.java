package com.yf.system.bak.excel;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hanmenghui
 *
 */
public class HthyWritableWorkBook {
	private HthyWritableWorkBook(){}
	private StringBuffer bookbody=new StringBuffer();
	private List<HthyWorkSheet> sheetlist=new ArrayList<HthyWorkSheet>();
	private PrintWriter printwrite=null;
	public static int SEARCHNUM=0;
	public static HthyWritableWorkBook getInstance(OutputStream out){
		//将当前查询的人数放入Application中		
		return new HthyWritableWorkBook(out);
	}
	private  HthyWritableWorkBook(OutputStream out){
		printwrite=new PrintWriter(new BufferedOutputStream(out));			
		bookbody.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>\n");
		bookbody
				.append("<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"\n");
		bookbody.append(" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n");
		bookbody.append(" xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\n");
		bookbody
				.append(" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"\n");
		bookbody.append(" xmlns:html=\"http://www.w3.org/TR/REC-html40\">\n");
		bookbody
				.append("<DocumentProperties xmlns=\"urn:schemas-microsoft-com:office:office\">\n");
		bookbody.append("<Author>ed woychowsky</Author>\n");
		bookbody.append("<LastAuthor>Edmond Woychowsky</LastAuthor>\n");
		bookbody.append("<Created>2007-01-26T16:54:15Z</Created>\n");
		bookbody.append("<LastSaved>2007-01-27T05:18:54Z</LastSaved>\n");
		bookbody.append("<Company>None</Company>\n");
		bookbody.append("<Version>10.3501</Version>\n");
		bookbody.append("</DocumentProperties>\n");
		bookbody
				.append("<OfficeDocumentSettings xmlns=\"urn:schemas-microsoft-com:office:office\">\n");
		bookbody.append("<DownloadComponents/>\n");
		bookbody.append("<LocationOfComponents HRef=\"file:///D:\"/>\n");
		bookbody.append("</OfficeDocumentSettings>\n");
		bookbody
				.append("<ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">\n");
		bookbody.append("<WindowHeight>8700</WindowHeight>\n");
		bookbody.append("<WindowWidth>11355</WindowWidth>\n");
		bookbody.append("<WindowTopX>480</WindowTopX>\n");
		bookbody.append("<WindowTopY>120</WindowTopY>\n");
		bookbody.append("<ProtectStructure>False</ProtectStructure>\n");
		bookbody.append("<ProtectWindows>False</ProtectWindows>\n");
		bookbody.append("</ExcelWorkbook>\n");
		bookbody.append("<Styles>\n");
		bookbody.append("<Style ss:ID=\"Default\" ss:Name=\"Normal\">\n"); 
		bookbody.append("<Alignment ss:Vertical=\"Bottom\"/>\n");
		bookbody.append("<Borders/>\n");
		bookbody.append("<Font/>\n");
		bookbody.append("<Interior/>\n");
		bookbody.append("<NumberFormat/>\n");
		bookbody.append("<Protection/>\n");
		bookbody.append("</Style>\n");
		bookbody.append("<Style ss:ID=\"Blod\">\n");
		bookbody.append("<Font ss:FontName=\"宋体\" x:CharSet=\"134\" ss:Bold=\"1\"/>\n");
		bookbody.append("</Style>\n");
		bookbody.append("<Style ss:ID=\"CenterBlod\">\n");
		bookbody.append("<Alignment ss:Horizontal=\"Center\" ss:Vertical=\"Bottom\"/>\n");
		bookbody.append("<Font x:Family=\"Swiss\" ss:Bold=\"1\"/>\n");
		bookbody.append("</Style>\n");  
		bookbody.append("<Style ss:ID=\"35break\"><Alignment ss:Vertical=\"Bottom\" ss:WrapText=\"1\"/></Style>");
		bookbody.append("</Styles>\n");
	}
	/**
	 * @param sheetname  sheet名称
	 * @param columnCount 总列数
	 * @param rowCoun 总行数
	 * @return
	 */
	public HthyWorkSheet createHthyWorkSheet(String sheetname, int columnCount, int rowCoun){
		HthyWorkSheet sheet= new HthyWorkSheet(sheetname,columnCount,rowCoun);
		sheetlist.add(sheet);
		return sheet;
		
	}
	
	/**
	 * @param sheetname  sheet名称
	 * @param columnCount 总列数
	 * @param rowCoun 总行数
	 * @param columns
	 * @return
	 */
	public HthyWorkSheet createHthyWorkSheet(String sheetname, int columnCount, int rowCoun,Map<Integer,Integer> columns){
		HthyWorkSheet sheet= new HthyWorkSheet(sheetname,columnCount,rowCoun,columns);
		sheetlist.add(sheet);
		return sheet;
		
	}
	/**
	 * 
	 */
	public void flush(){
		printwrite.flush();
	}
	public void write(){
		for(HthyWorkSheet sheet:sheetlist){
			String excel=sheet.getSheetbody().toString();
			bookbody.append(excel);
			sheet.setSheetbody(new StringBuffer());
		}
		printwrite.write(this.bookbody.toString());
		bookbody=new StringBuffer("");
		
	}
	public void close(){
		bookbody.append("</Workbook>\n");
		printwrite.write(this.bookbody.toString());
		printwrite.close();
		if(SEARCHNUM>0)
		{
			SEARCHNUM=SEARCHNUM-1;
		}
	}
	public static int getSEARCHNUM() {
		return SEARCHNUM;
	}
	public static void setSEARCHNUM(int searchnum) {
		if(searchnum<0){
			searchnum=0;
		}
		SEARCHNUM = searchnum;
	}

}
