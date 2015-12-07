package com.yf.system.base.fflight;

import java.sql.Timestamp;
import java.util.List;
import java.io.Serializable;

public class AllRouteInfo implements Serializable{
	private int AllRouteID;
	private String RouteStr;
	//
	private List<Route> Routes;
	public int getAllRouteID() {
		return AllRouteID;
	}
	public void setAllRouteID(int allRouteID) {
		AllRouteID = allRouteID;
	}
	public String getRouteStr() {
		return RouteStr;
	}
	public void setRouteStr(String routeStr) {
		RouteStr = routeStr;
	}
	public List<Route> getRoutes() {
		return Routes;
	}
	public void setRoutes(List<Route> routes) {
		Routes = routes;
	}
	
}
