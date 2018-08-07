package cn.my12306.bean;
/**
 * 证件类型实体类
 * @author lynn
 * 作用：封装数据，在各层之间进行传递
 * 步骤：1、写类
 * 2、私有的成员变量
 * 3、公共的get、set方法
 * 4、构造函数(可重载)
 * 
 *
 */
public class CertType {

	private int id;
	private String contentnot;
	
	/**
	 * 获取证件类型编号
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置证件类型编号
	 * @param id int 证件类型编号
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取证件类型名称
	 * @return String
	 */
	public String getContentnot() {
		return contentnot;
	}
	/**
	 * 设置证件类型名称
	 * @param contentnot String 证件类型名称
	 */
	public void setContentnot(String contentnot) {
		this.contentnot = contentnot;
	}
	
	public CertType() {
	}
	
	public CertType(int id, String contentnot) {
		super();
		this.id = id;
		this.contentnot = contentnot;
	}
	
	
}
