package com.yf.system.back.policy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;

import com.caucho.hessian.client.HessianProxyFactory;
import com.yf.system.atom.interticket.HttpClient;
import com.yf.system.back.server.Server;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.liudianrefinfo.Liudianrefinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.sellreport.Sellreport;
import com.yf.system.base.service.IMemberService;
import com.yf.system.base.service.ISystemService;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.util.Util;

/**
 * 支付通知
 * 
 * @author 小陈
 * 
 */
public class ReturnPayURL extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(ReturnPayURL.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
		FileInputStream fileInputStream = new FileInputStream("C://user.xls");
		Workbook hotelbook = Workbook.getWorkbook(fileInputStream);
		
		Sheet sheetHotel = hotelbook.getSheet(0);
		Sellreport sellreport2 = new Sellreport();
		
		List<Sellreport> listuser = new ArrayList<Sellreport>();
		/*Server.getInstance().setUrl("http://183.60.161.17:8800/service/service/");
		
		String url = "http://183.60.161.17:8800/service/service/";*/
     /*	
    	HessianProxyFactory factory = new HessianProxyFactory();
     	
 			IMemberService servier = (IMemberService) factory.create(IMemberService.class, url + IMemberService.class.getSimpleName()) ;
 		*/	
 			StringBuilder bussinesssql=new StringBuilder("");
		
 			int  aaa=sheetHotel.getRows();
 			
		for(int d=1;d<=aaa;d++){
			Cell angname = sheetHotel.getCell(0, d);
			Cell loginname = sheetHotel.getCell(1, d);
			System.out.println("angname:"+angname.getContents()+",loginname:"+loginname.getContents());
			
			Customeragent customeragent = new Customeragent();
			Customeruser user = new Customeruser();
			
			String arentstr="46,1";
			customeragent.setParentstr(arentstr);
			customeragent.setParentid(46l);
			customeragent.setCreateuser("admin");
			customeragent.setUserid(46l);
			customeragent.setAgentcompanyname(angname.getContents().trim());
			customeragent.setAgentshortname(angname.getContents().trim());
			customeragent.setAgenttype(3);
			customeragent.setType(1);
			
			customeragent.setCreatetime(new Timestamp(System.currentTimeMillis()));
			customeragent.setModifytime(new Timestamp(System.currentTimeMillis()));
			customeragent.setVmoney(0f);
			customeragent.setAgentcheckstatus(1);
			customeragent.setAgentisenable(1);
			customeragent.setAgentjibie(0);
			
			
			
			customeragent.setAllowlevelcount(0);// 表示不限
			customeragent.setAllowproxycount(0);// 表示不限
			customeragent.setVmoney(0.0f);
			customeragent=Server.getInstance().getMemberService().createCustomeragent(customeragent);
			//员工
			user.setLoginname(loginname.getContents().trim());
			user.setLogpassword(Util.MD5("zgwmyqf"));//adminis
			user.setAgentid(customeragent.getId());
			user.setCreatetime(new Timestamp(System.currentTimeMillis()));
			user.setModifytime(new Timestamp(System.currentTimeMillis()));
			user.setIsadmin(1);
			user.setIsenable(1);// 是否启用。
			user.setMembertype(-1);// 用于区分默认管理员
			user.setMobile("13888888888");
			user.setMembername(loginname.getContents().trim());
			user.setType(customeragent.getAgenttype());
			user=Server.getInstance().getMemberService().createCustomeruser(user);
			//
			
			Agentroleref agentroleref = new Agentroleref();
			agentroleref.setCustomeruserid(user.getId());
			agentroleref.setRoleid(10036l);
			
			Server.getInstance().getMemberService().createAgentroleref(agentroleref);
			
			
			//进行留点
				Liudianrefinfo liudianrefinfo= new Liudianrefinfo();
				liudianrefinfo.setLiudianrecid(1l);
				liudianrefinfo.setTypeid(37l);
				liudianrefinfo.setAgentid(customeragent.getId());
				Server.getInstance().getMemberService().createLiudianrefinfo(liudianrefinfo);
			//留点结束	
				
			
			
			bussinesssql.append("INSERT INTO T_AGENTREFBUSSINESS VALUES ("+customeragent.getId()+",1);");
			Server.getInstance().getSystemService().findMapResultBySql(bussinesssql.toString(), null);
		}
		System.out.println("完了");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
				
		

	}

}
