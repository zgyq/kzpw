/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.roomstateback;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店房态表
 */
public class RoomstatebackBean implements java.io.Serializable{

	/**
	  *酒店房态表 表名
	  */
	public static final String TABLE  = "T_ROOMSTATEBACK";

	
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
	  *房型ID 列名 
	  */
    public static final String COL_roomid  = "C_ROOMID";
	
	/**
	  *是否禁用 列名 
	  */
    public static final String COL_isvalid  = "C_ISVALID";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *是否确认 列名 
	  */
    public static final String COL_confirmmethod  = "C_CONFIRMMETHOD";
	
	/**
	  *计算类别 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *单日房态31 列名 
	  */
    public static final String COL_no31  = "C_NO31";
	
	/**
	  *单日房态30 列名 
	  */
    public static final String COL_no30  = "C_NO30";
	
	/**
	  *单日房态29 列名 
	  */
    public static final String COL_no29  = "C_NO29";
	
	/**
	  *单日房态28 列名 
	  */
    public static final String COL_no28  = "C_NO28";
	
	/**
	  *单日房态27 列名 
	  */
    public static final String COL_no27  = "C_NO27";
	
	/**
	  *单日房态26 列名 
	  */
    public static final String COL_no26  = "C_NO26";
	
	/**
	  *单日房态25 列名 
	  */
    public static final String COL_no25  = "C_NO25";
	
	/**
	  *单日房态24 列名 
	  */
    public static final String COL_no24  = "C_NO24";
	
	/**
	  *单日房态23 列名 
	  */
    public static final String COL_no23  = "C_NO23";
	
	/**
	  *单日房态22 列名 
	  */
    public static final String COL_no22  = "C_NO22";
	
	/**
	  *单日房态21 列名 
	  */
    public static final String COL_no21  = "C_NO21";
	
	/**
	  *单日房态20 列名 
	  */
    public static final String COL_no20  = "C_NO20";
	
	/**
	  *单日房态19 列名 
	  */
    public static final String COL_no19  = "C_NO19";
	
	/**
	  *单日房态18 列名 
	  */
    public static final String COL_no18  = "C_NO18";
	
	/**
	  *单日房态17 列名 
	  */
    public static final String COL_no17  = "C_NO17";
	
	/**
	  *单日房态16 列名 
	  */
    public static final String COL_no16  = "C_NO16";
	
	/**
	  *单日房态15 列名 
	  */
    public static final String COL_no15  = "C_NO15";
	
	/**
	  *单日房态14 列名 
	  */
    public static final String COL_no14  = "C_NO14";
	
	/**
	  *单日房态13 列名 
	  */
    public static final String COL_no13  = "C_NO13";
	
	/**
	  *单日??态12 列名 
	  */
    public static final String COL_no12  = "C_NO12";
	
	/**
	  *单日房态11 列名 
	  */
    public static final String COL_no11  = "C_NO11";
	
	/**
	  *单日房态10 列名 
	  */
    public static final String COL_no10  = "C_NO10";
	
	/**
	  *单日房态9 列名 
	  */
    public static final String COL_no9  = "C_NO9";
	
	/**
	  *单日房态8 列名 
	  */
    public static final String COL_no8  = "C_NO8";
	
	/**
	  *单日房态7 列名 
	  */
    public static final String COL_no7  = "C_NO7";
	
	/**
	  *单日房态6 列名 
	  */
    public static final String COL_no6  = "C_NO6";
	
	/**
	  *????房态5 列名 
	  */
    public static final String COL_no5  = "C_NO5";
	
	/**
	  *单日房态4 列名 
	  */
    public static final String COL_no4  = "C_NO4";
	
	/**
	  *单日房态3 列名 
	  */
    public static final String COL_no3  = "C_NO3";
	
	/**
	  *单日房态2 列名 
	  */
    public static final String COL_no2  = "C_NO2";
	
