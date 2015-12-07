package com.yf.service;

import java.net.MalformedURLException;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.yf.system.base.zrate.Zrate;


public class ZrateServer {
	private static ZrateServer server = null;	
	private HessianProxyFactory factory = new HessianProxyFactory();
	private String url="http://127.0.0.1:28080";//114.113.236.101
	private ZrateServer() {
		
		
	}

	public static ZrateServer getInstance() {
		if (server == null) {

			server = new ZrateServer();
			
		
		}
		return server;
	}
	
	 
	public IZratememService getService() {
		try {
			return (IZratememService) factory.create(IZratememService.class, 
					url+"/ZrateServer/service/"+ IZratememService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

	public Zrate createZrate(Zrate rate) {
		
		return getService().createZrate(rate);
	}


	public long deleteZrate(Zrate rate) {
		return getService().deleteZrate(rate);
		
	}


	public void endQuery() {
		getService().endQuery();

	}


	public Zrate findZrate(long agentid, String key) {
		
			return getService().findZrate(agentid, key);
		
	}


	public List searchZrate(String formcity, String tocity, String aircode,
			String cabincode, String formtime, int agentid, String fnumber,
			int isgaofan) {
		
		return getService().searchZrate(formcity, tocity, aircode, cabincode, formtime, agentid, fnumber, isgaofan);
	}


	public void flushAll(long agentid) {
		getService().flushAll(agentid);
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
