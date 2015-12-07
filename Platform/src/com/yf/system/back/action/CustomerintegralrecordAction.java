/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.base.customerintegralrecord.Customerintegralrecord;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;


public class CustomerintegralrecordAction extends B2b2cbackAction {
	private List <  Customerintegralrecord  >  listCustomerintegralrecord;
	private Customerintegralrecord customerintegralrecord = new Customerintegralrecord();
	private String customername="";//会员名
	private String s_begincreatetime="";//积分获取时间
	private String s_endcreatetime="";//积分获取时间

	
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询会员积分记录
	 */	
	public String execute()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String where = " where 1=1 ";
		if(customerintegralrecord.getRefuid()>0){
			where+=" AND "+Customerintegralrecord.COL_refuid+"="+customerintegralrecord.getRefuid();
		}
		if(!isNotNullOrEpt(customername)){
			customername =Server.getInstance().getMemberService().findCustomeruser(customerintegralrecord.getRefuid()).getMembername();
		
		}
		if(this.isNotNullOrEpt(customerintegralrecord.getRefordernumber())){
			where+=" AND "+Customerintegralrecord.COL_refordernumber+" LIKE '%"+customerintegralrecord.getRefordernumber()+"%'";
		}
		String time=this.getCheckTime(s_begincreatetime, s_endcreatetime,Customerintegralrecord.COL_createtime);
		if(this.isNotNullOrEpt(time)){
			where+=" AND ("+time+")";
		}
	
	    List list = Server.getInstance().getMemberService().findAllCustomerintegralrecordForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCustomerintegralrecord = list;
		  if(pageinfo.getTotalrow()>0 &&   listCustomerintegralrecord.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllCustomerintegralrecordForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCustomerintegralrecord = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到会员积分记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到会员积分记录修改页面
	 */	
	public String toedit()throws Exception{
	customerintegralrecord = Server.getInstance().getMemberService().findCustomerintegralrecord(customerintegralrecord.getId());
		return EDIT;
	}
	
	/**
	 * 转向到会员积分记录审核页面
	 */	
	public String tocheck()throws Exception{
	customerintegralrecord = Server.getInstance().getMemberService().findCustomerintegralrecord(customerintegralrecord.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加会员积分记录
	 */		
	public String add()throws Exception{
	customerintegralrecord.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createCustomerintegralrecord(customerintegralrecord);
		return LIST;
	}
	
	

	/**
	 * 审核会员积分记录
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateCustomerintegralrecordIgnoreNull(customerintegralrecord);
		return LIST;
	}
	


	/**
	 * 编辑会员积分记录
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateCustomerintegralrecordIgnoreNull(customerintegralrecord);
		return LIST;
	}

	/**
	 * 删除会员积分记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteCustomerintegralrecord(customerintegralrecord.getId());
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
					Server.getInstance().getMemberService().deleteCustomerintegralrecord(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回会员积分记录对象
	 */		
	
	public Object getModel() {
		return customerintegralrecord;
	}
	public List < Customerintegralrecord >   getListCustomerintegralrecord() {
		return listCustomerintegralrecord;
	}
	public void setListCustomerintegralrecord(List <  Customerintegralrecord  >  listCustomerintegralrecord) {
		this.listCustomerintegralrecord = listCustomerintegralrecord;
	}
	public Customerintegralrecord getCustomerintegralrecord() {
		return customerintegralrecord;
	}
	public void setCustomerintegralrecord(Customerintegralrecord customerintegralrecord) {
		this.customerintegralrecord = customerintegralrecord;
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
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	
	public String getS_begincreatetime() {
		return s_begincreatetime;
	}
	public void setS_begincreatetime(String s_begincreatetime) {
		this.s_begincreatetime = s_begincreatetime;
	}
	public String getS_endcreatetime() {
		return s_endcreatetime;
	}
	public void setS_endcreatetime(String s_endcreatetime) {
		this.s_endcreatetime = s_endcreatetime;
	}
	
	
}