/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */

package com.yf.system.base.orderinfo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.PageInfo;

public class OrderinfoManager extends SqlMapClientDaoSupport implements
		IOrderinfoManager {

	/**
	 * 创建 订单信息表
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Orderinfo createOrderinfo(Orderinfo orderinfo) throws SQLException {

		if (orderinfo.getId() > 0) {
			throw new SQLException("ID must <= 0.");
		}
		// 将不再使用 此种 获取ID 方法。by：小陈
		// orderinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource()
		// .getConnection(), "T_ORDERINFO"));
		Integer outstate = null;
		orderinfo.setExtorderstatus(null);
			if (orderinfo.getExtorderid() != null) {
				orderinfo.setExtorderstatus(1);
			}
		
		getSqlMapClientTemplate().insert("createOrderinfo", orderinfo);
		if (orderinfo.getUcode() == null || orderinfo.getUcode() < 1) {
			orderinfo.setUcode(orderinfo.getId());
			updateOrderinfoIgnoreNull(orderinfo);
		}
		return orderinfo;
	}

	/**
	 * 删除 订单信息表
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteOrderinfo(long id) {

		return getSqlMapClientTemplate().delete("deleteOrderinfo", id);
	}

	/**
	 * 修改 订单信息表
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateOrderinfo(Orderinfo orderinfo) {
		return getSqlMapClientTemplate().update("updateOrderinfo", orderinfo);

	}

	/**
	 * 修改 订单信息表但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateOrderinfoIgnoreNull(Orderinfo orderinfo) {
		Orderinfo tmp = findOrderinfo(orderinfo.getId());
		int flag = 0;

		if (orderinfo.getOrdernumber() != null) {
			tmp.setOrdernumber(orderinfo.getOrdernumber());
			flag++;
		}

		if (orderinfo.getBuyagentid() != null) {
			tmp.setBuyagentid(orderinfo.getBuyagentid());

			flag++;
		}
		
		if (orderinfo.getB2cprofit() != null) {
			tmp.setB2cprofit(orderinfo.getB2cprofit());

			flag++;
		}
		if (orderinfo.getCclientpayprice() != null) {
			tmp.setCclientpayprice(orderinfo.getCclientpayprice());

			flag++;
		}

		if (orderinfo.getIsbackinsur() > 0) {
			tmp.setIsbackinsur(orderinfo.getIsbackinsur());
			flag++;
		}

		if (orderinfo.getPolicyid() != null) {
			tmp.setPolicyid(orderinfo.getPolicyid());

			flag++;
		}
		if (orderinfo.getPnrtxt() != null) {
			tmp.setPnrtxt(orderinfo.getPnrtxt());

			flag++;
		}
		if (orderinfo.getPattxt() != null) {
			tmp.setPattxt(orderinfo.getPattxt());

			flag++;
		}

		if (orderinfo.getCashier() != null) {
			tmp.setCashier(orderinfo.getCashier());
			flag++;
		}
		
	
		if (orderinfo.getNewextorderid() != null) {
			tmp.setNewextorderid(orderinfo.getNewextorderid());
			flag++;
		}

		if (orderinfo.getFkmethod() != null) {
			tmp.setFkmethod(orderinfo.getFkmethod());
			flag++;
		}
		if (orderinfo.getContactmsgtype() != null) {
			tmp.setContactmsgtype(orderinfo.getContactmsgtype());
			flag++;
		}
		if (orderinfo.getOldorderstatus() != null) {
			tmp.setOldorderstatus(orderinfo.getOldorderstatus());
			flag++;
		}
		if (orderinfo.getContactname() != null) {
			tmp.setContactname(orderinfo.getContactname());

			flag++;
		}

		if (orderinfo.getReturnprice() != null) {
			tmp.setReturnprice(orderinfo.getReturnprice());
			flag++;
		}

		if (orderinfo.getCustomeragentid() != null) {
			tmp.setCustomeragentid(orderinfo.getCustomeragentid());
			flag++;
		}
		if (orderinfo.getContactmobile() != null) {
			tmp.setContactmobile(orderinfo.getContactmobile());

			flag++;
		}
		if (orderinfo.getIsprint() != null) {
			tmp.setIsPrint(orderinfo.getIsprint());

			flag++;
		}

		if (orderinfo.getOperateagent() != null) {
			tmp.setOperateagent(orderinfo.getOperateagent());
			flag++;
		}
		if (orderinfo.getMemo() != null) {
			tmp.setMemo(orderinfo.getMemo());

			flag++;
		}
		if (orderinfo.getFxssuotime() != null) {
			tmp.setFxssuotime(orderinfo.getFxssuotime());

			flag++;
		}
		if (orderinfo.getGyssuotime() != null) {
			tmp.setGyssuotime(orderinfo.getGyssuotime());

			flag++;
		}

		if (orderinfo.getReceipt() != null) {
			tmp.setReceipt(orderinfo.getReceipt());

			flag++;
		}

		if (orderinfo.getAddresa() != null) {
			tmp.setAddresa(orderinfo.getAddresa());

			flag++;
		}
		if (orderinfo.getQuxiaotime() != null) {
			tmp.setQuxiaotime(orderinfo.getQuxiaotime());

			flag++;
		}

		if (orderinfo.getOrderstatus() != null) {
			tmp.setOrderstatus(orderinfo.getOrderstatus());

			flag++;
		}

		if (orderinfo.getTotalfuelfee() != null) {
			tmp.setTotalfuelfee(orderinfo.getTotalfuelfee());

			flag++;
		}

		if (orderinfo.getTotalairportfee() != null) {
			tmp.setTotalairportfee(orderinfo.getTotalairportfee());

			flag++;
		}

		if (orderinfo.getTotalticketprice() != null) {
			tmp.setTotalticketprice(orderinfo.getTotalticketprice());

			flag++;
		}

		if (orderinfo.getCreatetime() != null) {
			tmp.setCreatetime(orderinfo.getCreatetime());

			flag++;
		}

		if (orderinfo.getRelationorderid() != null) {
			tmp.setRelationorderid(orderinfo.getRelationorderid());

			flag++;
		}

		if (orderinfo.getTuistatus() != null) {
			tmp.setTuistatus(orderinfo.getTuistatus());

			flag++;
		}

		if (orderinfo.getContacttel() != null) {
			tmp.setContacttel(orderinfo.getContacttel());

			flag++;
		}

		if (orderinfo.getPnr() != null) {
			tmp.setPnr(orderinfo.getPnr());

			flag++;
		}

		if (orderinfo.getPaystatus() != null) {
			tmp.setPaystatus(orderinfo.getPaystatus());

			flag++;
		}

		if (orderinfo.getPaymethod() != null) {
			tmp.setPaymethod(orderinfo.getPaymethod());

			flag++;
		}

		if (orderinfo.getSaleagentid() != null) {
			tmp.setSaleagentid(orderinfo.getSaleagentid());

			flag++;
		}

		if (orderinfo.getCustomeruserid() != null) {
			tmp.setCustomeruserid(orderinfo.getCustomeruserid());

			flag++;
		}

		if (orderinfo.getNotetype() != null) {
			tmp.setNotetype(orderinfo.getNotetype());

			flag++;
		}

		if (orderinfo.getContactemail() != null) {
			tmp.setContactemail(orderinfo.getContactemail());

			flag++;
		}

		if (orderinfo.getContactfax() != null) {
			tmp.setContactfax(orderinfo.getContactfax());

			flag++;
		}

		if (orderinfo.getPrinttime() != null) {
			tmp.setPrinttime(orderinfo.getPrinttime());

			flag++;
		}

		if (orderinfo.getRatevalue() != null) {
			tmp.setRatevalue(orderinfo.getRatevalue());

			flag++;
		}

		if (orderinfo.getUcode() != null) {
			tmp.setUcode(orderinfo.getUcode());

			flag++;
		}

		if (orderinfo.getLanguage() != null) {
			tmp.setLanguage(orderinfo.getLanguage());

			flag++;
		}

		if (orderinfo.getPostmoney() != null) {
			tmp.setPostmoney(orderinfo.getPostmoney());

			flag++;
		}

		if (orderinfo.getPostname() != null) {
			tmp.setPostname(orderinfo.getPostname());

			flag++;
		}

		if (orderinfo.getPostmobile() != null) {
			tmp.setPostmobile(orderinfo.getPostmobile());

			flag++;
		}

		if (orderinfo.getPostcode() != null) {
			tmp.setPostcode(orderinfo.getPostcode());

			flag++;
		}

		if (orderinfo.getOrdertype() != null) {
			tmp.setOrdertype(orderinfo.getOrdertype());

			flag++;
		}

		if (orderinfo.getUserid() != null) {
			tmp.setUserid(orderinfo.getUserid());

			flag++;
		}

		if (orderinfo.getUpdatetime() != null) {
			tmp.setUpdatetime(orderinfo.getUpdatetime());

			flag++;
		}
		if (orderinfo.getFenxiaouserid() != null) {
			tmp.setFenxiaouserid(orderinfo.getFenxiaouserid());

			flag++;
		}

		if (orderinfo.getFenxiaoupdatetime() != null) {
			tmp.setFenxiaoupdatetime(orderinfo.getFenxiaoupdatetime());

			flag++;
		}
		if (orderinfo.getFenxiaooperstate() != null) {
			tmp.setFenxiaooperstate(orderinfo.getFenxiaooperstate());

			flag++;
		}
		if (orderinfo.getBigpnr() != null) {
			tmp.setBigpnr(orderinfo.getBigpnr());

			flag++;
		}
		if (orderinfo.getOperatingstate() != null) {
			tmp.setOperatingstate(orderinfo.getOperatingstate());

			flag++;
		}
		if (orderinfo.getGaiorderid() != null) {
			tmp.setGaiorderid(orderinfo.getGaiorderid());

			flag++;
		}

		if (orderinfo.getPeisongrenid() != null) {
			tmp.setPeisongrenid(orderinfo.getPeisongrenid());

			flag++;
		}

		if (orderinfo.getPeisongstatus() != null) {
			tmp.setPeisongstatus(orderinfo.getPeisongstatus());

			flag++;
		}
		if (orderinfo.getPickonename() != null) {
			tmp.setPickonename(orderinfo.getPickonename());

			flag++;
		}

		if (orderinfo.getPickonephone() != null) {
			tmp.setPickonephone(orderinfo.getPickonephone());

			flag++;
		}

		if (orderinfo.getBusystatus() != null) {
			tmp.setBusystatus(orderinfo.getBusystatus());

			flag++;
		}

		if (orderinfo.getGuazhangrenid() != null) {
			tmp.setGuazhangrenid(orderinfo.getGuazhangrenid());

			flag++;
		}

		if (orderinfo.getPeisongdate() != null) {
			tmp.setPeisongdate(orderinfo.getPeisongdate());

			flag++;
		}

		if (orderinfo.getNewpnr() != null) {
			tmp.setNewpnr(orderinfo.getNewpnr());

			flag++;
		}

		if (orderinfo.getNewticnum() != null) {
			tmp.setNewticnum(orderinfo.getNewticnum());

			flag++;
		}

		if (orderinfo.getNewordernum() != null) {
			tmp.setNewordernum(orderinfo.getNewordernum());

			flag++;
		}

		if (orderinfo.getExtpolicyid() != null) {
			tmp.setExtpolicyid(orderinfo.getExtpolicyid());

			flag++;
		}

		if (orderinfo.getPolicyagentid() != null) {
			tmp.setPolicyagentid(orderinfo.getPolicyagentid());

			flag++;
		}

		if (orderinfo.getExtorderid() != null) {
			tmp.setExtorderid(orderinfo.getExtorderid());

			flag++;
		}

		if (orderinfo.getExtorderstatus() != null) {
			tmp.setExtorderstatus(orderinfo.getExtorderstatus());

			flag++;
		}

		if (orderinfo.getExtorderpolicyid() != null) {
			tmp.setExtorderpolicyid(orderinfo.getExtorderpolicyid());

			flag++;
		}

		if (orderinfo.getExtorderepolicyid() != null) {
			tmp.setExtorderepolicyid(orderinfo.getExtorderepolicyid());

			flag++;
		}

		if (orderinfo.getExtorderprice() != null) {
			tmp.setExtorderprice(orderinfo.getExtorderprice());

			flag++;
		}

		if (orderinfo.getCreditcardid() != null) {
			tmp.setCreditcardid(orderinfo.getCreditcardid());
			flag++;
		}

		if (orderinfo.getFenxiaoshangfandian() != null) {
			tmp.setFenxiaoshangfandian(orderinfo.getFenxiaoshangfandian());

			flag++;
		}

		if (orderinfo.getExtordercreatetime() != null) {
			tmp.setExtordercreatetime(orderinfo.getExtordercreatetime());

			flag++;
		}

		if (orderinfo.getShengcangorderid() != null) {
			tmp.setSaleagentid(orderinfo.getShengcangorderid());

			flag++;
		}

		if (orderinfo.getShengcangoldtn() != null) {
			tmp.setShengcangoldtn(orderinfo.getShengcangoldtn());

			flag++;
		}

		if (orderinfo.getIsshengcang() != null) {
			tmp.setIsshengcang(orderinfo.getIsshengcang());

			flag++;
		}

		if (orderinfo.getExtreturnprice() != null) {
			tmp.setExtreturnprice(orderinfo.getExtreturnprice());
			flag++;
		}

		if (orderinfo.getShengcangorderid() != null) {
			tmp.setSaleagentid(orderinfo.getShengcangorderid());

			flag++;
		}

		if (orderinfo.getTotalanjian() != null) {
			tmp.setTotalanjian(orderinfo.getTotalanjian());

			flag++;
		}

		if (orderinfo.getTotalotherfee() != null) {
			tmp.setTotalotherfee(orderinfo.getTotalotherfee());

			flag++;
		}

		if (orderinfo.getInternal() != null) {
			tmp.setInternal(orderinfo.getInternal());

			flag++;
		}

		if (orderinfo.getZhekoujine() != null) {
			tmp.setZhekoujine(orderinfo.getZhekoujine());

			flag++;
		}

		if (orderinfo.getIsmutily() != null) {
			tmp.setIsmutily(orderinfo.getIsmutily());

			flag++;
		}

		if (orderinfo.getRebatemoney() != null) {
			tmp.setRebatemoney(orderinfo.getRebatemoney());

			flag++;
		}

		if (orderinfo.getBackpointinfo() != null) {
			tmp.setBackpointinfo(orderinfo.getBackpointinfo());

			flag++;
		}
		if (orderinfo.getPaymenturl() != null) {
			tmp.setPaymenturl(orderinfo.getPaymenturl());

			flag++;
		}

		if (orderinfo.getCurrplatfee() != null) {
			tmp.setCurrplatfee(orderinfo.getCurrplatfee());

			flag++;
		}

		if (flag == 0) {
			return 0;
		} else {
			return getSqlMapClientTemplate().update("updateOrderinfo", tmp);
		}
	}

	/**
	 * 查找 订单信息表
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinfo(String where, String orderby, int limit,
			int offset) {
		if (where == null || where.trim().length() == 0) {
			where = " where (" + Orderinfo.COL_language + " = 0 OR "
					+ Orderinfo.COL_language + " is NULL)";
		} else if (where.indexOf(Orderinfo.COL_language) < 0) {
			where += " and (" + Orderinfo.COL_language + " = 0 OR "
					+ Orderinfo.COL_language + " is NULL)";
		}
		Map map = new HashMap();
		if (limit < 0) {
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllOrderinfo", map,
				offset, limit);
	}

	/**
	 * 查找 订单信息表
	 * 
	 * @param id
	 * @return
	 */
	public Orderinfo findOrderinfo(long id) {
		return (Orderinfo) (getSqlMapClientTemplate().queryForObject(
				"findOrderinfo", id));
	}

	/**
	 * 查找 订单信息表 by language
	 * 
	 * @param id
	 * @return
	 */
	public Orderinfo findOrderinfobylanguage(long id, Integer language) {
		String where = " where 1=1 and " + Orderinfo.COL_ucode + " = " + id
				+ " and " + Orderinfo.COL_language + " = " + language;
		List list = findAllOrderinfo(where, "", -1, 0);
		if (list != null && list.size() > 0) {
			return (Orderinfo) list.get(0);
		}
		return null;
	}

	/**
	 * 查找 订单信息表
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOrderinfo(String where, String orderby, PageInfo pageinfo) {
		if (where == null || where.trim().length() == 0) {
			where = " where " + Orderinfo.COL_language + " = 0";
		} else if (where.indexOf(Orderinfo.COL_language) < 0) {
			where += " and " + Orderinfo.COL_language + " = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate()
				.queryForObject("countOrderinfoBySql", map).toString()));
		int offset = pageinfo.getOffset();
		int limit = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllOrderinfo",
				map, offset, limit);
		if (list != null) {
			list.add(0, pageinfo);
		}
		return list;
	}

	/**
	 * 根据Sql查找订单信息表
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinfo(String sql, int limit, int offset) {
		Map map = new HashMap();
		map.put("sql", sql);
		if (limit < 0) {
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllOrderinfoBySql",
				map, offset, limit);
	}

	/**
	 * 执行Sql 订单信息表
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteOrderinfoBySql(String sql) {
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteOrderinfoBySql", map);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countOrderinfoBySql(String sql) {
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject(
				"countOrderinfoBySql", map).toString()));
	}
}
