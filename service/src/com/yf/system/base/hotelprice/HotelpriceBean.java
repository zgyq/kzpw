/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelprice;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店价格
 */
public class HotelpriceBean implements java.io.Serializable{

	/**
	  *酒店价格 表名
	  */
	public static final String TABLE  = "T_HOTELPRICE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *月份 列名 
	  */
    public static final String COL_datenumber  = "C_DATENUMBER";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *价格类型 列名 
	  */
    public static final String COL_pricetype  = "C_PRICETYPE";
	
	/**
	  *门市价 列名 
	  */
    public static final String COL_deptprice  = "C_DEPTPRICE";
	
	/**
	  *底价 列名 
	  */
    public static final String COL_endprice  = "C_ENDPRICE";
	
	/**
	  *房型ID 列名 
	  */
    public static final String COL_roomid  = "C_ROOMID";
	
	/**
	  *是否禁用 列名 
	  */
    public static final String COL_isvalid  = "C_ISVALID";
	
	/**
	  *单日价1 列名 
	  */
    public static final String COL_no1  = "C_NO1";
	
	/**
	  *单日价2 列名 
	  */
    public static final String COL_no2  = "C_NO2";
	
	/**
	  *单日???3 列名 
	  */
    public static final String COL_no3  = "C_NO3";
	
	/**
	  *单日价4 列名 
	  */
    public static final String COL_no4  = "C_NO4";
	
	/**
	  *单日价5 列名 
	  */
    public static final String COL_no5  = "C_NO5";
	
	/**
	  *单日价6 列名 
	  */
    public static final String COL_no6  = "C_NO6";
	
	/**
	  *单日价7 列名 
	  */
    public static final String COL_no7  = "C_NO7";
	
	/**
	  *单日价8 列名 
	  */
    public static final String COL_no8  = "C_NO8";
	
	/**
	  *单日价9 列名 
	  */
    public static final String COL_no9  = "C_NO9";
	
	/**
	  *单日价10 列名 
	  */
    public static final String COL_no10  = "C_NO10";
	
	/**
	  *单日价11 列名 
	  */
    public static final String COL_no11  = "C_NO11";
	
	/**
	  *单日价12 列名 
	  */
    public static final String COL_no12  = "C_NO12";
	
	/**
	  *单日价13 列名 
	  */
    public static final String COL_no13  = "C_NO13";
	
	/**
	  *单日价14 列名 
	  */
    public static final String COL_no14  = "C_NO14";
	
	/**
	  *???????价15 列名 
	  */
    public static final String COL_no15  = "C_NO15";
	
	/**
	  *单日价16 列名 
	  */
    public static final String COL_no16  = "C_NO16";
	
	/**
	  *单日价17 列名 
	  */
    public static final String COL_no17  = "C_NO17";
	
	/**
	  *单日价18 列名 
	  */
    public static final String COL_no18  = "C_NO18";
	
	/**
	  *单日价19 列名 
	  */
    public static final String COL_no19  = "C_NO19";
	
	/**
	  *单日价20 列名 
	  */
    public static final String COL_no20  = "C_NO20";
	
	/**
	  *单日价21 列名 
	  */
    public static final String COL_no21  = "C_NO21";
	
	/**
	  *单日价22 列名 
	  */
    public static final String COL_no22  = "C_NO22";
	
	/**
	  *单日价23 列名 
	  */
    public static final String COL_no23  = "C_NO23";
	
	/**
	  *单日价24 列名 
	  */
    public static final String COL_no24  = "C_NO24";
	
	/**
	  *单日价25 列名 
	  */
    public static final String COL_no25  = "C_NO25";
	
	/**
	  *单日价26 列名 
	  */
    public static final String COL_no26  = "C_NO26";
	
	/**
	  *单日价27 列名 
	  */
    public static final String COL_no27  = "C_NO27";
	
	/**
	  *单日价28 列名 
	  */
    public static final String COL_no28  = "C_NO28";
	
	/**
	  *单日价29 列名 
	  */
    public static final String COL_no29  = "C_NO29";
	
	/**
	  *单日价30 列名 
	  */
    public static final String COL_no30  = "C_NO30";
	
	/**
	  *单日价31 列名 
	  */
    public static final String COL_no31  = "C_NO31";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";
    
