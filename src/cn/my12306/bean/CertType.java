package cn.my12306.bean;
/**
 * ֤������ʵ����
 * @author lynn
 * ���ã���װ���ݣ��ڸ���֮����д���
 * ���裺1��д��
 * 2��˽�еĳ�Ա����
 * 3��������get��set����
 * 4�����캯��(������)
 * 
 *
 */
public class CertType {

	private int id;
	private String contentnot;
	
	/**
	 * ��ȡ֤�����ͱ��
	 * @return int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * ����֤�����ͱ��
	 * @param id int ֤�����ͱ��
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��ȡ֤����������
	 * @return String
	 */
	public String getContentnot() {
		return contentnot;
	}
	/**
	 * ����֤����������
	 * @param contentnot String ֤����������
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
