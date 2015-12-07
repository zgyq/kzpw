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
import com.yf.system.base.hotelfan.Hotelfan;


public class HotelfanAction extends B2b2cbackAction {
	private List <  Hotelfan  >  listHotelfan;
	private Hotelfan hotelfan = new Hotelfan();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_starttime;
	private String s_endtime;
	private String s_hotelid;
	private Double s_startprice;
	private Double s_endprice;
	private String s_fan;
	private Long s_ifvoucher;
	/**
	 * 列表查询酒店设置返点表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Hotelfan.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getHotelService().findAllHotelfanForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHotelfan = list;
		  if(pageinfo.getTotalrow()>0 &&   listHotelfan.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelfanForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listHotelfan = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店设置返点表添加页面
	 */	
	public String toadd()throws Exception{
		
		return EDIT;
	}
	/**
	 * 转向到酒店设置返点表修改页面
	 */	
	public String toedit()throws Exception{
	hotelfan = Server.getInstance().getHotelService().findHotelfan(hotelfan.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店设置返点表审核页面
	 */	
	public String tocheck()throws Exception{
	hotelfan = Server.getInstance().getHotelService().findHotelfan(hotelfan.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加酒店设置返点表
	 */		
	public String add()throws Exception{
		if(s_hotelid!=null && s_hotelid.length()>0){
			String[] listhotelid=s_hotelid.toString().trim().split(",");
			for(int i=0;i<listhotelid.length;i++){
		if(listhotelid[i]!=null && !listhotelid[i].toString().equals(" "))
				{
			Hotelfan hotelfan = new Hotelfan();
			hotelfan.setCreatetime(new Timestamp(System.currentTimeMillis()));
			hotelfan.setStatus(1);
			hotelfan.setIfvoucher(s_ifvoucher);
			hotelfan.setStartprice(s_startprice);
			hotelfan.setEndprice(s_endprice);
			hotelfan.setFan(s_fan);
			hotelfan.setHotelid(Long.parseLong(listhotelid[i].trim()));
			hotelfan.setMemberid(getLoginUser().getId());
			hotelfan.setStarttime(dateToTimestamp(s_starttime));
			hotelfan.setEndtime(dateToTimestamp(s_endtime));
			Server.getInstance().getHotelService().createHotelfan(hotelfan);
				}
			}
		}
		return LIST;
	}

	/**
	 * 审核酒店设置返点表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelfanIgnoreNull(hotelfan);
		return LIST;
	}
	


	/**
	 * 编辑酒店设置返点表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelfanIgnoreNull(hotelfan);
		return LIST;
	}

	/**
	 * 删除酒店设置返点表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotelfan(hotelfan.getId());
		return "ok";
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
					Server.getInstance().getHotelService().deleteHotelfan(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return "ok";
	}






	/**
	 *  返回酒店设置返点表对象
	 */		
	
	public Object getModel() {
		return hotelfan;
	}
	public List < Hotelfan >   getListHotelfan() {
		return listHotelfan;
	}
	public void setListHotelfan(List <  Hotelfan  >  listHotelfan) {
		this.listHotelfan = listHotelfan;
	}
	public Hotelfan getHotelfan() {
		return hotelfan;
	}
	public void setHotelfan(Hotelfan hotelfan) {
		this.hotelfan = hotelfan;
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
	public String getS_starttime() {
		return s_starttime;
	}
	public void setS_starttime(String s_starttime) {
		this.s_starttime = s_starttime;
	}
	public String getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}
	public String getS_hotelid() {
		return s_hotelid;
	}
	public void setS_hotelid(String s_hotelid) {
		this.s_hotelid = s_hotelid;
	}
	public Double getS_startprice() {
		return s_startprice;
	}
	public void setS_startprice(Double s_startprice) {
		this.s_startprice = s_startprice;
	}
	public Double getS_endprice() {
		return s_endprice;
	}
	public void setS_endprice(Double s_endprice) {
		this.s_endprice = s_endprice;
	}
	public String getS_fan() {
		return s_fan;
	}
	public void setS_fan(String s_fan) {
		this.s_fan = s_fan;
	}
	public Long getS_ifvoucher() {
		return s_ifvoucher;
	}
	public void setS_ifvoucher(Long s_ifvoucher) {
		this.s_ifvoucher = s_ifvoucher;
	}
	
	
}