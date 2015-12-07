/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.kweifabu.Kweifabu;


public class KweifabuAction extends B2b2cbackAction {
	private List <  Kweifabu  >  listKweifabu;
	private Kweifabu kweifabu = new Kweifabu();
	private List <  Aircompany  >  listAircompany;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private String starttime2;
	
	/**
	 * 列表查询K位特价发布表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Kweifabu.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllKweifabuForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listKweifabu = list;
		  if(pageinfo.getTotalrow()>0 &&   listKweifabu.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllKweifabuForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listKweifabu = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 列表查询K位特价发布表
	 */	
	public String tomy()throws Exception{
		String where = " where 1=1 and "+Kweifabu.COL_angenid+" ="+getLoginUser().getAgentid();
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Kweifabu.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllKweifabuForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listKweifabu = list;
		  if(pageinfo.getTotalrow()>0 &&   listKweifabu.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllKweifabuForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listKweifabu = list;
		}
		
		return "tomy";
	}
	/**
	 * 转向到K位特价发布表添加页面
	 */	
	public String toadd()throws Exception{
		listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
		
		return EDIT;
	}
	/**
	 * 转向到K位特价发布表修改页面
	 */	
	public String toedit()throws Exception{
		listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
		
	kweifabu = Server.getInstance().getAirService().findKweifabu(kweifabu.getId());
		return EDIT;
	}
	
	/**
	 * 转向到K位特价发布表审核页面
	 */	
	public String tocheck()throws Exception{
	kweifabu = Server.getInstance().getAirService().findKweifabu(kweifabu.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加K位特价发布表
	 */		
	public String add()throws Exception{
		java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(starttime2);
		kweifabu.setStarttime(new Timestamp(date.getTime()));
		
		kweifabu.setCreatetime(new Timestamp(System.currentTimeMillis()));
		kweifabu.setCreateuser(getLoginUser().getLoginname());
		kweifabu.setAngenid(getLoginUser().getAgentid());
		Server.getInstance().getAirService().createKweifabu(kweifabu);
		return LIST;
	}

	/**
	 * 审核K位特价发布表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateKweifabuIgnoreNull(kweifabu);
		return LIST;
	}
	


	/**
	 * 编辑K位特价发布表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateKweifabuIgnoreNull(kweifabu);
		return LIST;
	}

	/**
	 * 删除K位特价发布表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteKweifabu(kweifabu.getId());
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
					Server.getInstance().getAirService().deleteKweifabu(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回K位特价发布表对象
	 */		
	
	public Object getModel() {
		return kweifabu;
	}
	public List < Kweifabu >   getListKweifabu() {
		return listKweifabu;
	}
	public void setListKweifabu(List <  Kweifabu  >  listKweifabu) {
		this.listKweifabu = listKweifabu;
	}
	public Kweifabu getKweifabu() {
		return kweifabu;
	}
	public void setKweifabu(Kweifabu kweifabu) {
		this.kweifabu = kweifabu;
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
	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}
	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}
	public String getStarttime2() {
		return starttime2;
	}
	public void setStarttime2(String starttime2) {
		this.starttime2 = starttime2;
	}
	
	
}