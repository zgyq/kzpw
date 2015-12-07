/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.HashMap;
import java.util.List;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.scang.Scang;
import com.yf.system.base.segmentinfo.Segmentinfo;


public class ScangAction extends B2b2cbackAction {
	private List <  Scang  >  listScang;
	private Scang scang = new Scang();
	private Orderinfo orderinfo = new Orderinfo();
	private List < Passenger  >  listPassenger;
	//批量操作ID数组
	private int[]selectid;
	//private int[] pa;
	
	//批量操作选项
	private int opt;
	private int orderinfoid;
	
	
	private long scangid;
	//search
	private String passid;
	private String forword;
	
	
	/**
	 * 列表查询订单升舱表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Scang.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
		if(orderinfoid>0){
			where+=" AND "+Scang.COL_orderid+" ="+orderinfoid;
		}
	    List list = Server.getInstance().getAirService().findAllScangForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listScang = list;
		  if(pageinfo.getTotalrow()>0 &&   listScang.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllScangForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listScang = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到订单升舱表添加页面
	 */	
	public String toadd()throws Exception{
		listPassenger = Server.getInstance().getAirService().findAllPassenger("where 1=1 and "+Passenger.COL_orderid+" ="+orderinfoid, "", -1, 0);
	
		orderinfo = Server.getInstance().getAirService().findOrderinfo(orderinfoid);
		return EDIT;
	}
	/**
	 * 转向到订单升舱表修改页面
	 */	
	public String toedit()throws Exception{
	scang = Server.getInstance().getAirService().findScang(scang.getId());
	orderinfo = Server.getInstance().getAirService().findOrderinfo(scang.getOrderid());
		return EDIT;
	}
	
	/**
	 * 转向到订单升舱表审核页面
	 */	
	public String tocheck()throws Exception{
	scang = Server.getInstance().getAirService().findScang(scang.getId());
		return CHECK;
	}
	
	public String topay()throws Exception{
		orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfoid);
			scang = Server.getInstance().getAirService().findScang(scangid);
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("billname", "Airpayhelper");// 对应接口中 支付辅助类 必传
			map.put("orderid", orderinfo.getId());// 订单id 必传
			map.put("scangid", scangid);// 订单id 必传
			
			map.put("orderprice", scang.getPrice());
			request.setAttribute("ordermap", map);// 传值....
			
			
			return "topay";
		}
	
	public long getScangid() {
		return scangid;
	}
	public void setScangid(long scangid) {
		this.scangid = scangid;
	}
	/**
	 * 添加订单升舱表
	 */		
	public String add_old()throws Exception{
		if(passid!=null && passid.trim().length()>0){
			//String pass = scang.getPassengerid().toString();
			String []pa=passid.trim().split(",");
			for(int a=0;a<pa.length;a++){
				scang.setPassengerid(Long.parseLong(pa[a].trim()));
				scang.setCreatetime(new Timestamp(System.currentTimeMillis()));
				scang.setApplyid(getLoginUserId());
				scang.setStatus(1l);//1,提出升舱/换开申请  2,升舱待支付差价   3,支付成功  4,支付失败  5,升舱成功  6,升舱失败 7，换开待支付.8。换开成功 9，换开失败
				Server.getInstance().getAirService().createScang(scang);
			}
			Orderinfo order = Server.getInstance().getAirService().findOrderinfo(scang.getOrderid());
			order.setOrderstatus(23);//23为申请升舱
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(order);
		}
		forword="orderinfo.action";
		return "add";
	}
	/**
	 * 添加订单升舱表
	 */		
	public String add()throws Exception{
		
				
				scang.setCreatetime(new Timestamp(System.currentTimeMillis()));
				scang.setApplyid(getLoginUserId());
				scang.setStatus(1l);//1,提出升舱/换开申请  2,升舱待支付差价   3,支付成功  4,支付失败  5,升舱成功  6,升舱失败 7，换开待支付.8。换开成功 9，换开失败
				Server.getInstance().getAirService().createScang(scang);
			
				
		return this.execute();
	}
	public String addprice()throws Exception{
		scang.setPrice(scang.getPrice());
		
		scang.setStatus(2l);
		
			
		
		//scang.setCreatetime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getAirService().updateScangIgnoreNull(scang);
		
		forword ="orderinfo!toshengcang.action?s_orderstatus=23";
		return "addprice";
	}
	public String huankai()throws Exception{//换开
		//scang.setPrice(scang.getPrice());
		
		scang.setStatus(7l);
		scang.setNewpnr(scang.getNewpnr());
			
		
		//scang.setCreatetime(new Timestamp(System.currentTimeMillis()));
	 Server.getInstance().getAirService().updateScangIgnoreNull(scang);
	 scang = Server.getInstance().getAirService().findScang(scang.getId());
	//	forword ="orderinfo!toshengcang.action?s_orderstatus=23";
		return "huankai";
	}
	/**
	 * 审核订单升舱表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateScangIgnoreNull(scang);
		return LIST;
	}
	


	/**
	 * 编辑订单升舱表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateScangIgnoreNull(scang);
		return LIST;
	}

	/**
	 * 删除订单升舱表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteScang(scang.getId());
		return LIST;
	}

	public String gethangban(long id) {//取航班号
		List<Segmentinfo>list = Server.getInstance().getAirService().findAllSegmentinfo("where 1=1 and "+Segmentinfo.COL_orderid+" ="+id, "", -1, 0);
			if(list.size()>0&&list.get(0).getFlightnumber()!=null){
				return list.get(0).getFlightnumber();
			
		}else{
			return "";
		}
	}
	public String getcangwei(long orderid) {//取舱位
		List<Segmentinfo>list = Server.getInstance().getAirService().findAllSegmentinfo("where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderid, "", -1, 0);
		if(list.size()>0){
			return list.get(0).getCabincode();
		}else{
			return "";
		}
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
					Server.getInstance().getAirService().deleteScang(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回订单升舱表对象
	 */		
	
	public Object getModel() {
		return scang;
	}
	public List < Scang >   getListScang() {
		return listScang;
	}
	public void setListScang(List <  Scang  >  listScang) {
		this.listScang = listScang;
	}
	public Scang getScang() {
		return scang;
	}
	public void setScang(Scang scang) {
		this.scang = scang;
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
	public List<Passenger> getListPassenger() {
		return listPassenger;
	}
	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}
	public int getOrderinfoid() {
		return orderinfoid;
	}
	public void setOrderinfoid(int orderinfoid) {
		this.orderinfoid = orderinfoid;
	}
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}
	public String getPassid() {
		return passid;
	}
	public void setPassid(String passid) {
		this.passid = passid;
	}
	public String getForword() {
		return forword;
	}
	public void setForword(String forword) {
		this.forword = forword;
	}

	
	
}