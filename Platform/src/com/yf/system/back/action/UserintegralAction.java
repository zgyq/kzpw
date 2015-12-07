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
import com.yf.system.base.userintegral.Userintegral;


public class UserintegralAction extends B2b2cbackAction {
	private List <  Userintegral  >  listUserintegral;
	private Userintegral userintegral = new Userintegral();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询会员积分记录表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Userintegral.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllUserintegralForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listUserintegral = list;
		  if(pageinfo.getTotalrow()>0 &&   listUserintegral.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllUserintegralForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listUserintegral = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到会员积分记录表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到会员积分记录表修改页面
	 */	
	public String toedit()throws Exception{
	userintegral = Server.getInstance().getMemberService().findUserintegral(userintegral.getId());
		return EDIT;
	}
	
	/**
	 * 转向到会员积分记录表审核页面
	 */	
	public String tocheck()throws Exception{
	userintegral = Server.getInstance().getMemberService().findUserintegral(userintegral.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加会员积分记录表
	 */		
	public String add()throws Exception{
	userintegral.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createUserintegral(userintegral);
		return LIST;
	}

	/**
	 * 审核会员积分记录表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateUserintegralIgnoreNull(userintegral);
		return LIST;
	}
	


	/**
	 * 编辑会员积分记录表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateUserintegralIgnoreNull(userintegral);
		return LIST;
	}

	/**
	 * 删除会员积分记录表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteUserintegral(userintegral.getId());
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
					Server.getInstance().getMemberService().deleteUserintegral(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回会员积分记录表对象
	 */		
	
	public Object getModel() {
		return userintegral;
	}
	public List < Userintegral >   getListUserintegral() {
		return listUserintegral;
	}
	public void setListUserintegral(List <  Userintegral  >  listUserintegral) {
		this.listUserintegral = listUserintegral;
	}
	public Userintegral getUserintegral() {
		return userintegral;
	}
	public void setUserintegral(Userintegral userintegral) {
		this.userintegral = userintegral;
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