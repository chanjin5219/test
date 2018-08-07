package cn.my12306.bean;
/**
 * 用户类型实体类
 * @author lynn
 *
 */
public class UserType {

	private int id;
	private String contentnot;
	
	/**
	 * 获取用户类型编号
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置用户类型编号
	 * @param id int 用户类型编号
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取用户类型名称
	 * @return String
	 */
	public String getContentnot() {
		return contentnot;
	}
	/**
	 * 设置用户类型名称
	 * @param contentnot String 用户类型名称
	 */
	public void setContentnot(String contentnot) {
		this.contentnot = contentnot;
	}
	
	public UserType() {
	}
	
	public UserType(int id, String contentnot) {
		super();
		this.id = id;
		this.contentnot = contentnot;
	}
	
	
}
