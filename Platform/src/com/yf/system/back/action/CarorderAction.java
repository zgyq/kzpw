/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.text.SimpleDateFormat;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.city.City;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;


public class CarorderAction extends B2b2cbackAction {
	private List <  Carorder  >  listCarorder;
	private Carorder carorder = new Carorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private List <City> listCities ;
	private List<Customeragent> listCustomeragent;
	private int orderstate;
	private long h_angent;
	//search
	private String s_name;
	private String ordercode;
	private String c_username;
	
	private int s_type=0;
	
	//预订的开始时间
	private String h_prestarttime ;
	
	//预订的结束时间
	private String h_preendtime ;
	private long longtype;
	
	private long C_ScityId;
	
	private long C_EcityId;
	/**
	 * 列表查询租车订单
	 */	
	public String execute()throws Exception{
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_type+" =2", "ORDER BY " + City.COL_sort, -1, 0) ;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		/*if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}*/
		
		
		String where = " where 1=1 ";
		List<Sysconfig>listsys=Server.getInstance().getSystemService().findAllSysconfig(" where 1=1 and "+Sysconfig.COL_name+" ='agentid'", "", -1, 0);
		
		if(getLoginUser().getAgentid()==46){//龙泰得员工
			longtype=0;
			
			where+=" ";
			
			if(h_angent>0){//
				
				where+=" and "+Carorder.COL_memberid+" in ( select "+Customeruser.COL_id+" from "+Customeruser.TABLE+" where 1=1 and "+Customeruser.COL_agentid+" ="+h_angent+")";
							
			}
		
			listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 ", " ORDER BY ID DESC ", -1, 0);

		
			
		}else{
			longtype=1;
		where+=" and "+Carorder.COL_memberid+" in ( select "+Customeruser.COL_id+" from "+Customeruser.TABLE+" where 1=1 and "+Customeruser.COL_agentid+" ="+getLoginUser().getAgentid()+")";
		listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 AND "+Customeragent.COL_parentid+" ="+getLoginUser().getAgentid(), " ORDER BY ID DESC ", -1, 0);
		
		
		}
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Carorder.COL_carname +" like '%" + s_name.trim()+"%'";	
		}
		if (c_username!=null && c_username.trim().length()!=0) {
			
			where += " and " + Carorder.COL_linkname +" like '%" + c_username.trim()+"%'";	
		}
		if (ordercode!=null && ordercode.trim().length()!=0) {
			
			where += " and " + Carorder.COL_code +" like '%" + ordercode.trim()+"%'";	
		}
		if(s_type>0){
			
			where +=" and "+Carorder.COL_property+" ='"+s_type+"'";
		}
		if(C_ScityId>0){
			
			where +=" and "+Carorder.COL_scityid+" ='"+C_ScityId+"'";
		}
		if(C_EcityId>0){
			
			where +=" and "+Carorder.COL_endcityid+" ='"+C_EcityId+"'";
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where +=" AND " + Carorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')" ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where +=" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')";
		}
		
		System.out.println("where="+where);
	    List list = Server.getInstance().getCarService().findAllCarorderForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCarorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listCarorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getCarService().findAllCarorderForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCarorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到租车订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到租车订单修改页面
	 */	
	public String toedit()throws Exception{
	carorder = Server.getInstance().getCarService().findCarorder(carorder.getId());
		return EDIT;
	}
	public String toinfo()throws Exception{
		carorder = Server.getInstance().getCarService().findCarorder(carorder.getId());
			return "info";
		}
	/**
	 * 转向到租车订单审核页面
	 */	
	public String tocheck()throws Exception{
	carorder = Server.getInstance().getCarService().findCarorder(carorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加租车订单
	 */		
	public String add()throws Exception{
		
		
		Server.getInstance().getCarService().createCarorder(carorder);
		
		carorder.setCode(Server.getInstance().getServiceCenter().getCarOrderCode(carorder));
		Server.getInstance().getCarService().updateCarorderIgnoreNull(carorder);
		return LIST;
	}

	/**
	 * 审核租车订单
	 */		
	public String check()throws Exception{
		carorder=Server.getInstance().getCarService().findCarorder(carorder.getId());
		
		if(orderstate==5){//取消订单
			if(carorder.getWaicode()!=null&&carorder.getWaicode().length()>0&&!carorder.getWaicode().equals("NOCODE")){
			String code=Server.getInstance().getYiHaiCarService().cancelorder(carorder.getWaicode());
				if(code.equals("OK")){//取消成功
					
					carorder.setState(5);
				}
			}
			
		}
		carorder.setState(orderstate);
		Server.getInstance().getCarService().updateCarorderIgnoreNull(carorder);
		return LIST;
	}
	


	/**
	 * 编辑租车订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getCarService().updateCarorderIgnoreNull(carorder);
		return LIST;
	}

	/**
	 * 删除租车订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getCarService().deleteCarorder(carorder.getId());
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
					Server.getInstance().getCarService().deleteCarorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回租车订单对象
	 */		
	
	public Object getModel() {
		return carorder;
	}
	public List < Carorder >   getListCarorder() {
		return listCarorder;
	}
	public void setListCarorder(List <  Carorder  >  listCarorder) {
		this.listCarorder = listCarorder;
	}
	public Carorder getCarorder() {
		return carorder;
	}
	public void setCarorder(Carorder carorder) {
		this.carorder = carorder;
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
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getC_username() {
		return c_username;
	}
	public void setC_username(String c_username) {
		this.c_username = c_username;
	}
	public int getS_type() {
		return s_type;
	}
	public void setS_type(int s_type) {
		this.s_type = s_type;
	}
	public String getH_prestarttime() {
		return h_prestarttime;
	}
	public void setH_prestarttime(String h_prestarttime) {
		this.h_prestarttime = h_prestarttime;
	}
	public String getH_preendtime() {
		return h_preendtime;
	}
	public void setH_preendtime(String h_preendtime) {
		this.h_preendtime = h_preendtime;
	}
	public long getLongtype() {
		return longtype;
	}
	public void setLongtype(long longtype) {
		this.longtype = longtype;
	}
	public List<City> getListCities() {
		return listCities;
	}
	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}
	public long getC_ScityId() {
		return C_ScityId;
	}
	public void setC_ScityId(long scityId) {
		C_ScityId = scityId;
	}
	public long getC_EcityId() {
		return C_EcityId;
	}
	public void setC_EcityId(long ecityId) {
		C_EcityId = ecityId;
	}
	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}
	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}
	public long getH_angent() {
		return h_angent;
	}
	public void setH_angent(long h_angent) {
		this.h_angent = h_angent;
	}
	
	
}