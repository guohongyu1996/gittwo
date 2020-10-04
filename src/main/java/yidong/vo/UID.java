package yidong.vo;

import java.util.UUID;

public class UID {

	public static String getUUID(){
		return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
	}

}
