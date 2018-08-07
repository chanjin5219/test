package cn.my12306.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import cn.my12306.bean.Province;
import cn.my12306.bean.Province;
import cn.my12306.dao.BaseDao;

public class ProvinceDaoImpl {

	/**
	 * 获取所有省份信息
	 * @return
	 */
	public ArrayList<Province> getProvinces()
	{
		ArrayList<Province> provinces=new ArrayList<Province>();
		Province province=null;
		ResultSet rs=null;
		
		String sql="select id,provinceId,province from province ";
		try {
			rs=BaseDao.executeQuery(sql, null);
			
			while(rs.next())
			{
				province=new Province(rs.getInt("id"), rs.getString("provinceId"),rs.getString("province"));
				provinces.add(province);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			BaseDao.close(rs);
		}
		return provinces;
	}
}
