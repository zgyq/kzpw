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
import com.yf.system.base.spotmes.Spotmes;


public class SpotmesAction extends B2b2cbackAction {
	private List <  Spotmes  >  listSpotmes;
	private Spotmes spotmes = new Spotmes();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询景点信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotmes.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotmesForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotmes = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotmes.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotmesForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotmes = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到景点信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到景点信息修改页面
	 */	
	public String toedit()throws Exception{
	spotmes = Server.getInstance().getTripService().findSpotmes(spotmes.getId());
		return EDIT;
	}
	
	/**
	 * 转向到景点信息审核页面
	 */	
	public String tocheck()throws Exception{
	spotmes = Server.getInstance().getTripService().findSpotmes(spotmes.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加景点信息
	 */		
	public String add()throws Exception{
	spotmes.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createSpotmes(spotmes);
		return LIST;
	}

	/**
	 * 审核景点信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotmesIgnoreNull(spotmes);
		return LIST;
	}
	


	/**
	 * 编辑景点信息
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotmesIgnoreNull(spotmes);
		return LIST;
	}

	/**
	 * 删除景点信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotmes(spotmes.getId());
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
					Server.getInstance().getTripService().deleteSpotmes(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回景点信息对象
	 */		
	
	public Object getModel() {
		return spotmes;
	}
	public List < Spotmes >   getListSpotmes() {
		return listSpotmes;
	}
	public void setListSpotmes(List <  Spotmes  >  listSpotmes) {
		this.listSpotmes = listSpotmes;
	}
	public Spotmes getSpotmes() {
		return spotmes;
	}
	public void setSpotmes(Spotmes spotmes) {
		this.spotmes = spotmes;
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