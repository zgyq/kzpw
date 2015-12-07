package com.yf.system.back.servlet;


import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.service.IAirService;
import com.yf.system.base.service.IMemberService;
import com.yf.system.base.service.ISystemService;




public class testDAOCHU {

    /**
     * @param args
     * @throws IOException 
     * @throws WriteException 
     * @throws RowsExceededException 
     */
    public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
    	
    
    	String url="http://b.100ticket.com:8080/service/service/";
    	
    	HessianProxyFactory factory = new HessianProxyFactory();
    	IMemberService basicww = (IMemberService) factory.create(IMemberService.class, url+"IMemberService");
    	ISystemService systemService=(ISystemService) factory.create(ISystemService.class, url+"ISystemService");
    	IAirService airService=(IAirService) factory.create(IAirService.class, url+"IAirService");
    	
    	
    	List<Customeragent>list=basicww.findAllCustomeragent(" WHERE 1=1 AND "+Customeragent.COL_id+" >6 AND "+Customeragent.COL_agenttype+" =3", " ORDER BY ID ", -1, 0);
    	
    	File xlsfile = new File("D:\\cc\\test.xls ");
    	WritableWorkbook book = Workbook.createWorkbook(xlsfile);
    	WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 );
    	Label label1  =   new  Label( 0 ,  0 ,  "代理代码" );
    	Label label2  =   new  Label( 1 ,  0 ,  "代理名称" );
    	Label label3  =   new  Label( 2 ,  0 ,  "代理简称" );
    	Label label4  =   new  Label( 3 ,  0 ,  "所属代理" );
    	Label label5  =   new  Label( 4 ,  0 ,  "联系人" );
    	Label label6  =   new  Label( 5 ,  0 ,  "联系电话" );
    	Label label7  =   new  Label( 6 ,  0 ,  "开户日期" );
    	Label label8  =   new  Label( 7 ,  0 ,  "帐号" );
    	
    	sheet.addCell(label1);
    	sheet.addCell(label2);
    	sheet.addCell(label3);
    	sheet.addCell(label4);
    	sheet.addCell(label5);
    	sheet.addCell(label6);
    	sheet.addCell(label7);
    	sheet.addCell(label8);
    	
		
    	for(int a=0;a<list.size();a++){
    		String code="";
    		String name="";
    		String jiancheng="";
    		String suoshu="";
    		String lianxiren="";
    		String tel="";
    		String time="";
    		String user="";
    		code=list.get(a).getCode();
    		name=list.get(a).getAgentcompanyname();
    		jiancheng=list.get(a).getAgentshortname();
    		suoshu=basicww.findCustomeragent(list.get(a).getParentid()).getAgentcompanyname();
    		lianxiren=list.get(a).getAgentcontactname();
    		tel=list.get(a).getAgentphone();
    		time=list.get(a).getCreatetime().toString();
    		
    		List<Customeruser>listuser=basicww.findAllCustomeruser(" WHERE 1=1 AND "+Customeruser.COL_agentid+" ="+list.get(a).getId(), " ORDER BY ID ", -1, 0);
    		user="";
    		if(listuser.size()>0){
    			for(int u=0;u<listuser.size();u++){
    				user+=listuser.get(u).getLoginname()+"\r\n";
    			}
    		}
    		System.out.println(list.get(a).getAgentcompanyname()+","+list.get(a).getCreatetime().toString());
    		
    		
    		
    		int aa=a+1;
    	
        	Label label11  =   new  Label( 0 ,  aa ,  code );
        	Label label22  =   new  Label( 1 ,  aa ,  name );
        	Label label33  =   new  Label( 2 ,  aa ,  jiancheng );
        	Label label44  =   new  Label( 3 ,  aa ,  suoshu );
        	Label label55  =   new  Label( 4 ,  aa ,  lianxiren );
        	Label label66  =   new  Label( 5 ,  aa ,  tel );
        	Label label77  =   new  Label( 6 ,  aa ,  time );
        	Label label88  =   new  Label( 7 ,  aa ,  user );
        	
        	sheet.addCell(label11);
        	sheet.addCell(label22);
        	sheet.addCell(label33);
        	sheet.addCell(label44);
        	sheet.addCell(label55);
        	sheet.addCell(label66);
        	sheet.addCell(label77);
        	sheet.addCell(label88);
    		
    	}
    	System.out.println("OK");
    	book.write();
    	book.close();//完成xls生成
	}

}   
    
	

