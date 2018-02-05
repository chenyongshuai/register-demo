package com.chenys.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	// 1.设置发�?邮件的一些参�?
	private static Properties pro = new Properties();

	static {
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.host", "smtp.qq.com");
		pro.setProperty("mail.smtp.auth", "true");
		pro.setProperty("mail.smtp.port", "587");
	}

	public static int sendSimpleMail(String recipients) {
		int res = 0;
		try {
			// 2.创建�?��会话对象和邮件服务器交互
			Session session = Session.getDefaultInstance(pro);
			// 3.创建�?��邮件对象
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("1291758809@qq.com")); // 发�?�?

			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(recipients)); // 收件�?

			message.setSubject("欢迎您注册为SkyPlatForm用户！");// 设置邮件的标�?

			message.setContent("点击'我要激活'字样连接，即可激活为SkyPlatForm正式用户?<a href='http://192.168.0.148:8989/SkyPlatForm/user/active.do?userEmail="+recipients+"&time="+new Date().getTime()+"'><font color='red'>我要激活</font></a>", "text/html;charset=UTF-8");// 设置邮件的正�?

			message.setSentDate(new Date());// 发�?时间

			message.saveChanges(); // 保存设置

			Transport transport = session.getTransport();// 获取�?��传输对象

			transport.connect("1291758809@qq.com", "yzimgprrregijibg");// 设置发�?邮件用户名和密码

			transport.sendMessage(message, message.getAllRecipients());// 发�?邮件

			transport.close();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
