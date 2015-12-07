package com.yf.system.base.interflightinfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.Serializable;

public class InterFlight implements Serializable,Comparator<InterFlight>,Comparable<InterFlight>{
	
	// 航程ID
	private String Fid;
	
	// 价格D
	private String Pid;
	
	
	// 价格信息
	private String Priceinfo;
	
	// 起飞机场
	private String StartAirport;
	// 起飞起场名称
	private String StartAirportName;
	// 起飞城市名字
	private String StartCityName;
	
	// 起飞机场航站楼
	private String StartAirportHZL;
	
	
	
	// 到达机场
	private String EndAirport;
	
	// 到达城市名字
	private String EndCityName;
	
	// 到达机场航站楼
	private String EndAirportHZL;
	
	// 餐饮
	private String meal;
	
	// 飞行时间
	private String FltTm;
	
	//距离
	private Double distance;

	// 到达机场名称
	private String EndAirportName;

	// 起飞起场城市名称
	private String StartAirportCity;
	// 航线
	private String Airline;
	// 航空公司
	private String AirCompany;
	// 航空公司名称
	private String AirCompanyName;

	// 机场建设费
	private Integer AirportFee;

	// 燃油费
	private Integer FuelFee;
	
	// 燃油费儿童
	private Integer FuelFeeCHD;

	// 起飞时间
	private String DepartTime;

	// 到达时间
	private String ArriveTime;

	//全价价格
	private float YPrice;
	//暂时不用
	//private Integer CPrice;
	//private Integer FPrice;
	
	//是否是共享航班
	private Integer IsShare;
	//共享航班号
	private String ShareFlightNumber;

	// 飞机型号
	private String AirplaneType;
	// 飞机型号描述
	private String AirplaneTypeDesc;
	
	private String BorderPointAT;
	
	private String OffPointAT;

	private boolean IsStop;
	private String IsStopInfo;
	
	// 飞行时间
	private String Duration;
	// 到达天数
	private String ArrivalDays;
	
	private List<InterCarbinInfo> Carbins = new ArrayList<InterCarbinInfo>();
	
	private InterCarbinInfo LowCarbin;

	public String getStartAirport() {
		return StartAirport;
	}

	public void setStartAirport(String startAirport) {
		StartAirport = startAirport;
	}

	public String getStartAirportName() {
		return StartAirportName;
	}

	public void setStartAirportName(String startAirportName) {
		StartAirportName = startAirportName;
	}

	public String getEndAirport() {
		return EndAirport;
	}

	public void setEndAirport(String endAirport) {
		EndAirport = endAirport;
	}

	public String getEndAirportName() {
		return EndAirportName;
	}

	public void setEndAirportName(String endAirportName) {
		EndAirportName = endAirportName;
	}

	public String getStartAirportCity() {
		return StartAirportCity;
	}

	public void setStartAirportCity(String startAirportCity) {
		StartAirportCity = startAirportCity;
	}

	public String getAirline() {
		return Airline;
	}

	public void setAirline(String airline) {
		Airline = airline;
	}

	public String getAirCompany() {
		return AirCompany;
	}

	public void setAirCompany(String airCompany) {
		AirCompany = airCompany;
	}

	public String getAirCompanyName() {
		return AirCompanyName;
	}

	public void setAirCompanyName(String airCompanyName) {
		AirCompanyName = airCompanyName;
	}

	public Integer getAirportFee() {
		return AirportFee;
	}

	public void setAirportFee(Integer airportFee) {
		AirportFee = airportFee;
	}

	public Integer getFuelFee() {
		return FuelFee;
	}

	public void setFuelFee(Integer fuelFee) {
		FuelFee = fuelFee;
	}

	

	public String getDepartTime() {
		return DepartTime;
	}

	public void setDepartTime(String departTime) {
		DepartTime = departTime;
	}

	public String getArriveTime() {
		return ArriveTime;
	}

	public void setArriveTime(String arriveTime) {
		ArriveTime = arriveTime;
	}

	public Float getYPrice() {
		return YPrice;
	}

	public void setYPrice(Integer price) {
		YPrice = price;
	}

	//public Integer getCPrice() {
		//return CPrice;
	//}

	//public void setCPrice(Integer price) {
		//CPrice = price;
	//}

	//public Integer getFPrice() {
		//return FPrice;
	//}

	//public void setFPrice(Integer price) {
		//FPrice = price;
	//}

