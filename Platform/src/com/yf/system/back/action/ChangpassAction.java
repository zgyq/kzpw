/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.back.server.Server;
import com.yf.system.base.changpass.Changpass;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.util.PageInfo;


public class ChangpassAction extends B2b2cbackAction {
	private List <  Changpass  >  listChangpass;
	private Changpass changpass = new Changpass();
	private Orderinfo orderinfo = new Orderinfo();
	private List <  Passenger  >  listPassenger;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	private long s_orderid;
	//search
	//private String s_name;
	private String s_passid;
	private String s_idnum;
	
	
	/**
	 * 列表查询变更记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Changpass.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllChangpassForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listChangpass = list;
		  if(pageinfo.getTotalrow()>0 &&   listChangpass.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllChangpassForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listChangpass = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到变更记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到变更记录添加页面
	 */	
	public String tochang()throws Exception{
		orderinfo =Server.getInstance().getAirService().findOrderinfo(s_orderid);
		listPassenger=Server.getInstance().getAirService().findAllPassenger(" where 1=1 and "+Passenger.COL_orderid+" ="+s_orderid, " ORDER BY ID ", -1, 0);
		
		listChangpass =Server.getInstance().getAirService().findAllChangpass(" where 1=1 and "+Changpass.COL_orderid+" ="+s_orderid, " ORDER BY ID ", -1, 0);
		
		
		return "tochang";
	}
	/**
	 * 转向到变更记录修改页面
	 */	
	public String toedit()throws Exception{
	changpass = Server.getInstance().getAirService().findChangpass(changpass.getId());
		return EDIT;
	}
	
	/**
	 * 转向到变更记录审核页面
	 */	
	public String tocheck()throws Exception{
	changpass = Server.getInstance().getAirService().findChangpass(changpass.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加变更记录
	 */		
	public String add()throws Exception{
		changpass.setCreateuser(getLoginUser().getLoginname());
		changpass.setCreatetime(new Timestamp(System.currentTimeMillis()));
		changpass.setModifyuser(getLoginUser().getLoginname());
		changpass.setModifytime(new Timestamp(System.currentTimeMillis()));
		changpass.setAgentid(getLoginUser().getAgentid());
		changpass.setUserid(getLoginUser().getId());
		changpass.setType(3l);
		changpass.setStatus(1l);
		changpass=Server.getInstance().getAirService().createChangpass(changpass);
		orderinfo=Server.getInstance().getAirService().findOrderinfo(changpass.getOrderid());
		
		String sub="-1";
		try {
			
			sub = Server.getInstance().getRateService().ChangOrderPass(orderinfo, changpass);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message="";
		if(!sub.equals("-1")&&sub!=null&&sub.length()>0){//
			changpass.setOrdernum(sub);
			Server.getInstance().getAirService().updateChangpassIgnoreNull(changpass);
				message="申请成功!等待审核";
			
		}else{
			message="申请失败!";
			Server.getInstance().getAirService().deleteChangpass(changpass.getId());
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
		System.out.println("sub:"+sub);
		
		return "add";
	}

	/**
	 * 审核变更记录
	 */		
	public String check()throws Exception{
	changpass.setModifyuser(getLoginUser().getLoginname());
		changpass.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateChangpassIgnoreNull(changpass);
		return LIST;
	}
	


	/**
	 * 编辑变更记录
	 */		
	public String edit()throws Exception{
	changpass.setModifyuser(getLoginUser().getLoginname());
		changpass.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateChangpassIgnoreNull(changpass);
		return LIST;
	}

	/**
	 * 删除变更记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteChangpass(changpass.getId());
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
					Server.getInstance().getAirService().deleteChangpass(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回变更记录对象
	 */		
	
	public Object getModel() {
		return changpass;
	}
	public List < Changpass >   getListChangpass() {
		return listChangpass;
	}
	public void setListChangpass(List <  Changpass  >  listChangpass) {
		this.listChangpass = listChangpass;
	}
	public Changpass getChangpass() {
		return changpass;
	}
	public void setChangpass(Changpass changpass) {
		this.changpass = changpass;
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
	public List<Passenger> getListPassenger() {
		return listPassenger;
	}
	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}
	public long getS_orderid() {
		return s_orderid;
	}
	public void setS_orderid(long s_orderid) {
		this.s_orderid = s_orderid;
	}
	
	
}