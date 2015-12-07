/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */

package com.yf.system.back.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.country.Country;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotellandmark.Hotellandmark;
import com.yf.system.base.hotellinkman.Hotellinkman;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.hotelspec.Hotelspec;
import com.yf.system.base.incity.Incity;
import com.yf.system.base.landmark.Landmark;
import com.yf.system.base.province.Province;
import com.yf.system.base.region.Region;
import com.yf.system.base.roomstate.Roomstate;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.util.Ajax;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class HotelAction extends B2b2cbackAction {
	private List list;
	private List listHotel = new ArrayList();
	private String couid;//国家ID
	
	//国家
	private List<Country> listCountry; 
	//国际城市
	private List<Incity> listIncity; 
	
	private Hotel hotel = new Hotel();
	private List<Customeragent> listCustomeragent;
	private List listHotelprice = new ArrayList();
	// 上传文件的路径
	private String path;
	// 文件上传状态
	private int f_state;
	private int checkrad;
	private long cityid2;
	private int lan;
	private int uco;
	//批量用字段
	private String hotelid;
	//
	//报表所用的字段
	private int s_name;
	private Long cityId;
	private String hotelname;
	private String statetime;
	private String endtime;
	private String sell;//卖点
	private long pai;//排序
	private String iszhutui;
	private String hoteltype;//推荐级别
	private String hotelorderstate;//订单状态
	private List <Hotelorder> listHotelorder;
	private List <Guest> listGuest;
	//
	private int jianye;
	private double zongjia;
	// 酒店联系人清单
	private List<Hotellinkman> listHotellinkman = new ArrayList<Hotellinkman>();
	private Hotellinkman hotellinkman = new Hotellinkman();
	// 酒店注意事项
	private Hotelspec hotelspec = new Hotelspec();
	private List<Hotelspec> listhotelspec = new ArrayList<Hotelspec>();
	// 酒店地标
	private Hotellandmark hotellandmark = new Hotellandmark();
	private List<Hotellandmark> listhotellandmark = new ArrayList<Hotellandmark>();
	// 酒店房态
	private Roomstate roomstate = new Roomstate();
	private List<Roomstate> listroomstate = new ArrayList<Roomstate>();
	// 地区
	private List<Region> regionlist = new ArrayList<Region>();
	private Region region = new Region();
	// 所有的省
	private List<Province> listProvinces = new ArrayList<Province>();

	// 所有的市
	private List<City> listCities = new ArrayList<City>();
	private List<City> listinCities = new ArrayList<City>();

	// 地标
	private List<Landmark> lmarks = new ArrayList<Landmark>();
	// 酒店房型
	private List<Roomtype> roomtypes = new ArrayList<Roomtype>();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	//
	Hotelprice hotelprice = new Hotelprice();

	//
	private List<Roomtype> listRoomtype = new ArrayList<Roomtype>();

	//
	private String[] showPrices;

	//
	private Roomtype roomtype = new Roomtype();

	// search
	private String h_hotelname; // 酒店中文名称

	private Integer h_provinceId; // 所在的省

	private Integer h_cityId; // 所在的市

	private String h_enname; // 酒店的英文名称

	private Integer h_star; // 酒店星级

	private Integer h_repair; // 装修级别

	private Integer h_type; // 酒店的类型

	private Integer h_state; // 酒店的状态
	
	private Integer h_laiyuan; // 酒店的来源  1,芒果 2,经纪人签约
	
	private Integer h_recommend; // 推荐的级别

	private String[] cardType;// 卡类型

	private String[] serviceItem;// 服务项目

	private String[] eatery;// 餐饮设施

	private String[] playItem; // 娱乐设施

	private Long hotelId; // 酒店的ID
	private Long hid; // 酒店的ID

	private String[] webSign;

	private String checkdescStr;

	// 行政区
	private Integer ddlArea;

	// 商业区
	private Integer ddlBuss;

	// 景区
	private Integer select;

	private String opendateStr;// 开业时间

	private String otherCard;// 卡类型:其他

	private String areaCode;// 区号

	private String faxNo;
	// 房型ID
	private Long roomid;
	// 门市价
	private String hotelp_deptprice;

	public List<City> citybypro() {
		return Server.getInstance().getHotelService().findAllCity(
				" where " + City.COL_provinceid + " = " + h_provinceId,
				"ORDER BY ID ", -1, 0);
	}

	public String getcity() throws IOException {
		listCities = Server.getInstance().getHotelService().findAllCity(
				" where " + City.COL_provinceid + " = " + h_provinceId,
				" ORDER BY " + City.COL_id, -1, 0);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		PrintWriter out = response.getWriter();
		String ym = "<select id=\"h_cityId\" style=\"WIDTH: 120px\" name=\"h_cityId\">"
				+ "<option value='-1'>---请选择---</option>";
		for (int i = 0; i < listCities.size(); i++) {
			if (h_cityId != null && h_cityId > 0) {
				if (h_cityId == listCities.get(i).getId()) {
					ym += "<option value='" + listCities.get(i).getId()
							+ "' selected>" + listCities.get(i).getName()
							+ "</option>";
				} else {
					ym += "<option value='" + listCities.get(i).getId() + "'>"
							+ listCities.get(i).getName() + "</option>";
				}
			} else {
				ym += "<option value='" + listCities.get(i).getId() + "'>"
						+ listCities.get(i).getName() + "</option>";
			}
		}
		ym += "</select>";
		out.println(ym);
		out.flush();
		out.close();
		return "";
	}
	public String tofan() throws Exception {
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		//String where = " WHERE 1=1  and "+Hotel.COL_id+" not in ( SELECT "+Hotelfan.COL_hotelid+" FROM "+Hotelfan.TABLE+" where 1=1 )";
		String where = " WHERE 1=1 ";
		
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}


//		if (h_provinceId != null && h_provinceId.intValue() > 0) {
//			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
//					+ h_provinceId.intValue();
//		}

		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_laiyuan != null && h_laiyuan.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_sourcetype+ "="
					+ h_laiyuan.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		//如果是Ebooking登录
		/*String strRoleid=ActionContext.getContext().getSession().get("ListAgid").toString();
		if(strRoleid.equals("10035"))
		{
			if(getLoginUser()!=null&&getLoginUser().getEbookhotelid()!=null)
			{
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_id+"='"+ getLoginUser().getEbookhotelid()+"'";
			}else
			{
				where+=" and 1=2 ";
			}
		}*/
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}

		return "tofan";
	}
	/**
	 * 转向酒店详细信息页面
	 */
	public String toinfo() throws Exception {
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		return "toinfo";
	}
	public String editsta() throws Exception {
		//String sql =" update "+Hotel.TABLE+" set "+Hotel.COL_state+" ="+h_state+" where " +Hotel.COL_sourcetype+" ="+h_laiyuan;
		//System.out.println("sql=="+sql);
		//int aa=Server.getInstance().getHotelService().updatehotelcountHotelBySql(sql);
		
		String where = " where 1=1 and "+Hotel.COL_sourcetype+" ="+h_laiyuan;
		List<Hotel>listh=Server.getInstance().getHotelService().findAllHotel(where, "", -1, 0);
		if(listh.size()>0){
			for(int a=0;a<listh.size();a++){
				Hotel h =listh.get(a);
				h.setState(h_state);
				Server.getInstance().getHotelService().updateHotelIgnoreNull(h);
				
			}
		}
		return LIST;
	}
	/**
	 * 转向酒店设置返点页面
	 */
	public String toaddfan() throws Exception {
		
		
		return "toaddfan";
	}
	/**
	 * 转向酒店批量下网页面
	 */
	public String toout() throws Exception {
		
		
		return "toout";
	}
	/**
	 * 转向酒店详细信息页面
	 */
	public String editzhutui() throws Exception {
	Hotel hotel2 = Server.getInstance().getHotelService().findHotel(hid);

	hotel2.setHot(1);
	hotel2.setSellpoint(sell);
	hotel2.setSort(pai);
	Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel2);
		return "editzhutui";
	}
	
	/**
	 * 酒店主推
	 */
	public String zhutui() throws Exception {
		hotel.setWebsign(Integer.parseInt(hoteltype));
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		hotel=Server.getInstance().getHotelService().findHotel(hotel.getId());
		if(hotel.getType()==2){
			
			return this.interhotel();
		}else{
			return LIST;
		}
	}
	
	/**
	 * 列表查询酒店--国内
	 */
	public String execute() throws Exception {
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null",
				"ORDER BY " + City.COL_id, -1, 0);
		
		System.out.println("listCities=="+listCities);
		
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}


//		if (h_provinceId != null && h_provinceId.intValue() > 0) {
//			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
//					+ h_provinceId.intValue();
//		}

		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_laiyuan != null && h_laiyuan.intValue() > 0) {
			
			
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_sourcetype + "="
					+ h_laiyuan.intValue();
			
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		//如果是Ebooking登录
		/*String strRoleid=ActionContext.getContext().getSession().get("ListAgid").toString();
		if(strRoleid.equals("10035"))
		{
			if(getLoginUser()!=null&&getLoginUser().getEbookhotelid()!=null)
			{
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_id+"='"+ getLoginUser().getEbookhotelid()+"'";
			}else
			{
				where+=" and 1=2 ";
			}
		}*/
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		//listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 and "+Customeragent.COL_agentjibie+" =3", " ORDER BY ID DESC ", -1, 0);
		return SUCCESS;
	}
	/**
	 * 列表查询酒店--国际
	 */
	public String interhotel() throws Exception {
		listCountry = Server.getInstance().getInterHotelService().findAllCountry("", "", -1, 0);
		
		String where = " WHERE 1=1  and "+Hotel.COL_type+" =2";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}


	if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_contryid + "="
				+ h_provinceId.intValue();
	}

		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_laiyuan != null && h_laiyuan.intValue() > 0) {
			
			
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_sourcetype + "="
					+ h_laiyuan.intValue();
			
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		//如果是Ebooking登录
		/*String strRoleid=ActionContext.getContext().getSession().get("ListAgid").toString();
		if(strRoleid.equals("10035"))
		{
			if(getLoginUser()!=null&&getLoginUser().getEbookhotelid()!=null)
			{
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_id+"='"+ getLoginUser().getEbookhotelid()+"'";
			}else
			{
				where+=" and 1=2 ";
			}
		}*/
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		//listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 and "+Customeragent.COL_agentjibie+" =3", " ORDER BY ID DESC ", -1, 0);
		return "interhotel";
	}
	public void getInterCity() throws Exception {
		String incity="";
		
		List<Incity>listincity=Server.getInstance().getInterHotelService().findAllIncity(" where 1=1 and "+Incity.COL_countryid+" ='"+couid+"'", "", -1, 0);
		if(listincity.size()>0){
			incity+="<select id='h_cityId' name='h_cityId' style='WIDTH: 120px'>";
			for(int i=0;i<listincity.size();i++){
				incity+="<option value='"+listincity.get(i).getId()+"'>"+listincity.get(i).getName()+"</option>";
			}
			incity+="</select>";
		}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			System.out.println("incity=="+incity);
			sb.append(incity);
			out.print(sb);
			out.flush();
		    out.close();
		    
	}
	/**
	 * Ebooking列表查询酒店
	 */
	public String getHotelForEbook() throws Exception {
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1  ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}


