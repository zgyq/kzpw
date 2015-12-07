/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.liudianrecord.Liudianrecord;
import com.yf.system.base.liudianrefinfo.Liudianrefinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.settlementtype.Settlementtype;
import com.yf.system.base.util.PageInfo;


public class SettlementtypeAction extends B2b2cbackAction {
	private List <  Settlementtype  >  listSettlementtype;
	private Settlementtype settlementtype = new Settlementtype();
	private List <  Liudianrefinfo  >  listLiudianrefinfo;
	private List<Liudianrecord> listrecord;
	private Liudianrefinfo liudianrefinfo = new Liudianrefinfo();
	
	//批量操作ID数组
	private int[]selectid;
	private long s_agentid;
	private String s_fandianstart;
	private String s_fandianend;
	private String s_liudian;
	private String s_id;
	private String forword;
	
	//批量操作选项
	private int opt;
	
	//留点类型 1,按返点  2,按利润
	private String liudiantype;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询结算分类表
	 */	
	public String execute()throws Exception{
		/*String where = " where 1=1 ";
		s_agentid=getLoginUserAgent().getId();
		if(s_agentid!=46)
		{
			where+="and "+Settlementtype.COL_agentid+"="+s_agentid;
		}
	    List list = Server.getInstance().getMemberService().findAllSettlementtypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSettlementtype = list;
		  if(pageinfo.getTotalrow()>0 &&   listSettlementtype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllSettlementtypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSettlementtype = list;
		}*/
		//String where = " where 1=1 and "+Settlementtype.COL_createuser+" ="+getLoginUser().getId();
		String where = " where 1=1 and "+Settlementtype.COL_agentid+" ="+getLoginUser().getAgentid();
		  
		List list = Server.getInstance().getMemberService().findAllSettlementtypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSettlementtype = list;
		  if(pageinfo.getTotalrow()>0 &&   listSettlementtype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllSettlementtypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSettlementtype = list;
		}
		return SUCCESS;
	}
	/**
	 * 转向到结算分类表添加页面
	 */	
	public String toadd()throws Exception{
		String strwhere=" where 1=1";
		strwhere+=" and "+Liudianrecord.COL_agentid+"="+settlementtype.getId();
		
		listrecord=Server.getInstance().getMemberService().findAllLiudianrecord(strwhere, "ORDER BY ID ", -1, 0);
		return EDIT;
	}
	
	public String toaddb2c()throws Exception{
		List <Settlementtype>  list=Server.getInstance().getMemberService().findAllSettlementtype(" WHERE 1=1 AND "+Settlementtype.COL_agentid+" ="+getLoginUser().getAgentid()+" AND "+Settlementtype.COL_typename+" ='B2C留点'", " ORDER BY ID ", -1, 0);
		if(list!=null&&list.size()>0){
			settlementtype=	list.get(0);
		}
		
		
		String strwhere=" where 1=1";
		strwhere+=" and "+Liudianrecord.COL_typeid+"="+settlementtype.getId();
		listrecord=Server.getInstance().getMemberService().findAllLiudianrecord(strwhere, "ORDER BY ID ", -1, 0);
		
		System.out.println(listrecord.size());
		
		
		return "toaddb2c";
	}
	
	
	
	
	/**
	 * 转向到结算分类表修改页面
	 */	
	public String toedit()throws Exception{	
	/*settlementtype = Server.getInstance().getMemberService().findSettlementtype(settlementtype.getId());
	String strwhere=" where 1=1";
	strwhere+=" and "+Liudianrecord.COL_agentid+"="+s_agentid;
	
	listrecord=Server.getInstance().getMemberService().findAllLiudianrecord(strwhere, "ORDER BY ID ", -1, 0);*/
		
	settlementtype = Server.getInstance().getMemberService().findSettlementtype(settlementtype.getId());
	String strwhere=" where 1=1";
	strwhere+=" and "+Liudianrecord.COL_typeid+"="+settlementtype.getId();
	
	listrecord=Server.getInstance().getMemberService().findAllLiudianrecord(strwhere, "ORDER BY ID ", -1, 0);
	
		return EDIT;
	}
	
	public String toview() throws Exception
	{
		settlementtype = Server.getInstance().getMemberService().findSettlementtype(settlementtype.getId());
		String strwhere=" where 1=1";
		strwhere+=" and "+Liudianrecord.COL_agentid+"="+settlementtype.getId();
		
		listrecord=Server.getInstance().getMemberService().findAllLiudianrecord(strwhere, "ORDER BY ID ", -1, 0);
		return "view";
	}
	
