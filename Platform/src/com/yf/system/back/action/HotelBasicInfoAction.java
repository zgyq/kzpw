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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.province.Province;
import com.yf.system.base.region.Region;
import com.yf.system.base.util.Ajax;
import com.opensymphony.webwork.ServletActionContext;

public class HotelBasicInfoAction extends B2b2cbackAction {
	private List <  Hotel  >  listHotel;
	private Hotel hotel = new Hotel();
	private List<Customeragent> listCustomeragent;
	//所有的省
	private List<Province> listProvinces ;
	//所有的市
	private List<City> listCities ;
	private List<City> listinCities ;
	
	private Long hotelId ; //酒店的ID
	private int aa=0 ; 
	private String opendateStr;
	
	private String cityId;
	private String forword;
	
	private String[] cardType;// 卡类型

	private String[] serviceItem;// 服务项目

	private String[] eatery;// 餐饮设施

	private String[] playItem; // 娱乐设施
	
	private String otherCard;
	
	public String[] getCardType() {
		return cardType;
	}

	public void setCardType(String[] cardType) {
		this.cardType = cardType;
	}

	public String[] getEatery() {
		return eatery;
	}

	public void setEatery(String[] eatery) {
		this.eatery = eatery;
	}

	public String getOtherCard() {
		return otherCard;
	}

	public void setOtherCard(String otherCard) {
		this.otherCard = otherCard;
	}

	public String[] getPlayItem() {
		return playItem;
	}

	public void setPlayItem(String[] playItem) {
		this.playItem = playItem;
	}

	public String[] getServiceItem() {
		return serviceItem;
	}

	public void setServiceItem(String[] serviceItem) {
		this.serviceItem = serviceItem;
	}

	public String getOpendateStr() {
		return opendateStr;
	}

	public void setOpendateStr(String opendateStr) {
		this.opendateStr = opendateStr;
	}