	/**
	  *单日房态1 列名 
	  */
    public static final String COL_no1  = "C_NO1";
	
	/**
	  *单日剩31 列名 
	  */
    public static final String COL_back31  = "C_BACK31";
	
	/**
	  *单日剩30 列名 
	  */
    public static final String COL_back30  = "C_BACK30";
	
	/**
	  *单日剩29 列名 
	  */
    public static final String COL_back29  = "C_BACK29";
	
	/**
	  *单日剩28 列名 
	  */
    public static final String COL_back28  = "C_BACK28";
	
	/**
	  *单日剩27 列名 
	  */
    public static final String COL_back27  = "C_BACK27";
	
	/**
	  *单日剩26 列名 
	  */
    public static final String COL_back26  = "C_BACK26";
	
	/**
	  *单日剩25 列名 
	  */
    public static final String COL_back25  = "C_BACK25";
	
	/**
	  *单日剩24 列名 
	  */
    public static final String COL_back24  = "C_BACK24";
	
	/**
	  *单日剩23 列名 
	  */
    public static final String COL_back23  = "C_BACK23";
	
	/**
	  *单日剩22 列名 
	  */
    public static final String COL_back22  = "C_BACK22";
	
	/**
	  *单日剩21 列名 
	  */
    public static final String COL_back21  = "C_BACK21";
	
	/**
	  *单日剩20 列名 
	  */
    public static final String COL_back20  = "C_BACK20";
	
	/**
	  *单日剩19 列名 
	  */
    public static final String COL_back19  = "C_BACK19";
	
	/**
	  *单日剩18 列名 
	  */
    public static final String COL_back18  = "C_BACK18";
	
	/**
	  *单日剩17 列名 
	  */
    public static final String COL_back17  = "C_BACK17";
	
	/**
	  *单日???16 列名 
	  */
    public static final String COL_back16  = "C_BACK16";
	
	/**
	  *单日剩15 列名 
	  */
    public static final String COL_back15  = "C_BACK15";
	
	/**
	  *单日剩14 列名 
	  */
    public static final String COL_back14  = "C_BACK14";
	
	/**
	  *单日剩13 列名 
	  */
    public static final String COL_back13  = "C_BACK13";
	
	/**
	  *单日剩12 列名 
	  */
    public static final String COL_back12  = "C_BACK12";
	
	/**
	  *单日剩11 列名 
	  */
    public static final String COL_back11  = "C_BACK11";
	
	/**
	  *单日剩10 列名 
	  */
    public static final String COL_back10  = "C_BACK10";
	
	/**
	  *单日剩9 列名 
	  */
    public static final String COL_back9  = "C_BACK9";
	
	/**
	  *单日剩8 列名 
	  */
    public static final String COL_back8  = "C_BACK8";
	
	/**
	  *单日剩7 列名 
	  */
    public static final String COL_back7  = "C_BACK7";
	
	/**
	  *单日剩6 列名 
	  */
    public static final String COL_back6  = "C_BACK6";
	
	/**
	  *单日剩5 列名 
	  */
    public static final String COL_back5  = "C_BACK5";
	
	/**
	  *单日剩4 列名 
	  */
    public static final String COL_back4  = "C_BACK4";
	
	/**
	  *单???剩3 列名 
	  */
    public static final String COL_back3  = "C_BACK3";
	
	/**
	  *单日剩2 列名 
	  */
    public static final String COL_back2  = "C_BACK2";
	
	/**
	  *单日剩1 列名 
	  */
    public static final String COL_back1  = "C_BACK1";
	
	/**
	  *父编号 列名 
	  */
    public static final String COL_ucode  = "C_UCODE";
	
	/**
	  *语言类型 列名 
	  */
    public static final String COL_language  = "C_LANGUAGE";

	//ID
	private long id;    
    

	//月份
	private String datenumber;    
    

	//酒店ID
	private Long hotelid;    
    

	//房型ID
	private Long roomid;    
    

