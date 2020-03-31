package kdg;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.*;

public class FileUpload {
	String upload = "C:\\source\\web_semi\\WebContent\\upload";
	String tempDir = "C:/temp2/";
	
	int maxSize = 1024*1024*50;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	
	public FileUpload(HttpServletRequest req,HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	public boolean uploadFormCheck() {
		boolean flag = ServletFileUpload.isMultipartContent(req);
		return flag;
	}
	public InsertRoomsVo roomsUploading(){//건물정보 업로드
		InsertRoomsVo vo = new InsertRoomsVo();//건물정보
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(new File(tempDir));
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		sf.setHeaderEncoding("utf-8");
		sf.setFileSizeMax(maxSize);
		
		try {
			List<FileItem> list = sf.parseRequest(req);
			for(FileItem fi:list) {
				String v = fi.getString("utf-8");
				String k = fi.getFieldName();
				
				if(fi.isFormField()) {
					switch(k) {
					case "ceo":
						vo.setCeo(v);
						break;
					case "rName":
						vo.setrName(v);
						break;
					case "adress":
						vo.setAddress(v);
						break;
					case "rPlace":
						vo.setrPlace(v);
						break;
					case "stars":
						vo.setStars(Integer.parseInt(v));
						break;
					case "gInfo":
						vo.setgInfo(v);
						break;
					case "aType":
						vo.setaType(Integer.parseInt(v));
						break;
					case "kind":
						vo.setKind(Integer.parseInt(v));
						break;
					case "checkIn":
						vo.setCheckin(sdf.parse(v));
						break;
					case "checkOut":
						vo.setCheckout(sdf.parse(v));
						break;
					
					case "pet":
						if(v.equals("on")) {
							vo.setPet(1);
						}else {
							vo.setPet(0);
						}
						break;
					case "smoke":
						if(v.equals("on")) {
							vo.setSmoke(1);
						}else {
							vo.setSmoke(0);
						}
						break;
					case "noSmoke":
						if(v.equals("on")) {
							vo.setNoSmoke(1);
						}else {
							vo.setNoSmoke(0);
						}
						break;
					case "parking":
						if(v.equals("on")){
							vo.setParking(1);
						}else {
							vo.setParking(0);
						}
						break;
					case "breakfast":
						if(v.equals("on")) {
							vo.setBreakfast(1);
						}else {
							vo.setBreakfast(0);
						}
						break;
						
					case "pt":
						if(v.equals("on")) {
							vo.setPt(1);
						}else {
							vo.setPt(0);
						}
						break;
					case "swim":
						if(v.equals("on")) {
							vo.setSwim(1);
						}else {
							vo.setSwim(0);
						}
						break;
					case "rest":
						if(v.equals("on")) {
							vo.setRest(1);
						}else {
							vo.setRest(0);
						}
						break;
					case "cafe":
						if(v.equals("on")) {
							vo.setCafe(1);
						}else {
							vo.setCafe(0);
						}
						break;
					case "bar":
						if(v.equals("on")) {
							vo.setBar(1);
						}else {
							vo.setBar(2);
						}
						break;
						
					case "washer":
						if(v.equals("on")) {
							vo.setWasher(1);
						}else {
							vo.setWasher(0);
						}
						break;
					case "lounge":
						if(v.equals("on")) {
							vo.setLounge(1);
						}else {
							vo.setLounge(0);
						}
						break;
					case "kitchen":
						if(v.equals("on")) {
							vo.setKitchen(1);
						}else {
							vo.setKitchen(0);
						}
						break;
					case "dryer":
						if(v.equals("on")) {
							vo.setDryer(1);
						}else {
							vo.setDryer(0);
						}
						break;
					case "talsu":
						if(v.equals("on")) {
							vo.setTalsu(1);
						}else {
							vo.setTalsu(0);
						}
						break;
					}
				}else {
					if(fi.getSize()>0) {
						String f = fi.getName();
						String sysfile = new Date().getTime()+"-"+f;
						vo.setOriFile(f);
						vo.setSysFile(sysfile);
						
						File file = new File(upload + sysfile);
						fi.write(file);
						
						fi.delete();
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return vo;
			
		}
	}
	public InsertRoomVo roomUploading() {
		InsertRoomVo vo = new InsertRoomVo();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(new File(tempDir));
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		sf.setHeaderEncoding("utf-8");
		sf.setFileSizeMax(maxSize);
		
		try {
			List<FileItem> list = sf.parseRequest(req);
			for(FileItem fi:list) {
				String v = fi.getString("utf-8");
				String k = fi.getFieldName();
				
				if(fi.isFormField()) {
					switch(k) {
					case "rCode":
						vo.setrCode(Integer.parseInt(v));
						break;
					case "roomName":
						vo.setRoomName(v);
						break;
					case "rMaxPeople":
						vo.setrMaxPeople(Integer.parseInt(v));
						break;
					case "price":
						vo.setPrice(Integer.parseInt(v));
						break;
						
					case "tv":
						if(v.equals("on")) {
							vo.setTv(1);
						}else {
							vo.setTv(0);
						}
						break;
					case "wifi":
						if(v.equals("on")) {
							vo.setWifi(1);
						}else {
							vo.setWifi(0);
						}
						break;
					case "shower":
						if(v.equals("on")) {
							vo.setShower(1);
						}else {
							vo.setShower(0);
						}
						break;
					case "aircon":
						if(v.equals("on")) {
							vo.setAircon(1);
						}else {
							vo.setAircon(0);
						}
						break;
					case "spa":
						if(v.equals("on")) {
							vo.setSpa(1);
						}else {
							vo.setSpa(0);
						}
						break;
					case "tub":
						if(v.equals("on")) {
							vo.setTub(1);
						}else {
							vo.setTub(0);
						}
						break;
					case "computer":
						if(v.equals("on")) {
							vo.setComputer(1);
						}else {
							vo.setComputer(0);
						}
						break;
					case "iron":
						if(v.equals("on")) {
							vo.setIron(1);
						}else {
							vo.setIron(0);
						}
						break;
					case "refr":
						if(v.equals("on")) {
							vo.setRefr(1);
						}else {
							vo.setRefr(0);
						}
						break;
					case "socket":
						if(v.equals("on")) {
							vo.setSocket(1);
						}else {
							vo.setSocket(0);
						}
						break;
					case "bed":
						vo.setBed(Integer.parseInt(v));
						break;
					
					}
				}else {
					if(fi.getSize()>0) {
						String f = fi.getName();
						String sysfile = new Date().getTime()+"-"+f;
						vo.setOriFile(f);
						vo.setSysFile(sysfile);
						
						File file = new File(upload + sysfile);
						fi.write(file);
						
						fi.delete();
					}
				}
			}
		}catch(Exception e) {
			
		}finally {
			return vo;
			
		}
	}
	
	
}





































