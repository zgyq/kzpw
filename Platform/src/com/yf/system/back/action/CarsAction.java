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
import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.cars.Cars;
import com.yf.system.base.carstore.Carstore;
import com.yf.system.base.city.City;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.util.PageInfo;


public class CarsAction extends B2b2cbackAction {
	private List <  Cars  >  listCars;
	private List <  City  >  listCity;
	private List <  Carstore  >  listCarstore;
	private Cars cars = new Cars();
	
	//批量操作ID数组
	private int[]selectid;
	private long longtype;
	//批量操作选项
	private int opt;
	private long C_ScityId;
	//search
	private String s_name;
	private String c_markettime;//上市日期
	
	//book_car
	
	private String cartype;//车型
	private String car_num;//大小
	private String qu_typw;//取车类型
	private String car_name;//车品牌
	private String linkname;//联系人
	private String linktel;//联系号码
	private String s_dizhi;//用车地址
	private String s_day;//用车时间
	private String s_num;//用车周期
	private String s_desc;//备注
	private List <  Carorder  >  listCarorder;
	/**
	 * 在线租车
	 */		
	public String book_car()throws Exception{
		Carorder carorder=new Carorder();
		carorder.setLinkname(linkname);
		carorder.setLinktell(linktel);
		carorder.setLinkmail(s_dizhi);
		carorder.setSpecreq(s_desc);
		carorder.setCode(cartype);
		carorder.setManyday(Integer.parseInt(s_num));
		carorder.setSdate(s_day);
		carorder.setCarname(car_name);
		carorder.setProperty(qu_typw);//取车类型
		carorder.setCarcode(car_num);//大小
		carorder.setPretime(new Timestamp(System.currentTimeMillis()));
		carorder.setMemberid(getLoginUser().getId());
		carorder.setCarid(getLoginUser().getAgentid());
		Server.getInstance().getCarService().createCarorder(carorder);
		return this.car_new();
	}
	
	public String car_new()throws Exception{
	String where=" where 1=1 ";
	if(getLoginUser().getAgentid()!=46){
		where+=" AND "+Carorder.COL_carid+" ="+getLoginUser().getAgentid();
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
	  return "car_new";
	}
	
	/**
	 * 列表查询汽车
	 */	
	public String execute()throws Exception{
		//查询所有的城市
		listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_type+" =2", "ORDER BY " + City.COL_sort, -1, 0) ;
	
		
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Cars.COL_name +" like '%" + s_name.trim()+"%'";	
		}
		if(C_ScityId>0){
			
			where +=" and "+Cars.COL_cityid+" ='"+C_ScityId+"'";
		}
	
	    List list = Server.getInstance().getCarService().findAllCarsForPageinfo(where," ORDER BY ID DESC",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCars = list;
		  if(pageinfo.getTotalrow()>0 &&   listCars.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getCarService().findAllCarsForPageinfo(where," ORDER BY ID DESC",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCars = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到汽车添加页面
	 */	
	public String toadd()throws Exception{
		listCity=Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_language+" =0", "", -1, 0);
		listCarstore=Server.getInstance().getCarService().findAllCarstore(" where 1=1 ", "", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到汽车修改页面
	 */	
	public String toedit()throws Exception{
		listCity=Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_language+" =0", "", -1, 0);
	cars = Server.getInstance().getCarService().findCars(cars.getId());
		return EDIT;
	}
	
	/**
	 * 转向到汽车审核页面
	 */	
	public String tocheck()throws Exception{
	cars = Server.getInstance().getCarService().findCars(cars.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加汽车
	 */		
	public String add()throws Exception{
		cars.setCreatetime(new Timestamp(System.currentTimeMillis()));
		cars.setCreateuser(getLoginUser().getLoginname());
		//cars.setMarkettime(dateToTimestamp(c_markettime));
		Server.getInstance().getCarService().createCars(cars);
		return LIST;
	}


	

	
	/**
	 * 审核汽车
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getCarService().updateCarsIgnoreNull(cars);
		return LIST;
	}
	
	

	/**
	 * 编辑汽车
	 */		
	public String edit()throws Exception{
		//cars.setMarkettime(dateToTimestamp(c_markettime));
		Server.getInstance().getCarService().updateCarsIgnoreNull(cars);
		return LIST;
	}

	/**
	 * 删除汽车
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getCarService().deleteCars(cars.getId());
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
					Server.getInstance().getCarService().deleteCars(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回汽车对象
	 */		
	
	public Object getModel() {
		return cars;
	}
	public List < Cars >   getListCars() {
		return listCars;
	}
	public void setListCars(List <  Cars  >  listCars) {
		this.listCars = listCars;
	}
	public Cars getCars() {
		return cars;
	}
	public void setCars(Cars cars) {
		this.cars = cars;
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
	public List<City> getListCity() {
		return listCity;
	}
	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}
	public String getC_markettime() {
		return c_markettime;
	}
	public void setC_markettime(String c_markettime) {
		this.c_markettime = c_markettime;
	}
	public List<Carstore> getListCarstore() {
		return listCarstore;
	}
	public void setListCarstore(List<Carstore> listCarstore) {
		this.listCarstore = listCarstore;
	}
	public long getLongtype() {
		return longtype;
	}
	public void setLongtype(long longtype) {
		this.longtype = longtype;
	}
	public long getC_ScityId() {
		return C_ScityId;
	}
	public void setC_ScityId(long scityId) {
		C_ScityId = scityId;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCar_num() {
		return car_num;
	}
	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}
	public String getQu_typw() {
		return qu_typw;
	}
	public void setQu_typw(String qu_typw) {
		this.qu_typw = qu_typw;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getLinktel() {
		return linktel;
	}
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}
	public String getS_dizhi() {
		return s_dizhi;
	}
	public void setS_dizhi(String s_dizhi) {
		this.s_dizhi = s_dizhi;
	}
	public String getS_day() {
		return s_day;
	}
	public void setS_day(String s_day) {
		this.s_day = s_day;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_desc() {
		return s_desc;
	}
	public void setS_desc(String s_desc) {
		this.s_desc = s_desc;
	}
	public List<Carorder> getListCarorder() {
		return listCarorder;
	}
	public void setListCarorder(List<Carorder> listCarorder) {
		this.listCarorder = listCarorder;
	}
	
}