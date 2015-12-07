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
import com.yf.system.base.eaccount.Eaccount;


public class EaccountAction extends B2b2cbackAction {
	private List <  Eaccount  >  listEaccount;
	private Eaccount eaccount = new Eaccount();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询外部账号
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Eaccount.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getSystemService().findAllEaccountForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listEaccount = list;
		  if(pageinfo.getTotalrow()>0 &&   listEaccount.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllEaccountForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listEaccount = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到外部账号添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到外部账号修改页面
	 */	
	public String toedit()throws Exception{
	eaccount = Server.getInstance().getSystemService().findEaccount(eaccount.getId());
		return EDIT;
	}
	
	/**
	 * 转向到外部账号审核页面
	 */	
	public String tocheck()throws Exception{
	eaccount = Server.getInstance().getSystemService().findEaccount(eaccount.getId());
	if(eaccount.getState()==null){
		
		eaccount.setState("1");
	}else{
		
		if(eaccount.getState().equals("1")){
			eaccount.setState("0");
			
		}else{
			
			eaccount.setState("1");
		}
		
	}
	
	Server.getInstance().getSystemService().updateEaccountIgnoreNull(eaccount);
	
	
		return LIST;
	}
	
	
	/**
	 * 添加外部账号
	 */		
	public String add()throws Exception{
	eaccount.setCreateuser(getLoginUser().getLoginname());
		eaccount.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().createEaccount(eaccount);
		return LIST;
	}

	/**
	 * 审核外部账号
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getSystemService().updateEaccountIgnoreNull(eaccount);
		return LIST;
	}
	


	/**
	 * 编辑外部账号
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getSystemService().updateEaccountIgnoreNull(eaccount);
		return LIST;
	}

	/**
	 * 删除外部账号
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getSystemService().deleteEaccount(eaccount.getId());
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
					Server.getInstance().getSystemService().deleteEaccount(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回外部账号对象
	 */		
	
	public Object getModel() {
		return eaccount;
	}
	public List < Eaccount >   getListEaccount() {
		return listEaccount;
	}
	public void setListEaccount(List <  Eaccount  >  listEaccount) {
		this.listEaccount = listEaccount;
	}
	public Eaccount getEaccount() {
		return eaccount;
	}
	public void setEaccount(Eaccount eaccount) {
		this.eaccount = eaccount;
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