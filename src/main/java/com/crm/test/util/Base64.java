package com.crm.test.util;

import java.io.IOException;

public class Base64 {
	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode(String str) {
		if(str == null){
			return "";
		}
		byte[] bytes = str.getBytes();
		return new sun.misc.BASE64Encoder().encode(bytes).replaceAll("\r|\n", "");
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static String decode(String str) {
		if(str == null){
			return "";
		}
		byte[] bytes = null;
		String result = "";
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bytes = decoder.decodeBuffer(str);
			result = new String(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
//	private static String str = "<p>&nbsp;&nbsp;底层为小贷资产，期限为301天，利率为8.00%。</p>";
//	public static void main(String[] args) {
//		String base64_encode = encode(str);
//		System.out.println(base64_encode);
//		
//		String base64_decode = decode("5YiG6KGM77ya6ZW/5rKZ5YiG6KGM77yb6LWE5Lqn5YiG57G777ya5Zyf5Zyw5L2/55So5p2D77yb5rOV6Zmi5ZCN56ew77ya77yb5ouN5Y2W5pe26Ze077yaMDAwMS0wMS0wMSAwMDowMDowMO+8m+adg+WxnuivgeaYju+8mu+8m+eFp+eci+S6uu+8mumYv+S4ie+8m+WcsOeQhuS9jee9ru+8mumYv+iLj+mBk+Wkq++8m+iBlOezu+S6uu+8muiigeWFiOeUn++8m+iBlOezu+aWueW8j++8muaJi+acujoxNTgxNDA5NTk1OSAg5Zu65a6a55S16K+dOjg2Njk1ODI3ICDpgq7nrrE6eXVhbnh5QGNtYmZhZS5jb20=");
//		System.out.println(base64_decode);
//	}
}
