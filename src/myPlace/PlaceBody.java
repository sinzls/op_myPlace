package myPlace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PlaceBody{
	String bol = "true";
	int num;
	
	public void end(Scanner scan) { //반복 선택
		System.out.println("계속 하시려면 1를 입력해주세요.");
		System.out.println("종료 하시려면 0를 입력해주세요.");
		if(Integer.parseInt(scan.nextLine())==0) bol = "fales";
	}
	
	public void num1(HashMap mapStr, HashMap mapDou, Scanner scan) {  //1번 자료값을 입력받는다. mapStr에 각각 키에 값입력
		System.out.println("지명을 입력하세요 : ");
		mapStr.put("Name",scan.nextLine());
		System.out.println("연락처를 입력하세요 : ");
		mapStr.put("Tel",scan.nextLine());
		System.out.println("주소를 입력하세요 : ");
		mapStr.put("Address",scan.nextLine());
		System.out.println("위도를 입력하세요 : ");
		mapDou.put("Latitude",Double.parseDouble(scan.nextLine()));
		System.out.println("경도를 입력하세요 : ");
		mapDou.put("Longitude",Double.parseDouble(scan.nextLine()));
	}
	
	public void num2(ArrayList<Html> plList, Scanner scan) {
		System.out.println("삭제 할 정보를 선택하세요.");
		for(int i=0; i<plList.size();i++) {
			System.out.println(i+"번"+plList.get(i).print());
		}
		plList.remove(Integer.parseInt(scan.nextLine()));
	}
	
	public void num3(ArrayList<Html> plList,Scanner scan) {
		int num3;
		System.out.println("수정 할 정보를 선택하세요.");
		for(int i=0; i<plList.size();i++) {
			System.out.println(i+"번"+plList.get(i).print());
		}
		num3 =Integer.parseInt(scan.nextLine());
		System.out.println("수정 할 정보를 선택하세요.");
		System.out.println("1번 "+ plList.get(num3).getName());
		System.out.println("2번 "+ plList.get(num3).getTel());
		System.out.println("3번 "+ plList.get(num3).getAddress());
		System.out.println("4번 "+ plList.get(num3).getLatitude());
		System.out.println("5번 "+ plList.get(num3).getLongitude());
		num =Integer.parseInt(scan.nextLine());
		if(num == 1) plList.get(num3).setName(scan.nextLine());
		else if(num ==2) plList.get(num3).setTel(scan.nextLine());
		else if(num ==3) plList.get(num3).setAddress(scan.nextLine());
		else if(num ==4) plList.get(num3).setLatitude(Double.parseDouble(scan.nextLine()));
		else if(num ==5) plList.get(num3).setLongitude(Double.parseDouble(scan.nextLine()));
	}
	
	public void num4(ArrayList<Html> plList,Scanner scan) {
		
		System.out.println("출력 할 정보를 선택하세요.");
		for(int i=0; i<plList.size();i++) {
			System.out.println(i+"번"+plList.get(i).print());
		}
		num =Integer.parseInt(scan.nextLine());
		plList.get(num).setHtml();
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("d:/jun/javaprj/myPlace/placelist.txt"));
		Scanner scan = new Scanner(System.in);   //입력값 출력
		ArrayList<Html> plList = new ArrayList<Html>();  //  html를 출력하기 위한 인스턴스
		HashMap<String, String> mapStr = new HashMap<String, String>();  // 지명, 연락처, 주소
		HashMap<String, Double> mapDou = new HashMap<String, Double>();  // 위도, 경도
		PlaceBody placeBody = new PlaceBody();
		String line;
		String str;
		String[] arr;
		
		while(true) {  // 입력 받았던 정보를 불러옴
        	line = br.readLine();
        	if(line==null) break;
        	str = line;
        	arr = str.split(",");
        	plList.add(new Html(arr[0],arr[1],arr[2],Double.parseDouble(arr[3]),Double.parseDouble(arr[4])));
		}
        br.close();
		
        
		while(placeBody.bol == "true") {
			
			System.out.println("장소정보에 관리에 사용 할 기능을 선택하세요.");
			System.out.println("1번 장소 추가\r\n2번 장소 삭제\r\n3번 장소 수정\r\n4번 장소 출력");
			System.out.println("현재 입력된 정보");
			for(int i=0; i<plList.size();i++) {
				System.out.println(i+"번"+plList.get(i).print());
			}
			
			placeBody.num = Integer.parseInt(scan.nextLine());  // 최초 입력된 값을 num이 받고 그 값을 if문에 대입
			
			if(placeBody.num==1) {  //정보 추가
				placeBody.num1(mapStr, mapDou, scan);
				plList.add(new Html(mapStr.get("Name"),mapStr.get("Tel"),mapStr.get("Address"),mapDou.get("Latitude"),mapDou.get("Longitude")));
				placeBody.end(scan);
				
			} else if(placeBody.num==2) {  //정보 삭제
				placeBody.num2(plList, scan);
				placeBody.end(scan);
				
			} else if(placeBody.num==3) {  //정보 수정
				placeBody.num3(plList, scan);
				placeBody.end(scan);
				
			} else if(placeBody.num==4) {  // 값의 리스트를 출력하고 그 값을 지도로 표시
				placeBody.num4(plList, scan);
				FileWriter fwnew = new FileWriter("d:/jun/javaprj/myPlace/myPlace.html");
				fwnew.write(plList.get(placeBody.num).getHtml());
				fwnew.close();
				placeBody.end(scan);
			}
		}
		
		FileWriter fw = new FileWriter("d:/jun/javaprj/myPlace/placelist.txt");
		for(int i=0; i<plList.size();i++) {
			fw.write(plList.get(i).print() + "\r\n");
		}
		fw.write("");
		fw.close();
	}
}
