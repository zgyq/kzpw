package com.yf.system.back.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.yf.system.base.zrate.Zrate;

public class TestImpZrate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//File[] batchfile=new ;
		 File batchfile = new File("C:\\CoreSupplierPolicyImportTemplate.xls");

			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(batchfile);
				Sheet sheet = workbook.getSheet(0);
				for(int i=1;i<sheet.getRows();i++)
				{
					if(sheet.getCell(0, i).getContents().toString().length()>0)
					{
					
						System.out.println(sheet.getCell(0, i).getContents().toString().trim());
						
					
					//zratetemp.setLocalzrate(Float.parseFloat(sheet.getCell(11, i).getContents().toString().trim()));
					//zratetemp.setBegindate(dateToTimestamp(sheet.getCell(13, i).getContents().toString().trim()));
					//zratetemp.setEnddate(dateToTimestamp(sheet.getCell(14, i).getContents().toString().trim()));
					
					}
				}
				
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} /*catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
		

	}

}
