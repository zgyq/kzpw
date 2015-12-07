package com.yf.system.back.server;

public class ExcelReportServer {
	private String getBookTop(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		buffer
				.append("<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"");
		buffer.append(" xmlns:o=\"urn:schemas-microsoft-com:office:office\"");
		buffer.append(" xmlns:x=\"urn:schemas-microsoft-com:office:excel\"");
		buffer
				.append(" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"");
		buffer.append(" xmlns:html=\"http://www.w3.org/TR/REC-html40\">");
		buffer
				.append("<DocumentProperties xmlns=\"urn:schemas-microsoft-com:office:office\">");
		buffer.append("<Author>ed woychowsky</Author>");
		buffer.append("<LastAuthor>Edmond Woychowsky</LastAuthor>");
		buffer.append("<Created>2007-01-26T16:54:15Z</Created>");
		buffer.append("<LastSaved>2007-01-27T05:18:54Z</LastSaved>");
		buffer.append("<Company>None</Company>");
		buffer.append("<Version>10.3501</Version>");
		buffer.append("</DocumentProperties>");
		buffer.append("<OfficeDocumentSettings xmlns=\"urn:schemas-microsoft-com:office:office\">");
		buffer.append("<DownloadComponents/>");
		buffer.append("<LocationOfComponents HRef=\"file:///D:\"/>");
		buffer.append("</OfficeDocumentSettings>");
		buffer
				.append("<ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">");
		buffer.append("<WindowHeight>8700</WindowHeight>");
		buffer.append("<WindowWidth>11355</WindowWidth>");
		buffer.append("<WindowTopX>480</WindowTopX>");
		buffer.append("<WindowTopY>120</WindowTopY>");
		buffer.append("<ProtectStructure>False</ProtectStructure>");
		buffer.append("<ProtectWindows>False</ProtectWindows>");
		buffer.append("</ExcelWorkbook>");
		buffer.append("<Styles>");
		buffer.append("<Style ss:ID=\"Default\" ss:Name=\"Normal\">");
		buffer.append("<Alignment ss:Vertical=\"Bottom\"/>");
		buffer.append("<Borders/>");
		buffer.append("<Font/>");
		buffer.append("<Interior/>");
		buffer.append("<NumberFormat/>");
		buffer.append("<Protection/>");
		buffer.append("</Style>");
		buffer.append("</Styles>");
		return buffer.toString();
	}

}
