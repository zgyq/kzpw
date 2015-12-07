/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.util.PageInfo;


public class FcityAction extends B2b2cbackAction {
	private List <  Fcity  >  listFcity;
	private Fcity fcity = new Fcity();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票城市
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fcity.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFcityForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFcity = list;
		  if(pageinfo.getTotalrow()>0 &&   listFcity.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFcityForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFcity = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票城市添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票城市修改页面
	 */	
	public String toedit()throws Exception{
	fcity = Server.getInstance().getInterticketService().findFcity(fcity.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票城市审核页面
	 */	
	public String tocheck()throws Exception{
	fcity = Server.getInstance().getInterticketService().findFcity(fcity.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票城市
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFcity(fcity);
		return LIST;
	}

	/**
	 * 审核国际机票城市
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFcityIgnoreNull(fcity);
		return LIST;
	}
	


	/**
	 * 编辑国际机票城市
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFcityIgnoreNull(fcity);
		return LIST;
	}

	/**
	 * 删除国际机票城市
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFcity(fcity.getId());
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
					Server.getInstance().getInterticketService().deleteFcity(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票城市对象
	 */		
	
	public Object getModel() {
		return fcity;
	}
	public List < Fcity >   getListFcity() {
		return listFcity;
	}
	public void setListFcity(List <  Fcity  >  listFcity) {
		this.listFcity = listFcity;
	}
	public Fcity getFcity() {
		return fcity;
	}
	public void setFcity(Fcity fcity) {
		this.fcity = fcity;
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