	public String getAirplaneType() {
		return AirplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		AirplaneType = airplaneType;
	}

	public String getAirplaneTypeDesc() {
		return AirplaneTypeDesc;
	}

	public void setAirplaneTypeDesc(String airplaneTypeDesc) {
		AirplaneTypeDesc = airplaneTypeDesc;
	}

	public boolean isStop() {
		return IsStop;
	}

	public void setStop(boolean isStop) {
		IsStop = isStop;
	}

	public String getIsStopInfo() {
		return IsStopInfo;
	}

	public void setIsStopInfo(String isStopInfo) {
		IsStopInfo = isStopInfo;
	}

	public List<InterCarbinInfo> getCarbins() {
		return Carbins;
	}

	public void setCarbins(List<InterCarbinInfo> carbins) {
		Carbins = carbins;
	}

	public InterCarbinInfo getLowCarbin() {
		return LowCarbin;
	}

	public void setLowCarbin(InterCarbinInfo lowCarbin) {
		LowCarbin = lowCarbin;
	}

	public String getBorderPointAT() {
		return BorderPointAT;
	}

	public void setBorderPointAT(String borderPointAT) {
		BorderPointAT = borderPointAT;
	}

	public String getOffPointAT() {
		return OffPointAT;
	}

	public void setOffPointAT(String offPointAT) {
		OffPointAT = offPointAT;
	}

	@Override
	public int compareTo(InterFlight o) {
		
		return this.Airline.compareTo(o.getAirline());
	}

	@Override
	public int compare(InterFlight o1, InterFlight o2) {
		// TODO Auto-generated method stub
		return o1.getAirline().compareTo(o2.getAirline());
	}
	
	    public int hashCode()
	    {
	        return new Integer(Airline.length()).hashCode();
	    }
	    
	    @Override
	    public boolean equals(Object st)
	    {
	        InterFlight fi= (InterFlight) st;
	        return this.Airline.equals(fi.getAirline());
	    } 
	    
	    public String toString()
	    {
	        return Airline;
	    }

		public Integer getIsShare() {
			return IsShare;
		}

		public void setIsShare(Integer isShare) {
			IsShare = isShare;
		}

		public String getShareFlightNumber() {
			return ShareFlightNumber;
		}

		public void setShareFlightNumber(String shareFlightNumber) {
			ShareFlightNumber = shareFlightNumber;
		}

		public String getStartAirportHZL() {
			return StartAirportHZL;
		}

		public void setStartAirportHZL(String startAirportHZL) {
			StartAirportHZL = startAirportHZL;
		}

		public String getEndAirportHZL() {
			return EndAirportHZL;
		}

		public void setEndAirportHZL(String endAirportHZL) {
			EndAirportHZL = endAirportHZL;
		}

		public void setYPrice(float price) {
			YPrice = price;
		}

		public String getMeal() {
			return meal;
		}

		public void setMeal(String meal) {
			this.meal = meal;
		}

		public Double getDistance() {
			return distance;
		}

		public void setDistance(Double distance) {
			this.distance = distance;
		}

		public String getFltTm() {
			return FltTm;
		}

		public void setFltTm(String fltTm) {
			FltTm = fltTm;
		}

		public Integer getFuelFeeCHD() {
			return FuelFeeCHD;
		}

		public void setFuelFeeCHD(Integer fuelFeeCHD) {
			FuelFeeCHD = fuelFeeCHD;
		}

		public String getFid() {
			return Fid;
		}

		public void setFid(String fid) {
			Fid = fid;
		}

		public String getPid() {
			return Pid;
		}

		public void setPid(String pid) {
			Pid = pid;
		}

		public String getPriceinfo() {
			return Priceinfo;
		}

		public void setPriceinfo(String priceinfo) {
			Priceinfo = priceinfo;
		}

		public String getStartCityName() {
			return StartCityName;
		}

		public void setStartCityName(String startCityName) {
			StartCityName = startCityName;
		}

		public String getEndCityName() {
			return EndCityName;
		}

		public void setEndCityName(String endCityName) {
			EndCityName = endCityName;
		}

		public String getDuration() {
			return Duration;
		}

		public void setDuration(String duration) {
			Duration = duration;
		}

		public String getArrivalDays() {
			return ArrivalDays;
		}

		public void setArrivalDays(String arrivalDays) {
			ArrivalDays = arrivalDays;
		}

}