	/**
	 * 转向到结算分类表审核页面
	 */	
	public String tocheck()throws Exception{
	settlementtype = Server.getInstance().getMemberService().findSettlementtype(settlementtype.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加结算分类表
	 */		
	public String add()throws Exception{
	   
		if(settlementtype.getId()==0)	
		{
		   settlementtype.setCreateuser(getLoginUser().getId());
		   settlementtype.setLiudianid(Long.parseLong(liudiantype));//1,按返点 2,按利润
		   settlementtype.setAgentid(getLoginUserAgent().getId());  //所属代理商
		   settlementtype.setCreatetime(new Timestamp(System.currentTimeMillis()));
		   settlementtype=Server.getInstance().getMemberService().createSettlementtype(settlementtype);
		}
		else
		{
			settlementtype.setLiudianid(Long.parseLong(liudiantype));//1,按返点 2,按利润
			Server.getInstance().getMemberService().updateSettlementtypeIgnoreNull(settlementtype);
		}
		Long settypeid=settlementtype.getId();
		//循环插入留点记录表中的值
		String[] fandianshiarr=s_fandianstart.split(",");
		String[] fandianzhiarr=s_fandianend.split(",");
		String[] liudianarr=s_liudian.split(",");
		String[] idarr=s_id.split(",");
		
		
		for(int i=0;i<fandianshiarr.length;i++)
		{
			Liudianrecord liudianrecord=new Liudianrecord();
			if(idarr[i].equals("0"))
			{
				liudianrecord.setAgentid(getLoginUserAgent().getId());
				liudianrecord.setFandianstart(Float.parseFloat(fandianshiarr[i]));
				liudianrecord.setFandianend(Float.parseFloat(fandianzhiarr[i]));
				liudianrecord.setLiudian(Float.parseFloat(liudianarr[i]));
				liudianrecord.setTypeid(settypeid);
				Server.getInstance().getMemberService().createLiudianrecord(liudianrecord);
			}
			else if(!idarr[i].equals("0"))
			{
				liudianrecord.setId(Long.parseLong(idarr[i]));
				liudianrecord.setAgentid(getLoginUserAgent().getId());
				liudianrecord.setFandianstart(Float.parseFloat(fandianshiarr[i]));
				liudianrecord.setFandianend(Float.parseFloat(fandianzhiarr[i]));
				liudianrecord.setLiudian(Float.parseFloat(liudianarr[i]));
				Server.getInstance().getMemberService().updateLiudianrecordIgnoreNull(liudianrecord);
			}
		}
		return LIST;
	}

	/**
	 * 审核结算分类表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateSettlementtypeIgnoreNull(settlementtype);
		return LIST;
	}
	
	public List<Liudianrecord> GetListRecordbyID(long typeid)throws Exception{
		List<Liudianrecord> list = null;
		String where =" where 1=1 and "+Liudianrecord.COL_typeid+" ="+typeid;
		list = Server.getInstance().getMemberService().findAllLiudianrecord(where, " ORDER BY ID ", -1, 0);
		System.out.println("list=="+list);
	
		
		return list;
	}


	/**
	 * 编辑结算分类表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateSettlementtypeIgnoreNull(settlementtype);
		return LIST;
	}

	/**
	 * 删除结算分类表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().excuteLiudianrecordBySql(" DELETE "+Liudianrecord.TABLE+" where "+Liudianrecord.COL_typeid+" ="+settlementtype.getId());
		Server.getInstance().getMemberService().excuteLiudianrefinfoBySql(" DELETE "+Liudianrefinfo.TABLE+" where "+Liudianrefinfo.COL_typeid+" ="+settlementtype.getId());
		Server.getInstance().getMemberService().deleteSettlementtype(settlementtype.getId());
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
					Server.getInstance().getMemberService().deleteSettlementtype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回结算分类表对象
	 */		
	
	public Object getModel() {
		return settlementtype;
	}
	public List < Settlementtype >   getListSettlementtype() {
		return listSettlementtype;
	}
	public void setListSettlementtype(List <  Settlementtype  >  listSettlementtype) {
		this.listSettlementtype = listSettlementtype;
	}
	public Settlementtype getSettlementtype() {
		return settlementtype;
	}
	public void setSettlementtype(Settlementtype settlementtype) {
		this.settlementtype = settlementtype;
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
	public long getS_agentid() {
		return s_agentid;
	}
	public void setS_agentid(long s_agentid) {
		this.s_agentid = s_agentid;
	}
	public String getLiudiantype() {
		return liudiantype;
	}
	public void setLiudiantype(String liudiantype) {
		this.liudiantype = liudiantype;
	}
	
	
	
}