/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.qzchanpin.Qzchanpin;
import com.yf.system.base.qzchanpininfo.Qzchanpininfo;
import com.yf.system.base.qzguojia.Qzguojia;


public class QzseachAction extends B2b2cbackAction {
	private List <  Qzguojia  >  listQzguojia;
	private Qzguojia qzguojia = new Qzguojia();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	private String c_id;//签证国家ID
	private long c_qzinfoid;//签证产品ID
	private List<Qzchanpin> ListQzchanpin;
	private List<Qzchanpininfo> ListQzchanpininfo;
	private Qzchanpininfo qzchanpininfo;
	
	private List <  Qzguojia  >  listQzguojiayz;//亚洲
	private List <  Qzguojia  >  listQzguojiaoz;//欧洲
	private List <  Qzguojia  >  listQzguojiamz;//美洲
	private List <  Qzguojia  >  listQzguojiaaz;//奥洲
	private List <  Qzguojia  >  listQzguojiafz;//非洲
	
	/**
	 * 列表查询签证国家
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Qzguojia.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllQzguojiaForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQzguojia = list;
		  if(pageinfo.getTotalrow()>0 &&   listQzguojia.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllQzguojiaForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQzguojia = list;
		}
		
		  listQzguojiayz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =6", " ORDER BY ID ", -1, 0);
		  listQzguojiaoz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =2", " ORDER BY ID ", -1, 0);
		  listQzguojiamz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =3", " ORDER BY ID ", -1, 0);
		  listQzguojiaaz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =4", " ORDER BY ID ", -1, 0);
		  listQzguojiafz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =5", " ORDER BY ID ", -1, 0);
		  
		return SUCCESS;
	}
	public String toqzbycont(){
		ListQzchanpininfo=Server.getInstance().getTripService().findAllQzchanpininfo(" where 1=1 and "+Qzchanpininfo.COL_param2+" ='"+c_id+"'", "", 10, 0);
		List<Qzguojia>list=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_classid+" ='"+c_id+"'", " ORDER BY ID ", -1, 0);
		if(list.size()>0){
			qzguojia=list.get(0);
		}
		//qzguojia=Server.getInstance().getTripService().findQzguojia(id);
		return "toqzbycont";
	}
	public String toqzinfo(){
		//ListQzchanpininfo=Server.getInstance().getTripService().findAllQzchanpininfo(" where 1=1 and "+Qzchanpininfo.COL_param2+" ='"+c_id+"'", "", 10, 0);
		qzchanpininfo=Server.getInstance().getTripService().findQzchanpininfo(c_qzinfoid);
		//qzguojia=Server.getInstance().getTripService().findQzguojia(id);
		List<Qzguojia>list=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_classid+" ='"+qzchanpininfo.getParam2()+"'", " ORDER BY ID ", -1, 0);
		if(list.size()>0){
			qzguojia=list.get(0);
		}
		return "toqzinfo";
	}
	/**
	 * 转向到签证国家添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到签证国家修改页面
	 */	
	public String toedit()throws Exception{
	qzguojia = Server.getInstance().getTripService().findQzguojia(qzguojia.getId());
		return EDIT;
	}
	
	/**
	 * 转向到签证国家审核页面
	 */	
	public String tocheck()throws Exception{
	qzguojia = Server.getInstance().getTripService().findQzguojia(qzguojia.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加签证国家
	 */		
	public String add()throws Exception{
	qzguojia.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createQzguojia(qzguojia);
		return LIST;
	}

	/**
	 * 审核签证国家
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateQzguojiaIgnoreNull(qzguojia);
		return LIST;
	}
	


	/**
	 * 编辑签证国家
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateQzguojiaIgnoreNull(qzguojia);
		return LIST;
	}

	/**
	 * 删除签证国家
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteQzguojia(qzguojia.getId());
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
					Server.getInstance().getTripService().deleteQzguojia(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回签证国家对象
	 */		
	
	public Object getModel() {
		return qzguojia;
	}
	public List < Qzguojia >   getListQzguojia() {
		return listQzguojia;
	}
	public void setListQzguojia(List <  Qzguojia  >  listQzguojia) {
		this.listQzguojia = listQzguojia;
	}
	public Qzguojia getQzguojia() {
		return qzguojia;
	}
	public void setQzguojia(Qzguojia qzguojia) {
		this.qzguojia = qzguojia;
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
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public long getC_qzinfoid() {
		return c_qzinfoid;
	}
	public void setC_qzinfoid(long c_qzinfoid) {
		this.c_qzinfoid = c_qzinfoid;
	}
	public List<Qzchanpin> getListQzchanpin() {
		return ListQzchanpin;
	}
	public void setListQzchanpin(List<Qzchanpin> listQzchanpin) {
		ListQzchanpin = listQzchanpin;
	}
	public List<Qzchanpininfo> getListQzchanpininfo() {
		return ListQzchanpininfo;
	}
	public void setListQzchanpininfo(List<Qzchanpininfo> listQzchanpininfo) {
		ListQzchanpininfo = listQzchanpininfo;
	}
	public Qzchanpininfo getQzchanpininfo() {
		return qzchanpininfo;
	}
	public void setQzchanpininfo(Qzchanpininfo qzchanpininfo) {
		this.qzchanpininfo = qzchanpininfo;
	}
	public List<Qzguojia> getListQzguojiayz() {
		return listQzguojiayz;
	}
	public void setListQzguojiayz(List<Qzguojia> listQzguojiayz) {
		this.listQzguojiayz = listQzguojiayz;
	}
	public List<Qzguojia> getListQzguojiaoz() {
		return listQzguojiaoz;
	}
	public void setListQzguojiaoz(List<Qzguojia> listQzguojiaoz) {
		this.listQzguojiaoz = listQzguojiaoz;
	}
	public List<Qzguojia> getListQzguojiamz() {
		return listQzguojiamz;
	}
	public void setListQzguojiamz(List<Qzguojia> listQzguojiamz) {
		this.listQzguojiamz = listQzguojiamz;
	}
	public List<Qzguojia> getListQzguojiaaz() {
		return listQzguojiaaz;
	}
	public void setListQzguojiaaz(List<Qzguojia> listQzguojiaaz) {
		this.listQzguojiaaz = listQzguojiaaz;
	}
	public List<Qzguojia> getListQzguojiafz() {
		return listQzguojiafz;
	}
	public void setListQzguojiafz(List<Qzguojia> listQzguojiafz) {
		this.listQzguojiafz = listQzguojiafz;
	}
	
	
}