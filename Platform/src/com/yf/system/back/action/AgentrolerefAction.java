/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.util.PageInfo;


public class AgentrolerefAction extends B2b2cbackAction {
	private List <  Agentroleref  >  listAgentroleref;
	private Agentroleref agentroleref = new Agentroleref();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询会员角色关联
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Agentroleref.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllAgentrolerefForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listAgentroleref = list;
		  if(pageinfo.getTotalrow()>0 &&   listAgentroleref.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllAgentrolerefForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listAgentroleref = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到会员角色关联添加页面
	 */	
	public String toadd()throws Exception{
		System.out.println("laidaolazhea");
		return EDIT;
	}
	/**
	 * 转向到会员角色关联修改页面
	 */	
	public String toedit()throws Exception{
	agentroleref = Server.getInstance().getMemberService().findAgentroleref(agentroleref.getId());
		return EDIT;
	}
	
	/**
	 * 转向到会员角色关联审核页面
	 */	
	public String tocheck()throws Exception{
	agentroleref = Server.getInstance().getMemberService().findAgentroleref(agentroleref.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加会员角色关联
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createAgentroleref(agentroleref);
		return LIST;
	}

	/**
	 * 审核会员角色关联
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateAgentrolerefIgnoreNull(agentroleref);
		return LIST;
	}
	


	/**
	 * 编辑会员角色关联
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateAgentrolerefIgnoreNull(agentroleref);
		return LIST;
	}

	/**
	 * 删除会员角色关联
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteAgentroleref(agentroleref.getId());
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
					Server.getInstance().getMemberService().deleteAgentroleref(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回会员角色关联对象
	 */		
	
	public Object getModel() {
		return agentroleref;
	}
	public List < Agentroleref >   getListAgentroleref() {
		return listAgentroleref;
	}
	public void setListAgentroleref(List <  Agentroleref  >  listAgentroleref) {
		this.listAgentroleref = listAgentroleref;
	}
	public Agentroleref getAgentroleref() {
		return agentroleref;
	}
	public void setAgentroleref(Agentroleref agentroleref) {
		this.agentroleref = agentroleref;
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