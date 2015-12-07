package com.yf.system.back.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.specialprice.Specialprice;


/**
 * @author vic wong
 * @ 2011-09-06
 * */
public class AirBaseInfoManagerAction extends B2b2cbackAction{
	
	private List<Specialprice> listBaseInfo;//基本信息
	private List<Cityairport> listCityAirPortStart;//对应城市信息(起航站)
	private List<Cityairport> listCityAirPortStop;//对应城市信息(终点站)
	
	private Specialprice specialprice;	//编辑的特价对象
	private Long editId=0L;//编辑的ID值
	
	/**
	 *  接口要求实现的，暂时没做任何用户，如使用，请修改此说明
	 */
	public Object getModel() {
		return "";
	}
	//异步读取数据
	public void ajaxGetAirListBaseInfo() throws Exception
	{
		StringBuilder sbWhere=new StringBuilder();
		sbWhere.append("where 1=1");
		listBaseInfo=(List<Specialprice>)Server.getInstance().getAirService().findAllSpecialpriceForPageinfo(sbWhere.toString(), "ORDER BY C_STARTTIME", pageinfo);
		if(listBaseInfo==null)
			listBaseInfo=new ArrayList<Specialprice>();
		
		sbWhere.delete(0, sbWhere.length());//清空字符串
		StringBuilder sbWhereStop=new StringBuilder();
		
		sbWhere.append("where 1=1 and "+Cityairport.COL_airportcode +" in('");
		sbWhereStop.append("where 1=1 and "+Cityairport.COL_airportcode +" in('");
		
		if(listBaseInfo!=null && listBaseInfo.size()>0){
		listBaseInfo.remove(0);
		
		List<String> listStrStart=new ArrayList<String>();
		List<String> listStrStop=new ArrayList<String>();
		for(Specialprice sp :listBaseInfo){
			
			if (!(sp.getStartport().trim().equals("") ||listStrStart.contains(sp.getStartport().trim())))
			{
				listStrStart.add(sp.getStartport().trim());
				sbWhere.append(sp.getStartport().trim() + "','");
			}
			if (!(sp.getArrivalport().trim().equals("") || listStrStop.contains(sp.getArrivalport().trim()))){
				listStrStop.add(sp.getArrivalport().trim());
				sbWhereStop.append(sp.getArrivalport().trim() + "','");
		}}
		
		listStrStart.clear();
		listStrStart=null;
		listStrStop.clear();
		listStrStop=null;
		
		sbWhere.delete(sbWhere.length()-2, sbWhere.length());
		sbWhereStop.delete(sbWhereStop.length()-2, sbWhereStop.length());
		
		sbWhere.append(")");
		sbWhereStop.append(")");

		listCityAirPortStart=(List<Cityairport>)Server.getInstance().getAirService().findAllCityairport(sbWhere.toString(), "", -1, 0);
//		if (listCityAirPortStart == null || listCityAirPortStart.size() >0)
//			listCityAirPortStart.remove(0);
		
		listCityAirPortStop=(List<Cityairport>)Server.getInstance().getAirService().findAllCityairport(sbWhereStop.toString(), "", -1, 0);
//		if (listCityAirPortStop == null || listCityAirPortStop.size() >0)
//			listCityAirPortStop.remove(0);
		}
		sbWhere=null;
		sbWhereStop=null;
		
	}

	//同步读取数据初始化页面
	public String GetAirListBaseInfo() throws Exception
	{
		String where = "where 1=1";
		//读取初始化数据
		this.ajaxGetAirListBaseInfo();
		
		//这里可以对 listBaseInfo 数据进行处理

		return "airListInfo";
	}
	
	//编辑
	public String toEdit() throws Exception
	{
		specialprice =Server.getInstance().getAirService().findSpecialprice(editId);

		return "airinfoMgrEdit";
	}
	
	//删除
	public String toDelete() throws Exception
	{
		Server.getInstance().getAirService().deleteSpecialprice(editId);
		
		return GetAirListBaseInfo();
	}
	
	/*****************************************Tools专区*************************************************/
	// 通过Code码获取值
	public String checkNameByCode(String code, Boolean isStart) {
		
		code=code.trim();
		if (isStart) {
			if (listCityAirPortStart == null)
				code = "机场名称未显示";
			else {
				for (Cityairport cp : listCityAirPortStart)
					
					if (cp.getAirportcode().trim().equals(code)) {
						code = cp.getAirportname();
						break;
					}
			}
		} else {
			if (listCityAirPortStop == null)
				code = "机场名称未显示";
			else {
				for (Cityairport cp : listCityAirPortStop)
					if (cp.getAirportcode().trim().equals(code)) {
						code = cp.getAirportname();
						break;
					}
			}
		}

		return code;
	}

	// 通过Code码获取值
	public String checkPerByCode(String code) {
		return (new DecimalFormat("#.00")).format(code.trim());
	}
	/** *************************************************************************************** */

	public List<Specialprice> getListBaseInfo() {
		return listBaseInfo;
	}
	public List<Cityairport> getListCityAirPortStart() {
		return listCityAirPortStart;
	}
	public List<Cityairport> getListCityAirPortStop() {
		return listCityAirPortStop;
	}
	//编辑时候获取ID值
	public void setEditId(Long editId) {
		this.editId = editId;
	}
	public Specialprice getspecialprice() {
		return specialprice;
	}
	public void setspecialprice(Specialprice specialprice) {
		this.specialprice = specialprice;
	}
}