//		if (h_provinceId != null && h_provinceId.intValue() > 0) {
//			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
//					+ h_provinceId.intValue();
//		}

		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}

		return "ebookinghotels";
	}
	public String toaddebookinguser() throws Exception
	{
		
		return "toaddebookinguser";
	}
	/**
	 * 列表查询酒店
	 */
	public String topiliang() throws Exception {
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1  ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}


//		if (h_provinceId != null && h_provinceId.intValue() > 0) {
//			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
//					+ h_provinceId.intValue();
//		}

		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}

		return "topiliang";
	}
	/**
	 * 列表查询酒店
	 */
	public String tozhutui() throws Exception {
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}
		/*if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
					+ h_provinceId.intValue();
		}*/
		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		if(iszhutui!=null && iszhutui.length()>0)
		{
		    where +=" AND ("+ Hotel.TABLE + "." + Hotel.COL_hot+" =1 or "+ Hotel.TABLE + "." + Hotel.COL_hot+"=2)";
		}
		System.out.println(where);
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY C_HOT,C_SORT", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY C_HOT,C_SORT", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}

		return "tozhutui";
	}
	/**
	 * 转向到酒店订单页面
	 */
	public String toorder() throws Exception {
		
		return "toorder";
	}
	/**
	 * 转向到酒店批量修改页面
	 */
	public String piliang() throws Exception {
		System.out.println("批量修改的酒店id==="+hotelid);
		return "piliang";
	}

	/**
	 * 转向到酒店添加页面
	 */
	public String toadd() throws Exception {
		// System.out.println("info ... to add!");
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince(" WHERE 1=1 ", "ORDER BY " + Province.COL_id, -1, 0);
		String strwhere="where 1=1 and "+City.COL_provinceid+" is not null ";
		listCities = Server.getInstance().getHotelService().findAllCity(strwhere,
				"ORDER BY " + City.COL_id, -1, 0);
		//listinCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168 and "+City.COL_language+" ="+lan, "", -1, 0);
		listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 and "+Customeragent.COL_agentjibie+" =3", " ORDER BY ID DESC ", -1, 0);
		
		
		return "add";
	}
	/**
	 * 转向到酒店业务报表
	 */
	public String bordereaux() throws Exception {
		// System.out.println("info ... to add!");
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(statetime==null||statetime.trim().length()==0)
		{
			statetime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(endtime==null||endtime.trim().length()==0)
		{
			endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		
		
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_state+" =9");
		
		

		if (hotelname != null && hotelname.trim().length() != 0) {

			where.append(" and ").append(Hotelorder.COL_name).append(" like '%").append(hotelname.trim()).append("%'");
		}
		if(statetime != null && statetime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + statetime + " 00:00:00')") ;
		}
		if(endtime != null && endtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + endtime + " 23:59:59')") ;
		}
		if (hoteltype != null && hoteltype.length()!=0) {

			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_hot).append("=").append(hoteltype) ;
			where.append(")") ;
			
		}
		/*if(hotelorderstate!=null && hotelorderstate.length()!=0){
			
			where.append(" and "+Hotelorder.COL_state +" = "+hotelorderstate);
			
		}*/
		if(cityId != null && cityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_cityid).append("=").append(cityId) ;
			where.append(")") ;
		}
		
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorder(where.toString(), "", -1, 0)	;
		System.out.println("where==="+where);
		String sql="SELECT SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice," +
				"COUNT(a.ID) as r_sum ," +
				"SUM(cast(ltrim(rtrim(a.C_MANYDAY)) as decimal)) as r_jianye"+
				" FROM T_HOTELORDER a"+
		""+where+"";
		System.out.println("sql==="+sql);
		list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		
/*	if(listHotelorder.size()>0){	
		for (Hotelorder order : listHotelorder) {

			
			if(order.getManyday()!=null){
			int jian = order.getManyday();
			jianye +=jian;
			}
			if(order.getPrice()!=null){
			double	jia=Double.parseDouble(order.getPrice()); 
	
			int level = (int) (jia / 10);
			zongjia +=jia;
			}
		
			
			
			
		}
		
	}*/
		
		return "bordereaux";
	}
	/**
	 * 转向到酒店业务报表
	 */
	public String bordereaux_fan() throws Exception {
		
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(statetime==null||statetime.trim().length()==0)
		{
			statetime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(endtime==null||endtime.trim().length()==0)
		{
			endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		
		
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_state+" =9");
		
		

		if (hotelname != null && hotelname.trim().length() != 0) {

			where.append(" and ").append(Hotelorder.COL_name).append(" like '%").append(hotelname.trim()).append("%'");
		}
		if(statetime != null && statetime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + statetime + " 00:00:00')") ;
		}
		if(endtime != null && endtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + endtime + " 23:59:59')") ;
		}
		if (hoteltype != null && hoteltype.length()!=0) {

			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_hot).append("=").append(hoteltype) ;
			where.append(")") ;
			
		}
		/*if(hotelorderstate!=null && hotelorderstate.length()!=0){
			
			where.append(" and "+Hotelorder.COL_state +" = "+hotelorderstate);
			
		}*/
		if(cityId != null && cityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_cityid).append("=").append(cityId) ;
			where.append(")") ;
		}
		
		//listHotelorder = Server.getInstance().getHotelService().findAllHotelorder(where.toString(), "", -1, 0)	;
		List list = Server.getInstance().getHotelService()
		.findAllHotelorderForPageinfo(where.toString(), "ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotelorder = list;
		if (pageinfo.getTotalrow() > 0 && listHotelorder.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
			.findAllHotelorderForPageinfo(where.toString(), " ORDER BY ID DESC", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotelorder = list;
		}
		
		return "bordereaux_fan";
	}
	// 跟住订单ID	查找入住人
	public String getruzhu(long id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		listGuest = Server.getInstance().getHotelService().findAllGuest("where 1=1 and "+Guest.COL_orderid+" ="+id, "", -1, 0)	;
		StringBuffer Guestname = new StringBuffer();
	//	for (Guest gu : listGuest) {
		if(listGuest.size()>0){
			for(int i=0;i<listGuest.size();i++)
			{
				int a= i+1;
				if(listGuest.size()>a){
				 Guestname.append(listGuest.get(i).getName()+" ,");
				}else {
					 Guestname.append(listGuest.get(i).getName());
				}
			}
		}
		return Guestname.toString();
}
	/**
	 * 转向到酒店业务报表
	 */
	public void bordereauxexcel() throws IOException, RowsExceededException, WriteException {
		// System.out.println("info ... to add!");
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 ");
		
		

		
		
		if (hotelname != null && hotelname.trim().length() != 0) {

			where.append(" and ").append(Hotelorder.COL_name).append(" like '%").append(hotelname.trim()).append("%'");
		}
		if(statetime != null && statetime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + statetime + " 00:00:00')") ;
		}
		if(endtime != null && endtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + endtime + " 23:59:59')") ;
		}
		if (hoteltype != null && hoteltype.length()!=0) {

			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_hot).append("=").append(hoteltype) ;
			where.append(")") ;
			
		}
		if(hotelorderstate!=null && hotelorderstate.length()!=0){
			
			where.append(" and "+Hotelorder.COL_state +" = "+hotelorderstate);
			
		}
		if(cityId != null && cityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_cityid).append("=").append(cityId) ;
			where.append(")") ;
		}
		
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorder(where.toString(), "", -1, 0)	;
		System.out.println("where==="+where);
		String sql="SELECT SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice," +
				"COUNT(a.ID) as r_sum ," +
				"SUM(cast(ltrim(rtrim(a.C_MANYDAY)) as decimal)) as r_jianye"+
				" FROM T_HOTELORDER a"+
		""+where+"";
		System.out.println("sql==="+sql);
		list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
