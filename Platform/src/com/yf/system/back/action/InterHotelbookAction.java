package com.yf.system.back.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.country.Country;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelpass.Hotelpass;
import com.yf.system.base.incity.Incity;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.ymsend.Ymsend;
import com.opensymphony.webwork.ServletActionContext;

/**
 * 酒店预订Action
 * 
 */
public class InterHotelbookAction extends B2b2cbackAction {
	
	private Map<Long,Hotel> maphotel = new HashMap<Long,Hotel>();//酒店--房型
	private Map<Long,Map<Long,Hotel>> maphotelroom = new HashMap<Long,Map<Long,Hotel>>();//酒店--房型
	private Hotelorder hotelorder = new Hotelorder();
	private List<Hotel> listhotelbj;
	private List<Guest> listGuest;
	private List<Hotel> listHotelPrice = new ArrayList();
	// 酒店常用旅客
	private List<Hotelpass> listHotelpasa;
	private List<Country> listCountry;
	private List<Incity> listIncity;
	private List<Hotelimage> ListHotelimage;
	private List<Hotel> hotelList;
	private Hotel hotel = new Hotel();
	private Guest guest = new Guest();
	private int countryid;
	private int roomid;
	private List Listprice = new ArrayList();
	private int cityId;
	private long hotelid;
	private long hotelorderid;
	private String roomname;
	private String bedname;
	//每日平均价格
	private Double junjia;	
	// 入住日期
	private String startDate;
	// 离店日期
	private String endDate;
	
	//房型类型
	private String roomtype;
	
	//间数
	private String roomnum;
	
	//排序
	private int orderType;
	private int orderMode;
//接口返回
	
	private String sub;
	
	//酒店价格单价
	private Double price;
	//酒店早餐价
	private Double breakfastPrice;
	
	//总价
	private Double zongjia;
	//价格单位
	private String Currency;
	//验证价格单位
	private String ifCurrency;
	//验证酒店价格单价
	private Double ifprice;
	
	//常用入住人解析
	private String InRoomPeople;
	private String InRoommobile;
	private String hidsex;
	private int add=0;	
	
	//日期
	
	private String Date1;
	private String Date2;
	private String Date3;
	private String Date4;
	private String Date5;
	private String Date6;
	private String Date7;
	//天数
	
	private long s_num;
	//调整路径
	
	private String forword;
	
	/**
	 * 根据城市ID获取城市名称--国际
	 */
	public String getInterCityNameByStr(String cityid)
	{
		Incity city=Server.getInstance().getInterHotelService().findIncity(Long.parseLong(cityid));
		return city != null && city.getName()!=null&& !"".equals(city.getName()) ? city.getName() : "";
	}

