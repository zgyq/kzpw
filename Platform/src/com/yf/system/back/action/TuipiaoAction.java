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
import com.yf.system.base.tuipiao.Tuipiao;
import com.yf.system.base.util.PageInfo;


public class TuipiaoAction extends B2b2cbackAction {
	private List <  Tuipiao  >  listTuipiao;
	private Tuipiao tuipiao = new Tuipiao();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	private File[] batchfile;
	/**
	 * 列表查询退票报表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Tuipiao.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllTuipiaoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTuipiao = list;
		  if(pageinfo.getTotalrow()>0 &&   listTuipiao.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllTuipiaoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTuipiao = list;
		}
		
		return SUCCESS;
	}
	public String daoru()throws Exception{//导入今日报表
		
		
		
		DateFormat format = new SimpleDateFormat("M/d/y HH:mm");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
								
	//	FileInputStream fileInputStream = new FileInputStream("D://jinribaobiao2.xls");
		try {
		Workbook hotelbook = Workbook.getWorkbook(this.batchfile[0]);
		
		Sheet sheetHotel = hotelbook.getSheet(0);
		Sellreport sellreport2 = new Sellreport();
		
		List<Sellreport> list = new ArrayList<Sellreport>();
		
		for(int d=1;d<sheetHotel.getRows();d++){
			
			Tuipiao tuipiao = new Tuipiao();
			
			Cell ordertime = sheetHotel.getCell(1, d);
		if(ordertime.getContents()==null||ordertime.getContents()==""||ordertime.getContents().equals("0")||ordertime.getContents().equals(0)){
			
			return LIST;
		}else{	
			
		
		
		Date aaaa = format2.parse(ordertime.getContents());
		tuipiao.setRttime(new java.sql.Timestamp(aaaa.getTime()));
		
	
		
		
		Cell bianhao = sheetHotel.getCell(2, d);
		
		tuipiao.setOrdercode(bianhao.getContents());
		
		
		
		
		
		
		
		Cell pnr = sheetHotel.getCell(3, d);
	
		tuipiao.setPnr(pnr.getContents());
		
	
		
		Cell number = sheetHotel.getCell(4, d);
	
		String nu =number.getContents();
		long n = Long.parseLong(nu);
		tuipiao.setNumber(n);
	
	
		
		Cell tuipiaoren = sheetHotel.getCell(5, d);
	
		String num =tuipiaoren.getContents();
		long nua = Long.parseLong(num);
		tuipiao.setRnumber(nua);
	
	
	
		Cell feituitime = sheetHotel.getCell(6, d);
		
		Date aaa = format2.parse(feituitime.getContents());
		tuipiao.setApplytime(new java.sql.Timestamp(aaa.getTime()));
	
		
		Cell zhuangtai = sheetHotel.getCell(7, d);
		tuipiao.setState(zhuangtai.getContents());
		
		
		//offine 8
			
		Cell tuikuanjia = sheetHotel.getCell(9, d);
		if(tuikuanjia.getContents().length()>1){
		tuipiao.setTuiprice(Double.parseDouble(tuikuanjia.getContents()));	
		}
		
		Cell tuikuantime = sheetHotel.getCell(10, d);
		if(tuikuantime.getContents()!=""&&tuikuantime.getContents().length()>1){
		Date tui = format2.parse(tuikuantime.getContents());
		tuipiao.setTuitime(new java.sql.Timestamp(tui.getTime()));
		}
		
		Cell piaohao = sheetHotel.getCell(11, d);
		tuipiao.setTicketno(piaohao.getContents());
		
		Cell chengjiren = sheetHotel.getCell(12, d);
		tuipiao.setPassenger(chengjiren.getContents());
		
		Cell chengjitype = sheetHotel.getCell(13, d);
		tuipiao.setPtype(chengjitype.getContents());
		
		Cell chufa = sheetHotel.getCell(14, d);
		tuipiao.setStartcity(chufa.getContents());
		
		Cell daoda = sheetHotel.getCell(15, d);
		tuipiao.setEndcity(daoda.getContents());
		
		Cell hangcheng = sheetHotel.getCell(16, d);
		tuipiao.setJourneytype(hangcheng.getContents());
		
		Cell gongsi = sheetHotel.getCell(17, d);
		tuipiao.setAircompany(gongsi.getContents());
		
		Cell hangban = sheetHotel.getCell(18, d);
		tuipiao.setCabin(hangban.getContents());
		
		Cell hangbantime = sheetHotel.getCell(19, d);
		Date han = format3.parse(hangbantime.getContents());
		tuipiao.setFlighttime(new java.sql.Timestamp(han.getTime()));
		
		
		Cell cangwei = sheetHotel.getCell(20, d);
		tuipiao.setCabin(cangwei.getContents());
		
		
		Cell piaomian = sheetHotel.getCell(21, d);
		tuipiao.setPrice(Double.parseDouble(piaomian.getContents()));
		
		Cell jijian = sheetHotel.getCell(22, d);
		tuipiao.setJijian(Double.parseDouble(piaomian.getContents()));
		
		Cell yuanyou = sheetHotel.getCell(23, d);
		tuipiao.setRanyou(Double.parseDouble(piaomian.getContents()));
		
		Cell danzhong = sheetHotel.getCell(24, d);
		tuipiao.setTalfee(Double.parseDouble(piaomian.getContents()));
		
		Cell xingcheng = sheetHotel.getCell(25, d);
		tuipiao.setJourneytype(xingcheng.getContents());
		

		Cell jiashoufuwu = sheetHotel.getCell(26, d);
		tuipiao.setFuwufei(Double.parseDouble(jiashoufuwu.getContents()));
		
		Server.getInstance().getAirService().createTuipiao(tuipiao);
		
		
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
	 * 转向到退票报表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	public String todaoru()throws Exception{
		return "todaoru";
	}
	/**
	 * 转向到退票报表修改页面
	 */	
	public String toedit()throws Exception{
	tuipiao = Server.getInstance().getAirService().findTuipiao(tuipiao.getId());
		return EDIT;
	}
	
	/**
	 * 转向到退票报表审核页面
	 */	
	public String tocheck()throws Exception{
	tuipiao = Server.getInstance().getAirService().findTuipiao(tuipiao.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加退票报表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createTuipiao(tuipiao);
		return LIST;
	}

	/**
	 * 审核退票报表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateTuipiaoIgnoreNull(tuipiao);
		return LIST;
	}
	


	/**
	 * 编辑退票报表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateTuipiaoIgnoreNull(tuipiao);
		return LIST;
	}

	/**
	 * 删除退票报表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteTuipiao(tuipiao.getId());
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
					Server.getInstance().getAirService().deleteTuipiao(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回退票报表对象
	 */		
	
	public Object getModel() {
		return tuipiao;
	}
	public List < Tuipiao >   getListTuipiao() {
		return listTuipiao;
	}
	public void setListTuipiao(List <  Tuipiao  >  listTuipiao) {
		this.listTuipiao = listTuipiao;
	}
	public Tuipiao getTuipiao() {
		return tuipiao;
	}
	public void setTuipiao(Tuipiao tuipiao) {
		this.tuipiao = tuipiao;
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
	public File[] getBatchfile() {
		return batchfile;
	}
	public void setBatchfile(File[] batchfile) {
		this.batchfile = batchfile;
	}
	
	
}