$(function(){
			$("tr td:first").addClass("tdFirst");
			function sendMsg(){
				var userPhone = $("[name='userPhone']").val();
				$.ajax({
					url:"user/sendSms.do",
					data:"userPhone="+userPhone,
					success:function(data){
						//console.log(data);
						if(data.code==2){
							$("#sendMsg").val("获取成功，60秒内输入。").prop("disabled",true);
							window.setTimeout(function(){
								$("#sendMsg").val("获取短信验证码").prop("disabled",false);							
							}, 60000);
						}else{
							$("#sendMsg").val("获取失败，请稍后重试").prop("disabled",true);
							window.setTimeout(function(){
								$("#sendMsg").val("获取短信验证码").prop("disabled",false);							
							}, 6000);
						}
					}
				});
			}
			$("#sendMsg").click(sendMsg);
			//邮箱验证
			function verifyEmail(){
				var userEmail = $("#verifyEmail").val();
				if(userEmail==""){
					$("#emailSpan").html("<img src='img/2017-10-11_133512.png'/>邮箱不能为空").css("color","red");
					return false;
				}else if(/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/.test(userEmail)){
					var flag = false;
					$.ajax({
						url:"user/getUserByEmail.do",
						data:"userEmail="+userEmail,
						async:false,
						success:function(data){
							//console.log(data);
							if(data){
								$("#emailSpan").html("恭喜您，该用户可以正常使用").addClass("rightEmailSpan").css("color","black");
								flag=true;
							}else{
								$("#emailSpan").html("对不起，该用户已经被占用").addClass("errorEmailSpan2").css("color","red");
							}
						}
					});
					return flag;
				}else{
					$("#emailSpan").html("<img src='img/2017-10-11_133512.png'/>对不起，邮箱格式不正确").css("color","red");
					return false;
				}
			}
			$("#verifyEmail").blur(verifyEmail);
			//密码验证
			function verifyPwd(){
				var userPwd = $("#verifyPwd").val();
				//console.log(  $.trim(userPwd)  );
				//console.log(  $.trim(userPwd).length  );
				if(userPwd==""){
					$("#pwdSpan").html("<img src='img/2017-10-11_133512.png'/>对不起，密码不能为空").css("color","red");
					return false;
				}else if($.trim(userPwd).length<6||$.trim(userPwd).length>16){
					$("#pwdSpan").html("<img src='img/2017-10-11_133512.png'/>对不起，密码为6-16位").css("color","red");
					return false;
				}else{
					$("#pwdSpan").html("");
					return true;
				}
			}
			$("#verifyPwd").blur(verifyPwd);
			//确认密码
			function verifyRePwd(){
				var userPwd = $.trim($("#verifyPwd").val()) ;
				var userRePwd = $("#verifyRePwd").val();
				if(userRePwd==""){
					$("#pwdReSpan").html("<img src='img/2017-10-11_133512.png'/>请确认您的密码").css("color","red");
					return false;
				}else if(userPwd!=userRePwd){
					$("#pwdReSpan").html("<img src='img/2017-10-11_133512.png'/>对不起，两次输入的密码不一致").css("color","red");
					return false;
				}else{
					$("#pwdReSpan").html("");
					return true;
				}
			}
			$("#verifyRePwd").blur(verifyRePwd);
			//手机验证
			function verifyPhone(){
				var userPhone =  $.trim( $("#verifyPhone").val() );
				if(userPhone==""){
					$("#phoneSpan").html("<img src='img/2017-10-11_133512.png'/>手机号码不能为空").css("color","red");
					return false;
				}else if(/^1[3|5|7|8|][0-9]{9}$/.test(userPhone)){
					$("#phoneSpan").html("");
					return true;
				}else if(userPhone.length!=11){
					$("#phoneSpan").html("<img src='img/2017-10-11_133512.png'/>请输入11位手机号码").css("color","red");
					return false;
				}else{
					$("#phoneSpan").html("<img src='img/2017-10-11_133512.png'/>手机号码无效").css("color","red");
					return false;
				}
			}
			$("#verifyPhone").blur(verifyPhone);
			//验证码验证
			function verifyMsg(){
				var msgCode = $.trim(  $("#msgInput").val()  );
				if(msgCode==""){
					$("#msgSpan").html("<img src='img/2017-10-11_133512.png'/>短信验证码不能为空").css("color","red");
					return false;
				}else if(/^[0-9]{6}$/.test(msgCode)){
					$("#msgSpan").html("");
					return true;
				}else{
					$("#msgSpan").html("<img src='img/2017-10-11_133512.png'/>短信验证码为6位有效数字").css("color","red");
					return false;
				}
			}
			$("#msgInput").blur(verifyMsg);
			//提交表单      
			$("#regForm").submit(function(){
				//console.log(  $("#agree").prop("checked")  );
				var message = $("#sendMsg").val();
				if(  $("#regBySms").prop("checked")  ){
					if( message=="获取成功，60秒内输入。"&$("#agree").prop("checked")&verifyEmail()&verifyPwd()&verifyRePwd()&verifyPhone()&verifyMsg()){
						return true;
					}else{
						return false;
					}
				}else{
					if($("#agree").prop("checked")&verifyEmail()&verifyPwd()&verifyRePwd()&verifyPhone()){
						return true;
					}else{
						return false;
					}
				}
			});
			
			//角色按钮
			$("#role input").click(function(){
				$("#role input").removeClass("selected");
				$(this).addClass("selected");
				//console.log(  $(this).prop("title") );
				$("#roleInput").val(  $(this).prop("title")  );
			});
			
			//点击邮箱验证
			$("#regByEmail").click(function(){
				$("#smsTr").hide().next().hide();
			});
			//点击短信验证
			$("#regBySms").click(function(){
				$("#smsTr").show().next().show();
			});
		});