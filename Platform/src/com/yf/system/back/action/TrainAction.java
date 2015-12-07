/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.system.atom.service.IAtomService;
import com.yf.system.back.server.Server;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.province.Province;
import com.yf.system.base.service.ITrainService;
import com.yf.system.base.train.Train;
import com.yf.system.base.trainpassenger.Trainpassenger;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.ymsend.Ymsend;
import com.opensymphony.webwork.ServletActionContext;

public class TrainAction extends B2b2cbackAction {
	private List<Train> listTrain;
	private Train train = new Train();
	private String agentroot;
	private long agentid;
	private int[] selectid;
	
	
	private String companyname;
	private String forword;
	
	private int baoxianprice;

	// 用于查询条件
	private String startcreatetime;
	private String endcreatetime;
	private int s_orderstatus=-2;
	
	private String s_name;
	private String s_code;
	private String s_ordercode;
	private int s_qupiaotype=-1;
	
	private List<Customeruser> listuser = new ArrayList<Customeruser>();
	private List<Train> trainlist = new ArrayList<Train>();
	private List<Trainpassenger> trainpassengerlist = null;
	private ITrainService trainservice;
	
	private List<Province> listProvince = new ArrayList<Province>();
	
	private List<Ymsend> listsms=new ArrayList<Ymsend>();
	
	private Float allprice;
	private int allbxprice;
	
	//配送用
	private String address;
	private String cmbProvince;
	private String cmbCity;
	private String cmbArea;
	
	private String peisong_name;
	private String peisong_tel;
	private String peisong_post;
	
	private String strOrderID;//订单ID
	
	private String s_userid;//会员ID
	
	
	private String s_kdcomname;//快递
	
	private String s_kdcode;//快递
	
	private String s_kddesc;//快递

	/**
	 * 火车首页
	 */
	public String execute() {
		
		
		
		

		return "index";
	}
	public String topeisong() {
		
		
		train=Server.getInstance().getTrainService().findTrain(Long.parseLong(strOrderID));
		

		return "topeisong";
	}
	public String updateuserid() {
		
		Train train=Server.getInstance().getTrainService().findTrain(Long.parseLong(strOrderID));
		train.setUserid(s_userid);
		Server.getInstance().getTrainService().updateTrainIgnoreNull(train);
		

		return this.trainorder();
	}
	
	
	
	/**
	 * 火车-分配地区
	 */
	public String tofenpei() {
		String where=" WHERE 1=1 AND "+Province.COL_id+" NOT IN( SELECT "+Customeruser.COL_description+" FROM "+Customeruser.TABLE+" )";
			   where=" WHERE 1=1 ";
		listProvince=Server.getInstance().getHotelService().findAllProvince(where, " ORDER BY ID DESC ", -1, 0);
		
		System.out.println("where:"+where+",listProvince:"+listProvince.size());

		return "tofenpei";
	}
	
	public String fenpei() {
		System.out.println(s_name.toString()+","+s_userid);
		Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(Long.parseLong(s_userid));
		
		customeruser.setDescription(s_name);
		Server.getInstance().getMemberService().updateCustomeruserIgnoreNull(customeruser);
		
		forword="customeruser!toEmployeelist.action?agentid="+customeruser.getAgentid();
		
		return "forword";
	}
	
