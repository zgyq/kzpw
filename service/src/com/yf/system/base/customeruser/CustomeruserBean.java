/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customeruser;
import java.sql.Timestamp;

/**
 *会员
 */
public class CustomeruserBean implements java.io.Serializable{
	

	/**
	  *会员 表名
	  */
	public static final String TABLE  = "T_CUSTOMERUSER";

	
	/**
	  *用户ID 列名 
	  */
    public static final String COL_id  = "ID";
	
    //准备删除
//	/**
//	  *用户卡号 列名 
//	  */
//    public static final String COL_cardnumber  = "C_CARDNUMBER";
//	
//	/**
//	  *用户卡密码 列名 
//	  */
//    public static final String COL_cardpassword  = "C_CARDPASSWORD";
	
	/**
	  *登录名 列名 
	  */
    public static final String COL_loginname  = "C_LOGINNAME";
	
	/**
	  *登陆密码 列名 
	  */
    public static final String COL_logpassword  = "C_LOGPASSWORD";
	
	/**
	  *姓名 列名 
	  */
    public static final String COL_membername  = "C_MEMBERNAME";
	
	/**
	  *性别 列名 
	  */
    public static final String COL_membersex  = "C_MEMBERSEX";
	
	/**
	  *电子邮箱 列名 
	  */
    public static final String COL_memberemail  = "C_MEMBEREMAIL";
	
	/**
	  *手机号 列名 
	  */
    public static final String COL_mobile  = "C_MOBILE";
	
	/**
	  *状态 列名 
	  */
    public static final String COL_state  = "C_STATE";
	
	/**
	  *类型(1=运营商,2=供应商,3=分销商,4=大客户) 列名 
	  */
    public static final String COL_type  = "C_TYPE";
	
	/**
	  *是否是管理员 列名 
	  */
    public static final String COL_isadmin  = "C_ISADMIN";
	
	/**
	  *生日 列名 
	  */
    public static final String COL_birthday  = "C_BIRTHDAY";
	
	/**
	  *所在城市 列名 
	  */
    public static final String COL_localcity  = "C_LOCALCITY";
	
	/**
	  *传真 列名 
	  */
    public static final String COL_memberfax  = "C_MEMBERFAX";
	
//	/**
//	  *备忘录 列名 
//	  */
//    public static final String COL_memberdesc  = "C_MEMBERDESC";
	
	/**
	  *是否是网站会员 列名 1:是，2.:不是
	  */
    public static final String COL_isweb  = "C_ISWEB";
	
	/**
	  *移动电话号码 列名 
	  */
    public static final String COL_membermobile  = "C_MEMBERMOBILE";
	
	/**
	  *是否启用 列名 
	  */
    public static final String COL_isenable  = "C_ISENABLE";
	
	/**
	  *类型 列名 
	  */
    public static final String COL_membertype  = "C_MEMBERTYPE";
	
	/**
	  *所属加盟商ID 列名 
	  */
    public static final String COL_agentid  = "C_AGENTID";
	
	/**
	  *修改时间 列名 
	  */
    public static final String COL_modifytime  = "C_MODIFYTIME";
	
	/**
	  *修改者 列名 
	  */
    public static final String COL_modifyuser  = "C_MODIFYUSER";
	
	/**
	  *创建时间 列名 
	  */
    public static final String COL_createtime  = "C_CREATETIME";
	
	/**
	  *创建者 列名 
	  */
    public static final String COL_createuser  = "C_CREATEUSER";
	
	/**
	  *部门ID 列名 
	  */
    public static final String COL_deptid  = "C_DEPTID";
	
//	/**
   //待删除
//	  *是否领导 列名 
//	  */
//    public static final String COL_ismanager  = "C_ISMANAGER";

	/**
	  *证件类型 列名 
	  */
    public static final String COL_cardtype  = "C_CARDTYPE";
	
	/**
	  *证件号码 列名 
	  */
    public static final String COL_cardnunber  = "C_CARDNUNBER";
	
	/**
	  *工作电话 列名 
	  */
    public static final String COL_workphone  = "C_WORKPHONE";
	
	/**
	  *其他联系方式 列名 
	  */
    public static final String COL_linkother  = "C_LINKOTHER";
	
	/**
	  *备注 列名 
	  */
    public static final String COL_description  = "C_DESCRIPTION";

    /**
	  *客户英文名 列名 
	  */
   public static final String COL_enname  = "C_ENNAME";
	
