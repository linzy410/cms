<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="/page/admin/include/header.jsp" %>
		<script type="text/javascript">
			$(function() {
				$("#queryType").change(function(){
					$("#hTypeQuery").val(this.value);
					$("#f1").submit();
				});

				$("#chkall").click(function(){
					$("input[name='newschk']").attr("checked", this.checked);
				});
			});

			function remove(id){
				if(confirm("确定删除吗？")){
					goAction("/admin/news_remove.action?selectedId="+id);
				}
			}
			function removeMulti() {
				var newsIds = "";
				$("input[name='newschk']:checked").each(function(){
					newsIds+="," + this.value;
				});
				if (newsIds.length > 0) {
					if (confirm("确认要删除图片吗？")){
						goAction("/admin/news_removeMulti.action?selectedIds=" + newsIds.substring(1));
					}
				}
			}
		</script>
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
				    <li class="active"><a href="/admin/news_list.action">新闻管理</a></li>
					<li><input type="button" class="btn btn-primary" onclick="goAction('/admin/news_add.action')" value="新增"/></li>
					<li><input type="button" class="btn btn-primary" onclick="removeMulti();" value="批量删除"/></li>
					<li>
						<form id="f1" class="navbar-form" method="post" action="/admin/news_list.action">
							<input style="margin-top:0px;" type="hidden" name="typeQuery" id="hTypeQuery" value="${typeQuery}"/> 
							<input style="margin-top:0px;" type="text" name="titleQuery" placeholder="请输入标题" value="${titleQuery}" class="span3 searchIpt" />
							<input style="margin-top:0px;" type="submit" class="btn searchBtn" value="搜索"/>
						</form>
					</li>
				</ul>
		    	<div class="data-list">
		    	    <table class="table table-striped table-bordered table-condensed">
			    	    <tr>
			    	    	<th width="25" style="text-align:center;"><input type="checkbox" id="chkall"/></th>
			    	    	<th width="30">序号</th>
			    	    	<th>标题</th>
			    	    	<th>
			    	    		<select id="queryType" style="margin-bottom:0px;">
									<option value="0">类别</option>
									<s:iterator value="menus">
										<option value="${id}" <s:if test="id==typeQuery">selected="selected"</s:if>>${name} | ${nameEn}</option>
									</s:iterator>
								</select>
							</th>
			    	    	<th width="70">创建者</th>
			    	    	<th width="70">操作</th>
			    	    </tr>
		    	    	<s:iterator value="page.elements" status="st">
			    	    	<tr>
			    	    		<td style="text-align:center;"><input type="checkbox" value="${id}" name="newschk"/></td>
			    	    		<td>${st.index+1}</td>
			    	    		<td>${title}</td>
			    	    		<td>${menuName} | ${menuNameEn}</td>
			    	    		<td>${creator}</td>
			    	    		<td><a href="/admin/news_edit.action?selectedId=${id}">编辑</a> | <a href="javascript:void(0);" onclick="remove(${id});">删除</a></td>
			    	    	</tr>
		    	    	</s:iterator>
    				</table>
   				</div>
				<%@ include file="/page/admin/include/page.jsp" %>
		    </div>
	    </div>
    </div>
	</body>
</html>
