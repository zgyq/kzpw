/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.yf.system.back.server.Server;
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.triporder.Triporder;
import com.yf.system.base.util.PageInfo;


public class TriporderAction extends B2b2cbackAction {
	private List <  Triporder  >  listTriporder;
	private Triporder triporder = new Triporder();
	
	private String s_ordernum;
	private String s_contactmingzi;
	private String s_startdate;
	private String s_enddate;
	private String s_bookdate;
	private String s_bookenddate;
	private String s_reportsdate;
	private String s_reportedate;
	private List listMap;
	private List listReportMap;
	private String s_ordercount;
	
	private long oid;
	private String s_totalamount;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询线路订单
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_ordernum!=null && s_ordernum.trim().length()!=0) {
			
			where += " and " + Triporder.COL_code +" = '" + s_ordernum.trim()+"'";	
		}
       if (s_contactmingzi!=null && s_contactmingzi.trim().length()!=0) {
			
			where += " and " + Triporder.COL_linkname +" like '%" + s_contactmingzi.trim()+"%'";	
		}
       if (s_startdate!=null && s_startdate.trim().length()!=0 && s_enddate!=null && s_enddate.trim().length()!=0) {
			
			where += " and " + Triporder.COL_statetime +" between '" + s_startdate.trim()+" 00:00:00' and '"+s_enddate.trim()+" 23:59:59'";	
		}
       if (s_bookdate!=null && s_bookdate.trim().length()!=0 && s_bookenddate!=null && s_bookenddate.trim().length()!=0) {
			
			where += " and " + Triporder.COL_createtime +" between '" + s_bookdate.trim()+" 00:00:00' and '"+s_bookenddate.trim()+" 23:59:59'";	
		}
       if(getLoginUserAgent().getId()!=46)
       {
    	   where+=" and "+Triporder.COL_buyagentid+"="+getLoginUserAgent().getId();
       }
	
	    List list = Server.getInstance().getTripService().findAllTriporderForPageinfo(where," ORDER BY ID DESC",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTriporder = list;
		  if(pageinfo.getTotalrow()>0 &&   listTriporder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTriporderForPageinfo(where," ORDER BY ID DESC",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTriporder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 根据线路ID获取线路名称
	 */
	public String getTriplineName(long idnumber)
	{
		Tripline tripline=Server.getInstance().getTripService().findTripline(idnumber);
		return tripline != null && !"".equals(tripline.getName()) ? tripline.getName() : "";
	}
	public String lirun()throws Exception
	{
		String where =" where 1=1 ";
		
		if (s_reportsdate!=null && s_reportsdate.trim().length()!=0 && s_reportedate!=null && s_reportedate.trim().length()!=0) {
			where += " and C_CREATETIME between '" + s_reportsdate.trim()+" 00:00:00' and '"+s_reportedate.trim()+" 23:59:59'";	
		}
		
		listTriporder = Server.getInstance().getTripService().findAllTriporder(where, " ORDER BY ID DESC", -1, 0);
		return "tripprice";
	}
	/**
	 * 显示是否锁住
	 * @param oid
	 * @return
	 */
	public boolean getlock(long oid)
	{
		Triporder orderinfo = Server.getInstance().getTripService().findTriporder(oid);
		if(orderinfo.getLockuser()==null||orderinfo.getLockuser()==getLoginUser().getId())
		{
			return true;
		}
		if(orderinfo.getLockstate()==null||orderinfo.getLockstate()==0)
		{
			return true;
		}
		if(orderinfo.getLocktime()==null)
		{
			return true;
		}
		if(new Timestamp(System.currentTimeMillis()).getTime() - orderinfo.getLocktime().getTime()>30*1000*60)
		{
			return true;
		}
		return false;
	}
	/**
	 * 解锁
	 * @return
	 */
	public String unlock()
	{
		Triporder orderinfo = new Triporder();
		orderinfo.setId(oid);
		orderinfo.setLockstate(0l);
		Server.getInstance().getTripService().updateTriporderIgnoreNull(orderinfo);
		return LIST;
	}
	/*public void checklock() {//查看锁单
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		if(this.isadmin())
		{
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("nolock");
			out.flush();
			out.close();
		}
		Triporder orderinfo = Server.getInstance().getTripService().findTriporder(oid);
		if(orderinfo.getLockstate()==null||orderinfo.getLockstate()==0||orderinfo.getLockuser()==null||orderinfo.getLockuser()==this.getLoginUser().getId()){// 新订单啊
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("nolock");
			out.flush();
			out.close();
		}else{
			if(new Timestamp(System.currentTimeMillis()).getTime() - orderinfo.getLocktime().getTime()>30*1000*60){//超过了30分钟
				orderinfo.setLockstate(0l);
				Server.getInstance().getTripService().updateTriporderIgnoreNull(orderinfo);
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.print("nolock");
				out.flush();
				out.close();
			}else{//还没超过30分钟
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Customeruser customeruser=Server.getInstance().getMemberService().findCustomeruser(orderinfo.getLockuser());
				out.print(customeruser.getLoginname());
				out.flush();
				out.close();
			}
		}
		}*/
	/**
	 * 转向到线路订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到线路订单修改页面
	 */	
	public String toedit()throws Exception{
		triporder.setLockstate(1l);
		triporder.setLocktime(new Timestamp(System.currentTimeMillis()));
		triporder.setLockuser(getLoginUserId());
		Server.getInstance().getTripService().updateTriporderIgnoreNull(triporder);
		triporder = Server.getInstance().getTripService().findTriporder(triporder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到线路订单审核页面
	 */	
	public String tocheck()throws Exception{
	triporder = Server.getInstance().getTripService().findTriporder(triporder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加线路订单
	 */		
	public String add()throws Exception{
	    triporder.setCreateuser(getLoginUser().getLoginname());
		triporder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		triporder.setModifyuser(getLoginUser().getLoginname());
		triporder.setModifytime(new Timestamp(System.currentTimeMillis()));
		triporder.setBuyagentid(getLoginUserAgent().getId());
		Server.getInstance().getTripService().createTriporder(triporder);
		return LIST;
	}

	/**
	 * 审核线路订单
	 */		
	public String check()throws Exception{
	triporder.setModifyuser(getLoginUser().getLoginname());
		triporder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriporderIgnoreNull(triporder);
		return LIST;
	}
	


	/**
	 * 编辑线路订单
	 */		
	public String edit()throws Exception{
	triporder.setModifyuser(getLoginUser().getLoginname());
		triporder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriporderIgnoreNull(triporder);
		return LIST;
	}

	/**
	 * 删除线路订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTriporder(triporder.getId());
		return LIST;
	}
	/**
	 * 跳转到旅游报表
	 */
	public String totripreport() throws Exception
	{
		listReportMap=tripreportinfo();
		return "tripreport";
	}
	
	public List tripreportinfo()
	{
		String strsql = "select CONVERT(varchar(10) , C_CREATETIME, 120 ) as createtime,C_TRIPLINEID as triplineid,COUNT(ID) as totalnumber,SUM(C_SUMP) as amount from T_TRIPORDER";
        String where=" where 1=1 and "+Triporder.COL_state+"=2 ";
        
		if (s_reportsdate!=null && s_reportsdate.trim().length()!=0 && s_reportedate!=null && s_reportedate.trim().length()!=0) {
			where += " and C_CREATETIME between '" + s_reportsdate.trim()+" 00:00:00' and '"+s_reportedate.trim()+" 23:59:59'";	
		}
		
        String strgroupby=" group by CONVERT(varchar(10) , C_CREATETIME, 120 ),C_TRIPLINEID";
        strsql+=where;
        strsql+=strgroupby;
        String strWhere="select count(ID) as number,sum(C_SUMP) as amount from "+Triporder.TABLE+" "+where;
        listMap= Server.getInstance().getSystemService().findMapResultBySql(strWhere, null);
        if(listMap.size()>0 && listMap!=null)
        {
 	       Map map=(Map) listMap.get(0);
 	       
 	       if(map.get("number").toString()!="0" && map.get("number")!=null)
 	       {
 	    	 s_ordercount=map.get("number").toString();
 	       }
 	       else
 	       {
 	    	   s_ordercount="0";
 	       }
 	       if(map.get("amount")!=null)
 	       {
 	    	   s_totalamount=map.get("amount").toString();
 	       }
 	       else
 	       {
 	    	   s_totalamount="0";
 	       }
        }
        else
        {
     	   s_ordercount="0";
 	       s_totalamount="0";
        }
        return Server.getInstance().getSystemService().findMapResultBySql(strsql,null);
	}
	/**
	 * 跳转到旅游订单业务报表
	 */
    public String toreportdetail() throws Exception
    {
        String where = "where 1=1 and "+Triporder.COL_state+"=2";
		if (s_ordernum!=null && s_ordernum.trim().length()!=0) {
			where += " and " + Triporder.COL_code +" = '" + s_ordernum.trim()+"'";	
		}
       if (s_contactmingzi!=null && s_contactmingzi.trim().length()!=0) {
			where += " and " + Triporder.COL_linkname +" like '%" + s_contactmingzi.trim()+"%'";	
		}
       if (s_startdate!=null && s_startdate.trim().length()!=0 && s_enddate!=null && s_enddate.trim().length()!=0) {
			
			where += " and " + Triporder.COL_statetime +" between '" + s_startdate.trim()+" 00:00:00' and '"+s_enddate.trim()+" 23:59:59'";	
		}
      if (s_bookdate!=null && s_bookdate.trim().length()!=0 && s_bookenddate!=null && s_bookenddate.trim().length()!=0) {
			
			where += " and " + Triporder.COL_createtime +" between '" + s_bookdate.trim()+" 00:00:00' and '"+s_bookenddate.trim()+" 23:59:59'";	
		}
       String strWhere="select count(ID) as number,sum(C_SUMP) as amount from "+Triporder.TABLE+" "+where;
       listTriporder = Server.getInstance().getTripService().findAllTriporder(where," ORDER BY ID DESC",-1,0);
       listMap= Server.getInstance().getSystemService().findMapResultBySql(strWhere, null);
       if(listMap.size()>0 && listMap!=null)
       {
	       Map map=(Map) listMap.get(0);
	       
	       if(map.get("number").toString()!="0" && map.get("number")!=null)
	       {
	    	 s_ordercount=map.get("number").toString();
	       }
	       else
	       {
	    	   s_ordercount="0";
	       }
	       if(map.get("amount")!=null)
	       {
	    	   s_totalamount=map.get("amount").toString();
	       }
	       else
	       {
	    	   s_totalamount="0";
	       }
       }
       else
       {
    	   s_ordercount="0";
	       s_totalamount="0";
       }
        return "reportdetail";    	
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
					Server.getInstance().getTripService().deleteTriporder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回线路订单对象
	 */		
	
	public Object getModel() {
		return triporder;
	}
	public List < Triporder >   getListTriporder() {
		return listTriporder;
	}
	public void setListTriporder(List <  Triporder  >  listTriporder) {
		this.listTriporder = listTriporder;
	}
	public Triporder getTriporder() {
		return triporder;
	}
	public void setTriporder(Triporder triporder) {
		this.triporder = triporder;
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
	public String getS_ordernum() {
		return s_ordernum;
	}
	public void setS_ordernum(String s_ordernum) {
		this.s_ordernum = s_ordernum;
	}
	public String getS_contactmingzi() {
		return s_contactmingzi;
	}
	public void setS_contactmingzi(String s_contactmingzi) {
		this.s_contactmingzi = s_contactmingzi;
	}
	public String getS_startdate() {
		return s_startdate;
	}
	public void setS_startdate(String s_startdate) {
		this.s_startdate = s_startdate;
	}
	public String getS_bookdate() {
		return s_bookdate;
	}
	public void setS_bookdate(String s_bookdate) {
		this.s_bookdate = s_bookdate;
	}
	public List getListMap() {
		return listMap;
	}
	public void setListMap(List listMap) {
		this.listMap = listMap;
	}
	public String getS_ordercount() {
		return s_ordercount;
	}
	public void setS_ordercount(String s_ordercount) {
		this.s_ordercount = s_ordercount;
	}
	public String getS_totalamount() {
		return s_totalamount;
	}
	public void setS_totalamount(String s_totalamount) {
		this.s_totalamount = s_totalamount;
	}
	public String getS_enddate() {
		return s_enddate;
	}
	public void setS_enddate(String s_enddate) {
		this.s_enddate = s_enddate;
	}
	public String getS_bookenddate() {
		return s_bookenddate;
	}
	public void setS_bookenddate(String s_bookenddate) {
		this.s_bookenddate = s_bookenddate;
	}
	public String getS_reportsdate() {
		return s_reportsdate;
	}
	public void setS_reportsdate(String s_reportsdate) {
		this.s_reportsdate = s_reportsdate;
	}
	public String getS_reportedate() {
		return s_reportedate;
	}
	public void setS_reportedate(String s_reportedate) {
		this.s_reportedate = s_reportedate;
	}
	public List getListReportMap() {
		return listReportMap;
	}
	public void setListReportMap(List listReportMap) {
		this.listReportMap = listReportMap;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	
}