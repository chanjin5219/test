package cn.my12306.dao;

import java.util.ArrayList;

import cn.my12306.bean.CertType;

/**
 * ֤�����͵����ݷ��ʽӿ�
 * @author lynn
 *	��ɾ�Ĳ�
 */
public interface CertTypeDao {
	
	int add(CertType certType);
	
	ArrayList<CertType> getCertTypes();

}
