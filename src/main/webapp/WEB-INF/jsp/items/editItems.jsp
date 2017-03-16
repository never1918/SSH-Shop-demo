<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>
	<form id="itemFrom"
		action="${pageContext.request.contextPath}/items/editItemsSubmit.action"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${itemsCustom.id}" /> 修改商品信息
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${itemsCustom.name}" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"
					value="${itemsCustom.price}" /></td>
			</tr>
			<tr>
				<td>生产日期</td>
				<td><input type="text" name="createtime"
					value="<fmt:formatDate value="${item.createtime}"
							pattern="yyyy-MM-dd HH:mm:ss" />" /></td>
			</tr>
			<%--<tr>
				<td>商品图片</td>
				<td><c:if test="${itme.pic!=null}">
						<img src="/pic/$item.pic" width=100 height=100 />
						<br />
					</c:if> <input type="file" name="pictureFile" /></td>
			</tr>--%>
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="detail"
					value="${itemsCustom.detail}" /></td>
			</tr>
			<tr>
				<td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>