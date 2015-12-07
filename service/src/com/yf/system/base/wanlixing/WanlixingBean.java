/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.wanlixing;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *万里行申请表
 */
public class WanlixingBean implements java.io.Serializable{

	/**
	  *万里行申请表 表名
	  */
	public static final String TABLE  = "T_WANLIXING";

	
	/**
	  *ID 列名 
	  */
    public static final String COL_id  = "ID";
	
	/**
	  *性别 列名 
	  */
    public static final String COL_sex  = "C_SEX";
	
	/**
	  *称谓 列名 
	  */
    public static final String COL_chenghu  = "C_CHENGHU";
	
	/**
	  *中文姓 列名 
	  */
    public static final String COL_zxing  = "C_ZXING";
	
	/**
	  *中文名 列名 
	  */
    public static final String COL_zming  = "C_ZMING";
	
	/**
	  *英文姓 列名 
	  */
    public static final String COL_yxing  = "C_YXING";
	
	/**
	  *英文名 列名 
	  */
    public static final String COL_yming  = "C_YMING";
	
	/**
	  *身份证号码 列名 
	  */
    public static final String COL_number  = "C_NUMBER";
	
	/**
	  *护照号码 列名 
	  */
    public static final String COL_huzhao  = "C_HUZHAO";
	
	/**
	  *军官证 列名 
	  */
    public static final String COL_jun  = "C_JUN";
	
	/**
	  *回乡证 列名 
	  */
    public static final String COL_hui  = "C_HUI";
	
	/**
	  *其他证件号码 列名 
	  */
    public static final String COL_qita  = "C_QITA";
	
	/**
	  *国籍 列名 
	  */
    public static final String COL_guoji  = "C_GUOJI";
	
	/**
	  *出生日期 列名 
	  */
    public static final String COL_chusheng  = "C_CHUSHENG";
	
	/**
	  *联络语言 列名 
	  */
    public static final String COL_yuyan  = "C_YUYAN";
	
	/**
	  *密码 列名 
	  */
    public static final String COL_password  = "C_PASSWORD";
	
	/**
	  *提示问题 列名 
	  */
    public static final String COL_wenti  = "C_WENTI";
	
	/**
	  *问题答案 列名 
	  */
    public static final String COL_daan  = "C_DAAN";
	
	/**
	  *邮箱 列名 
	  */
    public static final String COL_postbox  = "C_POSTBOX";
	
	/**
	  *邮寄类型 列名 
	  */
    public static final String COL_youtype  = "C_YOUTYPE";
	
	/**
	  *邮寄到国家 列名 
	  */
    public static final String COL_youjiguo  = "C_YOUJIGUO";
	
	/**
	  *邮寄到省 列名 
	  */
    public static final String COL_youjisheng  = "C_YOUJISHENG";
	
	/**
	  *邮政编码 列名 
	  */
    public static final String COL_youbian  = "C_YOUBIAN";
	
	/**
	  *市/县/自治州 列名 
	  */
    public static final String COL_shi  = "C_SHI";
	
	/**
	  *邮寄地址 列名 
	  */
    public static final String COL_address  = "C_ADDRESS";
	
	/**
	  *联系电话 列名 
	  */
    public static final String COL_dianhua  = "C_DIANHUA";
	
	/**
	  *传真 列名 
	  */
    public static final String COL_fax  = "C_FAX";
	
	/**
	  *账单邮寄类型 列名 
	  */
    public static final String COL_duizhangtype  = "C_DUIZHANGTYPE";
	
	/**
	  *联系手机 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *单位名称 列名 
	  */
    public static final String COL_copname  = "C_COPNAME";
	
	/**
	  *阁下级别 列名 
	  */
    public static final String COL_jibie  = "C_JIBIE";
	
	/**
	  *行业性质 列名 
	  */
    public static final String COL_xingzhi  = "C_XINGZHI";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";

	//ID
	private long id;    
    

	//性别
	private Long sex;    
    

	//称谓
	private Long chenghu;    
    

	//中文姓
	private String zxing;    
    

	//中文名
	private String zming;    
    

	//英文姓
	private String yxing;    
    

	//英文名
	private String yming;    
    

	//身份证号码
	private String number;    
    

	//护照号码
	private String huzhao;    
    

	//军官证
	private String jun;    
    

	//回乡证
	private String hui;    
    

	//其他证件号码
	private String qita;    
    

