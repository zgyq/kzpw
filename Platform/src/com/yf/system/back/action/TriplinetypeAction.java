/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.triplinetype.Triplinetype;
import com.yf.system.base.util.PageInfo;


public class TriplinetypeAction extends B2b2cbackAction {
	private List <  Triplinetype  >  listTriplinetype;
	private Triplinetype triplinetype = new Triplinetype();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询旅游线路类型表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Triplinetype.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllTriplinetypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTriplinetype = list;
		  if(pageinfo.getTotalrow()>0 &&   listTriplinetype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTriplinetypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTriplinetype = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到旅游线路类型表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到旅游线路类型表修改页面
	 */	
	public String toedit()throws Exception{
	triplinetype = Server.getInstance().getTripService().findTriplinetype(triplinetype.getId());
		return EDIT;
	}
	
	public String toeditlanguage()throws Exception{
		Integer lan=triplinetype.getLanguage();
		Long uco=triplinetype.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		//triplinetype = Server.getInstance().getTripService().findTriplinetype(triplinetype.getId());
		triplinetype = Server.getInstance().getTripService().findTriplinetypebylanguage(triplinetype.getUcode(),triplinetype.getLanguage());
		if(triplinetype==null)
		{
			triplinetype=new Triplinetype();
			triplinetype.setLanguage(lan);
			triplinetype.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			triplinetype = Server.getInstance().getTripService().findTriplinetype(triplinetype.getId());
		}
		return EDIT;
	}
	
	/**
	 * 转向到旅游线路类型表审核页面
	 */	
	public String tocheck()throws Exception{
	triplinetype = Server.getInstance().getTripService().findTriplinetype(triplinetype.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加旅游线路类型表
	 */		
	public String add()throws Exception{
	triplinetype.setCreateuser(getLoginUser().getLoginname());
		triplinetype.setCreatetime(new Timestamp(System.currentTimeMillis()));
		triplinetype.setModifyuser(getLoginUser().getLoginname());
		triplinetype.setModifytime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getTripService().createTriplinetype(triplinetype);
		return LIST;
	}

	/**
	 * 审核旅游线路类型表
	 */		
	public String check()throws Exception{
	triplinetype.setModifyuser(getLoginUser().getLoginname());
		triplinetype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriplinetypeIgnoreNull(triplinetype);
		return LIST;
	}
	


	/**
	 * 编辑旅游线路类型表
	 */		
	public String edit()throws Exception{
	triplinetype.setModifyuser(getLoginUser().getLoginname());
		triplinetype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriplinetypeIgnoreNull(triplinetype);
		return LIST;
	}

	/**
	 * 删除旅游线路类型表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTriplinetype(triplinetype.getId());
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
					Server.getInstance().getTripService().deleteTriplinetype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回旅游线路类型表对象
	 */		
	
	public Object getModel() {
		return triplinetype;
	}
	public List < Triplinetype >   getListTriplinetype() {
		return listTriplinetype;
	}
	public void setListTriplinetype(List <  Triplinetype  >  listTriplinetype) {
		this.listTriplinetype = listTriplinetype;
	}
	public Triplinetype getTriplinetype() {
		return triplinetype;
	}
	public void setTriplinetype(Triplinetype triplinetype) {
		this.triplinetype = triplinetype;
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