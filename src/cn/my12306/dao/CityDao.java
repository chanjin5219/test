package cn.my12306.dao;

import java.util.ArrayList;

import cn.my12306.bean.City;

/**
 * 城市数据访问接口
 * @author lynn
 *
 */
public interface CityDao {

	int add(City city);
	int update(City city);
	ArrayList<City> getCitys();
}
