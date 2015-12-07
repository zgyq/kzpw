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
import com.yf.system.base.city.City;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.spotline.Spotline;
import com.yf.system.base.spotlineimg.Spotlineimg;
import com.yf.system.base.spotlineinfo.Spotlineinfo;
import com.yf.system.base.spotlineprice.Spotlineprice;


public class SpotlineAction extends B2b2cbackAction {
	private List <  Spotline  >  listSpotline;
	private Spotline spotline = new Spotline();
	private List <  Spotlineinfo  >  listSpotlineinfo;
	private List <  Spotlineprice  >  listSpotlineprice;
	private List <  City  >  listCity;
	private List <  Spotcity  >  listSpotCity;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	private long s_spotlineid;
	//search
	//private String s_name;
	
	//一下为维护线路详细信息用
	private String scityname;
	
	private String szhusu;
	
	private String sbeizhu;
	
	private String scanyin;
	//以下为维护线路价格用
	
	
	private String sptype;//成人类型
	private String sprice;//结算价
	private String slsprice;//零售价
	
	
	/**
	 * 列表查询景区线路信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotline.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
		
		if(getLoginUser().getAgentid()!=46){
			where+=" AND "+Spotline.COL_agentid+" ='"+getLoginUser().getAgentid()+"'";
			
		}
	
	    List list = Server.getInstance().getTripService().findAllSpotlineForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotline = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotline.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotlineForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotline = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到景区线路信息添加页面
	 */	
	public String toadd()throws Exception{
		listCity=Server.getInstance().getHotelService().findAllCity(" WHERE 1=1 ", " ORDER BY C_ENNAME ", -1, 0);
		
		String strwhere = "WHERE 1=1 and " + Spotcity.COL_parentid+ " in ( select "+Spotcity.COL_id+" from "+Spotcity.TABLE+" where "+Spotcity.COL_parentid+" =1)";
		listSpotCity=Server.getInstance().getTripService().findAllSpotcity(strwhere, " ORDER BY ID ", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到景区线路信息修改页面
	 */	
	public String toedit()throws Exception{
	listCity=Server.getInstance().getHotelService().findAllCity(" WHERE 1=1 ", " ORDER BY C_ENNAME ", -1, 0);
	String strwhere = "WHERE 1=1 and " + Spotcity.COL_parentid+ " in ( select "+Spotcity.COL_id+" from "+Spotcity.TABLE+" where "+Spotcity.COL_parentid+" =1)";
	listSpotCity=Server.getInstance().getTripService().findAllSpotcity(strwhere, " ORDER BY ID ", -1, 0);
	spotline = Server.getInstance().getTripService().findSpotline(spotline.getId());
	listSpotlineinfo=Server.getInstance().getTripService().findAllSpotlineinfo(" WHERE 1=1 AND "+Spotlineinfo.COL_spotlineid+" ='"+spotline.getId()+"'", " ORDER BY ID ", -1, 0);
	listSpotlineprice=Server.getInstance().getTripService().findAllSpotlineprice(" WHERE 1=1 AND "+Spotlineprice.COL_spotlineid+" ='"+spotline.getId()+"'", " ORDER BY ID ", -1, 0)	;
	return EDIT;
	}
	
	/**
	 * 转向到景区线路信息审核页面
	 */	
	public String tocheck()throws Exception{
	spotline = Server.getInstance().getTripService().findSpotline(s_spotlineid);
	
	System.out.println(spotline.getState());
	if(spotline.getState()==1){
		spotline.setState(0l);	
	}else{
		spotline.setState(1l);
	}
	
	System.out.println(spotline.getState());
	
	Server.getInstance().getTripService().updateSpotlineIgnoreNull(spotline);
	
		return this.execute();
	}
	
public String GetSpotCityNmaeByID(String spotcityid){
		
		
		return Server.getInstance().getTripService().findSpotcity(Long.parseLong(spotcityid)).getName();
	}
	/**
	 * 添加景区线路信息
	 */		
	public String add()throws Exception{
		spotline.setCreatetime(new Timestamp(System.currentTimeMillis()));
		spotline.setAgentid(getLoginUser().getAgentid()+"");
		spotline.setMemberid(getLoginUser().getId());
		spotline=Server.getInstance().getTripService().createSpotline(spotline);
		
		String[] scitynames=scityname.split(",");//区间
		String[] szhusus=szhusu.split(",");//住宿
		String[] scanyins=scanyin.split(",");//餐饮
		String[] sbeizhus=sbeizhu.split(",");//备注
		if(scitynames!=null){
			for(int s=0;s<scitynames.length;s++){
				Spotlineinfo spotlineinfo=new Spotlineinfo();
				if(sbeizhus[s]!=null){
				spotlineinfo.setBeizhu(sbeizhus[s].trim());
				}
				if(scitynames[s]!=null){
				spotlineinfo.setQujian(scitynames[s].trim());
				}
				if(scanyins[s]!=null){
				spotlineinfo.setCanyin(scanyins[s].trim());
				}
				spotlineinfo.setDday("第"+(s+1)+"天");
				if(szhusus[s]!=null){
				spotlineinfo.setZhusu(szhusus[s].trim());
				}
				spotlineinfo.setSpotlineid(spotline.getId()+"");
				Server.getInstance().getTripService().createSpotlineinfo(spotlineinfo);
				
			}
			
		}
		
		String[] sptypes=sptype.split(",");//成人类型
		String[] sprices=sprice.split(",");//结算价
		String[] slsprices=slsprice.split(",");//零售价
		if(sptypes!=null){
			for(int s=0;s<sptypes.length;s++){
				Spotlineprice spotlineprice=new Spotlineprice();
				spotlineprice.setSpotlineid(spotline.getId()+"");
				if(sptypes[s]!=null){
				spotlineprice.setPtype(sptypes[s].trim());
				}
				if(sprices[s]!=null){
				spotlineprice.setPrice(sprices[s].trim());
				}
				if(slsprices[s]!=null){
				spotlineprice.setLsprice(slsprices[s].trim());
				}
				
				Server.getInstance().getTripService().createSpotlineprice(spotlineprice);
			}
			
		}
		
		
		
		
		return LIST;
	}

	/**
	 * 审核景区线路信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineIgnoreNull(spotline);
		return LIST;
	}
	


	/**
	 * 编辑景区线路信息
	 */		
	public String edit()throws Exception{
		spotline.setAgentid(getLoginUser().getAgentid()+"");
		Server.getInstance().getTripService().updateSpotlineIgnoreNull(spotline);
		
		
		Server.getInstance().getTripService().excuteSpotlineinfoBySql(" DELETE "+Spotlineinfo.TABLE+" WHERE "+Spotlineinfo.COL_spotlineid+" ='"+spotline.getId()+"'");
		String[] scitynames=scityname.split(",");//区间
		String[] szhusus=szhusu.split(",");//住宿
		String[] scanyins=scanyin.split(",");//餐饮
		String[] sbeizhus=sbeizhu.split(",");//备注
		if(scitynames!=null){
			for(int s=0;s<scitynames.length;s++){
				Spotlineinfo spotlineinfo=new Spotlineinfo();
					if(sbeizhus[s]!=null){
					spotlineinfo.setBeizhu(sbeizhus[s].trim());
					}
					if(scitynames[s]!=null){
					spotlineinfo.setQujian(scitynames[s].trim());
					}
					if(scanyins[s]!=null){
					spotlineinfo.setCanyin(scanyins[s].trim());
					}
					spotlineinfo.setDday("第"+(s+1)+"天");
					if(szhusus[s]!=null){
					spotlineinfo.setZhusu(szhusus[s].trim());
					}
				spotlineinfo.setSpotlineid(spotline.getId()+"");
				Server.getInstance().getTripService().createSpotlineinfo(spotlineinfo);
				
			}
			
		}
		
		Server.getInstance().getTripService().excuteSpotlinepriceBySql(" DELETE "+Spotlineprice.TABLE+" WHERE "+Spotlineprice.COL_spotlineid+" ='"+spotline.getId()+"'");
		String[] sptypes=sptype.split(",");//成人类型
		String[] sprices=sprice.split(",");//结算价
		String[] slsprices=slsprice.split(",");//零售价
		if(sptypes!=null){
			for(int s=0;s<sptypes.length;s++){
				Spotlineprice spotlineprice=new Spotlineprice();
				spotlineprice.setSpotlineid(spotline.getId()+"");
				if(sptypes[s]!=null){
				spotlineprice.setPtype(sptypes[s].trim());
				}
				if(sprices[s]!=null){
				spotlineprice.setPrice(sprices[s].trim());
				}
				if(slsprices[s]!=null){
				spotlineprice.setLsprice(slsprices[s].trim());
				}
				
				Server.getInstance().getTripService().createSpotlineprice(spotlineprice);
			}
			
		}
		
		return LIST;
	}

	/**
	 * 删除景区线路信息
	 */		
	public String delete()throws Exception{	
		
		Server.getInstance().getTripService().excuteSpotlineimgBySql(" DELETE "+Spotlineimg.TABLE+" WHERE "+Spotlineimg.COL_spotlineid+" ='"+spotline.getId()+"'");
		Server.getInstance().getTripService().excuteSpotlineinfoBySql(" DELETE "+Spotlineinfo.TABLE+" WHERE "+Spotlineinfo.COL_spotlineid+" ='"+spotline.getId()+"'");
		Server.getInstance().getTripService().excuteSpotlinepriceBySql(" DELETE "+Spotlineprice.TABLE+" WHERE "+Spotlineprice.COL_spotlineid+" ='"+spotline.getId()+"'");
		Server.getInstance().getTripService().deleteSpotline(spotline.getId());
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
					Server.getInstance().getTripService().deleteSpotline(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回景区线路信息对象
	 */		
	
	public Object getModel() {
		return spotline;
	}
	public List < Spotline >   getListSpotline() {
		return listSpotline;
	}
	public void setListSpotline(List <  Spotline  >  listSpotline) {
		this.listSpotline = listSpotline;
	}
	public Spotline getSpotline() {
		return spotline;
	}
	public void setSpotline(Spotline spotline) {
		this.spotline = spotline;
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
	public List<City> getListCity() {
		return listCity;
	}
	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}
	public String getScityname() {
		return scityname;
	}
	public void setScityname(String scityname) {
		this.scityname = scityname;
	}
	public String getSzhusu() {
		return szhusu;
	}
	public void setSzhusu(String szhusu) {
		this.szhusu = szhusu;
	}
	public String getSbeizhu() {
		return sbeizhu;
	}
	public void setSbeizhu(String sbeizhu) {
		this.sbeizhu = sbeizhu;
	}
	public String getScanyin() {
		return scanyin;
	}
	public void setScanyin(String scanyin) {
		this.scanyin = scanyin;
	}
	public List<Spotlineinfo> getListSpotlineinfo() {
		return listSpotlineinfo;
	}
	public void setListSpotlineinfo(List<Spotlineinfo> listSpotlineinfo) {
		this.listSpotlineinfo = listSpotlineinfo;
	}
	public List<Spotlineprice> getListSpotlineprice() {
		return listSpotlineprice;
	}
	public void setListSpotlineprice(List<Spotlineprice> listSpotlineprice) {
		this.listSpotlineprice = listSpotlineprice;
	}
	public String getSptype() {
		return sptype;
	}
	public void setSptype(String sptype) {
		this.sptype = sptype;
	}
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getSlsprice() {
		return slsprice;
	}
	public void setSlsprice(String slsprice) {
		this.slsprice = slsprice;
	}
	public List<Spotcity> getListSpotCity() {
		return listSpotCity;
	}
	public void setListSpotCity(List<Spotcity> listSpotCity) {
		this.listSpotCity = listSpotCity;
	}
	public long getS_spotlineid() {
		return s_spotlineid;
	}
	public void setS_spotlineid(long s_spotlineid) {
		this.s_spotlineid = s_spotlineid;
	}
	
	
}