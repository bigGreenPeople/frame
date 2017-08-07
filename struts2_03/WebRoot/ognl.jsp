<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 取得生成get方法放入值的数据 -->
    <s:property value="user.name"/>
    <s:property value="user.password"/>
    <!-- 取得set方法放入值的数据 -->
    <s:property value="name"/><br>
    <!-- 取得push方法放入值的数据 -->
    <s:property value="[0].top"/><br>
    
    <!-- 取得list里面的值 -->
    <!-- 第一种方式 -->
    	第一种方式:
    <s:property value="list[0].name"/>
    <s:property value="list[1].name"/><br>
    <!-- 第二种方式 -->
    	第二种方式:
    <s:iterator value="list">
    	<s:property value="name"/>
    </s:iterator><br>
    
     <!-- 第三种方式 struts2为了加快速度会将user临时放入到context中 -->
    	第三种方式:
     <s:iterator value="list" var="user">
    	<s:property value="#user.name"/><br>
    </s:iterator><br>
    
    <!-- 这里使用el表达式取值 -->
    el表达式取值:
    ${name }<br>
    ${user.name }<br>
     ${list[0].name } ${list[1].name }<br>
    
    <s:debug></s:debug>
  </body>
</html>