	/**
	 * 火车首页
	 */
	public String tochupiao() {
		train=Server.getInstance().getTrainService().findTrain(Long.parseLong(strOrderID));
		
		
		

		return "tochupiao";
	}
public void allpaytui(){
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			String orderidstr = request.getParameter("strTuiOrderID");
			String strTuiOrderState = request.getParameter("strTuiOrderState");
			
			String pretstr="";
			Train train = Server.getInstance().getTrainService().findTrain(Long.parseLong(orderidstr));
			if(train!=null&&(train.getOrderstatus()==3||train.getOrderstatus()==4)){
				pretstr="申请成功!";
				train.setOrderstatus(Integer.parseInt(strTuiOrderState));
				Server.getInstance().getTrainService().updateTrainIgnoreNull(train);
				if(train.getOrderstatus()==17){
					pretstr="申请成功!请及时联系平台告诉准确的改签信息!!!";
				}
				
			}else{
				if(train.getOrderstatus()==14||train.getOrderstatus()==17){
					pretstr="申请失败!当前已经是申请状态!!";
				}else{
					pretstr="申请失败!";
				}
				
			}
			
			
			PrintWriter out = response.getWriter();
			System.out.println(pretstr);
			out.print(pretstr);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

public void suodan(){
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			String orderidstr = request.getParameter("strTuiOrderID");
			String pretstr="";
			Train train = Server.getInstance().getTrainService().findTrain(Long.parseLong(orderidstr));
			if(train.getUserid()==null||train.getUserid().equals("")||train.getUserid().equals("0")||train.getUserid().equals("-1")){
				pretstr="锁单成功!";
				train.setUserid(getLoginUser().getId()+"");
				train.setSuotime(new Timestamp(System.currentTimeMillis()));
				Server.getInstance().getTrainService().updateTrainIgnoreNull(train);
			}else{
				if(!train.getUserid().equals(getLoginUser().getId()+"")){
					pretstr="锁单失败!当前订单已被["+getusername(Long.parseLong(train.getUserid()))+"]锁定!";
					
				}else{
					pretstr="锁单成功!";
					
				}
				
			}
			
			
			PrintWriter out = response.getWriter();
			System.out.println(pretstr);
			out.print(pretstr);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
public void ajaxValadateSuoDan(){
	
	try {
		
		if(getLoginAgent().getAgenttype()==1||getLoginAgent().getAgenttype()==2){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String orderidstr = request.getParameter("strTuiOrderID");
		String pretstr="";
		Train train = Server.getInstance().getTrainService().findTrain(Long.parseLong(orderidstr));
		if(train.getUserid()==null||train.getUserid().equals("")||train.getUserid().equals("0")||train.getUserid().equals("-1")){
			pretstr="";
			train.setUserid(getLoginUser().getId()+"");
			train.setSuotime(new Timestamp(System.currentTimeMillis()));
			Server.getInstance().getTrainService().updateTrainIgnoreNull(train);
		}else{
			if(!train.getUserid().equals(getLoginUser().getId()+"")){
				pretstr="锁单失败!当前订单已被["+getusername(Long.parseLong(train.getUserid()))+"]锁定!";
				
			}else{
				
				pretstr="";
			}
			
		}
		
		
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();
		
		
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
	
}
	/**
	 * 火车出票
	 */
	public String SaveAndTicket() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Train train=Server.getInstance().getTrainService().findTrain(Long.parseLong(strOrderID));
		List<Trainpassenger>list1=Server.getInstance().getTrainService().findAllTrainpassenger(" where 1=1 and "+Trainpassenger.COL_orderid+" ="+train.getId(), " ORDER BY ID ", -1, 0);
		String beizhu=request.getParameter("beizhu_"+strOrderID);
		
		String cpxx=request.getParameter("chupiaoxinxi_"+strOrderID);
		
		System.out.println("备注:"+beizhu);
		String names="";
		for(int a=0;a<list1.size();a++){
			Trainpassenger trainpassenger=list1.get(a);
			String xibie = request.getParameter("s_beixuanxibie_"+list1.get(a).getId());
			String price = request.getParameter("s_chupiaoprice_"+list1.get(a).getId());
			
			names+=trainpassenger.getName()+",";
			System.out.println(list1.get(a).getName()+":"+xibie+":"+price);
			trainpassenger.setYudingtype(GetXiBieTypeByCode(train.getSeattype()));
			trainpassenger.setChupiaotype(xibie);
			trainpassenger.setChupiaoprice(price);
			Server.getInstance().getTrainService().updateTrainpassengerIgnoreNull(trainpassenger);
			
		}
		
		train.setOrderstatus(3);
		train.setMemo("["+beizhu+"]");
		train.setCpxx(cpxx);
		Server.getInstance().getTrainService().updateTrainIgnoreNull(train);
		
		//熊富强,您预定06月27日K420次14车厢026号陇西11:53开硬座，已出票，请尽快换取纸质车票，祝您旅途愉快
		//增加出票短信
		//String msm="您已购"+train.getStartdate()+train.getTraincode()+"次"+train.getStartcity()+train.getStarttime()+"开。已出票，"+names+"请尽快换取纸质车票。";
		String	msm=names+"您预定"+train.getStartdate()+"日"+train.getTraincode()+"次"+cpxx+train.getStartcity()+train.getStarttime()+"开"+GetXiBieTypeByCode(train.getSeattype())+",已出票，请尽快换取纸质车票，祝您旅途愉快";
		System.out.println(msm);
		Server.getInstance().getAtomService().sendSms(new String[] {train.getContactmobile()}, msm, train.getId()+"", "3");//2机票  2火车票短信
		forword="train!trainorder.action?s_orderstatus=3";
		
		return "forword";
	}
	
	/**
	 * 火车配送
	 */
	public String SaveAndPeiSong() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Train train=Server.getInstance().getTrainService().findTrain(Long.parseLong(strOrderID));
		train.setKdcode(s_kdcode);
		train.setKdcomname(s_kdcomname);
		train.setKddesc(s_kddesc);
		train.setOrderstatus(4);
		
		Server.getInstance().getTrainService().updateTrainIgnoreNull(train);
		

		return this.trainorder();
	}

	/**
	 * @return 时刻列表
	 */
	public String search() {
		IAtomService service = Server.getInstance().getAtomService();
		if (!isNotNullOrEpt(train.getStarttime())) {
			Timestamp now = this.getCurrentTime();
			now.setDate(now.getDate() + 2);
			train.setStarttime(super.formatTimestampyyyyMMdd(now));
		}
		this.trainlist = service.getSKTrainList(train.getStartcity(), train
				.getEndcity(), train.getStarttime());
		System.out.println("***************************************");
		System.out.println(trainlist.size());
		return "trainlist";

	}
	public List getPassengerInfohtml(long id){
		List<Object> list=new ArrayList<Object>();
		
		List<Trainpassenger>list1=Server.getInstance().getTrainService().findAllTrainpassenger(" where 1=1 and "+Trainpassenger.COL_orderid+" ="+id, " ORDER BY ID ", -1, 0);
		if(list1!=null&&list1.size()>0){
			for(int a=0;a<list.size();a++){
				
				//String ret+=list1.get(a).getName()+"</br>";
			}
		} 
		
		
		
		
		
		return list;
	}
	public List<Trainpassenger> GetTrainPassList(long id){
		
		
		List<Trainpassenger>list=Server.getInstance().getTrainService().findAllTrainpassenger(" where 1=1 and "+Trainpassenger.COL_orderid+" ="+id, " ORDER BY ID ", -1, 0);
		
		return list;
	}
	
	
	
	public String GetTrainTypeByCode(String code){
		String ret="普快";
		if(code.indexOf("T")!=-1){
			ret="特快";
		}
		if(code.indexOf("K")!=-1){
			ret="快速";
		}
		if(code.indexOf("Z")!=-1){
			ret="直达";
		}
		if(code.indexOf("D")!=-1){
			ret="动车";
		}
		if(code.indexOf("G")!=-1){
			ret="高铁";
		}
		
		return ret;
	}
	
	public String GetXiBieTypeByCode(int code){
		String ret="无座";
		if(code==0){
			ret="无座";
		}
		if(code==1){
			ret="硬座";
		}
		if(code==2){
			ret="软卧";
		}
		if(code==3){
			ret="硬卧";
		}
		if(code==4){
			ret="软卧";
		}
		if(code==5){
			ret="高卧";
		}
		if(code==6){
			ret="二等";
		}
		if(code==7){
			ret="一等";
		}
		if(code==8){
			ret="商务";
		}
		if(code==9){
			ret="特等";
		}
		return ret;
	}
	
	
	
	public String GetTrainOrderStausByCode(int code){
		String ret="等待支付";
		if(code==-1){
			ret="已经取消";
		}
		if(code==0){
			ret="等待确认";
		}
		if(code==1){
			ret="等待支付";
		}
		if(code==2){
			ret="已支付,待出票";
		}
		if(code==3){
			ret="已出票,交易完成";
		}
		
		if(code==4){
			ret="已出票,已配送";
		}
		if(code==5){
			ret="拒单-等待退款";
		}
		if(code==6){
			ret="拒单-已退款";
		}
		if(code==14){
			ret="申请退票";
		}
		if(code==24){
			ret="退票-处理中";
		}
		if(code==15){
			ret="已退票,已退款";
		}
		if(code==16){
			ret="退票失败";
		}
		if(code==17){
			ret="申请改签";
		}
		if(code==27){
			ret="改签-处理中";
		}
		if(code==18){
			ret="改签成功";
		}
		if(code==9){
			ret="改签失败";
		}
		if(code==99){
			ret="订单关闭";
		}
		
		return ret;
	}
	
	
	public String GetAgentTel(long id){
		String tel="";
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(id);
		if(customeragent!=null&&customeragent.getAgentphone()!=null){
			tel=customeragent.getAgentphone();
		}
		
		return tel;
	}
	public String GetTrainPassName(long id){
		String ret="";
		List<Trainpassenger>list=Server.getInstance().getTrainService().findAllTrainpassenger(" where 1=1 and "+Trainpassenger.COL_orderid+" ="+id, " ORDER BY ID ", -1, 0);
		if(list!=null&&list.size()>0){
			for(int a=0;a<list.size();a++){
				
				ret+=list.get(a).getName()+"</br>";
			}
		} 
		
		return ret;
	}
	
	public Float GetTrainPrice(long id){
		Float allprice=0f;
		Train train=Server.getInstance().getTrainService().findTrain(id);
		allprice=train.getTotalprice()+train.getPsprice();
		
		int bxprice=0;
		List<Trainpassenger>list=Server.getInstance().getTrainService().findAllTrainpassenger(" where 1=1 and "+Trainpassenger.COL_orderid+" ="+id, " ORDER BY ID ", -1, 0);
		if(list!=null&&list.size()>0){
			for(int a=0;a<list.size();a++){
				if(list.get(a).getBxprice()>0){
					bxprice+=list.get(a).getBxprice();
				}
				
			}
		} 
		
		
		
		return allprice+bxprice;
	}
	
	
	public String GetBeiXuan(String info){
		String ret="<select name='s_beixuanxibie'>";
		ret+="";
		if(info!=null&&info.trim().length()>0){
			String[] infos=info.split(",");
			for(int a=0;a<infos.length;a++){
				ret+="<option value='"+infos[a].trim()+"' >"+infos[a].trim()+"</option>";
				
			}
			
		}else{
			
			ret+="<option value='无' >无</option>";
			
		}
		ret+="</select>";
		 
         
         
		
		return ret;
	}
	public String Getchupiaoxibie(String beixuan,String dangqian){
		String ret="";
		ret+="<option value='"+dangqian+"' >"+dangqian+"</option>";
		if(beixuan!=null&&beixuan.trim().length()>0){
			String[] infos=beixuan.split(",");
			for(int a=0;a<infos.length;a++){
				ret+="<option value='"+infos[a].trim()+"' >"+infos[a].trim()+"</option>";
			}
		}
		return ret;
	}
	public void getPassengersqList(){
		
		String strReturn = "";
		
		Train train=Server.getInstance().getTrainService().findTrain(Long.parseLong(strOrderID));
		List<Trainpassenger>listpass=GetTrainPassList(Long.parseLong(strOrderID));
		
		
		strReturn+="<div class='message' id='message' >";
		strReturn+="<h2>信息核对</h2>";
		strReturn+="<table  cellspacing='0' cellpadding='1' align='center' style='width:100%'>";
		strReturn+="<tr><td colspan='5'>车票信息</td></tr>";
		strReturn+="<tr>";
		strReturn+="<td style='font-size: 28px;color: red'><b>"+train.getStartdate()+"</b></td>";
		strReturn+="<td style='font-size: 28px;color: red'><b>"+train.getTraincode()+"次</b></td>";
		strReturn+="<td colspan='3' style='font-size: 18px;color: red'><b>"+train.getStartcity()+"&nbsp;"+train.getStarttime()+"—"+train.getEndcity()+"</b></td></tr>";
		strReturn+="</table>";
         
		strReturn+="<table cellspacing='0' cellpadding='1' align='center' style='width:100%' class='me-info'>";
		strReturn+="<tr><td colspan='6' >乘客信息</td></tr>";
		strReturn+="<tr>";
		strReturn+="<td width='10%'>席别</td>";
		strReturn+="<td width='10%'>票种</td>";
		strReturn+="<td width='20%'>姓名</td>";
		strReturn+="<td width='20%'>证件类型</td>";
		strReturn+="<td width='40%'>证件号码</td>";
		strReturn+="</tr>";
             
		//strReturn+="<ww:iterator value='GetTrainPassList(id)'>";
		
		Float price=0f;
		for(int a=0;a<listpass.size();a++){
		strReturn+="<tr>";
		strReturn+="<td width='10%' style='font-size: 28px;color: red'><b>"+GetXiBieTypeByCode(listpass.get(a).getState())+"</b></td>";
		String type="成人";
		if(listpass.get(a).getState()==1){
			type="成人";
			price=listpass.get(a).getPrice();
		}
		if(listpass.get(a).getState()==2){
			type="儿童";
		}
		strReturn+="<td width='10%'>"+type+"</td>";
		strReturn+="<td width='20%' style='font-size: 28px;color: red'><b>"+listpass.get(a).getName()+"</b></td>";
		strReturn+="<td width='20%'>"+getTypeToString(listpass.get(a).getIdtype())+"</td>";
		strReturn+="<td width='40%' style='font-size: 18px;color: red'><b>"+listpass.get(a).getIdnumber()+"</b></td>";
		
		//strReturn+="<ww:set name='infos_price' value='price'/>";
		strReturn+="</tr>";
		}
		//strReturn+="</ww:iterator>";
		strReturn+="</table>";
         
         
         
		strReturn+="<table  cellspacing='0' cellpadding='1' align='center' style='width:100%' class='save'>";
		strReturn+="<tr><td colspan='5'>其他信息</td></tr>";
		strReturn+="<tr>";
		strReturn+="<td style='font-size: 18px;color: red'><b>备选席别:"+train.getDeliverytypeval()+"</b></td>";
		strReturn+="<td style='font-size: 28px;color: red'><b>单人票价:"+price+"</b></td>";
		strReturn+="<td colspan='3' style='font-size: 28px;color: red'><b>总票价:"+train.getTotalprice()+"</b></td>";
		strReturn+="</tr>";
		strReturn+="</table>";  
         
		strReturn+="<table cellspacing='0' cellpadding='1' align='center' style='width:100%' class='me-info'>";
		strReturn+="<tr><td colspan='6' >出票信息</td></tr>";
		strReturn+="<tr>";
		strReturn+="<td width='20%'>姓名</td>";
		strReturn+="<td width='10%'>票种</td>";
		strReturn+="<td width='10%'>席别</td>";
		strReturn+="<td width='20%'>价格</td>";
		strReturn+="</tr>";
             
		//strReturn+="<ww:iterator value='GetTrainPassList(id)' status='ind'>";
		for(int a=0;a<listpass.size();a++){
		strReturn+="<tr>";
                 
                  
		strReturn+="<td width='20%' style='font-size: 28px;color: red'><b>"+listpass.get(a).getName()+"</b></td>";
		String type="成人";
		if(listpass.get(a).getState()==1){
			type="成人";
			price=listpass.get(a).getPrice();
		}
		if(listpass.get(a).getState()==2){
			type="儿童";
		}
		strReturn+="<td width='10%'>"+type+"</td>";
		strReturn+="<td width='10%' style='font-size: 28px;color: red'><b>"+Getchupiaoxibie(train.getDeliverytypeval(), GetXiBieTypeByCode(train.getSeattype()))+"<ww:property value='GetXiBieTypeByCode(seattype)'/></b></td>";
		strReturn+="<td width='20%'><input id='' name='' /></td>";
                 
		strReturn+="</tr>";
		}
		//strReturn+="</ww:iterator>";
		strReturn+="</table>";
         
         /*<table  cellspacing='0' cellpadding='1' align='center' style='width:100%' class='save'>
         
             <tr>
                <td class='save-tit'>订单编号:</td>
                <td class='save-con'><input type='text' /></td>
                <td class='save-tit'>坐席号:</td>
                <td class='save-con'><input type='text' /></td>
             </tr>
              <tr>
                <td class='save-tit'>出票席别:</td>
                <td class='save-con'><input type='text' /></td>
                <td class='save-tit'>出票单价:</td>
                <td class='save-con'><input type='text' /></td>
             </tr>
             <tr>
                 <td class='save-tit'>订单备注:</td>
                 <td class='save-con'><textarea></textarea></td>
             </tr>
         </table>*/
		strReturn+="<table  cellspacing='0' cellpadding='1' align='center' style='width:100%' class='save-btn'>";
		strReturn+="<tr>";
		strReturn+="<td style='text-align:right'><a href='#' class='save-btn'>保存并出票</a></td>";
		strReturn+="<td style='text-align:left'><a href='#' class='can-btn' onclick='guanbi(id='message<ww:property value='#t.count'/>');'>取消</a></td>";
		strReturn+="</tr>";
		strReturn+="</table>";
		strReturn+="</div>";
		
		
		
		
		
		System.out.println(strReturn);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		try {
			PrintWriter	out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strReturn);
			out.print(sb);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * @return
	 * 
	 * 预定列表
	 */
	public String yptrain() {
		// IAtomService service = Server.getInstance().getAtomService();
		// DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// if (train.getStarttime() == null) {
		// train.setStarttime(super.formatTimestampyyyyMMdd(this
		// .getCurrentTime()));
		// }
		// String time;
		// try {
		// time = format.format(format.parse((train.getStarttime())));
		// train.setStarttime(time);
		// } catch (ParseException e) {
		// }
		// this.trainlist = service.getDGTrainList(train.getStartcity(), train
		// .getEndcity(), train.getStarttime());
		// for (Train ctrian : trainlist) {
		// if (ctrian.getTraincode().equals(this.train.getTraincode())) {
		// trainlist.remove(ctrian);
		// trainlist.add(0, ctrian);
		// break;
		// }
		// }
		System.out.println("***************************************");
		System.out.println("TrainAction:yptrain/train:yptrainlist.jsp");
		return "yptrain";
	}

	public void ajaxYPList() {
		HttpServletResponse response = ServletActionContext.getResponse();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(train.getTraincode());
		System.out.println(train.getStartcity());
		System.out.println(train.getEndcity());
		IAtomService service = Server.getInstance().getAtomService();
		if (train.getStarttime() == null) {
			train.setStarttime(super.formatTimestampyyyyMMdd(this
					.getCurrentTime()));
		}

		try {
			String time = format.format(format.parse((train.getStarttime())));
			train.setStarttime(time);
		} catch (ParseException e) {
		}
		System.out.println(train.getStarttime());
		this.trainlist = service.getDGTrainList(train.getStartcity(), train
				.getEndcity(), train.getStarttime());
		if (isNotNullOrEpt(train.getTraincode())) {
			for (Train ctrian : trainlist) {
				if (ctrian.getTraincode().equals(this.train.getTraincode())) {
					trainlist.remove(ctrian);
					trainlist.add(0, ctrian);
					break;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (Train train : trainlist) {
			builder.append("<TR ");
			if (i == 0) {
				builder.append("style='background: #d1e6f8'");
			}
			builder.append("class='" + train.getTraincode().substring(0, 1)
					+ "'>");
			builder.append("<TD height=\"50px\"><b class=\"lan14\">");
			builder.append(train.getTraincode() + "</b><br />");
			builder.append(train.getTraintype() + "</TD>");
			builder
					.append("<TD>" + train.getStartcity()
							+ train.getStarttime());
			builder.append("<br />");
			builder.append(train.getEndcity() + train.getEndtime() + "</TD>");
			builder.append("<TD>" + train.getDistance() + "公里<br />");
			builder.append(train.getCosttime() + "</TD>");
			// <!-- 硬座 -->
			builder.append("<TD>");
			builder.append(getTrainpriceByYP(train.getYzyp(), train
					.getYzprice(), "￥"));
			builder.append("</TD>");
			builder.append("<TD>");
			if (existSeat(train.getRz2yp())) {
				builder.append(getTrainpriceByYP(train.getRz2yp(), train
						.getRz2price(), "二等￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getRz1yp(), train
						.getRz1price(), "一等￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getRzyp(), train
						.getRzprice(), "普通￥"));
			} else {

				builder.append("<font style=\"color: #ccc\">--</font>");
				builder.append("</TD>");
			}
			builder.append("<TD>");

			if (existSeat(train.getYwyp())) {
				builder.append(getTrainpriceByYP(train.getYwyp(), train
						.getYwsprice(), "上￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getYwyp(), train
						.getYwzprice(), "中￥"));
				builder.append("<br />");
				builder.append(getTrainpriceByYP(train.getYwyp(), train
						.getYwxprice(), "下￥"));
			} else {
				builder.append("<font style=\"color: #ccc\">--</font>");
			}
			builder.append("</TD>");
			builder.append("<TD>");
			if (existSeat(train.getRwyp())) {
				builder.append(getTrainpriceByYP(train.getRwyp(), train
						.getRwsprice(), "上￥"));
				builder.append("<br/>");
				builder.append(getTrainpriceByYP(train.getRwyp(), train
						.getRwxprice(), "下￥"));
				builder.append("<br/>");
			} else {
				builder.append("<font style=\"color: #ccc\">--</font>");
			}
			builder.append("</TD>");
			builder.append("<TD>");
			if (hasYP(train)) {
				builder
						.append("<img src=\"images/buyico.jpg\" style='margin-top:1px;cursor:pointer;'");
				builder.append("onclick=toordertrain(" + train.getJson()
						+ "); /><br/>");
			} else {
				builder.append("<font color='#cccccc'>已售完</font>");
			}
			builder.append("<span style='cursor: pointer; display:block' "
					+ "onclick=showInfo('" + train.getTraincode() + "'," + i
					+ ")>&nbsp;&nbsp;详情</span>");
			builder.append("</TD>");
			builder.append("</TR>");
			builder.append("<tr>");
			builder.append("<td colspan=\"8\" style=\"padding: 0\">");
			builder.append("<div class=\"tinfo lbox\" id='divinfo" + i
					+ "' style=\"display:none; text-align: center;");
			builder.append("width:670px; margin: 8px\">");
			builder.append("</div>");
			builder.append("</td>");
			builder.append("</tr>");
			builder.append("<tr>");
			builder
					.append("<td colspan=\"8\" style=\"height: 1px; line-height: 1px;");
			builder.append("overflow:hidden; padding: 0 \">");
			builder
					.append("<div style=\"height: 1px; background:#91c8e5; line-height: 1px;");
			builder.append("overflow: \">&nbsp;</div>");
			builder.append("</td>");
			builder.append("</tr>");
			i++;
		}

		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(builder.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return 到订单预定页面
	 */
	public String toordertrain() {
		
		
		/*List<Map<String, String>> listmap = Server.getInstance()
		.getAtomService().getTrainInfo(train.getTraincode(), train.getStartdate());*/
		
		IAtomService service = Server.getInstance().getAtomService();
		this.trainlist = service.getYPTrainList(train.getStartcity(), train
				.getEndcity(), train.getStartdate());
		
		if(trainlist!=null&&trainlist.size()>0){
			for(int a=0;a<trainlist.size();a++){
				if(trainlist.get(a).getTraincode()!=null&&trainlist.get(a).getTraincode().equals(train.getTraincode())){
					train=trainlist.get(a);
					System.out.println("找到了");
					break;
				}
			}
			
			
		}
		System.out.println("yp2:"+train.getRz2yp());
		System.out.println("yp1:"+train.getRz1yp());
		System.out.println("ypsw:"+train.getSwzyp());
		System.out.println("yptd:"+train.getTdzyp());
		
		System.out.println("price2:"+train.getRz2price());
		System.out.println("price1:"+train.getRz1price());
		System.out.println("pricesw:"+train.getSwzprice());
		System.out.println("pricetd:"+train.getTdzprice());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println(train.getStartdate());
		session.setAttribute("ordertrain", train);
		StringBuilder builder = new StringBuilder("");
		StringBuilder pwbuilder = new StringBuilder("");
		System.out.println(train.getGwyp());
		
		List<Object> listprice=new ArrayList<Object>();
		
		if (isntNullorZero(train.getYzprice())) {//无座
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_0' type='radio' value='"+train.getYzprice()+","+train.getWzyp()+"' onclick='bookOrderchangeFirstSeat(this,0);'/>");
			if(train.getWzyp()!=null&&existSeat(train.getWzyp())){
			 int yp = Integer.valueOf(train.getWzyp());
				if(yp>0){
					builder.append("<span id='em_firstSeat_0'>无座&nbsp;"+train.getYzprice()+"元　(剩余"+train.getWzyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>无座&nbsp;"+train.getYzprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>无座&nbsp;"+train.getYzprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getYzprice());
		}
		
		if (isntNullorZero(train.getYzprice())) {//硬座
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_1' type='radio' value='"+train.getYzprice()+","+train.getYzyp()+"' onclick='bookOrderchangeFirstSeat(this,1);'/>");
			if(train.getYzyp()!=null&&existSeat(train.getYzyp())){
			 int yp = Integer.valueOf(train.getYzyp());
				if(yp>0){
					builder.append("<span id='em_firstSeat_0'>硬座&nbsp;"+train.getYzprice()+"元　(剩余"+train.getYzyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>硬座&nbsp;"+train.getYzprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>硬座&nbsp;"+train.getYzprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getYzprice());
		}
		
	
		
		if (isntNullorZero(train.getRzprice())) {//软座
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_2' type='radio' value='"+train.getRzprice()+","+train.getRzyp()+"' onclick='bookOrderchangeFirstSeat(this,2);'/>");
			if(train.getRzyp()!=null&&existSeat(train.getRzyp())){
			 int yp = Integer.valueOf(train.getRzyp());
				if(yp>0){
					builder.append("<span id='em_firstSeat_0'>软座&nbsp;"+train.getRzprice()+"元　(剩余"+train.getRzyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>软座&nbsp;"+train.getRzprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>软座&nbsp;"+train.getRzprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getRzprice());
		}
		
		
		if (isntNullorZero(train.getYwxprice())) {//硬卧
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_3' type='radio' value='"+train.getYwxprice()+","+train.getYwyp()+"' onclick='bookOrderchangeFirstSeat(this,3);'/>");
			if(train.getYwyp()!=null&&existSeat(train.getYwyp())){
			 int yp = Integer.valueOf(train.getYwyp());
				if(yp>0){
					builder.append("<span title='[卧铺上中下铺位是随机订位，暂收下铺价格，出票后根据实际票价退还差价。]' id='em_firstSeat_0'>硬卧&nbsp;"+train.getYwxprice()+"元　(剩余"+train.getYwyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>硬卧&nbsp;"+train.getYwxprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>硬卧&nbsp;"+train.getYwxprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getYwxprice());
		}
		
		if (isntNullorZero(train.getRwxprice())) {//软卧
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_4' type='radio' value='"+train.getRwxprice()+","+train.getRwyp()+"' onclick='bookOrderchangeFirstSeat(this,4);'/>");
			if(train.getRwyp()!=null&&existSeat(train.getRwyp())){
			 int yp = Integer.valueOf(train.getRwyp());
				if(yp>0){
					builder.append("<span title='[卧铺上中下铺位是随机订位，暂收下铺价格，出票后根据实际票价退还差价。]' id='em_firstSeat_0'>软卧&nbsp;"+train.getRwxprice()+"元　(剩余"+train.getRwyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>软卧&nbsp;"+train.getRwxprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>软卧&nbsp;"+train.getRwxprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getRwxprice());
		}
		
		
		
		if (isntNullorZero(train.getGwxprice())) {//高卧
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_5' type='radio' value='"+train.getGwxprice()+","+train.getGwyp()+"' onclick='bookOrderchangeFirstSeat(this,5);'/>");
			if(train.getGwyp()!=null&&existSeat(train.getGwyp())){
			 int yp = Integer.valueOf(train.getGwyp());
				if(yp>0){
					builder.append("<span title='[卧铺上中下铺位是随机订位，暂收下铺价格，出票后根据实际票价退还差价。]' id='em_firstSeat_0'>高卧&nbsp;"+train.getGwxprice()+"元　(剩余"+train.getGwyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>高卧&nbsp;"+train.getGwxprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>高卧&nbsp;"+train.getGwxprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getGwxprice());
		}
		
		if (isntNullorZero(train.getRz2price())) {//二等
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_6' type='radio' value='"+train.getRz2price()+","+train.getRz2yp()+"' onclick='bookOrderchangeFirstSeat(this,6);'/>");
			if(train.getRz2yp()!=null&&existSeat(train.getRz2yp())){
			 int yp = Integer.valueOf(train.getRz2yp());
				if(yp>0){
					builder.append("<span id='em_firstSeat_0'>二等&nbsp;"+train.getRz2price()+"元　(剩余"+train.getRz2yp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>二等&nbsp;"+train.getRz2price()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>二等&nbsp;"+train.getRz2price()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getRz2price());
		}
		
		if (isntNullorZero(train.getRz1price())) {//一等
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_7' type='radio' value='"+train.getRz1price()+","+train.getRz1yp()+"' onclick='bookOrderchangeFirstSeat(this,7);'/>");
			if(train.getRz1yp()!=null&&existSeat(train.getRz1yp())){
			 int yp = Integer.valueOf(train.getRz1yp());
				if(yp>0){
					builder.append("<span id='em_firstSeat_0'>一等&nbsp;"+train.getRz1price()+"元　(剩余"+train.getRz1yp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>一等&nbsp;"+train.getRz1price()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>一等&nbsp;"+train.getRz1price()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getRz1price());
		}
		
		if (isntNullorZero(train.getSwzprice())) {//商务
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_8' type='radio' value='"+train.getSwzprice()+","+train.getSwzyp()+"' onclick='bookOrderchangeFirstSeat(this,8);'/>");
			if(train.getSwzyp()!=null&&existSeat(train.getSwzyp())){
			 int yp = Integer.valueOf(train.getSwzyp());
				if(yp>0){
					builder.append("<span id='em_firstSeat_0'>商务&nbsp;"+train.getSwzprice()+"元　(剩余"+train.getSwzyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>商务&nbsp;"+train.getSwzprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>商务&nbsp;"+train.getSwzprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getSwzprice());
		}
		
		
		if (isntNullorZero(train.getTdzprice())) {//特等
			builder.append("<li>");
			builder.append("<input name='oSeat' id='firstSeat_9' type='radio' value='"+train.getTdzprice()+","+train.getTdzyp()+"' onclick='bookOrderchangeFirstSeat(this,9);'/>");
			if(train.getTdzyp()!=null&&existSeat(train.getTdzyp())){
			 int yp = Integer.valueOf(train.getTdzyp());
				if(yp>0){
					builder.append("<span id='em_firstSeat_0'>特等&nbsp;"+train.getTdzprice()+"元　(剩余"+train.getTdzyp()+"张)</span>");
				}else{
					builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>特等&nbsp;"+train.getTdzprice()+"元　(已经售完)</span>");
				}
			}else{
				builder.append("<span title='[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]' id='em_firstSeat_0'>特等&nbsp;"+train.getTdzprice()+"元　(已经售完)</span>");
			}
			builder.append("</li>");
			listprice.add(train.getTdzprice());
		}
		
		
		
		request.setAttribute("zwhtml", builder.toString());
		request.setAttribute("jszw", pwbuilder.toString());
		String oneprice="";
		if(listprice.get(0)!=null){
			request.setAttribute("oneprice", listprice.get(0));
		}
		
		
		return "toordertrain";

	}
	
	/**
	 * @return 到订单预定页面
	 */
	public String toordertrain_old() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println(train.getStartdate());
		session.setAttribute("ordertrain", train);
		StringBuilder builder = new StringBuilder("");
		StringBuilder pwbuilder = new StringBuilder("");
		System.out.println(train.getGwyp());
		if (existSeat(train.getGwyp())) {
			int yp = Integer.valueOf(train.getGwyp());
			if (yp > 0 && train.getGwxprice() > 0 && train.getGwsprice() > 0) {
				pwbuilder
						.append("<div id='daccept1' class='f'><input name='jszw' type=checkbox value='1'/>高级卧铺下</div>");
				pwbuilder
						.append("<div id='daccept2' class='f'><input name='jszw' type=checkbox value='2'/>高级卧铺上</div>");
				builder.append("<option value=\"{'type':1,price:"
						+ train.getGwxprice() + "}\">高级卧铺下"
						+ train.getGwxprice() + "</option>");
				builder.append("<option value=\"{'type':2,price:"
						+ train.getGwsprice() + "}\">高级卧铺上"
						+ train.getGwsprice() + "</option>");
			}
		}
		if (existSeat(train.getRwyp())) {
			int yp = Integer.valueOf(train.getRwyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept3' class='f'><input name='jszw' type=checkbox value='3'/>软卧下</div>");
				pwbuilder
						.append("<div id='daccept4' class='f'><input name='jszw' type=checkbox value='4'/>软卧上</div>");
				builder.append("<option value=\"{'type':3,'price':"
						+ train.getRwxprice() + "}\">软卧下" + train.getRwxprice()
						+ "</option>");
				builder.append("<option value=\"{'type':4,'price':"
						+ train.getRwsprice() + "}\">软卧上" + train.getRwsprice()
						+ "</option>");
			}
		}
		if (existSeat(train.getYwyp())) {
			int yp = Integer.valueOf(train.getYwyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept5' class='f'><input name='jszw' type=checkbox value='5'/>硬卧下</div>");
				pwbuilder
						.append("<div id='daccept6' class='f'><input name='jszw' type=checkbox value='6'/>硬卧上</div>");
				builder.append("<option value=\"{'type':5,'price':"
						+ train.getYwxprice() + "}\">硬卧下" + train.getYwxprice()
						+ "</option>");
				builder.append("<option value=\"{'type':6,'price':"
						+ train.getYwxprice() + "}\">硬卧上" + train.getYwsprice()
						+ "</option>");
			}

		}
		if (existSeat(train.getRzyp())) {
			int yp = Integer.valueOf(train.getRzyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept7' class='f'><input name='jszw' type=checkbox value='7'/>普通软座</div>");
				builder.append("<option value=\"{'type':7,'price':"
						+ train.getRzprice() + "}\">普通软座" + train.getRzprice()
						+ "</option>");
			}
		}
		if (existSeat(train.getRz1yp())) {
			int yp = Integer.valueOf(train.getRz1yp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept8' class='f'><input name='jszw' type=checkbox value='8'/>一等座</div>");
				builder.append("<option value=\"{'type':8,'price':"
						+ train.getRz1price() + "}\">一等座"
						+ train.getRz1price() + "</option>");
			}
		}
		if (existSeat(train.getRz2yp())) {
			int yp = Integer.valueOf(train.getRz2yp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept9' class='f'><input name='jszw' type=checkbox value='9'/>二等座</div>");
				builder.append("<option value=\"{'type':9,'price':"
						+ train.getRz2price() + "}\">二等座"
						+ train.getRz2price() + "</option>");
			}
		}
		if (existSeat(train.getSwzyp())) {
			int yp = Integer.valueOf(train.getSwzyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept9' class='f'><input name='jszw' type=checkbox value='12'/>商务座</div>");
				builder.append("<option value=\"{'type':12,'price':"
						+ train.getSwzprice() + "}\">商务座"
						+ train.getSwzprice() + "</option>");
			}
		}
		if (existSeat(train.getTdzyp())) {
			int yp = Integer.valueOf(train.getTdzyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept9' class='f'><input name='jszw' type=checkbox value='13'/>特等座</div>");
				builder.append("<option value=\"{'type':13,'price':"
						+ train.getTdzprice() + "}\">特等座"
						+ train.getTdzprice() + "</option>");
			}
		}
		
		if (existSeat(train.getYzyp())) {
			int yp = Integer.valueOf(train.getYzyp());
			if (yp > 0) {
				pwbuilder
						.append("<div id='daccept10' class='f'><input name='jszw' type=checkbox value='10'/>硬座</div>");
				builder.append("<option value=\"{'type':10,'price':"
						+ train.getYzprice() + "}\">硬座" + train.getYzprice()
						+ "</option>");
			}
		}

		if (train.getWzyp() != null && train.getWzyp().equals("有")) {
			pwbuilder
					.append("<div id='d10' class='f'><input name='jszw' type=checkbox value='11'/>无座</div>");
			builder.append("<option value=\"{'type':11,'price':"
					+ train.getYzprice() + "}\">无座" + train.getYzprice()
					+ "</option>");
		}
		request.setAttribute("zwhtml", builder.toString());
		request.setAttribute("jszw", pwbuilder.toString());
		return "toordertrain";

	}
	/**
	 * 预定车票 生成订单
	 * 
	 * @return
	 */
	public String ordertrain() {
		
		int pnum=0;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String[] pnames1 = request.getParameterValues("pname");
		if (pnames1 != null && pnames1.length > 0) {
			for (int i = 0; i < pnames1.length; i++) {
				if(pnames1[i]!=null&&pnames1[i].trim().length()>0){
					pnum++;
					}
				}
				
			}
		
		
		
		HttpSession session = request.getSession();
		Train ordertrain = (Train) session.getAttribute("ordertrain");
		session.removeAttribute("ordertrain");
		session.removeAttribute("orderuserlogin");
		String oneprice = request.getParameter("trainprice");
		ordertrain.setCreatetime(new Timestamp(System.currentTimeMillis()));
		ordertrain.setStartdate(train.getStartdate());
		ordertrain.setOrderstatus(1);// 未支付
		ordertrain.setCreateuid(this.getLoginUserId());// 预订人
		ordertrain.setMemberid(0);// 会员ID，流程更改，已无用
		ordertrain.setAgentid(this.getLoginUser().getAgentid());// 网站散客
		ordertrain.setTotalprice(Float.valueOf(oneprice.trim())*pnum);
		ordertrain.setBooktype(train.getBooktype());
		ordertrain.setQptype(train.getQptype());
		ordertrain.setSeattype(train.getSeattype());
		ordertrain.setDeliverytypeval(train.getDeliverytypeval());
		if(ordertrain.getQptype()==1){
			ordertrain.setContactname(train.getContactname());
			ordertrain.setContactmobile(train.getContactmobile());
			ordertrain.setPsprice(0);
			ordertrain.setUserid("-1");
		}else{
			ordertrain.setContactname(peisong_name);
			ordertrain.setContactmobile(peisong_tel);
			ordertrain.setDeliveryadd(cmbProvince+"-"+cmbCity+"-"+cmbArea+"-"+address);//地址
			ordertrain.setPost(peisong_post);
			ordertrain.setPsprice(20+5);
			String where =" where 1=1 and "+Customeruser.COL_description+" like '%"+cmbProvince+"%'";
			List<Customeruser>listuser=Server.getInstance().getMemberService().findAllCustomeruser(where, " ORDER BY ID DESC ", -1, 0);
			if(listuser!=null&&listuser.size()>0){
				ordertrain.setUserid(listuser.get(0).getId()+"");
			}
			
			
			
		}
		
		
		ordertrain.setSeattype(train.getSeattype());
		ordertrain.setDeliverytype(train.getDeliverytype());
		
		ordertrain.setCount(pnum);
		ordertrain.setMemo(train.getMemo());
		ordertrain.setPaymethod(1);// 网上支付
		ordertrain.setPaystatus(1);// 未支付
		String[] acceptseats = request.getParameterValues("jszw");
		if (acceptseats != null && acceptseats.length > 0) {
			StringBuilder accept = new StringBuilder();
			for (String s : acceptseats) {
				if (accept.length() > 0) {
					accept.append(",");
				}
				accept.append(s);
			}
			ordertrain.setAcceptseat(accept.toString());
		}

		try {
			this.installService();
			ordertrain = this.trainservice.createTrain(ordertrain);
			String ordernumber = Server.getInstance().getServiceCenter()
					.getTrainCode(ordertrain);
			ordernumber="T"+(ordertrain.getId()+10000);
			ordertrain.setOrdernumber(ordernumber);
			
			ordertrain.setOrdernumber(ordernumber);
			trainservice.updateTrainIgnoreNull(ordertrain);
			String[] pnames = request.getParameterValues("pname");
			if (pnames != null && pnames.length > 0) {
				String[] idtypes = request.getParameterValues("idtype");
				String[] idnumbers = request.getParameterValues("idnumber");
				String[] passtype = request.getParameterValues("passtype");
				for (int i = 0; i < pnames.length; i++) {
					String pname = pnames[i];
					if (pname.trim().length() > 0) {
						String idtype = idtypes[i];
						String idnumber = idnumbers[i];
						Trainpassenger passenger = new Trainpassenger();
						passenger.setName(pname);
						System.out.println(ordertrain.getId());
						passenger.setOrderid(ordertrain.getId());
						passenger.setIdtype(Integer.valueOf(idtype));
						passenger.setIdnumber(idnumber);
						passenger.setState(Integer.parseInt(passtype[i].trim()));//成人类型
						passenger.setBxprice(baoxianprice);
						passenger.setPrice(Float.valueOf(oneprice.trim()));
						
						this.trainservice.createTrainpassenger(passenger);
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.train = ordertrain;
		session.setAttribute("ordertrain", train);
		this.forword = "http://" + request.getServerName() + ":"
				+ request.getServerPort()
				+ "/interface/Alipay?helpername=Trainpayhelper&orderid="
				+ train.getId();
		return "orderpay";
	}
	/**
	 * 预定车票 生成订单
	 * 
	 * @return
	 */
	public String ordertrain_old() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Train ordertrain = (Train) session.getAttribute("ordertrain");
		session.removeAttribute("ordertrain");
		session.removeAttribute("orderuserlogin");
		String totalprice = request.getParameter("frometo");
		ordertrain.setCreatetime(this.getCurrentTime());
		ordertrain.setOrderstatus(1);// 未支付
		ordertrain.setCreateuid(this.getLoginUserId());// 预订人
		ordertrain.setMemberid(0);// 会员ID，流程更改，已无用
		ordertrain.setAgentid(this.getLoginsessionagent().getId());// 网站散客
		ordertrain.setTotalprice(Float.valueOf(totalprice.trim()));
		ordertrain.setQptype(train.getQptype());
		ordertrain.setSeattype(train.getSeattype());
		if(ordertrain.getQptype()==1){
			ordertrain.setContactname(train.getContactname());
			ordertrain.setContactmobile(train.getContactmobile());
		}else{
			ordertrain.setContactname(peisong_name);
			ordertrain.setContactmobile(peisong_tel);
			ordertrain.setDeliveryadd(cmbProvince+cmbCity+cmbArea+address);//地址
			ordertrain.setPost(peisong_post);
			ordertrain.setPsprice(20);
		}
		
		ordertrain.setDeliverytype(train.getDeliverytype());
		
		
		ordertrain.setCount(train.getCount());
		ordertrain.setMemo(train.getMemo());
		ordertrain.setPaymethod(1);// 网上支付
		ordertrain.setPaystatus(1);// 未支付
		String[] acceptseats = request.getParameterValues("jszw");
		if (acceptseats != null && acceptseats.length > 0) {
			StringBuilder accept = new StringBuilder();
			for (String s : acceptseats) {
				if (accept.length() > 0) {
					accept.append(",");
				}
				accept.append(s);
			}
			ordertrain.setAcceptseat(accept.toString());
		}

		try {
			this.installService();
			ordertrain = this.trainservice.createTrain(ordertrain);
			String ordernumber = Server.getInstance().getServiceCenter()
					.getTrainCode(ordertrain);
			ordernumber="T"+(ordertrain.getId()+10000);
			ordertrain.setOrdernumber(ordernumber);
			trainservice.updateTrainIgnoreNull(ordertrain);
			String[] pnames = request.getParameterValues("pname");
			if (pnames != null && pnames.length > 0) {
				String[] idtypes = request.getParameterValues("idtype");
				String[] idnumbers = request.getParameterValues("idnumber");
				for (int i = 0; i < pnames.length; i++) {
					String pname = pnames[i];
					if (pname.trim().length() > 0) {
						String idtype = idtypes[i];
						String idnumber = idnumbers[i];
						Trainpassenger passenger = new Trainpassenger();
						passenger.setName(pname);
						System.out.println(ordertrain.getId());
						passenger.setOrderid(ordertrain.getId());
						passenger.setIdtype(Integer.valueOf(idtype));
						passenger.setIdnumber(idnumber);
						
						this.trainservice.createTrainpassenger(passenger);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.train = ordertrain;
		session.setAttribute("ordertrain", train);
		this.forword = "http://" + request.getServerName() + ":"
				+ request.getServerPort()
				+ "/interface/Alipay?helpername=Trainpayhelper&orderid="
				+ train.getId();
		return "orderpay";
	}

	public String ordersuccess() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		this.train = (Train) session.getAttribute("ordertrain");
		
		train=Server.getInstance().getTrainService().findTrain(train.getId());
		trainpassengerlist=new ArrayList<Trainpassenger>();
		trainpassengerlist=Server.getInstance().getTrainService().findAllTrainpassenger(" WHERE 1=1 AND "+Trainpassenger.COL_orderid+" ="+train.getId(), " ORDER BY ID ", -1, 0);
		//session.removeAttribute("ordertrain");
		
		int bxprice=0;
		int psprice=0;
		List<Trainpassenger>list=new ArrayList<Trainpassenger>();
		list=Server.getInstance().getTrainService().findAllTrainpassenger(" WHERE 1=1 AND "+Trainpassenger.COL_orderid+" ="+train.getId(), " order by id ", -1, 0);
		if(list!=null&&list.size()>0){
			for(int a=0;a<list.size();a++){
				if(list.get(a).getBxprice()>0){
				bxprice+=list.get(a).getBxprice();
				}
			}
		}
		if(train.getPsprice()>0){
			psprice=train.getPsprice();
		}
		System.out.println(bxprice+","+psprice);
		allprice=(train.getTotalprice()+bxprice+psprice);
		allbxprice=bxprice;
		
		
		return "ordersuccess";
	}
	public String toorder() {
		
		
		train=Server.getInstance().getTrainService().findTrain(Long.parseLong(strOrderID));
		trainpassengerlist=new ArrayList<Trainpassenger>();
		trainpassengerlist=Server.getInstance().getTrainService().findAllTrainpassenger(" WHERE 1=1 AND "+Trainpassenger.COL_orderid+" ="+train.getId(), " ORDER BY ID ", -1, 0);
		//session.removeAttribute("ordertrain");
		
		int bxprice=0;
		int psprice=0;
		List<Trainpassenger>list=new ArrayList<Trainpassenger>();
		list=Server.getInstance().getTrainService().findAllTrainpassenger(" WHERE 1=1 AND "+Trainpassenger.COL_orderid+" ="+train.getId(), " order by id ", -1, 0);
		if(list!=null&&list.size()>0){
			for(int a=0;a<list.size();a++){
				if(list.get(a).getBxprice()>0){
				bxprice+=list.get(a).getBxprice();
				}
			}
		}
		if(train.getPsprice()>0){
			psprice=train.getPsprice();
		}
		System.out.println(bxprice+","+psprice);
		allprice=(train.getTotalprice()+bxprice+psprice);
		allbxprice=bxprice;
		
		
		return "ordersuccess";
	}
	public String toPay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.forword = "http://" + request.getServerName() + ":"
				+ request.getServerPort()
				+ "/interface/Alipay?helpername=Trainpayhelper&orderid="
				+ train.getId();
		System.out.println(forword);
		return "orderpay";
	}

	/**
	 * 火车票订单列表
	 * 
	 * @return
	 */
	public String trainorder() {
		this.installService();
		HttpServletRequest request = ServletActionContext.getRequest();
		Customeragent loginagent = this.getLoginsessionagent();
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		if(getLoginAgent().getAgenttype()==3){
			where.append(" AND C_AGENTID="+getLoginAgent().getId()+" AND C_AGENTID in( SELECT "+Customeragent.COL_id+" FROM "+Customeragent.TABLE+" WHERE "+Customeragent.COL_parentid+"="+getLoginAgent().getId()+" )");
		}
		if(getLoginAgent().getAgenttype()==2&&getLoginUser().getIsadmin()!=1){
			where.append(" AND C_USERID="+getLoginUser().getId());
		}
		
		if (isNotNullOrEpt(s_code)) {
			where.append(" AND C_TRAINCODE LIKE '%" + s_code
					+ "%'");
		}
		if (isNotNullOrEpt(s_ordercode)) {
			where.append(" AND C_ORDERNUMBER LIKE '%" + s_ordercode
					+ "%'");
		}
		if (isNotNullOrEpt(s_name)) {
			where.append(" AND "+Train.COL_id+" IN ( SELECT "+Trainpassenger.COL_orderid+" FROM "+Trainpassenger.TABLE+" where "+Trainpassenger.COL_name+" like '%"+s_name+"%' )" );
		}
		
		if (s_orderstatus > -2) {
			where.append(" AND C_ORDERSTATUS=" + s_orderstatus);
		}
		String createtime = this.getCheckTime(this.startcreatetime,
				this.endcreatetime, "C_CREATETIME");
		if (isNotNullOrEpt(createtime)) {
			where.append(" AND  (" + createtime + ")");
		}
		
		if(s_qupiaotype>-1){
			
			where.append(" AND "+Train.COL_qptype+" =" + s_qupiaotype);
			
		}
		
		
		
		
		System.out.println("where:"+where);
		
		List list = trainservice.findAllTrainForPageinfo(where.toString(),
				" ORDER BY ID DESC ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		this.trainlist = list;
		agentroot = new CustomeragentAction().getAgentRoot();
		if (this.getLoginUserAgent().getAgenttype() == 1) {
			agentroot += this.getAgentRootreplenish();
		}
		System.out
				.println("train!trainorder.action/train:trainorderrecord.jsp");
		
		
		
		listuser=Server.getInstance().getMemberService().findAllCustomeruser(" WHERE 1=1 AND "+Customeruser.COL_agentid+" =60 AND "+Customeruser.COL_isadmin+" !=1", " ORDER BY ID DESC ", -1, 0);
		if(listuser==null||listuser.size()==0){
			listuser=Server.getInstance().getMemberService().findAllCustomeruser(" WHERE 1=1 AND "+Customeruser.COL_agentid+" ="+getLoginUser().getAgentid()+" AND "+Customeruser.COL_isadmin+" !=1", " ORDER BY ID DESC ", -1, 0);
		}
		
		return "trainorder";
	}

	public String trainreport() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String sql="SELECT * FROM view_trainorderrebate   ";
		List list=Server.getInstance().getSystemService().findMapResultSortBySql(sql, " ORDER BY ID DESC ", pageinfo);
		pageinfo=(PageInfo)list.remove(0);
		request.setAttribute("trainrebatelist", list);
		
		
		
		
		

		System.out
				.println("train!trainreport.action/report:trainrebatreport.jsp");
		return "trainreport";
	}

	public String processOrder() {
		this.installService();
		int orderstatus = train.getOrderstatus();
		if(orderstatus==5){
			Train ctrain=this.trainservice.findTrain(train.getId());
			if(ctrain.getAgentid()==46&&ctrain.getMemberid()!=1){
				Server.getInstance().getAtomService().createTrainrebate(ctrain);
			}
		}
		
		if (orderstatus > 0) {
			this.trainservice.updateTrainIgnoreNull(train);
		}
		return this.trainorder();
	}

	/**
	 * 订单详细信息
	 * 
	 * @return
	 */
	public String orderdetail() {
		this.installService();
		this.train = trainservice.findTrain(train.getId());
		String acceptseat = train.getAcceptseat();
		
		this.trainpassengerlist = trainservice.findAllTrainpassenger(
				"WHERE C_ORDERID=" + train.getId(), "", -1, 0);
		
		for(int a=0;a<trainpassengerlist.size();a++){
			allbxprice+=trainpassengerlist.get(a).getBxprice();
		}
		listsms=Server.getInstance().getMemberService().findAllYmsend(" WHERE 1=1 AND "+Ymsend.COL_type+" ='3' AND "+Ymsend.COL_ordercode+" ='"+train.getId()+"'", " ORDER BY ID DESC ", -1, 0);
		
		
		return "orderdetail";
	}

	public String getAgentRootreplenish() {

		return "var root_0=new Ext.tree.TreeNode({text:\"网站散客\",id:'0'});root.appendChild(root_0)";
	}

	/**
	 * 列车坐席价格
	 * 
	 * @param train
	 * @return
	 */
	public String getTicketPriceHtml(Train train) {
			
		StringBuilder pricehtml = new StringBuilder("");
		if (isntNullorZero(train.getYzprice())) {
			pricehtml.append("硬座：￥" + train.getYzprice() + "元");
		}
		if (isntNullorZero(train.getYwsprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("硬卧：￥" + train.getYwsprice() + "/"
					+ train.getYwzprice() + "/" + train.getYwxprice() + "元");
		}
		if (isntNullorZero(train.getRzprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("普通软坐：￥" + train.getRzprice() + "元");
		}
		if (isntNullorZero(train.getRz2price())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("二等：￥" + train.getRz2price() + "元");
		}
		if (isntNullorZero(train.getRz1price())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("一等：￥" + train.getRz1price() + "元");
		}
		if (isntNullorZero(train.getSwzprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("商务座：￥" + train.getSwzprice() + "元");
		}
		if (isntNullorZero(train.getTdzprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("特等座：￥" + train.getTdzprice() + "元");
		}
		if (isntNullorZero(train.getRwsprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("软卧：￥" + train.getRwsprice() + "/"
					+ train.getRwxprice() + "元");
		}
		if (isntNullorZero(train.getGwsprice())) {
			if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}
			pricehtml.append("高级软卧：￥" + train.getGwsprice() + "/"
					+ train.getGwxprice() + "元");
		}
		return pricehtml.toString();
	}
	public String getTicketPriceHtml_new(Train train) {
		StringBuilder pricehtml = new StringBuilder("<table  cellspacing='0' cellpadding='1' align='center' style='width:100%'>");
		//StringBuilder pricehtml = new StringBuilder("");
		if (isntNullorZero(train.getYzprice())) {
			pricehtml.append("<tr><td>");
			pricehtml.append("硬座：￥<b>" + train.getYzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getYwsprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("硬卧：￥<b>" + train.getYwsprice() + "/"
					+ train.getYwzprice() + "/" + train.getYwxprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRzprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("软坐：￥<b>" + train.getRzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRz2price())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("二等：￥<b>" + train.getRz2price() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRz1price())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("一等：￥<b>" + train.getRz1price() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getSwzprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("商务：￥<b>" + train.getSwzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getTdzprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("特等：￥<b>" + train.getTdzprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getRwsprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("软卧：￥<b>" + train.getRwsprice() + "/"
					+ train.getRwxprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		if (isntNullorZero(train.getGwsprice())) {
			/*if (pricehtml.length() > 0) {
				pricehtml.append("<br/>");
			}*/
			pricehtml.append("<tr><td>");
			pricehtml.append("高级软卧：￥<b>" + train.getGwsprice() + "/"
					+ train.getGwxprice() + "元</b>");
			pricehtml.append("</td></tr>");
		}
		pricehtml.append("</table>");
		
		System.out.println(pricehtml.toString());
		
		return pricehtml.toString();
	}
	private boolean isntNullorZero(Float value) {
		if (value == null || value == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 根据余票显示不同颜色坐席
	 * 
	 * @param yp
	 * @param price
	 * @param info
	 * @return
	 */
	public String getTrainpriceByYP(String yp, Float price, String info) {
		System.out.println(yp + "|" + price + "|" + info);
		try {
			int ypcount = Integer.valueOf(yp);
			if (ypcount > 0) {
				return "<font style='color:#3582c8' >" + info + price + "("
						+ yp + ")</font>";
			} else {
				return "<font style='color:#ccc'>" + info + price + "</font>";
			}
		} catch (Exception e) {
			return "<font style='color:#ccc'>--</font>";
		}

	}

	public boolean existSeat(String yp) {
		try {
			Integer.parseInt(yp);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean hasYP(Train train) {
		int yp = 0;
		// try {
		// if (train.getWzyp().trim().equals("有")) {
		// return true;
		// }
		// } catch (Exception e) {
		//
		// }
		try {
			yp = Integer.valueOf(train.getYzyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getYwyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}

		try {
			yp = Integer.valueOf(train.getRz2yp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getRz1yp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getRzyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getRwyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		try {
			yp = Integer.valueOf(train.getGwyp().trim());
			if (yp > 0) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	public String GetYongShi(String stime,String etime) {
		long minute1=0l;
		try {
			SimpleDateFormat dfs = new SimpleDateFormat("HH:mm");
			java.util.Date begin=dfs.parse(stime);
			java.util.Date end = dfs.parse(etime);
			long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒

			long day1=between/(24*3600);
			long hour1=between%(24*3600)/3600;
			minute1 = between%3600/60;
			long second1=between%60/60;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
		
		return minute1+"";
		
		
	}
	
	public void ajaxGetTrainInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");

		String traincode = request.getParameter("traincode");
		String date = request.getParameter("startdate");
		List<Map<String, String>> listmap = Server.getInstance()
				.getAtomService().getTrainInfo(traincode, date);
		StringBuilder htmlbuilder = new StringBuilder("");
		htmlbuilder.append("<table  cellspacing='0' cellpadding='1' align='center' style='width:100%'><tr>");
		int i = 0;
		for (Map<String, String> map : listmap) {
			htmlbuilder.append("<td>"+map.get("sname")+"<br />");
			if(i==0&&map.get("arrtime").equals(map.get("gotime"))){
				htmlbuilder.append("<span class='color'>发时:"+map.get("gotime")+"</span><br />");
			}else if(i!=0&&map.get("arrtime").equals(map.get("gotime"))){
				htmlbuilder.append("<span class='color'>到时:"+map.get("gotime")+"</span><br />");
			}else{
			htmlbuilder.append("<span class='color'>"+map.get("arrtime")+"—"+map.get("gotime")+"</span><br />");
			htmlbuilder.append("<span class='color'>停"+GetYongShi(map.get("arrtime"),map.get("gotime"))+"分</span>");
			}
			
			htmlbuilder.append("</td>");
			i++;
			if(i==8||i==16||i==24||i==32){
				htmlbuilder.append("</tr><tr>");
				System.out.println("??????????????????");

			}
			
		}
		htmlbuilder.append("</tr></table>");
		try {
			System.out.println(htmlbuilder.toString());
			PrintWriter out = response.getWriter();
			out.print(htmlbuilder.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ajaxGetTrainInfo2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");

		String traincode = request.getParameter("traincode");
		String date = request.getParameter("startdate");
		List<Map<String, String>> listmap = Server.getInstance()
				.getAtomService().getTrainInfo(traincode, date);
		StringBuilder htmlbuilder = new StringBuilder("");
		htmlbuilder.append("showTrainInfo(new Array(");
		int i = 0;
		for (Map<String, String> map : listmap) {
			if (i != 0) {
				htmlbuilder.append(",");
			}
			htmlbuilder.append("{");
			htmlbuilder.append("'sno':'" + map.get("sno") + "',");
			htmlbuilder.append("'sname':'" + map.get("sname") + "',");
			htmlbuilder.append("'arrtime':'" + map.get("arrtime") + "',");
			htmlbuilder.append("'gotime':'" + map.get("gotime") + "',");
			htmlbuilder.append("'costtime':'" + map.get("costtime") + "',");
			htmlbuilder.append("'distance':'" + map.get("distance") + "',");
			htmlbuilder.append("'yz':'" + map.get("yz") + "',");
			// htmlbuilder.append("'rz':'"+map.get("rz")+"',");
			// htmlbuilder.append("'rz1':'"+map.get("rz1")+"',");
			htmlbuilder.append("'rz2':'" + map.get("rz2") + "',");
			htmlbuilder.append("'yws':'" + map.get("yws") + "',");
			htmlbuilder.append("'ywz':'" + map.get("ywz") + "',");
			htmlbuilder.append("'ywx':'" + map.get("ywx") + "'");
			// htmlbuilder.append("'rws':'"+map.get("rws")+"',");
			// htmlbuilder.append("'rwx':'"+map.get("rwx")+"'");
			htmlbuilder.append("}");
			i++;
		}
		htmlbuilder.append("));");
		try {
			System.out.println(htmlbuilder.toString());
			PrintWriter out = response.getWriter();
			out.print(htmlbuilder.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void installService() {
		if (trainservice == null) {
			this.trainservice = Server.getInstance().getTrainService();
		}
	}

	/**
	 * 转向到火车时刻表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}
	
	/**
	 * 转向到火车时刻表修改页面
	 */
	public String toedit() throws Exception {
		
		this.installService();
		this.train = trainservice.findTrain(train.getId());
		String acceptseat = train.getAcceptseat();
		
		this.trainpassengerlist = trainservice.findAllTrainpassenger(
				"WHERE C_ORDERID=" + train.getId(), "", -1, 0);
		
		for(int a=0;a<trainpassengerlist.size();a++){
			allbxprice+=trainpassengerlist.get(a).getBxprice();
		}
		return "toedit";
	}
	/**
	 * 转向到火车时刻表修改页面
	 */
	public String edit_trainorder() throws Exception {
		
		this.installService();
		//this.train = trainservice.findTrain(train.getId());
	
		trainservice.updateTrainIgnoreNull(train);
		this.train = trainservice.findTrain(train.getId());
		forword="train!toedit.action?id="+train.getId();
		return "forword";
	}
	
	public String edit_order() throws Exception {
		
		this.installService();
		this.train = trainservice.findTrain(train.getId());
		train.setOrderstatus(s_orderstatus);
		trainservice.updateTrainIgnoreNull(train);
		
		return this.trainorder();
	}
	/**
	 * 返回火车时刻表对象
	 */

	public Object getModel() {
		return train;
	}

	public List<Train> getListTrain() {
		return listTrain;
	}

	public void setListTrain(List<Train> listTrain) {
		this.listTrain = listTrain;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public List<Train> getTrainlist() {
		return trainlist;
	}

	public void setTrainlist(List<Train> trainlist) {
		this.trainlist = trainlist;
	}

	public String getAgentroot() {
		return agentroot;
	}

	public void setAgentroot(String agentroot) {
		this.agentroot = agentroot;
	}

	public String getEndcreatetime() {
		return endcreatetime;
	}

	public void setEndcreatetime(String endcreatetime) {
		this.endcreatetime = endcreatetime;
	}

	public String getStartcreatetime() {
		return startcreatetime;
	}

	public void setStartcreatetime(String startcreatetime) {
		this.startcreatetime = startcreatetime;
	}

	public List<Trainpassenger> getTrainpassengerlist() {
		return trainpassengerlist;
	}

	public void setTrainpassengerlist(List<Trainpassenger> trainpassengerlist) {
		this.trainpassengerlist = trainpassengerlist;
	}

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public int getBaoxianprice() {
		return baoxianprice;
	}

	public void setBaoxianprice(int baoxianprice) {
		this.baoxianprice = baoxianprice;
	}

	public ITrainService getTrainservice() {
		return trainservice;
	}

	public void setTrainservice(ITrainService trainservice) {
		this.trainservice = trainservice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCmbProvince() {
		return cmbProvince;
	}

	public void setCmbProvince(String cmbProvince) {
		this.cmbProvince = cmbProvince;
	}

	public String getCmbCity() {
		return cmbCity;
	}

	public void setCmbCity(String cmbCity) {
		this.cmbCity = cmbCity;
	}

	public String getCmbArea() {
		return cmbArea;
	}

	public void setCmbArea(String cmbArea) {
		this.cmbArea = cmbArea;
	}

	public String getPeisong_name() {
		return peisong_name;
	}

	public void setPeisong_name(String peisong_name) {
		this.peisong_name = peisong_name;
	}

	public String getPeisong_tel() {
		return peisong_tel;
	}

	public void setPeisong_tel(String peisong_tel) {
		this.peisong_tel = peisong_tel;
	}

	public String getPeisong_post() {
		return peisong_post;
	}

	public void setPeisong_post(String peisong_post) {
		this.peisong_post = peisong_post;
	}

	public Float getAllprice() {
		return allprice;
	}

	public void setAllprice(Float allprice) {
		this.allprice = allprice;
	}

	public int getAllbxprice() {
		return allbxprice;
	}

	public void setAllbxprice(int allbxprice) {
		this.allbxprice = allbxprice;
	}



	public int getS_orderstatus() {
		return s_orderstatus;
	}

	public void setS_orderstatus(int s_orderstatus) {
		this.s_orderstatus = s_orderstatus;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_code() {
		return s_code;
	}

	public void setS_code(String s_code) {
		this.s_code = s_code;
	}

	public String getS_ordercode() {
		return s_ordercode;
	}

	public void setS_ordercode(String s_ordercode) {
		this.s_ordercode = s_ordercode;
	}

	public int getS_qupiaotype() {
		return s_qupiaotype;
	}

	public void setS_qupiaotype(int s_qupiaotype) {
		this.s_qupiaotype = s_qupiaotype;
	}

	public String getStrOrderID() {
		return strOrderID;
	}

	public void setStrOrderID(String strOrderID) {
		this.strOrderID = strOrderID;
	}
	public List<Province> getListProvince() {
		return listProvince;
	}
	public void setListProvince(List<Province> listProvince) {
		this.listProvince = listProvince;
	}
	public String getS_userid() {
		return s_userid;
	}
	public void setS_userid(String s_userid) {
		this.s_userid = s_userid;
	}
	public int[] getSelectid() {
		return selectid;
	}
	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}
	public List<Customeruser> getListuser() {
		return listuser;
	}
	public void setListuser(List<Customeruser> listuser) {
		this.listuser = listuser;
	}
	public String getS_kdcomname() {
		return s_kdcomname;
	}
	public void setS_kdcomname(String s_kdcomname) {
		this.s_kdcomname = s_kdcomname;
	}
	public String getS_kdcode() {
		return s_kdcode;
	}
	public void setS_kdcode(String s_kdcode) {
		this.s_kdcode = s_kdcode;
	}
	public String getS_kddesc() {
		return s_kddesc;
	}
	public void setS_kddesc(String s_kddesc) {
		this.s_kddesc = s_kddesc;
	}
	public List<Ymsend> getListsms() {
		return listsms;
	}
	public void setListsms(List<Ymsend> listsms) {
		this.listsms = listsms;
	}

}