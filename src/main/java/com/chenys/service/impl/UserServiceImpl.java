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
	
	//ע��ʱ��֤�˺��Ƿ��Ѿ�����
	public boolean getUserByEmail(String userEmail) {
		User user = dao.getUserByEmail(userEmail);
		//System.out.println(user+"****");
		if(user==null){
			return true;
		}
		return false;
	}

	//���ݶ�����֤�������֤   
	public boolean addUser(User user) {
		int count = dao.addUser(user);
		if(count>0){
			return true;
		}
		return false;
	}
	
	//�����˺�
	public Map activeUser(String userEmail,long time) {
		Map map = new HashMap();
		if(new Date().getTime()-time>=600000){
			map.put("message", "�Բ������ļ����ѳ�ʱ��������Ϊ���� ���䷢�ͼ������ӣ���ǰ��������м���");
			MailUtil.sendSimpleMail(userEmail);
		}else{
			int count = dao.activeUser(userEmail);
			if(count>0){
				map.put("message", "��ϲ���Ѽ���ɹ����뷵����ҳ����е�½����");
			}else{
				map.put("message","�Բ��𣬼���ʧ�ܣ��뷵���������¼���");
			}
		}
		return map;
	}
	
	//���Ͷ���Ϣ
	public Map sendSms(String userPhone) {
		System.out.println(userPhone);
		Map map = new HashMap();
		
		//1.����һ��HttpClient����
		HttpClient client = HttpClients.createDefault();
		
		//2.����һ��6λ������֤��
		Random random = new Random();
		int smsCode = 0;
		while(smsCode<=99999){
			double d = random.nextDouble();
			smsCode = (int)(d*1000000);
		}
		System.out.println(smsCode+"****");
		map.put("smsCode", smsCode);
		//3.get����webService������ַ
		HttpGet get = new HttpGet("http://106.ihuyi.com/webservice/sms.php?method=Submit&account=C48574126&password=9ae1e83d66b7609efa8d7e0c612d4140&mobile="+userPhone+"&content=������֤���ǣ�"+smsCode+"���벻Ҫ����֤��й¶�������ˡ�");
		
		int resultCode = 0;
		//4.�������󣬻�ȡ��Ӧʵ��������
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
			
			//5.����DOM����xml
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
