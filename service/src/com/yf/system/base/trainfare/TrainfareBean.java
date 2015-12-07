/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.trainfare;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *火车票价
 */
public class TrainfareBean implements java.io.Serializable{

	/**
	  *火车票价 表名
	  */
	public static final String TABLE  = "T_TRAINFARE";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *车次编号 列名 
	  */
    public static final String COL_train_no  = "C_TRAIN_NO";
	
	/**
	  *出发站 列名 
	  */
    public static final String COL_start_station_name  = "C_START_STATION_NAME";
	
	/**
	  *出发站 列名 
	  */
    public static final String COL_stop_station_name  = "C_STOP_STATION_NAME";
	
	/**
	  *席别类型 列名 
	  */
    public static final String COL_seat_type  = "C_SEAT_TYPE";
	
	/**
	  *席别名称 列名 
	  */
    public static final String COL_seat_name  = "C_SEAT_NAME";
	
	/**
	  *铺位类型(0非1下2中3上) 列名 
	  */
    public static final String COL_bed_level  = "C_BED_LEVEL";
	
	/**
	  *价格(角) 列名 
	  */
    public static final String COL_price  = "C_PRICE";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_mem  = "C_MEM";
	
	/**
	  *备用1 列名 
	  */
    public static final String COL_back1  = "C_BACK1";
	
	/**
	  *备用2 列名 
	  */
    public static final String COL_back2  = "C_BACK2";
	
	/**
	  *备用3 列名 
	  */
    public static final String COL_back3  = "C_BACK3";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//车次编号
	private String train_no;    
    

	//出发站
	private String start_station_name;    
    

	//出发站
	private String stop_station_name;    
    

	//席别类型
	private String seat_type;    
    

	//席别名称
	private String seat_name;    
    

	//铺位类型(0非1下2中3上)
	private String bed_level;    
    

	//价格(角)
	private String price;    
    

	//备注
	private String mem;    
    

	//备用1
	private String back1;    
    

	//备用2
	private String back2;    
    

	//备用3
	private String back3;    
    

	//状态
	private Long state;    
    

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
	 * get车次编号
	 */
    public String getTrain_no(){
         return train_no;
    }

	/**
	 * set车次编号
	 */
    public void setTrain_no(String train_no){
         this.train_no=train_no;
    }

	/**
	 * get出发站
	 */
    public String getStart_station_name(){
         return start_station_name;
    }

	/**
	 * set出发站
	 */
    public void setStart_station_name(String start_station_name){
         this.start_station_name=start_station_name;
    }

	/**
	 * get出发站
	 */
    public String getStop_station_name(){
         return stop_station_name;
    }

	/**
	 * set出发站
	 */
    public void setStop_station_name(String stop_station_name){
         this.stop_station_name=stop_station_name;
    }

	/**
	 * get席别类型
	 */
    public String getSeat_type(){
         return seat_type;
    }

	/**
	 * set席别类型
	 */
    public void setSeat_type(String seat_type){
         this.seat_type=seat_type;
    }

	/**
	 * get席别名称
	 */
    public String getSeat_name(){
         return seat_name;
    }

	/**
	 * set席别名称
	 */
    public void setSeat_name(String seat_name){
         this.seat_name=seat_name;
    }

	/**
	 * get铺位类型(0非1下2中3上)
	 */
    public String getBed_level(){
         return bed_level;
    }

	/**
	 * set铺位类型(0非1下2中3上)
	 */
    public void setBed_level(String bed_level){
         this.bed_level=bed_level;
    }

	/**
	 * get价格(角)
	 */
    public String getPrice(){
         return price;
    }

	/**
	 * set价格(角)
	 */
    public void setPrice(String price){
         this.price=price;
    }

	/**
	 * get备注
	 */
    public String getMem(){
         return mem;
    }

	/**
	 * set备注
	 */
    public void setMem(String mem){
         this.mem=mem;
    }

	/**
	 * get备用1
	 */
    public String getBack1(){
         return back1;
    }

	/**
	 * set备用1
	 */
    public void setBack1(String back1){
         this.back1=back1;
    }

	/**
	 * get备用2
	 */
    public String getBack2(){
         return back2;
    }

	/**
	 * set备用2
	 */
    public void setBack2(String back2){
         this.back2=back2;
    }

	/**
	 * get备用3
	 */
    public String getBack3(){
         return back3;
    }

	/**
	 * set备用3
	 */
    public void setBack3(String back3){
         this.back3=back3;
    }

	/**
	 * get状态
	 */
    public Long getState(){
         return state;
    }

	/**
	 * set状态
	 */
    public void setState(Long state){
         this.state=state;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + train_no +"|"
	   
	 + start_station_name +"|"
	   
	 + stop_station_name +"|"
	   
	 + seat_type +"|"
	   
	 + seat_name +"|"
	   
	 + bed_level +"|"
	   
	 + price +"|"
	   
	 + mem +"|"
	   
	 + back1 +"|"
	   
	 + back2 +"|"
	   
	 + back3 +"|"
	   
	 + state
	 + "]";
 } 

}
