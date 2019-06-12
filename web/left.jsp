<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style>
		.le {
			border: 1px solid #bbb;
			line-height: 56px;
			font-size: 19px;
			width: 203px;
			margin-left: -9px;
			margin-top: -9px;
			margin-bottom: 1px;
			padding-left: 0px;
			padding-bottom: 7px;
			background: white;
		}
		
		a {
			text-decoration: none;
		}
	</style>

	<body>
		<div class="le" style="font-size: 5">
			<a href="lunbo.html" target="right1">
				<img src="img/11.png" style="padding-left: 1px;" /> &nbsp;首页
			</a>
		</div>
		<div class="le" style="font-size: 5">
			<a href="${pageContext.request.contextPath}/queryAllSensorInformation.action" target="right1">
				<img src="img/44.png" /> 传感器记录查询
			</a>
		</div>
		<div class="le" style="font-size: 5">
			<a href="${pageContext.request.contextPath}/sensorInformation.jsp" target="right1">
				<img src="img/555.png" />&nbsp;传感器信息</a>
		</div>
		<div class="le" style="font-size: 5">
			<a href="${pageContext.request.contextPath}/queryAllSensor.action" target="right1">
				<img src="img/22.png" />&nbsp;传感器管理</a>
		</div>
		</div>
		<%--<div class="le" style="font-size: 5">
			<a href="right1.html" target="right1">
				<img src="img/66.png" />&nbsp;摄像头管理</a>
		</div>--%>
		<div class="le" style="font-size: 5">
			<a href="${pageContext.request.contextPath}/index.jsp" target="right1">
				<img src="img/66.png" />&nbsp;后台连接管理</a>
		</div>
		</div>

		</div>

	</body>

</html>