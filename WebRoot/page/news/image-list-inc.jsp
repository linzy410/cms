<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("td").toggle(
					function(){$(this).find("img").addClass("imgSelected")},
					function(){$(this).find("img").removeClass("imgSelected")}
				);
				
				$("input").click(function(){
					var images = $(".imgSelected");
					if (images.size()==0){
						alert("请选择一张图片");
					} else {
						parent.selectImg(images);
					}
				});
			});
		</script>
		<style type="text/css">
			.table td {text-align:center;}
			.table td img {border: 2px solid transparent;}
			.table td img.imgSelected {border-color: #B6000C;}
		</style>
	</head>
	<body>
		<div class="thumbnail">
			<legend>图片列表</legend>
			<div style="padding-bottom:3px;"><input type="button" class="btn btn-primary" value="插入所选图片"/></div>
			<table class="table table-bordered">
				<s:iterator value="result.images" status="st">
					<s:if test="#st.index%4==0"><tr class=""></s:if>
						<td width="25%"><img src="/upload/${filePath}/${fileName}" width="160"/></td>
						<s:if test="#st.last">
							<s:set name="r" value="3-(#st.index%4)"/>
							<s:if test="#r==1"><td>&nbsp;</td></s:if>
							<s:if test="#r==2"><td>&nbsp;</td><td>&nbsp;</td></s:if>
							<s:if test="#r==3"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></s:if>
						</s:if>
					<s:if test="#st.index%4==3"></tr></s:if>
				</s:iterator>
			</table>
			<div><input type="button" class="btn btn-primary" value="插入所选图片"/></div>
		</div>
	</body>
</html>