/**
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.bussiness.Bussiness;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.liudianrecord.Liudianrecord;
import com.yf.system.base.liudianrefinfo.Liudianrefinfo;
import com.yf.system.base.settlementtype.Settlementtype;
import com.opensymphony.webwork.ServletActionContext;

public class LiudianrefinfoAction extends B2b2cbackAction {
	private List<Liudianrefinfo> listLiudianrefinfo;
	private Liudianrefinfo liudianrefinfo = new Liudianrefinfo();

	private List<Liudianrecord> listrecord;

	private List<Settlementtype> listsettle;

	private List<Bussiness> listbussiness;
	private long lagentid;

	// 批量操作ID数组
	private int[] selectid;

	private String s_fandianstart;
	private String s_fandianend;
	private String s_liudian;
	private String s_id;
	private String forword;
	private long refid;
	private long s_agentid;
	
	private long s_typeid;
	// 批量操作选项
	private int opt;

	private String ajax_typeid;
	
	
	
	private String ajax_agentid;
	

	// search
	// private String s_name;

	/**
	 * 列表查询留点设置关联表
	 */
	public String execute() throws Exception {

		return SUCCESS;
	}

	/**
	 * 转向到留点设置关联表添加页面
	 */
	public String toadd() throws Exception {
		/*
		 * String strwhere=" where 1=1"; if(lagentid!=0) { strwhere+=" and
		 * "+Settlementtype.COL_agentid+"="+lagentid; }
		 * 
		 * 
		 * listsettle=Server.getInstance().getMemberService().findAllSettlementtype(strwhere,
		 * "ORDER BY ID", -1, 0);
		 * 
		 * listLiudianrefinfo=Server.getInstance().getMemberService().findAllLiudianrefinfo("where
		 * "+Liudianrefinfo.COL_agentid+"="+lagentid, "", -1, 0);
		 * if(listLiudianrefinfo.size()>0) {
		 * liudianrefinfo=listLiudianrefinfo.get(0); }
		 */
		listLiudianrefinfo = Server.getInstance().getMemberService()
		.findAllLiudianrefinfo(
				"where " + Liudianrefinfo.COL_agentid + "=" + lagentid,
				"", -1, 0);
		if (listLiudianrefinfo.size() > 0) {//如果该加盟商被匹配了留点。。。lagentid
			liudianrefinfo = listLiudianrefinfo.get(0);
			
			//如果被匹配了。。。显示被匹配的类型。。。。
			long stypeid=liudianrefinfo.getTypeid();
			
			/*String strwhere = " where 1=1 and " + Settlementtype.COL_agentid + " ="
			+ getLoginUser().getAgentid()+" OR "+ Settlementtype.COL_agentid + " =46";
			
			listsettle = Server.getInstance().getMemberService()
			.findAllSettlementtype(strwhere, "ORDER BY ID", -1, 0);*/
			

		
		}else{
			
			/*String strwhere = " where 1=1 and " + Settlementtype.COL_agentid + " ="
			+ getLoginUser().getAgentid();
				listsettle = Server.getInstance().getMemberService()
			.findAllSettlementtype(strwhere, "ORDER BY ID", -1, 0);*/
			
		}

		
		String strwhere = " where 1=1 and " + Settlementtype.COL_agentid + " ="
		+ getLoginUser().getAgentid();
		if(getLoginUser().getAgentid()==46||getLoginUser().getAgentid()==1){
			strwhere+=" OR "+Settlementtype.COL_agentid + " =46";
		}
		System.out.println("留点类型where:"+strwhere);
			listsettle = Server.getInstance().getMemberService()
		.findAllSettlementtype(strwhere, "ORDER BY ID", -1, 0);
		

		
		return EDIT;
	}

	/**
	 * 转向到留点设置关联表修改页面
	 */
	public String toedit() throws Exception {
		liudianrefinfo = Server.getInstance().getMemberService()
				.findLiudianrefinfo(liudianrefinfo.getId());
		return EDIT;
	}

	/**
	 * 转向到留点设置关联表审核页面
	 */
	public String tocheck() throws Exception {
		liudianrefinfo = Server.getInstance().getMemberService()
				.findLiudianrefinfo(liudianrefinfo.getId());
		return CHECK;
	}
	
	public String edittypeid() throws Exception{
		System.out.println("s_agentid=="+s_agentid+",s_typeid=="+s_typeid);
		if(s_agentid!=-1&&s_typeid!=-1){
			
			List<Liudianrefinfo>list = Server.getInstance().getMemberService().findAllLiudianrefinfo(" where 1=1 and "+Liudianrefinfo.COL_agentid+" ="+s_agentid, " order by id desc ", -1, 0);
			if(list.size()>0){
				
				Liudianrefinfo liudianrefinfo =list.get(0);
				liudianrefinfo.setTypeid(s_typeid);
				Server.getInstance().getMemberService().updateLiudianrefinfoIgnoreNull(liudianrefinfo);
			}else{
				
				Liudianrefinfo liudianrefinfo= new Liudianrefinfo();
				liudianrefinfo.setAgentid(s_agentid);
				liudianrefinfo.setTypeid(s_typeid);
				liudianrefinfo.setLiudianrecid(1L);
				Server.getInstance().getMemberService().createLiudianrefinfo(liudianrefinfo);
				
				
			}
		}
		if(s_agentid!=-1&&s_typeid==-1){
			
			//List<Liudianrefinfo>list = Server.getInstance().getMemberService().findAllLiudianrefinfo(" where 1=1 and "+Liudianrefinfo.COL_agentid+" ="+s_agentid, " order by id desc ", -1, 0);
			
			Server.getInstance().getMemberService().excuteLiudianrefinfoBySql(" delete "+Liudianrefinfo.TABLE+" where "+Liudianrefinfo.COL_agentid+" ="+s_agentid);
			
		}
		
		
		
		return "edittypeid";
	}
	
	public void AjaxLodAgentSetType() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		String sb="-1";
		List<Liudianrefinfo> list= Server.getInstance().getMemberService().findAllLiudianrefinfo(" where 1=1 and "+Liudianrefinfo.COL_agentid+" ="+ajax_agentid, " order by id ", -1, 0);
		if(list.size()>0){
			
			long typeid=list.get(0).getTypeid();
			Settlementtype settlementtype= Server.getInstance().getMemberService().findSettlementtype(typeid);
			if(settlementtype!=null){
				
				sb=settlementtype.getId()+"";
			}
		}
		out.print(sb.toString());
		out.flush();
		out.close();
	}

	public void AjaxLodLiuDianRecodeByTypeID() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		// StringBuilder sb = new StringBuilder();
		String sb = "";
		String danwei="%";
		if (ajax_typeid != null && ajax_typeid.length() > 0) {
			
			Settlementtype settlementtype = Server.getInstance().getMemberService().findSettlementtype(Long.parseLong(ajax_typeid));
			if(settlementtype.getLiudianid()==null){
				
				danwei="%";
			}
			if(settlementtype.getLiudianid()==1){
				
				danwei="%";
			}
			if(settlementtype.getLiudianid()==2){
				
				danwei="元";
			}
			
			String where = " WHERE 1=1 AND " + Liudianrecord.COL_typeid + " ='"
					+ ajax_typeid + "'";
			List<Liudianrecord> list = Server.getInstance().getMemberService()
					.findAllLiudianrecord(where, "", -1, 0);
			
				sb += "<table width='60%' cellspacing='0' cellpadding='0' border='1' class='table_color'>";
				sb += "<tr class='tbody_color' style='font-weight: bold'>";
				sb += "<td width='25%' align='center'>序号</td>";
				sb += "<td width='25%' align='center'>大于</td>";
				sb += "<td width='25%' align='center'>小于</td>";
				sb += "<td width='25%' align='center'>暗扣</td>";
				//sb += "<td width='20%' align='center'>操作</td>";
				sb += "</tr>";
				sb += "<tr>";
				sb += "<td colspan='5'>";
				sb += "<table id='tbrecord' width='100%' cellspacing='0' cellpadding='0' border='0'>";
				if (list.size() > 0){
				for(int a=0;a<list.size();a++){
				sb += "<tr>";
				String index=(a+1)+"";
				sb += "<td width='25%'>"+index+"";
				sb += "<input type='hidden' name='tempid' style='width: 100px' value='"+list.get(a).getId()+"' />";
				sb += "</td>";
				sb += "<td width='25%'><input type='text' disabled='disabled' name='fandianstart' style='width: 100px' value='"+formatMoney(list.get(a).getFandianstart())+"' />"+danwei+"</td>";
				sb += "<td width='25%'><input type='text' disabled='disabled' name='fandianend' style='width: 100px' value='"+formatMoney(list.get(a).getFandianend())+"' />"+danwei+"</td>";
				sb += "<td width='25%'><input type='text' disabled='disabled' name='liudian' style='width: 100px' value='"+formatMoney(list.get(a).getLiudian())+"' />"+danwei+"</td>";
				//sb += "<td width='20%'><a href='#' onclick='addrecord();'><img disabled='disabled' src='images/add.gif' />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='nodelete();'><img  disabled='disabled' src='images/del.gif' />删除</a></td>";
				//sb += "<td width='20%'><a href='#' ><img disabled='disabled' src='images/add.gif' />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' ><img  disabled='disabled' src='images/del.gif' />删除</a></td>";
				
				sb += "</tr>";
				}
				}
				//else{
				
				//sb += "<tr id='hidid_1'>";
				//sb += "<td width='20%'>1";
				//sb += "<input type='hidden' name='tempid' style='width: 100px' value='0' />";
				//sb += "</td>";
				//sb += "<td width='20%'><input type='text' name='fandianstart' style='width: 100px' />%</td>";
				//sb += "<td width='20%'><input type='text' name='fandianend' style='width: 100px' />%</td>";
				//sb += "<td width='20%'><input type='text' name='liudian' style='width: 100px' /></td>";
				//sb += "<td width='20%'><a href='#' onclick='addrecord();'><img src='images/add.gif' />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='delrecord(1);'><img src='images/del.gif' />删除</a></td>";
				//}
				sb += "</table>";
				sb += "</td>";
				sb += "<input type='hidden' id='s_fandianstart' name='s_fandianstart' value='' />";
				sb += "<input type='hidden' id='s_fandianend' name='s_fandianend' value='' />";
				sb += "<input type='hidden' id='s_liudian' name='s_liudian' value='' />";

				sb += "<input type='hidden' id='s_id' name='s_id' value='' />";
				sb += "</tr>";
				sb += "</table>";

			

			}else{
				
				
				sb="-1";
			}

		

		System.out.println("sb==" + sb);

		out.print(sb.toString());
		out.flush();
		out.close();
	}

	/**
	 * 添加留点设置关联表
	 */
	public String add() throws Exception {

		liudianrefinfo.setLiudianrecid(1l);
		Server.getInstance().getMemberService().createLiudianrefinfo(
				liudianrefinfo);

		forword = "customeragent!tofenxiao.action?agenttype=3";
		return "forword";
	}

	/**
	 * 审核留点设置关联表
	 */
	public String check() throws Exception {

		Server.getInstance().getMemberService().updateLiudianrefinfoIgnoreNull(
				liudianrefinfo);
		return LIST;
	}

	/**
	 * 编辑留点设置关联表
	 */
	public String edit() throws Exception {

		Server.getInstance().getMemberService().updateLiudianrefinfoIgnoreNull(
				liudianrefinfo);
		return LIST;
	}

	/**
	 * 删除留点设置关联表
	 */
	public String delete() throws Exception {
		Server.getInstance().getMemberService().deleteLiudianrefinfo(
				liudianrefinfo.getId());
		
		//
//		Customeragent customeragent=	 new Customeragent ();
//		List list=customeragent.getBussinesslist();
		
		
		
		return LIST;
	}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		if (selectid != null && selectid.length > 0) {

			switch (opt) {
			case 1: // delete

				for (int i : selectid) {
					Server.getInstance().getMemberService()
							.deleteLiudianrefinfo(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	
	//得到所有业务
	public String getbussiness(){
		
		Customeragent customeragent	= Server.getInstance().getMemberService().findCustomeragent(lagentid);
		listbussiness=customeragent.getBussinesslist();
		return "listbussine";
	}
	/**
	 * 返回留点设置关联表对象
	 */

	public Object getModel() {
		return liudianrefinfo;
	}

	public List<Liudianrefinfo> getListLiudianrefinfo() {
		return listLiudianrefinfo;
	}

	public void setListLiudianrefinfo(List<Liudianrefinfo> listLiudianrefinfo) {
		this.listLiudianrefinfo = listLiudianrefinfo;
	}

	public Liudianrefinfo getLiudianrefinfo() {
		return liudianrefinfo;
	}

	public void setLiudianrefinfo(Liudianrefinfo liudianrefinfo) {
		this.liudianrefinfo = liudianrefinfo;
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

	public List<Liudianrecord> getListrecord() {
		return listrecord;
	}

	public void setListrecord(List<Liudianrecord> listrecord) {
		this.listrecord = listrecord;
	}

	public long getLagentid() {
		return lagentid;
	}

	public void setLagentid(long lagentid) {
		this.lagentid = lagentid;
	}

	public String getS_fandianstart() {
		return s_fandianstart;
	}

	public void setS_fandianstart(String s_fandianstart) {
		this.s_fandianstart = s_fandianstart;
	}

	public String getS_fandianend() {
		return s_fandianend;
	}

	public void setS_fandianend(String s_fandianend) {
		this.s_fandianend = s_fandianend;
	}

	public String getS_liudian() {
		return s_liudian;
	}

	public void setS_liudian(String s_liudian) {
		this.s_liudian = s_liudian;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public List<Settlementtype> getListsettle() {
		return listsettle;
	}

	public void setListsettle(List<Settlementtype> listsettle) {
		this.listsettle = listsettle;
	}

	public long getRefid() {
		return refid;
	}

	public void setRefid(long refid) {
		this.refid = refid;
	}

	public long getS_agentid() {
		return s_agentid;
	}

	public void setS_agentid(long s_agentid) {
		this.s_agentid = s_agentid;
	}

	public String getAjax_typeid() {
		return ajax_typeid;
	}

	public void setAjax_typeid(String ajax_typeid) {
		this.ajax_typeid = ajax_typeid;
	}

	public String getAjax_agentid() {
		return ajax_agentid;
	}

	public void setAjax_agentid(String ajax_agentid) {
		this.ajax_agentid = ajax_agentid;
	}

	public long getS_typeid() {
		return s_typeid;
	}

	public void setS_typeid(long s_typeid) {
		this.s_typeid = s_typeid;
	}

	public List<Bussiness> getListbussiness() {
		return listbussiness;
	}

	public void setListbussiness(List<Bussiness> listbussiness) {
		this.listbussiness = listbussiness;
	}

}