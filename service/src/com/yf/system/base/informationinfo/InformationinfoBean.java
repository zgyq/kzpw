/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.informationinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *资讯中心详细信息
 */
public class InformationinfoBean implements java.io.Serializable{

	/**
	  *资讯中心详细信息 表名
	  */
	public static final String TABLE  = "T_INFORMATIONINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *信息 列名 
	  */
    public static final String COL_info  = "C_INFO";
	
	/**
	  *类型ID 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建人id 列名 
	  */
    public static final String COL_memberid  = "C_MEMBERID";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *图片 列名 
	  */
    public static final String COL_image  = "C_IMAGE";
    
    
    /**
	  *是否问答 列名 
	  */
  public static final String COL_isanswer  = "C_ISANSWER";
  

  /**
	  *是否主推 列名 
	  */
 public static final String COL_isweb  = "C_ISWEB";
 
 

	//ID
	private long id;    
    

	//名称
	private String name;    
    

	//信息
	private String info;    
    

	//类型ID
	private Long typeid;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建人id
	private Long memberid;    
    

	//状态
	private Long state;    
    

	//图片
	private String image;    
    

	//是否是问答
	private Long isanswer;   //1问答  2文本信息
	
	
	
	//是否主推显示
	private Long isweb;   //1主推  2其他不主推
	
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
	 * get名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get信息
	 */
    public String getInfo(){
         return info;
    }

	/**
	 * set信息
	 */
    public void setInfo(String info){
         this.info=info;
    }

	/**
	 * get类型ID
	 */
    public Long getTypeid(){
         return typeid;
    }

	/**
	 * set类型ID
	 */
    public void setTypeid(Long typeid){
         this.typeid=typeid;
    }

	/**
	 * get创建时间
	 */
    public Timestamp getCreatetime(){
         return createtime;
    }

	/**
	 * set创建时间
	 */
    public void setCreatetime(Timestamp createtime){
         this.createtime=createtime;
    }

	/**
	 * get创建人id
	 */
    public Long getMemberid(){
         return memberid;
    }

	/**
	 * set创建人id
	 */
    public void setMemberid(Long memberid){
         this.memberid=memberid;
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

	/**
	 * get图片
	 */
    public String getImage(){
         return image;
    }

	/**
	 * set图片
	 */
    public void setImage(String image){
         this.image=image;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + name +"|"
	   
	 + info +"|"
	   
	 + typeid +"|"
	   
	 + createtime +"|"
	   
	 + memberid +"|"
	   
	 + state +"|"
	   
	 
	 + isanswer +"|"
	 
	 + isweb +"|"
	 
	 + image
	 + "]";
 }

	public Long getIsanswer() {
		return isanswer;
	}

	public void setIsanswer(Long isanswer) {
		this.isanswer = isanswer;
	}

	public Long getIsweb() {
		return isweb;
	}

	public void setIsweb(Long isweb) {
		this.isweb = isweb;
	} 

}