	//是否禁用
	private String isvalid;    
    

	//描述
	private String description;    
    

	//状态
	private Integer state;    
    

	//是否确认
	private Integer confirmmethod;    
    

	//计算类别
	private Integer type;    
    

	//单日房态31
	private Integer no31;    
    

	//单日房态30
	private Integer no30;    
    

	//单日房态29
	private Integer no29;    
    

	//单日房态28
	private Integer no28;    
    

	//单日房态27
	private Integer no27;    
    

	//单日房态26
	private Integer no26;    
    

	//单日房态25
	private Integer no25;    
    

	//单日房态24
	private Integer no24;    
    

	//单日房态23
	private Integer no23;    
    

	//单日房态22
	private Integer no22;    
    

	//单日房态21
	private Integer no21;    
    

	//单日房态20
	private Integer no20;    
    

	//单日房态19
	private Integer no19;    
    

	//单日房态18
	private Integer no18;    
    

	//单日房态17
	private Integer no17;    
    

	//单日房态16
	private Integer no16;    
    

	//单日房态15
	private Integer no15;    
    

	//单日房态14
	private Integer no14;    
    

	//单日房态13
	private Integer no13;    
    

	//单日??态12
	private Integer no12;    
    

	//单日房态11
	private Integer no11;    
    

	//单日房态10
	private Integer no10;    
    

	//单日房态9
	private Integer no9;    
    

	//单日房态8
	private Integer no8;    
    

	//单日房态7
	private Integer no7;    
    

	//单日房态6
	private Integer no6;    
    

	//????房态5
	private Integer no5;    
    

	//单日房态4
	private Integer no4;    
    

	//单日房态3
	private Integer no3;    
    

	//单日房态2
	private Integer no2;    
    

	//单日房态1
	private Integer no1;    
    

	//单日剩31
	private Integer back31;    
    

	//单日剩30
	private Integer back30;    
    

	//单日剩29
	private Integer back29;    
    

	//单日剩28
	private Integer back28;    
    

	//单日剩27
	private Integer back27;    
    

	//单日剩26
	private Integer back26;    
    

	//单日剩25
	private Integer back25;    
    

	//单日剩24
	private Integer back24;    
    

	//单日剩23
	private Integer back23;    
    

	//单日剩22
	private Integer back22;    
    

	//单日剩21
	private Integer back21;    
    

	//单日剩20
	private Integer back20;    
    

	//单日剩19
	private Integer back19;    
    

	//单日剩18
	private Integer back18;    
    

	//单日剩17
	private Integer back17;    
    

	//单日???16
	private Integer back16;    
    

	//单日剩15
	private Integer back15;    
    

	//单日剩14
	private Integer back14;    
    

	//单日剩13
	private Integer back13;    
    

	//单日剩12
	private Integer back12;    
    

	//单日剩11
	private Integer back11;    
    

	//单日剩10
	private Integer back10;    
    

	//单日剩9
	private Integer back9;    
    

	//单日剩8
	private Integer back8;    
    

	//单日剩7
	private Integer back7;    
    

	//单日剩6
	private Integer back6;    
    

	//单日剩5
	private Integer back5;    
    

	//单日剩4
	private Integer back4;    
    

	//单???剩3
	private Integer back3;    
    

	//单日剩2
	private Integer back2;    
    

	//单日剩1
	private Integer back1;    
    

	//父编号
	private Long ucode;    
    