	public String execute() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		calendar.add(Calendar.DATE , 1);
		endDate = sdf.format(calendar.getTime());
	System.out.println("来到国际酒店首页");
	listCountry = Server.getInstance().getInterHotelService().findAllCountry(" where 1=1 and "+Country.COL_type+" =2", "", -1, 0);
	return SUCCESS;
	}
	public String seach() throws Exception {
		
		System.out.println("开始检索国际酒店!!!,国际ID=="+countryid+",城市ID="+cityId+",入住日期=="+startDate+",离店日期="+endDate+",房型="+roomtype+",间数= "+roomnum);
		
		String where =" where 1=1 and "+Hotel.COL_state+"=3 and "+Hotel.COL_type+"=2";
		if(cityId>0){
			where +=" and "+Hotel.COL_cityid+" ="+cityId;
			
		}
		
		// 排序
		String orderStr = "ORDER BY C_HOT";
		if(orderType == 1){
			
			orderStr = "order by C_STARTPRICE ";
		}
		if(orderType == 2){
			
			orderStr = "order by C_STARTPRICE DESC";
		}
		
		if(orderType == 3){
			
			orderStr = "order by C_STAR ";
		}
		
		if(orderType == 4){
			
			orderStr = "order by C_STAR DESC";
		}
		
		pageinfo.setPagerow(8);
		List list = Server.getInstance().getHotelService()
		.findAllHotelForPageinfo(where.toString(), orderStr, pageinfo);
	pageinfo = (PageInfo) list.remove(0);
		hotelList = list;
	
	if(pageinfo.getTotalrow()>0 &&   hotelList.size()==0){
		pageinfo.setPagenum(1);
		list = Server.getInstance().getHotelService().findAllHotelForPageinfo(where.toString()," ORDER BY C_HOT ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		hotelList = list;
	}
	System.out.println("where"+where);
	System.out.println("hotelList="+hotelList);	
	if(roomtype.equals("1")){
		roomid=1;
		roomname="SingleRoom";
		bedname="单人床";
	}
	if(roomtype.equals("2")){
		roomid=2;
		roomname="DoubleRoom";
		bedname="双人床";
	}
	if(roomtype.equals("3")){
		roomid=3;
		roomname="TripleRoom";
		bedname="三人床";
	}
	if(roomtype.equals("4")){
		roomid=4;
		roomname="FamilyRoom";
		bedname="多人床";
	}
	if(hotelList.size()>0){
		for(int a=0;a<hotelList.size();a++){
			try {
			String	hotelsub=Server.getInstance().getManGoHotelService().findInterHotelPriceByIdAndRoomType(hotelList.get(a), roomtype, roomnum+"", startDate, endDate);
					if(!hotelsub.equals("NO")){//有数据
						//System.out.println("hotelsub=="+hotelsub);
						Hotel h = new Hotel();
						String[] pr=hotelsub.split("-");
						Double price=Double.parseDouble(pr[0]);
						if(pr[1]!=null&&pr[1].length()>0&&!pr[1].equals("null")){
							
							Double BreakfastPrice=Double.parseDouble(pr[1]);
							h.setBreakfastPrice(BreakfastPrice);
						}
						
						String Currency=pr[2];
						
						h.setCurrency(Currency);
						
						h.setAmountAfterTax(price);
						maphotel.put(hotelList.get(a).getId(), h);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	getCommandHotelList(cityId);
		System.out.println("roomtype=="+roomtype);
		return "hotellist";
	}
	
	public String tohotelinfo() throws Exception{
		System.out.println("来到酒店info页面...hotelid=="+hotelid);
		hotel = Server.getInstance().getHotelService().findHotel(hotelid);
		
		try {
					String	hotelsub1=Server.getInstance().getManGoHotelService().findInterHotelPriceByIdAndRoomType(hotel, "1", roomnum+"", startDate, endDate);
					if(!hotelsub1.equals("NO")){//有数据
						System.out.println("hotelsub1=="+hotelsub1);
						Hotel h = new Hotel();
						String[] pr1=hotelsub1.split("-");
						Double price=Double.parseDouble(pr1[0]);
						if(pr1[1]!=null&&pr1[1].length()>0&&!pr1[1].equals("null")){
							
							Double BreakfastPrice=Double.parseDouble(pr1[1]);
							h.setBreakfastPrice(BreakfastPrice);
						}
						
						String Currency=pr1[2];
						
						h.setCurrency(Currency);
						h.setRoomtype(1);
						h.setAmountAfterTax(price);
						listHotelPrice.add(h);
						
						
					
					}
					//
					String	hotelsub2=Server.getInstance().getManGoHotelService().findInterHotelPriceByIdAndRoomType(hotel, "2", roomnum+"", startDate, endDate);
					if(!hotelsub2.equals("NO")){//有数据
						System.out.println("hotelsub2=="+hotelsub2);
						Hotel h = new Hotel();
						String[] pr2=hotelsub2.split("-");
						Double price=Double.parseDouble(pr2[0]);
						if(pr2[1]!=null&&pr2[1].length()>0&&!pr2[1].equals("null")){
							
							Double BreakfastPrice=Double.parseDouble(pr2[1]);
							h.setBreakfastPrice(BreakfastPrice);
						}
						
						String Currency=pr2[2];
						
						h.setCurrency(Currency);
						h.setRoomtype(2);
						h.setAmountAfterTax(price);
						listHotelPrice.add(h);
					
						
					}
					//
					String	hotelsub3=Server.getInstance().getManGoHotelService().findInterHotelPriceByIdAndRoomType(hotel, "3", roomnum+"", startDate, endDate);
					if(!hotelsub3.equals("NO")){//有数据
						System.out.println("hotelsub3=="+hotelsub3);
						Hotel h = new Hotel();
						String[] pr3=hotelsub3.split("-");
						Double price=Double.parseDouble(pr3[0]);
						if(pr3[1]!=null&&pr3[1].length()>0&&!pr3[1].equals("null")){
							
							Double BreakfastPrice=Double.parseDouble(pr3[1]);
							h.setBreakfastPrice(BreakfastPrice);
						}
						
						String Currency=pr3[2];
						
						h.setCurrency(Currency);
						h.setRoomtype(3);
						h.setAmountAfterTax(price);
						listHotelPrice.add(h);
						
						
						
					}
					//
					//
					String	hotelsub4=Server.getInstance().getManGoHotelService().findInterHotelPriceByIdAndRoomType(hotel, "4", roomnum+"", startDate, endDate);
					if(!hotelsub4.equals("NO")){//有数据
						System.out.println("hotelsub4=="+hotelsub4);
						Hotel h = new Hotel();
						String[] pr4=hotelsub4.split("-");
						Double price=Double.parseDouble(pr4[0]);
						if(pr4[1]!=null&&pr4[1].length()>0&&!pr4[1].equals("null")){
							
							Double BreakfastPrice=Double.parseDouble(pr4[1]);
							h.setBreakfastPrice(BreakfastPrice);
						}
						
						String Currency=pr4[2];
						
						h.setCurrency(Currency);
						h.setRoomtype(4);
						h.setAmountAfterTax(price);
						listHotelPrice.add(h);
						
						
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ListHotelimage =Server.getInstance().getHotelService().findAllHotelimage("where 1=1 and "+Hotelimage.COL_hotelid+" ="+hotelid, " ORDER BY ID ", -1, 0);
				cityId = Integer.parseInt(hotel.getCityid()+"");
				getCommandHotelList(cityId);
		return "hotelinfo";
	}
	
	public String tobook() throws Exception {
		System.out.println("来了预定方法!!!,酒店ID=="+hotelid+",房型=="+roomtype+",间数=="+roomnum+",入住时间=="+startDate+",离店日期=="+endDate);
		
		
		//登录拦截
		Customeruser  customeruser =getLoginUser();
		
		 hotel=Server.getInstance().getHotelService().findHotel(hotelid);
		//调取接口价格开始
		try {
			String	hotelsub2=Server.getInstance().getManGoHotelService().findInterHotelPriceByIdAndRoomType(hotel, roomtype, roomnum+"", startDate, endDate);
			if(!hotelsub2.equals("NO")){//有数据
				System.out.println("hotelsub2=="+hotelsub2);
				
				String[] pr2=hotelsub2.split("-");
				 price=Double.parseDouble(pr2[0]);
				 price=getinterhotelprice(price);
				 if(pr2[1]!=null&&pr2[1].length()>0&&!pr2[1].equals("null")){
				 breakfastPrice=Double.parseDouble(pr2[1]);
				 }
				 Currency=pr2[2];
				 
			}
		} catch (RuntimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//结束
		
		
		//周几信息
		
		SimpleDateFormat   df   =new   SimpleDateFormat("yyyy-MM-dd");        
        Date InDate1 =df.parse(startDate.trim());
        Date1=startDate.trim();
        
        Calendar d11=new GregorianCalendar();
        Date   d1=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式自己设置
        String baseDate=startDate.trim() ;//入住日期
        try{ //一定要放到try里面,不然会报错的
            d1   =   sdf.parse(baseDate);  
         }
         catch(Exception e){
         }
         d11.setTime(d1);
         
         //第二天日期
         d11.add(Calendar.DAY_OF_MONTH, 1);
         Date2=df.format(d11.getTime()).toString();
         System.out.println(Date2);
         //第三天日期
         Calendar d22=new GregorianCalendar();
         Date   d2=null;
         try{ //一定要放到try里面,不然会报错的
             d2   =   sdf.parse(Date2);  
          }
          catch(Exception e){
          }
          d22.setTime(d2);
         d22.add(Calendar.DAY_OF_MONTH, 1);
         Date3=df.format(d22.getTime()).toString();
         //第四天日期
         Calendar d33=new GregorianCalendar();
         Date   d3=null;
         try{ //一定要放到try里面,不然会报错的
             d3   =   sdf.parse(Date3);  
          }
          catch(Exception e){
          }
         d33.setTime(d3);
         d33.add(Calendar.DAY_OF_MONTH, 1);
         Date4=df.format(d33.getTime()).toString();
         //第五天日期
         Calendar d44=new GregorianCalendar();
         Date   d4=null;
         try{ //一定要放到try里面,不然会报错的
             d4   =   sdf.parse(Date4);  
          }
          catch(Exception e){
          }
         d44.setTime(d4);
         d44.add(Calendar.DAY_OF_MONTH, 1);
         Date5=df.format(d44.getTime()).toString();
         //第六天日期
         Calendar d55=new GregorianCalendar();
         Date   d5=null;
         try{ //一定要放到try里面,不然会报错的
             d5   =   sdf.parse(Date5);  
          }
          catch(Exception e){
          }
         d55.setTime(d5);
         d55.add(Calendar.DAY_OF_MONTH, 1);
         Date6=df.format(d55.getTime()).toString();
         //第七天日期
         Calendar d66=new GregorianCalendar();
         Date   d6=null;
         try{ //一定要放到try里面,不然会报错的
             d6   =   sdf.parse(Date6);  
          }
          catch(Exception e){
          }
         d66.setTime(d6);
         d66.add(Calendar.DAY_OF_MONTH, 1);
         Date7=df.format(d66.getTime()).toString();
		
         s_num = dateDiff(endDate.trim(), startDate.trim());
         for(int p=0;p<s_num;p++){
        	 
        	 Listprice.add(price);
         }
        
         zongjia=price*s_num;
        // String where=" where 1=1 and "+Hotelpass.COL_createuserid+" ="+getLoginUser().getId()+"  AND "+Hotelpass.COL_name+" IS NOT NULL AND "+Hotelpass.COL_mobile+" IS NOT NULL AND "+Hotelpass.COL_sex+" IS NOT NULL ";
         listHotelpasa=Server.getInstance().getHotelService().findAllHotelpass(" where 1=1 AND "+Hotelpass.COL_name+" IS NOT NULL AND "+Hotelpass.COL_mobile+" IS NOT NULL AND "+Hotelpass.COL_sex+" IS NOT NULL  and "+Hotelpass.COL_createuserid+" ="+getOrderUserLogin().getId(), "", 20, 0);
       
 		getCommandHotelList(cityId);
		return "tobook";
	}
	
	public String book()throws Exception {
		Customeruser muser = new Customeruser();
		
			 muser = Server.getInstance().getMemberService().findCustomeruser(getLoginUser().getId());

		
		/*if(muser.getMembername()==null){
			
			muser.setMembername(hotelorder.getLinkname());
			
		}
		if(muser.getMemberemail()==null){
			
			muser.setMemberemail(hotelorder.getLinkmail());
			
		}
		
		muser.setMobile(hotelorder.getLinkmobile());
		if(muser.getMembersex()==null){
			
			muser.setMembersex(hotelorder.getSex());
		}
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(muser);*/




	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date time = df.parse(startDate);



	Date time2 = df.parse(endDate);
	long manyday = (time2.getTime()-time.getTime())/(24*3600*1000);
	int  many = (int)manyday;
	//roomname=java.net.URLDecoder.decode(roomname,"UTF-8"); 

	
	Hotel hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());
	cityId=Integer.parseInt(hotel.getCityid()+"");


	Float rvaule =1F;
	Double pr=0.0;
	Double aa;
	
	Customeruser  customeruser =getLoginUser();
	Customeragent customeragent = Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());//当前登录者所属
	/*List<Rebaterule>list=Server.getInstance().getMemberService().findAllRebaterule(" where 1=1 and "+Rebaterule.COL_ruletypeid+" =2 and "+Rebaterule.COL_agenttypeid+" ="+customeragent.getAgentjibie(), "", -1, 0);
	if(list.size()>0){
		rvaule = list.get(0).getRebatvalue();	
	}*/

/*	if(hotel.getSourcetype()==1){//芒果
		if(hotel.getStar()==null){
			pr=  Double.valueOf(formatMoney_short(Double.valueOf(hotelorder.getPrice())*12/100+""));
		}
		if(hotel.getStar()==8||hotel.getStar()==9){//5星级得,,返9%
			pr=  Double.valueOf(formatMoney_short(Double.valueOf(hotelorder.getPrice())*9/100+""));
		}else{//其他星级得 返12%
			pr=  Double.valueOf(formatMoney_short(Double.valueOf(hotelorder.getPrice())*12/100+""));
		}
	}else{//经纪人
		
		
		pr=  Double.valueOf(formatMoney_short(Double.valueOf(hotelorder.getPrice())*Double.parseDouble(hotel.getRulesback())/100+""));
		
	}*/

		pr=(Double.valueOf(hotelorder.getPrice())-(Double.valueOf(hotelorder.getPrice())/1.03));
		System.out.println("利润=="+(Double.valueOf(hotelorder.getPrice())-(Double.valueOf(hotelorder.getPrice())/1.03))+",原价=="+(Double.valueOf(hotelorder.getPrice())/1.03));
		hotelorder.setManyday(many);
		hotelorder.setNumber(hotelorder.getNumber());
		hotelorder.setDanbao(0);
		hotelorder.setYestate(0);//0,未夜审 1,已夜审,全部正常 2,已也审,非正常 
		hotelorder.setSex(hotelorder.getSex());
		
		hotelorder.setPaystate(0l);//0未支付,1已支付,2已退款
		
		hotelorder.setComedate((new Timestamp(time.getTime())));
		hotelorder.setLeavedate((new Timestamp(time2.getTime())));
		hotelorder.setConfirmmethod(hotelorder.getConfirmmethod());
		hotelorder.setLinkmail(hotelorder.getLinkmail());
		hotelorder.setSpecreq(hotelorder.getSpecreq());
		hotelorder.setLinkmobile(hotelorder.getLinkmobile());
		hotelorder.setLinkname(hotelorder.getLinkname());
		hotelorder.setLinktell(hotelorder.getLinktell());
		hotelorder.setFanprice(pr*rvaule);//Createuserid的利润
		hotelorder.setPrice(Double.valueOf(hotelorder.getPrice())+"");
		hotelorder.setActualmount(Double.parseDouble(hotelorder.getPrice()));
		hotelorder.setCreateuserid(getLoginUser().getId());
		hotelorder.setProfits(pr);//订单总利润

		
		
			
			hotelorder.setMembername(getLoginUser().getMembername());
			hotelorder.setMemberid(getLoginUser().getId());
			hotelorder.setType(0);
			
		
		
		hotelorder.setReservstart(hotelorder.getReservstart());
		hotelorder.setReservend(hotelorder.getReservend());
		hotelorder.setPretime(new Timestamp(System.currentTimeMillis()));

		
		hotelorder.setHotelid(hotelorder.getHotelid());
		
		hotelorder.setPaytype(2l);//1现付,2预付
		hotelorder.setChecktype(hotel.getChecktype());
		hotelorder.setReservstart(hotelorder.getReservstart());
		hotelorder.setReservend(hotelorder.getReservend());
		hotelorder.setDayprice(hotelorder.getDayprice());
		
		hotelorder.setPrerooms(hotelorder.getPrerooms());
		hotelorder.setState(0);
		hotelorder.setRoomtypename(getRoomTypeNameByRoomType(hotelorder.getRoomtypename()));
		hotelorder.setPricecurrency(hotelorder.getPricecurrency());
		String[] strarrGuest=InRoomPeople.split(",");
		String[] strarrGuestmobile=InRoommobile.split(",");
		String[] strarrGuestsex=hidsex.split(",");
		for(int i=0;i<strarrGuest.length;i++)
		{   
			if(strarrGuest[i]!=null && !strarrGuest[i].toString().equals(" "))
			{
				add++;
			}
		}
		hotelorder.setOrderpeaple(add);
		hotelorder.setActualmount((Double.valueOf(hotelorder.getPrice())/1.03));
		hotelorder=Server.getInstance().getHotelService().createHotelorder(hotelorder);
		
		
		for(int i=0;i<strarrGuest.length;i++)
		{   
			if(strarrGuest[i]!=null && !strarrGuest[i].toString().equals(" "))
			{
				guest.setMemo(hotelorder.getConfirmmethod()+"");
				guest.setLanguage(0);
				guest.setOrderid(hotelorder.getId());
				guest.setMobile(strarrGuestmobile[i]);
				guest.setSex(Long.parseLong(strarrGuestsex[i]));
				guest.setName(strarrGuest[i]);
				guest.setRuzhutime(hotelorder.getComedate());
				guest.setLikaitime(hotelorder.getLeavedate());
				guest.setState(1l); //1，正常 2,提前离店 3,延住 4,取消
				guest.setPrice(hotelorder.getDayprice());
				Server.getInstance().getHotelService().createGuest(guest);
			}
		}
		


	String hoteladdress = hotel.getAddress();
	String hoteltel = hotel.getTortell();
	if(hoteltel==null){
		hoteltel="";
	}

		hotelorder.setState(1);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		
		
		/*String smstemple="";
		smstemple=this.getSMSTemple("HOrderSuccess");
		smstemple=smstemple.replaceAll("@CustomerName@", hotelorder.getLinkname().replace("$", "\\$"));

		smstemple=smstemple.replaceAll("@reserve_date@",formatDate(hotelorder.getComedate()).toString());
		smstemple=smstemple.replaceAll("@hotel_name@",hotelorder.getName()+"("+hotelorder.getRoomtypename()+")");
		smstemple=smstemple.replaceAll("@room_type_rmdy@",hotelorder.getManyday()+"间"+hotelorder.getManyday());

		smstemple=smstemple.replaceAll("@OrderId@", hotelorder.getOrderid());

		this.smsSend(new String[] { "" + hotelorder.getLinkmobile() + "" },smstemple, ""+hotelorder.getOrderid(), getLoginUserId() + "");
	*/	
		String smstemple="您的酒店已预订成功!";
		Ymsend ymsend=new Ymsend();
		ymsend.setContent(smstemple);
		ymsend.setCreatetime(new Timestamp(System.currentTimeMillis()));
		ymsend.setOrdercode("");
		ymsend.setPhone(hotelorder.getLinkmobile());
		ymsend.setType(2);
		ymsend.setState(0l);
		Server.getInstance().getMemberService().createYmsend(ymsend);
		System.out.println(smstemple);
		
		forword ="interhotelbook!took.action?hotelid="+hotelorder.getHotelid()+"&hotelorderid="+hotelorder.getId()+"&endDate="+endDate+"&startDate="+startDate;

		
		getgejifan(3, hotelorder);

		return "took";

			
		}
	
	
	
	public String took()throws Exception{
		
		
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorderid);
		hotel = Server.getInstance().getHotelService().findHotel(hotelid);

		s_num = dateDiff(endDate.trim(), startDate.trim());
		
		junjia=Double.parseDouble(hotelorder.getPrice())/s_num;
		listGuest = Server.getInstance().getHotelService().findAllGuest("where 1=1 and "+Guest.COL_orderid+" ="+hotelorderid, " ORDER BY ID ", -1, 0);
		
		
		cityId = Integer.parseInt(hotel.getCityid()+"");
		getCommandHotelList(cityId);

			return "yudingok";
			
		
		
		
		
	}
	/**
	 * 获得推荐酒店列表
	 */
	private void getCommandHotelList(long cityid){
		listhotelbj=Server.getInstance().getHotelService().findAllHotel("WHERE "+Hotel.COL_cityid+" ="+cityid, "ORDER BY ID DESC", 7, 0);
		
	}

	/**
	 * 获取两个日期相减剩余天数
	 * @param d1 
	 * @param d2
	 * @return  天数
	 * @throws ParseException 
	 */
	public long dateDiff(String d1,String d2) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 =  df.parse(d1);
		Date date2 =  df.parse(d2);
		return (date1.getTime() - date2.getTime())/86400000; 
	}
	
	//获取中国的城市
	public String getCityAirPortData() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strwhere="WHERE 1=1 and "+Incity.COL_countryid+" ="+countryid;
		
		
		
		
		List<Incity> listAirport = Server.getInstance().getInterHotelService().findAllIncity(strwhere, "", -1, 0);
				
		for (Incity airPort : listAirport) {
			sb.append(airPort.getName() + "# &" + airPort.getId()
					+ ",");
		}
		// return strRetData;
		System.out.println("SB=="+sb);
		out.print(sb);
		out.flush();
		out.close();
		return SUCCESS;
	}
	public String getima(String url){
		if(url.indexOf(",")!=-1){
			
			return url.split(",")[0];
		}else{
			
			return url;
		}
		
		
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
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

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Map<Long, Hotel> getMaphotel() {
		return maphotel;
	}

	public void setMaphotel(Map<Long, Hotel> maphotel) {
		this.maphotel = maphotel;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getBedname() {
		return bedname;
	}

	public void setBedname(String bedname) {
		this.bedname = bedname;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public long getHotelid() {
		return hotelid;
	}

	public void setHotelid(long hotelid) {
		this.hotelid = hotelid;
	}

	public Map<Long, Map<Long, Hotel>> getMaphotelroom() {
		return maphotelroom;
	}

	public void setMaphotelroom(Map<Long, Map<Long, Hotel>> maphotelroom) {
		this.maphotelroom = maphotelroom;
	}

	public List<Hotel> getListHotelPrice() {
		return listHotelPrice;
	}

	public void setListHotelPrice(List<Hotel> listHotelPrice) {
		this.listHotelPrice = listHotelPrice;
	}

	public List<Hotelimage> getListHotelimage() {
		return ListHotelimage;
	}

	public void setListHotelimage(List<Hotelimage> listHotelimage) {
		ListHotelimage = listHotelimage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDate1() {
		return Date1;
	}

	public void setDate1(String date1) {
		Date1 = date1;
	}

	public String getDate2() {
		return Date2;
	}

	public void setDate2(String date2) {
		Date2 = date2;
	}

	public String getDate3() {
		return Date3;
	}

	public void setDate3(String date3) {
		Date3 = date3;
	}

	public String getDate4() {
		return Date4;
	}

	public void setDate4(String date4) {
		Date4 = date4;
	}

	public String getDate5() {
		return Date5;
	}

	public void setDate5(String date5) {
		Date5 = date5;
	}

	public String getDate6() {
		return Date6;
	}

	public void setDate6(String date6) {
		Date6 = date6;
	}

	public String getDate7() {
		return Date7;
	}

	public void setDate7(String date7) {
		Date7 = date7;
	}

	public List getListprice() {
		return Listprice;
	}

	public void setListprice(List listprice) {
		Listprice = listprice;
	}

	public long getS_num() {
		return s_num;
	}

	public void setS_num(long s_num) {
		this.s_num = s_num;
	}

	public Double getZongjia() {
		return zongjia;
	}

	public void setZongjia(Double zongjia) {
		this.zongjia = zongjia;
	}

	public List<Hotelpass> getListHotelpasa() {
		return listHotelpasa;
	}

	public void setListHotelpasa(List<Hotelpass> listHotelpasa) {
		this.listHotelpasa = listHotelpasa;
	}

	public Hotelorder getHotelorder() {
		return hotelorder;
	}

	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
	}

	public List<Hotel> getListhotelbj() {
		return listhotelbj;
	}

	public void setListhotelbj(List<Hotel> listhotelbj) {
		this.listhotelbj = listhotelbj;
	}

	public List<Guest> getListGuest() {
		return listGuest;
	}

	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public long getHotelorderid() {
		return hotelorderid;
	}

	public void setHotelorderid(long hotelorderid) {
		this.hotelorderid = hotelorderid;
	}

	public Double getJunjia() {
		return junjia;
	}

	public void setJunjia(Double junjia) {
		this.junjia = junjia;
	}

	public String getInRoomPeople() {
		return InRoomPeople;
	}

	public void setInRoomPeople(String inRoomPeople) {
		InRoomPeople = inRoomPeople;
	}

	public String getInRoommobile() {
		return InRoommobile;
	}

	public void setInRoommobile(String inRoommobile) {
		InRoommobile = inRoommobile;
	}

	public String getHidsex() {
		return hidsex;
	}

	public void setHidsex(String hidsex) {
		this.hidsex = hidsex;
	}

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public String getIfCurrency() {
		return ifCurrency;
	}

	public void setIfCurrency(String ifCurrency) {
		this.ifCurrency = ifCurrency;
	}

	public Double getIfprice() {
		return ifprice;
	}

	public void setIfprice(Double ifprice) {
		this.ifprice = ifprice;
	}

	public Double getBreakfastPrice() {
		return breakfastPrice;
	}

	public void setBreakfastPrice(Double breakfastPrice) {
		this.breakfastPrice = breakfastPrice;
	}


	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(int orderMode) {
		this.orderMode = orderMode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public InterHotelbookAction() {

	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}


}
