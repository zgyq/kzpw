package com.yf.website.web.servlet;

import java.util.List;

import com.yf.system.atom.component.WriteLog;
import com.yf.system.base.city.City;
import com.yf.system.base.province.Province;
import com.yf.website.web.server.Server;



public class CreateCityJs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Server.getInstance().setUrl("http://localhost:8080/service/service/");
		String where=" where 1=1 and "+City.COL_countryid+" =168 and "+City.COL_provinceid+" >0";
		List<City>list=Server.getInstance().getHotelService().findAllCity(where, " ORDER BY C_ENNAME ", -1, 0);
		System.out.println(list.size());
		StringBuffer sub=new StringBuffer();
		sub.append("cQuery.jsonpResponse={};cQuery.jsonpResponse.suggestion={\"热门\":[");
		StringBuffer subrm=new StringBuffer();
		for(int a=0;a<list.size();a++){
			if(a<20){
			subrm.append("{display:\""+list.get(a).getName().trim()+"\",data:\"|"+list.get(a).getName().trim()+"|"+list.get(a).getId()+"\"}");
			}
			if(a<19){
			subrm.append(",\r");
			}
			if(a==19){
				subrm.append("]},\r");
			}
		}
		StringBuffer abcdef=new StringBuffer();
		abcdef.append("\r 'ABCDEF':[");
		
		StringBuffer GHIJ=new StringBuffer();
		GHIJ.append("\r 'GHIJ':[");
		
		StringBuffer KLMN=new StringBuffer();
		KLMN.append("\r 'KLMN':[");
		
		StringBuffer PQRSTUVW=new StringBuffer();
		PQRSTUVW.append("\r 'PQRSTUVW':[");
		
		StringBuffer XYZ=new StringBuffer();
		XYZ.append("\r 'XYZ':[");
		
		StringBuffer ALLCITY=new StringBuffer();
		ALLCITY.append("\r if (!cQuery.jsonpResponse){cQuery.jsonpResponse={};}cQuery.jsonpResponse.alias=['name_py','name','id','name_jp','index'];cQuery.jsonpResponse.data=\"");
		
		for(int a=0;a<list.size();a++){
			if(list.get(a).getEnname().substring(0, 1).equals("a")||list.get(a).getEnname().substring(0, 1).equals("b")||list.get(a).getEnname().substring(0, 1).equals("c")||list.get(a).getEnname().substring(0, 1).equals("d")
					||list.get(a).getEnname().substring(0, 1).equals("e")||list.get(a).getEnname().substring(0, 1).equals("f")){
			 abcdef.append("{display:\""+list.get(a).getName().trim()+"\",data:\"|"+list.get(a).getName().trim()+"|"+list.get(a).getId()+"\"},\r");
			}
			if(list.get(a).getEnname().substring(0, 1).equals("g")||list.get(a).getEnname().substring(0, 1).equals("h")||list.get(a).getEnname().substring(0, 1).equals("i")||list.get(a).getEnname().substring(0, 1).equals("j")
			){
				GHIJ.append("{display:\""+list.get(a).getName().trim()+"\",data:\"|"+list.get(a).getName().trim()+"|"+list.get(a).getId()+"\"},\r");
			}
			if(list.get(a).getEnname().substring(0, 1).equals("k")||list.get(a).getEnname().substring(0, 1).equals("l")||list.get(a).getEnname().substring(0, 1).equals("m")||list.get(a).getEnname().substring(0, 1).equals("n")
			){
				KLMN.append("{display:\""+list.get(a).getName().trim()+"\",data:\"|"+list.get(a).getName().trim()+"|"+list.get(a).getId()+"\"},\r");
			}
			if(list.get(a).getEnname().substring(0, 1).equals("p")||list.get(a).getEnname().substring(0, 1).equals("q")||list.get(a).getEnname().substring(0, 1).equals("r")||list.get(a).getEnname().substring(0, 1).equals("s")
			 ||list.get(a).getEnname().substring(0, 1).equals("t")||list.get(a).getEnname().substring(0, 1).equals("u")||list.get(a).getEnname().substring(0, 1).equals("v")||list.get(a).getEnname().substring(0, 1).equals("w")){
				PQRSTUVW.append("{display:\""+list.get(a).getName().trim()+"\",data:\"|"+list.get(a).getName().trim()+"|"+list.get(a).getId()+"\"},\r");
			}
			
			if(list.get(a).getEnname().substring(0, 1).equals("x")||list.get(a).getEnname().substring(0, 1).equals("y")||list.get(a).getEnname().substring(0, 1).equals("z")
			){
				XYZ.append("{display:\""+list.get(a).getName().trim()+"\",data:\"|"+list.get(a).getName().trim()+"|"+list.get(a).getId()+"\"},\r");
			}
			
			Province province=Server.getInstance().getHotelService().findProvince(list.get(a).getProvinceid());
			ALLCITY.append("@"+list.get(a).getEnname().trim()+"|"+list.get(a).getName().trim()+"|"+list.get(a).getId()+"|"+list.get(a).getEnname().trim()+"|"+list.get(a).getEnname().trim()+"||||"+province.getId()+"|"+province.getName().trim()+"");
		}
		WriteLog.write("ALLCITY", ALLCITY.toString().trim()+"@\";");
		sub.append(subrm.toString().trim());
		String abcstr=abcdef.toString();
		sub.append(abcstr.substring(0, abcstr.length()-1)+"],");
	  	sub.append(GHIJ.toString().substring(0, GHIJ.toString().length()-1)+"],");
	  	sub.append(KLMN.toString().substring(0, KLMN.toString().length()-1)+"],");
	  	sub.append(PQRSTUVW.toString().substring(0, PQRSTUVW.toString().length()-1)+"],");
	  	sub.append(XYZ.toString().substring(0, XYZ.toString().length()-1)+"]};");
	  	sub.append(ALLCITY.toString());
		/*System.out.println(sub.toString()+subrm.toString());
		System.out.println(abcdef.toString());
		System.out.println(GHIJ.toString());
		System.out.println(KLMN.toString());
		System.out.println(PQRSTUVW.toString());
		System.out.println(XYZ.toString());
		System.out.println(ALLCITY.toString());*/
		WriteLog.write("city_20130427_gb2312", sub.toString().trim()+"\";");
		System.out.println("OK");
		//System.out.println(sub.toString()+subrm.toString()+abcdef.toString()+GHIJ.toString()+KLMN.toString()+PQRSTUVW.toString()+XYZ.toString()+ALLCITY.toString()+"\";");
	}

}
