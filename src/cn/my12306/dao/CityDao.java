package cn.my12306.dao;

import java.util.ArrayList;

import cn.my12306.bean.City;

/**
 * �������ݷ��ʽӿ�
 * @author lynn
 *
 */
public interface CityDao {

	int add(City city);
	int update(City city);
	ArrayList<City> getCitys();
}
