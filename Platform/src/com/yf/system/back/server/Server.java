package com.yf.system.back.server;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.webservice.webservice.ITicketWebService;
import com.yf.system.atom.service.IAtomService;
import com.yf.system.atom.service.IManGoHotelService;
import com.yf.system.atom.service.ITicketSearchService;
import com.yf.system.atom.service.IYiHaiCarService;
import com.yf.system.base.service.IAirService;
import com.yf.system.base.service.ICarService;
import com.yf.system.base.service.ICompanyService;
import com.yf.system.base.service.IHotelService;
import com.yf.system.base.service.IInterhotelService;
import com.yf.system.base.service.IInterticketService;
import com.yf.system.base.service.IMemberService;
import com.yf.system.base.service.IServicecenterService;
import com.yf.system.base.service.ISystemService;
import com.yf.system.base.service.ITrainService;
import com.yf.system.base.service.ITripService;
import com.yf.service.IHotelInterService;
import com.yf.service.IRateService;
import com.yf.service.IZratememService;
	


public class Server {
	private static Server server = null;
	private HessianProxyFactory factory = new HessianProxyFactory();
	private String url;
	private String urlAtom;
	private String inter ;
	private String hotelinter="" ;
	private String weburl="http://localhost:8080/webservice/wservice/" ;
	private String redzrate ;
	
	private Server() {
	}
	
	public static Server getInstance() {
		if (server == null) {
			
			server = new Server();
		}
		return server;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlAtom() {
		return urlAtom;
	}

	public void setUrlAtom(String urlAtom) {
		this.urlAtom = urlAtom;
	}
	
public IHotelInterService getHotelInterService(){
		
		try {
			return (IHotelInterService) factory.create(IHotelInterService.class, hotelinter
					+ IHotelInterService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ITicketWebService getticketWebService(){
		try {
			return (ITicketWebService) factory.create(ITicketWebService.class, weburl
					+ ITicketWebService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public IAirService getAirService() {
		try {
			return (IAirService) factory.create(IAirService.class, url
					+ IAirService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ICompanyService getCompanyService() {
		try {
			return (ICompanyService) factory.create(ICompanyService.class, url
					+ ICompanyService.class.getSimpleName());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public ITrainService getTrainService() {
		try {
			return (ITrainService) factory.create(ITrainService.class, url
					+ ITrainService.class.getSimpleName());
		} catch (MalformedURLException e) {
			System.out.println("****调用TrainService出现异常：");
			e.printStackTrace();
			return null;
		}
	}
	public IInterhotelService getInterHotelService(){
		try {
			return (IInterhotelService) factory.create(IInterhotelService.class, url
					+ IInterhotelService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ICarService getCarService(){
		try {
			return (ICarService) factory.create(ICarService.class, url
					+ ICarService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public IHotelService getHotelService(){
		try {
			return (IHotelService) factory.create(IHotelService.class, url
					+ IHotelService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public IMemberService getMemberService() {
		try {
			return (IMemberService) factory.create(IMemberService.class, url
					+ IMemberService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ITicketSearchService getTicketSearchService(){
		try {
			return (ITicketSearchService) factory.create(ITicketSearchService.class, urlAtom
					+ ITicketSearchService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public IAtomService getAtomService(){
		try {
			return (IAtomService) factory.create(IAtomService.class, urlAtom
					+ IAtomService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public IServicecenterService getServiceCenter(){
		try {
			return (IServicecenterService) factory.create(IServicecenterService.class, url
					+ IServicecenterService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public ISystemService getSystemService(){
	try {
		return (ISystemService) factory.create(ISystemService.class, url
				+ ISystemService.class.getSimpleName());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}	
	public IInterticketService getInterticketService(){
		try {
			return (IInterticketService) factory.create(IInterticketService.class, url
					+ IInterticketService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ITripService getTripService(){
		try {
			return (ITripService) factory.create(ITripService.class,
					url + ITripService.class.getSimpleName());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public IManGoHotelService getManGoHotelService(){
		try {
			return (IManGoHotelService) factory.create(IManGoHotelService.class, urlAtom
					+ IManGoHotelService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}
	
	public IRateService getRateService(){
		
		try {
			return (IRateService) factory.create(IRateService.class, inter
					+ IRateService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public IZratememService getService() {
		try {
			return (IZratememService) factory.create(IZratememService.class, 
					redzrate+"/ZrateServer/service/"+ IZratememService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public IYiHaiCarService getYiHaiCarService(){
		try {
			return (IYiHaiCarService) factory.create(IYiHaiCarService.class, urlAtom
					+ IYiHaiCarService.class.getSimpleName());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}

	public String getInter() {
		return inter;
	}

	public void setInter(String inter) {
		this.inter = inter;
	}

	public static Server getServer() {
		return server;
	}

	public static void setServer(Server server) {
		Server.server = server;
	}

	public HessianProxyFactory getFactory() {
		return factory;
	}

	public void setFactory(HessianProxyFactory factory) {
		this.factory = factory;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public String getHotelinter() {
		return hotelinter;
	}

	public void setHotelinter(String hotelinter) {
		this.hotelinter = hotelinter;
	}
	
}
