/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fflight.Fflight;
import com.yf.system.base.util.PageInfo;


public class FflightAction extends B2b2cbackAction {
	private List <  Fflight  >  listFflight;
	private Fflight fflight = new Fflight();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票行程
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fflight.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFflightForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFflight = list;
		  if(pageinfo.getTotalrow()>0 &&   listFflight.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFflightForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFflight = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票行程添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票行程修改页面
	 */	
	public String toedit()throws Exception{
	fflight = Server.getInstance().getInterticketService().findFflight(fflight.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票行程审核页面
	 */	
	public String tocheck()throws Exception{
	fflight = Server.getInstance().getInterticketService().findFflight(fflight.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票行程
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFflight(fflight);
		return LIST;
	}

	/**
	 * 审核国际机票行程
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFflightIgnoreNull(fflight);
		return LIST;
	}
	


	/**
	 * 编辑国际机票行程
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFflightIgnoreNull(fflight);
		return LIST;
	}

	/**
	 * 删除国际机票行程
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFflight(fflight.getId());
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
					Server.getInstance().getInterticketService().deleteFflight(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票行程对象
	 */		
	
	public Object getModel() {
		return fflight;
	}
	public List < Fflight >   getListFflight() {
		return listFflight;
	}
	public void setListFflight(List <  Fflight  >  listFflight) {
		this.listFflight = listFflight;
	}
	public Fflight getFflight() {
		return fflight;
	}
	public void setFflight(Fflight fflight) {
		this.fflight = fflight;
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