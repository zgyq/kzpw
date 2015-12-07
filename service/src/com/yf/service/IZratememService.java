package com.yf.service;

import java.util.List;

import com.yf.system.base.zrate.Zrate;

public interface IZratememService {
	
	//政策自增ID
	public static  final String ID_KEY = "zrate_id";
	
	//查询对象键值
	public static  final String QUERY_KEY = "zrate_query";
	
	//政策列表值前缀
	public static  final String PRE_AGENT_KEY = "agent_";
	
	
	public Zrate createZrate(Zrate rate);
	public long  deleteZrate(Zrate rate);
	public Zrate findZrate(long agentid,String key);
	public List searchZrate(String formcity,String tocity,String aircode,String cabincode,
			String formtime,int agentid,String fnumber,int isgaofan);
	public void endQuery();
	public void flushAll(long agentid);
	
	public Object getObject(String key);
	
	public Zrate getZrate(long agentid,String key);
	
	public List getObjectList(String key);

	public boolean setObject(String key,Object obj);
	
}
