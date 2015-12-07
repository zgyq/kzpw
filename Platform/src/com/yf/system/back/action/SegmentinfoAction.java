/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;


public class SegmentinfoAction extends B2b2cbackAction {
	private List <  Segmentinfo  >  listSegmentinfo;
	private Segmentinfo segmentinfo = new Segmentinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询行程表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Segmentinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllSegmentinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSegmentinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listSegmentinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllSegmentinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSegmentinfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到行程表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到行程表修改页面
	 */	
	public String toedit()throws Exception{
	segmentinfo = Server.getInstance().getAirService().findSegmentinfo(segmentinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到行程表审核页面
	 */	
	public String tocheck()throws Exception{
	segmentinfo = Server.getInstance().getAirService().findSegmentinfo(segmentinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加行程表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		return LIST;
	}

	/**
	 * 审核行程表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateSegmentinfoIgnoreNull(segmentinfo);
		return LIST;
	}
	


	/**
	 * 编辑行程表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateSegmentinfoIgnoreNull(segmentinfo);
		return LIST;
	}

	/**
	 * 删除行程表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteSegmentinfo(segmentinfo.getId());
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
					Server.getInstance().getAirService().deleteSegmentinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回行程表对象
	 */		
	
	public Object getModel() {
		return segmentinfo;
	}
	public List < Segmentinfo >   getListSegmentinfo() {
		return listSegmentinfo;
	}
	public void setListSegmentinfo(List <  Segmentinfo  >  listSegmentinfo) {
		this.listSegmentinfo = listSegmentinfo;
	}
	public Segmentinfo getSegmentinfo() {
		return segmentinfo;
	}
	public void setSegmentinfo(Segmentinfo segmentinfo) {
		this.segmentinfo = segmentinfo;
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