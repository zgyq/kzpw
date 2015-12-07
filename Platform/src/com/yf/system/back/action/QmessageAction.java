/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.qmessage.Qmessage;


public class QmessageAction extends B2b2cbackAction {
	private List <  Qmessage  >  listQmessage;
	private Qmessage qmessage = new Qmessage();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private String s_createuser;
	private int s_ststus=0;
	private String s_stratedate;
	private String s_endedate;
	private String s_createendtime;
	private String s_createstarttime;
	
	
	/**
	 * 列表查询Q信箱
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_createuser!=null && s_createuser.trim().length()!=0) {
			
			where += " and " + Qmessage.COL_createuser +" like '%" + s_createuser.trim()+"%'";	
		}
		
        if (s_ststus!=-1) {
			
			where += " and " + Qmessage.COL_status +"=" + s_ststus;	
		}
        
        if (s_stratedate!=null && s_stratedate.trim().length()!=0 && s_endedate!=null && s_endedate.trim().length()!=0) {
			
			where += " and " + Qmessage.COL_dealtime +" between '"+s_stratedate +"' and '"+s_endedate+"'";	
		}
        
       if (s_createstarttime!=null && s_createstarttime.trim().length()!=0 && s_createendtime!=null && s_createendtime.trim().length()!=0) {
			
			where += " and " + Qmessage.COL_createtime +" between '"+s_createstarttime +"' and '"+s_createendtime+"'";	
		}
	
	    List list = Server.getInstance().getMemberService().findAllQmessageForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQmessage = list;
		  if(pageinfo.getTotalrow()>0 &&   listQmessage.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllQmessageForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQmessage = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到Q信箱添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到Q信箱修改页面
	 */	
	public String toedit()throws Exception{
		
	    qmessage = Server.getInstance().getMemberService().findQmessage(qmessage.getId());
		return EDIT;
	}
	
	/**
	 * 转向到Q信箱审核页面
	 */	
	public String tocheck()throws Exception{
	qmessage = Server.getInstance().getMemberService().findQmessage(qmessage.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加Q信箱
	 */		
	public String add()throws Exception{
	qmessage.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createQmessage(qmessage);
		return LIST;
	}

	/**
	 * 审核Q信箱
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateQmessageIgnoreNull(qmessage);
		return LIST;
	}
	


	/**
	 * 编辑Q信箱
	 */		
	public String edit()throws Exception{
		qmessage=Server.getInstance().getMemberService().findQmessage(qmessage.getId());
		qmessage.setStatus(1);
		qmessage.setCreateuser(this.getLoginUser().getMembername());
		qmessage.setDealtime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getMemberService().updateQmessageIgnoreNull(qmessage);
		return LIST;
	}

	/**
	 * 删除Q信箱
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteQmessage(qmessage.getId());
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
					Server.getInstance().getMemberService().deleteQmessage(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回Q信箱对象
	 */		
	
	public Object getModel() {
		return qmessage;
	}
	public List < Qmessage >   getListQmessage() {
		return listQmessage;
	}
	public void setListQmessage(List <  Qmessage  >  listQmessage) {
		this.listQmessage = listQmessage;
	}
	public Qmessage getQmessage() {
		return qmessage;
	}
	public void setQmessage(Qmessage qmessage) {
		this.qmessage = qmessage;
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
	public String getS_createuser() {
		return s_createuser;
	}
	public void setS_createuser(String s_createuser) {
		this.s_createuser = s_createuser;
	}
	
	public String getS_stratedate() {
		return s_stratedate;
	}
	public void setS_stratedate(String s_stratedate) {
		this.s_stratedate = s_stratedate;
	}
	public String getS_endedate() {
		return s_endedate;
	}
	public void setS_endedate(String s_endedate) {
		this.s_endedate = s_endedate;
	}
	public void setS_ststus(int s_ststus) {
		this.s_ststus = s_ststus;
	}
	public String getS_createendtime() {
		return s_createendtime;
	}
	public void setS_createendtime(String s_createendtime) {
		this.s_createendtime = s_createendtime;
	}
	public String getS_createstarttime() {
		return s_createstarttime;
	}
	public void setS_createstarttime(String s_createstarttime) {
		this.s_createstarttime = s_createstarttime;
	}
	
	
}