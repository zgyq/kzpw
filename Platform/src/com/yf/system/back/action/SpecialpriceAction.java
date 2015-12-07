/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.specialprice.Specialprice;



public class SpecialpriceAction extends B2b2cbackAction {
	private List <  Specialprice  >  listSpecialprice;
	private Specialprice specialprice = new Specialprice();
	private int ticket;//保存机票类型
	private String flytime;//起飞时间
	private String updatetimes;//更新时间
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询特价机票信息（定期更新）
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Specialprice.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllSpecialpriceForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpecialprice = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpecialprice.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllSpecialpriceForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpecialprice = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到特价机票信息（定期更新）添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到特价机票信息（定期更新）修改页面
	 */	
	public String toedit()throws Exception{
	specialprice = Server.getInstance().getAirService().findSpecialprice(specialprice.getId());
		return EDIT;
	}
	
	/**
	 * 转向到特价机票信息（定期更新）审核页面
	 */	
	public String tocheck()throws Exception{
	specialprice = Server.getInstance().getAirService().findSpecialprice(specialprice.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加特价机票信息（定期更新）
	 */		
	public String add()throws Exception{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    specialprice.setCreateuser(getLoginUser().getLoginname());
		specialprice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		specialprice.setModifyuser(getLoginUser().getLoginname());
		specialprice.setModifytime(new Timestamp(System.currentTimeMillis()));
		specialprice.setIsinternal(ticket);
		if(this.flytime!=null&&!this.flytime.equals("")){
		specialprice.setStarttime(new Timestamp(format.parse(flytime).getTime()));
		}
		if(this.updatetimes!=null&&!updatetimes.equals("")){
	    specialprice.setUpdatetime(new Timestamp(format.parse(updatetimes).getTime()));
		}
		Server.getInstance().getAirService().createSpecialprice(specialprice);
		return LIST;
	}

	/**
	 * 审核特价机票信息（定期更新）
	 */		
	public String check()throws Exception{
	specialprice.setModifyuser(getLoginUser().getLoginname());
		specialprice.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateSpecialpriceIgnoreNull(specialprice);
		return LIST;
	}
	


	/**
	 * 编辑特价机票信息（定期更新）
	 */		
	public String edit()throws Exception{
	specialprice.setModifyuser(getLoginUser().getLoginname());
		specialprice.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateSpecialpriceIgnoreNull(specialprice);
		return LIST;
	}

	/**
	 * 删除特价机票信息（定期更新）
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteSpecialprice(specialprice.getId());
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
					Server.getInstance().getAirService().deleteSpecialprice(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回特价机票信息（定期更新）对象
	 */		
	
	public Object getModel() {
		return specialprice;
	}
	public List < Specialprice >   getListSpecialprice() {
		return listSpecialprice;
	}
	public void setListSpecialprice(List <  Specialprice  >  listSpecialprice) {
		this.listSpecialprice = listSpecialprice;
	}
	public Specialprice getSpecialprice() {
		return specialprice;
	}
	public void setSpecialprice(Specialprice specialprice) {
		this.specialprice = specialprice;
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
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	
	
	public String getFlytime() {
		return flytime;
	}
	public void setFlytime(String flytime) {
		this.flytime = flytime;
	}
	public String getUpdatetimes() {
		return updatetimes;
	}
	public void setUpdatetimes(String updatetimes) {
		this.updatetimes = updatetimes;
	}
	
	
}