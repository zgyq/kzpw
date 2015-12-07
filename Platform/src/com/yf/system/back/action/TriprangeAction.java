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
import com.yf.system.base.scenicspot.Scenicspot;
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.triprange.Triprange;
import com.yf.system.base.triprangescenicspot.Triprangescenicspot;
import com.yf.system.base.util.PageInfo;


public class TriprangeAction extends B2b2cbackAction {
	private static final long serialVersionUID = 7269934980224177042L;
	private List <  Triprange  >  listTriprange;
	private Triprange triprange = new Triprange();
	private List<Tripline> listTripline;
	private List<Scenicspot> listScenicspot;
	private String s_Jingdianinfo;
	private String s_triplinename;
	private String s_triprangename;
	
	// 批量操作ID数组
	private int[]selectid;
	
	// 批量操作选项
	private int opt;
	
	// search
	// private String s_name;
	
	
	/**
	 * 列表查询行程
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		 if (s_triplinename!=null && s_triplinename.trim().length()!=0) {
			
			 where += " and " + Tripline.COL_name +" like '%" +
			 s_triplinename.trim()+"%'";
		 }
		
	    List<Tripline> listtripline=Server.getInstance().getTripService().findAllTripline(where, "", -1, 0);
	    String strIDs="";
	    for(Tripline tripline:listtripline)
	    {
	    	strIDs+=tripline.getId()+",";
	    }
	   
	    String strwhere=" Where 1=1 and "+Triprange.COL_triplineid+" in("+strIDs.substring(0, strIDs.length()-1)+")";
	    if(s_triprangename!=null && s_triprangename.trim().length()!=0)
		 {
	    	strwhere+=" and "+Triprange.COL_name+" like '%"+s_triprangename+"%'";
		 }
	    List list = Server.getInstance().getTripService().findAllTriprangeForPageinfo(strwhere," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTriprange = list;
		  if(pageinfo.getTotalrow()>0 &&   listTriprange.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTriprangeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTriprange = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到行程添加页面
	 */	
	public String toadd()throws Exception{
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		listScenicspot=Server.getInstance().getTripService().findAllScenicspot("where 1=1", "ORDER BY ID", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到行程修改页面
	 */	
	public String toedit()throws Exception{
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		listScenicspot=Server.getInstance().getTripService().findAllScenicspot("where 1=1", "ORDER BY ID", -1, 0);
		triprange = Server.getInstance().getTripService().findTriprange(triprange.getId());
		
		return EDIT;
	}
	
	/**
	 * 转向到行程审核页面
	 */	
	public String tocheck()throws Exception{
		triprange = Server.getInstance().getTripService().findTriprange(triprange.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加行程
	 */		
	public String add()throws Exception{
		triprange.setCreateuser(getLoginUser().getLoginname());
		triprange.setCreatetime(new Timestamp(System.currentTimeMillis()));
		triprange.setModifyuser(getLoginUser().getLoginname());
		triprange.setModifytime(new Timestamp(System.currentTimeMillis()));
		triprange = Server.getInstance().getTripService().createTriprange(triprange);
		Triprangescenicspot triprangescenicspot=new Triprangescenicspot();
		String[] arrayjingdian=s_Jingdianinfo.split(",");
		for(int i=0;i<arrayjingdian.length;i++)
		{
			long lid=Long.parseLong(arrayjingdian[i].trim());
			triprangescenicspot.setScenicspotid(lid);
			triprangescenicspot.setTriprangeid(triprange.getId());
			triprangescenicspot.setLanguage(0);
			triprangescenicspot.setUcode(triprange.getId());
			Server.getInstance().getTripService().createTriprangescenicspot(triprangescenicspot);
		}
		listScenicspot=Server.getInstance().getTripService().findAllScenicspot("where 1=1", "ORDER BY ID", -1, 0);
		this.addActionMessage("您的作已成功！");
		return EDIT;
	}

	/**
	 * 审核行程
	 */		
	public String check()throws Exception{
		triprange.setModifyuser(getLoginUser().getLoginname());
		triprange.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriprangeIgnoreNull(triprange);
		return LIST;
	}
	


	/**
	 * 编辑行程
	 */		
	public String edit()throws Exception{
		triprange.setModifyuser(getLoginUser().getLoginname());
		triprange.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriprangeIgnoreNull(triprange);
		
		Triprangescenicspot triprangescenicspot=new Triprangescenicspot();
		String[] arrayjingdian=s_Jingdianinfo.split(",");
		for(int i=0;i<arrayjingdian.length;i++)
		{
			long lid=Long.parseLong(arrayjingdian[i].trim());
			triprangescenicspot.setScenicspotid(lid);
			triprangescenicspot.setTriprangeid(triprange.getId());
			Server.getInstance().getTripService().updateTriprangescenicspotIgnoreNull(triprangescenicspot);
		}
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 删除行程
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTriprange(triprange.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: // delete
				
				for(int i:selectid){
					Server.getInstance().getTripService().deleteTriprange(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	public String toeditlanguage()throws Exception{
		Integer lan=triprange.getLanguage();
		Long uco=triprange.getUcode();
		// 调用此方法时需在service项目中对应的service添加方法
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		listScenicspot=Server.getInstance().getTripService().findAllScenicspot("where 1=1", "ORDER BY ID", -1, 0);
		triprange = Server.getInstance().getTripService().findTriprangebylanguage(triprange.getUcode(),triprange.getLanguage());
		listTripline = Server.getInstance().getTripService().findAllTripline("where 1=1", "ORDER BY ID", -1, 0);
		if(triprange==null)
		{
			triprange=new Triprange();
			triprange.setLanguage(lan);
			triprange.setUcode(uco);
			// 以下是toadd参考方法
		}else
		{
			// 以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象
			// else可以不写
		}
		return EDIT;
	}
	
	/**
	 * 根据路线路Id获取线路名称
	 * @param triplineId
	 * @return
	 */
	public String getTriplineNameByID(long triplineId) {
		Tripline tp = Server.getInstance().getTripService().findTripline(triplineId);
		return tp != null ? tp.getName() : "";
	}




	/**
	 * 返回行程对象
	 */		
	
	public Object getModel() {
		return triprange;
	}
	public List < Triprange >   getListTriprange() {
		return listTriprange;
	}
	public void setListTriprange(List <  Triprange  >  listTriprange) {
		this.listTriprange = listTriprange;
	}
	public Triprange getTriprange() {
		return triprange;
	}
	public void setTriprange(Triprange triprange) {
		this.triprange = triprange;
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
	public List<Scenicspot> getListScenicspot() {
		return listScenicspot;
	}
	public void setListScenicspot(List<Scenicspot> listScenicspot) {
		this.listScenicspot = listScenicspot;
	}
	public String getS_Jingdianinfo() {
		return s_Jingdianinfo;
	}
	public void setS_Jingdianinfo(String jingdianinfo) {
		s_Jingdianinfo = jingdianinfo;
	}
	public String getS_triplinename() {
		return s_triplinename;
	}
	public void setS_triplinename(String s_triplinename) {
		this.s_triplinename = s_triplinename;
	}
	public String getS_triprangename() {
		return s_triprangename;
	}
	public void setS_triprangename(String s_triprangename) {
		this.s_triprangename = s_triprangename;
	}
	
	
}