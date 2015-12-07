/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.atom.component.WriteLog;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.peisong.Peisong;


public class PeisongAction extends B2b2cbackAction {
	private List <  Peisong  >  listPeisong;
	private Peisong peisong = new Peisong();
	private Orderinfo orderinfo = new Orderinfo();
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	public void  alipay_tuifenrun() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderidstr = request.getParameter("strTuiOrderID");
		orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
		String ret="-1";
		String whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and "+Traderecord.COL_ordercode+" ='"+orderinfo.getOrdernumber()+"'";
		whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
		
		/*if(orderinfo.getRelationorderid()!=null&&orderinfo.getRelationorderid()>0){
			String orid="A"+(orderinfo.getRelationorderid()+10000);
			whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and ( "+Traderecord.COL_ordercode+" ='"+orderinfo.getOrdernumber()+"' OR "+Traderecord.COL_ordercode+" ='"+orid+"') ";
			whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
		}*/
		
		List<Traderecord>listTraderecord=new ArrayList<Traderecord>();
		
		listTraderecord=Server.getInstance().getMemberService().findAllTraderecord(whereTR, " ORDER BY ID ", -1, 0);
		if(listTraderecord!=null&&listTraderecord.size()>0){
		//在线支付.退款
		String url="http://127.0.0.1:8080/interface/Alipaytui?orderid="+orderinfo.getId();
		WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url);
		java.net.URL Url = new java.net.URL(url);
		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String s="";
		while((s=br.readLine())!=null)
		{
			WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
			System.out.println("申请退款返回:"+s);
			if(s.indexOf("T")!=-1)
        	{
				WriteLog.write("申请退款信息-成功", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
				ret="1";
				System.out.println("申请退款成功");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/plain; charset=utf-8");
				PrintWriter out = response.getWriter();
				
				out.print(ret);
				out.flush();
				out.close();
        	}else{
        		System.out.println("申请退款失败");
        		WriteLog.write("申请退款信息-失败", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
        		ret="-1";
        		HttpServletResponse response = ServletActionContext.getResponse();
    			response.setContentType("text/plain; charset=utf-8");
    			PrintWriter out = response.getWriter();
    			
    			out.print(ret);
    			out.flush();
    			out.close();
        	}
			
		}
		}else{
			
			if(orderinfo.getRelationorderid()!=null&&orderinfo.getRelationorderid()>0){
			
			orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
			 ret="-1";
			 whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and "+Traderecord.COL_ordercode+" ='"+orderinfo.getOrdernumber()+"'";
			whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
			listTraderecord=Server.getInstance().getMemberService().findAllTraderecord(whereTR, " ORDER BY ID ", -1, 0);
			if(listTraderecord!=null&&listTraderecord.size()>0){
			//在线支付.退款
			String url="http://127.0.0.1:8080/interface/Alipaytui?orderid="+orderinfo.getId();
			WriteLog.write("申请退款信息-关联订单", "订单ID:"+orderinfo.getId()+"URL:"+url);
			java.net.URL Url = new java.net.URL(url);
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String s="";
			while((s=br.readLine())!=null)
			{
				WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
				System.out.println("申请退款返回:"+s);
				if(s.indexOf("T")!=-1)
	        	{
					WriteLog.write("申请退款信息-成功", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
					ret="1";
					System.out.println("申请退款成功");
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/plain; charset=utf-8");
					PrintWriter out = response.getWriter();
					
					out.print(ret);
					out.flush();
					out.close();
	        	}else{
	        		System.out.println("申请退款失败");
	        		WriteLog.write("申请退款信息-失败", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
	        		ret="-1";
	        		HttpServletResponse response = ServletActionContext.getResponse();
	    			response.setContentType("text/plain; charset=utf-8");
	    			PrintWriter out = response.getWriter();
	    			
	    			out.print(ret);
	    			out.flush();
	    			out.close();
	        	}
				
			}
			}
			
		}
		}
		
	}
	
	
	/**
	 * 列表查询行程单配送记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Peisong.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllPeisongForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listPeisong = list;
		  if(pageinfo.getTotalrow()>0 &&   listPeisong.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllPeisongForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listPeisong = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到行程单配送记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到行程单配送记录修改页面
	 */	
	public String toedit()throws Exception{
	peisong = Server.getInstance().getAirService().findPeisong(peisong.getId());
		return EDIT;
	}
	
	/**
	 * 转向到行程单配送记录审核页面
	 */	
	public String tocheck()throws Exception{
	peisong = Server.getInstance().getAirService().findPeisong(peisong.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加行程单配送记录
	 */		
	public String add()throws Exception{
	peisong.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createPeisong(peisong);
		return LIST;
	}

	/**
	 * 审核行程单配送记录
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updatePeisongIgnoreNull(peisong);
		return LIST;
	}
	


	/**
	 * 编辑行程单配送记录
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updatePeisongIgnoreNull(peisong);
		return LIST;
	}

	/**
	 * 删除行程单配送记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deletePeisong(peisong.getId());
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
					Server.getInstance().getAirService().deletePeisong(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回行程单配送记录对象
	 */		
	
	public Object getModel() {
		return peisong;
	}
	public List < Peisong >   getListPeisong() {
		return listPeisong;
	}
	public void setListPeisong(List <  Peisong  >  listPeisong) {
		this.listPeisong = listPeisong;
	}
	public Peisong getPeisong() {
		return peisong;
	}
	public void setPeisong(Peisong peisong) {
		this.peisong = peisong;
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


	public Orderinfo getOrderinfo() {
		return orderinfo;
	}


	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}
	
	
}