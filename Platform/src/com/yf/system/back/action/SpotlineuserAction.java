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
import com.yf.system.base.spotlineuser.Spotlineuser;


public class SpotlineuserAction extends B2b2cbackAction {
	private List <  Spotlineuser  >  listSpotlineuser;
	private Spotlineuser spotlineuser = new Spotlineuser();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询线路游客
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotlineuser.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotlineuserForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotlineuser = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotlineuser.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotlineuserForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotlineuser = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到线路游客添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到线路游客修改页面
	 */	
	public String toedit()throws Exception{
	spotlineuser = Server.getInstance().getTripService().findSpotlineuser(spotlineuser.getId());
		return EDIT;
	}
	
	/**
	 * 转向到线路游客审核页面
	 */	
	public String tocheck()throws Exception{
	spotlineuser = Server.getInstance().getTripService().findSpotlineuser(spotlineuser.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加线路游客
	 */		
	public String add()throws Exception{
	spotlineuser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createSpotlineuser(spotlineuser);
		return LIST;
	}

	/**
	 * 审核线路游客
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineuserIgnoreNull(spotlineuser);
		return LIST;
	}
	


	/**
	 * 编辑线路游客
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineuserIgnoreNull(spotlineuser);
		return LIST;
	}

	/**
	 * 删除线路游客
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotlineuser(spotlineuser.getId());
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
					Server.getInstance().getTripService().deleteSpotlineuser(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回线路游客对象
	 */		
	
	public Object getModel() {
		return spotlineuser;
	}
	public List < Spotlineuser >   getListSpotlineuser() {
		return listSpotlineuser;
	}
	public void setListSpotlineuser(List <  Spotlineuser  >  listSpotlineuser) {
		this.listSpotlineuser = listSpotlineuser;
	}
	public Spotlineuser getSpotlineuser() {
		return spotlineuser;
	}
	public void setSpotlineuser(Spotlineuser spotlineuser) {
		this.spotlineuser = spotlineuser;
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