	//国籍
	private Long guoji;    
    

	//出生日期
	private String chusheng;    
    

	//联络语言
	private Long yuyan;    
    

	//密码
	private String password;    
    

	//提示问题
	private String wenti;    
    

	//问题答案
	private String daan;    
    

	//邮箱
	private String postbox;    
    

	//邮寄类型
	private Long youtype;    
    

	//邮寄到国家
	private String youjiguo;    
    

	//邮寄到省
	private String youjisheng;    
    

	//邮政编码
	private String youbian;    
    

	//市/县/自治州
	private String shi;    
    

	//邮寄地址
	private String address;    
    

	//联系电话
	private String dianhua;    
    

	//传真
	private String fax;    
    

	//账单邮寄类型
	private Long duizhangtype;    
    

	//联系手机
	private String mobile;    
    

	//单位名称
	private String copname;    
    

	//阁下级别
	private Long jibie;    
    

	//行业性质
	private Long xingzhi;    
    

	//创建时间
	private Timestamp createtime;    
    

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
	 * get性别
	 */
    public Long getSex(){
         return sex;
    }

	/**
	 * set性别
	 */
    public void setSex(Long sex){
         this.sex=sex;
    }

	/**
	 * get称谓
	 */
    public Long getChenghu(){
         return chenghu;
    }

	/**
	 * set称谓
	 */
    public void setChenghu(Long chenghu){
         this.chenghu=chenghu;
    }

	/**
	 * get中文姓
	 */
    public String getZxing(){
         return zxing;
    }

	/**
	 * set中文姓
	 */
    public void setZxing(String zxing){
         this.zxing=zxing;
    }

	/**
	 * get中文名
	 */
    public String getZming(){
         return zming;
    }

	/**
	 * set中文名
	 */
    public void setZming(String zming){
         this.zming=zming;
    }

	/**
	 * get英文姓
	 */
    public String getYxing(){
         return yxing;
    }

	/**
	 * set英文姓
	 */
    public void setYxing(String yxing){
         this.yxing=yxing;
    }

	/**
	 * get英文名
	 */
    public String getYming(){
         return yming;
    }

	/**
	 * set英文名
	 */
    public void setYming(String yming){
         this.yming=yming;
    }

	/**
	 * get身份证号码
	 */
    public String getNumber(){
         return number;
    }

	/**
	 * set身份证号码
	 */
    public void setNumber(String number){
         this.number=number;
    }

	/**
	 * get护照号码
	 */
    public String getHuzhao(){
         return huzhao;
    }

	/**
	 * set护照号码
	 */
    public void setHuzhao(String huzhao){
         this.huzhao=huzhao;
    }

	/**
	 * get军官证
	 */
    public String getJun(){
         return jun;
    }

	/**
	 * set军官证
	 */
    public void setJun(String jun){
         this.jun=jun;
    }

	/**
	 * get回乡证
	 */
    public String getHui(){
         return hui;
    }

	/**
	 * set回乡证
	 */
    public void setHui(String hui){
         this.hui=hui;
    }

	/**
	 * get其他证件号码
	 */
    public String getQita(){
         return qita;
    }

	/**
	 * set其他证件号码
	 */
    public void setQita(String qita){
         this.qita=qita;
    }

	/**
	 * get国籍
	 */
    public Long getGuoji(){
         return guoji;
    }

	/**
	 * set国籍
	 */
    public void setGuoji(Long guoji){
         this.guoji=guoji;
    }

	/**
	 * get出生日期
	 */
    public String getChusheng(){
         return chusheng;
    }

	/**
	 * set出生日期
	 */
    public void setChusheng(String chusheng){
         this.chusheng=chusheng;
    }

	/**
	 * get联络语言
	 */
    public Long getYuyan(){
         return yuyan;
    }

	/**
	 * set联络语言
	 */
    public void setYuyan(Long yuyan){
         this.yuyan=yuyan;
    }

	/**
	 * get密码
	 */
    public String getPassword(){
         return password;
    }

	/**
	 * set密码
	 */
    public void setPassword(String password){
         this.password=password;
    }

	/**
	 * get提示问题
	 */
    public String getWenti(){
         return wenti;
    }

	/**
	 * set提示问题
	 */
    public void setWenti(String wenti){
         this.wenti=wenti;
    }

	/**
	 * get问题答案
	 */
    public String getDaan(){
         return daan;
    }

