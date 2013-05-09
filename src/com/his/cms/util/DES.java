package com.his.cms.util;

import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author <a href="mailto:linzheyan@viewlinecn.com">林哲炎</a> 
 * created in 2008-10-7
 * 
 * DES加解密算法
 */
public class DES {
	private static Log log = LogFactory.getLog(DES.class);
	String Algorithm = "DES";
	SecretKey deskey = null;
	private static DES handler = null;

	private DES() {
	}

	public static DES getInstance() throws Exception {
		if (handler == null) {
			handler = new DES();
			handler.init();
		}
		return handler;
	}


	/**
	 * 初始化
	 * @throws Exception
	 */
	private void init() throws Exception {
		DESKeySpec dks = new DESKeySpec("sA0j90sI(^s)sd&S".getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		deskey = keyFactory.generateSecret(dks);
	}

	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public String encryptStr(String str) {
		String _r = "fail";
		try {
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			byte[] cipherByte = c1.doFinal(str.getBytes());
			_r = byte2hex(cipherByte);
		} catch (java.security.NoSuchAlgorithmException e1) {
			log.error("[NoSuchAlgorithmException]" + e1.getMessage());
		} catch (javax.crypto.NoSuchPaddingException e2) {
			log.error("[NoSuchPaddingException]" + e2.getMessage());
		} catch (java.lang.Exception e3) {
			log.error("[NoSuchPaddingException]" + e3.getMessage());
		}
		return _r;
	}

	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public String decryptStr(String str) {
		String _r = "fail";
		try {
			//解密
			byte[] newBytes = String2Bytes(str);
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			byte[] clearByte = c1.doFinal(newBytes);
			_r = new String(clearByte);
		} catch (java.security.NoSuchAlgorithmException e1) {
			log.error("[NoSuchAlgorithmException]" + e1.getMessage());
		} catch (javax.crypto.NoSuchPaddingException e2) {
			log.error("[NoSuchPaddingException]" + e2.getMessage());
		} catch (java.lang.Exception e3) {
			log.error("[NoSuchPaddingException]" + e3.getMessage());
		}
		return _r;
	}

	/**
	 * 将字符串转化成字节
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private byte[] String2Bytes(String str) throws Exception {
		// 为满足token的要求，每两位密文之前加  :
		StringBuffer sb = new StringBuffer();
		sb.append(":");
		int length = str.length();
		while (length > 2) {
			sb.append(str.substring(0, 2));
			sb.append(":");
			str = str.substring(2);
			length = length - 2;
		}
		sb.append(str);
		StringTokenizer token = new StringTokenizer(sb.toString(), ":");
		String _r = "";
		while (token.hasMoreTokens()) {
			String a = token.nextToken();
			int tmp = Integer.parseInt(a, 16);
			_r += (char) tmp;
		}
		return _r.getBytes("iso-8859-1");
	}

	/**
	 * 将字节转化成字符串
	 * @param b
	 * @return
	 */
	private String byte2hex(byte[] b) {
		String _r = "";
		for (int n = 0; n < b.length; n++) {
			int c = b[n];
			if (b[n] < 0)
				c += 256;
			String tmp = Integer.toString(c, 16);
			if (tmp.length() == 1)
				tmp = "0" + tmp;
			//			_r += ":" + tmp;
			_r += tmp;
		}
		return _r;
	}

	public static void main(String[] args) throws Exception {
		DES handler = DES.getInstance();
		String str = handler.encryptStr("10000001");
		System.out.println(str);
		str = handler.decryptStr(str);
		System.out.println(str);
	}

}
