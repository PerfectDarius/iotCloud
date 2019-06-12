<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>表格隔行换色</title>

	</head>
	<body>
		<form action="${pageContext.request.contextPath}/updateSensor.action">
			<input type="hidden" name="sensor_id" value="${sensor.sensor_id}">
			<table border="1px" align="center" width="1000px" height="400px" cellpadding="0px" cellspacing="0px" style="background-color: #f7f8f8; margin-top: 36px;"  >

					<tr>
						<td colspan="2" style="text-align: center;">
							<font size="5">编辑传感器</font>
						</td>
					</tr>
					<tr>
						<td style="text-align: center;">
							传感器名称
						</td>
						<td style="padding-left: 5px;">
							<input type="text" name="sensor_name" value="${sensor.sensor_name}"/>
						</td>
					</tr>
					<tr>
						<td style="text-align: center;">
							传感器类型
						</td>
						<td style="padding-left: 5px;">
							<input type="text" name="sensor_type" value="${sensor.sensor_type}"/>
						</td>
					</tr>
					<tr>
						<td style="text-align: center;">
							地址
						</td>
						<td style="padding-left: 5px;">
							<input type="text" name="sensor_ip" value="${sensor.sensor_ip}"/>
						</td>
						
					</tr>
					<tr>
						<td style="text-align: center;">
							单位
						</td>
						<td style="padding-left: 5px;">
							<input type="text" name="sensor_unit" value="${sensor.sensor_unit}"/>
						</td>
					</tr>
					
					<tr>
						<!--注册-->
						<td colspan="2" height="30px" style="padding-left: 275px;">
							<input type="submit" value="保存" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消" />
						</td>
					
					</tr>
			</table>								
		</form>
	</body>
</html>
