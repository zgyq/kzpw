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
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.tripnode.Tripnode;
import com.yf.system.base.util.PageInfo;


public class TripnodeAction extends B2b2cbackAction {
	private List <  Tripnode  >  listTripnode;
	private Tripnode tripnode = new Tripnode();
	private List<Tripline> listTripline;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询注意事项
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Tripnode.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllTripnodeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTripnode = list;
		  if(pageinfo.getTotalrow()>0 &&   listTripnode.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTripnodeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTripnode = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到注意事项添加页面
	 */	
	public String toadd()throws Exception{
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到注意事项修改页面
	 */	
	public String toedit()throws Exception{
		tripnode = Server.getInstance().getTripService().findTripnode(tripnode.getId());
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		return EDIT;
	}
	
	/**
	 * 转向到注意事项审核页面
	 */	
	public String tocheck()throws Exception{
		tripnode = Server.getInstance().getTripService().findTripnode(tripnode.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加注意事项
	 */		
	public String add()throws Exception{
		tripnode.setCreateuser(getLoginUser().getLoginname());
		tripnode.setCreatetime(new Timestamp(System.currentTimeMillis()));
		tripnode.setModifyuser(getLoginUser().getLoginname());
		tripnode.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		tripnode = Server.getInstance().getTripService().createTripnode(tripnode);
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 审核注意事项
	 */		
	public String check()throws Exception{
		tripnode.setModifyuser(getLoginUser().getLoginname());
		tripnode.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTripnodeIgnoreNull(tripnode);
		return LIST;
	}
	


	/**
	 * 编辑注意事项
	 */		
	public String edit()throws Exception{
	tripnode.setModifyuser(getLoginUser().getLoginname());
		tripnode.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTripnodeIgnoreNull(tripnode);
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 删除注意事项
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTripnode(tripnode.getId());
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
					Server.getInstance().getTripService().deleteTripnode(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	public String toeditlanguage()throws Exception{
		Integer lan=tripnode.getLanguage();
		Long uco=tripnode.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		//tripnode = Server.getInstance().getTripService().findTripnode(tripnode.getId());
		tripnode = Server.getInstance().getTripService().findTripnodebylanguage(tripnode.getUcode(),tripnode.getLanguage());
		if(tripnode==null)
		{
			tripnode=new Tripnode();
			tripnode.setLanguage(lan);
			tripnode.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			tripnode = Server.getInstance().getTripService().findTripnode(tripnode.getId());
		}
		return EDIT;
	}





	/**
	 *  返回注意事项对象
	 */		
	
	public Object getModel() {
		return tripnode;
	}
	public List < Tripnode >   getListTripnode() {
		return listTripnode;
	}
	public void setListTripnode(List <  Tripnode  >  listTripnode) {
		this.listTripnode = listTripnode;
	}
	public Tripnode getTripnode() {
		return tripnode;
	}
	public void setTripnode(Tripnode tripnode) {
		this.tripnode = tripnode;
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
	public List<Tripline> getListTripline() {
		return listTripline;
	}
	public void setListTripline(List<Tripline> listTripline) {
		this.listTripline = listTripline;
	}
	
	
}