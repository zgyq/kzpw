/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fairway.Fairway;
import com.yf.system.base.util.PageInfo;


public class FairwayAction extends B2b2cbackAction {
	private List <  Fairway  >  listFairway;
	private Fairway fairway = new Fairway();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票航空公司
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fairway.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFairwayForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFairway = list;
		  if(pageinfo.getTotalrow()>0 &&   listFairway.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFairwayForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFairway = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票航空公司添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票航空公司修改页面
	 */	
	public String toedit()throws Exception{
	fairway = Server.getInstance().getInterticketService().findFairway(fairway.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票航空公司审核页面
	 */	
	public String tocheck()throws Exception{
	fairway = Server.getInstance().getInterticketService().findFairway(fairway.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票航空公司
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFairway(fairway);
		return LIST;
	}

	/**
	 * 审核国际机票航空公司
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFairwayIgnoreNull(fairway);
		return LIST;
	}
	


	/**
	 * 编辑国际机票航空公司
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFairwayIgnoreNull(fairway);
		return LIST;
	}

	/**
	 * 删除国际机票航空公司
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFairway(fairway.getId());
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
					Server.getInstance().getInterticketService().deleteFairway(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票航空公司对象
	 */		
	
	public Object getModel() {
		return fairway;
	}
	public List < Fairway >   getListFairway() {
		return listFairway;
	}
	public void setListFairway(List <  Fairway  >  listFairway) {
		this.listFairway = listFairway;
	}
	public Fairway getFairway() {
		return fairway;
	}
	public void setFairway(Fairway fairway) {
		this.fairway = fairway;
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