	/**
	  *入境时间 列名 
	  */
   public static final String COL_entrytime  = "C_ENTRYTIME";
	
//	/**
//	  *居留证件种类 列名 
//	  */
//   public static final String COL_livingcardtype  = "C_LIVINGCARDTYPE";
//	
//	/**
//	  *居留证件号码 列名 
//	  */
//   public static final String COL_livingcardnum  = "C_LIVINGCARDNUM";
//	
//	/**
//	  *居留证件有效期 列名 现用于保存驾照领取时间
//	  */
//   public static final String COL_livingperiod  = "C_LIVINGPERIOD";
//	
//	/**
//	  *就业证号码 列名 
//	  */
   public static final String COL_worknumber  = "C_WORKNUMBER";
//	
//	/**
//	  *就业证有效期 列名 
//	  */
//   public static final String COL_workperiod  = "C_WORKPERIOD";
//	
	/**
	  *在华地址 列名 
	  */
   public static final String COL_chinaaddress  = "C_CHINAADDRESS";
   
   

	public static final String COL_nationality ="C_NATIONALITY";    
	
	
//	/**
//	 *返利 列名 
//	 */
	public static final String COL_profits  = "C_PROFITS";
//	
	/**
	 *邮政编码 列名 
	 */
	public static final String COL_postalcode  = "C_POSTALCODE";
//	
   
	//用户ID
	private long id;    
    

//	//用户卡号
//	private String cardnumber;    
//    
//
//	//用户卡密码
//	private String cardpassword;    
//    

	//登录名
	private String loginname;    
    

	//登陆密码
	private String logpassword;    
    

	//姓名
	private String membername;    
    

	//性别
	private String membersex;    
    

	//电???邮箱
	private String memberemail;    
    

	//手机号
	private String mobile;    
    

	//状态
	private Integer state;    
    

	//类型(1=运营商,2=供应商,3=分销商)
	private Integer type;    
    

	//是否是管理员
	private Integer isadmin;    
    

	//生日
	private Timestamp birthday;    
    

	//所在城市
	//private String localcity;    
    

	//传真
	private String memberfax;    
    

	//备忘录
	//private String memberdesc;    
    

	//是否是网站会员
	private Integer isweb;    
    

	//移动电话号码
	private String membermobile;    
    

	//是否启用
	private Integer isenable;    
    

	//类型
	private Integer membertype;  //1会员.2员工  
    

	//所属加盟商ID
	private Long agentid;    
    

	//修改时间
	private Timestamp modifytime;    
    

	//修改者
	private String modifyuser;    
    

	//创建时间
	private Timestamp createtime;    
    

	//创建者
	private String createuser;    
    

	//部门ID
	private Long deptid;    
    

	//是否领导
	//private Long ismanager;   
	
	
	//国籍
	//private String nationality;    
	
	
	
 
    

	//证件类型
	private Long cardtype;    
    

	//证件号码
	private String cardnunber;    
    

	//工作电话
	private String workphone;    
    

	//其他联系方式
	//private String linkother;    
    

	//备注
	private String description;
	
	//客户英文名
	private String enname;    
    

	//入境时间
//	private String entrytime;    
//    
//
//	//居留证件种类
//	private String livingcardtype;    
//    
//
//	//居留证件号码
//	private String livingcardnum;    
//    
//
//	//居留证件有效期    下载呢用于保存驾照领取时间
//	private String livingperiod;    
//    
//
//	//就业证号码--现在改成注册就送的优惠劵
	private String worknumber;    
//    
//
//	//就业证有效期
//	private String workperiod;    
//    
//
//
  private String chinaaddress;   
	
	//总积分
	private Integer totalscore;
    
	//现金账户
	private Float profits; 
	

	private String postalcode;   
	

	/**
	 * get用户ID
	 */
    public long getId(){
         return id;
    }

	/**
	 * set用户ID
	 */
    public void setId(long id){
         this.id=id;
    }

//	/**
//	 * get用户卡号
//	 */
//    public String getCardnumber(){
//         return cardnumber;
//    }
//
//	/**
//	 * set用户卡号
//	 */
//    public void setCardnumber(String cardnumber){
//         this.cardnumber=cardnumber;
//    }

//	/**
//	 * get用户卡密码
//	 */
//    public String getCardpassword(){
//         return cardpassword;
//    }
//
//	/**
//	 * set用户卡密码
//	 */
//    public void setCardpassword(String cardpassword){
//         this.cardpassword=cardpassword;
//    }

	/**
	 * get登录名
	 */
    public String getLoginname(){
         return loginname;
    }

	/**
	 * set登录名
	 */
    public void setLoginname(String loginname){
         this.loginname=loginname;
    }

	/**
	 * get登陆密码
	 */
    public String getLogpassword(){
         return logpassword;
    }

	/**
	 * set登陆密码
	 */
    public void setLogpassword(String logpassword){
         this.logpassword=logpassword;
    }

