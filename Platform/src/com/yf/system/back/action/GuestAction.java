/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.guest.Guest;




public class GuestAction extends B2b2cbackAction{
	private List <  Guest  >  listGuest;
	private Guest guest = new Guest();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询客人信息表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Guest.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
//		listGuest = Server.getInstance().getGuestManager().findAllGuest(where,"ORDER BY ID",pageinfo);
//		
//		 if(pageinfo.getTotalrow()>0 &&   listGuest.size()==0){
//			pageinfo.setPagenum(1);
//			listGuest = Server.getInstance().getGuestManager().findAllGuest(where," ORDER BY ID ",pageinfo);	
//		}
		
		
		return SUCCESS;
	}
	/**
	 * 转向到客人信息表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到客人信息表修改页面
	 */	
	public String toedit()throws Exception{
	guest = Server.getInstance().getHotelService().findGuest(guest.getId());
		return EDIT;
	}
	
	/**
	 * 转向到客人信息表审核页面
	 */	
	public String tocheck()throws Exception{
	guest = Server.getInstance().getHotelService().findGuest(guest.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加客人信息表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getHotelService().createGuest(guest);
		return LIST;
	}

	/**
	 * 审核客人信息表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
		return LIST;
	}
	


	/**
	 * 编辑客人信息表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateGuestIgnoreNull(guest);
		return LIST;
	}

	/**
	 * 删除客人信息表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteGuest(guest.getId());
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
					Server.getInstance().getHotelService().deleteGuest(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回客人信息表对象
	 */		
	
	public Object getModel() {
		return guest;
	}
	public List < Guest >   getListGuest() {
		return listGuest;
	}
	public void setListGuest(List <  Guest  >  listGuest) {
		this.listGuest = listGuest;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
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