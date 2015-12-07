package com.yf.system.back.action;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Segment;

import com.yf.system.back.server.Server;
import com.yf.system.back.services.impl.CustomeragentServiceImpl;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.insurcomputer.Insurcomputer;
import com.yf.system.base.insurorder.Insurorder;
import com.yf.system.base.insuruser.Insuruser;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.Insurances;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;



public class InsuranceAction extends B2b2cbackAction{
    private String membername[];//保存被保人姓名
    private String membersex[];//保存性别
    private Long cardtype[];//保存证件
    private String cardnunber[];//保存证件号
    private String mobile[];//保存电话号码
    private String birthday[];//保存出生日期
    private String memberemail[];//保存电子邮箱
    private String [] flyno;//保存被保人的航班号
    private String [] city;//保存城市信息
    private String begintime;//保存起保时间
    private String begintime1;
    private String flytime;//保存起飞时间
    private Insuruser insuruser=new Insuruser();//保存被保人信息
    //调用保险单创建的接口
	private List<Insurances> inlist;
	private Insurorder insurorder=new Insurorder();//用来保存订单的详细信息
	private List orderlist;
	private Insurances in;
	private List<Insuruser> inuserlist=new ArrayList<Insuruser>();//用来保存被保人信息
	private  Long oid;//保存订单编号
	private  List passengerlist;//保存乘机人列表信息
	private String flyorderid;//保存飞机订单编号
	private String message;//保存订单生成的信息
	private String inname;//保存被保人姓名
	private List userlist;//保存被保人信息列表
	private List<Insurorder> olist=new ArrayList<Insurorder>();
	private Long userid;//保存用户id
	
	private Orderinfo orderinfo=new Orderinfo();
	private Segmentinfo segmentinfo=new Segmentinfo();
	private List<Passenger>listpass=new ArrayList<Passenger>();
	
	private long passid;
	
	//保存订单id
	public long orderId;// 订单Id
	public long getOrderId() {
		return orderId;
	}
	
	public String getInname() {
		return inname;
	}

	public void setInname(String inname) {
		this.inname = inname;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getFlytime() {
		return flytime;
	}
	public void setFlytime(String flytime) {
		this.flytime = flytime;
	}
	public String getBegintime1() {
		return begintime1;
	}
	public void setBegintime1(String begintime1) {
		this.begintime1 = begintime1;
	}
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public List<Insurances> getInlist() {
		return inlist;
	}
	public void setInlist(List<Insurances> inlist) {
		this.inlist = inlist;
	}
	
	public List<Insuruser> getInuserlist() {
		return inuserlist;
	}
	public void setInuserlist(List<Insuruser> inuserlist) {
		this.inuserlist = inuserlist;
	}
	public Insurances getIn() {
		return in;
	}
	public void setIn(Insurances in) {
		this.in = in;
	}
	public Insurorder getInsurorder() {
		return insurorder;
	}
	public void setInsurorder(Insurorder insurorder) {
		this.insurorder = insurorder;
	}
	public List getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List orderlist) {
		this.orderlist = orderlist;
	}
	public List<Insurances> getinlist() {
		return inlist;
	}
	public void setinlist(List<Insurances> inlist) {
		this.inlist = inlist;
	}
	public void setInsuruser(Insuruser insuruser) {
		this.insuruser = insuruser;
	}
    private Insurcomputer insurcomputer;
	public Insurcomputer getInsurcomputer() {
		return insurcomputer;
	}
	public void setInsurcomputer(Insurcomputer insurcomputer) {
		this.insurcomputer = insurcomputer;
	}
	public String[] getFlyno() {
		return flyno;
	}
	public void setFlyno(String[] flyno) {
		this.flyno = flyno;
	}
	
