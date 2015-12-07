/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.supteam.Supteam;


public class SupteamAction extends B2b2cbackAction {
	private List <  Supteam  >  listSupteam;
	private Supteam supteam = new Supteam();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询团队申请报价表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Supteam.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllSupteamForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSupteam = list;
		  if(pageinfo.getTotalrow()>0 &&   listSupteam.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllSupteamForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSupteam = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到团队申请报价表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到团队申请报价表修改页面
	 */	
	public String toedit()throws Exception{
	supteam = Server.getInstance().getAirService().findSupteam(supteam.getId());
		return EDIT;
	}
	
	/**
	 * 转向到团队申请报价表审核页面
	 */	
	public String tocheck()throws Exception{
	supteam = Server.getInstance().getAirService().findSupteam(supteam.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加团队申请报价表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createSupteam(supteam);
		return LIST;
	}
	/**
	 * 添加团队申请报价表
	 */		
	public String addsup()throws Exception{
			List<Supteam>listsupteam = Server.getInstance().getAirService().findAllSupteam("where 1=1 and "+Supteam.COL_supplierid+" ="+getLoginUser().getAgentid()+" and "+Supteam.COL_teamid+" ="+supteam.getTeamid(), "", -1, 0);
		if(listsupteam.size()!=0){
			Supteam	supteam2 = new Supteam();
			supteam2 = listsupteam.get(0);
			supteam2.setOffer(supteam.getOffer());
			supteam2.setCreatetime(new Timestamp(System.currentTimeMillis()));
			Server.getInstance().getAirService().updateSupteamIgnoreNull(supteam2);
			
		}else{
		supteam.setStatus(0l);//0,供应商刚刚创建  1.分销商选中
		supteam.setSupplierid(getLoginUser().getAgentid());
		supteam.setCreatetime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getAirService().createSupteam(supteam);
		}
		return "addsup";
	}

	/**
	 * 审核团队申请报价表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateSupteamIgnoreNull(supteam);
		return LIST;
	}
	


	/**
	 * 编辑团队申请报价表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateSupteamIgnoreNull(supteam);
		return LIST;
	}

	/**
	 * 删除团队申请报价表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteSupteam(supteam.getId());
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
					Server.getInstance().getAirService().deleteSupteam(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回团队申请报价表对象
	 */		
	
	public Object getModel() {
		return supteam;
	}
	public List < Supteam >   getListSupteam() {
		return listSupteam;
	}
	public void setListSupteam(List <  Supteam  >  listSupteam) {
		this.listSupteam = listSupteam;
	}
	public Supteam getSupteam() {
		return supteam;
	}
	public void setSupteam(Supteam supteam) {
		this.supteam = supteam;
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