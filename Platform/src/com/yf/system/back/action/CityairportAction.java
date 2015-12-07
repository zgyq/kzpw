/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.atom.component.BaseCache;
import com.yf.system.back.server.Server;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class CityairportAction extends B2b2cbackAction {
	private static final long serialVersionUID = -4781247472584471167L;
	private List<Cityairport> listCityairport;
	private Cityairport cityairport = new Cityairport();
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	 private String s_name;

	/**
	 * 列表查询机场城市
	 */
	public String execute() throws Exception {
		//生成城市数据-生成城市控件Js数据
		String strJs="var commoncitys=new Array(); \r\n";
		
		String strHotCity=" where "+Cityairport.COL_countrycode+"='CN'";
		List<Cityairport> listhotcity=Server.getInstance().getAirService().findAllCityairport(strHotCity, "order by "+Cityairport.COL_cityindex, -1, 0);
		for(int i=0;i<20;i++)
		{
			strJs+=" commoncitys["+i+"]=new Array('"+listhotcity.get(i).getAirportcode()+"','"+listhotcity.get(i).getCityname()+"','"+listhotcity.get(i).getPinyin()+"','"+listhotcity.get(i).getShortpinyin()+"');  \r\n";
		}
		strJs+=" var citys=new Array(); \r\n";
		for(int i=0;i<listhotcity.size();i++)
		{
			strJs+=" citys["+i+"]=new Array('"+listhotcity.get(i).getAirportcode()+"','"+listhotcity.get(i).getCityname()+"','"+listhotcity.get(i).getPinyin()+"','"+listhotcity.get(i).getShortpinyin()+"');  \r\n";
		}
		//System.out.println(strJs);
		//生成城市数据-生成城市控件Js数据
		
		
		
		String where = " where 1=1 ";

		if (cityairport.getCityname() != null
				&& !"".equals(cityairport.getCityname())) {
			where += " and " + Cityairport.COL_cityname + " like '%"
					+ cityairport.getCityname() + "%'";
		}

		if (cityairport.getPinyin() != null
				&& !"".equals(cityairport.getPinyin())) {
			where += " and " + Cityairport.COL_pinyin + " like '%"
					+ cityairport.getPinyin() + "%'";
		}

		if (cityairport.getAirportname() != null
				&& !"".equals(cityairport.getAirportname())) {
			where += " and " + Cityairport.COL_airportname + " like '%"
					+ cityairport.getAirportname() + "%'";
		}

		if (cityairport.getAirportcode() != null
				&& !"".equals(cityairport.getAirportcode())) {
			where += " and " + Cityairport.COL_airportcode + " like '%"
					+ cityairport.getAirportcode() + "%'";
		}
		if (s_name != null&& !"".equals(s_name)&&!s_name.equals("ALL")) {
			if(s_name.equals("CN")){
				where += " and " + Cityairport.COL_countrycode + " like '%"+ s_name + "%'";
				
			}else{
				where += " and " + Cityairport.COL_countrycode + "!='CN'";
				
			}
			
			
		}
		

		List list = Server
				.getInstance()
				.getAirService()
				.findAllCityairportForPageinfo(where, " ORDER BY ID DESC ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listCityairport = list;
		if (pageinfo.getTotalrow() > 0 && listCityairport.size() == 0) {
			if (pageinfo.getPagenum() <= 1) {
				pageinfo.setPagenum(1);
			}
			list = Server.getInstance().getAirService()
					.findAllCityairportForPageinfo(where, " ORDER BY ID DESC ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listCityairport = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到机场城市添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到机场城市修改页面
	 */
	public String toedit() throws Exception {
		cityairport = Server.getInstance().getAirService().findCityairport(
				cityairport.getId());
		return EDIT;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=cityairport.getLanguage();
		Long uco=cityairport.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		cityairport = Server.getInstance().getAirService().findCityairportbylanguage(cityairport.getUcode(),cityairport.getLanguage());
		if(cityairport==null)
		{
			cityairport=new Cityairport();
			cityairport.setLanguage(lan);
			cityairport.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
		}
		return EDIT;
	}
	
	public void getInterAirPortData() throws Exception {
		String strRetData = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		List<Fcity> listAirport = Server.getInstance().getInterticketService().findAllFcity("WHERE 1=1 ", "ORDER BY C_INDEX", -1, 0);
		for (Fcity airPort : listAirport) {
			sb.append(airPort.getCityname() + "#" + airPort.getCitynameen() + "%"
					+ airPort.getCitycode()+airPort.getCitynameen()+airPort.getCountrycode() + "&" + airPort.getCitycode()
					+ ",");
		}
		//System.out.println(sb.toString());
		// return strRetData;
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 转向到机场城市审核页面
	 */
	public String docheck() throws Exception {
		cityairport = Server.getInstance().getAirService().findCityairport(
				cityairport.getId());
		if (cityairport.getIsenable() == 1) {
			cityairport.setIsenable(0);
		} else {
			cityairport.setIsenable(1);
		}
		Server.getInstance().getAirService().updateCityairportIgnoreNull(
				cityairport);
		return "list2";
	}

	public void getCityAirPortData() throws Exception {
		String strRetData = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		List<Cityairport> listAirport = Server.getInstance().getAirService()
				.findAllCityairport("WHERE 1=1 and "+Cityairport.COL_countrycode+"='CN'", "ORDER BY C_CITYINDEX", -1, 0);
		for (Cityairport airPort : listAirport) {
			sb.append(airPort.getCityname() + "#" + airPort.getAirportcode() + "%"
					+ airPort.getAirportcode()+airPort.getShortpinyin()+airPort.getPinyin() + "&" + airPort.getAirportcode()
					+ ",");
		}
		//System.out.println(sb.toString());
		// return strRetData;
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 添加机场城市
	 */
	public String add() throws Exception {
		cityairport.setCreateuser(getLoginUser().getLoginname());
		cityairport.setCreatetime(new Timestamp(System.currentTimeMillis()));
		cityairport.setModifyuser(getLoginUser().getLoginname());
		cityairport.setModifytime(new Timestamp(System.currentTimeMillis()));

		cityairport=Server.getInstance().getAirService().createCityairport(cityairport);
		this.addActionMessage("您的操作已成功！");
		
		 Server.getInstance().getTicketSearchService().CreateOscach(cityairport.getAirportcode(),cityairport); 
		return EDIT;
	}

	/**
	 * 审核机场城市
	 */
	public String check() throws Exception {
		cityairport.setModifyuser(getLoginUser().getLoginname());
		cityairport.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateCityairportIgnoreNull(
				cityairport);
		return LIST;
	}

	/**
	 * 编辑机场城市
	 */
	public String edit() throws Exception {
		cityairport.setModifyuser(getLoginUser().getLoginname());
		cityairport.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateCityairportIgnoreNull(
				cityairport);
		this.addActionMessage("您的操作已成功！");
		
		Cityairport cityairport2=Server.getInstance().getAirService().findCityairport(cityairport.getId());
		
		Server.getInstance().getTicketSearchService().CreateOscach(cityairport2.getAirportcode(),cityairport2); 
		return EDIT;
	}

	/**
	 * 删除机场城市
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteCityairport(
				cityairport.getId());
		Cityairport cityairport2=Server.getInstance().getAirService().findCityairport(cityairport.getId());
		Server.getInstance().getTicketSearchService().removeOscach(cityairport2.getAirportcode());
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
					Server.getInstance().getAirService().deleteCityairport(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回机场城市对象
	 */

	public Object getModel() {
		return cityairport;
	}

	public List<Cityairport> getListCityairport() {
		return listCityairport;
	}

	public void setListCityairport(List<Cityairport> listCityairport) {
		this.listCityairport = listCityairport;
	}

	public Cityairport getCityairport() {
		return cityairport;
	}

	public void setCityairport(Cityairport cityairport) {
		this.cityairport = cityairport;
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

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}



}