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
import com.yf.system.base.hotelagent.Hotelagent;


public class HotelagentAction extends B2b2cbackAction {
	private List <  Hotelagent  >  listHotelagent;
	private Hotelagent hotelagent = new Hotelagent();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询加盟商返点表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Hotelagent.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getHotelService().findAllHotelagentForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHotelagent = list;
		  if(pageinfo.getTotalrow()>0 &&   listHotelagent.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelagentForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listHotelagent = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到加盟商返点表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到加盟商返点表修改页面
	 */	
	public String toedit()throws Exception{
	hotelagent = Server.getInstance().getHotelService().findHotelagent(hotelagent.getId());
		return EDIT;
	}
	
	/**
	 * 转向到加盟商返点表审核页面
	 */	
	public String tocheck()throws Exception{
	hotelagent = Server.getInstance().getHotelService().findHotelagent(hotelagent.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加加盟商返点表
	 */		
	public String add()throws Exception{
	hotelagent.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getHotelService().createHotelagent(hotelagent);
		return LIST;
	}

	/**
	 * 审核加盟商返点表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelagentIgnoreNull(hotelagent);
		return LIST;
	}
	


	/**
	 * 编辑加盟商返点表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelagentIgnoreNull(hotelagent);
		return LIST;
	}

	/**
	 * 删除加盟商返点表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotelagent(hotelagent.getId());
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
					Server.getInstance().getHotelService().deleteHotelagent(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回加盟商返点表对象
	 */		
	
	public Object getModel() {
		return hotelagent;
	}
	public List < Hotelagent >   getListHotelagent() {
		return listHotelagent;
	}
	public void setListHotelagent(List <  Hotelagent  >  listHotelagent) {
		this.listHotelagent = listHotelagent;
	}
	public Hotelagent getHotelagent() {
		return hotelagent;
	}
	public void setHotelagent(Hotelagent hotelagent) {
		this.hotelagent = hotelagent;
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