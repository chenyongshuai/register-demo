package com.chenys.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class MD5EncryptionTechnique {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getMD5Digest("admin"));//d033e22ae348aeb5660fc2140aec35850c4da997���Ľ�����MD5�㷨
		
		System.out.println(ReversibleW("admin"));//�Զ�����ܼ���������
		System.out.println(ReversibleW(""));//admin�Զ�����ܣ�����      ��ͳһ�����㷨�õ�������

		System.out.println(encode("admin"));//YWRtaW4=  Base64��������
		System.out.println(decode("YWRtaW4="));//admin   Base64��������
	}

	/**
	 * MD5�㷨����SHA-1�㷨Ҫ�õ��ļ����㷨
	 * ���������ת����ʮ������ַ�
	 * @author Carry
	 * @param b byte[] �ֽ���
	 * @return String ʮ������ַ�
	 */
	public static String byteToHexString(byte[] b) {

		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
			if (n < b.length - 1)
				hs = hs + "";
		}
		return hs;
	}

	/**
	 * ��Դ�ַ����md5/SHA-1����
	 * @author Carry
	 * @param sourceData����
	 * @return ����
	 */
	public static String getMD5Digest(String sourceData) {
		try {
			//�˾仰�ǲ���MD5�㷨����
			//MessageDigest alga = MessageDigest.getInstance("MD5");
			
			//�˾仰�ǲ���SHA-1�㷨
			MessageDigest alga=MessageDigest.getInstance("SHA-1");
			alga.update(sourceData.getBytes());
			byte[] digesta = alga.digest();
			return byteToHexString(digesta);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	/**
	 * reversible encryption technique
	 * ��������ǿ���ļ��ܽ����㷨������ȥ���ģ��õ��������ģ�����ȥ���ģ��õ���������
	 * �Զ��巽����������΢�˽�һ��
	 * @author Carry
	 * @param inStr
	 * @return
	 */
	public static String ReversibleW(String inStr) {
		// String s = new String(inStr);
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 'w');//w���Ի�����һ��ĸ�����ܺ���ͬ*********����ʱҪ�ü��ܵ�ͬһ����ĸ
		}
		String s = new String(a);
		return s;
	}
	
	/**
	 * Base64�����㷨
	 * @param sourceData ����
	 * @return ����
	 */
	public static String encode(String sourceData) {
		String str = Base64.encode(sourceData.getBytes(), 0);
		return str;
	}
	
	/**
	 * Base64�����㷨
	 * @param str ����
	 * @return ����
	 */
	public static String decode(String str) {
		try {
			byte[] sourceData = Base64.decode(str);
			return new String(sourceData);
		} catch (Base64DecodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
