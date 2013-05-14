<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
	</head>
	<body>
    <%@ include file="/page/admin/include/top.jsp" %>
    <div class="container">
	    <div class="row">
		    <div class="span3">
		    	 <%@ include file="/page/admin/include/menu.jsp" %>
		    </div>
		    <div class="span12">
				<ul class="breadcrumb">
				    <li><a href="/admin/user_list.action">用户管理</a><span class="divider"> /</span></li>
				    <li class="active"><s:if test="user==null || user.id==0">新增</s:if><s:else>编辑</s:else></li>
				</ul>
		    	<div>
    				<div class="alert alert-error" style="width:98%;"><a data-dismiss="alert" class="close">×</a><s:actionerror/></div>
				    <form class="form-horizontal" method="post" action="/admin/<s:if test="user==null || user.id==0">user_save.action</s:if><s:else>user_update.action</s:else>">
				    	<input type="hidden" name="id" value="${user.id}"/>
					    <fieldset>
							<div class="control-group">
						   		<label class="control-label">用户名</label>
							    	<div class="controls">
							    	<s:if test="user==null || user.id==0">
									    <input type="text" class="input-xlarge" placeholder="请输入用户名，4-20位长度" name="username" value="${user.username}"/>
							   		</s:if><s:else>
									    <input type="text" name="username" readonly="readonly" value="${user.username}" id="disabledInput" class="input-xlarge disabled"/>
								   </s:else>
							    </div>
						    </div>
							<div class="control-group">
						   		<label class="control-label">姓名</label>
							    <div class="controls">
								    <input type="text" class="input-xlarge" placeholder="请输入姓名" name="name" value="${user.name}"/>
							    </div>
						    </div>
							<div class="control-group">
						   		<label class="control-label">密码</label>
							    <div class="controls">
								    <input type="password" class="input-xlarge" placeholder="请输入密码，6位以上长度" name="password"/>
								    <s:if test="user!=null && user.id>0"><p class="help-block">如需修改密码请输入密码</p></s:if>
							    </div>
						    </div>
							<div class="control-group">
						   		<label class="control-label">密码确认</label>
							    <div class="controls">
								    <input type="password" class="input-xlarge" placeholder="请再次输入密码" name="checkPassword"/>
							    </div>
						    </div>
						    <div class="controls" style="padding-top:10px;">
						    	<button class="btn btn-primary" type="submit">确定</button>
						    	<a href="/admin/user_list.action" class="btn">返回</a>
						    </div>
					    </fieldset>
				    </form>
		    	</div>
		    </div>
	    </div>
    </div>
	</body>
</html>
