package myPlace;

//이름,연락처,주소,위도,경도
//정보수집
//텍스트 저장
//
public class Place{
	String name;
	String tel;
	String address;
	double latitude;
	double longitude;
	public Place() {
		// TODO Auto-generated constructor stub
	}
	public Place(String name, String tel, String address, double latitude, double longitude) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String print() {
		return this.name + "," + this.tel+ "," + this.address+ "," + this.latitude+ "," + this.longitude;
	}
	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	public void setTel(String tel) {this.tel = tel;}
	public String getTel() {return tel;}
	public void setAddress(String address) {this.address = address;}
	public String getAddress() {return address;}
	public void setLatitude(double latitude) {this.latitude = latitude;}
	public double getLatitude() {return latitude;}
	public void setLongitude(double longitude) {this.longitude = longitude;}
	public double getLongitude() {return longitude;}
	
	
}
