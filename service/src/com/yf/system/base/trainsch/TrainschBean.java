/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.trainsch;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *列车时刻
 */
public class TrainschBean implements java.io.Serializable{

	/**
	  *列车时刻 表名
	  */
	public static final String TABLE  = "T_TRAINSCH";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *车次编号 列名 
	  */
    public static final String COL_train_id  = "C_TRAIN_ID";
	
	/**
	  *GTFS类型 列名 
	  */
    public static final String COL_train_class  = "C_TRAIN_CLASS";
	
	/**
	  *GTFSID 列名 
	  */
    public static final String COL_trainstation_id  = "C_TRAINSTATION_ID";
	
	/**
	  *车站名称 列名 
	  */
    public static final String COL_station_name  = "C_STATION_NAME";
	
	/**
	  *到达时间 列名 
	  */
    public static final String COL_arr_time  = "C_ARR_TIME";
	
	/**
	  *离开时间 列名 
	  */
    public static final String COL_dep_time  = "C_DEP_TIME";
	
	/**
	  *到达时间_秒 列名 
	  */
    public static final String COL_arr_time24  = "C_ARR_TIME24";
	
	/**
	  *离开时间_秒 列名 
	  */
    public static final String COL_dep_time24  = "C_DEP_TIME24";
	
	/**
	  *站序 列名 
	  */
    public static final String COL_station_no  = "C_STATION_NO";
	
	/**
	  *到达日(0123) 列名 
	  */
    public static final String COL_day_arr  = "C_DAY_ARR";
	
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
	private String train_id;    
    

	//GTFS类型
	private String train_class;    
    

	//GTFSID
	private String trainstation_id;    
    

	//车站名称
	private String station_name;    
    

	//到达时间
	private String arr_time;    
    

	//离开时间
	private String dep_time;    
    

	//到达时间_秒
	private String arr_time24;    
    

	//离开时间_秒
	private String dep_time24;    
    

	//站序
	private String station_no;    
    

	//到达日(0123)
	private String day_arr;    
    

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
    public String getTrain_id(){
         return train_id;
    }

	/**
	 * set车次编号
	 */
    public void setTrain_id(String train_id){
         this.train_id=train_id;
    }

	/**
	 * getGTFS类型
	 */
    public String getTrain_class(){
         return train_class;
    }

	/**
	 * setGTFS类型
	 */
    public void setTrain_class(String train_class){
         this.train_class=train_class;
    }

	/**
	 * getGTFSID
	 */
    public String getTrainstation_id(){
         return trainstation_id;
    }

	/**
	 * setGTFSID
	 */
    public void setTrainstation_id(String trainstation_id){
         this.trainstation_id=trainstation_id;
    }

	/**
	 * get车站名称
	 */
    public String getStation_name(){
         return station_name;
    }

	/**
	 * set车站名称
	 */
    public void setStation_name(String station_name){
         this.station_name=station_name;
    }

	/**
	 * get到达时间
	 */
    public String getArr_time(){
         return arr_time;
    }

	/**
	 * set到达时间
	 */
    public void setArr_time(String arr_time){
         this.arr_time=arr_time;
    }

	/**
	 * get离开时间
	 */
    public String getDep_time(){
         return dep_time;
    }

	/**
	 * set离开时间
	 */
    public void setDep_time(String dep_time){
         this.dep_time=dep_time;
    }

	/**
	 * get到达时间_秒
	 */
    public String getArr_time24(){
         return arr_time24;
    }

	/**
	 * set到达时间_秒
	 */
    public void setArr_time24(String arr_time24){
         this.arr_time24=arr_time24;
    }

	/**
	 * get离开时间_秒
	 */
    public String getDep_time24(){
         return dep_time24;
    }

	/**
	 * set离开时间_秒
	 */
    public void setDep_time24(String dep_time24){
         this.dep_time24=dep_time24;
    }

	/**
	 * get站序
	 */
    public String getStation_no(){
         return station_no;
    }

	/**
	 * set站序
	 */
    public void setStation_no(String station_no){
         this.station_no=station_no;
    }

	/**
	 * get到达日(0123)
	 */
    public String getDay_arr(){
         return day_arr;
    }

	/**
	 * set到达日(0123)
	 */
    public void setDay_arr(String day_arr){
         this.day_arr=day_arr;
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
	   
	 + train_id +"|"
	   
	 + train_class +"|"
	   
	 + trainstation_id +"|"
	   
	 + station_name +"|"
	   
	 + arr_time +"|"
	   
	 + dep_time +"|"
	   
	 + arr_time24 +"|"
	   
	 + dep_time24 +"|"
	   
	 + station_no +"|"
	   
	 + day_arr +"|"
	   
	 + mem +"|"
	   
	 + back1 +"|"
	   
	 + back2 +"|"
	   
	 + back3 +"|"
	   
	 + state
	 + "]";
 } 

}
