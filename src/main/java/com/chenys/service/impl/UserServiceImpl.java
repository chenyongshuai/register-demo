package com.chenys.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenys.dao.UserDao;
import com.chenys.entity.User;
import com.chenys.service.UserService;
import com.chenys.util.MailUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	//注册时验证账号是否已经存在
	public boolean getUserByEmail(String userEmail) {
		User user = dao.getUserByEmail(userEmail);
		//System.out.println(user+"****");
		if(user==null){
			return true;
		}
		return false;
	}

	//根据短信验证码进行验证   
	public boolean addUser(User user) {
		int count = dao.addUser(user);
		if(count>0){
			return true;
		}
		return false;
	}
	
	//激活账号
	public Map activeUser(String userEmail,long time) {
		Map map = new HashMap();
		if(new Date().getTime()-time>=600000){
			map.put("message", "对不起，您的激活已超时，已重新为您的 邮箱发送激活链接，请前往邮箱进行激活");
			MailUtil.sendSimpleMail(userEmail);
		}else{
			int count = dao.activeUser(userEmail);
			if(count>0){
				map.put("message", "恭喜您已激活成功，请返回主页面进行登陆操作");
			}else{
				map.put("message","对不起，激活失败，请返回邮箱重新激活");
			}
		}
		return map;
	}
	
	//发送短消息
	public Map sendSms(String userPhone) {
		System.out.println(userPhone);
		Map map = new HashMap();
		
		//1.创建一个HttpClient对象
		HttpClient client = HttpClients.createDefault();
		
		//2.生成一个6位数的验证码
		Random random = new Random();
		int smsCode = 0;
		while(smsCode<=99999){
			double d = random.nextDouble();
			smsCode = (int)(d*1000000);
		}
		System.out.println(smsCode+"****");
		map.put("smsCode", smsCode);
		//3.get请求webService发布地址
		HttpGet get = new HttpGet("http://106.ihuyi.com/webservice/sms.php?method=Submit&account=C48574126&password=9ae1e83d66b7609efa8d7e0c612d4140&mobile="+userPhone+"&content=您的验证码是："+smsCode+"。请不要把验证码泄露给其他人。");
		
		int resultCode = 0;
		//4.发送请求，获取响应实体类数据
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			InputStream inputStream = entity.getContent();
			InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String result = "";
			String str = null;
			while((str=br.readLine())!=null){
				result = result+str;
			}
			System.out.println(result);
			
			//5.利用DOM解析xml
			org.dom4j.Document doc = DocumentHelper.parseText(result);
			org.dom4j.Element element = doc.getRootElement();
			String code = element.elementText("code");
			map.put("code", code);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}


}
