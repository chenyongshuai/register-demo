package com.chenys.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenys.entity.User;
import com.chenys.service.UserService;
import com.chenys.util.MailUtil;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/sendSms")
	public @ResponseBody Map sendSms(String userPhone,HttpSession session){
		//System.out.println(userPhone);
		Map map = service.sendSms(userPhone);
		Integer smsCode = (Integer) map.get("smsCode");
		session.setAttribute("smsCode", smsCode);
		map.remove("smsCode");
		return map;
	}
	
	//ע���˺�
	@RequestMapping("/register")
	public String register(int type,Integer code,User user,HttpSession session,Map map){
		System.out.println(user+"*****"+code+"*****"+type);
		//boolean isReg = service.register(user);
		//1.��֤���Ƿ���ȷ
		if(type==1){
			Integer smsCode = (Integer) session.getAttribute("smsCode");
			System.out.println(smsCode+"****"+code);
			if(smsCode.equals(code)){
				//2.��������
				user.setUserState(1);
				service.addUser(user);
				return "regBySms";
			}
		}else{
			int i = MailUtil.sendSimpleMail(user.getUserEmail());
			service.addUser(user);
			map.put("message", "ע��ɹ�����ǰ���������������֤����");
			return "regByEmail";
		}
		return null;
	}
	
	//���伤��
	@RequestMapping("/active")
	public String active(String userEmail,long time,HttpServletRequest request){
		System.out.println(userEmail+"****"+time);
		Map map = service.activeUser(userEmail,time);
		request.setAttribute("map", map);
		return "regByEmail";
	}
	
	//ע��ʱ��֤�˺��Ƿ��Ѿ�����
	@RequestMapping("/getUserByEmail")
	public @ResponseBody boolean getUserByEmail(String userEmail){
		//System.out.println(userEmail+"****");
		boolean isExist = service.getUserByEmail(userEmail);
		return isExist;
	}
}
