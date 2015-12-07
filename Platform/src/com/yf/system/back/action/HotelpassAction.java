/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotelpass.Hotelpass;
import com.yf.system.base.util.PageInfo;


public class HotelpassAction extends B2b2cbackAction {
	private List <  Hotelpass  >  listHotelpass;
	private Hotelpass hotelpass = new Hotelpass();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询酒店常用入住人表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Hotelpass.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getHotelService().findAllHotelpassForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHotelpass = list;
		  if(pageinfo.getTotalrow()>0 &&   listHotelpass.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelpassForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listHotelpass = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店常用入住人表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到酒店常用入住人表修改页面
	 */	
	public String toedit()throws Exception{
	hotelpass = Server.getInstance().getHotelService().findHotelpass(hotelpass.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店常用入住人表审核页面
	 */	
	public String tocheck()throws Exception{
	hotelpass = Server.getInstance().getHotelService().findHotelpass(hotelpass.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加酒店常用入住人表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getHotelService().createHotelpass(hotelpass);
		return LIST;
	}

	/**
	 * 审核酒店常用入住人表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelpassIgnoreNull(hotelpass);
		return LIST;
	}
	


	/**
	 * 编辑酒店常用入住人表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelpassIgnoreNull(hotelpass);
		return LIST;
	}

	/**
	 * 删除酒店常用入住人表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotelpass(hotelpass.getId());
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
					Server.getInstance().getHotelService().deleteHotelpass(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回酒店常用入住人表对象
	 */		
	
	public Object getModel() {
		return hotelpass;
	}
	public List < Hotelpass >   getListHotelpass() {
		return listHotelpass;
	}
	public void setListHotelpass(List <  Hotelpass  >  listHotelpass) {
		this.listHotelpass = listHotelpass;
	}
	public Hotelpass getHotelpass() {
		return hotelpass;
	}
	public void setHotelpass(Hotelpass hotelpass) {
		this.hotelpass = hotelpass;
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