/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.yf.system.back.server.Server;
import com.yf.system.base.sellreport.Sellreport;
import com.yf.system.base.util.PageInfo;


public class SellreportAction extends B2b2cbackAction {
	private List <  Sellreport  >  listSellreport;
	private Sellreport sellreport = new Sellreport();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private File[] batchfile;
	
	public File[] getBatchfile() {
		return batchfile;
	}
	public void setBatchfile(File[] batchfile) {
		this.batchfile = batchfile;
	}
	/**
	 * 列表查询销售报表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Sellreport.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllSellreportForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSellreport = list;
		  if(pageinfo.getTotalrow()>0 &&   listSellreport.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllSellreportForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSellreport = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到销售报表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	public String todaoru()throws Exception{
		return "todaoru";
	}
	public String daoru()throws Exception{
		Date ordtime=null;
		String ordercode="";
		String xiao="";
		String ren="";
		String pn="";
		String churen="";
		String zhitype="";
		String ddtype="";
		String hao="";
		String cheng="";
		String piaoji="";
		String jing="";
		String jiyou="";
		String shouxu="";
		String shiji="";
		String zhifutype="";
		String ordertype="";
		String ticktype="";
		String xingcheng="";
		String chupiao="";
		
		DateFormat format = new SimpleDateFormat("M/d/y HH:mm");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");				
		//FileInputStream fileInputStream = new FileInputStream("D://51bookxiaoshou.xls");
		try {
		Workbook hotelbook = Workbook.getWorkbook(batchfile[0]);
		
		Sheet sheetHotel = hotelbook.getSheet(0);
		Sellreport sellreport2 = new Sellreport();
		
		List<Sellreport> list = new ArrayList<Sellreport>();
		
		for(int d=1;d<sheetHotel.getRows();d++){
			
		Cell piaoh = sheetHotel.getCell(20, d);
			if(piaoh.getContents()==null||piaoh.getContents()==""||piaoh.getContents().equals(0)||piaoh.getContents().equals("0")){
				return LIST;
			}else{
			
		Sellreport sellreport = new Sellreport();
		

		Cell number = sheetHotel.getCell(6, d);
		if(number.getContents().length()==0 || number.getContents()=="" || number.getContents()==null || number.getContents().equals("0") ){
			
			sellreport.setNumber(Long.parseLong(ren));
		}else{
		String nu =number.getContents();
		long n = Long.parseLong(nu);
		sellreport.setNumber(n);
		ren=nu;
		}
		
		
	
		Cell ordertime = sheetHotel.getCell(1, d);
		if(ordertime.getContents().trim().length()==0 || ordertime.getContents()==null || ordertime.getContents().equals("")||ordertime.getContents().equals(0)){
			sellreport.setRttime(new java.sql.Timestamp(ordtime.getTime()));
		}else{
		Date aaaa = format2.parse(ordertime.getContents());
		sellreport.setRttime(new java.sql.Timestamp(aaaa.getTime()));
		ordtime =aaaa;
		}
		
		
		Cell bianhao = sheetHotel.getCell(2, d);
	
		
		if(bianhao.getContents().length()==0 || bianhao.getContents()==null || bianhao.getContents()==""|| bianhao.getContents().equals("0")){
		sellreport.setOrdercode(ordercode);
		}else{
		sellreport.setOrdercode(bianhao.getContents());
		ordercode=bianhao.getContents();
		
		}
		
		
		
		Cell xiaolv = sheetHotel.getCell(3, d);
		if(xiaolv.getContents().length()==0 || xiaolv.getContents()=="" || xiaolv.getContents()==null|| xiaolv.getContents().equals("0")){
			sellreport.setXiaolv(xiao);
		}else{
		sellreport.setXiaolv(xiaolv.getContents());
		xiao=xiaolv.getContents();
		}
		
		
		Cell chupiaoren = sheetHotel.getCell(4, d);
		if(chupiaoren.getContents().length()==0 || chupiaoren.getContents()==null || chupiaoren.getContents()==""|| chupiaoren.getContents().equals("0")){
			sellreport.setUsername(churen);
		}else{
		sellreport.setUsername(chupiaoren.getContents());
		churen=chupiaoren.getContents();
		}
		
		
		Cell pnr = sheetHotel.getCell(5, d);
		if(pnr.getContents().length()==0 || pnr.getContents()==null || pnr.getContents()=="" || pnr.getContents().equals("0")){
			sellreport.setPnr(pn);
		}else{
		sellreport.setPnr(pnr.getContents());
		pn=pnr.getContents();
		}
		
		//保证金空着 7
		
		Cell piaomian = sheetHotel.getCell(8, d);
		if(piaomian.getContents().length()==0 || piaomian.getContents()=="" || piaomian.getContents()==null || piaomian.getContents().equals("0")){
			sellreport.setSubprice(Double.parseDouble(piaoji));
		}else{
		sellreport.setSubprice(Double.parseDouble(piaomian.getContents()));
		piaoji=piaomian.getContents();
		}
		
		
		Cell jingjia = sheetHotel.getCell(9, d);
		if(jingjia.getContents().length()==0 || jingjia.getContents()=="" || jingjia.getContents()==null || jingjia.getContents().equals("0")){
			sellreport.setJingjia(Double.parseDouble(jing));
		}else{
		sellreport.setJingjia(Double.parseDouble(jingjia.getContents()));
		jing=jingjia.getContents();
		}
		
		
		Cell jijianyuanyou = sheetHotel.getCell(10, d);
		if(jijianyuanyou.getContents().length()==0 || jijianyuanyou.getContents()=="" || jijianyuanyou.getContents()==null || jijianyuanyou.getContents().equals("0")){
			sellreport.setJijianranyou(Double.parseDouble(jiyou));
		}else{
		sellreport.setJijianranyou(Double.parseDouble(jijianyuanyou.getContents()));
		jiyou=jijianyuanyou.getContents();
		}
		
		
		
		Cell zongshuxufei = sheetHotel.getCell(11, d);
		if(zongshuxufei.getContents().length()==0 || zongshuxufei.getContents()=="" || zongshuxufei.getContents()==null || zongshuxufei.getContents().equals("0")){
			sellreport.setPoundage(Double.parseDouble(shouxu));
		}else{
		sellreport.setPoundage(Double.parseDouble(zongshuxufei.getContents()));
		shouxu=zongshuxufei.getContents();
		}
		
		Cell shishouzongji = sheetHotel.getCell(12, d);
		if(shishouzongji.getContents().length()==0 || shishouzongji.getContents()=="" || shishouzongji.getContents()==null || shishouzongji.getContents().equals("0")){
			sellreport.setPactprice(Double.parseDouble(shiji));
		}else{
		sellreport.setPactprice(Double.parseDouble(shishouzongji.getContents()));
		shiji=shishouzongji.getContents();
		}
		
		Cell zhifufangshi = sheetHotel.getCell(13, d);
		if(zhifufangshi.getContents().length()==0||zhifufangshi.getContents().equals("0")||zhifufangshi.getContents().equals(0)||zhifufangshi.getContents()==null){
			sellreport.setPaytype(zhifutype);
		}else{
		sellreport.setPaytype(zhifufangshi.getContents());
		zhitype=zhifufangshi.getContents();
		zhifutype=zhitype;
		}
		
		Cell dingdantype = sheetHotel.getCell(14, d);
		if(dingdantype.getContents().length()==0||dingdantype.getContents().equals(0)||dingdantype.getContents().equals(0)||dingdantype.getContents()==null){
			sellreport.setOrdertype(ddtype);
		}else{
		sellreport.setOrdertype(dingdantype.getContents());
		ddtype=dingdantype.getContents();
		
		}
		Cell jipiaotype = sheetHotel.getCell(15, d);
		if(jipiaotype.getContents().length()==0||jipiaotype.getContents().equals(0)||jipiaotype.getContents().equals("0")||jipiaotype.getContents()==null){
			sellreport.setTickettype(ticktype);
		}else{
		sellreport.setTickettype(jipiaotype.getContents());
		ticktype=jipiaotype.getContents();
		}
		
		Cell xingchengtype = sheetHotel.getCell(16, d);
		if(xingchengtype.getContents().length()==0||xingchengtype.getContents().equals(0)||xingchengtype.getContents().equals("0")||xingchengtype.getContents()==null){
			sellreport.setJourneytype(xingcheng);
		}else{
		sellreport.setJourneytype(xingchengtype.getContents());
		xingcheng=xingchengtype.getContents();
		}
		
		
		Cell chupiaotype = sheetHotel.getCell(17, d);
		if(chupiaotype.getContents().length()==0||chupiaotype.getContents().equals(0)||chupiaotype.getContents().equals("0")||chupiaotype.getContents()==null){
			sellreport.setChupiaotype(chupiao);
		}else{
		sellreport.setChupiaotype(chupiaotype.getContents());
		chupiao=chupiaotype.getContents();
		}
		//office 18  备注19
		Cell piaohao = sheetHotel.getCell(20, d);
		sellreport.setPiaohao(piaohao.getContents());
		hao=piaohao.getContents();
		
		
		Cell chengjiren = sheetHotel.getCell(21, d);
		sellreport.setPassenger(chengjiren.getContents());
		cheng=chengjiren.getContents();
		
		Cell chengren = sheetHotel.getCell(22, d);
		sellreport.setUsertype(chengren.getContents());
		
		Cell chufa = sheetHotel.getCell(23, d);
		sellreport.setStartcity(chufa.getContents());
		
		Cell daoda = sheetHotel.getCell(24, d);
		sellreport.setEndcity(daoda.getContents());
		
		Cell hangcheng = sheetHotel.getCell(25, d);
		sellreport.setSail(hangcheng.getContents());
		
		Cell gongsi = sheetHotel.getCell(26, d);
		sellreport.setAircompany(gongsi.getContents());
		
		Cell hangban = sheetHotel.getCell(27, d);
		sellreport.setFlightnumber(hangban.getContents());
		
		Cell hangbantime = sheetHotel.getCell(28, d);
		Date zhitime = format3.parse(hangbantime.getContents());
		sellreport.setFlighttime(new java.sql.Timestamp(zhitime.getTime()));
		
		Cell cangwei = sheetHotel.getCell(29, d);
		sellreport.setCabin(cangwei.getContents());
		
		Cell zce = sheetHotel.getCell(30, d);
		sellreport.setPolicy(zce.getContents());
		
		Cell piaomianjia = sheetHotel.getCell(31, d);
		sellreport.setPrice(Double.parseDouble(piaomianjia.getContents()));
		
		Cell danzhangjingjia = sheetHotel.getCell(32, d);
		sellreport.setLeafletsnet(Double.parseDouble(danzhangjingjia.getContents()));
		
		Cell jijian = sheetHotel.getCell(33, d);
		sellreport.setJijian(Double.parseDouble(jijian.getContents()));
		
		Cell ruanyou = sheetHotel.getCell(34, d);
		sellreport.setRanyou(Double.parseDouble(ruanyou.getContents()));
		
		Cell danzhangjiesuan = sheetHotel.getCell(35, d);
		sellreport.setJiesuanprice(Double.parseDouble(danzhangjiesuan.getContents()));
		Server.getInstance().getAirService().createSellreport(sellreport);
			}
		}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("完成了阿");
		
		return LIST;
	}
	/**
	 * 转向到销售报表修改页面
	 */	
	public String toedit()throws Exception{
	sellreport = Server.getInstance().getAirService().findSellreport(sellreport.getId());
		return EDIT;
	}
	
	/**
	 * 转向到销售报表审核页面
	 */	
	public String tocheck()throws Exception{
	sellreport = Server.getInstance().getAirService().findSellreport(sellreport.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加销售报表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createSellreport(sellreport);
		return LIST;
	}

	/**
	 * 审核销售报表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateSellreportIgnoreNull(sellreport);
		return LIST;
	}
	


	/**
	 * 编辑销售报表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateSellreportIgnoreNull(sellreport);
		return LIST;
	}

	/**
	 * 删除销售报表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteSellreport(sellreport.getId());
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
					Server.getInstance().getAirService().deleteSellreport(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回销售报表对象
	 */		
	
	public Object getModel() {
		return sellreport;
	}
	public List < Sellreport >   getListSellreport() {
		return listSellreport;
	}
	public void setListSellreport(List <  Sellreport  >  listSellreport) {
		this.listSellreport = listSellreport;
	}
	public Sellreport getSellreport() {
		return sellreport;
	}
	public void setSellreport(Sellreport sellreport) {
		this.sellreport = sellreport;
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