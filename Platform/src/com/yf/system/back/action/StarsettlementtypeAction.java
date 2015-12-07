/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.liudianrecord.Liudianrecord;
import com.yf.system.base.settlementtype.Settlementtype;
import com.yf.system.base.starrecord.Starrecord;
import com.yf.system.base.starreinfo.Starreinfo;
import com.yf.system.base.starsettlementtype.Starsettlementtype;
import com.opensymphony.webwork.ServletActionContext;


public class StarsettlementtypeAction extends B2b2cbackAction {
	private List <  Starsettlementtype  >  listStarsettlementtype;
	private List<Starrecord> liststarrecord;
	private Starsettlementtype starsettlementtype = new Starsettlementtype();
	private List<Starreinfo>listStarreinfo;
	private Starreinfo starreinfo = new Starreinfo();
	private long lagentid;
	//批量操作ID数组
	private int[]selectid;
	private long s_agentid;
	private String s_fandianstart;
	private String s_fandianend;
	private String s_liudian;
	private String s_id;
	private String forword;
	private String ajax_typeid;
	
	private String  typeid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private String liudiantype;
	
	
	/**
	 * 列表查询星级结算分类
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 and "+Starsettlementtype.COL_sagentid+" ="+getLoginUser().getAgentid();
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Starsettlementtype.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getHotelService().findAllStarsettlementtypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listStarsettlementtype = list;
		  if(pageinfo.getTotalrow()>0 &&   listStarsettlementtype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllStarsettlementtypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listStarsettlementtype = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到星级结算分类添加页面
	 */	
	public String toadd()throws Exception{
		String strwhere=" where 1=1";
		strwhere+=" and "+Starrecord.COL_sagentid+" ="+starsettlementtype.getId();
		liststarrecord=Server.getInstance().getHotelService().findAllStarrecord(strwhere, " order by id ", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到星级结算分类修改页面
	 */	
	public String toedit()throws Exception{
	starsettlementtype = Server.getInstance().getHotelService().findStarsettlementtype(starsettlementtype.getId());
	String strwhere=" where 1=1";
	strwhere+=" and "+Starrecord.COL_typeid+" ="+starsettlementtype.getId();
	liststarrecord=Server.getInstance().getHotelService().findAllStarrecord(strwhere, " order by id ", -1, 0);
		return EDIT;
	}
	
	/**
	 * 转向到星级结算分类审核页面
	 */	
	public String tocheck()throws Exception{
	starsettlementtype = Server.getInstance().getHotelService().findStarsettlementtype(starsettlementtype.getId());
		return CHECK;
	}
	
	//
	public String toAgentType()throws Exception{
		System.out.println("lagentid=="+lagentid);
		listStarreinfo=Server.getInstance().getHotelService().findAllStarreinfo(" WHERE 1=1 AND "+Starreinfo.COL_sagentid+" ="+lagentid, " ORDER BY ID ", -1, 0);
		if(listStarreinfo.size()>0){
			
			starreinfo=listStarreinfo.get(0);
		}
		
		listStarsettlementtype=Server.getInstance().getHotelService().findAllStarsettlementtype(" WHERE 1=1 AND "+Starsettlementtype.COL_sagentid+" ="+lagentid+" or "+Starreinfo.COL_sagentid+" =46", " ORDER BY ID DESC ", -1, 0);
		return "toAgentType";
	}
	public String toview() throws Exception
	{
		starsettlementtype = Server.getInstance().getHotelService().findStarsettlementtype(starsettlementtype.getId());
		String strwhere=" where 1=1";
		strwhere+=" and "+Liudianrecord.COL_agentid+"="+starsettlementtype.getId();
		
		liststarrecord=Server.getInstance().getMemberService().findAllLiudianrecord(strwhere, "ORDER BY ID ", -1, 0);
		return "view";
	}
	public List<Starrecord> GetListRecordbyID(long typeid)throws Exception{
		List<Starrecord> list = null;
		String where =" where 1=1 and "+Starrecord.COL_typeid+" ="+typeid;
		list = Server.getInstance().getHotelService().findAllStarrecord(where, " ORDER BY ID ", -1, 0);
		System.out.println("list=="+list);
	
		
		return list;
	}
	public void AjaxLodLiuDianRecodeByTypeID() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		// StringBuilder sb = new StringBuilder();
		String sb = "";
		String danwei="%";
		if (ajax_typeid != null && ajax_typeid.length() > 0) {
			
			//Settlementtype settlementtype = Server.getInstance().getMemberService().findSettlementtype(Long.parseLong(ajax_typeid));
			Starsettlementtype starsettlementtype=Server.getInstance().getHotelService().findStarsettlementtype(Long.parseLong(ajax_typeid));
			
			if(starsettlementtype.getSliudianid()==null){
				
				danwei="元";
			}
			if(starsettlementtype.getSliudianid()==1){
				
				danwei="%";
			}
			if(starsettlementtype.getSliudianid()==2){
				
				danwei="元";
			}
			
			String where = " WHERE 1=1 AND " + Starrecord.COL_typeid + " ='"
					+ ajax_typeid + "'";
			
			
			List<Starrecord> list = Server.getInstance().getHotelService()
					.findAllStarrecord(where, "", -1, 0);
			
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
				sb += "<td width='25%'><input type='text' disabled='disabled' name='fandianstart' style='width: 100px' value='"+formatMoney(Float.parseFloat(list.get(a).getSfandianstart()))+"' />"+danwei+"</td>";
				sb += "<td width='25%'><input type='text' disabled='disabled' name='fandianend' style='width: 100px' value='"+formatMoney(Float.parseFloat(list.get(a).getSfandianend()))+"' />"+danwei+"</td>";
				sb += "<td width='25%'><input type='text' disabled='disabled' name='liudian' style='width: 100px' value='"+formatMoney(Float.parseFloat(list.get(a).getSliudian()))+"' />"+danwei+"</td>";
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
	
	public String addAngentType()throws Exception{
		Starreinfo starreinfo= new Starreinfo();
		List<Starreinfo>list=Server.getInstance().getHotelService().findAllStarreinfo(" WHERE 1=1 AND "+Starreinfo.COL_sagentid+" ="+lagentid, " ORDER BY ID DESC ", -1, 0);
		if(list.size()>0){
			
			starreinfo=list.get(0);
		}
		
		starreinfo.setSagentid(lagentid);
		//starreinfo.setSliudianrecid(Long.parseLong(typeid));
		starreinfo.setTypeid(Long.parseLong(typeid));
		if(list.size()>0){
			
			Server.getInstance().getHotelService().updateStarreinfoIgnoreNull(starreinfo);
		}else{
			
			Server.getInstance().getHotelService().createStarreinfo(starreinfo);
			
		}
		forword="starsettlementtype!toAgentType.action?lagentid="+lagentid;
		return "addAngentType";
	}
	/**
	 * 添加星级结算分类
	 */		
	public String add()throws Exception{
//	starsettlementtype.setCreateuser(getLoginUser().getLoginname());
//		starsettlementtype.setCreatetime(new Timestamp(System.currentTimeMillis()));
//		
//		Server.getInstance().getHotelService().createStarsettlementtype(starsettlementtype);
		if(starsettlementtype.getId()==0){
				starsettlementtype.setCreatetime(new Timestamp(System.currentTimeMillis()));
				starsettlementtype.setCreateuser(Long.toString(getLoginUser().getId()));
				starsettlementtype.setSliudianid(Long.parseLong(liudiantype));//1,按返点 2,按利润
				starsettlementtype.setSagentid(getLoginUserAgent().getId());
				starsettlementtype=Server.getInstance().getHotelService().createStarsettlementtype(starsettlementtype);
		}else{
			starsettlementtype.setSliudianid(Long.parseLong(liudiantype));//1,按返点 2,按利润
			Server.getInstance().getHotelService().updateStarsettlementtypeIgnoreNull(starsettlementtype);
		}
		Long settypeid=starsettlementtype.getId();
		//循环插入留点记录表中的值
		String[] fandianshiarr=s_fandianstart.split(",");
		String[] fandianzhiarr=s_fandianend.split(",");
		String[] liudianarr=s_liudian.split(",");
		String[] idarr=s_id.split(",");
		
		for(int i=0;i<fandianshiarr.length;i++)
		{
			Starrecord starrecord=new Starrecord();
			if(idarr[i].equals("0"))
			{
				starrecord.setSagentid(getLoginUserAgent().getId());
				starrecord.setSfandianstart(fandianshiarr[i]);
				starrecord.setSfandianend(fandianzhiarr[i]);
				starrecord.setSliudian(liudianarr[i]);
				starrecord.setTypeid(settypeid);
				Server.getInstance().getHotelService().createStarrecord(starrecord);
			}
			else if(!idarr[i].equals("0"))
			{
				starrecord.setId(Long.parseLong(idarr[i]));
				starrecord.setSagentid(getLoginUserAgent().getId());
				starrecord.setSfandianstart(fandianshiarr[i]);
				starrecord.setSfandianend(fandianzhiarr[i]);
				starrecord.setSliudian(liudianarr[i]);
				Server.getInstance().getHotelService().updateStarrecordIgnoreNull(starrecord);
			}
		}
		
		
		return LIST;
	}

	/**
	 * 审核星级结算分类
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateStarsettlementtypeIgnoreNull(starsettlementtype);
		return LIST;
	}
	


	/**
	 * 编辑星级结算分类
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateStarsettlementtypeIgnoreNull(starsettlementtype);
		return LIST;
	}

	/**
	 * 删除星级结算分类
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteStarsettlementtype(starsettlementtype.getId());
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
					Server.getInstance().getHotelService().deleteStarsettlementtype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回星级结算分类对象
	 */		
	
	public Object getModel() {
		return starsettlementtype;
	}
	public List < Starsettlementtype >   getListStarsettlementtype() {
		return listStarsettlementtype;
	}
	public void setListStarsettlementtype(List <  Starsettlementtype  >  listStarsettlementtype) {
		this.listStarsettlementtype = listStarsettlementtype;
	}
	public Starsettlementtype getStarsettlementtype() {
		return starsettlementtype;
	}
	public void setStarsettlementtype(Starsettlementtype starsettlementtype) {
		this.starsettlementtype = starsettlementtype;
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
	public List<Starrecord> getListstarrecord() {
		return liststarrecord;
	}
	public void setListstarrecord(List<Starrecord> liststarrecord) {
		this.liststarrecord = liststarrecord;
	}
	public String getLiudiantype() {
		return liudiantype;
	}
	public void setLiudiantype(String liudiantype) {
		this.liudiantype = liudiantype;
	}
	public long getS_agentid() {
		return s_agentid;
	}
	public void setS_agentid(long s_agentid) {
		this.s_agentid = s_agentid;
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
	public List<Starreinfo> getListStarreinfo() {
		return listStarreinfo;
	}
	public void setListStarreinfo(List<Starreinfo> listStarreinfo) {
		this.listStarreinfo = listStarreinfo;
	}
	public long getLagentid() {
		return lagentid;
	}
	public void setLagentid(long lagentid) {
		this.lagentid = lagentid;
	}
	public Starreinfo getStarreinfo() {
		return starreinfo;
	}
	public void setStarreinfo(Starreinfo starreinfo) {
		this.starreinfo = starreinfo;
	}
	public String getAjax_typeid() {
		return ajax_typeid;
	}
	public void setAjax_typeid(String ajax_typeid) {
		this.ajax_typeid = ajax_typeid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	
	
}