    /**
	  *价格计划名字 列名 
	  */
   public static final String COL_rateplanname  = "C_RATEPLANNAME";
   
   /**
	  *价格计划CODE 列名 
	  */
   public static final String COL_rateplancode  = "C_RATEPLANCODE";
   
   /**
	  *币种 列名 
	  */
 public static final String COL_moytype  = "C_MOYTYPE";

	//ID
	private long id;    
    

	//月份
	private String datenumber;    
    

	//酒店ID
	private Long hotelid;    
    

	//价格类型
	private String pricetype;    
    

	//门市价
	private String deptprice;    
    

	//底价
	private String endprice;    
    

	//房型ID
	private Long roomid;    
    

	//是否禁用
	private String isvalid;    
    

	//单日价1
	private Double no1;    
    

	//单日价2
	private Double no2;    
    

	//单日???3
	private Double no3;    
    

	//单日价4
	private Double no4;    
    

	//单日价5
	private Double no5;    
    

	//单日价6
	private Double no6;    
    

	//单日价7
	private Double no7;    
    

	//单日价8
	private Double no8;    
    

	//单日价9
	private Double no9;    
    

	//单日价10
	private Double no10;    
    

	//单日价11
	private Double no11;    
    

	//单日价12
	private Double no12;    
    

	//单日价13
	private Double no13;    
    

	//单日价14
	private Double no14;    
    

	//???????价15
	private Double no15;    
    

	//单日价16
	private Double no16;    
    

	//单日价17
	private Double no17;    
    

	//单日价18
	private Double no18;    
    

	//单日价19
	private Double no19;    
    

	//单日价20
	private Double no20;    
    

	//单日价21
	private Double no21;    
    

	//单日价22
	private Double no22;    
    

	//单日价23
	private Double no23;    
    

	//单日价24
	private Double no24;    
    

	//单日价25
	private Double no25;    
    

	//单日价26
	private Double no26;    
    

	//单日价27
	private Double no27;    
    

	//单日价28
	private Double no28;    
    

	//单日价29
	private Double no29;    
    

	//单日价30
	private Double no30;    
    

	//单日价31
	private Double no31;    
    

	//描述
	private String description;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;   
	
	//价格计划名字
	private String rateplanname; 
	
	//价格计划code
	private String rateplancode; 
	
	//币种
	private String moytype; 
    

	/**
	 * getID
	 */
    public long getId(){
         return id;
    }

	/**
	 * setID
	 */
    public void setId(long id){
         this.id=id;
    }

	/**
	 * get月份
	 */
    public String getDatenumber(){
         return datenumber;
    }

	/**
	 * set月份
	 */
    public void setDatenumber(String datenumber){
         this.datenumber=datenumber;
    }

	/**
	 * get酒店ID
	 */
    public Long getHotelid(){
         return hotelid;
    }

	/**
	 * set酒店ID
	 */
    public void setHotelid(Long hotelid){
         this.hotelid=hotelid;
    }

	/**
	 * get价格类型
	 */
    public String getPricetype(){
         return pricetype;
    }

	/**
	 * set价格类型
	 */
    public void setPricetype(String pricetype){
         this.pricetype=pricetype;
    }

	/**
	 * get门市价
	 */
    public String getDeptprice(){
         return deptprice;
    }

	/**
	 * set门市价
	 */
    public void setDeptprice(String deptprice){
         this.deptprice=deptprice;
    }

	/**
	 * get底价
	 */
    public String getEndprice(){
         return endprice;
    }

	/**
	 * set底价
	 */
    public void setEndprice(String endprice){
         this.endprice=endprice;
    }

	/**
	 * get房型ID
	 */
    public Long getRoomid(){
         return roomid;
    }

	/**
	 * set房型ID
	 */
    public void setRoomid(Long roomid){
         this.roomid=roomid;
    }

	/**
	 * get是否禁用
	 */
    public String getIsvalid(){
         return isvalid;
    }

	/**
	 * set是否禁用
	 */
    public void setIsvalid(String isvalid){
         this.isvalid=isvalid;
    }

	/**
	 * get单日价1
	 */
    public Double getNo1(){
         return no1;
    }

	/**
	 * set单日价1
	 */
    public void setNo1(Double no1){
         this.no1=no1;
    }

	/**
	 * get单日价2
	 */
    public Double getNo2(){
         return no2;
    }

