/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.liudianrecord.Liudianrecord;
import com.yf.system.base.util.PageInfo;


public class LiudianrecordAction extends B2b2cbackAction {
	private List <  Liudianrecord  >  listLiudianrecord;
	private Liudianrecord liudianrecord = new Liudianrecord();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询留点记录表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Liudianrecord.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllLiudianrecordForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listLiudianrecord = list;
		  if(pageinfo.getTotalrow()>0 &&   listLiudianrecord.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllLiudianrecordForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listLiudianrecord = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到留点记录表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到留点记录表修改页面
	 */	
	public String toedit()throws Exception{
	liudianrecord = Server.getInstance().getMemberService().findLiudianrecord(liudianrecord.getId());
		return EDIT;
	}
	
	/**
	 * 转向到留点记录表审核页面
	 */	
	public String tocheck()throws Exception{
	liudianrecord = Server.getInstance().getMemberService().findLiudianrecord(liudianrecord.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加留点记录表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createLiudianrecord(liudianrecord);
		return LIST;
	}

	/**
	 * 审核留点记录表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateLiudianrecordIgnoreNull(liudianrecord);
		return LIST;
	}
	


	/**
	 * 编辑留点记录表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateLiudianrecordIgnoreNull(liudianrecord);
		return LIST;
	}

	/**
	 * 删除留点记录表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteLiudianrecord(liudianrecord.getId());
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
					Server.getInstance().getMemberService().deleteLiudianrecord(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回留点记录表对象
	 */		
	
	public Object getModel() {
		return liudianrecord;
	}
	public List < Liudianrecord >   getListLiudianrecord() {
		return listLiudianrecord;
	}
	public void setListLiudianrecord(List <  Liudianrecord  >  listLiudianrecord) {
		this.listLiudianrecord = listLiudianrecord;
	}
	public Liudianrecord getLiudianrecord() {
		return liudianrecord;
	}
	public void setLiudianrecord(Liudianrecord liudianrecord) {
		this.liudianrecord = liudianrecord;
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