	/**
	 * get姓名
	 */
    public String getMembername(){
         return membername;
    }

	/**
	 * set姓名
	 */
    public void setMembername(String membername){
         this.membername=membername;
    }

	/**
	 * get性别
	 */
    public String getMembersex(){
         return membersex;
    }

	/**
	 * set性别
	 */
    public void setMembersex(String membersex){
         this.membersex=membersex;
    }

	/**
	 * get电???邮箱
	 */
    public String getMemberemail(){
         return memberemail;
    }

	/**
	 * set电???邮箱
	 */
    public void setMemberemail(String memberemail){
         this.memberemail=memberemail;
    }

	/**
	 * get手机号
	 */
    public String getMobile(){
         return mobile;
    }

	/**
	 * set手机号
	 */
    public void setMobile(String mobile){
         this.mobile=mobile;
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
	 * get类型(1=运营商,2=供应商,3=分销商)
	 */
    public Integer getType(){
         return type;
    }

	/**
	 * set类型(1=运营商,2=供应商,3=分销商)
	 */
    public void setType(Integer type){
         this.type=type;
    }

	/**
	 * get是否是管理员
	 */
    public Integer getIsadmin(){
         return isadmin;
    }

	/**
	 * set是否是管理员
	 */
    public void setIsadmin(Integer isadmin){
         this.isadmin=isadmin;
    }

	/**
	 * get生日
	 */
    public Timestamp getBirthday(){
         return birthday;
    }

	/**
	 * set生日
	 */
    public void setBirthday(Timestamp birthday){
         this.birthday=birthday;
    }

//	/**
//	 * get所在城市
//	 */
//    public String getLocalcity(){
//         return localcity;
//    }
//
//	/**
//	 * set所在城市
//	 */
//    public void setLocalcity(String localcity){
//         this.localcity=localcity;
//    }

	/**
	 * get传真
	 */
    public String getMemberfax(){
         return memberfax;
    }

	/**
	 * set传真
	 */
    public void setMemberfax(String memberfax){
         this.memberfax=memberfax;
    }

//	/**
//	 * get备忘录
//	 */
//    public String getMemberdesc(){
//         return memberdesc;
//    }

//	/**
//	 * set备忘录
//	 */
//    public void setMemberdesc(String memberdesc){
//         this.memberdesc=memberdesc;
//    }

	/**
	 * get是否是网站会员
	 */
    public Integer getIsweb(){
         return isweb;
    }

	/**
	 * set是否是网站会员
	 */
    public void setIsweb(Integer isweb){
         this.isweb=isweb;
    }

	/**
	 * get移动电话号码
	 */
    public String getMembermobile(){
         return membermobile;
    }

	/**
	 * set移动电话号码
	 */
    public void setMembermobile(String membermobile){
         this.membermobile=membermobile;
    }

	/**
	 * get是否启用
	 */
    public Integer getIsenable(){
         return isenable;
    }

	/**
	 * set是否启用
	 */
    public void setIsenable(Integer isenable){
         this.isenable=isenable;
    }

	/**
	 * get类型
	 */
    public Integer getMembertype(){
         return membertype;
    }

	/**
	 * set类型
	 */
    public void setMembertype(Integer membertype){
         this.membertype=membertype;
    }

	/**
	 * get所属加盟商ID
	 */
    public Long getAgentid(){
         return agentid;
    }

	/**
	 * set所属加盟商ID
	 */
    public void setAgentid(Long agentid){
         this.agentid=agentid;
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
	 * get部门ID
	 */
    public Long getDeptid(){
         return deptid;
    }

	/**
	 * set部门ID
	 */
    public void setDeptid(Long deptid){
         this.deptid=deptid;
    }

//	/**
//	 * get是否领导
//	 */
//    public Long getIsmanager(){
//         return ismanager;
//    }
//
//	/**
//	 * set是否领导
//	 */
//    public void setIsmanager(Long ismanager){
//         this.ismanager=ismanager;
//    }
    /**
	 * get证件类型
	 */
    public Long getCardtype(){
         return cardtype;
    }

	/**
	 * set证件类型
	 */
    public void setCardtype(Long cardtype){
         this.cardtype=cardtype;
    }

	/**
	 * get证件号码
	 */
    public String getCardnunber(){
         return cardnunber;
    }

	/**
	 * set证件号码
	 */
    public void setCardnunber(String cardnunber){
         this.cardnunber=cardnunber;
    }

	/**
	 * get工作电话
	 */
    public String getWorkphone(){
         return workphone;
    }

	/**
	 * set工作电话
	 */
    public void setWorkphone(String workphone){
         this.workphone=workphone;
    }

//	/**
//	 * get其他联系方式
//	 */
//    public String getLinkother(){
//         return linkother;
//    }
//
//	/**
//	 * set其他联系方式
//	 */
//    public void setLinkother(String linkother){
//         this.linkother=linkother;
//    }

	/**
	 * get备注
	 */
    public String getDescription(){
         return description;
    }

	/**
	 * set备注
	 */
    public void setDescription(String description){
         this.description=description;
    }

    
    /**
	 * get客户英文名
	 */
    public String getEnname(){
         return enname;
    }

	/**
	 * set客户英文名
	 */
    public void setEnname(String enname){
         this.enname=enname;
    }

//	/**
//	 * get入境时间
//	 */
//    public String getEntrytime(){
//         return entrytime;
//    }
//
//	/**
//	 * set入境时间
//	 */
//    public void setEntrytime(String entrytime){
//         this.entrytime=entrytime;
//    }
//
//	/**
//	 * get居留证件种类
//	 */
//    public String getLivingcardtype(){
//         return livingcardtype;
//    }
//
//	/**
//	 * set居留证件种类
//	 */
//    public void setLivingcardtype(String livingcardtype){
//         this.livingcardtype=livingcardtype;
//    }
//
//	/**
//	 * get居留证件号码
//	 */
//    public String getLivingcardnum(){
//         return livingcardnum;
//    }
//
//	/**
//	 * set居留证件号码
//	 */
//    public void setLivingcardnum(String livingcardnum){
//         this.livingcardnum=livingcardnum;
//    }
//
//	/**
//	 * get居留证件有效期
//	 */
//    public String getLivingperiod(){
//         return livingperiod
//    }
//
//	/**
//	 * set居留证件有效期
//	 */
//    public void setLivingperiod(String livingperiod){
//         this.livingperiod=livingperiod;
//    }
//
//	/**
//	 * get就业证号码
//	 */
    public String getWorknumber(){
         return worknumber;
    }
//
//	/**
//	 * set就业证号码
//	 */
    public void setWorknumber(String worknumber){
         this.worknumber=worknumber;
   }
//
//	/**
//	 * get就业证有效期
//	 */
//    public String getWorkperiod(){
//         return workperiod;
//    }
//
//	/**
//	 * set就业证有效期
//	 */
//    public void setWorkperiod(String workperiod){
//         this.workperiod=workperiod;
//    }
//
	/**
	 * get在华地址
	 */
    public String getChinaaddress(){
         return chinaaddress;
    }

	/**
	 * set在华地址
	 */
    public void setChinaaddress(String chinaaddress){
         this.chinaaddress=chinaaddress;
    }

	public String toString(){

	return "[" 
	 + id +"|"
	   
//	 + cardnumber +"|"
//	   
//	 + cardpassword +"|"
	   
	 + loginname +"|"
	   
	 + logpassword +"|"
	   
	 + membername +"|"
	   
	 + membersex +"|"
	   
	 + memberemail +"|"
	   
	 + mobile +"|"
	   
	 + state +"|"
	   
	 + type +"|"
	   
	 + isadmin +"|"
	   
	 + birthday +"|"
	   
//	 + localcity +"|"
//	   
//	 + memberfax +"|"
//	   
//	 + memberdesc +"|"
	   
	 + isweb +"|"
	   
	 + membermobile +"|"
	   
	 + isenable +"|"
	   
	 + membertype +"|"
	   
	 + agentid +"|"
	   
	 + modifytime +"|"
	   
	 + modifyuser +"|"
	   
	 + createtime +"|"
	   
	 + createuser +"|"
	   
	 + deptid +"|"
	   
//	 + ismanager+"|"
	   
	 + cardtype +"|"
	   
	 + cardnunber +"|"
	   
	 + workphone +"|"
	   
//	 + linkother +"|"
	   
	 + description+"|"
	   
	 + enname +"|"
	   
//	 + entrytime +"|"
//	   
//	 + livingcardtype +"|"
//	   
//	 + livingcardnum +"|"
//	   
//	 + livingperiod +"|"
//	   
	 + worknumber +"|"
//	   
//	 + workperiod +"|"
//	 
	 + profits +"|"
//	 
//	 + postalcode +"|"
//	 
//	 
//	   
//	 + chinaaddress
	 + "]";
 }

//	public String getNationality() {
//		return nationality;
//	}
//
//	public void setNationality(String nationality) {
//		this.nationality = nationality;
//	}

	public Integer getTotalscore() {
		return totalscore;
	}

	public void setTotalscore(Integer totalscore) {
		this.totalscore = totalscore;
	}

	public Float getProfits() {
		return profits;
	}

	public void setProfits(Float profits) {
		this.profits = profits;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	} 

}
