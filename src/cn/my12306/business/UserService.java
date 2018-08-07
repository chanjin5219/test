package cn.my12306.business;

import cn.my12306.bean.User;
import cn.my12306.dao.UserDao;
import cn.my12306.dao.impl.UserDaoImpl;

import java.security.*;

/**
 * 用户的业务逻辑类
 * @author lynn
 *
 */
public class UserService {
	
	private UserDao dao=new UserDaoImpl();

	/**
	 * 注册业务
	 * @param user 用户对象
	 * @return 1 注册成功  非1 注册失败
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
	 * 登录业务
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name,String pwd) throws Exception
	{
		pwd=this.getPwd(pwd);//加工数据
		User user=dao.getUser(name, pwd);//调用数据访问层
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
