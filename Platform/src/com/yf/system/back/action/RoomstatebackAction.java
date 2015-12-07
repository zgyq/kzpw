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
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.util.PageInfo;

public class RoomstatebackAction extends B2b2cbackAction {
	private List listRoomstateback;
	private Roomstateback roomstateback = new Roomstateback();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询酒店房态表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Roomstateback.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
		listRoomstateback = Server.getInstance().getHotelService().findAllRoomstatebackForPageinfo(where,"ORDER BY ID",pageinfo);
		
		 if(pageinfo.getTotalrow()>0 &&   listRoomstateback.size()==0){
			pageinfo.setPagenum(1);
			listRoomstateback = Server.getInstance().getHotelService().findAllRoomstatebackForPageinfo(where," ORDER BY ID ",pageinfo);	
		}
		
		 pageinfo = (PageInfo) listRoomstateback.get(0) ;
		 listRoomstateback.remove(0) ;
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店房态表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到酒店房态表修改页面
	 */	
	public String toedit()throws Exception{
	roomstateback = Server.getInstance().getHotelService().findRoomstateback(roomstateback.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店房态表审核页面
	 */	
	public String tocheck()throws Exception{
	roomstateback = Server.getInstance().getHotelService().findRoomstateback(roomstateback.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加酒店房态表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getHotelService().createRoomstateback(roomstateback);
		return LIST;
	}

	/**
	 * 审核酒店房态表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateRoomstatebackIgnoreNull(roomstateback);
		return LIST;
	}
	


	/**
	 * 编辑酒店房态表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateRoomstatebackIgnoreNull(roomstateback);
		return LIST;
	}

	/**
	 * 删除酒店房态表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteRoomstateback(roomstateback.getId());
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
					Server.getInstance().getHotelService().deleteRoomstateback(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回酒店房态表对象
	 */		
	
	public Object getModel() {
		return roomstateback;
	}
	public List < Roomstateback >   getListRoomstateback() {
		return listRoomstateback;
	}
	public void setListRoomstateback(List <  Roomstateback  >  listRoomstateback) {
		this.listRoomstateback = listRoomstateback;
	}
	public Roomstateback getRoomstateback() {
		return roomstateback;
	}
	public void setRoomstateback(Roomstateback roomstateback) {
		this.roomstateback = roomstateback;
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