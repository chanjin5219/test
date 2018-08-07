package cn.my12306.bean;

public class City {
	private int id ;
	private String	cityId;
	private String	city;
	private int pid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getProvince() {
		return this.pid;
	}
	public void setProvince(int province) {
		this.pid= province;
	}
	
	public City() {

	}
	public City(int id, String cityId, String city, int pid) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.city = city;
		this.pid = pid;
	}

}
