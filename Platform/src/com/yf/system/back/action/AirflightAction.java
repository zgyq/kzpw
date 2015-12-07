/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.yf.system.back.server.Server;
import com.yf.system.base.airflight.Airflight;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.flightinfo.CarbinInfo;
import com.yf.system.base.flightinfo.FlightInfo;
import com.yf.system.base.flightinfo.FlightSearch;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.zrate.Zrate;

public class AirflightAction extends B2b2cbackAction {
	private static final long serialVersionUID = 4247491703275711095L;
	private List<Airflight> listAirflight;
	private Airflight airflight = new Airflight();
	private List<FlightInfo> listFlightInfoAll;
	private FlightSearch flightSearch = new FlightSearch();
	private List<CarbinInfo>listCarbin=new ArrayList<CarbinInfo>();
	private List<Passenger> listPassenger;
	private List<Segmentinfo> listSegmentinfo;
	private Orderinfo orderinfo=new Orderinfo();
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	 private String s_name;

	 private String depDate;//出发日期
	 private String StartAirportCode;//出发机场三字码
	 private String EndAirportCode;//到达三字码
	 private String AirCompanyCode;//航空公司
	 private String AgentCode="";//代码
	 private String FlightNO;//航班号
	 private String CabinCode;//仓位吗
	 //下单用参数
	 private String Flightmodel;//机型       例:380
	 private String PassName;//乘机人姓名,多人用,分隔
	 private String IdType;//乘机人证件类型,多人用,分隔
	 private String IdNo;//乘机人证件号码,多人用,分隔
	 private String arrtime;//到达日期  例  2012-05-12 07:40:00.000
	 private String Price;//票面价
	 private String Portfee;//基建费
	 private String Fuelfee;//燃油费
	 private String Linkname;//联系人
	 private String Linktel;//联系人电话
	 private String ZrateID;//政策ID
	 private String ZrateValue;//政策返点
	 