/*	if(listHotelorder.size()>0){	
		for (Hotelorder order : listHotelorder) {

			
			if(order.getManyday()!=null){
			int jian = order.getManyday();
			jianye +=jian;
			}
			double	jia=Double.parseDouble(order.getPrice()); 
		
		
			
			zongjia +=jia;
			
		}
		
	}*/
	//开始写报表
	String fileName="酒店订单业务统计.xls";   
	HttpServletResponse response=ServletActionContext.getResponse();                      
	response.setContentType("application/vnd.ms-excel");                      
	response.setHeader("Content-Disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));                      
	//response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));                       
	WritableWorkbook workbook=Workbook.createWorkbook(response.getOutputStream()); 
	 WritableSheet sheet = workbook.createSheet("Sheet_1", 0); 
	 Label label0 = new Label(0, 0, "预订时间");    
     sheet.addCell(label0); 
     Label label1 = new Label(1, 0, "订单编号");    
     sheet.addCell(label1);
     Label label2 = new Label(2, 0, "入住酒店");    
     sheet.addCell(label2);
     Label label3 = new Label(3, 0, "客人姓名");    
     sheet.addCell(label3);
     Label label4 = new Label(4, 0, "入住日期");    
     sheet.addCell(label4);
     Label label5 = new Label(5, 0, "离店日期");    
     sheet.addCell(label5);
     Label label6 = new Label(6, 0, "天数");    
     sheet.addCell(label6);
     Label label7 = new Label(7, 0, "间数");    
     sheet.addCell(label7);
     Label label8 = new Label(8, 0, "间夜");    
     sheet.addCell(label8);
     Label label9 = new Label(9, 0, "客户");    
     sheet.addCell(label9);
     Label label10 = new Label(10, 0, "应收单价");    
     sheet.addCell(label10);
     Label label11 = new Label(11, 0, "早餐");    
     sheet.addCell(label11);
     Label label12 = new Label(12, 0, "杂费");    
     sheet.addCell(label12);
     Label label13 = new Label(13, 0, "应收总价");    
     sheet.addCell(label13);
     Label label14 = new Label(14, 0, "收款日期");    
     sheet.addCell(label14);
     Label label15 = new Label(15, 0, "备注");    
     sheet.addCell(label15);
     Label label16 = new Label(16, 0, "制单员");    
     sheet.addCell(label16);
     /*
     Label labela = new Label(0, 0, "");    
     sheet.addCell(labela); 
     Label labelb = new Label(1, 0, "");    
     sheet.addCell(labelb);
     Label labelc = new Label(2, 0, "");    
     sheet.addCell(labelc);
     Label labeld = new Label(3, 0, "");    
     sheet.addCell(labeld);*/
     
	 for(int i=0;i<listHotelorder.size();i++)
	 {
		 Hotelorder	 hotelorder = listHotelorder.get(i);
		 if(hotelorder.getPretime()!=null && hotelorder.getPretime().toString().length()>0){
			 Label label000 = new Label(0, i+1, hotelorder.getPretime().toString());    
	         sheet.addCell(label000); 
		 }else{
			 
			 Label label000 = new Label(0, i+1, "");    
	         sheet.addCell(label000); 
		 }
		
         
         if(hotelorder.getOrderid()!=null && hotelorder.getOrderid().toString().length()>0){
        	 Label label111 = new Label(1, i+1, hotelorder.getOrderid().toString());    
             sheet.addCell(label111);
         }else{
        	 
        	 Label label111 = new Label(1, i+1, "");    
             sheet.addCell(label111);
         }
        
         
         
         if(hotelorder.getName()!=null && hotelorder.getName().toString().length()>0){
        	 Label label222 = new Label(2, i+1, hotelorder.getName().toString());    
             sheet.addCell(label222);
         }else{
        	 
        	 Label label222 = new Label(2, i+1, "");    
             sheet.addCell(label222);
         }
        
         
         
         Label label333 = new Label(3, i+1, getruzhu(hotelorder.getId()));    
         sheet.addCell(label333);
         
         
         if(hotelorder.getComedate()!=null && hotelorder.getComedate().toString().length()>0){
        	 Label label444 = new Label(4, i+1, hotelorder.getComedate().toString());    
             sheet.addCell(label444);
         }else{
        	 Label label444 = new Label(4, i+1, "");    
             sheet.addCell(label444);
        	 
         }
        
         
         
         if(hotelorder.getLeavedate()!=null && hotelorder.getLeavedate().toString().length()>0){
        	 Label label555 = new Label(5, i+1, hotelorder.getLeavedate().toString());    
             sheet.addCell(label555);
         }else{
        	 Label label555 = new Label(5, i+1, "");    
             sheet.addCell(label555);
         }
        
         
         
         if(hotelorder.getManyday()!=null && hotelorder.getManyday().toString().length()>0){
        	  Label label666 = new Label(6, i+1, hotelorder.getManyday().toString());    
              sheet.addCell(label666);
         }else{
        	 Label label666 = new Label(6, i+1, "");    
             sheet.addCell(label666);
         }
       
         
         if(hotelorder.getPrerooms()!=null && hotelorder.getPrerooms().toString().length()>0){
        	 Label label777 = new Label(7, i+1, hotelorder.getPrerooms().toString());    
             sheet.addCell(label777);
        	 
         }else{
        	 Label label777 = new Label(7, i+1, "");    
             sheet.addCell(label777);

        	 
         }
        
         
         
         
         if(hotelorder.getManyday()!=null && hotelorder.getManyday().toString().length()>0){
        	 
        	  Label label888 = new Label(8, i+1, hotelorder.getManyday().toString());    
              sheet.addCell(label888);
         }else{
        	 Label label888 = new Label(8, i+1, "");    
             sheet.addCell(label888);
        	 
         }
         
       
         
         
         
         if(hotelorder.getLinkname().toString().length()>0 && hotelorder.getLinkname()!=null){
        	 
        	 Label label999 = new Label(9, i+1, hotelorder.getLinkname().toString());    //客户
             sheet.addCell(label999);
         }else{
        	 Label label999 = new Label(9, i+1, "");    //客户
             sheet.addCell(label999);
        	 
         }
         
        
       // 	String   Iprice =  hotelorder.getPrice() ;  
       //  String cc[]=  hotelorder.getPrice().split(".");
      // int Iprice=Integer.parseInt(cc[0]);
         if(hotelorder.getPrice()!=null && hotelorder.getPrice().toString().length()>0){
		         Double Iprice=Double.parseDouble(hotelorder.getPrice());
		         Double aa = Iprice/2;
		         Label label100 = new Label(10, i+1, aa+"");    //单价
		         sheet.addCell(label100);
         }else{
        	  Label label100 = new Label(10, i+1,"");    //单价
              sheet.addCell(label100);
        	 
         }
         Label label110 = new Label(11, i+1, "");   //早餐 
         sheet.addCell(label110);
         Label label120 = new Label(12, i+1, "");    //杂费
         sheet.addCell(label120);
         if(hotelorder.getPrice()!=null && hotelorder.getPrice().toString().length()>0){
        	 
        	 Label label130 = new Label(13, i+1, hotelorder.getPrice().toString()); //总价   
             sheet.addCell(label130); 
         }else{
        	 Label label130 = new Label(13, i+1, ""); //总价   
             sheet.addCell(label130); 
         }
         Label label140 = new Label(14, i+1, "");   //收款日期 
         sheet.addCell(label140);
         
         if(hotelorder.getPredesc()!=null){
        	 Label label150 = new Label(15, i+1, hotelorder.getPredesc().toString());    //备注
             sheet.addCell(label150);
        	 
         }else{
        	 
        	 Label label150 = new Label(15, i+1, "");    //备注
             sheet.addCell(label150);
         }
        
         Label label160 = new Label(16, i+1, "");   //制单员 
         sheet.addCell(label160);
	 }
	 
	 Map map=(Map) list.get(0);
	 
	
		 Label label000 = new Label(0, listHotelorder.size()+1, "");    
         sheet.addCell(label000); 
	
	
     
     
    	 
    	 Label label111 = new Label(1, listHotelorder.size()+1, "总订单数"+map.get("r_sum").toString());    
         sheet.addCell(label111);
    
    
     
     
    	 Label label222 = new Label(2, listHotelorder.size()+1, "");    
         sheet.addCell(label222);
    
    
     
     
	     Label label333 = new Label(3, listHotelorder.size()+1, "");    
	     sheet.addCell(label333);
	     
     

    	 Label label444 = new Label(4, listHotelorder.size()+1, "");    
         sheet.addCell(label444);
    	 
   
    
     
   
    	 Label label555 = new Label(5, listHotelorder.size()+1, "");    
         sheet.addCell(label555);
   
     
     
    
    	 Label label666 = new Label(6, listHotelorder.size()+1, "");    
         sheet.addCell(label666);

    	 Label label777 = new Label(7, listHotelorder.size()+1, "");    
         sheet.addCell(label777);

    	 

    
     
     
     
    
    	 Label label888 = new Label(8, listHotelorder.size()+1, "总间夜"+map.get("r_jianye").toString());    
         sheet.addCell(label888);
    	 
   
     
   
     
     
     
   
    	 Label label999 = new Label(9, listHotelorder.size()+1, "");    //客户
         sheet.addCell(label999);
    	 
    
     
    
   // 	String   Iprice =  hotelorder.getPrice() ;  
   //  String cc[]=  hotelorder.getPrice().split(".");
  // int Iprice=Integer.parseInt(cc[0]);
    
    	  Label label100 = new Label(10, listHotelorder.size()+1,"");    //单价
          sheet.addCell(label100);
    	 
	 
	     Label label110 = new Label(11, listHotelorder.size()+1, "");   //早餐 
	     sheet.addCell(label110);
	     Label label120 = new Label(12, listHotelorder.size()+1, "");    //杂费
	     sheet.addCell(label120);
	  
    	 Label label130 = new Label(13, listHotelorder.size()+1, "总金额"+map.get("r_hotelprice").toString()); //总价   
         sheet.addCell(label130); 

	     Label label140 = new Label(14, listHotelorder.size()+1, "");   //收款日期 
	     sheet.addCell(label140);
	     
 
    	 
    	 Label label150 = new Label(15, listHotelorder.size()+1, "");    //备注
         sheet.addCell(label150);
 
    
         Label label160 = new Label(16, listHotelorder.size()+1, "");   //制单员 
     	sheet.addCell(label160);
	 
    workbook.write();    
    workbook.close();  
		
		
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=hotel.getLanguage();
		Long uco=hotel.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		hotel = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getUcode(),hotel.getLanguage());
		if(hotel==null)
		{
			hotel=new Hotel();
			hotel.setLanguage(lan);
			hotel.setUcode(uco);
			//以下是toadd参考方法
			listProvinces = Server.getInstance().getHotelService()
			.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
			listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" =168 and "+City.COL_language+" ="+lan,
			"ORDER BY " + City.COL_id, -1, 0);
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			listProvinces = Server.getInstance().getHotelService()
			.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
	hotel = Server.getInstance().getHotelService().findHotel(hotel.getId());
	hotelId = hotel.getId();
	opendateStr = formatDate(hotel.getOpendate());
		}
		return EDIT;
	}

	/**
	 * 转向到酒店修改页面
	 */
	public String toedit() throws Exception {
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		hotel = Server.getInstance().getHotelService().findHotel(hotel.getId());
		hotelId = hotel.getId();
		listinCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168", "", -1, 0);
		
		opendateStr = formatDate(hotel.getOpendate());
		
		return EDIT;
	}

	/**
	 * 转向到酒店审核页面
	 */
	public String tocheck() throws Exception {
		hotel = Server.getInstance().getHotelService().findHotel(hotel.getId());
		hotelId = hotel.getId();
		return CHECK;
	}

	/**
	 * 转向酒店详细信息页面
	 */
	public String todetails() throws Exception {
		return "details";
	}

	
	/**
	 * 酒店禁用
	 */
	public String jinyong() throws Exception {
		hotel.setState(4);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);

		return LIST;
	}

	/**
	 * 
	 * 酒店启用
	 */
	public String qiyong() throws Exception {
		hotel.setState(3);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		hotel=Server.getInstance().getHotelService().findHotel(hotel.getId());
	
		return LIST;
	}

	/**
	 * 酒店审核通过
	 */
	public String hotelCheck() throws Exception {
		// hotel =
		// Server.getInstance().getHotelManager().findHotel(hotel.getId());
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		return LIST;
	}

	/**
	 * 添加酒店
	 */
	public String add() throws Exception {
		// 0表示为待审核
		hotel.setState(3);
		hotel.setSourcetype(1l);
		// 总机电话
		String telCode = "";
		if (this.areaCode != null && this.areaCode.trim().length() > 0) {
			telCode = this.areaCode + "-" + hotel.getTortell();
		}

		// 传真
		String faxnum = "";
		if (this.areaCode != null && this.areaCode.trim().length() > 0) {
			faxnum = this.areaCode + "-" + hotel.getFax1();
		}

		// 卡类型
		String type = "";
		if (null != cardType && cardType.length > 0) {
			for (int i = 0; i < cardType.length; i++) {
				type += cardType[i] + "|";
			}

		}
		if (this.otherCard != null && this.otherCard.trim().length() > 0) {
			type += ":" + this.otherCard.trim();
		}
		// 服务项目
		/*String item = "";
		if (null != serviceItem && serviceItem.length > 0) {
			for (int i = 0; i < serviceItem.length; i++) {
				item += serviceItem[i] + "|";
			}
		}*/
		// 餐饮设施
		/*String food = "";
		if (null != eatery && eatery.length > 0) {
			for (int i = 0; i < eatery.length; i++) {
				food += eatery[i] + "|";
			}
		}*/
		// 娱乐健身设施
		/*String amusement = "";
		if (null != playItem && playItem.length > 0) {
			for (int i = 0; i < playItem.length; i++) {
				amusement += playItem[i] + "|";
			}
		}*/

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date opentime = dateFormat.parse(opendateStr);
		//hotel.setPlayitem(amusement);
		hotel.setCarttype(type);
		hotel.setOpendate(new java.sql.Date(opentime.getTime()));
		hotel.setFax1(faxnum);
		hotel.setTortell(telCode);
	//	hotel.setServiceitem(item);
		hotel.setType(hotel.getType());
	//	hotel.setFootitem(food);
		if(checkrad==1){
		hotel.setCityid(hotel.getCityid());
		hotel.setContryid(168l);
		}
		if(checkrad==2){
			hotel.setCityid(cityid2);
			hotel.setContryid(-1l);
			}
		hotel.setRegionid1(new Long(ddlArea));
		hotel.setRegionid2(new Long(ddlBuss));
		hotel.setRegionid3(new Long(select));
		hotel.setType(1);
		Hotel hotelBak = Server.getInstance().getHotelService().createHotel(
				hotel);

		hotelId = hotelBak.getId();
		
	
		
		return "addsuccess";

	}

	/**
	 * 审核酒店
	 */
	public String check() throws Exception {
		hotel.setState(1);
		// 2表示未通过审核
		// 3表示酒店上网 ,4表示酒店下网
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		return LIST;
	}

	/**
	 * 编辑酒店
	 */
	public String edit() throws Exception {
		if(checkrad==1){
			hotel.setCityid(hotel.getCityid());
			hotel.setContryid(168l);
			}
			if(checkrad==2){
				hotel.setCityid(cityid2);
				hotel.setContryid(-1l);
				}
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		return LIST;
	}

	/**
	 * 删除酒店
	 */
	public String delete() throws Exception {
		Server.getInstance().getHotelService().deleteHotel(hotel.getId());
		return LIST;
	}
	/**
	 * 下线酒店
	 */
	public String checkout() throws Exception {
		Hotel hot = Server.getInstance().getHotelService().findHotel(hotel.getId());
		hot.setState(4);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hot);
		return LIST;
	}
	
	
	//设置为图片主推酒店
	public String zhutuiimage() throws Exception {
		hotel.setHot(1);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		
		Hotel h1 = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getId(), 1);
		if(h1!=null){
			h1.setHot(1);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(h1);
		}
		Hotel h2 = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getId(), 2);
		if(h2!=null){
			h2.setHot(1);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(h2);
		}
		Hotel h3 = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getId(), 3);
		if(h3!=null){
			h3.setHot(1);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(h3);
		}
		
	
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}
		if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
					+ h_provinceId.intValue();
		}
		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		where +=" AND ("+ Hotel.TABLE + "." + Hotel.COL_hot+" =1 or "+ Hotel.TABLE + "." + Hotel.COL_hot+"=2)";
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY C_HOT,C_SORT", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY C_HOT,C_SORT", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		return "tozhutui";
	}
	
	
	public String batchzhutuiimage() throws Exception {
		if (selectid != null && selectid.length > 0) {
			switch (opt) {
			case 1: // delete
				for (int i : selectid) {
					hotel.setHot(1);
					hotel.setId(Long.parseLong(i+""));
					Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
				}
			}
		}
		
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}
		if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
					+ h_provinceId.intValue();
		}
		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		where +=" AND ("+ Hotel.TABLE + "." + Hotel.COL_hot+" =1 or "+ Hotel.TABLE + "." + Hotel.COL_hot+"=2)";
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY C_HOT,C_SORT", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY C_HOT,C_SORT", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		return "tozhutui";
	}
	
	//设置为图片主推酒店
	public String zhutuitext() throws Exception {
		hotel.setHot(2);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		
		Hotel h1 = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getId(), 1);
		if(h1!=null){
			h1.setHot(2);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(h1);
		}
		Hotel h2 = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getId(), 2);
		if(h2!=null){
			h2.setHot(2);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(h2);
		}
		Hotel h3 = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getId(), 3);
		if(h3!=null){
			h3.setHot(2);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(h3);
		}
		
	
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}
		if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
					+ h_provinceId.intValue();
		}
		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		where +=" AND ("+ Hotel.TABLE + "." + Hotel.COL_hot+" =1 or "+ Hotel.TABLE + "." + Hotel.COL_hot+"=2)";
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY C_HOT,C_SORT", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY C_HOT,C_SORT", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		return "tozhutui";
	}
	
	
	public String batchzhutuitext() throws Exception {
		if (selectid != null && selectid.length > 0) {
			switch (opt) {
			case 1: // delete
				for (int i : selectid) {
					hotel.setHot(2);
					hotel.setId(Long.parseLong(i+""));
					Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
				}
			}
		}
		
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}
		if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
					+ h_provinceId.intValue();
		}
		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		where +=" AND ("+ Hotel.TABLE + "." + Hotel.COL_hot+" =1 or "+ Hotel.TABLE + "." + Hotel.COL_hot+"=2)";
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY C_HOT,C_SORT", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY C_HOT,C_SORT", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		return "tozhutui";
	}
	
	//撤销酒店主推级别改为一级主推
	public String deletezhutui() throws Exception {
		hotel.setHot(4);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
	
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}
		if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
					+ h_provinceId.intValue();
		}
		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		where +=" AND ("+ Hotel.TABLE + "." + Hotel.COL_hot+" =1 or "+ Hotel.TABLE + "." + Hotel.COL_hot+"=2)";
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY C_HOT,C_SORT", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY C_HOT,C_SORT", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		return "tozhutui";
	}

	/**
	 * 跳转到导入酒店的页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toReaderExcel() throws Exception {

		return "import";
	}

	/**
	 * 导入酒店信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String readerExcel() throws Exception {
		Timestamp currTime = new Timestamp(System.currentTimeMillis());
		Timestamp modifyTime = new Timestamp(System.currentTimeMillis());
		String userName = getLoginUser().getLoginname();
		Long userId = getLoginUser().getId();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(path + "   路径---------------------------------");
		FileInputStream fileInputStream = new FileInputStream("D:\\hotelexcel.xls");
		Workbook hotelbook = Workbook.getWorkbook(fileInputStream);
	//	Workbook hotelbook = Workbook.getWorkbook(new FileInputStream("C:\\Users\\Administrator\\Desktop\\jiudian3.xls"));
		
		
	//	Sheet sheetHotel = hotelbook ;
		Sheet sheetHotel = hotelbook.getSheet(0);
		Sheet sheetHotel0 = hotelbook.getSheet(0);
		Sheet sheetHotel1 = hotelbook.getSheet(1);
		Sheet sheetHotel2 = hotelbook.getSheet(2);
		Sheet sheetHotel3 = hotelbook.getSheet(3);
		for(int d=0;d< sheetHotel.getRows();d++){

			
			Hotel hotel = new Hotel();

			// Cell test=sheetHotel.getCell(2, 1);
			// System.out.println(test.getContents()+" 测试----------------");

			// 酒店序号
			// Cell hot1= sheetHotel.getCell(0,i);
		//	sheetHotel.getRows();
			// 酒店名称
			Cell hot2 = sheetHotel.getCell(1, d);
			hotel.setName(hot2.getContents());
			// 英文名称
			Cell en_name = sheetHotel.getCell(17, d);
			hotel.setEnname(en_name.getContents());
			// 简拼
		//	Cell jp_name = sheetHotel.getCell(2, 3);
		//	hotel.setJpname(jp_name.getContents());
			
			// 酒店星级
			Cell hot3 = sheetHotel.getCell(2, d);
			System.out.println(hot3.getContents());
			if (hot3.getContents().equals("1")) {
				hotel.setStar(1);
			}
			if (hot3.getContents().equals("-2")) {
				hotel.setStar(2);
			}
			if (hot3.getContents().equals("2")) {
				hotel.setStar(3);
			}
			if (hot3.getContents().equals("-3")) {
				hotel.setStar(4);
			}
			if (hot3.getContents().equals("3")) {
				hotel.setStar(5);
			}
			if (hot3.getContents().equals("-1")) {
				hotel.setStar(6);
			}
			if (hot3.getContents().equals("4")) {
				hotel.setStar(7);
			}
			if (hot3.getContents().equals("-5")) {
				hotel.setStar(8);
			}
			if (hot3.getContents().equals("5")) {
				hotel.setStar(9);
			}
			// 酒店类型
		/*	Cell h_type = sheetHotel.getCell(2, 6);
			if (h_type.getContents().equals("公寓式")) {
				hotel.setType(1);
			}
			if (h_type.getContents().equals("会议型")) {
				hotel.setType(2);
			}
			if (h_type.getContents().equals("度假型")) {
				hotel.setType(3);
			}
			if (h_type.getContents().equals("观光型")) {
				hotel.setType(4);
			}
			if (h_type.getContents().equals("综合型")) {
				hotel.setType(5);
			}
			if (h_type.getContents().equals("机场型")) {
				hotel.setType(6);
			}`
			if (h_type.getContents().equals("别墅型")) {
				hotel.setType(7);
			}
			if (h_type.getContents().equals("商务型")) {
				hotel.setType(8);
			}*/
			// 房间总数
			/*Cell h_rooms = sheetHotel.getCell(2, 7);
			try {
				hotel.setRooms(Integer.parseInt(h_rooms.getContents()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}*/

			// 装修级别
			/*Cell h_repair = sheetHotel.getCell(2, 8);
			if (h_repair.getContents().equals("豪华")) {
				hotel.setRepair(1);
			}
			if (h_repair.getContents().equals("高档")) {
				hotel.setRepair(2);
			}
			if (h_repair.getContents().equals("舒适")) {
				hotel.setRepair(3);
			}
			if (h_repair.getContents().equals("经济")) {
				hotel.setRepair(4);
			}*/
			// 开业时间
			/*Cell open_date = sheetHotel.getCell(2, 9);
			System.out.println(open_date.getContents());
			try {
				Date aaaa = format.parse(open_date.getContents());
				hotel.setOpendate(new java.sql.Date(aaaa.getTime()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}*/
			// 装修时间
			/*Cell repail_date = sheetHotel.getCell(2, 10);
			hotel.setRepaildate(repail_date.getContents());*/
			// 主楼高度
			/*Cell main_level = sheetHotel.getCell(2, 11);
			try {
				hotel.setMainlevel(Integer.parseInt(main_level.getContents()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}
*/
			// 附楼高度
			/*Cell append_lever = sheetHotel.getCell(2, 12);
			try {
				hotel.setAppendlever(Integer.parseInt(append_lever
						.getContents()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}*/

			// 酒店简介
			Cell hot4 = sheetHotel.getCell(24, d);
			hotel.setDescription(hot4.getContents());
			// 预订要求
			Cell h_prespec = sheetHotel.getCell(18, d);
			hotel.setPrespec(h_prespec.getContents());
			// 酒店特色
			Cell sell_point = sheetHotel.getCell(16, d);
			hotel.setSellpoint(sell_point.getContents());
			// 酒店全称
			Cell full_name = sheetHotel.getCell(1, d);
			hotel.setFullname(full_name.getContents());
			// 开户行
		//	Cell open_bank = sheetHotel.getCell(2, 17);
		//	hotel.setOpenbank(open_bank.getContents());
			// 账号
		//	Cell bank_account = sheetHotel.getCell(2, 18);
		//	hotel.setBankaccount(bank_account.getContents());
			// 所在省
		//	Cell h_province = sheetHotel.getCell(2, 19);
			// hotel.setProvinceid(Long.parseLong(province_id.getContents()));
			// 所在城市
			Cell h_city = sheetHotel.getCell(10, d);
			// 行政区
		//	Cell h_region1 = sheetHotel.getCell(2, 21);
			// 商业区
		//	Cell h_region2 = sheetHotel.getCell(2, 22);
			// 景区
		//	Cell h_region3 = sheetHotel.getCell(2, 23);
			// 经度
		//	Cell h_lat = sheetHotel.getCell(2, 24);


			// 总机电话
			Cell tor_tell = sheetHotel.getCell(22, d);
			hotel.setTortell(tor_tell.getContents());
			// 确认传真
			Cell h_fax1 = sheetHotel.getCell(7, d);
			hotel.setFax1(h_fax1.getContents());
			// 传真说明
		//	Cell fax_desc = sheetHotel.getCell(2, 28);
		//	hotel.setFaxdesc(fax_desc.getContents());
			// 销售电话
			Cell market_tell = sheetHotel.getCell(3, d);
			hotel.setMarkettell(market_tell.getContents());
			// 酒店具体地址
			Cell hot8 = sheetHotel.getCell(8, d);
			hotel.setAddress(hot8.getContents());
			// 邮编
			Cell post_code = sheetHotel.getCell(9, d);
			hotel.setPostcode(post_code.getContents());
			// 周边酒店
			//Cell near_hotel = sheetHotel.getCell(2, 32);
			//hotel.setNearhotel(near_hotel.getContents());
			// 可接受卡类型
			//Cell cart_type = sheetHotel.getCell(2, 33);
		//	hotel.setCarttype(cart_type.getContents());
			// 宾馆服务项目
			Cell service_item = sheetHotel.getCell(15, d);
			hotel.setServiceitem(service_item.getContents());
			// 餐饮设施
			Cell foot_item = sheetHotel.getCell(25, d);
			hotel.setFootitem(foot_item.getContents());
			// 娱乐健身设施
			Cell play_item = sheetHotel.getCell(27, d);
			hotel.setPlayitem(play_item.getContents());

			// 根据酒店城市名称得到城市id和省份id
			String cityName = h_city.getContents();
			listCities = Server.getInstance().getHotelService().findAllCity(
					" where " + City.COL_name + "= '" + cityName + "'",
					"order by ID", 1, 0);
			if (!listCities.isEmpty()) {
				City city = listCities.get(0);
				hotel.setCityid(city.getId());
				Long cityid = city.getId();// 城市id
				Long provinid = city.getProvinceid();// 省份id
				hotel.setProvinceid(city.getProvinceid());
		
			}
			System.out.println("酒店：  " + hotel);
			this.hotel = hotel;
		
	
		/**
		 * 酒店联系人清单
		 */

			//	for (int j = 2; j < linkmanSheet.getRows(); j++) {
				Hotellinkman hotelLinkman = new Hotellinkman();
				// 联系人名称
				Cell lm_name = sheetHotel.getCell(6, d);
				hotelLinkman.setName(lm_name.getContents());
				// 联系人性别
				/*Cell lm_sex = linkmanSheet.getCell(2, j);
				if (lm_sex.getContents().equals("男")) {
					hotelLinkman.setSex(1);
				}
				if (lm_sex.getContents().equals("女")) {
					hotelLinkman.setSex(2);
				}*/
				// 联系人职务
			//	Cell lm_duty = linkmanSheet.getCell(3, j);
			//	hotelLinkman.setDuty(lm_duty.getContents());
				// 联系人座机
				Cell lm_tell = sheetHotel.getCell(4, d);
				hotelLinkman.setTell(lm_tell.getContents());
				// 联系人手机
			//	Cell lm_mobil = linkmanSheet.getCell(5, j);
			//	hotelLinkman.setMobil(lm_mobil.getContents());
				// 联系人传真
				Cell lm_fax = sheetHotel.getCell(5, d);
				hotelLinkman.setFax(lm_fax.getContents());
				// 创建时间
				hotelLinkman.setCreatetime(currTime);
				// 创建者
				hotelLinkman.setCreateuser(userName);
				// 修改者
				hotelLinkman.setModifyuser(userName);
				// 修改时间
				hotelLinkman.setModifytime(modifyTime);
				// 状态
				hotelLinkman.setState(0);
				/*if ("" == lm_name.getContents()
						|| null == lm_name.getContents()) {
					break;
				}*/
				System.out.println("酒店联系人：   " + hotelLinkman);
				//listHotellinkman.add(hotelLinkman);
				// try {
				// hotelLinkman.setHotelid(hotelId);
				// Server.getInstance().getHotellinkmanManager()
				// .createHotellinkman(hotelLinkman);
				// f_state = 1;
				//
				// } catch (Exception e) {
				// e.printStackTrace();
				// f_state = -3;
				// e.printStackTrace();
				// }
		//	}

	
	
		

		
		/**
		 * 开始导入酒店
		 */
		try {
			//this.hotel.setStartprice(0d);
			System.out.println("开始导入酒店： " + this.hotel);
			Hotel h_hotel = Server.getInstance().getHotelService().createHotel(
					this.hotel);
			hotelId = h_hotel.getId();
			f_state = 1;
		} catch (Exception e) {
			e.printStackTrace();
			f_state = -1;
			return "import";
		}
		
		/**
		 * 开始导入酒店联系人
		 */
		try {
			
			//	hotellinkman = listHotellinkman.get(i);
				hotelLinkman.setHotelid(hotelId);
				//System.out.println("开始导入酒店联系人： " + hotellinkman + " 顺序： " + i);
				Server.getInstance().getHotelService()
						.createHotellinkman(hotelLinkman);
				f_state = 1;
			

		} catch (Exception e) {
			e.printStackTrace();
			f_state = -3;
			return "import";
		}
		
}	
		
		hotelbook.close();
		fileInputStream.close();
		

		System.out.println("我依然到这里");
		return "import";
	}

	/**
	 * 添加酒店价格
	 * 
	 * @param beginTime
	 * @param parameterList
	 * @param price
	 * @throws Exception
	 */
	private void addPrice(String beginTime, List<String> parameterList,
			Double[] price) throws Exception {
		Hotelprice temphotelprice = new Hotelprice();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M");
		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(sdf.parse(beginTime));
		int maxDate = beginCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int week = -1;

		StringBuffer isvalid = new StringBuffer();

		for (int i = 1; i <= maxDate; i++) {
			try {
				Method method = Hotelprice.class.getMethod("setNo" + i,
						Double.class);
				SimpleDateFormat strDate = new SimpleDateFormat("yyyy-M-d");
				Date tempDate = strDate.parse(beginTime + "-" + i);
				// if(i<10){
				// isvalid.append("0"+i+"|0|");
				// }else{
				// isvalid.append(i+"|0|");
				// }
				isvalid.append("0");
				long newTime = tempDate.getTime();
				boolean flag = true;
				if (parameterList.size() > 0) {
					for (int par = 0; par < parameterList.size(); par++) {
						String[] tempTimearr = parameterList.get(par).split(
								"\\|");
						if (Double.parseDouble(tempTimearr[0]) <= newTime
								&& Double.parseDouble(tempTimearr[1]) >= newTime) {
							method.invoke(temphotelprice, Double
									.parseDouble(tempTimearr[2]));
							flag = false;
							break;
						}

					}
					if (flag) {
						Calendar tempCal = Calendar.getInstance();
						tempCal.setTime(tempDate);
						week = tempCal.get(Calendar.DAY_OF_WEEK);
						method.invoke(temphotelprice, price[week - 1]);
					}
				} else {
					Calendar tempCal = Calendar.getInstance();
					tempCal.setTime(tempDate);
					week = tempCal.get(Calendar.DAY_OF_WEEK);
					method.invoke(temphotelprice, price[week - 1]);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (beginTime.split("-")[1].length() < 2) {
			beginTime = beginTime.split("-")[0] + "-" + "0"
					+ beginTime.split("-")[1];
		}
		temphotelprice.setDatenumber(beginTime);
		System.out.println(hotelId
				+ "     =价格里面的ID----------------------------------------");
		temphotelprice.setHotelid(hotelId);
		temphotelprice.setRoomid(roomid);
		temphotelprice.setDeptprice(hotelp_deptprice);
		temphotelprice.setIsvalid(isvalid.toString());
		try {

			Server.getInstance().getHotelService().createHotelprice(
					temphotelprice);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断酒店名称是否存在
	 */
	// public String hotelnameisexist()throws Exception{
	// List <Hotel> hotelnames =
	// Server.getInstance().getHotelManager().findAllHotel(" WHERE " +
	// Hotel.COL_name +
	// "='"+hotel.getName()+ "' AND "+ Hotel.COL_id +"="+hotel.getId(),"",-1,0);
	// HttpServletResponse response = ServletActionContext.getResponse();
	// response.setContentType("text/blank");
	// PrintWriter out = response.getWriter();
	// if(hotelnames != null && hotelnames.size()>0){
	// out.print("1") ;
	//			
	// }else{
	// out.print("0");
	// }
	// out.flush();
	// out.close();
	// return null;
	// }
	// 判断酒店名称是否存在
	public void findByHotelName() throws Exception {
		String hotelName = new String(this.hotel.getName().trim().getBytes(
				"ISO8859-1"), "UTF-8");
		String sql = "where C_NAME = '" + hotelName + "'";
		int name = Server.getInstance().getHotelService().findAllHotel(sql, "",
				-1, 0).size();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if (name > 0) {
			out.print("true");
		} else if (hotelName != null && hotelName.length() > 0) {
			out.print("false");
		} else {
			out.print("blank");
		}
		out.flush();
		out.close();

	}
	public String hotelzhutuibatch() throws Exception {
		int type=1;
		
		if (selectid != null && selectid.length > 0) {
			switch (opt) {
			case 1: // delete
				for (int i : selectid) {
					hotel=Server.getInstance().getHotelService().findHotel(i);
					hotel.setWebsign(Integer.parseInt(hoteltype));
					hotel.setId(Long.parseLong(i+""));
					Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
					hotel=Server.getInstance().getHotelService().findHotel(hotel.getId());
					type=hotel.getType();
				}
			}
		}
		
		if(type==2){
				
				return this.interhotel();
			}else{
				return LIST;
			}
		
		
		}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		if (selectid != null && selectid.length > 0) {
			switch (opt) {
			case 1: // delete
				for (int i : selectid) {
					Server.getInstance().getHotelService().deleteHotel(i);
				}
			}
		}
		return LIST;
	}
	/**
	 * 批量操作下线
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batchout() throws Exception {
		if (selectid != null && selectid.length > 0) {
			switch (opt) {
			case 1: // delete
				for (int i : selectid) {
					Hotel hotel = Server.getInstance().getHotelService().findHotel(i);
					hotel.setState(4);
					
					
					Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
				}
			}
		}
		return LIST;
	}
	
	/**
	 * 批量撤销主推操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batchzhutui() throws Exception {
		if (selectid != null && selectid.length > 0) {
			switch (opt) {
			case 1: // delete
				for (int i : selectid) {
					hotel.setHot(4);
					hotel.setId(Long.parseLong(i+""));
					Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
				}
			}
		}
		
		// 查询所有的省
		listProvinces = Server.getInstance().getHotelService()
				.findAllProvince("", "ORDER BY " + Province.COL_id, -1, 0);
		// List
		// provicesls=Server.getInstance().getProvinceManager().findAllProvince("",
		// "ORDER BY " + Province.COL_id,-1,0);
		// 查询所有的市
		listCities = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_provinceid+" is not null ",
				"ORDER BY " + City.COL_id, -1, 0);
		String where = " WHERE 1=1 ";
		if (h_hotelname != null && h_hotelname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_name + " LIKE '%"
					+ h_hotelname + "%'";
		}
		if (h_enname != null && h_enname.trim().length() != 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_enname
					+ " LIKE '%" + h_enname + "%'";
		}
		if (h_provinceId != null && h_provinceId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_provinceid + "="
					+ h_provinceId.intValue();
		}
		if (h_cityId != null && h_cityId.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_cityid + "="
					+ h_cityId.intValue();
		}
		if (h_star != null && h_star.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_star + "="
					+ h_star.intValue();
		}
		if (h_repair != null && h_repair.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_repair + "="
					+ h_repair.intValue();
		}
		if (h_type != null && h_type.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_type + "="
					+ h_type.intValue();
		}
		if (h_recommend != null && h_recommend.intValue() > 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_hot + "="
					+ h_recommend.intValue();
		}
		if (h_state != null && h_state.intValue() >= 0) {
			where += " AND " + Hotel.TABLE + "." + Hotel.COL_state + "="
					+ h_state.intValue();
		}
		where +=" AND ("+ Hotel.TABLE + "." + Hotel.COL_hot+" =1 or "+ Hotel.TABLE + "." + Hotel.COL_hot+"=2)";
		List list = Server.getInstance().getHotelService()
				.findAllHotelForPageinfo(where, "ORDER BY C_HOT,C_SORT", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotel = list;
		if (pageinfo.getTotalrow() > 0 && listHotel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllHotelForPageinfo(where, " ORDER BY C_HOT,C_SORT", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotel = list;
		}
		return "tozhutui";
	}

	public String getprovinceNamebyId(long id) {
		return Server.getInstance().getHotelService().findProvince(id)
				.getName();
	}



	public void getTellCode() throws Exception {
		// String tellCode =
		// Server.getInstance().getCityManager().findCity(h_cityId).getAreacode();
		String tellCode = "027";
		Ajax.ajaxResponse(ServletActionContext.getResponse(), tellCode);
	}

	
	

	/**
	 * 得到城市相关信息
	 * 
	 * @throws Exception
	 */
	public void getCitiesInfo() throws Exception {
		List<Region> listAdmin = Server.getInstance().getHotelService()
				.findAllRegion(
						" WHERE " + Region.COL_cityid + " = " + h_cityId
								+ " AND " + Region.COL_type + "='行政区'",
						" ORDER BY ID ", -1, 0);
		List<Region> listBiz = Server.getInstance().getHotelService()
				.findAllRegion(
						" WHERE " + Region.COL_cityid + " = " + h_cityId
								+ " AND " + Region.COL_type + "='商业区'",
						" ORDER BY ID ", -1, 0);
		List<Region> listView = Server.getInstance().getHotelService()
				.findAllRegion(
						" WHERE " + Region.COL_cityid + " = " + h_cityId
								+ " AND " + Region.COL_type + "='景区'",
						" ORDER BY ID ", -1, 0);

		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("listAdmin", listAdmin);
		mp.put("listBiz", listBiz);
		mp.put("listView", listView);
		Ajax.ajaxResponse(ServletActionContext.getResponse(), mp);
	}

	// /////////////////////////////////////////////////////////////////////
	/**
	 * 酒店价格 查看列表
	 */

	public String getAllpricebyid() throws Exception {
		String where = " where 1=1 and " + Hotelprice.COL_hotelid + " = "
				+ hotelprice.getHotelid();
		List list = Server.getInstance().getHotelService()
				.findAllHotelpriceForPageinfo(where, "order by C_ROOMID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		this.listHotelprice = list;

		hotel.setName(Server.getInstance().getHotelService().findHotel(
				hotelprice.getHotelid()).getName());
		return "topricelist";
	}
	

	/**
	 * 
	 * @param id
	 * @return
	 */

	public String getAllpricebyidCheck() throws Exception {
		String where = " where 1=1 and " + Hotelprice.COL_hotelid + " = "
				+ hotelprice.getHotelid();
		List list = Server.getInstance().getHotelService()
				.findAllHotelpriceForPageinfo(where, "order by C_ROOMID ",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		this.listHotelprice = list;

		hotel.setName(Server.getInstance().getHotelService().findHotel(
				hotelprice.getHotelid()).getName());
		return "topricechecklist";
	}

	public String getroomnamebyroomid(long id) {
		// System.out.println(id);
		return Server.getInstance().getHotelService().findRoomtype(id)
				.getName();
	}

	public String toPricequeryandview() throws Exception {
		hotel.setName(new String(this.hotel.getName().getBytes("ISO8859-1"),
				"UTF-8"));
		return "to_shows";
	}

	public String toPricequeryview() throws Exception {
		hotel.setName(new String(this.hotel.getName().getBytes("ISO8859-1"),
				"GBK"));
		return "price_check";
	}

	public List<Hotelprice> getListHotelprice() {
		return listHotelprice;
	}


	static int prosceniumNo = 0;

	static int getDate = 0;

	public static int getGetDate() {
		return getDate;
	}

	public static void setGetDate(int getDate) {
		HotelAction.getDate = getDate;
	}

	public static int getProsceniumNo() {
		return prosceniumNo;
	}

	public static void setProsceniumNo(int prosceniumNo) {
		HotelAction.prosceniumNo = prosceniumNo;
	}

	/**
	 * 跳转到酒店价格查看页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toShow() throws Exception {
		// hotel.setName(new
		// String(this.hotel.getName().getBytes("ISO8859-1"),"GBK"));
		this.priceQuerybydatenumber();
		return "show";
	}

	/**
	 * 跳转到酒店价格审核页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toCheckShow() throws Exception {
		hotel.setName(new
		 String(this.hotel.getName().getBytes("ISO8859-1"),"GBK"));
		this.priceQuerybydatenumber();
		return "checkshow";
	}

	/**
	 * 返回查看价格列表页面
	 * 
	 * @return
	 * @throws Exception
	 */

	public String toBack() throws Exception {
		// this.hotel.setName(new
		// String(this.hotel.getName().getBytes("ISO8859-1"),"GBK"));

		this.listRoomtype = Server.getInstance().getHotelService()
				.findAllRoomtype(
						" where " + Roomtype.COL_hotelid + "="
								+ roomtype.getHotelid(), "ORDER BY ID ", -1, 0);
		hotel.setName(new String(this.hotel.getName().getBytes("ISO8859-1"),
				"GBK"));
		String where = " where 1=1 and " + hotelprice.COL_hotelid + " = "
				+ hotelprice.getHotelid();
		List list = Server.getInstance().getHotelService()
				.findAllHotelpriceForPageinfo(
						where,
						"order by " + Hotelprice.COL_datenumber + ","
								+ Hotelprice.COL_roomid + " asc", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		this.listHotelprice = list;
		return "to_shows";
	}

	/**
	 * 返回审核价格列表页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toCheckBack() throws Exception {
		this.listRoomtype = Server.getInstance().getHotelService()
				.findAllRoomtype(
						" where " + Roomtype.COL_hotelid + "="
								+ roomtype.getHotelid(), "ORDER BY ID ", -1, 0);
		hotel.setName(new String(this.hotel.getName().getBytes("ISO8859-1"),
				"GBK"));
		String where = " where 1=1 and " + hotelprice.COL_hotelid + " = "
				+ hotelprice.getHotelid();
		List list = Server.getInstance().getHotelService()
				.findAllHotelpriceForPageinfo(
						where,
						"order by " + Hotelprice.COL_datenumber + ","
								+ Hotelprice.COL_roomid + " asc", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		this.listHotelprice = list;
		return "price_check";
	}

	public void priceQuerybydatenumber() throws Exception {
		prosceniumNo = 0;
		getDate = 0;
		hotel.setName(new String(this.hotel.getName().getBytes("ISO8859-1"),
				"GBK"));
		String where = " where 1=1 and " + hotelprice.COL_datenumber + "= '"
				+ hotelprice.getDatenumber() + "' and "
				+ hotelprice.COL_hotelid + "=" + hotelprice.getHotelid()
				+ " and " + hotelprice.COL_roomid + "="
				+ hotelprice.getRoomid();

		String roomWhere = " where 1=1 and " + Roomtype.COL_hotelid + " = "
				+ hotelprice.getHotelid();
		listRoomtype = Server.getInstance().getHotelService()
				.findAllRoomtype(roomWhere, "ORDER BY ID ", -1, 0);

		String datenumberWhere = " where 1=1 and " + hotelprice.COL_roomid
				+ " = " + hotelprice.getRoomid() + " and "
				+ hotelprice.COL_hotelid + "=" + hotelprice.getHotelid();
		listHotelprice = Server.getInstance().getHotelService()
				.findAllHotelprice(datenumberWhere, "ORDER BY ID ", -1, 0);

		List<Hotelprice> list = Server.getInstance().getHotelService()
				.findAllHotelprice(where, "ORDER BY ID ", -1, 0);
		if (list.size() != 0) {
			this.hotelprice = list.get(0);
			// System.out.println(this.hotelprice);
			roomtype.setHotelid(hotelprice.getHotelid());
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(hotelprice
					.getDatenumber()
					+ "-01"));

			showPrices = new String[cal.get(Calendar.DAY_OF_WEEK) - 1
					+ cal.getActualMaximum(Calendar.DAY_OF_MONTH)];
			int count = 1;
			for (int i = cal.get(Calendar.DAY_OF_WEEK) - 1; i < showPrices.length; i++) {
				showPrices[i] = ((Double) hotelprice.getClass().getMethod(
						"getNo" + count).invoke(hotelprice)).toString();
				count++;
			}
		}
	}

	public Long formatTimestamp(String date) throws ParseException {
		return (new SimpleDateFormat("yyyy/MM/dd").parse(date).getTime());
	}

	public Object getModel() {
		return hotel;
	}

	public List<Hotel> getListHotel() {
		return listHotel;
	}



	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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

	public List<Province> getListProvinces() {
		return listProvinces;
	}

	public void setListProvinces(List<Province> listProvinces) {
		this.listProvinces = listProvinces;
	}

	public List<City> getListCities() {
		return listCities;
	}

	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}

	public String getH_enname() {
		return h_enname;
	}

	public void setH_enname(String h_enname) {
		this.h_enname = h_enname;
	}

	public String getH_hotelname() {
		return h_hotelname;
	}

	public void setH_hotelname(String h_hotelname) {
		this.h_hotelname = h_hotelname;
	}

	public Integer getH_cityId() {
		return h_cityId;
	}

	public void setH_cityId(Integer id) {
		h_cityId = id;
	}

	public Integer getH_provinceId() {
		return h_provinceId;
	}

	public void setH_provinceId(Integer id) {
		h_provinceId = id;
	}

	public Integer getH_recommend() {
		return h_recommend;
	}

	public void setH_recommend(Integer h_recommend) {
		this.h_recommend = h_recommend;
	}

	public Integer getH_repair() {
		return h_repair;
	}

	public void setH_repair(Integer h_repair) {
		this.h_repair = h_repair;
	}

	public Integer getH_star() {
		return h_star;
	}

	public void setH_star(Integer h_star) {
		this.h_star = h_star;
	}

	public Integer getH_state() {
		return h_state;
	}

	public String[] getCardType() {
		return cardType;
	}

	public void setCardType(String[] cardType) {
		this.cardType = cardType;
	}

	public void setH_state(Integer h_state) {
		this.h_state = h_state;
	}

	public Integer getH_type() {
		return h_type;
	}

	public void setH_type(Integer h_type) {
		this.h_type = h_type;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String[] getServiceItem() {
		return serviceItem;
	}

	public void setServiceItem(String[] serviceItem) {
		this.serviceItem = serviceItem;
	}

	public String[] getEatery() {
		return eatery;
	}

	public void setEatery(String[] eatery) {
		this.eatery = eatery;
	}

	public String[] getPlayItem() {
		return playItem;
	}

	public void setPlayItem(String[] playItem) {
		this.playItem = playItem;
	}

	public String[] getWebSign() {
		return webSign;
	}

	public void setWebSign(String[] webSign) {
		this.webSign = webSign;
	}

	public Hotelprice getHotelprice() {
		return hotelprice;
	}

	public void setHotelprice(Hotelprice hotelprice) {
		this.hotelprice = hotelprice;
	}

	public Roomtype getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public String[] getShowPrices() {
		return showPrices;
	}

	public void setShowPrices(String[] showPrices) {
		this.showPrices = showPrices;
	}

	public String getCheckdescStr() {
		return checkdescStr;
	}

	public void setCheckdescStr(String checkdescStr) {
		this.checkdescStr = checkdescStr;
	}

	public Integer getDdlArea() {
		return ddlArea;
	}

	public void setDdlArea(Integer ddlArea) {
		this.ddlArea = ddlArea;
	}

	public Integer getDdlBuss() {
		return ddlBuss;
	}

	public void setDdlBuss(Integer ddlBuss) {
		this.ddlBuss = ddlBuss;
	}

	public Integer getSelect() {
		return select;
	}

	public void setSelect(Integer select) {
		this.select = select;
	}

	public String getOpendateStr() {
		return opendateStr;
	}

	public void setOpendateStr(String opendateStr) {
		this.opendateStr = opendateStr;
	}

	public String getOtherCard() {
		return otherCard;
	}

	public void setOtherCard(String otherCard) {
		this.otherCard = otherCard;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Region> getRegionlist() {
		return regionlist;
	}

	public void setRegionlist(List<Region> regionlist) {
		this.regionlist = regionlist;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public int getF_state() {
		return f_state;
	}

	public void setF_state(int f_state) {
		this.f_state = f_state;
	}

	public List<Roomtype> getRoomtypes() {
		return roomtypes;
	}

	public void setRoomtypes(List<Roomtype> roomtypes) {
		this.roomtypes = roomtypes;
	}

	public List<Landmark> getLmarks() {
		return lmarks;
	}

	public void setLmarks(List<Landmark> lmarks) {
		this.lmarks = lmarks;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getHotelp_deptprice() {
		return hotelp_deptprice;
	}

	public void setHotelp_deptprice(String hotelp_deptprice) {
		this.hotelp_deptprice = hotelp_deptprice;
	}

	public int getCheckrad() {
		return checkrad;
	}

	public void setCheckrad(int checkrad) {
		this.checkrad = checkrad;
	}

	public long getCityid2() {
		return cityid2;
	}

	public void setCityid2(long cityid2) {
		this.cityid2 = cityid2;
	}

	public Hotellinkman getHotellinkman() {
		return hotellinkman;
	}

	public void setHotellinkman(Hotellinkman hotellinkman) {
		this.hotellinkman = hotellinkman;
	}

	public List<City> getListinCities() {
		return listinCities;
	}

	public void setListinCities(List<City> listinCities) {
		this.listinCities = listinCities;
	}

	public int getLan() {
		return lan;
	}

	public void setLan(int lan) {
		this.lan = lan;
	}

	public int getUco() {
		return uco;
	}

	public void setUco(int uco) {
		this.uco = uco;
	}
	
	public static void main(String[] args) {
		try {
			Workbook hotelbook = Workbook.getWorkbook(new FileInputStream("C:\\Users\\Administrator\\Desktop\\jiudian3.xls"));
			Sheet sheetHotel = hotelbook.getSheet(0);

			Hotel hotel = new Hotel();

			// Cell test=sheetHotel.getCell(2, 1);
			// System.out.println(test.getContents()+" 测试----------------");

			// 酒店序号
			// Cell hot1= sheetHotel.getCell(0,i);
		//	sheetHotel.getRows();
			// 酒店名称
			Cell hot2 = sheetHotel.getCell(0, 1);
			hotel.setName(hot2.getContents());
			// 英文名称
			Cell en_name = sheetHotel.getCell(2, 17);
			hotel.setEnname(en_name.getContents());
			// 简拼
		//	Cell jp_name = sheetHotel.getCell(2, 3);
		//	hotel.setJpname(jp_name.getContents());

			// 酒店星级
			Cell hot3 = sheetHotel.getCell(2, 2);
			System.out.println(hot3.getContents());
			if (hot3.getContents().equals("1")) {
				hotel.setStar(1);
			}
			if (hot3.getContents().equals("-2")) {
				hotel.setStar(2);
			}
			if (hot3.getContents().equals("2")) {
				hotel.setStar(3);
			}
			if (hot3.getContents().equals("-3")) {
				hotel.setStar(4);
			}
			if (hot3.getContents().equals("3")) {
				hotel.setStar(5);
			}
			if (hot3.getContents().equals("-1")) {
				hotel.setStar(6);
			}
			if (hot3.getContents().equals("4")) {
				hotel.setStar(7);
			}
			if (hot3.getContents().equals("-5")) {
				hotel.setStar(8);
			}
			if (hot3.getContents().equals("5")) {
				hotel.setStar(9);
			}
			// 酒店类型
		/*	Cell h_type = sheetHotel.getCell(2, 6);
			if (h_type.getContents().equals("公寓式")) {
				hotel.setType(1);
			}
			if (h_type.getContents().equals("会议型")) {
				hotel.setType(2);
			}
			if (h_type.getContents().equals("度假型")) {
				hotel.setType(3);
			}
			if (h_type.getContents().equals("观光型")) {
				hotel.setType(4);
			}
			if (h_type.getContents().equals("综合型")) {
				hotel.setType(5);
			}
			if (h_type.getContents().equals("机场型")) {
				hotel.setType(6);
			}`
			if (h_type.getContents().equals("别墅型")) {
				hotel.setType(7);
			}
			if (h_type.getContents().equals("商务型")) {
				hotel.setType(8);
			}*/
			// 房间总数
			/*Cell h_rooms = sheetHotel.getCell(2, 7);
			try {
				hotel.setRooms(Integer.parseInt(h_rooms.getContents()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}*/

			// 装修级别
			/*Cell h_repair = sheetHotel.getCell(2, 8);
			if (h_repair.getContents().equals("豪华")) {
				hotel.setRepair(1);
			}
			if (h_repair.getContents().equals("高档")) {
				hotel.setRepair(2);
			}
			if (h_repair.getContents().equals("舒适")) {
				hotel.setRepair(3);
			}
			if (h_repair.getContents().equals("经济")) {
				hotel.setRepair(4);
			}*/
			// 开业时间
			/*Cell open_date = sheetHotel.getCell(2, 9);
			System.out.println(open_date.getContents());
			try {
				Date aaaa = format.parse(open_date.getContents());
				hotel.setOpendate(new java.sql.Date(aaaa.getTime()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}*/
			// 装修时间
			/*Cell repail_date = sheetHotel.getCell(2, 10);
			hotel.setRepaildate(repail_date.getContents());*/
			// 主楼高度
			/*Cell main_level = sheetHotel.getCell(2, 11);
			try {
				hotel.setMainlevel(Integer.parseInt(main_level.getContents()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}
*/
			// 附楼高度
			/*Cell append_lever = sheetHotel.getCell(2, 12);
			try {
				hotel.setAppendlever(Integer.parseInt(append_lever
						.getContents()));
			} catch (Exception e) {
				// TODO: handle exception
				f_state = -1;
				e.printStackTrace();
			}*/

			// 酒店简介
			Cell hot4 = sheetHotel.getCell(2, 24);
			hotel.setDescription(hot4.getContents());
			// 预订要求
			Cell h_prespec = sheetHotel.getCell(2, 18);
			hotel.setPrespec(h_prespec.getContents());
			// 酒店特色
			Cell sell_point = sheetHotel.getCell(2, 16);
			hotel.setSellpoint(sell_point.getContents());
			// 酒店全称
			Cell full_name = sheetHotel.getCell(2, 1);
			hotel.setFullname(full_name.getContents());
			// 开户行
			
			try {
				Server.getInstance().getHotelService().createHotel(hotel);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			
			System.out.println("我在BiffException");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.out.println("我在IOException");
			e.printStackTrace();
		}
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getStatetime() {
		return statetime;
	}

	public void setStatetime(String statetime) {
		this.statetime = statetime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getHoteltype() {
		return hoteltype;
	}

	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}

	public String getHotelorderstate() {
		return hotelorderstate;
	}

	public void setHotelorderstate(String hotelorderstate) {
		this.hotelorderstate = hotelorderstate;
	}

	public List<Hotelorder> getListHotelorder() {
		return listHotelorder;
	}

	public void setListHotelorder(List<Hotelorder> listHotelorder) {
		this.listHotelorder = listHotelorder;
	}

	public List<Guest> getListGuest() {
		return listGuest;
	}

	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}

	public int getJianye() {
		return jianye;
	}

	public void setJianye(int jianye) {
		this.jianye = jianye;
	}

	public double getZongjia() {
		return zongjia;
	}

	public void setZongjia(double zongjia) {
		this.zongjia = zongjia;
	}

	public List<Hotellinkman> getListHotellinkman() {
		return listHotellinkman;
	}

	public void setListHotellinkman(List<Hotellinkman> listHotellinkman) {
		this.listHotellinkman = listHotellinkman;
	}

	public Hotelspec getHotelspec() {
		return hotelspec;
	}

	public void setHotelspec(Hotelspec hotelspec) {
		this.hotelspec = hotelspec;
	}

	public List<Hotelspec> getListhotelspec() {
		return listhotelspec;
	}

	public void setListhotelspec(List<Hotelspec> listhotelspec) {
		this.listhotelspec = listhotelspec;
	}

	public Hotellandmark getHotellandmark() {
		return hotellandmark;
	}

	public void setHotellandmark(Hotellandmark hotellandmark) {
		this.hotellandmark = hotellandmark;
	}

	public List<Hotellandmark> getListhotellandmark() {
		return listhotellandmark;
	}

	public void setListhotellandmark(List<Hotellandmark> listhotellandmark) {
		this.listhotellandmark = listhotellandmark;
	}

	public Roomstate getRoomstate() {
		return roomstate;
	}

	public void setRoomstate(Roomstate roomstate) {
		this.roomstate = roomstate;
	}

	public List<Roomstate> getListroomstate() {
		return listroomstate;
	}

	public void setListroomstate(List<Roomstate> listroomstate) {
		this.listroomstate = listroomstate;
	}

	public List<Roomtype> getListRoomtype() {
		return listRoomtype;
	}

	public void setListRoomtype(List<Roomtype> listRoomtype) {
		this.listRoomtype = listRoomtype;
	}



	public void setListHotelprice(List listHotelprice) {
		this.listHotelprice = listHotelprice;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

	public long getPai() {
		return pai;
	}

	public void setPai(long pai) {
		this.pai = pai;
	}

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public String getIszhutui() {
		return iszhutui;
	}

	public void setIszhutui(String iszhutui) {
		this.iszhutui = iszhutui;
	}

	public String getHotelid() {
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}

	public Integer getH_laiyuan() {
		return h_laiyuan;
	}

	public void setH_laiyuan(Integer h_laiyuan) {
		this.h_laiyuan = h_laiyuan;
	}

	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}

	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}

	public int getS_name() {
		return s_name;
	}

	public void setS_name(int s_name) {
		this.s_name = s_name;
	}

	public void setListHotel(List listHotel) {
		this.listHotel = listHotel;
	}

	public List<Country> getListCountry() {
		return listCountry;
	}

	public void setListCountry(List<Country> listCountry) {
		this.listCountry = listCountry;
	}

	public List<Incity> getListIncity() {
		return listIncity;
	}

	public void setListIncity(List<Incity> listIncity) {
		this.listIncity = listIncity;
	}

	public String getCouid() {
		return couid;
	}

	public void setCouid(String couid) {
		this.couid = couid;
	}
	
}