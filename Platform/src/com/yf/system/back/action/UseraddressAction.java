/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.useraddress.Useraddress;
import com.yf.system.base.util.PageInfo;


public class UseraddressAction extends B2b2cbackAction {
	private List <  Useraddress  >  listUseraddress;
	private Useraddress useraddress = new Useraddress();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询会员常用配送地址
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Useraddress.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllUseraddressForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listUseraddress = list;
		  if(pageinfo.getTotalrow()>0 &&   listUseraddress.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllUseraddressForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listUseraddress = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到会员常用配送地址添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到会员常用配送地址修改页面
	 */	
	public String toedit()throws Exception{
	useraddress = Server.getInstance().getMemberService().findUseraddress(useraddress.getId());
		return EDIT;
	}
	
	/**
	 * 转向到会员常用配送地址审核页面
	 */	
	public String tocheck()throws Exception{
	useraddress = Server.getInstance().getMemberService().findUseraddress(useraddress.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加会员常用配送地址
	 */		
	public String add()throws Exception{
	useraddress.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createUseraddress(useraddress);
		return LIST;
	}

	/**
	 * 审核会员常用配送地址
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateUseraddressIgnoreNull(useraddress);
		return LIST;
	}
	


	/**
	 * 编辑会员常用配送地址
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateUseraddressIgnoreNull(useraddress);
		return LIST;
	}

	/**
	 * 删除会员常用配送地址
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteUseraddress(useraddress.getId());
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
					Server.getInstance().getMemberService().deleteUseraddress(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回会员常用配送地址对象
	 */		
	
	public Object getModel() {
		return useraddress;
	}
	public List < Useraddress >   getListUseraddress() {
		return listUseraddress;
	}
	public void setListUseraddress(List <  Useraddress  >  listUseraddress) {
		this.listUseraddress = listUseraddress;
	}
	public Useraddress getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(Useraddress useraddress) {
		this.useraddress = useraddress;
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