		//错误信息
	public String errManger;
	public String GetCabinType(Float discont,String cabincode){
		System.out.println("discont:"+discont);
		if(cabincode.equals("P")&&discont>200){
			return "豪华头等舱";
		}
		if(cabincode.equals("P")&&discont>0&&discont<100){
			return "经济舱";
		}
		if(cabincode.equals("A")&&discont>200){
			return "头等舱";
		}
		if(cabincode.equals("A")&&discont>0&&discont<100){
			return "经济舱";
		}
		if(cabincode.equals("P")){
			return "超值头等舱";
		}
		if(cabincode.equals("Z")&&discont>0&&discont<100){
			return "经济舱";
		}
		
		
		if(cabincode.equals("F")||cabincode.equals("A")||cabincode.equals("Z")){
			return "头等舱";
		}
		
		if((discont==100)){
			return "全价舱";
		}
		
		if((discont>=40&&discont<100)){
			return "经济舱";
		}
		if((discont<40)){
			return "特价舱";
		}	
		
		
		return "经济舱";
	}
	
	
	public String CreateOrderBySeginfo() throws Exception {
		if(AgentCode==null||AgentCode.trim().length()==0){
			errManger="代理编号为空";
			return "airerr";
		}
		List<Customeragent>listagent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 AND "+Customeragent.COL_agentisenable+" =1 and "+Customeragent.COL_code+" ='"+AgentCode+"'", " ORDER BY ID ", -1, 0);
		if(listagent.size()==0){
			errManger="没有对应的代理";
			return "airerr";
		}
		
		if(StartAirportCode==null||StartAirportCode.trim().length()==0||StartAirportCode.trim().length()!=3){
			errManger="出发三字码错误;格式例如:PEK";
			return "airerr";
		}
		if(EndAirportCode==null||EndAirportCode.trim().length()==0||EndAirportCode.trim().length()!=3){
			errManger="到达三字码错误;格式例如:SHA";
			return "airerr";
		}
		if(FlightNO==null||FlightNO.trim().length()==0||FlightNO.trim().length()>7){
			errManger="航班号错误;格式例如CA8888";
			return "airerr";
		}
		if(depDate==null||depDate.trim().length()==0||depDate.trim().length()!=23){
			errManger="起飞时间错误;格式例如XXXX-XX-XX XX:XX:XX.XXX";
			return "airerr";
		}
		if(arrtime==null||arrtime.trim().length()==0||arrtime.trim().length()!=23){
			errManger="到达时间错误;格式例如XXXX-XX-XX XX:XX:XX.XXX";
			return "airerr";
		}
		
		if(CabinCode==null||CabinCode.trim().length()==0||CabinCode.trim().length()>40){
			errManger="仓位码错误;格式例如Y 或者A,B,C,Y";
			return "airerr";
		}
		if(Flightmodel==null||Flightmodel.trim().length()==0||Flightmodel.trim().length()>40){
			errManger="机型信息错误;格式例如380";
			return "airerr";
		}
		if(PassName==null||PassName.trim().length()==0){
			errManger="乘机人姓名不能为空";
			return "airerr";
		}
		if(IdType==null||IdType.trim().length()==0){
			errManger="证件类型不能为空";
			return "airerr";
		}
		if(IdNo==null||IdNo.trim().length()==0){
			errManger="证件号码不能为空";
			return "airerr";
		}
		if(Price==null||Price.trim().length()==0){
			errManger="票面价不能为空";
			return "airerr";
		}
		if(Portfee==null||Portfee.trim().length()==0){
			errManger="基建费不能为空";
			return "airerr";
		}
		if(Fuelfee==null||Fuelfee.trim().length()==0){
			errManger="燃油费不能为空";
			return "airerr";
		}
		if(Linkname==null||Linkname.trim().length()==0){
			errManger="联系人不能为空";
			return "airerr";
		}
		if(Linktel==null||Linktel.trim().length()==0){
			errManger="联系电话不能为空";
			return "airerr";
		}
		if(ZrateID==null||ZrateID.trim().length()==0){
			errManger="政策ID不能为空";
			return "airerr";
		}
		if(ZrateValue==null||ZrateValue.trim().length()==0){
			errManger="政策返点不能为空";
			return "airerr";
		}
		
		listPassenger =new ArrayList<Passenger>();
		
		String[] passnames=PassName.split(",");
		String[] IdTypes=IdType.split(",");
		String[] IdNos=IdNo.split(",");
		if(passnames!=null&&passnames.length>0){
			for(int p=0;p<passnames.length;p++){
				if(passnames[p]!=null&&passnames[p].trim().length()>0){
					Passenger passenger=new Passenger();
					passenger.setName(passnames[p].trim());
					if(IdTypes[p]!=null&&IdTypes[p].trim().length()>0){
					passenger.setIdtype(Integer.parseInt(IdTypes[p].trim()));
					}
					if(IdNos[p]!=null&&IdNos[p].trim().length()>0){
					passenger.setIdnumber(IdNos[p].trim());
					}
					passenger.setPrice(Float.parseFloat(Price));
					passenger.setAirportfee(Float.parseFloat(Portfee));
					passenger.setFuelprice(Float.parseFloat(Fuelfee));
					listPassenger.add(passenger);
				}
			}
		}
		if(listPassenger.size()==0){
			errManger="乘机人为空";
			return "airerr";
		}
		if(listPassenger.size()>9){
			errManger="一次订单提交乘机人数量不能大于9";
			return "airerr";
		}
		
		listSegmentinfo=new ArrayList<Segmentinfo>();
		Segmentinfo segmentinfo=new Segmentinfo();
		segmentinfo.setStartairport(StartAirportCode);
		segmentinfo.setEndairport(EndAirportCode);
		listSegmentinfo.add(segmentinfo);
		
		
		
		
		
		
		
		return "";
		
	}
	
