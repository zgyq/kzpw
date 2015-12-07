/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.prizeinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *积分礼品信息
 */
public class PrizeinfoBean implements java.io.Serializable{

	/**
	  *积分礼品信息 表名
	  */
	public static final String TABLE  = "T_PRIZEINFO";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *所属类别 列名 
	  */
    public static final String COL_typeid  = "C_TYPEID";
	
	/**
	  *礼品名称 列名 
	  */
    public static final String COL_name  = "C_NAME";
	
	/**
	  *图片路径 列名 
	  */
    public static final String COL_imgurl  = "C_IMGURL";
	
	/**
	  *描述 列名 
	  */
    public static final String COL_desc  = "C_DESC";
	
	/**
	  *所需积分 列名 
	  */
    public static final String COL_scores  = "C_SCORES";
	
	/**
	  *排序 列名 
	  */
    public static final String COL_index  = "C_INDEX";
	
	/**
	  *是否允许兑换 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";

	//ID
	private long id;    
    

	//所属类别
	private Long typeid;    
    

	//礼品名称
	private String name;    
    

	//图片路径
	private String imgurl;    
    

	//描述
	private String desc;    
    

	//所需积分
	private Integer scores;    
    

	//排序
	private Integer index;    
    

	//是否允许兑换
	private Integer isenable;    
    

	//创建者
	private String createuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//修改者
	private String modifyuser;    
    

	//修改时间
	private Timestamp modifytime;    
    

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
	 * get所属类别
	 */
    public Long getTypeid(){
         return typeid;
    }

	/**
	 * set所属类别
	 */
    public void setTypeid(Long typeid){
         this.typeid=typeid;
    }

	/**
	 * get礼品名称
	 */
    public String getName(){
         return name;
    }

	/**
	 * set礼品名称
	 */
    public void setName(String name){
         this.name=name;
    }

	/**
	 * get图片路径
	 */
    public String getImgurl(){
         return imgurl;
    }

	/**
	 * set图片路径
	 */
    public void setImgurl(String imgurl){
         this.imgurl=imgurl;
    }

	/**
	 * get描述
	 */
    public String getDesc(){
         return desc;
    }

	/**
	 * set描述
	 */
    public void setDesc(String desc){
         this.desc=desc;
    }

	/**
	 * get所需积分
	 */
    public Integer getScores(){
         return scores;
    }

	/**
	 * set所需积分
	 */
    public void setScores(Integer scores){
         this.scores=scores;
    }

	/**
	 * get排序
	 */
    public Integer getIndex(){
         return index;
    }

	/**
	 * set排序
	 */
    public void setIndex(Integer index){
         this.index=index;
    }

	/**
	 * get是否允许兑换
	 */
    public Integer getIsenable(){
         return isenable;
    }

	/**
	 * set是否允许兑换
	 */
    public void setIsenable(Integer isenable){
         this.isenable=isenable;
    }

	/**
	 * get创建者
	 */
    public String getCreateuser(){
         return createuser;
    }

	/**
	 * set创建者
	 */
    public void setCreateuser(String createuser){
         this.createuser=createuser;
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
	 * get修改者
	 */
    public String getModifyuser(){
         return modifyuser;
    }

	/**
	 * set修改者
	 */
    public void setModifyuser(String modifyuser){
         this.modifyuser=modifyuser;
    }

	/**
	 * get修改时间
	 */
    public Timestamp getModifytime(){
         return modifytime;
    }

	/**
	 * set修改时间
	 */
    public void setModifytime(Timestamp modifytime){
         this.modifytime=modifytime;
    }


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + typeid +"|"
	   
	 + name +"|"
	   
	 + imgurl +"|"
	   
	 + desc +"|"
	   
	 + scores +"|"
	   
	 + index +"|"
	   
	 + isenable +"|"
	   
	 + createuser +"|"
	   
	 + createtime +"|"
	   
	 + modifyuser +"|"
	   
	 + modifytime
	 + "]";
 } 

}
