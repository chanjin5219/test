package cn.my12306.bean;

/**
 * 省份实体类
 * @author lynn
 *
 */
public class Province {
	
	private int id ;
	private String	provinceId;
	private String	province;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Province() {
	}
	public Province(int id, String provinceId, String province) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.province = province;
	}
	
	
	
}