	/**
	 * set单日价2
	 */
    public void setNo2(Double no2){
         this.no2=no2;
    }

	/**
	 * get单日???3
	 */
    public Double getNo3(){
         return no3;
    }

	/**
	 * set单日???3
	 */
    public void setNo3(Double no3){
         this.no3=no3;
    }

	/**
	 * get单日价4
	 */
    public Double getNo4(){
         return no4;
    }

	/**
	 * set单日价4
	 */
    public void setNo4(Double no4){
         this.no4=no4;
    }

	/**
	 * get单日价5
	 */
    public Double getNo5(){
         return no5;
    }

	/**
	 * set单日价5
	 */
    public void setNo5(Double no5){
         this.no5=no5;
    }

	/**
	 * get单日价6
	 */
    public Double getNo6(){
         return no6;
    }

	/**
	 * set单日价6
	 */
    public void setNo6(Double no6){
         this.no6=no6;
    }

	/**
	 * get单日价7
	 */
    public Double getNo7(){
         return no7;
    }

	/**
	 * set单日价7
	 */
    public void setNo7(Double no7){
         this.no7=no7;
    }

	/**
	 * get单日价8
	 */
    public Double getNo8(){
         return no8;
    }

	/**
	 * set单日价8
	 */
    public void setNo8(Double no8){
         this.no8=no8;
    }

	/**
	 * get单日价9
	 */
    public Double getNo9(){
         return no9;
    }

	/**
	 * set单日价9
	 */
    public void setNo9(Double no9){
         this.no9=no9;
    }

	/**
	 * get单日价10
	 */
    public Double getNo10(){
         return no10;
    }

	/**
	 * set单日价10
	 */
    public void setNo10(Double no10){
         this.no10=no10;
    }

	/**
	 * get单日价11
	 */
    public Double getNo11(){
         return no11;
    }

	/**
	 * set单日价11
	 */
    public void setNo11(Double no11){
         this.no11=no11;
    }

	/**
	 * get单日价12
	 */
    public Double getNo12(){
         return no12;
    }

	/**
	 * set单日价12
	 */
    public void setNo12(Double no12){
         this.no12=no12;
    }

	/**
	 * get单日价13
	 */
    public Double getNo13(){
         return no13;
    }

	/**
	 * set单日价13
	 */
    public void setNo13(Double no13){
         this.no13=no13;
    }

	/**
	 * get单日价14
	 */
    public Double getNo14(){
         return no14;
    }

	/**
	 * set单日价14
	 */
    public void setNo14(Double no14){
         this.no14=no14;
    }

	/**
	 * get???????价15
	 */
    public Double getNo15(){
         return no15;
    }

	/**
	 * set???????价15
	 */
    public void setNo15(Double no15){
         this.no15=no15;
    }

	/**
	 * get单日价16
	 */
    public Double getNo16(){
         return no16;
    }

	/**
	 * set单日价16
	 */
    public void setNo16(Double no16){
         this.no16=no16;
    }

	/**
	 * get单日价17
	 */
    public Double getNo17(){
         return no17;
    }

	/**
	 * set单日价17
	 */
    public void setNo17(Double no17){
         this.no17=no17;
    }

	/**
	 * get单日价18
	 */
    public Double getNo18(){
         return no18;
    }

	/**
	 * set单日价18
	 */
    public void setNo18(Double no18){
         this.no18=no18;
    }

	/**
	 * get单日价19
	 */
    public Double getNo19(){
         return no19;
    }

	/**
	 * set单日价19
	 */
    public void setNo19(Double no19){
         this.no19=no19;
    }

	/**
	 * get单日价20
	 */
    public Double getNo20(){
         return no20;
    }

	/**
	 * set单日价20
	 */
    public void setNo20(Double no20){
         this.no20=no20;
    }

	/**
	 * get单日价21
	 */
    public Double getNo21(){
         return no21;
    }

	/**
	 * set单日价21
	 */
    public void setNo21(Double no21){
         this.no21=no21;
    }

	/**
	 * get单日价22
	 */
    public Double getNo22(){
         return no22;
    }

	/**
	 * set单日价22
	 */
    public void setNo22(Double no22){
         this.no22=no22;
    }

	/**
	 * get单日价23
	 */
    public Double getNo23(){
         return no23;
    }

