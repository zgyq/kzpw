/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.tousu.Tousu;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;


public class TousuAction extends B2b2cbackAction {
	private List <  Tousu  >  listTousu;
	private Tousu tousu = new Tousu();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private String s_starttime;//航班时间
	private String s_happentime;//事发时间
	//保存投诉内容
	private String content;
	//保存反馈信息列表
	private List fankuilist;
	//保存时间范围
	private String begintime;
	private String endtime;
	private Long tid;
	
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public List getFankuilist() {
		return fankuilist;
	}
	public void setFankuilist(List fankuilist) {
		this.fankuilist = fankuilist;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getS_starttime() {
		return s_starttime;
	}
	public void setS_starttime(String s_starttime) {
		this.s_starttime = s_starttime;
	}
	public String getS_happentime() {
		return s_happentime;
	}
	public void setS_happentime(String s_happentime) {
		this.s_happentime = s_happentime;
	}
	/**
	 * 添加消息反馈信息
	 * @return
	 * 赵晓晓
	 */
	public void getreturnmessage(){
		
		try {
			//获得投诉内容
			tousu.setComment(content);
			//获得添加时间
			tousu.setCreatetime(new Timestamp(System.currentTimeMillis()));
			//获得登录人编号从session中获得
			HttpSession session = ServletActionContext.getRequest().getSession();
			Customeruser customer=new Customeruser();
			customer=(Customeruser)session.getAttribute("loginuser");
			Long id=customer.getId();
			tousu.setUsername(id.toString());
			//获得代理编号
			Customeragent customeragent=new Customeragent();
			customeragent=(Customeragent)session.getAttribute("loginagent");
			Long Agentid=customeragent.getId();
			tousu.setDainame(Agentid.toString());
			Server.getInstance().getMemberService().createTousu(tousu);
			System.out.println("添加投诉信息成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("添加失败！");
		}
		
	}
	/**
	 * 查询消息反馈信息列表
	 * 赵晓晓
	 */
	public String showfklist(){
		String where = " where 1=1 ";
		StringBuilder sb=new StringBuilder("");
		if(begintime!=null&&!begintime.equals("")&&endtime!=null&&!endtime.equals("")){
			sb.append(" and C_CREATETIME between '"+begintime+"' and '"+endtime+"'");
		}
		List list = Server.getInstance().getMemberService().findAllTousuForPageinfo(where+sb," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		fankuilist = list;
		  if(pageinfo.getTotalrow()>0 &&   fankuilist.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllTousuForPageinfo(where+sb," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			fankuilist = list;
		}
		return "showfklist";
	}
	public String getfkname(Long id){
		Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(id);
		return customeruser != null && !"".equals(customeruser.getLoginname()) ? customeruser.getLoginname() : "";
	}
	/**
	 * 查看详情
	 * 赵晓晓
	 */
	public String searchfk(){
		tousu = Server.getInstance().getMemberService().findTousu(this.getTid());
		return "searchfk";
	}
	/**
	 * 列表查询投诉建议表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Tousu.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllTousuForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTousu = list;
		  if(pageinfo.getTotalrow()>0 &&   listTousu.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllTousuForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTousu = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到投诉建议表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到投诉建议表修改页面
	 */	
	public String toedit()throws Exception{
	    tousu = Server.getInstance().getMemberService().findTousu(tousu.getId());
		return EDIT;
	}
	
	/**
	 * 转向到投诉建议表审核页面
	 */	
	public String tocheck()throws Exception{
	tousu = Server.getInstance().getMemberService().findTousu(tousu.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加投诉建议表
	 */		
	public String add()throws Exception{
	tousu.setCreatetime(new Timestamp(System.currentTimeMillis()));
	tousu.setStarttime(dateToTimestamp(s_starttime));
	tousu.setHappentime(dateToTimestamp(s_happentime));	
		Server.getInstance().getMemberService().createTousu(tousu);
		return LIST;
	}

	/**
	 * 审核投诉建议表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateTousuIgnoreNull(tousu);
		return LIST;
	}
	


	/**
	 * 编辑投诉建议表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateTousuIgnoreNull(tousu);
		return LIST;
	}

	/**
	 * 删除投诉建议表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteTousu(tousu.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getMemberService().deleteTousu(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回投诉建议表对象
	 */		
	
	public Object getModel() {
		return tousu;
	}
	public List < Tousu >   getListTousu() {
		return listTousu;
	}
	public void setListTousu(List <  Tousu  >  listTousu) {
		this.listTousu = listTousu;
	}
	public Tousu getTousu() {
		return tousu;
	}
	public void setTousu(Tousu tousu) {
		this.tousu = tousu;
	}
	
	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}
	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}
	
	
}