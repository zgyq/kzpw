/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.base.integral.Integral;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;


public class IntegralAction extends B2b2cbackAction {
	private List <  Integral  >  listIntegral;
	private Integral integral = new Integral();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	//初始化sql
//	 INSERT INTO T_INTEGRAL (ID,C_AGENTTYPE,C_AIRCOEFT,C_HOTELCOEFT,C_TRAVELCOEFT,C_CARRENTALCOEFT,C_RECHARGECOEFT,C_REGISTERSCORE,C_PUNISHSCORE,C_BACKORDERSCORE,C_WEBORDERSCORE)
//	  SELECT 1,0,0,0,0,0,0,0,0,0,0 UNION 
//	  SELECT 2,1,0,0,0,0,0,0,0,0,0 UNION 
//	  SELECT 3,2,0,0,0,0,0,0,0,0,0 UNION 
//	  SELECT 4,3,0,0,0,0,0,0,0,0,0 UNION 
//	  SELECT 5,4,0,0,0,0,0,0,0,0,0 UNION 
//	  SELECT 6,5,0,0,0,0,0,0,0,0,0 
	
	
	/**
	 * 列表查询积分管理
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Integral.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllIntegralForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listIntegral = list;
		  if(pageinfo.getTotalrow()>0 &&   listIntegral.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllIntegralForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listIntegral = list;
		}
		  for(Integral integral:listIntegral){
			  if(integral.getAgenttype()==5){//会员
				  this.integral=integral;
				 
			  }
		  }
		
		return SUCCESS;
	}
	
	public String getAgenttype(long agenttype){
		return getAgentTypeName((int)agenttype)+"积分系数";
	}
	/**
	 * 转向到积分管理添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到积分管理修改页面
	 */	
	public String toedit()throws Exception{
	integral = Server.getInstance().getMemberService().findIntegral(integral.getId());
		return EDIT;
	}
	
	/**
	 * 转向到积分管理审核页面
	 */	
	public String tocheck()throws Exception{
	integral = Server.getInstance().getMemberService().findIntegral(integral.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加积分管理
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createIntegral(integral);
		return LIST;
	}

	/**
	 * 审核积分管理
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateIntegralIgnoreNull(integral);
		return LIST;
	}
	


	/**
	 * 编辑积分管理
	 */		
	public String edit()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String where = " where 1=1 ";
		List list = Server.getInstance().getMemberService().findAllIntegralForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listIntegral = list;
		  if(pageinfo.getTotalrow()>0 &&   listIntegral.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllIntegralForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listIntegral = list;
		}
		   
		  int register=Integer.valueOf(converNull(request.getParameter("register5"),"0"));
		  int punish=Integer.valueOf(converNull(request.getParameter("punish5"),"0"));
		  int backorder=Integer.valueOf(converNull(request.getParameter("backorder5"),"0"));
		  int  weborder=Integer.valueOf(converNull(request.getParameter("weborder5"),"0"));
		  
		  for(Integral integral:listIntegral){
			  long type=integral.getAgenttype();
			  System.out.println(request.getParameter("aircoeft"+type));
			  float aircoeft=Float.valueOf(converNull(request.getParameter("aircoeft"+type),"0"));
			  //float hotelcoeft=Float.valueOf(converNull(request.getParameter("hotelcoeft"+type),"0"));
			  //float travelcoeft=Float.valueOf(converNull(request.getParameter("travelcoeft"+type),"0"));
			  //float carrentalcoeft=Float.valueOf(converNull(request.getParameter("carrentalcoeft"+type),"0"));
			  //float rechargecoeft=Float.valueOf(converNull(request.getParameter("rechargecoeft"+type),"0"));
			  
			 
			  integral.setAircoeft(aircoeft);
			  //integral.setHotelcoeft(hotelcoeft);
			  //integral.setTravelcoeft(travelcoeft);
			  //integral.setCarrentalcoeft(carrentalcoeft);
			  //integral.setRechargecoeft(rechargecoeft);
			  integral.setRegisterscore(register);
			  integral.setPunishscore(punish);
			  integral.setBackorderscore(backorder);
			  integral.setWeborderscore(weborder);
			  Server.getInstance().getMemberService().updateIntegralIgnoreNull(integral);
			  
			  
		  }
		return this.execute();
	}

	/**
	 * 删除积分管理
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteIntegral(integral.getId());
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
					Server.getInstance().getMemberService().deleteIntegral(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回积分管理对象
	 */		
	
	public Object getModel() {
		return integral;
	}
	public List < Integral >   getListIntegral() {
		return listIntegral;
	}
	public void setListIntegral(List <  Integral  >  listIntegral) {
		this.listIntegral = listIntegral;
	}
	public Integral getIntegral() {
		return integral;
	}
	public void setIntegral(Integral integral) {
		this.integral = integral;
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
	
	
}