	/**
	 * set单日价23
	 */
    public void setNo23(Double no23){
         this.no23=no23;
    }

	/**
	 * get单日价24
	 */
    public Double getNo24(){
         return no24;
    }

	/**
	 * set单日价24
	 */
    public void setNo24(Double no24){
         this.no24=no24;
    }

	/**
	 * get单日价25
	 */
    public Double getNo25(){
         return no25;
    }

	/**
	 * set单日价25
	 */
    public void setNo25(Double no25){
         this.no25=no25;
    }

	/**
	 * get单日价26
	 */
    public Double getNo26(){
         return no26;
    }

	/**
	 * set单日价26
	 */
    public void setNo26(Double no26){
         this.no26=no26;
    }

	/**
	 * get单日价27
	 */
    public Double getNo27(){
         return no27;
    }

	/**
	 * set单日价27
	 */
    public void setNo27(Double no27){
         this.no27=no27;
    }

	/**
	 * get单日价28
	 */
    public Double getNo28(){
         return no28;
    }

	/**
	 * set单日价28
	 */
    public void setNo28(Double no28){
         this.no28=no28;
    }

	/**
	 * get单日价29
	 */
    public Double getNo29(){
         return no29;
    }

	/**
	 * set单日价29
	 */
    public void setNo29(Double no29){
         this.no29=no29;
    }

	/**
	 * get单日价30
	 */
    public Double getNo30(){
         return no30;
    }

	/**
	 * set单日价30
	 */
    public void setNo30(Double no30){
         this.no30=no30;
    }

	/**
	 * get单日价31
	 */
    public Double getNo31(){
         return no31;
    }

	/**
	 * set单日价31
	 */
    public void setNo31(Double no31){
         this.no31=no31;
    }

	/**
	 * get描述
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set描述
	 */
    public void setDescription(String description){
         this.description=description;
    }

	/**
	 * get父编号
	 */
    public Long getUcode(){
         return ucode;
    }

	/**
	 * set父编号
	 */
    public void setUcode(Long ucode){
         this.ucode=ucode;
    }

	/**
	 * get语言类型
	 */
    public Integer getLanguage(){
         return language;
    }

	/**
	 * set语言类型
	 */
    public void setLanguage(Integer language){
         this.language=language;
    }


	public String getRateplanname() {
		return rateplanname;
	}

	public void setRateplanname(String rateplanname) {
		this.rateplanname = rateplanname;
	}

	public String getRateplancode() {
		return rateplancode;
	}

	public void setRateplancode(String rateplancode) {
		this.rateplancode = rateplancode;
	}

	public String getMoytype() {
		return moytype;
	}

	public void setMoytype(String moytype) {
		this.moytype = moytype;
	}

	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + datenumber +"|"
	   
	 + hotelid +"|"
	   
	 + pricetype +"|"
	   
	 + deptprice +"|"
	   
	 + endprice +"|"
	   
	 + roomid +"|"
	   
	 + isvalid +"|"
	   
	 + no1 +"|"
	   
	 + no2 +"|"
	   
	 + no3 +"|"
	   
	 + no4 +"|"
	   
	 + no5 +"|"
	   
	 + no6 +"|"
	   
	 + no7 +"|"
	   
	 + no8 +"|"
	   
	 + no9 +"|"
	   
	 + no10 +"|"
	   
	 + no11 +"|"
	   
	 + no12 +"|"
	   
	 + no13 +"|"
	   
	 + no14 +"|"
	   
	 + no15 +"|"
	   
	 + no16 +"|"
	   
	 + no17 +"|"
	   
	 + no18 +"|"
	   
	 + no19 +"|"
	   
	 + no20 +"|"
	   
	 + no21 +"|"
	   
	 + no22 +"|"
	   
	 + no23 +"|"
	   
	 + no24 +"|"
	   
	 + no25 +"|"
	   
	 + no26 +"|"
	   
	 + no27 +"|"
	   
	 + no28 +"|"
	   
	 + no29 +"|"
	   
	 + no30 +"|"
	   
	 + no31 +"|"
	   
	 + description +"|"
	   
	 + ucode +"|"
	 
	 + rateplanname +"|"
	 
	 + rateplancode +"|"
	 
	 + moytype +"|"
	 
	 + language
	 + "]";
 } 

}
