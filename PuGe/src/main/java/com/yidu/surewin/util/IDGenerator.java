package com.yidu.surewin.util;

import java.util.UUID;

public class IDGenerator {

	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
	}
}
