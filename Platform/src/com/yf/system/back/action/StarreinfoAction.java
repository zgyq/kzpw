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
import com.yf.system.base.starreinfo.Starreinfo;


public class StarreinfoAction extends B2b2cbackAction {
	private List <  Starreinfo  >  listStarreinfo;
	private Starreinfo starreinfo = new Starreinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询星级返点设置关联
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Starreinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getHotelService().findAllStarreinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listStarreinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listStarreinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllStarreinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listStarreinfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到星级返点设置关联添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到星级返点设置关联修改页面
	 */	
	public String toedit()throws Exception{
	starreinfo = Server.getInstance().getHotelService().findStarreinfo(starreinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到星级返点设置关联审核页面
	 */	
	public String tocheck()throws Exception{
	starreinfo = Server.getInstance().getHotelService().findStarreinfo(starreinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加星级返点设置关联
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getHotelService().createStarreinfo(starreinfo);
		return LIST;
	}

	/**
	 * 审核星级返点设置关联
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateStarreinfoIgnoreNull(starreinfo);
		return LIST;
	}
	


	/**
	 * 编辑星级返点设置关联
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateStarreinfoIgnoreNull(starreinfo);
		return LIST;
	}

	/**
	 * 删除星级返点设置关联
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteStarreinfo(starreinfo.getId());
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
					Server.getInstance().getHotelService().deleteStarreinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回星级返点设置关联对象
	 */		
	
	public Object getModel() {
		return starreinfo;
	}
	public List < Starreinfo >   getListStarreinfo() {
		return listStarreinfo;
	}
	public void setListStarreinfo(List <  Starreinfo  >  listStarreinfo) {
		this.listStarreinfo = listStarreinfo;
	}
	public Starreinfo getStarreinfo() {
		return starreinfo;
	}
	public void setStarreinfo(Starreinfo starreinfo) {
		this.starreinfo = starreinfo;
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