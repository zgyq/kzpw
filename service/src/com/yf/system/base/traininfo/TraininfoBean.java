/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.traininfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *车次信息
 */
public class TraininfoBean implements java.io.Serializable{

	/**
	  *车次信息 表名
	  */
	public static final String TABLE  = "T_TRAININFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *车次编号 列名 
	  */
    public static final String COL_train_no  = "C_TRAIN_NO";
	
	/**
	  *始发站ID 列名 
	  */
    public static final String COL_from_id  = "C_FROM_ID";
	
	/**
	  *始发站名称 列名 
	  */
    public static final String COL_from_name  = "C_FROM_NAME";
	
	/**
	  *始发时间 列名 
	  */
    public static final String COL_from_time  = "C_FROM_TIME";
	
	/**
	  *终点站id 列名 
	  */
    public static final String COL_to_id  = "C_TO_ID";
	
	/**
	  *终点站名称 列名 
	  */
    public static final String COL_to_name  = "C_TO_NAME";
	
	/**
	  *终点站时间 列名 
	  */
    public static final String COL_to_time  = "C_TO_TIME";
	
	/**
	  *运行时间 列名 
	  */
    public static final String COL_run_time  = "C_RUN_TIME";
	
	/**
	  *运行周期 列名 
	  */
    public static final String COL_run_day  = "C_RUN_DAY";
	
	/**
	  *开运日期 列名 
	  */
    public static final String COL_start_data  = "C_START_DATA";
	
	/**
	  *结束日期 列名 
	  */
    public static final String COL_end_data  = "C_END_DATA";
	
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
	  *备用4 列名 
	  */
    public static final String COL_back4  = "C_BACK4";
	
	/**
	  *备用5 列名 
	  */
    public static final String COL_back5  = "C_BACK5";
	
	/**
	  *备用6 列名 
	  */
    public static final String COL_back6  = "C_BACK6";
	
	/**
	  *备用7 列名 
	  */
    public static final String COL_back7  = "C_BACK7";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";

	//ID
	private long id;    
    

	//车次编号
	private String train_no;    
    

	//始发站ID
	private String from_id;    
    

	//始发站名称
	private String from_name;    
    

	//始发时间
	private String from_time;    
    

	//终点站id
	private String to_id;    
    

	//终点站名称
	private String to_name;    
    

	//终点站时间
	private String to_time;    
    

	//运行时间
	private String run_time;    
    

	//运行周期
	private String run_day;    
    

	//开运日期
	private String start_data;    
    

	//结束日期
	private String end_data;    
    

	//备注
	private String mem;    
    

	//备用1
	private String back1;    
    

	//备用2
	private String back2;    
    

	//备用3
	private String back3;    
    

	//备用4
	private String back4;    
    

	//备用5
	private String back5;    
    

	//备用6
	private String back6;    
    

	//备用7
	private String back7;    
    

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
	 * get始发站ID
	 */
    public String getFrom_id(){
         return from_id;
    }

	/**
	 * set始发站ID
	 */
    public void setFrom_id(String from_id){
         this.from_id=from_id;
    }

	/**
	 * get始发站名称
	 */
    public String getFrom_name(){
         return from_name;
    }

	/**
	 * set始发站名称
	 */
    public void setFrom_name(String from_name){
         this.from_name=from_name;
    }

	/**
	 * get始发时间
	 */
    public String getFrom_time(){
         return from_time;
    }

	/**
	 * set始发时间
	 */
    public void setFrom_time(String from_time){
         this.from_time=from_time;
    }

	/**
	 * get终点站id
	 */
    public String getTo_id(){
         return to_id;
    }

	/**
	 * set终点站id
	 */
    public void setTo_id(String to_id){
         this.to_id=to_id;
    }

	/**
	 * get终点站名称
	 */
    public String getTo_name(){
         return to_name;
    }

	/**
	 * set终点站名称
	 */
    public void setTo_name(String to_name){
         this.to_name=to_name;
    }

	/**
	 * get终点站时间
	 */
    public String getTo_time(){
         return to_time;
    }

	/**
	 * set终点站时间
	 */
    public void setTo_time(String to_time){
         this.to_time=to_time;
    }

	/**
	 * get运行时间
	 */
    public String getRun_time(){
         return run_time;
    }

	/**
	 * set运行时间
	 */
    public void setRun_time(String run_time){
         this.run_time=run_time;
    }

	/**
	 * get运行周期
	 */
    public String getRun_day(){
         return run_day;
    }

	/**
	 * set运行周期
	 */
    public void setRun_day(String run_day){
         this.run_day=run_day;
    }

	/**
	 * get开运日期
	 */
    public String getStart_data(){
         return start_data;
    }

	/**
	 * set开运日期
	 */
    public void setStart_data(String start_data){
         this.start_data=start_data;
    }

	/**
	 * get结束日期
	 */
    public String getEnd_data(){
         return end_data;
    }

	/**
	 * set结束日期
	 */
    public void setEnd_data(String end_data){
         this.end_data=end_data;
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
	 * get备用4
	 */
    public String getBack4(){
         return back4;
    }

	/**
	 * set备用4
	 */
    public void setBack4(String back4){
         this.back4=back4;
    }

	/**
	 * get备用5
	 */
    public String getBack5(){
         return back5;
    }

	/**
	 * set备用5
	 */
    public void setBack5(String back5){
         this.back5=back5;
    }

	/**
	 * get备用6
	 */
    public String getBack6(){
         return back6;
    }

	/**
	 * set备用6
	 */
    public void setBack6(String back6){
         this.back6=back6;
    }

	/**
	 * get备用7
	 */
    public String getBack7(){
         return back7;
    }

	/**
	 * set备用7
	 */
    public void setBack7(String back7){
         this.back7=back7;
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
	   
	 + from_id +"|"
	   
	 + from_name +"|"
	   
	 + from_time +"|"
	   
	 + to_id +"|"
	   
	 + to_name +"|"
	   
	 + to_time +"|"
	   
	 + run_time +"|"
	   
	 + run_day +"|"
	   
	 + start_data +"|"
	   
	 + end_data +"|"
	   
	 + mem +"|"
	   
	 + back1 +"|"
	   
	 + back2 +"|"
	   
	 + back3 +"|"
	   
	 + back4 +"|"
	   
	 + back5 +"|"
	   
	 + back6 +"|"
	   
	 + back7 +"|"
	   
	 + state
	 + "]";
 } 

}
