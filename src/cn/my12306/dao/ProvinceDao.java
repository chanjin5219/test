package cn.my12306.dao;

import java.util.ArrayList;
import cn.my12306.bean.Province;

public interface ProvinceDao {

	int add(Province province);
	int update(Province province);
	ArrayList<Province> getProvinces();
}
