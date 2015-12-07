/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomstateback;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RoomstatebackManager extends  SqlMapClientDaoSupport  implements IRoomstatebackManager{ 
	
  
 	/**
	 * 创建 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public Roomstateback createRoomstateback(Roomstateback roomstateback) throws SQLException{
	
		if(roomstateback.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		roomstateback.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ROOMSTATEBACK"));
		getSqlMapClientTemplate().insert("createRoomstateback",roomstateback);
		if(roomstateback.getUcode()==null||roomstateback.getUcode()<1)
		{
			roomstateback.setUcode(roomstateback.getId());
			updateRoomstatebackIgnoreNull(roomstateback);
		}
		return roomstateback;
	}
	/**
	 * 删除 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstateback(long id){
	
		return getSqlMapClientTemplate().delete("deleteRoomstateback", id);
	}
	
	
	/**
	 * 修改 酒店房态表
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstateback(Roomstateback roomstateback){
		return getSqlMapClientTemplate().update("updateRoomstateback",roomstateback);
	
	}

		
	/**
	 * 修改 酒店房态表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstatebackIgnoreNull(Roomstateback roomstateback){
		Roomstateback tmp = findRoomstateback(roomstateback.getId());
		int flag =0;
		
		
		if(roomstateback.getDatenumber()!=null){
			tmp.setDatenumber(roomstateback.getDatenumber());
			
			flag++;
		}
		
		if(roomstateback.getHotelid()!=null){
			tmp.setHotelid(roomstateback.getHotelid());
			
			flag++;
		}
		
		if(roomstateback.getRoomid()!=null){
			tmp.setRoomid(roomstateback.getRoomid());
			
			flag++;
		}
		
		if(roomstateback.getIsvalid()!=null){
			tmp.setIsvalid(roomstateback.getIsvalid());
			
			flag++;
		}
		
		if(roomstateback.getDescription()!=null){
			tmp.setDescription(roomstateback.getDescription());
			
			flag++;
		}
		
		if(roomstateback.getState()!=null){
			tmp.setState(roomstateback.getState());
			
			flag++;
		}
		
		if(roomstateback.getConfirmmethod()!=null){
			tmp.setConfirmmethod(roomstateback.getConfirmmethod());
			
			flag++;
		}
		
		if(roomstateback.getType()!=null){
			tmp.setType(roomstateback.getType());
			
			flag++;
		}
		
		if(roomstateback.getNo31()!=null){
			tmp.setNo31(roomstateback.getNo31());
			
			flag++;
		}
		
		if(roomstateback.getNo30()!=null){
			tmp.setNo30(roomstateback.getNo30());
			
			flag++;
		}
		
		if(roomstateback.getNo29()!=null){
			tmp.setNo29(roomstateback.getNo29());
			
			flag++;
		}
		
		if(roomstateback.getNo28()!=null){
			tmp.setNo28(roomstateback.getNo28());
			
			flag++;
		}
		
		if(roomstateback.getNo27()!=null){
			tmp.setNo27(roomstateback.getNo27());
			
			flag++;
		}
		
		if(roomstateback.getNo26()!=null){
			tmp.setNo26(roomstateback.getNo26());
			
			flag++;
		}
		
		if(roomstateback.getNo25()!=null){
			tmp.setNo25(roomstateback.getNo25());
			
			flag++;
		}
		
		if(roomstateback.getNo24()!=null){
			tmp.setNo24(roomstateback.getNo24());
			
			flag++;
		}
		
		if(roomstateback.getNo23()!=null){
			tmp.setNo23(roomstateback.getNo23());
			
			flag++;
		}
		
		if(roomstateback.getNo22()!=null){
			tmp.setNo22(roomstateback.getNo22());
			
			flag++;
		}
		
		if(roomstateback.getNo21()!=null){
			tmp.setNo21(roomstateback.getNo21());
			
			flag++;
		}
		
		if(roomstateback.getNo20()!=null){
			tmp.setNo20(roomstateback.getNo20());
			
			flag++;
		}
		
		if(roomstateback.getNo19()!=null){
			tmp.setNo19(roomstateback.getNo19());
			
			flag++;
		}
		
		if(roomstateback.getNo18()!=null){
			tmp.setNo18(roomstateback.getNo18());
			
			flag++;
		}
		
		if(roomstateback.getNo17()!=null){
			tmp.setNo17(roomstateback.getNo17());
			
			flag++;
		}
		
		if(roomstateback.getNo16()!=null){
			tmp.setNo16(roomstateback.getNo16());
			
			flag++;
		}
		
		if(roomstateback.getNo15()!=null){
			tmp.setNo15(roomstateback.getNo15());
			
			flag++;
		}
		
		if(roomstateback.getNo14()!=null){
			tmp.setNo14(roomstateback.getNo14());
			
			flag++;
		}
		
		if(roomstateback.getNo13()!=null){
			tmp.setNo13(roomstateback.getNo13());
			
			flag++;
		}
		
		if(roomstateback.getNo12()!=null){
			tmp.setNo12(roomstateback.getNo12());
			
			flag++;
		}
		
		if(roomstateback.getNo11()!=null){
			tmp.setNo11(roomstateback.getNo11());
			
			flag++;
		}
		
		if(roomstateback.getNo10()!=null){
			tmp.setNo10(roomstateback.getNo10());
			
			flag++;
		}
		
		if(roomstateback.getNo9()!=null){
			tmp.setNo9(roomstateback.getNo9());
			
			flag++;
		}
		
		if(roomstateback.getNo8()!=null){
			tmp.setNo8(roomstateback.getNo8());
			
			flag++;
		}
		
		if(roomstateback.getNo7()!=null){
			tmp.setNo7(roomstateback.getNo7());
			
			flag++;
		}
		
		if(roomstateback.getNo6()!=null){
			tmp.setNo6(roomstateback.getNo6());
			
			flag++;
		}
		
		if(roomstateback.getNo5()!=null){
			tmp.setNo5(roomstateback.getNo5());
			
			flag++;
		}
		
		if(roomstateback.getNo4()!=null){
			tmp.setNo4(roomstateback.getNo4());
			
			flag++;
		}
		
		if(roomstateback.getNo3()!=null){
			tmp.setNo3(roomstateback.getNo3());
			
			flag++;
		}
		
		if(roomstateback.getNo2()!=null){
			tmp.setNo2(roomstateback.getNo2());
			
			flag++;
		}
		
		if(roomstateback.getNo1()!=null){
			tmp.setNo1(roomstateback.getNo1());
			
			flag++;
		}
		
		if(roomstateback.getBack31()!=null){
			tmp.setBack31(roomstateback.getBack31());
			
			flag++;
		}
		
		if(roomstateback.getBack30()!=null){
			tmp.setBack30(roomstateback.getBack30());
			
			flag++;
		}
		
		if(roomstateback.getBack29()!=null){
			tmp.setBack29(roomstateback.getBack29());
			
			flag++;
		}
		
		if(roomstateback.getBack28()!=null){
			tmp.setBack28(roomstateback.getBack28());
			
			flag++;
		}
		
		if(roomstateback.getBack27()!=null){
			tmp.setBack27(roomstateback.getBack27());
			
			flag++;
		}
		
		if(roomstateback.getBack26()!=null){
			tmp.setBack26(roomstateback.getBack26());
			
			flag++;
		}
		
		if(roomstateback.getBack25()!=null){
			tmp.setBack25(roomstateback.getBack25());
			
			flag++;
		}
		
		if(roomstateback.getBack24()!=null){
			tmp.setBack24(roomstateback.getBack24());
			
			flag++;
		}
		
		if(roomstateback.getBack23()!=null){
			tmp.setBack23(roomstateback.getBack23());
			
			flag++;
		}
		
		if(roomstateback.getBack22()!=null){
			tmp.setBack22(roomstateback.getBack22());
			
			flag++;
		}
		
		if(roomstateback.getBack21()!=null){
			tmp.setBack21(roomstateback.getBack21());
			
			flag++;
		}
		
		if(roomstateback.getBack20()!=null){
			tmp.setBack20(roomstateback.getBack20());
			
			flag++;
		}
		
		if(roomstateback.getBack19()!=null){
			tmp.setBack19(roomstateback.getBack19());
			
			flag++;
		}
		
		if(roomstateback.getBack18()!=null){
			tmp.setBack18(roomstateback.getBack18());
			
			flag++;
		}
		
		if(roomstateback.getBack17()!=null){
			tmp.setBack17(roomstateback.getBack17());
			
			flag++;
		}
		
		if(roomstateback.getBack16()!=null){
			tmp.setBack16(roomstateback.getBack16());
			
			flag++;
		}
		
		if(roomstateback.getBack15()!=null){
			tmp.setBack15(roomstateback.getBack15());
			
			flag++;
		}
		
		if(roomstateback.getBack14()!=null){
			tmp.setBack14(roomstateback.getBack14());
			
			flag++;
		}
		
		if(roomstateback.getBack13()!=null){
			tmp.setBack13(roomstateback.getBack13());
			
			flag++;
		}
		
		if(roomstateback.getBack12()!=null){
			tmp.setBack12(roomstateback.getBack12());
			
			flag++;
		}
		
		if(roomstateback.getBack11()!=null){
			tmp.setBack11(roomstateback.getBack11());
			
			flag++;
		}
		
		if(roomstateback.getBack10()!=null){
			tmp.setBack10(roomstateback.getBack10());
			
			flag++;
		}
		
		if(roomstateback.getBack9()!=null){
			tmp.setBack9(roomstateback.getBack9());
			
			flag++;
		}
		
		if(roomstateback.getBack8()!=null){
			tmp.setBack8(roomstateback.getBack8());
			
			flag++;
		}
		
		if(roomstateback.getBack7()!=null){
			tmp.setBack7(roomstateback.getBack7());
			
			flag++;
		}
		
		if(roomstateback.getBack6()!=null){
			tmp.setBack6(roomstateback.getBack6());
			
			flag++;
		}
		
		if(roomstateback.getBack5()!=null){
			tmp.setBack5(roomstateback.getBack5());
			
			flag++;
		}
		
		if(roomstateback.getBack4()!=null){
			tmp.setBack4(roomstateback.getBack4());
			
			flag++;
		}
		
		if(roomstateback.getBack3()!=null){
			tmp.setBack3(roomstateback.getBack3());
			
			flag++;
		}
		
		if(roomstateback.getBack2()!=null){
			tmp.setBack2(roomstateback.getBack2());
			
			flag++;
		}
		
		if(roomstateback.getBack1()!=null){
			tmp.setBack1(roomstateback.getBack1());
			
			flag++;
		}
		
		if(roomstateback.getUcode()!=null){
			tmp.setUcode(roomstateback.getUcode());
			
			flag++;
		}
		
		if(roomstateback.getLanguage()!=null){
			tmp.setLanguage(roomstateback.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRoomstateback",tmp);
		}
	}
	
	/**
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Roomstateback.COL_language+" = 0 OR "+Roomstateback.COL_language+" is NULL)";
		}
		else if(where.indexOf(Roomstateback.COL_language)<0)
		{
			where+=" and ("+Roomstateback.COL_language+" = 0 OR "+Roomstateback.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRoomstateback",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店房态表
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstateback(long id){
		return (Roomstateback)(getSqlMapClientTemplate().queryForObject("findRoomstateback",id));
	}
	/**
	 * 查找 酒店房态表 by language
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstatebackbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Roomstateback.COL_ucode+" = "+id+" and "+Roomstateback.COL_language+" = "+language;	
		List list=findAllRoomstateback(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Roomstateback)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Roomstateback.COL_language+" = 0";
		}
		else if(where.indexOf(Roomstateback.COL_language)<0)
		{
			where+=" and "+Roomstateback.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRoomstatebackBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRoomstateback",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店房态表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRoomstatebackBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店房态表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstatebackBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRoomstatebackBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstatebackBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRoomstatebackBySql",map).toString()));
	}
}

