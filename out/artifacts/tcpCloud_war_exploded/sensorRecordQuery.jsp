<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>表格隔行换色</title>
		<style>
			#sum {
				border: 0px solid #f7f8f8;
				text-align: center;
				
			}
			#top1{
				border: 0px solid black;
				margin-bottom: 5px;
				margin-top: 15px;
			}
		</style>
	</head>

	<body>
		<div id="sum">
			<div>
				<div id="top1">
					<form action="${pageContext.request.contextPath}/querySensorInformationByLikeName.action" method="post">
						<b><font size="3">筛选设备编号：</font></b><input type="text" name="informationName" />&nbsp;&nbsp;<input
							type="submit"
							value="查询" style="size: 7;" />
					</form>
				</div>
				
				<table border="1" width="800px"  align="center" cellspacing="0px" bordercolor="gray" style="background-color: #f7f8f8;">
					<tr>
						<th>设备编号</th>
						<th>消息</th>
						<th>单位</th>
						<th>地址</th>
						<th>时间</th>
					</tr>
					<c:forEach items="${sensorInformationList}" var="information">
						<tr>
							<td>${information.sensor.sensor_name}</td>
							<td>${information.message}</td>
							<td>${information.sensor.sensor_unit}</td>
							<td>${information.sensor.sensor_ip}</td>
							<td>${information.time}</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<div>

			</div>
		</div>
	</body>

</html>