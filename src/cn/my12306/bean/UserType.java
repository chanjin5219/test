package cn.my12306.bean;
/**
 * �û�����ʵ����
 * @author lynn
 *
 */
public class UserType {

	private int id;
	private String contentnot;
	
	/**
	 * ��ȡ�û����ͱ��
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * �����û����ͱ��
	 * @param id int �û����ͱ��
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��ȡ�û���������
	 * @return String
	 */
	public String getContentnot() {
		return contentnot;
	}
	/**
	 * �����û���������
	 * @param contentnot String �û���������
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