	public String SearchAirFlightZrate() throws Exception {
		if(StartAirportCode==null||StartAirportCode.trim().length()==0||StartAirportCode.trim().length()!=3){
			errManger="出发三字码错误;格式例如:PEK";
			return "airerr";
		}
		if(EndAirportCode==null||EndAirportCode.trim().length()==0||EndAirportCode.trim().length()!=3){
			errManger="到达三字码错误;格式例如:SHA";
			return "airerr";
		}
		if(FlightNO==null||FlightNO.trim().length()==0||FlightNO.trim().length()>7){
			errManger="航班号错误;格式例如CA8888";
			return "airerr";
		}
		if(depDate==null||depDate.trim().length()==0||depDate.trim().length()!=10){
			errManger="出发日期错误;格式例如XXXX-XX-XX";
			return "airerr";
		}
		if(CabinCode==null||CabinCode.trim().length()==0||CabinCode.trim().length()>40){
			errManger="仓位码错误;格式例如Y 或者A,B,C,Y";
			return "airerr";
		}
		if(AgentCode==null||AgentCode.trim().length()==0){
			errManger="没有对应的代理";
			return "airerr";
		}
		List<Customeragent>listagent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 AND "+Customeragent.COL_agentisenable+" =1 and "+Customeragent.COL_code+" ='"+AgentCode+"'", " ORDER BY ID ", -1, 0);
		if(listagent.size()==0){
			errManger="没有对应的代理;";
			return "airerr";
		}
		
		String[] cabins=CabinCode.trim().split(",");
		if(cabins!=null&&cabins.length>0){
			for(int a=0;a<cabins.length;a++){
				if(cabins[a]!=null&&cabins[a].trim().length()>0){
					CarbinInfo carbinInfo=new CarbinInfo();
					Float zratevalue=0f;
					//匹配政策开始
						Calendar cal=Calendar.getInstance(); 
					    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
					    String mDateTime=formatter.format(cal.getTime());
					    String strSP="[dbo].[sp_GetZrateByFlight] "+
						"@chufajichang = N'"+StartAirportCode+"',@daodajichang = N'"+EndAirportCode+"',"+
						"@chufariqi = N'"+depDate+"',@dangqianshijian= N'"+mDateTime+"',"+
						"@hangkonggongsi= N'"+FlightNO.substring(0, 2).trim()+"',"+
						"@cangwei= N'"+cabins[a].trim()+"',@hangbanhao= N'"+FlightNO.trim().substring(2, FlightNO.trim().length())+"',@ismulity=0,@isgaofan=1";
					    System.out.println(strSP);
					    
					   List  listz=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
					    System.out.println(listz);
					  
						
						if(listz.size()>0){
							Zrate zrate= new Zrate();
							for(int s=0;s<listz.size();s++){
								
								Map map=(Map)listz.get(s);
								
								//zrate=Server.getInstance().getAirService().findZrate(Long.parseLong(map.get("zrateid").toString().trim()));
								
								zratevalue=Getliudianvalue2(Float.parseFloat(map.get("zratevalue").toString().trim()), listagent.get(0));
								
								carbinInfo.setRatevalue(zratevalue);
								carbinInfo.setZrateid(Long.parseLong(map.get("zrateid").toString().trim()));
								carbinInfo.setCabin(cabins[a].trim());
								
								break;
							}
							System.out.println("zratevalue:"+zratevalue);
						}
						
						//匹配结束
						listCarbin.add(carbinInfo);
				}
				
			}
		}
		
		
		
		
		
		
		return "AirFlightZrate";
	}
	
	public String SearchAirFlight() throws Exception {
		if(AirCompanyCode==null||AirCompanyCode.length()==0){
			AirCompanyCode="ALL";
		}
		if(AgentCode==null||AgentCode.trim().length()==0){
			errManger="没有对应的代理";
			return "airerr";
		}
		if(StartAirportCode==null||StartAirportCode.trim().length()==0){
			errManger="出发三字码为空!";
			return "airerr";
		}
		if(EndAirportCode==null||EndAirportCode.trim().length()==0){
			errManger="到达三字码为空!";
			return "airerr";
		}
		if(depDate==null||depDate.trim().length()==0){
			errManger="出发日期为空!";
			return "airerr";
		}
		if(depDate.length()!=10){
			errManger="出发日期格式错误!准确格式XXXX-XX-XX";
			return "airerr";
		}
		List<Customeragent>listagent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 AND "+Customeragent.COL_agentisenable+" =1 and "+Customeragent.COL_code+" ='"+AgentCode+"'", " ORDER BY ID ", -1, 0);
		if(listagent.size()==0){
			errManger="没有对应的代理";
			return "airerr";
		}
		
		
		
		flightSearch.setAirCompanyCode(AirCompanyCode);
		flightSearch.setEndAirportCode(EndAirportCode);
		flightSearch.setStartAirportCode(StartAirportCode);
		flightSearch.setFromDate(depDate);
		//flightSearch.setTravelType(flightSearch.getTravelType());
		listFlightInfoAll = Server.getInstance().getTicketSearchService()
		.findAllFlightinfo(flightSearch);
		
		System.out.println(listFlightInfoAll.size());
		if(listFlightInfoAll!=null&&listFlightInfoAll.size()>10000){
			System.out.println("匹配返点");
		for(int a=0;a<listFlightInfoAll.size();a++){
			
		List<CarbinInfo>listCarbinInfo=listFlightInfoAll.get(a).getCarbins();
		 if(listCarbinInfo!=null&&listCarbinInfo.size()>0){
			 for(int c=0;c<listCarbinInfo.size();c++){
				 Float zratevalue=0f;
				 zratevalue=Getliudianvalue2(listCarbinInfo.get(c).getRatevalue(), listagent.get(0));
					listCarbinInfo.get(c).setRatevalue(zratevalue);
			 }
		 }
		}
		
		}
		
		return "airlist";
	}
	
	
	
