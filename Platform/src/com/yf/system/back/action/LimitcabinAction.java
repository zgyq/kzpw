/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;

import com.yf.system.back.server.Server;
import com.yf.system.base.limitcabin.Limitcabin;
import com.yf.system.base.util.PageInfo;



public class LimitcabinAction extends B2b2cbackAction {
	private List <  Limitcabin  >  listLimitcabin;
	private Limitcabin limitcabin = new Limitcabin();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private String s_stime;
	private String s_endtime;
	private String s_state;
	/**
	 * 列表查询限制仓位
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Limitcabin.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllLimitcabinForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listLimitcabin = list;
		  if(pageinfo.getTotalrow()>0 &&   listLimitcabin.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllLimitcabinForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listLimitcabin = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到限制仓位添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到限制仓位修改页面
	 */	
	public String toedit()throws Exception{
	limitcabin = Server.getInstance().getAirService().findLimitcabin(limitcabin.getId());
		return EDIT;
	}
	
	/**
	 * 转向到限制仓位审核页面
	 */	
	public String tocheck()throws Exception{
	limitcabin = Server.getInstance().getAirService().findLimitcabin(limitcabin.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加限制仓位
	 */		
	public String add()throws Exception{
		limitcabin.setCreatetime(new Timestamp(System.currentTimeMillis()));
		limitcabin.setStime(dateToTimestamp(s_stime));
		limitcabin.setEndtime(dateToTimestamp(s_endtime));
		Server.getInstance().getAirService().createLimitcabin(limitcabin);
		return LIST;
	}

	/**
	 * 审核限制仓位
	 */		
	public String check()throws Exception{
		limitcabin.setState(Long.parseLong(s_state));
		Server.getInstance().getAirService().updateLimitcabinIgnoreNull(limitcabin);
		return LIST;
	}
	


	/**
	 * 编辑限制仓位
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateLimitcabinIgnoreNull(limitcabin);
		return LIST;
	}

	/**
	 * 删除限制仓位
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteLimitcabin(limitcabin.getId());
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
					Server.getInstance().getAirService().deleteLimitcabin(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回限制仓位对象
	 */		
	
	public Object getModel() {
		return limitcabin;
	}
	public List < Limitcabin >   getListLimitcabin() {
		return listLimitcabin;
	}
	public void setListLimitcabin(List <  Limitcabin  >  listLimitcabin) {
		this.listLimitcabin = listLimitcabin;
	}
	public Limitcabin getLimitcabin() {
		return limitcabin;
	}
	public void setLimitcabin(Limitcabin limitcabin) {
		this.limitcabin = limitcabin;
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
	public String getS_stime() {
		return s_stime;
	}
	public void setS_stime(String s_stime) {
		this.s_stime = s_stime;
	}
	public String getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	
	
}