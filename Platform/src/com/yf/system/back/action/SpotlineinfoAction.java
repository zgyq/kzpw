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


import com.yf.system.back.server.Server;
import com.yf.system.base.spotlineinfo.Spotlineinfo;


public class SpotlineinfoAction extends B2b2cbackAction {
	private List <  Spotlineinfo  >  listSpotlineinfo;
	private Spotlineinfo spotlineinfo = new Spotlineinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询景区线路详细信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotlineinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotlineinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotlineinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotlineinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotlineinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotlineinfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到景区线路详细信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到景区线路详细信息修改页面
	 */	
	public String toedit()throws Exception{
	spotlineinfo = Server.getInstance().getTripService().findSpotlineinfo(spotlineinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到景区线路详细信息审核页面
	 */	
	public String tocheck()throws Exception{
	spotlineinfo = Server.getInstance().getTripService().findSpotlineinfo(spotlineinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加景区线路详细信息
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getTripService().createSpotlineinfo(spotlineinfo);
		return LIST;
	}

	/**
	 * 审核景区线路详细信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineinfoIgnoreNull(spotlineinfo);
		return LIST;
	}
	


	/**
	 * 编辑景区线路详细信息
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineinfoIgnoreNull(spotlineinfo);
		return LIST;
	}

	/**
	 * 删除景区线路详细信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotlineinfo(spotlineinfo.getId());
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
					Server.getInstance().getTripService().deleteSpotlineinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回景区线路详细信息对象
	 */		
	
	public Object getModel() {
		return spotlineinfo;
	}
	public List < Spotlineinfo >   getListSpotlineinfo() {
		return listSpotlineinfo;
	}
	public void setListSpotlineinfo(List <  Spotlineinfo  >  listSpotlineinfo) {
		this.listSpotlineinfo = listSpotlineinfo;
	}
	public Spotlineinfo getSpotlineinfo() {
		return spotlineinfo;
	}
	public void setSpotlineinfo(Spotlineinfo spotlineinfo) {
		this.spotlineinfo = spotlineinfo;
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