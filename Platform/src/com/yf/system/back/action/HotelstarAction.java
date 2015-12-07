/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotelstar.Hotelstar;
import com.yf.system.base.util.PageInfo;


public class HotelstarAction extends B2b2cbackAction {
	private List <  Hotelstar  >  listHotelstar;
	private Hotelstar hotelstar = new Hotelstar();
	
	//批量操作ID数组  
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询酒店星级返点对应表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Hotelstar.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getHotelService().findAllHotelstarForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHotelstar = list;
		  if(pageinfo.getTotalrow()>0 &&   listHotelstar.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelstarForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listHotelstar = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店星级返点对应表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到酒店星级返点对应表修改页面
	 */	
	public String toedit()throws Exception{
	hotelstar = Server.getInstance().getHotelService().findHotelstar(hotelstar.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店星级返点对应表审核页面
	 */	
	public String tocheck()throws Exception{
	hotelstar = Server.getInstance().getHotelService().findHotelstar(hotelstar.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加酒店星级返点对应表
	 */		
	public String add()throws Exception{
		hotelstar.setCreateuserid(getLoginUser().getId());
		Server.getInstance().getHotelService().createHotelstar(hotelstar);
		return LIST;
	}

	/**
	 * 审核酒店星级返点对应表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelstarIgnoreNull(hotelstar);
		return LIST;
	}
	


	/**
	 * 编辑酒店星级返点对应表
	 */		
	public String edit()throws Exception{
		hotelstar.setCreateuserid(getLoginUser().getId());
		Server.getInstance().getHotelService().updateHotelstarIgnoreNull(hotelstar);
		return LIST;
	}

	/**
	 * 删除酒店星级返点对应表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotelstar(hotelstar.getId());
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
					Server.getInstance().getHotelService().deleteHotelstar(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回酒店星级返点对应表对象
	 */		
	
	public Object getModel() {
		return hotelstar;
	}
	public List < Hotelstar >   getListHotelstar() {
		return listHotelstar;
	}
	public void setListHotelstar(List <  Hotelstar  >  listHotelstar) {
		this.listHotelstar = listHotelstar;
	}
	public Hotelstar getHotelstar() {
		return hotelstar;
	}
	public void setHotelstar(Hotelstar hotelstar) {
		this.hotelstar = hotelstar;
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