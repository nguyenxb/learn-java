<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
       <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
       <script type="text/javascript">
    	   $("#regist").blur(function(){
    	     var value = $("#username1").val();
    	    
    	     alert(len);
    	     
    	   });
    	   
    	 //页面加载完成
   		$(function(){
   				$("#regist").attr('disabled',true);
   			  //验证用户名必须是由字母、数字下、划线组成，并且是5-12 位。
   			    //创建失去焦点事件
   			  $("#username1").blur(function(){
   			  	//获取用户输入的用户名信息
   			  	 var usernametext=$(this).val()
   			  	 //创建正则表达式对象
   			  	 var usernamepatt=/^\w{1,12}$/;  //^:开始   $：结束   \w:字母数组下划线  {5,12} 表示5到12位
   			  	 
   			  	 //使用text方法验证
   			  	 
   			  	 //提示用户结果
   			  	 
   			  	 if(!usernamepatt.test(usernametext)){
   			  	 	alert("你输入的用户名长度不足");
   			  	 	$("#regist").attr('disabled',true);
   			  	 }else{
   			  		$("#regist").attr('disabled',false);
   			  	 }
   			  });
   		});
       </script>
</head>
<body>
		<div align="center">
			<form action=showInfo.jsp>
			<table border="1"  rules="all">
				<caption>基本资料</caption>
				<tr>
					<th> <span style="color:red">*</span>姓名:</th>
					<td><input type="text" id= "username1" name="username"></td>
				</tr>
				<tr>
					<th> <span style="color:red">*</span>性别:</th>
					<td>
						<input type="radio" name="gender" value="男" checked="checked">男
						<input type="radio" name="gender" value="女">女
					</td>
				</tr>
				<tr>
					<th> <span style="color:red">*</span>民族:</th>
					<td>
						<input type="radio" name="nation" value="汉族" checked="checked">汉族
						<input type="radio" name="nation" value="回族">回族
						<input type="radio" name="nation" value="壮族">壮族
					</td>
				</tr>
				<tr>
					<th> <span style="color:red">*</span>专业:</th>
					<td>
						<select name="job">
						<option value="计算机科学与技术"  selected="selected">计算机科学与技术</option>
						<option value="计算机网络">计算机网络</option>
						<option value="计算机原理">计算机原理</option>
						</select>专业
					</td>
				</tr>
				<tr>
					<th> <span style="color:red">*</span>
					兴趣:</th>
					<td>
						<input type="checkbox" name="inters" value="电影" checked="checked">电影
						<input type="checkbox" name="inters" value="戏剧">戏剧
						<input type="checkbox" name="inters" value="音乐">音乐
						<input type="checkbox" name="inters" value="美术">美术
					</td>
				</tr>
			</table>
					<input type="submit" id="regist" value="注册">&nbsp;
					<input type="reset" value="重置">&nbsp;
			</form>
		</div>
</body>
</html>