package cn.my12306.dao;

import java.util.ArrayList;

import cn.my12306.bean.CertType;

/**
 * 证件类型的数据访问接口
 * @author lynn
 *	增删改查
 */
public interface CertTypeDao {
	
	int add(CertType certType);
	
	ArrayList<CertType> getCertTypes();

}
