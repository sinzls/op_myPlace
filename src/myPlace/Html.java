package myPlace;

public class Html extends Place{
	String html;
	
	public Html() {
		
	}
	
	public Html(String name, String tel, String address, double latitude, double longitude) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public void setHtml() {
		this.html = "<html>\r\n";
		this.html +=  "<head>\r\n";
		this.html +=  "<style>\r\n";
		this.html +=  "#map {\r\n";
		this.html +=  "height: 400px;\r\n";
		this.html +=  "width: 100%;\r\n";
		this.html +=  "}\r\n";
		this.html +=  "</style>\r\n";
		this.html +=  "</head>\r\n";
		this.html +=  "<body>\r\n";
		this.html +=  "<p>";
		this.html +=  this.print();
		this.html +=  "</p>\r\n";
		this.html +=  "<h3>My Google Maps Demo</h3>\r\n";
		this.html +=  "<div id=\"map\"></div>\r\n";
		this.html +=  "<script>\r\n";
		this.html +=  "function initMap() {\r\n";
		this.html +=  "var uluru = {lat: "+ this.latitude  +", lng: "+ this.longitude +"};\r\n";
		this.html +=  "var map = new google.maps.Map(\r\n";
		this.html +=  "document.getElementById('map'), {zoom: 16, center: uluru});\r\n";
		this.html +=  "var marker = new google.maps.Marker({position: uluru, map: map});\r\n";
		this.html +=  "}\r\n";
		this.html +=  "</script>\r\n";
		this.html +=  "<script async defer\r\n";
		this.html +=  "src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyB_CQXqs5MVuSmlO2l7hfg5hXh7ZibC5jE&callback=initMap\">\r\n";
		this.html +=  "</script>\r\n";
		this.html +=  "</body>\r\n";
		this.html +=  "</html>\r\n";
	}
	public String getHtml() {
		return html;
	}
}
