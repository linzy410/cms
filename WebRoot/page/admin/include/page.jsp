<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<div class="pagination">
	<ul>
		<li class="disabled"><a href="#">共有<font color="red">${page.total}</font>条记录</a></li>
		<li><a href="${page.previousPage}">«</a></li>
		<s:iterator value="page.links">
		<li class="<s:if test='state==1'>active</s:if><s:elseif test='state==2'>disabled</s:elseif>"><a href="${href}">${name}</a></li>
		</s:iterator>
		<li><a href="${page.nextPage}">»</a></li>
	</ul>
</div>    		