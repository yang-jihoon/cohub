package com.cooperationHub.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class StringUtil {
	public static String nvl(String str, String ifNull) {
		return (str == null) ? ifNull : str;
	}
	
	public static String nvlEncode(String str, String ifNull) throws UnsupportedEncodingException {
		return (str == null) ? ifNull : URLDecoder.decode(str,"UTF-8");
	}
}
