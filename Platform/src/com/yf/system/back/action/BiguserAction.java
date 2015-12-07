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
import com.yf.system.base.biguser.Biguser;
import com.yf.system.base.util.PageInfo;


public class BiguserAction extends B2b2cbackAction {
	private List <  Biguser  >  listBiguser;
	private Biguser biguser = new Biguser();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询大客户关联金额表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Biguser.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllBiguserForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listBiguser = list;
		  if(pageinfo.getTotalrow()>0 &&   listBiguser.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllBiguserForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listBiguser = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到大客户关联金额表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到大客户关联金额表修改页面
	 */	
	public String toedit()throws Exception{
	biguser = Server.getInstance().getMemberService().findBiguser(biguser.getId());
		return EDIT;
	}
	
	/**
	 * 转向到大客户关联金额表审核页面
	 */	
	public String tocheck()throws Exception{
	biguser = Server.getInstance().getMemberService().findBiguser(biguser.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加大客户关联金额表
	 */		
	public String add()throws Exception{
		
		
		biguser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		biguser.setKyongprice(biguser.getCreditprice());
		biguser.setCreateuserid(getLoginUserId());
		Server.getInstance().getMemberService().createBiguser(biguser);
		return LIST;
	}

	/**
	 * 审核大客户关联金额表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateBiguserIgnoreNull(biguser);
		return LIST;
	}
	


	/**
	 * 编辑大客户关联金额表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateBiguserIgnoreNull(biguser);
		return LIST;
	}

	/**
	 * 删除大客户关联金额表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteBiguser(biguser.getId());
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
					Server.getInstance().getMemberService().deleteBiguser(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回大客户关联金额表对象
	 */		
	
	public Object getModel() {
		return biguser;
	}
	public List < Biguser >   getListBiguser() {
		return listBiguser;
	}
	public void setListBiguser(List <  Biguser  >  listBiguser) {
		this.listBiguser = listBiguser;
	}
	public Biguser getBiguser() {
		return biguser;
	}
	public void setBiguser(Biguser biguser) {
		this.biguser = biguser;
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