	/**
	 * set问题答案
	 */
    public void setDaan(String daan){
         this.daan=daan;
    }

	/**
	 * get邮箱
	 */
    public String getPostbox(){
         return postbox;
    }

	/**
	 * set邮箱
	 */
    public void setPostbox(String postbox){
         this.postbox=postbox;
    }

	/**
	 * get邮寄类型
	 */
    public Long getYoutype(){
         return youtype;
    }

	/**
	 * set邮寄类型
	 */
    public void setYoutype(Long youtype){
         this.youtype=youtype;
    }

	/**
	 * get邮寄到国家
	 */
    public String getYoujiguo(){
         return youjiguo;
    }

	/**
	 * set邮寄到国家
	 */
    public void setYoujiguo(String youjiguo){
         this.youjiguo=youjiguo;
    }

	/**
	 * get邮寄到省
	 */
    public String getYoujisheng(){
         return youjisheng;
    }

	/**
	 * set邮寄到省
	 */
    public void setYoujisheng(String youjisheng){
         this.youjisheng=youjisheng;
    }

	/**
	 * get邮政编码
	 */
    public String getYoubian(){
         return youbian;
    }

	/**
	 * set邮政编码
	 */
    public void setYoubian(String youbian){
         this.youbian=youbian;
    }

	/**
	 * get市/县/自治州
	 */
    public String getShi(){
         return shi;
    }

	/**
	 * set市/县/自治州
	 */
    public void setShi(String shi){
         this.shi=shi;
    }

	/**
	 * get邮寄地址
	 */
    public String getAddress(){
         return address;
    }

	/**
	 * set邮寄地址
	 */
    public void setAddress(String address){
         this.address=address;
    }

	/**
	 * get联系电话
	 */
    public String getDianhua(){
         return dianhua;
    }

	/**
	 * set联系电话
	 */
    public void setDianhua(String dianhua){
         this.dianhua=dianhua;
    }

	/**
	 * get传真
	 */
    public String getFax(){
         return fax;
    }

	/**
	 * set传真
	 */
    public void setFax(String fax){
         this.fax=fax;
    }

	/**
	 * get账单邮寄类型
	 */
    public Long getDuizhangtype(){
         return duizhangtype;
    }

	/**
	 * set账单邮寄类型
	 */
    public void setDuizhangtype(Long duizhangtype){
         this.duizhangtype=duizhangtype;
    }

	/**
	 * get联系手机
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set联系手机
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
    }

	/**
	 * get单位名称
	 */
    public String getCopname(){
         return copname;
    }

	/**
	 * set单位名称
	 */
    public void setCopname(String copname){
         this.copname=copname;
    }

	/**
	 * get阁下级别
	 */
    public Long getJibie(){
         return jibie;
    }

	/**
	 * set阁下级别
	 */
    public void setJibie(Long jibie){
         this.jibie=jibie;
    }

	/**
	 * get行业性质
	 */
    public Long getXingzhi(){
         return xingzhi;
    }

	/**
	 * set行业性质
	 */
    public void setXingzhi(Long xingzhi){
         this.xingzhi=xingzhi;
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


	public String toString(){

	return "[" 
	 + id +"|"
	   
	 + sex +"|"
	   
	 + chenghu +"|"
	   
	 + zxing +"|"
	   
	 + zming +"|"
	   
	 + yxing +"|"
	   
	 + yming +"|"
	   
	 + number +"|"
	   
	 + huzhao +"|"
	   
	 + jun +"|"
	   
	 + hui +"|"
	   
	 + qita +"|"
	   
	 + guoji +"|"
	   
	 + chusheng +"|"
	   
	 + yuyan +"|"
	   
	 + password +"|"
	   
	 + wenti +"|"
	   
	 + daan +"|"
	   
	 + postbox +"|"
	   
	 + youtype +"|"
	   
	 + youjiguo +"|"
	   
	 + youjisheng +"|"
	   
	 + youbian +"|"
	   
	 + shi +"|"
	   
	 + address +"|"
	   
	 + dianhua +"|"
	   
	 + fax +"|"
	   
	 + duizhangtype +"|"
	   
	 + mobile +"|"
	   
	 + copname +"|"
	   
	 + jibie +"|"
	   
	 + xingzhi +"|"
	   
	 + createtime
	 + "]";
 } 

}
