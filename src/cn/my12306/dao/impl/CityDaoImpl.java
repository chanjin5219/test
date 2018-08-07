package cn.my12306.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import cn.my12306.bean.City;
import cn.my12306.dao.BaseDao;
import cn.my12306.dao.CityDao;

public class CityDaoImpl implements CityDao {
	
	public int add(City city) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(City city) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/**
	 * 获取所有城市信息
	 * @return
	 */
	public ArrayList<City> getCitys()
	{
		ArrayList<City> citys=new ArrayList<City>();
		City city=null;
		ResultSet rs=null;
		
		String sql="select id,cityId,city,pid from city ";
		try {
			rs=BaseDao.executeQuery(sql, null);
			
			while(rs.next())
			{
				city=new City(rs.getInt("id"), rs.getString("cityId"),rs.getString("city"),rs.getInt("pid"));
				citys.add(city);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			BaseDao.close(rs);
		}
		return citys;
	}

	
}
