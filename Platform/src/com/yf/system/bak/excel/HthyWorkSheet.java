package com.yf.system.bak.excel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author hanmenghui
 * 类功能：对应Excel中sheet。
 *
 */
public class HthyWorkSheet extends HthyExcelBase {
	@SuppressWarnings("unused")
	private HthyWorkSheet() {
	}
	private StringBuffer sheetbody=new StringBuffer(1024);
	public static final String Blod="Blod";
	public static final String CenterBlod="CenterBlod";
	public static  final String EXCEL_BREAK="35break";

	public HthyWorkSheet(String sheetname, int columnCount, int rowCoun) {
		sheetbody.append("<Worksheet ss:Name=\"" + sheetname + "\">\n");
		sheetbody.append("<Table ss:ExpandedColumnCount=\"" + (columnCount)
				+ "\" ss:ExpandedRowCount=\"" + (rowCoun)
				+ "\" x:FullColumns=\"1\" x:FullRows=\"1\">\n");
	}
	public HthyWorkSheet(String sheetname, int columnCount, int rowCoun,Map<Integer,Integer> columns) {
		sheetbody.append("<Worksheet ss:Name=\"" + sheetname + "\">\n");
		sheetbody.append("<Table ss:ExpandedColumnCount=\"" + (columnCount)
				+ "\" ss:ExpandedRowCount=\"" + (rowCoun)
				+ "\" x:FullColumns=\"1\" x:FullRows=\"1\">\n");
		Iterator<Map.Entry<Integer, Integer>> iterator=columns.entrySet().iterator();
		while(iterator.hasNext()){
		Map.Entry<Integer, Integer> entry=iterator.next();
		sheetbody.append(" <Column ss:Index=\""+entry.getKey()+"\" ss:AutoFitWidth=\"0\" ss:Width=\""+entry.getValue()+"\"/>");
		};
	}
	public void sheetOver() {
		sheetbody.append("</Table>\n");
		sheetbody
				.append("<WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">\n");
		sheetbody.append(" <Print>\n");
		sheetbody.append("<ValidPrinterInfo/>\n");
		sheetbody.append("<HorizontalResolution>600</HorizontalResolution>\n");
		sheetbody.append(" <VerticalResolution>0</VerticalResolution>\n");
		sheetbody.append("</Print>\n");
		sheetbody.append("<Selected/>\n");
		sheetbody.append("<Panes>\n");
		sheetbody.append("<Pane>\n");
		sheetbody.append("<Number>3</Number>\n");
		sheetbody.append("<ActiveRow>2</ActiveRow>\n");
		sheetbody.append("</Pane>\n");
		sheetbody.append("</Panes>\n");
		sheetbody.append("<ProtectObjects>False</ProtectObjects>\n");
		sheetbody.append("<ProtectScenarios>False</ProtectScenarios>\n");
		sheetbody.append("</WorksheetOptions>\n");
		sheetbody.append("</Worksheet>\n");
	}
	
	public void createRow() {
		sheetbody.append("<Row>\n");
	}
	public void createRow(String rowstyle) {
		sheetbody.append("<Row ss:StyleID=\""+rowstyle+"\">\n");
	}

	public void rowOver() {
		sheetbody.append("</Row>\n");
	}

	public void addCell(Object label) {
		sheetbody.append("<Cell><Data ss:Type=\"String\">");
		sheetbody.append(converNull(label, " ") );
		sheetbody.append("</Data></Cell>\n");
	}
	public void addCell(Object label,int mergeCells) {
		sheetbody.append("<Cell ss:MergeAcross=\""+(mergeCells+1)+"\" ss:StyleID=\"Default\"><Data ss:Type=\"String\">"
				+ converNull(label, "") + "</Data></Cell>\n");
	}
	public void addCell(Object label,String style) {
		sheetbody.append("<Cell ss:StyleID=\""+style+"\"><Data ss:Type=\"String\">"
				+ converNull(label, "") + "</Data></Cell>\n");
	}
	
	public void createOneRow(Object[]labels){
		createRow();
		for(Object obj:labels){
			addCell(obj);
		}
		rowOver();
	}
	public void createOneRow(List[]labels){
		createRow();
		for(Object obj:labels){
			addCell(obj);
		}
		rowOver();
	}
	public void createOneRow(Object[]labels,String rowstyle){
		createRow(rowstyle);
		for(Object obj:labels){
			if(obj!=null&&obj.toString().length()>0)
			addCell(obj);
		}
		labels=null;
		rowOver();
	}
	public void createOneRow(List labels,String rowstyle){
		createRow(rowstyle);
		for(Object obj:labels){
			addCell(obj);
		}
		labels=null;
		rowOver();
	}
	public void createOneRow(Object label){
		createRow();
		addCell(label);
		rowOver();
	}
	public void createOneRow(Object label,int mergeCells){
		createRow();
		addCell(label,mergeCells);
		rowOver();
	}

	
	public StringBuffer getSheetbody() {
		return sheetbody;
	}

	public void setSheetbody(StringBuffer sheetbody) {
		this.sheetbody = sheetbody;
	}



}
