/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.SQLException;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.service.ITrainService;
import com.yf.system.base.trainroom.Trainroom;
import com.yf.system.base.util.PageInfo;


public class TrainroomAction extends B2b2cbackAction {
	private List <Trainroom>  trainroomlist;
	private Trainroom trainroom = new Trainroom();
	private ITrainService  service;
	/**
	 * 列表查询火车售票点
	 */	
	public String execute(){
		String where = " where 1=1 ";
		this.installService();
	    List list =service.findAllTrainroomForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		trainroomlist = list;		
		return SUCCESS;
	}
	
	public String toeditroom(){
		this.installService();
		this.trainroom=service.findTrainroom(trainroom.getId());
		return "editroom";
	}
	
	public String editroom(){
		this.installService();
		service.updateTrainroomIgnoreNull(trainroom);
		
		return this.execute();	
		
	}
	
	public String delroom(){
		this.installService();
		service.deleteTrainroom(this.trainroom.getId());
		return this.execute();
	}
	
	
	public String addtrainroom(){
		this.installService();
		try {
			service.createTrainroom(trainroom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.execute();
		
	}
	/**
	 * 转向到火车售票点添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	
	
	private void installService(){
		if(this.service==null){
			this.service=Server.getInstance().getTrainService();
		}
	}

	

	






	/**
	 *  返回火车售票点对象
	 */		
	
	public Object getModel() {
		return trainroom;
	}
	public Trainroom getTrainroom() {
		return trainroom;
	}
	public void setTrainroom(Trainroom trainroom) {
		this.trainroom = trainroom;
	}


	public List<Trainroom> getTrainroomlist() {
		return trainroomlist;
	}


	public void setTrainroomlist(List<Trainroom> trainroomlist) {
		this.trainroomlist = trainroomlist;
	}
	
	
	
}