	public String[] getCity() {
		return city;
	}
	public void setCity(String[] city) {
		this.city = city;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public List getPassengerlist() {
		return passengerlist;
	}
	public void setPassengerlist(List passengerlist) {
		this.passengerlist = passengerlist;
	}
	public String[] getMembername() {
		return membername;
	}
	public void setMembername(String[] membername) {
		this.membername = membername;
	}
	public String[] getMembersex() {
		return membersex;
	}
	public void setMembersex(String[] membersex) {
		this.membersex = membersex;
	}
	public Long[] getCardtype() {
		return cardtype;
	}
	public void setCardtype(Long[] cardtype) {
		this.cardtype = cardtype;
	}
	public String[] getCardnunber() {
		return cardnunber;
	}
	public void setCardnunber(String[] cardnunber) {
		this.cardnunber = cardnunber;
	}
	public String[] getMobile() {
		return mobile;
	}
	public void setMobile(String[] mobile) {
		this.mobile = mobile;
	}
	public String[] getBirthday() {
		return birthday;
	}
	public void setBirthday(String[] birthday) {
		this.birthday = birthday;
	}
	public String[] getMemberemail() {
		return memberemail;
	}
	public void setMemberemail(String[] memberemail) {
		this.memberemail = memberemail;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getBegintime() {
		return begintime;
	}
	public Insuruser getInsuruser() {
		return insuruser;
	}
	
	/**
	 * 跳转到保险服务页面
	 */
	public String toservice(){
		
	System.out.println(orderId+","+passid);	
		
	System.out.println("????????");	
	
		
		return "toservice";
	}

	
	/**
	 * 跳转到添加乘机人页面
	 */
	public String addinsur(){
		return "addinsur";
	}
	/**
	 * 创建电子保险单
	 */
	public String createOrderAply(){
		return "createOrderAply";
	}
	public static String getNumString(long num,int len){
		StringBuffer code =  new StringBuffer(len);
		for(int i=0;i<len ;i++){
			code.append('0');
		}
		String snum = (""+num);
		int slen = snum.length();
		if(slen>len){
			snum = snum.substring(0,len);
		}
		code.replace(len-snum.length(),len,snum);
		
		return code.toString();
	}
	/*
	 * 当前年月日
	 * @return
	 */
	private static String getDateString(){
		try {
			return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
			
		} catch (Exception e) {
			return "000000";
		}
		
	}
	public String OrderApply(){
		List list=new ArrayList(); 
		int mark=0;
		List<Insurances> listinsurance=new ArrayList<Insurances>();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String [] jyno=null;
		String [] flighttime=flytime.split(",");
        for(int i=0;i<membername.length;i++){
        	Insuruser users=new Insuruser();
			users.setName(membername[i]);
			users.setSex(Long.parseLong((membersex[i])));
			users.setCodetype((cardtype[i]));
			users.setCode((cardnunber[i]));
			users.setMobile(mobile[i]);
			users.setCity(city[i]);
			users.setFlyno(flyno[i]);
			try {
				users.setFlytime(new Timestamp(format.parse(flighttime[i]).getTime()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Timestamp ts=null;
			try {
				ts = new Timestamp((format.parse(birthday[i]).getTime()));
				users.setBegintime(new Timestamp(format.parse(begintime).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			users.setBirthday(ts);
			users.setEmail((memberemail[i]));
			list.add(users);
		}		
		try {
			//随即产生交易流水号
			StringBuilder number=new StringBuilder("");
			for(int i=0;i<list.size();i++){
				long ran = (int) (Math.random() * 99999999 + 1);
				number.append(getDateString()+(getNumString(ran,7))+"I,");
			}
			jyno=number.toString().split(",");
		    listinsurance=Server.getInstance().getAtomService().newOrderAplylist(jyno, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取对象中的值
		if(listinsurance!=null&&listinsurance.size()>0){
		    //循环获得返回的对象
			for(int i=0;i<listinsurance.size();i++){
				this.setIn(listinsurance.get(i));
				Insuruser iu=null;
				if(in.getFlag()==1){
					//代表创建保险单成功，将录入的信息保存起来
					Insuruser insu=(Insuruser)list.get(i);
					insu.setPolicyno(in.getApplicationNo());//保单号
					//循环将信息保存到数据库
					try {
						iu=Server.getInstance().getAirService().createInsuruser(insu);
						this.inuserlist.add(iu);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("添加被保人失败！");
					}
					//同时添加订单
					try {
						//同时将保险单添加到订单表中
						Insurorder insurorder=new Insurorder();
						insurorder.setLiushuino(in.getTransrno());
						insurorder.setOrderno(in.getApplicationNo());
						insurorder.setComputerid(Long.parseLong("1"));
						//insurorder.setUserid(loginuser.getId());
						insurorder.setStatus(Long.parseLong("1"));//订单成功
					//	insurorder.setInsuruserid(iu.getId());//保存被保人的id
						insurorder.setTime(new Timestamp(new Date().getTime()));//获得当前时间
						//添加保险数量
						insurorder.setInsurantcount(Long.parseLong("1"));
						insurorder.setInsurmoney(20.0);
						double totleprice=20.0;
						//保存总价钱
						insurorder.setTotalmoney(totleprice);
						insurorder.setBegintime(new Timestamp(format.parse(begintime).getTime()));
						Timestamp da=new Timestamp(format.parse(begintime).getTime());
						da.setDate(da.getDate()+10);
						insurorder.setEndtime(da);
						try {
							this.setInsurorder(Server.getInstance().getAirService().createInsurorder(insurorder));
							this.olist.add(this.insurorder);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mark=1;
				}else{
				//订单创建失败将信息保存起			
				//代表创建保险单成功，将录入的信息保存起来
				Insuruser ius=null;		     
				Insuruser insur=(Insuruser)
				list.get(i);				
				//如果保险预订成功将被保人添加到数据库				
				 try {			
					ius=Server.getInstance().getAirService().createInsuruser(insur);		
					this.inuserlist.add(ius);				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block			
					e1.printStackTrace();			
				}		
				 try {
				//同时将保险单添加到订单表中		
				Insurorder insurorder=new Insurorder();		
				insurorder.setOrderno(in.getApplicationNo());		
				insurorder.setLiushuino(in.getTransrno());			
				insurorder.setComputerid(Long.parseLong("1"));			
				insurorder.setStatus(Long.parseLong("4"));//4代表创建失败		
				//insurorder.setInsuruserid(ius.getId());//保存被保人的id		
				insurorder.setTime(new Timestamp(new Date().getTime()));//获得当前时间			
				//insurorder.setOrderno(in.getApplicationNo());
				//添加保险数量			
				insurorder.setInsurantcount(Long.parseLong("1"));				
				insurorder.setInsurmoney(20.0);
				double totleprice=20.0;
				//保存总价钱		
				insurorder.setTotalmoney(totleprice);			
				insurorder.setBegintime(new Timestamp(format.parse(begintime).getTime()));		
				Timestamp da=new Timestamp(format.parse(begintime).getTime());		
				da.setDate(da.getDate()+10);							
				insurorder.setEndtime(da);
				try {							
				this.setInsurorder(Server.getInstance().getAirService().createInsurorder(insurorder));
				this.olist.add(this.insurorder);
				} catch (SQLException e) {			
				// TODO Auto-generated catch block
					e.printStackTrace();
					}				
				} catch (ParseException e) {
				// TODO Auto-generated catch block		
				e.printStackTrace();		
				}
				mark=0;
			  }    		
			}	
			if(mark==1){
			this.setMessage("恭喜您!保险单预订成功!");
			return "OrderApply";
			}else{
				 this.setMessage("对不起!保险单预订失败!");
			  	 return "OrderApply";
			}
	}else{
		 //将录入的信息添加被保人表中
  	  for(int i=0;i<list.size();i++){
  		  Insuruser ius=(Insuruser)list.get(i);
  		  ius.setFlyno(flyno[i]);
  		  try {
				ius.setBegintime(new Timestamp(format.parse(begintime).getTime()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  		 try {
				Insuruser iu=Server.getInstance().getAirService().createInsuruser(ius);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	  }
  	  this.setInuserlist(list);
  	  this.setMessage("对不起!保险单预订失败!");
  	  return "OrderApply";
	}
}
	
	/**
	 * 查看保险单返回的是pdf格式的文档
	 */
	public String searchInsurance(){
		//根据订单编号得到订单对象
		this.setInsurorder(Server.getInstance().getAirService().findInsurorder(oid));
		//调用保险单接口
		try {
			DataHandler returnpdf=Server.getInstance().getAtomService().PolicyReprint(this.insurorder);	
			InputStream is=null;
             if(returnpdf!=null&&!returnpdf.equals("")){
            	is= returnpdf.getInputStream();
             }				 
			 byte[]dataHandler =new byte[is.available()];//将服务器端返回的dh转为byte数组
			 //byte[] dataHandler = (byte[]) returnpdf;//
			 HttpServletResponse response = ServletActionContext.getResponse();
			  try {
			   response.reset();
			   response.setContentType("application/pdf");   
			   response.setHeader("Content-Disposition","attachment;filename=insurance2011-12-20.pdf"); 
			   response.getOutputStream().write(dataHandler);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//	/**
//	 * 申请电子保险
//	 */
//	public String OrderApply(){
//		//获得登录人的详细信息
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		//获得登录者的信息
//		Customeruser loginuser=(Customeruser)session.getAttribute("loginuser");
//		List list=new ArrayList(); 
//		List<Insurances> listinsurance=new ArrayList<Insurances>();
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        for(int i=0;i<membername.length;i++){
//        	Insuruser users=new Insuruser();
//			users.setName(membername[i]);
//			users.setSex(Long.parseLong((membersex[i])));
//			users.setCodetype((cardtype[i]));
//			users.setCode((cardnunber[i]));
//			users.setMobile(mobile[i]);
//			users.setCity(city[i]);
//			Timestamp ts=null;
//			try {
//				ts = new Timestamp((format.parse(birthday[i]).getTime()));
//				users.setBegintime(new Timestamp(format.parse(begintime).getTime()));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			users.setBirthday(ts);
//			users.setEmail((memberemail[i]));
//			list.add(users);
//		}		
//		try {
//			//随即产生交易流水号
//			long ran = (int) (Math.random() * 99999999 + 1);
//			String number=getDateString()+(getNumString(ran,7))+"I";
//			String []times=begintime.split(",");
//		    listinsurance=Server.getInstance().getAtomService().orderAply(number, loginuser, list, times[0],flyno);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//获取对象中的值
//		if(listinsurance!=null&&listinsurance.size()>0){
//		    //获得返回的对象
//		    this.setIn(listinsurance.get(0));
//		    if(in.getFlag()==1){
//			//代表创建保险单成功，将录入的信息保存起来
//		    	Insuruser iu=null;
//			for(int i=0;i<list.size();i++){
//				Insuruser insu=(Insuruser)list.get(i);
//				insu.setFlyno(flyno[i]);
//				try {
//					insu.setCity(city[i]);//保存城市信息
//					insu.setFlytime(new Timestamp(format.parse(flytime).getTime()));
//					insu.setBegintime(new Timestamp(format.parse(begintime).getTime()));
//					//保险单号
//					insu.setPolicyno(this.in.getApplicationNo());
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try {
//					//如果保险预订成功将被保人添加到数据库
//					iu=Server.getInstance().getAirService().createInsuruser(insu);
//					this.inuserlist.add(iu);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					System.out.println("添加被保人信息错误");
//				}
//				
//			} 
//			
//			try {
//				//同时将保险单添加到订单表中
//				Insurorder insurorder=new Insurorder();
//				insurorder.setLiushuino(in.getTransrno());
//				insurorder.setOrderno(in.getTransrno());
//				insurorder.setComputerid(Long.parseLong("1"));
//				insurorder.setUserid(loginuser.getId());
//				insurorder.setStatus(Long.parseLong("1"));
//				//insurorder.setOrderno(in.getApplicationNo());
//				insurorder.setInsuruserid(iu.getId());//保存被保人的id
//				insurorder.setTime(new Timestamp(new Date().getTime()));//获得当前时间
//				//添加保险数量
//				int cou=list.size();
//				String count=String.valueOf(cou);
//				insurorder.setInsurantcount(Long.parseLong(count));
//				insurorder.setInsurmoney(20.0);
//				double totleprice=cou*20.0;
//				//保存总价钱
//				insurorder.setTotalmoney(totleprice);
//				insurorder.setBegintime(new Timestamp(format.parse(begintime).getTime()));
//				Timestamp da=new Timestamp(format.parse(begintime).getTime());
//				da.setDate(da.getDate()+10);
//				insurorder.setEndtime(da);
//				try {
//					this.setInsurorder(Server.getInstance().getAirService().createInsurorder(insurorder));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			this.setMessage("恭喜您！保险单预订成功！");
//			return "OrderApply";
//		}else{
//	    //订单创建失败将信息保存起来
//	    //代表创建保险单成功，将录入的信息保存起来
//			Insuruser iu=null;
//			for(int i=0;i<list.size();i++){
//				Insuruser insu=(Insuruser)list.get(i);
//				insu.setFlyno(flyno[i]);
//				
//				try {
//					insu.setCity(city[i]);//保存城市信息
//					insu.setFlytime(new Timestamp(format.parse(flytime).getTime()));
//					insu.setBegintime(new Timestamp(format.parse(begintime).getTime()));
//					//保险单号
//					//insu.setPolicyno(this.in.getApplicationNo());
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try {
//					//如果保险预订成功将被保人添加到数据库
//					 iu=Server.getInstance().getAirService().createInsuruser(insu);
//					this.inuserlist.add(iu);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					System.out.println("添加被保人信息错误");
//				}
//				
//			} 
//			try {
//				//同时将保险单添加到订单表中
//				Insurorder insurorder=new Insurorder();
//				insurorder.setOrderno(in.getTransrno());
//				insurorder.setLiushuino(in.getTransrno());
//				insurorder.setComputerid(Long.parseLong("1"));
//				insurorder.setUserid(loginuser.getId());
//				insurorder.setStatus(Long.parseLong("4"));//4代表创建失败
//				insurorder.setInsuruserid(iu.getId());//保存被保人的id
//				insurorder.setTime(new Timestamp(new Date().getTime()));//获得当前时间
//				//insurorder.setOrderno(in.getApplicationNo());
//				//添加保险数量
//				int cou=list.size();
//				String count=String.valueOf(cou);
//				insurorder.setInsurantcount(Long.parseLong(count));
//				insurorder.setInsurmoney(20.0);
//				double totleprice=cou*20.0;
//				//保存总价钱
//				insurorder.setTotalmoney(totleprice);
//				insurorder.setBegintime(new Timestamp(format.parse(begintime).getTime()));
//				Timestamp da=new Timestamp(format.parse(begintime).getTime());
//				da.setDate(da.getDate()+10);
//				insurorder.setEndtime(da);
//				try {
//					this.setInsurorder(Server.getInstance().getAirService().createInsurorder(insurorder));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    this.setMessage("对不起!保险单预订失败!");
//		return "OrderApply";
//	  }
//      }else{
//    	  //将录入的信息添加被保人表中
//    	  for(int i=0;i<list.size();i++){
//    		  Insuruser ius=(Insuruser)list.get(i);
//    		  ius.setFlyno(flyno[i]);
//    		  try {
//				ius.setBegintime(new Timestamp(format.parse(begintime).getTime()));
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//    		 try {
//				Insuruser iu=Server.getInstance().getAirService().createInsuruser(ius);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	  }
//    	  this.setInuserlist(list);
//    	  this.setMessage("对不起!保险单预订失败!");
//    	  return "OrderApply";
//      }
//	    }
	/**
	 * 跳转到保险单页面
	 */
	public String toInsurancelist(){
		return "toInsurancelist";
	}
	/**
	 * 查询保险单信息
	 */
	public String ordermanager(){
		StringBuilder sb=new StringBuilder("WHERE 1=1");
		if(begintime!=null&&!begintime.equals("")&&begintime1!=null&&!begintime1.equals("")){
		sb.append(" AND C_TIME between '"+begintime+"' and '"+begintime1+"'");
		}
		if(insurorder.getOrderno()!=null&&!insurorder.getOrderno().equals("")){
			sb.append(" AND C_ORDERNO like '%"+insurorder.getOrderno()+"%'");
		}
//		if(insurorder.getComputerid()!=0){
//            sb.append(" AND C_COMPUTERID="+insurorder.getComputerid());
//		}
		if(insurorder.getStatus()!=null&&!insurorder.getStatus().equals("")){
			sb.append(" AND C_STATUS="+insurorder.getStatus());
		}
		if(inname!=null&&!inname.equals("")){
			long id=getuserId(inname);
			sb.append(" AND C_INSURUSERID="+id);
		}
		System.out.println(sb.toString());
		List list=Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo)list.remove(0);
	      orderlist = list;
		  if(pageinfo.getTotalrow()>0 && orderlist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			orderlist = list;
		}
		System.out.println(orderlist.size());
		return "ordermanager";
	}
	/**
	 * 查看所有服务单信息
	 */
	public String serviceorder(){
		StringBuilder sb=new StringBuilder("WHERE 1=1");
		if(begintime!=null&&!begintime.equals("")&&begintime1!=null&&!begintime1.equals("")){
			sb.append(" AND C_BEGINTIME between '"+begintime+"' and '"+begintime1+"'");
		}
		if(insuruser.getName()!=null&&!insuruser.getName().equals("")){
			sb.append(" AND C_NAME LIKE '%"+insuruser.getName()+"%'");
		}
		if(insuruser.getCode()!=null&&!insuruser.getCode().equals("")){
			sb.append(" AND C_CODE LIKE '%"+insuruser.getCode()+"%'");
		}
		System.out.println(sb.toString());
		List list=Server.getInstance().getAirService().findAllInsuruserForPageinfo(sb.toString()," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
	      orderlist = list;
		  if(pageinfo.getTotalrow()>0 && orderlist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsuruserForPageinfo(sb.toString()," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			orderlist = list;
		}
		 
		return "serviceorder";
	}
	/**
	 * 根据服务公司的id查询服务公司的名称
	 */
	public String getcomputer(Long id){
		return Server.getInstance().getAirService().findInsurcomputer(id).getComputername();
	}
	/**
	 * 根据被保人id查询被保人姓名
	 */
	public String getinsuruser(Long id){
		return Server.getInstance().getAirService().findInsuruser(id).getName();
	}
	/**
	 * 根据被保人id查询订单id
	 */
	public Long getOrderIds(){
		System.out.println(Server.getInstance().getAirService().findInsuruser(userid).getOrderid());
		return Server.getInstance().getAirService().findInsuruser(userid).getOrderid();
	}
	/**
	 * 根据订单id查询订单信息
	 */
	public String getorder(Long id){
		return Server.getInstance().getAirService().findInsurorder(id).getOrderno();
	} 
	/**
	 * 通过被保人姓名查找被保人编号
	 */
	public long getuserId(String name){
		String where="WHERE 1=1 AND C_NAME='"+name+"'";
		List list=Server.getInstance().getAirService().findAllInsuruser(where, "", -1, 0);
		long id=0;
		if(list.size()>0){
		 Insuruser user=(Insuruser)list.get(0);
		 id=user.getId();
		}
		return id;
	}
	
	/**
	 * 查看订单详情
	 */
	public String orderdetail(){
		//根据订单编号的到订单对象
		Insurorder insruorder=Server.getInstance().getAirService().findInsurorder(oid);
		//根据被保人编号获得被保人信息
		//this.setInuserlist(Server.getInstance().getAirService().findAllInsuruser("WHERE 1=1 AND C_POLICYNO='"+insruorder.getId()+"'", "", 1, 1));
		System.out.println(insruorder.getInsuruserid());
		//this.setInsuruser(Server.getInstance().getAirService().findInsuruser(insruorder.getInsuruserid()));
		System.out.println(insuruser.getFlyno());
		System.out.println(insuruser.getCodetype());
		//根据订单编号查询被保人信息
		//this.setUserlist(Server.getInstance().getAirService().findAllInsuruser("WHERE　1=1", "", -1, 0));
		//System.out.println(userlist.size());
		return "orderdetail";
	}
	/**
	 * 根据订单id查询订单号
	 */
	public String getOrderno(Long id){
		Insurorder order=(Insurorder)Server.getInstance().getAirService().findAllInsurorder("WHERE ID="+id, " ", -1, 0).get(0);
		return order.getOrderno();
	}
	/**
	 * 根据被保人id查询保单号
	 */
	public String orderOn(Long id){
		Insurorder order=(Insurorder)Server.getInstance().getAirService().findAllInsurorder("WHERE C_INSURUSERID="+id, " ", -1, 0).get(0);
		return order.getOrderno();
	}
	/**
	 * 立即支付
	 */
	public String payinsurance(){
		//根据订单编号的到订单对象
		this.setInsurorder(Server.getInstance().getAirService().findInsurorder(oid));
		//根据被保人编号获得被保人信息
		//this.setInuserlist(Server.getInstance().getAirService().findAllInsuruser("WHERE 1=1 AND C_POLICYNO='"+insruorder.getId()+"'", "", 1, 1));
		System.out.println(this.insurorder.getInsuruserid());
//		this.setInsuruser(Server.getInstance().getAirService().findInsuruser(this.insurorder.getInsuruserid()));
//	    this.inuserlist.add(Server.getInstance().getAirService().findInsuruser(this.insurorder.getInsuruserid()));
		return "payinsurance";
	}
	/**
	 * 取消订单
	 */
	public String cancelOrder(){
		//根据订单编号得到订单对象
		this.setInsurorder(Server.getInstance().getAirService().findInsurorder(oid));
		this.insurorder.setStatus(Long.parseLong("3"));
		//修改订单的状态
		Server.getInstance().getAirService().updateInsurorder(insurorder);
		StringBuilder sb=new StringBuilder("WHERE 1=1");
		List list=Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo)list.remove(0);
	      orderlist = list;
		  if(pageinfo.getTotalrow()>0 && orderlist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			orderlist = list;
		}
		return "cancelOrder";
	}
	/**
	 * 支付保险订单
	 */
	public String payInsurOrder(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//根据订单id查询订单
		this.setInsurorder(Server.getInstance().getAirService().findInsurorder(oid));
		//获得总价
		Double totalprice=insurorder.getTotalmoney();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("billname", "InsurancepayHelper");// 对应接口中 支付辅助类 必传
		map.put("orderid", oid);// 订单id 必传
		if (ServletActionContext.getServletContext().getAttribute(
				"vmoneyservice") != null) {// 判断是否有虚拟账户业务
			map.put("actionname", "insurance!vmoneyAirticketpay.action");
			System.out.println(oid);
			boolean vpay = true;
			float vmoney=new CustomeragentServiceImpl().getTotalVmoney(this
					.getLoginUser().getAgentid());
			if (totalprice > vmoney) {
				vpay = false;
			}
			map.put("vmoney", vmoney);
			map.put("vmpayenable", vpay);// 如果可虚拟账户支付 传入当前账户余额
		}
		map.put("orderprice", totalprice);
		request.setAttribute("ordermap", map);// 传值....
		return "payInsurOrder";
	}

	/**
	 * 根据订单查询乘机人给乘机人购买保险
	 */
	public String buyInsurance(){
		//查询乘机人信息（被保人信息）根据订单号
		String pwhere = " WHERE " + Passenger.COL_orderid + "=" + orderId;
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(pwhere, "", -1, 0);
		this.setPassengerlist(passengers);
		return "buyInsurance";
	}
	/**
	 *根据订单id查询航班号
	 */
	public String getFlyNoById(long orderids){
	    String sql="SELECT C_FLIGHTNUMBER AS flightnumber FROM T_SEGMENTINFO WHERE C_ORDERID="+orderids+"";
	    System.out.println(sql);
		Segmentinfo segment=findBySql(Segmentinfo.class, sql);
		System.out.println(segment.getFlightnumber());
		return segment.getFlightnumber();
	}
	/**
	 * 根据订单id查询抵达时间
	 */
	public String getDepaittime(Long orderid){
		 String sql="SELECT C_DEPARTTIME AS departtime FROM T_SEGMENTINFO WHERE C_ORDERID="+orderid+"";
		    System.out.println(sql);
			Segmentinfo segment=findBySql(Segmentinfo.class, sql);
			System.out.println(formatTimestamp(segment.getDeparttime()).toString().substring(0,10));
			return formatTimestamp(segment.getDeparttime()).toString().substring(0,10);
		
	}
	/**
	 * 格式化时间
	 */
private SimpleDateFormat minuteformat = new SimpleDateFormat("yyyy-MM-dd");
public String formatTimestamptoMinute(Timestamp date) {
try {
	return (minuteformat.format(date));

} catch (Exception e) {
	return "";
}

}
	/**
	 * 根据订编号查询订单信息
	 */
	public String getPassenger(){
		//String sql="SELECT C_NAME AS name,C_IDTYPE AS idtype,C_IDNUMBER AS idnumber,C_MOBILE AS mobile,C_BIRTHDAY AS birthday FROM T_PASSENGER WHERE 1=1";
		StringBuilder sb=new StringBuilder();
		//判断编号是否为空
		if(flyorderid!=null&&!flyorderid.equals("")){
			sb.append(" Where  C_ORDERID=(SELECT ID AS id FROM T_ORDERINFO WHERE C_ordernumber ='"+flyorderid+"')") ;
			this.setPassengerlist(Server.getInstance().getAirService().findAllPassenger(sb.toString(), "", -1, 0));
		}else{
			this.setPageinfo(null);
		}
		
		return "buyInsurance";
	}
	public String getFlyorderid() {
		return flyorderid;
	}
	public void setFlyorderid(String flyorderid) {
		this.flyorderid = flyorderid;
	}
	
	/**
	 * 虚拟货币进行支付
	 */
	public String vmoneyAirticketpay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int paystate = 1;// 成功
		String message = "订单支付成功!";
		//获得订单编号
		String orderid = ServletActionContext.getRequest().getParameter(
				"orderid");
		try {
			//根据id获得订单信息
			Insurorder orderinfo = Server.getInstance().getAirService().findInsurorder(Long.valueOf(orderid));	
			//获得订单的总价钱
			double totleprice=orderinfo.getTotalmoney();
			//获得用户的虚拟货币
			long loginagentid=this.getLoginUser().getAgentid();
			double vmoney=new CustomeragentServiceImpl().getTotalVmoney(loginagentid);
			//判断是否能够支付
			if (totleprice > vmoney) {
				paystate = 2;// 失败
				message = "订单支付失败！原因：当前账户余额不足与订单支付！";
			} else {
				orderinfo.setStatus(Long.parseLong("2")); // 已支付
				//相应的扣除虚拟货币的金额
				String price=Double.toString(0-totleprice);
				this.createRebateRecord(orderinfo.getOrderno(),
						Float.parseFloat(price), 9, loginagentid, loginagentid, 2,null);

				//更新订单的状态
				Server.getInstance().getAirService().updateInsurorderIgnoreNull(orderinfo);
				
				//支付成功跳转到保险单查询页面
				StringBuilder sb=new StringBuilder("WHERE 1=1");
				List list=Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
				pageinfo = (PageInfo)list.remove(0);
			      orderlist = list;
				  if(pageinfo.getTotalrow()>0 && orderlist.size()==0){
					pageinfo.setPagenum(1);
					list = Server.getInstance().getAirService().findAllInsurorderForPageinfo(sb.toString()," ORDER BY ID ", pageinfo);
					pageinfo = (PageInfo)list.remove(0);
					orderlist = list;
				}

			}
		} catch (Exception e) {
			paystate = 2;// 失败
			message = "订单支付失败！原因：网络连接失败！";
			e.printStackTrace();
		}
		request.setAttribute("paystate", paystate);
		request.setAttribute("message", message);
		System.out.println("air/airpaysuccess.jsp");
		return "cancelOrder";
	}

	public List getUserlist() {
		return userlist;
	}

	public void setUserlist(List userlist) {
		this.userlist = userlist;
	}

	public List<Insurorder> getOlist() {
		return olist;
	}

	public void setOlist(List<Insurorder> olist) {
		this.olist = olist;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Orderinfo getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public Segmentinfo getSegmentinfo() {
		return segmentinfo;
	}

	public void setSegmentinfo(Segmentinfo segmentinfo) {
		this.segmentinfo = segmentinfo;
	}

	public List<Passenger> getListpass() {
		return listpass;
	}

	public void setListpass(List<Passenger> listpass) {
		this.listpass = listpass;
	}

	public long getPassid() {
		return passid;
	}

	public void setPassid(long passid) {
		this.passid = passid;
	}

	public SimpleDateFormat getMinuteformat() {
		return minuteformat;
	}

	public void setMinuteformat(SimpleDateFormat minuteformat) {
		this.minuteformat = minuteformat;
	}
	
}
