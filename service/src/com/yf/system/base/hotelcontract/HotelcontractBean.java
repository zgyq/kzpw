/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.hotelcontract;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *酒店合同
 */
public class HotelcontractBean implements java.io.Serializable{

	/**
	  *酒店合同 表名
	  */
	public static final String TABLE  = "C_HOTELCONTRACT";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *酒店ID 列名 
	  */
    public static final String COL_hotelid  = "C_HOTELID";
	
	/**
	  *合同编号 列名 
	  */
    public static final String COL_code  = "C_CODE";
	
	/**
	  *签约日期 列名 
	  */
    public static final String COL_signdate  = "C_SIGNDATE";
	
	/**
	  *终止日期 列名 
	  */
    public static final String COL_enddate  = "C_ENDDATE";
	
	/**
	  *酒店签约人 列名 
	  */
    public static final String COL_hotelsigner  = "C_HOTELSIGNER";
	
	/**
	  *公司签??????? 列名 
	  */
    public static final String COL_compsigner  = "C_COMPSIGNER";
	
	/**
	  *合同内容 列名 
	  */
    public static final String COL_content  = "C_CONTENT";
	
	/**
	  *合同文件路径 列名 
	  */
    public static final String COL_filepath  = "C_FILEPATH";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
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

	//ID
	private long id;    
    

	//酒店ID
	private Long hotelid;    
    

	//合同编号
	private String code;    
    

	//签约日期
	private Date signdate;    
    

	//终止日期
	private Date enddate;    
    

	//酒店签约人
	private String hotelsigner;    
    

	//公司签???????
	private String compsigner;    
    

	//合同内容
	private String content;    
    

	//合同文件路径
	private String filepath;    
    

	//状态
	private Integer state;    
    

	//描述
	private String description;    
    

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
	 * get合同编号
	 */
    public String getCode(){
         return code;
    }

	/**
	 * set合同编号
	 */
    public void setCode(String code){
         this.code=code;
    }

	/**
	 * get签约日期
	 */
    public Date getSigndate(){
         return signdate;
    }

	/**
	 * set签约日期
	 */
    public void setSigndate(Date signdate){
         this.signdate=signdate;
    }

	/**
	 * get终止日期
	 */
    public Date getEnddate(){
         return enddate;
    }

	/**
	 * set终止日期
	 */
    public void setEnddate(Date enddate){
         this.enddate=enddate;
    }

	/**
	 * get酒店签约人
	 */
    public String getHotelsigner(){
         return hotelsigner;
    }

	/**
	 * set酒店签约人
	 */
    public void setHotelsigner(String hotelsigner){
         this.hotelsigner=hotelsigner;
    }

	/**
	 * get公司签???????
	 */
    public String getCompsigner(){
         return compsigner;
    }

	/**
	 * set公司签???????
	 */
    public void setCompsigner(String compsigner){
         this.compsigner=compsigner;
    }

	/**
	 * get合同内容
	 */
    public String getContent(){
         return content;
    }

	/**
	 * set合同内容
	 */
    public void setContent(String content){
         this.content=content;
    }

	/**
	 * get合同文件路径
	 */
    public String getFilepath(){
         return filepath;
    }

	/**
	 * set合同文件路径
	 */
    public void setFilepath(String filepath){
         this.filepath=filepath;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + hotelid +"|"
	   
	 + code +"|"
	   
	 + signdate +"|"
	   
	 + enddate +"|"
	   
	 + hotelsigner +"|"
	   
	 + compsigner +"|"
	   
	 + content +"|"
	   
	 + filepath +"|"
	   
	 + state +"|"
	   
	 + description +"|"
	   
	 + ucode +"|"
	   
	 + language
	 + "]";
 } 

}
