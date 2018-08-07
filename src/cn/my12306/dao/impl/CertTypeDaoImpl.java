package cn.my12306.dao.impl;



import java.sql.ResultSet;
import java.util.ArrayList;

import cn.my12306.bean.CertType;
import cn.my12306.dao.BaseDao;
import cn.my12306.dao.CertTypeDao;

/**
 * 证件类型访问数据库的操作类
 * 
 * @author lynn
 *
 */
public class CertTypeDaoImpl implements CertTypeDao {
	
	public int add(CertType certType) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 获取所有的证件类型信息
	 * @return ArrayList<CertType>
	 */
	public ArrayList<CertType> getCertTypes()
	{
		ArrayList<CertType> certTypes=new ArrayList<CertType>();
		CertType certType=null;
		ResultSet rs=null;
		
		String sql="select id,content from CertType ";
		try {
			rs=BaseDao.executeQuery(sql, null);
			
			while(rs.next())
			{
				certType=new CertType(rs.getInt("id"), rs.getString("content"));
				certTypes.add(certType);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			BaseDao.close(rs);
		}
		return certTypes;
	}

	
	

}
