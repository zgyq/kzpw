/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


import com.yf.system.back.server.Server;
import com.yf.system.base.txuserinfo.Txuserinfo;


public class TxuserinfoAction extends B2b2cbackAction {
	private List <  Txuserinfo  >  listTxuserinfo;
	private Txuserinfo txuserinfo = new Txuserinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询用户信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Txuserinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllTxuserinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTxuserinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listTxuserinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllTxuserinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTxuserinfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到用户信息添加页面
	 */	
	public String toadd()throws Exception{
		listTxuserinfo=Server.getInstance().getMemberService().findAllTxuserinfo("", "", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到用户信息修改页面
	 */	
	public String toedit()throws Exception{
	txuserinfo = Server.getInstance().getMemberService().findTxuserinfo(txuserinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到用户信息审核页面
	 */	
	public String tocheck()throws Exception{
	txuserinfo = Server.getInstance().getMemberService().findTxuserinfo(txuserinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加用户信息
	 */		
	public String add()throws Exception{
		txuserinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getMemberService().createTxuserinfo(txuserinfo);
		return LIST;
	}

	/**
	 * 审核用户信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateTxuserinfoIgnoreNull(txuserinfo);
		return LIST;
	}
	


	/**
	 * 编辑用户信息
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateTxuserinfoIgnoreNull(txuserinfo);
		return LIST;
	}

	/**
	 * 删除用户信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteTxuserinfo(txuserinfo.getId());
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
					Server.getInstance().getMemberService().deleteTxuserinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回用户信息对象
	 */		
	
	public Object getModel() {
		return txuserinfo;
	}
	public List < Txuserinfo >   getListTxuserinfo() {
		return listTxuserinfo;
	}
	public void setListTxuserinfo(List <  Txuserinfo  >  listTxuserinfo) {
		this.listTxuserinfo = listTxuserinfo;
	}
	public Txuserinfo getTxuserinfo() {
		return txuserinfo;
	}
	public void setTxuserinfo(Txuserinfo txuserinfo) {
		this.txuserinfo = txuserinfo;
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