	/**
	 * 列表查询航班基础信息表
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Airflight.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		if (airflight.getSairportcode() != null
				&& !"".equals(airflight.getSairportcode())) {
			where += " and " + Airflight.COL_sairportcode + " like '%"
					+ airflight.getSairportcode() + "%'";
		}

		if (airflight.getEairportcode() != null
				&& !"".equals(airflight.getEairportcode())) {
			where += " and " + Airflight.COL_eairportcode + " like '%"
					+ airflight.getEairportcode() + "%'";
		}

		if (airflight.getAircompanycode() != null
				&& !"".equals(airflight.getAircompanycode())) {
			where += " and " + Airflight.COL_aircompanycode + " like '%"
					+ airflight.getAircompanycode() + "%'";
		}

		if (airflight.getFlightnumber() != null
				&& !"".equals(airflight.getFlightnumber())) {
			where += " and " + Airflight.COL_flightnumber + " like '%"
					+ airflight.getFlightnumber() + "%'";
		}

		List list = Server.getInstance().getAirService()
				.findAllAirflightForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listAirflight = list;
		if (pageinfo.getTotalrow() > 0 && listAirflight.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllAirflightForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listAirflight = list;
		}

		return SUCCESS;
	}
	/**
	 * 转向到航班基础信息表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到航班基础信息表修改页面
	 */
	public String toedit() throws Exception {
		airflight = Server.getInstance().getAirService().findAirflight(
				airflight.getId());
		return EDIT;
	}

	/**
	 * 转向到航班基础信息表审核页面
	 */
	public String docheck() throws Exception {
		airflight = Server.getInstance().getAirService().findAirflight(
				airflight.getId());
		if (airflight.getIsenable() == 1) {
			airflight.setIsenable(0);
		} else {
			airflight.setIsenable(1);
		}
		Server.getInstance().getAirService().updateAirflightIgnoreNull(airflight);
		return "list2";
	}

	/**
	 * 添加航班基础信息表
	 */
	public String add() throws Exception {
		airflight.setCreateuser(getLoginUser().getLoginname());
		airflight.setCreateusertime(new Timestamp(System.currentTimeMillis()));
		airflight.setModifyuser(getLoginUser().getLoginname());
		airflight.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().createAirflight(airflight);
		return LIST;
	}

	/**
	 * 审核航班基础信息表
	 */
	public String check() throws Exception {
		airflight.setModifyuser(getLoginUser().getLoginname());
		airflight.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateAirflightIgnoreNull(
				airflight);
		return LIST;
	}

	/**
	 * 编辑航班基础信息表
	 */
	public String edit() throws Exception {
		airflight.setModifyuser(getLoginUser().getLoginname());
		airflight.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateAirflightIgnoreNull(
				airflight);
		return LIST;
	}

	/**
	 * 删除航班基础信息表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteAirflight(airflight.getId());
		return LIST;
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
					Server.getInstance().getAirService().deleteAirflight(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回航班基础信息表对象
	 */

	public Object getModel() {
		return airflight;
	}

	public List<Airflight> getListAirflight() {
		return listAirflight;
	}

	public void setListAirflight(List<Airflight> listAirflight) {
		this.listAirflight = listAirflight;
	}

	public Airflight getAirflight() {
		return airflight;
	}

	public void setAirflight(Airflight airflight) {
		this.airflight = airflight;
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



	public List<FlightInfo> getListFlightInfoAll() {
		return listFlightInfoAll;
	}



	public void setListFlightInfoAll(List<FlightInfo> listFlightInfoAll) {
		this.listFlightInfoAll = listFlightInfoAll;
	}



	public FlightSearch getFlightSearch() {
		return flightSearch;
	}



	public void setFlightSearch(FlightSearch flightSearch) {
		this.flightSearch = flightSearch;
	}



	public String getS_name() {
		return s_name;
	}



	public void setS_name(String s_name) {
		this.s_name = s_name;
	}



	public String getDepDate() {
		return depDate;
	}



	public void setDepDate(String depDate) {
		this.depDate = depDate;
	}



	public String getStartAirportCode() {
		return StartAirportCode;
	}



	public void setStartAirportCode(String startAirportCode) {
		StartAirportCode = startAirportCode;
	}



	public String getEndAirportCode() {
		return EndAirportCode;
	}



	public void setEndAirportCode(String endAirportCode) {
		EndAirportCode = endAirportCode;
	}



	public String getAirCompanyCode() {
		return AirCompanyCode;
	}



	public void setAirCompanyCode(String airCompanyCode) {
		AirCompanyCode = airCompanyCode;
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public String getAgentCode() {
		return AgentCode;
	}



	public void setAgentCode(String agentCode) {
		AgentCode = agentCode;
	}

	public List<CarbinInfo> getListCarbin() {
		return listCarbin;
	}

	public void setListCarbin(List<CarbinInfo> listCarbin) {
		this.listCarbin = listCarbin;
	}

	public String getFlightNO() {
		return FlightNO;
	}

	public void setFlightNO(String flightNO) {
		FlightNO = flightNO;
	}

	public String getCabinCode() {
		return CabinCode;
	}

	public void setCabinCode(String cabinCode) {
		CabinCode = cabinCode;
	}

	public String getErrManger() {
		return errManger;
	}

	public void setErrManger(String errManger) {
		this.errManger = errManger;
	}

}