	//语言类型
	private Integer language;    
    

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
	 * get状态
	 */
    public Integer getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Integer state){
         this.state=state;
    }

	/**
	 * get是否确认
	 */
    public Integer getConfirmmethod(){
         return confirmmethod;
    }

	/**
	 * set是否确认
	 */
    public void setConfirmmethod(Integer confirmmethod){
         this.confirmmethod=confirmmethod;
    }

	/**
	 * get计算类别
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set计算类别
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get单日房态31
	 */
    public Integer getNo31(){
         return no31;
    }

	/**
	 * set单日房态31
	 */
    public void setNo31(Integer no31){
         this.no31=no31;
    }

	/**
	 * get单日房态30
	 */
    public Integer getNo30(){
         return no30;
    }

	/**
	 * set单日房态30
	 */
    public void setNo30(Integer no30){
         this.no30=no30;
    }

	/**
	 * get单日房态29
	 */
    public Integer getNo29(){
         return no29;
    }

	/**
	 * set单日房态29
	 */
    public void setNo29(Integer no29){
         this.no29=no29;
    }

	/**
	 * get单日房态28
	 */
    public Integer getNo28(){
         return no28;
    }

	/**
	 * set单日房态28
	 */
    public void setNo28(Integer no28){
         this.no28=no28;
    }

	/**
	 * get单日房态27
	 */
    public Integer getNo27(){
         return no27;
    }

	/**
	 * set单日房态27
	 */
    public void setNo27(Integer no27){
         this.no27=no27;
    }

	/**
	 * get单日房态26
	 */
    public Integer getNo26(){
         return no26;
    }

	/**
	 * set单日房态26
	 */
    public void setNo26(Integer no26){
         this.no26=no26;
    }

	/**
	 * get单日房态25
	 */
    public Integer getNo25(){
         return no25;
    }

	/**
	 * set单日房态25
	 */
    public void setNo25(Integer no25){
         this.no25=no25;
    }

	/**
	 * get单日房态24
	 */
    public Integer getNo24(){
         return no24;
    }

	/**
	 * set单日房态24
	 */
    public void setNo24(Integer no24){
         this.no24=no24;
    }

	/**
	 * get单日房态23
	 */
    public Integer getNo23(){
         return no23;
    }

	/**
	 * set单日房态23
	 */
    public void setNo23(Integer no23){
         this.no23=no23;
    }

	/**
	 * get单日房态22
	 */
    public Integer getNo22(){
         return no22;
    }

	/**
	 * set单日房态22
	 */
    public void setNo22(Integer no22){
         this.no22=no22;
    }

	/**
	 * get单日房态21
	 */
    public Integer getNo21(){
         return no21;
    }

	/**
	 * set单日房态21
	 */
    public void setNo21(Integer no21){
         this.no21=no21;
    }

	/**
	 * get单日房态20
	 */
    public Integer getNo20(){
         return no20;
    }

	/**
	 * set单日房态20
	 */
    public void setNo20(Integer no20){
         this.no20=no20;
    }

	/**
	 * get单日房态19
	 */
    public Integer getNo19(){
         return no19;
    }

	/**
	 * set单日房态19
	 */
    public void setNo19(Integer no19){
         this.no19=no19;
    }

	/**
	 * get单日房态18
	 */
    public Integer getNo18(){
         return no18;
    }

	/**
	 * set单日房态18
	 */
    public void setNo18(Integer no18){
         this.no18=no18;
    }

	/**
	 * get单日房态17
	 */
    public Integer getNo17(){
         return no17;
    }

	/**
	 * set单日房态17
	 */
    public void setNo17(Integer no17){
         this.no17=no17;
    }

	/**
	 * get单日房态16
	 */
    public Integer getNo16(){
         return no16;
    }

	/**
	 * set单日房态16
	 */
    public void setNo16(Integer no16){
         this.no16=no16;
    }

	/**
	 * get单日房态15
	 */
    public Integer getNo15(){
         return no15;
    }

	/**
	 * set单日房态15
	 */
    public void setNo15(Integer no15){
         this.no15=no15;
    }

	/**
	 * get单日房态14
	 */
    public Integer getNo14(){
         return no14;
    }

	/**
	 * set单日房态14
	 */
    public void setNo14(Integer no14){
         this.no14=no14;
    }

	/**
	 * get单日房态13
	 */
    public Integer getNo13(){
         return no13;
    }

	/**
	 * set单日房态13
	 */
    public void setNo13(Integer no13){
         this.no13=no13;
    }

	/**
	 * get单日??态12
	 */
    public Integer getNo12(){
         return no12;
    }

	/**
	 * set单日??态12
	 */
    public void setNo12(Integer no12){
         this.no12=no12;
    }

	/**
	 * get单日房态11
	 */
    public Integer getNo11(){
         return no11;
    }

	/**
	 * set单日房态11
	 */
    public void setNo11(Integer no11){
         this.no11=no11;
    }

	/**
	 * get单日房态10
	 */
    public Integer getNo10(){
         return no10;
    }

	/**
	 * set单日房态10
	 */
    public void setNo10(Integer no10){
         this.no10=no10;
    }

	/**
	 * get单日房态9
	 */
    public Integer getNo9(){
         return no9;
    }

	/**
	 * set单日房态9
	 */
    public void setNo9(Integer no9){
         this.no9=no9;
    }

	/**
	 * get单日房态8
	 */
    public Integer getNo8(){
         return no8;
    }

	/**
	 * set单日房态8
	 */
    public void setNo8(Integer no8){
         this.no8=no8;
    }

	/**
	 * get单日房态7
	 */
    public Integer getNo7(){
         return no7;
    }

	/**
	 * set单日房态7
	 */
    public void setNo7(Integer no7){
         this.no7=no7;
    }

	/**
	 * get单日房态6
	 */
    public Integer getNo6(){
         return no6;
    }

	/**
	 * set单日房态6
	 */
    public void setNo6(Integer no6){
         this.no6=no6;
    }

	/**
	 * get????房态5
	 */
    public Integer getNo5(){
         return no5;
    }

	/**
	 * set????房态5
	 */
    public void setNo5(Integer no5){
         this.no5=no5;
    }

	/**
	 * get单日房态4
	 */
    public Integer getNo4(){
         return no4;
    }

	/**
	 * set单日房态4
	 */
    public void setNo4(Integer no4){
         this.no4=no4;
    }

	/**
	 * get单日房态3
	 */
    public Integer getNo3(){
         return no3;
    }

	/**
	 * set单日房态3
	 */
    public void setNo3(Integer no3){
         this.no3=no3;
    }

	/**
	 * get单日房态2
	 */
    public Integer getNo2(){
         return no2;
    }

	/**
	 * set单日房态2
	 */
    public void setNo2(Integer no2){
         this.no2=no2;
    }

	/**
	 * get单日房态1
	 */
    public Integer getNo1(){
         return no1;
    }

	/**
	 * set单日房态1
	 */
    public void setNo1(Integer no1){
         this.no1=no1;
    }

	/**
	 * get单日剩31
	 */
    public Integer getBack31(){
         return back31;
    }

	/**
	 * set单日剩31
	 */
    public void setBack31(Integer back31){
         this.back31=back31;
    }

	/**
	 * get单日剩30
	 */
    public Integer getBack30(){
         return back30;
    }

	/**
	 * set单日剩30
	 */
    public void setBack30(Integer back30){
         this.back30=back30;
    }

	/**
	 * get单日剩29
	 */
    public Integer getBack29(){
         return back29;
    }

	/**
	 * set单日剩29
	 */
    public void setBack29(Integer back29){
         this.back29=back29;
    }

	/**
	 * get单日剩28
	 */
    public Integer getBack28(){
         return back28;
    }

	/**
	 * set单日剩28
	 */
    public void setBack28(Integer back28){
         this.back28=back28;
    }

	/**
	 * get单日剩27
	 */
    public Integer getBack27(){
         return back27;
    }

	/**
	 * set单日剩27
	 */
    public void setBack27(Integer back27){
         this.back27=back27;
    }

	/**
	 * get单日剩26
	 */
    public Integer getBack26(){
         return back26;
    }

	/**
	 * set单日剩26
	 */
    public void setBack26(Integer back26){
         this.back26=back26;
    }

	/**
	 * get单日剩25
	 */
    public Integer getBack25(){
         return back25;
    }

	/**
	 * set单日剩25
	 */
    public void setBack25(Integer back25){
         this.back25=back25;
    }

	/**
	 * get单日剩24
	 */
    public Integer getBack24(){
         return back24;
    }

	/**
	 * set单日剩24
	 */
    public void setBack24(Integer back24){
         this.back24=back24;
    }

	/**
	 * get单日剩23
	 */
    public Integer getBack23(){
         return back23;
    }

	/**
	 * set单日剩23
	 */
    public void setBack23(Integer back23){
         this.back23=back23;
    }

	/**
	 * get单日剩22
	 */
    public Integer getBack22(){
         return back22;
    }

	/**
	 * set单日剩22
	 */
    public void setBack22(Integer back22){
         this.back22=back22;
    }

	/**
	 * get单日剩21
	 */
    public Integer getBack21(){
         return back21;
    }

	/**
	 * set单日剩21
	 */
    public void setBack21(Integer back21){
         this.back21=back21;
    }

	/**
	 * get单日剩20
	 */
    public Integer getBack20(){
         return back20;
    }

	/**
	 * set单日剩20
	 */
    public void setBack20(Integer back20){
         this.back20=back20;
    }

	/**
	 * get单日剩19
	 */
    public Integer getBack19(){
         return back19;
    }

	/**
	 * set单日剩19
	 */
    public void setBack19(Integer back19){
         this.back19=back19;
    }

	/**
	 * get单日剩18
	 */
    public Integer getBack18(){
         return back18;
    }

	/**
	 * set单日剩18
	 */
    public void setBack18(Integer back18){
         this.back18=back18;
    }

	/**
	 * get单日剩17
	 */
    public Integer getBack17(){
         return back17;
    }

	/**
	 * set单日剩17
	 */
    public void setBack17(Integer back17){
         this.back17=back17;
    }

	/**
	 * get单日???16
	 */
    public Integer getBack16(){
         return back16;
    }

	/**
	 * set单日???16
	 */
    public void setBack16(Integer back16){
         this.back16=back16;
    }

	/**
	 * get单日剩15
	 */
    public Integer getBack15(){
         return back15;
    }

	/**
	 * set单日剩15
	 */
    public void setBack15(Integer back15){
         this.back15=back15;
    }

	/**
	 * get单日剩14
	 */
    public Integer getBack14(){
         return back14;
    }

	/**
	 * set单日剩14
	 */
    public void setBack14(Integer back14){
         this.back14=back14;
    }

	/**
	 * get单日剩13
	 */
    public Integer getBack13(){
         return back13;
    }

	/**
	 * set单日剩13
	 */
    public void setBack13(Integer back13){
         this.back13=back13;
    }

	/**
	 * get单日剩12
	 */
    public Integer getBack12(){
         return back12;
    }

	/**
	 * set单日剩12
	 */
    public void setBack12(Integer back12){
         this.back12=back12;
    }

	/**
	 * get单日剩11
	 */
    public Integer getBack11(){
         return back11;
    }

	/**
	 * set单日剩11
	 */
    public void setBack11(Integer back11){
         this.back11=back11;
    }

	/**
	 * get单日剩10
	 */
    public Integer getBack10(){
         return back10;
    }

	/**
	 * set单日剩10
	 */
    public void setBack10(Integer back10){
         this.back10=back10;
    }

	/**
	 * get单日剩9
	 */
    public Integer getBack9(){
         return back9;
    }

	/**
	 * set单日剩9
	 */
    public void setBack9(Integer back9){
         this.back9=back9;
    }

	/**
	 * get单日剩8
	 */
    public Integer getBack8(){
         return back8;
    }

	/**
	 * set单日剩8
	 */
    public void setBack8(Integer back8){
         this.back8=back8;
    }

	/**
	 * get单日剩7
	 */
    public Integer getBack7(){
         return back7;
    }

	/**
	 * set单日剩7
	 */
    public void setBack7(Integer back7){
         this.back7=back7;
    }

	/**
	 * get单日剩6
	 */
    public Integer getBack6(){
         return back6;
    }

	/**
	 * set单日剩6
	 */
    public void setBack6(Integer back6){
         this.back6=back6;
    }

	/**
	 * get单日剩5
	 */
    public Integer getBack5(){
         return back5;
    }

	/**
	 * set单日剩5
	 */
    public void setBack5(Integer back5){
         this.back5=back5;
    }

	/**
	 * get单日剩4
	 */
    public Integer getBack4(){
         return back4;
    }

	/**
	 * set单日剩4
	 */
    public void setBack4(Integer back4){
         this.back4=back4;
    }

	/**
	 * get单???剩3
	 */
    public Integer getBack3(){
         return back3;
    }

	/**
	 * set单???剩3
	 */
    public void setBack3(Integer back3){
         this.back3=back3;
    }

	/**
	 * get单日剩2
	 */
    public Integer getBack2(){
         return back2;
    }

	/**
	 * set单日剩2
	 */
    public void setBack2(Integer back2){
         this.back2=back2;
    }

	/**
	 * get单日剩1
	 */
    public Integer getBack1(){
         return back1;
    }

	/**
	 * set单日剩1
	 */
    public void setBack1(Integer back1){
         this.back1=back1;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + datenumber +"|"
	   
	 + hotelid +"|"
	   
	 + roomid +"|"
	   
	 + isvalid +"|"
	   
	 + description +"|"
	   
	 + state +"|"
	   
	 + confirmmethod +"|"
	   
	 + type +"|"
	   
	 + no31 +"|"
	   
	 + no30 +"|"
	   
	 + no29 +"|"
	   
	 + no28 +"|"
	   
	 + no27 +"|"
	   
	 + no26 +"|"
	   
	 + no25 +"|"
	   
	 + no24 +"|"
	   
	 + no23 +"|"
	   
	 + no22 +"|"
	   
	 + no21 +"|"
	   
	 + no20 +"|"
	   
	 + no19 +"|"
	   
	 + no18 +"|"
	   
	 + no17 +"|"
	   
	 + no16 +"|"
	   
	 + no15 +"|"
	   
	 + no14 +"|"
	   
	 + no13 +"|"
	   
	 + no12 +"|"
	   
	 + no11 +"|"
	   
	 + no10 +"|"
	   
	 + no9 +"|"
	   
	 + no8 +"|"
	   
	 + no7 +"|"
	   
	 + no6 +"|"
	   
	 + no5 +"|"
	   
	 + no4 +"|"
	   
	 + no3 +"|"
	   
	 + no2 +"|"
	   
	 + no1 +"|"
	   
	 + back31 +"|"
	   
	 + back30 +"|"
	   
	 + back29 +"|"
	   
	 + back28 +"|"
	   
	 + back27 +"|"
	   
	 + back26 +"|"
	   
	 + back25 +"|"
	   
	 + back24 +"|"
	   
	 + back23 +"|"
	   
	 + back22 +"|"
	   
	 + back21 +"|"
	   
	 + back20 +"|"
	   
	 + back19 +"|"
	   
	 + back18 +"|"
	   
	 + back17 +"|"
	   
	 + back16 +"|"
	   
	 + back15 +"|"
	   
	 + back14 +"|"
	   
	 + back13 +"|"
	   
	 + back12 +"|"
	   
	 + back11 +"|"
	   
	 + back10 +"|"
	   
	 + back9 +"|"
	   
	 + back8 +"|"
	   
	 + back7 +"|"
	   
	 + back6 +"|"
	   
	 + back5 +"|"
	   
	 + back4 +"|"
	   
	 + back3 +"|"
	   
	 + back2 +"|"
	   
	 + back1 +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
