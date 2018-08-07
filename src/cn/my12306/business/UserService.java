package cn.my12306.business;

import cn.my12306.bean.User;
import cn.my12306.dao.UserDao;
import cn.my12306.dao.impl.UserDaoImpl;

import java.security.*;

/**
 * �û���ҵ���߼���
 * @author lynn
 *
 */
public class UserService {
	
	private UserDao dao=new UserDaoImpl();

	/**
	 * ע��ҵ��
	 * @param user �û�����
	 * @return 1 ע��ɹ�  ��1 ע��ʧ��
	 */
	public int register(User user)throws Exception
	{
		int rs=-1;
		String pwd=user.getPassword();
		user.setPassword(this.getPwd(pwd));
		rs=dao.add(user);
        return rs;
	}
	
	/**
	 * ��¼ҵ��
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name,String pwd) throws Exception
	{
		pwd=this.getPwd(pwd);//�ӹ�����
		User user=dao.getUser(name, pwd);//�������ݷ��ʲ�
		return user;
	}
	
	
	public String getPwd(String pwd) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(pwd.getBytes());
		String newPwd=new String(digest);
		return newPwd;
	}
}