	/**
	 * 转向到酒店修改页面
	 */	
	public String toedit()throws Exception{
		listProvinces = Server.getInstance().getHotelService().findAllProvince("", "ORDER BY " + Province.COL_id , -1, 0) ;
		listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_provinceid+" is not null ", "ORDER BY " + City.COL_id, -1 ,0) ;
		//listinCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168", "", -1, 0);
		
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		opendateStr=formatDate(hotel.getOpendate());
		
		
		return EDIT;
	}
	/**
	 * 转向到酒店修改页面
	 */	
	public String toedit2()throws Exception{
		listProvinces = Server.getInstance().getHotelService().findAllProvince("", "ORDER BY " + Province.COL_id , -1, 0) ;
		listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" =168", "ORDER BY " + City.COL_id, -1 ,0) ;
		listinCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168", "", -1, 0);
		
		
		
		return EDIT;
	}
	/**
	 * 转向到酒店审核页面
	 */	
	public String tocheck()throws Exception{
		
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		opendateStr=formatDate(hotel.getOpendate());
		return CHECK;
	}
	/**
	 * 酒店审核通过
	 */
	public String tongguo()throws Exception{
		hotel.setState(3);
		return LIST;
	}
	/**
	 * 酒店审核驳回
	 */
	public String bohui()throws Exception{
		hotel.setState(0);
		return LIST;
	}
	
	/**
	 * 添加酒店
	 */		
	public String add()throws Exception{
		hotel.setState(0);
		//0表示为待审核
	    System.out.println("add Hotel.......");
	   // System.out.println(hotel+"==========");
		Server.getInstance().getHotelService().createHotel(hotel);
		hotel.setContryid(0l);
		
		
		System.out.println(hotel+"==========");
		return LIST;
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
			//
			hotel.setState(0);
			//hotelId=0l;
			
			//以下是toadd参考方法
			listProvinces = Server.getInstance().getHotelService()
			.findAllProvince("WHERE 1=1 AND "+Province.COL_language+" ="+lan, "ORDER BY " + Province.COL_id, -1, 0);
			listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" =168 and "+City.COL_language+" ="+lan,
			"ORDER BY " + City.COL_id, -1, 0);
			System.out.println("listCities=="+listCities);
			listinCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168 and "+City.COL_language+" ="+lan, "", -1, 0);
			System.out.println("listinCities=="+listinCities);
			//aa=2;
			forword = "hotel!toadd.action?lan="+lan+"&uco="+uco;
			return "add";
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			listProvinces = Server.getInstance().getHotelService().findAllProvince("", "ORDER BY " + Province.COL_id , -1, 0) ;
			listCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" =168", "ORDER BY " + City.COL_id, -1 ,0) ;
			listinCities = Server.getInstance().getHotelService().findAllCity("where 1=1 and "+City.COL_countryid+" !=168", "", -1, 0);
			
			hotel = Server.getInstance().getHotelService().findHotelbylanguage(hotel.getUcode(),hotel.getLanguage());
			opendateStr=formatDate(hotel.getOpendate());
			return 	EDIT;
		}
		//return "addsuccess1";
	}
	/**
	 * 转向酒店详细基本信息页面
	 */
	public String tolook() throws Exception{
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		this.opendateStr = formatDate(hotel.getOpendate());
		return "look";
	}

	/**
	 * 审核酒店
	 */		
	public String check()throws Exception{
		hotel.setState(1);
		//1表示审核未通过 2表示为通过审核
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		this.opendateStr = formatDate(hotel.getOpendate());
		return LIST;
	}
	


	/**
	 * 编辑酒店
	 */		
	public String edit()throws Exception{
		hotel.setState(0);
//		 卡类型
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
		String item = "";
		if (null != serviceItem && serviceItem.length > 0) {
			for (int i = 0; i < serviceItem.length; i++) {
				item += serviceItem[i] + "|";
			}
		}
		// 餐饮设施
		String food = "";
		if (null != eatery && eatery.length > 0) {
			for (int i = 0; i < eatery.length; i++) {
				food += eatery[i] + "|";
			}
		}
		// 娱乐健身设施
		String amusement = "";
		if (null != playItem && playItem.length > 0) {
			for (int i = 0; i < playItem.length; i++) {
				amusement += playItem[i] + "|";
			}
		}
		//hotel.setPlayitem(amusement);
		hotel.setCarttype(type);
	//	hotel.setServiceitem(item);
	//	hotel.setFootitem(food);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		 return "addsuccess";
	}

	/**
	 * 删除酒店
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotel(hotel.getId());
		return LIST;
	}
	/**
	 * 卡类型
	 */
	public String getCardTypeHTML(String t){
		String html="";
		if(null == t){
			t="";
		}
		if(null != t){
			if(t.indexOf("万事达Maste")!=-1){
				html += "<TD><INPUT type=checkbox name='cardType' value='万事达Maste' checked='checked'> 万事达Maste</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='cardType' value='万事达Maste'> 万事达Maste</TD>";
			}
			if(t.indexOf("威士VISA")>0){
				html += "<TD><INPUT type=checkbox name='cardType' value='威士VISA' checked='checked'> 威士VISA</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='cardType' value='威士VISA'> 威士VISA</TD>";
			}
			if(t.indexOf("运通AMEX")>0){
				html += "<TD><INPUT type=checkbox name='cardType' value='运通AMEX' checked='checked'> 运通AMEX</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='cardType' value='运通AMEX'> 运通AMEX</TD>";
			}
			if(t.indexOf("大来DinersClub")>0){
				html += "<TD><INPUT type=checkbox name='cardType' value='大来DinersClub' checked='checked'> 大来DinersClub</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='cardType' value='大来DinersClub'> 大来DinersClub</TD>";
			}
			if(t.indexOf("JCB")>0){
				html += "<TD><INPUT type=checkbox name='cardType' value='JCB' checked='checked'> JCB</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='cardType' value='JCB'> JCB</TD>";
			}
			if(t.indexOf("银联卡")>0){
				html += "<TD><INPUT type=checkbox name='cardType' value='银联卡' checked='checked'> 银联卡</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='cardType' value='银联卡'> 银联卡</TD>";
			}
			/*if(t.indexOf("其他")>0){
				html += "<TD> 其他:<INPUT type=text name='cardType' value='其他' checked='checked'></TD>";
			}else{
				html += "<TD> 其他:<INPUT type=text name='cardType' value=''></TD>";
			}*/
			
		}
		String[] xx = t.split(":");
		if(xx.length>1){
			html += "<TD>&nbsp;其他:<INPUT type=text name='otherCard' value='"+xx[1]+"' ></TD>";
		}else{
			html += "<TD>&nbsp;其他:<INPUT type=text name='otherCard' value=''></TD>";
		}
	
		return html;
	}

	 /**
	  * 宾馆服务项目
	  */
	public String getServicItemHTML(String it)throws Exception{
		String html ="";
		if(null != it){
			if(it.indexOf("会议厅")!=-1){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='会议厅' checked='checked'> 会议厅</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='会议厅' > 会议厅</TD>";
			}
			if(it.indexOf("商务中心")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='商务中心' checked='checked'> 商务中心</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='商务中心' > 商务中心</TD>";
			}
			if(it.indexOf("停车场")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='停车场' checked='checked'> 停车场</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='停车场' > 停车场</TD>";
			}
			if(it.indexOf("外币兑换服务")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='外币兑换服务' checked='checked'> 外币兑换服务</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='外币兑换服务' > 外币兑换服务</TD>";
			}
			if(it.indexOf("票务服务")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='票务服务' checked='checked'> 票务服务</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='票务服务' > 票务服务</TD>";
			}			
			if(it.indexOf("DDD电话")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='DDD电话' checked='checked'> DDD电话</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='DDD电话' > DDD电话</TD>";
			}	
			
			
			if(it.indexOf("IDD电话")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='IDD电话' checked='checked'> IDD电话</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='IDD电话' > IDD电话</TD>";
			}
			html+="</tr><tr>";
			if(it.indexOf("洗衣服务")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='洗衣服务' checked='checked'> 洗衣服务</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='洗衣服务' > 洗衣服务</TD>";
			}
			if(it.indexOf("商场")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='商场' checked='checked'> 商场</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='商场' > 商场</TD>";
			}
			if(it.indexOf("鲜花店")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='鲜花店' checked='checked'> 鲜花店</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='鲜花店' > 鲜花店</TD>";
			}
			if(it.indexOf("医务室")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='医务室' checked='checked'> 医务室</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='医务室' > 医务室</TD>";
			}
			if(it.indexOf("理发美容室")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='理发美容室' checked='checked'> 理发美容室</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='理发美容室' > 理发美容室</TD>";
			}
			if(it.indexOf("出租车")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='出租车' checked='checked'> 出租车</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='出租车' > 出租车</TD>";
			}
			if(it.indexOf("SPA")>0){
				html += "<TD><INPUT type=checkbox name='serviceItem' value='SPA' checked='checked'> SPA</TD>";
			}else{
				html += "<TD><INPUT type=checkbox name='serviceItem' value='SPA' > SPA</TD>";
			}
		}
		return html;
	}
	/**
	 * 餐饮设施
	 */
	public String  getEateryHTML(String f){
		String html="";
		if(null == f){
			f="";
		}
		
		if(null != f && f.length()>0){
			if(f.indexOf("中餐厅") != -1){
				html += "<TD><INPUT  type=checkbox name=eatery value='中餐厅' checked='checked'>中餐厅</TD>";	
			}else{
				html += "<TD><INPUT  type=checkbox name=eatery value='中餐厅' >中餐厅</TD>";
			}
			if(f.indexOf("西餐厅")>0){
				html += "<TD><INPUT  type=checkbox name=eatery value='西餐厅' checked='checked'>西餐厅</TD>";	
			}else{
				html += "<TD><INPUT  type=checkbox name=eatery value='西餐厅' >西餐厅</TD>";
			}
			if(f.indexOf("咖啡厅")>0){
				html += "<TD><INPUT  type=checkbox name=eatery value='咖啡厅' checked='checked'>咖啡厅</TD>";	
			}else{
				html += "<TD><INPUT  type=checkbox name=eatery value='咖啡厅' >咖啡厅</TD>";
			}
			if(f.indexOf("酒吧")>0){
				html += "<TD><INPUT  type=checkbox name=eatery value='酒吧' checked='checked'>酒吧</TD>";	
			}else{
				html += "<TD><INPUT  type=checkbox name=eatery value='酒吧' >酒吧</TD>";
			}
			if(f.indexOf("限时送餐服务")>0){
				html += "<TD><INPUT  type=checkbox name=eatery value='限时送餐服务' checked='checked'>限时送餐服务</TD>";	
			}else{
				html += "<TD><INPUT  type=checkbox name=eatery value='限时送餐服务' >限时送餐服务</TD>";
			}
			if(f.indexOf("日餐厅")>0){
				html += "<TD><INPUT  type=checkbox name=eatery value='日餐厅' checked='checked'>日餐厅</TD>";	
			}else{
				html += "<TD><INPUT  type=checkbox name=eatery value='日餐厅' >日餐厅</TD>";
			}
		}
		return html;
	}
	
	/**
	 * 娱乐健身设施
	 */
	public String getPlayItemHTML(String p) throws Exception{
		String html ="";
		if(null == p){
			p="";
		}
		
		if(null!=p && p.length()>0){
			if(p.indexOf("迪斯科舞厅") != -1){
				html += "<TD><INPUT type=checkbox name=playItem value='迪斯科舞厅' checked='checked'>迪斯科舞厅</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='迪斯科舞厅'>迪斯科舞厅</TD>" ;
			}
			if(p.indexOf("棋牌室")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='棋牌室' checked='checked'>棋牌室</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='棋牌室'>棋牌室</TD>" ;
			}
			if(p.indexOf("乒乓球室")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='乒乓球室' checked='checked'>乒乓球室</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='乒乓球室'>乒乓球室</TD>" ;
			}
			if(p.indexOf("室外游泳池")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='室外游泳池' checked='checked'>室外游泳池</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='室外游泳池'>室外游泳池</TD>" ;
			}
			if(p.indexOf("室内游泳池")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='室内游泳池' checked='checked'>室内游泳池</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='室内游泳池'>室内游泳池</TD>" ;
			}
			if(p.indexOf("健身室")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='健身室' checked='checked'>健身室</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='健身室'>健身室</TD>" ;
			}
			if(p.indexOf("桑拿浴室")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='桑拿浴室' checked='checked'>桑拿浴室</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='桑拿浴室'>桑拿浴室</TD>" ;
			}
			if(p.indexOf("桌球室")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='桌球室' checked='checked'>桌球室</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='桌球室'>桌球室</TD>" ;
			}
			if(p.indexOf("按摩室")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='按摩室' checked='checked'>按摩室</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='按摩室'>按摩室</TD>" ;
			}
			if(p.indexOf("网球场")>0){
				html += "<TD><INPUT type=checkbox name=playItem value='网球场' checked='checked'>网球场</TD>" ;
			}else{
				html += "<TD><INPUT type=checkbox name=playItem value='网球场'>网球场</TD>" ;
			}
		}
		
		return html;
	}
	
	
	
	
	
	/**
	 * 得到城市相关信息
	 * @throws Exception 
	 */
	public void getCitiesInfo() throws Exception{
		List<Region> listAdmin = Server.getInstance().getHotelService().findAllRegion(" WHERE " + Region.COL_cityid + " = " + cityId +" AND "+Region.COL_type+"='行政区'"," ORDER BY ID",-1,0);
		List<Region> listBiz = Server.getInstance().getHotelService().findAllRegion(" WHERE " + Region.COL_cityid + " = " + cityId +" AND "+Region.COL_type+"='商业区'"," ORDER BY ID",-1,0);
		List<Region> listView = Server.getInstance().getHotelService().findAllRegion(" WHERE " + Region.COL_cityid + " = " + cityId +" AND "+Region.COL_type+"='景区'"," ORDER BY ID",-1,0);
		
		Map<String,Object> mp = new HashMap<String,Object>();
		mp.put("listAdmin",listAdmin);
		mp.put("listBiz",listBiz);
		mp.put("listView",listView);
		Ajax.ajaxResponse(ServletActionContext.getResponse(),mp);
	}
	
	/**
	 * 通过省的id得到省的名称
	 */
	public String getProvinceNameById(long id){
		return Server.getInstance().getHotelService().findProvince(id).getName();
	}
	/**
	 * 通过省的id得到城市的名称
	 */
	public String getCityNameById(long id){
		return Server.getInstance().getHotelService().findCity(id).getName();
	}
	/**
	 * 通过省的id得到城市的名称
	 */
	public String getRegionNameById(long id,int typeid){
		if(typeid == 1)
		{
			return Server.getInstance().getHotelService().findRegion(id).getName();
		}
		if(typeid == 2)
		{
			return Server.getInstance().getHotelService().findRegion(id).getName();
		}
		if(typeid == 3)
		{
			return Server.getInstance().getHotelService().findRegion(id).getName();
		}
		return "";
	}
	
	/**
	 *  返回酒店对象
	 */		
	
	public Object getModel() {
		return hotel;
	}
	public List < Hotel >   getListHotel() {
		return listHotel;
	}
	public void setListHotel(List <  Hotel  >  listHotel) {
		this.listHotel = listHotel;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public List<City> getListinCities() {
		return listinCities;
	}

	public void setListinCities(List<City> listinCities) {
		this.listinCities = listinCities;
	}

	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}

	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}

	
	
}