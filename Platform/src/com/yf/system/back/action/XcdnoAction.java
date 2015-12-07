/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import sun.security.util.BigInt;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.back.server.Server;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.xcdno.Xcdno;
import com.yf.system.base.xcdnoinfo.Xcdnoinfo;
import com.yf.system.base.xcdorder.Xcdorder;


public class XcdnoAction extends B2b2cbackAction {
	private List <  Xcdno  >  listXcdno;
	private Xcdno xcdno = new Xcdno();
	
	private List <  Customeragent  >  listCustomeragent;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	private String s_numinfo;//行程单号
	private String s_passid;//乘机人ID
	
	private String s_pnr;//PNR
	private String s_ticketnum;//票号
	
	
	//以下查询用
	private String s_agentcode;//
	private String s_office;//
	private String s_tiankai;//
	private String s_lingdan;//
	
	private String s_sno;//s_sno
	
	private String s_endno;//s_endno
	
	
	/**
	 * 列表查询行程单
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_sno!=null && s_sno.trim().length()!=0) {
			
			where += " and " + Xcdno.COL_sno +" <="+s_sno;	
			
		}
		if (s_endno!=null && s_endno.trim().length()!=0) {
			
			where += " and " + Xcdno.COL_endno +" >="+s_endno;	
			
		}
		if (s_agentcode!=null && s_agentcode.trim().length()!=0) {
			where += " and " + Xcdno.COL_agentcode +" like '%" + s_agentcode.trim()+"%'";	
		}
		if (s_office!=null && s_office.trim().length()!=0) {
			where += " and " + Xcdno.COL_officecode +" like '%" + s_office.trim()+"%'";	
		}
		if (s_tiankai!=null && s_tiankai.trim().length()!=0) {
			where += " and " + Xcdno.COL_companyname +" like '%" + s_tiankai.trim()+"%'";	
		}
		if (s_lingdan!=null && s_lingdan.trim().length()!=0) {
			where += " and " + Xcdno.COL_agentid +" in( SELECT "+Customeragent.COL_id+" FROM "+Customeragent.TABLE+" WHERE 1=1 and ( "+Customeragent.COL_agentcompanyname+" LIKE '%"+s_lingdan.trim()+"%' OR "+Customeragent.COL_agentshortname+" LIKE '%"+s_lingdan.trim()+"%' ))";	
		}
		
		System.out.println(where);
	    List list = Server.getInstance().getAirService().findAllXcdnoForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listXcdno = list;
		  if(pageinfo.getTotalrow()>0 &&   listXcdno.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllXcdnoForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listXcdno = list;
		}
		
		return SUCCESS;
	}
	
	public String GetXcdNO(long id){
		String ret="";
		List<Xcdnoinfo>list=Server.getInstance().getAirService().findAllXcdnoinfo(" WHERE 1=1 AND "+Xcdnoinfo.COL_xcdid+" ="+id+" AND "+Xcdnoinfo.COL_state+" =2", " ORDER BY ID ", -1, 0);
		return list.size()+"";
		
	}
	/**
	 * 转向到行程单添加页面
	 */	
	public String toadd()throws Exception{
		String where=" where 1=1 and "+Customeragent.COL_agenttype+" =3";
		listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(where, " ORDER BY ID DESC ", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到行程单修改页面
	 */	
	public String toedit()throws Exception{
	xcdno = Server.getInstance().getAirService().findXcdno(xcdno.getId());
		return EDIT;
	}
	
	/**
	 * 转向到行程单修改页面
	 */	
	public String todaidaxcd()throws Exception{
	
		return "todaidaxcd";
	}
	
	/**
	 * 转向到行程单审核页面
	 */	
	public String tocheck()throws Exception{
	xcdno = Server.getInstance().getAirService().findXcdno(xcdno.getId());
		return CHECK;
	}
	public void SearchNumInfo() throws IOException{
		String restmsg="ok";
		
		List<Xcdnoinfo>list=Server.getInstance().getAirService().findAllXcdnoinfo(" where 1=1 and "+Xcdnoinfo.COL_xcdinfo+" ='"+s_numinfo+"'", " ORDER BY ID ", -1, 0);
		if(list.size()>0){
			restmsg="err";
		}
		System.out.println(restmsg);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(restmsg);
		out.flush();
		out.close();
		
		
	}
	
	public void valadateaNumInfo() throws IOException{
		String restmsg="-1";
		String where=" where 1=1 and "+Xcdnoinfo.COL_xcdinfo+" ='"+s_numinfo+"' AND "+Xcdnoinfo.COL_agentid+" ="+getLoginUser().getAgentid();
		System.out.println("where:"+where);
		List<Xcdnoinfo>list=Server.getInstance().getAirService().findAllXcdnoinfo(where, " ORDER BY ID ", -1, 0);
		if(list.size()>0){
			if(list.get(0).getState()==1){
				restmsg="1";//没使用
			}
			if(list.get(0).getState()==2){
				restmsg="2";//已使用
			}
		}else{
			
			restmsg="-1";
		}
		System.out.println(restmsg);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(restmsg);
		out.flush();
		out.close();
		
		
	}
	//创建乐途行程单
	public void toyuetucreateXCD() throws IOException{
		String restmsg="-1";
		System.out.println(s_passid+","+s_numinfo);
		Passenger passenger=Server.getInstance().getAirService().findPassenger(Long.parseLong(s_passid));
		if(passenger.getTicketnum()!=null){
			restmsg="1";
			//以下为罗总那  去乐途创建
			//restmsg=Server.getInstance().getRateService().Create_XingChengDan_New("ctu212", passenger.getTicketnum(), s_numinfo);
		}
		
		//restmsg="1";
		System.out.println(restmsg);
		if(restmsg.equals("1")){//乐途创建成功
			Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(passenger.getOrderid());
			
			List<Xcdnoinfo>listxcdinfo=	Server.getInstance().getAirService().findAllXcdnoinfo(" WHERE 1=1 AND "+Xcdnoinfo.COL_xcdinfo+" ='"+s_numinfo+"'", " ORDER BY ID ", -1, 0);
			if(listxcdinfo!=null&&listxcdinfo.size()>0){
					Xcdnoinfo xcdnoinfo=listxcdinfo.get(0);
					xcdnoinfo.setState(2l);
					Server.getInstance().getAirService().updateXcdnoinfoIgnoreNull(xcdnoinfo);
					
					Xcdorder xcdorder=new Xcdorder();
					xcdorder.setAgentid(xcdnoinfo.getAgentid());
					xcdorder.setCompanyname(xcdnoinfo.getCompanyname());
					xcdorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
					xcdorder.setOfficecode(xcdnoinfo.getOfficecode());
					xcdorder.setOrderid(orderinfo.getId());
					xcdorder.setPassid(passenger.getId());
					xcdorder.setPnr(orderinfo.getPnr());
					xcdorder.setState(1l);
					xcdorder.setTicketno(passenger.getTicketnum());
					xcdorder.setUserid(getLoginUser().getId());
					xcdorder.setXcdinfo(s_numinfo);
					xcdorder.setXcdinfoid(xcdnoinfo.getId());
					try {
						Server.getInstance().getAirService().createXcdorder(xcdorder);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
			}
		
			
			
		}
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(restmsg);
		out.flush();
		out.close();
		
		
	}
	
	//创建乐途行程单
	public void toyuetucreateXCD2() throws IOException{
		String restmsg="-1";
		
		if(s_ticketnum!=null){
			restmsg=Server.getInstance().getRateService().Create_XingChengDan_New("ctu212", s_ticketnum, s_numinfo);
		}
		restmsg="1";
		System.out.println(restmsg);
		if(restmsg.equals("1")){//乐途创建成功
			
			List<Xcdnoinfo>listxcdinfo=	Server.getInstance().getAirService().findAllXcdnoinfo(" WHERE 1=1 AND "+Xcdnoinfo.COL_xcdinfo+" ='"+s_numinfo+"'", " ORDER BY ID ", -1, 0);
			if(listxcdinfo!=null&&listxcdinfo.size()>0){
					Xcdnoinfo xcdnoinfo=listxcdinfo.get(0);
					xcdnoinfo.setState(2l);
					Server.getInstance().getAirService().updateXcdnoinfoIgnoreNull(xcdnoinfo);
					
					Xcdorder xcdorder=new Xcdorder();
					xcdorder.setAgentid(xcdnoinfo.getAgentid());
					xcdorder.setCompanyname(xcdnoinfo.getCompanyname());
					xcdorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
					xcdorder.setOfficecode(xcdnoinfo.getOfficecode());
					xcdorder.setPnr(s_pnr);
					xcdorder.setState(1l);
					xcdorder.setTicketno(s_ticketnum);
					xcdorder.setUserid(getLoginUser().getId());
					xcdorder.setXcdinfo(s_numinfo);
					xcdorder.setXcdinfoid(xcdnoinfo.getId());
					try {
						Server.getInstance().getAirService().createXcdorder(xcdorder);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
			}
		
			
			
		}
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(restmsg);
		out.flush();
		out.close();
		
		
	}
	
	
	/**
	 * 添加行程单
	 */		
	public String add()throws Exception{
	xcdno.setCreatetime(new Timestamp(System.currentTimeMillis()));
	//xcdno.setAgentid(agentid);
	xcdno.setUserid(getLoginUser().getId());
	xcdno=Server.getInstance().getAirService().createXcdno(xcdno);
		
		insetNumInfo(xcdno.getSno(), xcdno.getEndno(), 0l, 0, xcdno);
		
		return LIST;
	}
	
public void insetNumInfo(String starnum,String endnum,long travelitid,int len,Xcdno xcdno){
		if(Long.parseLong(endnum)>Long.parseLong((starnum))){
			Xcdnoinfo xcdnoinfo = new Xcdnoinfo();
			for(long s=Long.parseLong(starnum);s<=Long.parseLong(endnum);s++){
				System.out.println("s:"+s);
				xcdnoinfo.setXcdid(xcdno.getId());
				xcdnoinfo.setAgentid(xcdno.getAgentid());
				xcdnoinfo.setCompanyname(xcdno.getCompanyname());
				xcdnoinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
				xcdnoinfo.setEndno(xcdno.getEndno());
				xcdnoinfo.setSno(xcdno.getSno());
				xcdnoinfo.setOfficecode(xcdno.getOfficecode());
				xcdnoinfo.setUserid(getLoginUser().getId());
				xcdnoinfo.setState(1l);
				xcdnoinfo.setXcdinfo(s+"");
				try {
					Server.getInstance().getAirService().createXcdnoinfo(xcdnoinfo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		
	}

	/**
	 * 审核行程单
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateXcdnoIgnoreNull(xcdno);
		return LIST;
	}
	


	/**
	 * 编辑行程单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateXcdnoIgnoreNull(xcdno);
		return LIST;
	}

	/**
	 * 删除行程单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().excuteXcdnoinfoBySql(" DELETE "+Xcdnoinfo.TABLE+" WHERE "+Xcdnoinfo.COL_xcdid+" ="+xcdno.getId());
		Server.getInstance().getAirService().deleteXcdno(xcdno.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getAirService().excuteXcdnoinfoBySql(" DELETE "+Xcdnoinfo.TABLE+" WHERE "+Xcdnoinfo.COL_xcdid+" ="+i);
					Server.getInstance().getAirService().deleteXcdno(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回行程单对象
	 */		
	
	public Object getModel() {
		return xcdno;
	}
	public List < Xcdno >   getListXcdno() {
		return listXcdno;
	}
	public void setListXcdno(List <  Xcdno  >  listXcdno) {
		this.listXcdno = listXcdno;
	}
	public Xcdno getXcdno() {
		return xcdno;
	}
	public void setXcdno(Xcdno xcdno) {
		this.xcdno = xcdno;
	}
	
	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}
	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}
	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}
	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}
	public String getS_numinfo() {
		return s_numinfo;
	}
	public void setS_numinfo(String s_numinfo) {
		this.s_numinfo = s_numinfo;
	}
	public String getS_passid() {
		return s_passid;
	}
	public void setS_passid(String s_passid) {
		this.s_passid = s_passid;
	}
	public String getS_pnr() {
		return s_pnr;
	}
	public void setS_pnr(String s_pnr) {
		this.s_pnr = s_pnr;
	}
	public String getS_ticketnum() {
		return s_ticketnum;
	}
	public void setS_ticketnum(String s_ticketnum) {
		this.s_ticketnum = s_ticketnum;
	}

	public String getS_agentcode() {
		return s_agentcode;
	}

	public void setS_agentcode(String s_agentcode) {
		this.s_agentcode = s_agentcode;
	}

	public String getS_office() {
		return s_office;
	}

	public void setS_office(String s_office) {
		this.s_office = s_office;
	}

	public String getS_tiankai() {
		return s_tiankai;
	}

	public void setS_tiankai(String s_tiankai) {
		this.s_tiankai = s_tiankai;
	}

	public String getS_lingdan() {
		return s_lingdan;
	}

	public void setS_lingdan(String s_lingdan) {
		this.s_lingdan = s_lingdan;
	}

	public String getS_sno() {
		return s_sno;
	}

	public void setS_sno(String s_sno) {
		this.s_sno = s_sno;
	}

	public String getS_endno() {
		return s_endno;
	}

	public void setS_endno(String s_endno) {
		this.s_endno = s_endno;
	}
	
	
}