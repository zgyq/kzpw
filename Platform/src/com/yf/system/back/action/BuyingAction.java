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
import com.yf.system.base.buying.Buying;


public class BuyingAction extends B2b2cbackAction {
	private List <  Buying  >  listBuying;
	private Buying buying = new Buying();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private long s_buyingid;//
	
	/**
	 * 列表查询团购信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Buying.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
		if(getLoginUser().getAgentid()!=46){
			
			where+=" AND "+Buying.COL_agentid+" ="+getLoginUser().getAgentid();
		}
	    List list = Server.getInstance().getTripService().findAllBuyingForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listBuying = list;
		  if(pageinfo.getTotalrow()>0 &&   listBuying.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllBuyingForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listBuying = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到团购信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到团购信息修改页面
	 */	
	public String toedit()throws Exception{
	buying = Server.getInstance().getTripService().findBuying(buying.getId());
		return EDIT;
	}
	
	/**
	 * 转向到团购信息审核页面
	 */	
	public String tocheck()throws Exception{
	buying = Server.getInstance().getTripService().findBuying(buying.getId());
	System.out.println(buying.getState());
	if(buying.getState()==0){
		buying.setState(1l);
	}else{
		buying.setState(0l);
	}
	Server.getInstance().getTripService().updateBuyingIgnoreNull(buying);
		return this.execute();
	}
	
	
	/**
	 * 添加团购信息
	 */		
	public String add()throws Exception{
	buying.setCreatetime(new Timestamp(System.currentTimeMillis()));
	buying.setAgentid(getLoginUser().getAgentid());	
	buying.setMemberid(getLoginUser().getId());
	
	
		Server.getInstance().getTripService().createBuying(buying);
		return LIST;
	}

	/**
	 * 审核团购信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateBuyingIgnoreNull(buying);
		return LIST;
	}
	


	/**
	 * 编辑团购信息
	 */		
	public String edit()throws Exception{
		
		Server.getInstance().getTripService().updateBuyingIgnoreNull(buying);
		return LIST;
	}

	/**
	 * 删除团购信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteBuying(buying.getId());
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
					Server.getInstance().getTripService().deleteBuying(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回团购信息对象
	 */		
	
	public Object getModel() {
		return buying;
	}
	public List < Buying >   getListBuying() {
		return listBuying;
	}
	public void setListBuying(List <  Buying  >  listBuying) {
		this.listBuying = listBuying;
	}
	public Buying getBuying() {
		return buying;
	}
	public void setBuying(Buying buying) {
		this.buying = buying;
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
	public long getS_buyingid() {
		return s_buyingid;
	}
	public void setS_buyingid(long s_buyingid) {
		this.s_buyingid = s_buyingid;
	}
	
	
}