/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelprice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelpriceManager extends  SqlMapClientDaoSupport  implements IHotelpriceManager{ 
	
  
 	/**
	 * 创建 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public Hotelprice createHotelprice(Hotelprice hotelprice) throws SQLException{
	
		if(hotelprice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelprice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELPRICE"));
		getSqlMapClientTemplate().insert("createHotelprice",hotelprice);
		if(hotelprice.getUcode()==null||hotelprice.getUcode()<1)
		{
			hotelprice.setUcode(hotelprice.getId());
			updateHotelpriceIgnoreNull(hotelprice);
		}
		return hotelprice;
	}
	/**
	 * 删除 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelprice(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelprice", id);
	}
	
	
	/**
	 * 修改 酒店价格
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelprice(Hotelprice hotelprice){
		return getSqlMapClientTemplate().update("updateHotelprice",hotelprice);
	
	}

		
	/**
	 * 修改 酒店价格但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelpriceIgnoreNull(Hotelprice hotelprice){
		Hotelprice tmp = findHotelprice(hotelprice.getId());
		int flag =0;
		
		
		if(hotelprice.getDatenumber()!=null){
			tmp.setDatenumber(hotelprice.getDatenumber());
			
			flag++;
		}
		if(hotelprice.getMoytype()!=null){
			tmp.setMoytype(hotelprice.getMoytype());
			
			flag++;
		}
		if(hotelprice.getRateplancode()!=null){
			tmp.setRateplancode(hotelprice.getRateplancode());
			
			flag++;
		}
		if(hotelprice.getRateplanname()!=null){
			tmp.setRateplanname(hotelprice.getRateplanname());
			
			flag++;
		}
		
		if(hotelprice.getHotelid()!=null){
			tmp.setHotelid(hotelprice.getHotelid());
			
			flag++;
		}
		
		if(hotelprice.getPricetype()!=null){
			tmp.setPricetype(hotelprice.getPricetype());
			
			flag++;
		}
		
		if(hotelprice.getDeptprice()!=null){
			tmp.setDeptprice(hotelprice.getDeptprice());
			
			flag++;
		}
		
		if(hotelprice.getEndprice()!=null){
			tmp.setEndprice(hotelprice.getEndprice());
			
			flag++;
		}
		
		if(hotelprice.getRoomid()!=null){
			tmp.setRoomid(hotelprice.getRoomid());
			
			flag++;
		}
		
		if(hotelprice.getIsvalid()!=null){
			tmp.setIsvalid(hotelprice.getIsvalid());
			
			flag++;
		}
		
		if(hotelprice.getNo1()!=null){
			tmp.setNo1(hotelprice.getNo1());
			
			flag++;
		}
		
		if(hotelprice.getNo2()!=null){
			tmp.setNo2(hotelprice.getNo2());
			
			flag++;
		}
		
		if(hotelprice.getNo3()!=null){
			tmp.setNo3(hotelprice.getNo3());
			
			flag++;
		}
		
		if(hotelprice.getNo4()!=null){
			tmp.setNo4(hotelprice.getNo4());
			
			flag++;
		}
		
		if(hotelprice.getNo5()!=null){
			tmp.setNo5(hotelprice.getNo5());
			
			flag++;
		}
		
		if(hotelprice.getNo6()!=null){
			tmp.setNo6(hotelprice.getNo6());
			
			flag++;
		}
		
		if(hotelprice.getNo7()!=null){
			tmp.setNo7(hotelprice.getNo7());
			
			flag++;
		}
		
		if(hotelprice.getNo8()!=null){
			tmp.setNo8(hotelprice.getNo8());
			
			flag++;
		}
		
		if(hotelprice.getNo9()!=null){
			tmp.setNo9(hotelprice.getNo9());
			
			flag++;
		}
		
		if(hotelprice.getNo10()!=null){
			tmp.setNo10(hotelprice.getNo10());
			
			flag++;
		}
		
		if(hotelprice.getNo11()!=null){
			tmp.setNo11(hotelprice.getNo11());
			
			flag++;
		}
		
		if(hotelprice.getNo12()!=null){
			tmp.setNo12(hotelprice.getNo12());
			
			flag++;
		}
		
		if(hotelprice.getNo13()!=null){
			tmp.setNo13(hotelprice.getNo13());
			
			flag++;
		}
		
		if(hotelprice.getNo14()!=null){
			tmp.setNo14(hotelprice.getNo14());
			
			flag++;
		}
		
		if(hotelprice.getNo15()!=null){
			tmp.setNo15(hotelprice.getNo15());
			
			flag++;
		}
		
		if(hotelprice.getNo16()!=null){
			tmp.setNo16(hotelprice.getNo16());
			
			flag++;
		}
		
		if(hotelprice.getNo17()!=null){
			tmp.setNo17(hotelprice.getNo17());
			
			flag++;
		}
		
		if(hotelprice.getNo18()!=null){
			tmp.setNo18(hotelprice.getNo18());
			
			flag++;
		}
		
		if(hotelprice.getNo19()!=null){
			tmp.setNo19(hotelprice.getNo19());
			
			flag++;
		}
		
		if(hotelprice.getNo20()!=null){
			tmp.setNo20(hotelprice.getNo20());
			
			flag++;
		}
		
		if(hotelprice.getNo21()!=null){
			tmp.setNo21(hotelprice.getNo21());
			
			flag++;
		}
		
		if(hotelprice.getNo22()!=null){
			tmp.setNo22(hotelprice.getNo22());
			
			flag++;
		}
		
		if(hotelprice.getNo23()!=null){
			tmp.setNo23(hotelprice.getNo23());
			
			flag++;
		}
		
		if(hotelprice.getNo24()!=null){
			tmp.setNo24(hotelprice.getNo24());
			
			flag++;
		}
		
		if(hotelprice.getNo25()!=null){
			tmp.setNo25(hotelprice.getNo25());
			
			flag++;
		}
		
		if(hotelprice.getNo26()!=null){
			tmp.setNo26(hotelprice.getNo26());
			
			flag++;
		}
		
		if(hotelprice.getNo27()!=null){
			tmp.setNo27(hotelprice.getNo27());
			
			flag++;
		}
		
		if(hotelprice.getNo28()!=null){
			tmp.setNo28(hotelprice.getNo28());
			
			flag++;
		}
		
		if(hotelprice.getNo29()!=null){
			tmp.setNo29(hotelprice.getNo29());
			
			flag++;
		}
		
		if(hotelprice.getNo30()!=null){
			tmp.setNo30(hotelprice.getNo30());
			
			flag++;
		}
		
		if(hotelprice.getNo31()!=null){
			tmp.setNo31(hotelprice.getNo31());
			
			flag++;
		}
		
		if(hotelprice.getDescription()!=null){
			tmp.setDescription(hotelprice.getDescription());
			
			flag++;
		}
		
		if(hotelprice.getUcode()!=null){
			tmp.setUcode(hotelprice.getUcode());
			
			flag++;
		}
		
		if(hotelprice.getLanguage()!=null){
			tmp.setLanguage(hotelprice.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelprice",tmp);
		}
	}
	
	/**
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelprice(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Hotelprice.COL_language+" = 0 OR "+Hotelprice.COL_language+" is NULL)";
		}
		else if(where.indexOf(Hotelprice.COL_language)<0)
		{
			where+=" and ("+Hotelprice.COL_language+" = 0 OR "+Hotelprice.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelprice",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店价格
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelprice(long id){
		return (Hotelprice)(getSqlMapClientTemplate().queryForObject("findHotelprice",id));
	}
	/**
	 * 查找 酒店价格 by language
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelpricebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotelprice.COL_ucode+" = "+id+" and "+Hotelprice.COL_language+" = "+language;	
		List list=findAllHotelprice(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotelprice)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelprice(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Hotelprice.COL_language+" = 0";
		}
		else if(where.indexOf(Hotelprice.COL_language)<0)
		{
			where+=" and "+Hotelprice.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelpriceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelprice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店价格
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelprice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelpriceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店价格
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelpriceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelpriceBySql",map).toString()));
	}
}

