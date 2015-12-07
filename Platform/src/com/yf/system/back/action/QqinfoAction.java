/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.ArrayList;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.qqinfo.Qqinfo;
import com.yf.system.base.qqinfo.QqinfoBean;
import com.yf.system.base.qqtype.Qqtype;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.service.IMemberService;
import com.yf.system.base.util.PageInfo;


public class QqinfoAction extends B2b2cbackAction {
	private List <  Qqinfo  >  listQqinfo;
	private List <  Qqtype  >  listQqtype;
	private Qqinfo qqinfo = new Qqinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	public List <  Qqtype  > getListQqtype(){
		return listQqtype;
	}
	/**
	 * 列表查询QQ信息表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Qqinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllQqinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQqinfo = list;
		System.out.println(list.size());
		  if(pageinfo.getTotalrow()>0 &&   listQqinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllQqinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQqinfo = list;
		}
		IMemberService memberService=Server.getInstance().getMemberService();
		/*for(QqinfoBean qifo:listQqinfo){			
		qifo.setQqtypename(memberService.findQqtype(qifo.getQqtype()).getTypename());	
		}*/
		return SUCCESS;
	}
	
	public List getPassengerNamehtmls(Long id) {
		List<String> lists = new ArrayList<String>();
		
		
		Passenger passenger=Server.getInstance().getAirService().findPassenger(id);
		
		List<Segmentinfo>listseg=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+passenger.getOrderid(), "", -1, 0);
		String name=passenger.getName();
		
		String xingcheng=listseg.get(0).getStartairport()+"-"+listseg.get(0).getEndairport();
		String aircom=listseg.get(0).getFlightnumber();
		String stime=listseg.get(0).getDeparttime().toString();
		String cab=listseg.get(0).getCabincode();
		lists.add(name);
		lists.add(xingcheng);
		lists.add(aircom);
		lists.add(stime);
		lists.add(cab);
		return lists;
		
	}
	/**
	 * 转向到QQ信息表添加页面
	 */	
	public String toadd()throws Exception{
		String where = " where 1=1 ";
		List list = Server.getInstance().getMemberService().findAllQqtype(where," ORDER BY ID ", -1, 0);
		listQqtype = list;
		return EDIT;
	}
	/**
	 * 转向到QQ信息表修改页面
	 */	
	public String toedit()throws Exception{
		String where = " where 1=1 ";
		List list = Server.getInstance().getMemberService().findAllQqtype(where," ORDER BY ID ", -1, 0);
		listQqtype = list;
	    qqinfo = Server.getInstance().getMemberService().findQqinfo(qqinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到QQ信息表审核页面
	 */	
	public String tocheck()throws Exception{
	qqinfo = Server.getInstance().getMemberService().findQqinfo(qqinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加QQ信息表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createQqinfo(qqinfo);
		return LIST;
	}

	/**
	 * 审核QQ信息表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateQqinfoIgnoreNull(qqinfo);
		return LIST;
	}
	


	/**
	 * 编辑QQ信息表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateQqinfoIgnoreNull(qqinfo);
		return LIST;
	}

	/**
	 * 删除QQ信息表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteQqinfo(qqinfo.getId());
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
					Server.getInstance().getMemberService().deleteQqinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回QQ信息表对象
	 */		
	
	public Object getModel() {
		return qqinfo;
	}
	public List < Qqinfo >   getListQqinfo() {
		return listQqinfo;
	}
	public void setListQqinfo(List <  Qqinfo  >  listQqinfo) {
		this.listQqinfo = listQqinfo;
	}
	public Qqinfo getQqinfo() {
		return qqinfo;
	}
	public void setQqinfo(Qqinfo qqinfo) {
		this.qqinfo = qqinfo;
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