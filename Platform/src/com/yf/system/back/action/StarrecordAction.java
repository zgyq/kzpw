/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.starrecord.Starrecord;
import com.yf.system.base.util.PageInfo;


public class StarrecordAction extends B2b2cbackAction {
	private List <  Starrecord  >  listStarrecord;
	private Starrecord starrecord = new Starrecord();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询星级留点记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Starrecord.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getHotelService().findAllStarrecordForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listStarrecord = list;
		  if(pageinfo.getTotalrow()>0 &&   listStarrecord.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllStarrecordForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listStarrecord = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到星级留点记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到星级留点记录修改页面
	 */	
	public String toedit()throws Exception{
	starrecord = Server.getInstance().getHotelService().findStarrecord(starrecord.getId());
		return EDIT;
	}
	
	/**
	 * 转向到星级留点记录审核页面
	 */	
	public String tocheck()throws Exception{
	starrecord = Server.getInstance().getHotelService().findStarrecord(starrecord.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加星级留点记录
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getHotelService().createStarrecord(starrecord);
		return LIST;
	}

	/**
	 * 审核星级留点记录
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateStarrecordIgnoreNull(starrecord);
		return LIST;
	}
	


	/**
	 * 编辑星级留点记录
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateStarrecordIgnoreNull(starrecord);
		return LIST;
	}

	/**
	 * 删除星级留点记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteStarrecord(starrecord.getId());
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
					Server.getInstance().getHotelService().deleteStarrecord(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回星级留点记录对象
	 */		
	
	public Object getModel() {
		return starrecord;
	}
	public List < Starrecord >   getListStarrecord() {
		return listStarrecord;
	}
	public void setListStarrecord(List <  Starrecord  >  listStarrecord) {
		this.listStarrecord = listStarrecord;
	}
	public Starrecord getStarrecord() {
		return starrecord;
	}
	public void setStarrecord(Starrecord starrecord) {
		this.starrecord = starrecord;
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