<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:if test="#request.clist.size() !=0">
		<table>
			<tr>
				<tb>
					<div align="center">
						<span class="STYLE1">类别名称</span>>
					</div>
				</tb>
				<tb>
					<div align="center">
						<span class="STYLE1">基本操作</span>>
					</div>
				</tb>
			</tr>
			<s:iterator value="#request.clist" var="category">
				<tr>
					<td height="20" bgcolor="#ffffff">
						<s:property value="#category.name" />
					</td>
					<td>
						编辑删除
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

</body>
</html>