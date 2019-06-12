<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>表格隔行换色</title>


    <style>
        #but {
            border: 0px solid white;
            margin: auto;

            text-align: center;
            margin-top: 14px;
        }

        #table {
            border: 1px solid white;
            text-align: center;
            height: 100%;
            width: 100%;
            margin-top: 15px;
            background-color: #f7f8f8;
        }

    </style>

    <script>
        //添加按钮
        function add() {
            window.location.href("editSensor.jsp");
        }

        //编辑按钮
        function compile() {
            嘻嘻嘻
        }
    </script>
</head>
<body>
<div id="table">
    <table border="1" width="100%" height="400px" align="center" style="margin: auto;" cellspacing="0px"
           bordercolor="gray" style="background-color: #f7f8f8;">
        <tr >
            <th>传感器名称</th>
            <th>传感器类型</th>
            <th>地址</th>
            <th>单位</th>
            <th>编辑</th>
            <th>删除</th>
        </tr>

        <c:forEach items="${sensorList}" var="sensor">
            <tr>
                <td>${sensor.sensor_name}</td>
                <td>${sensor.sensor_type}</td>
                <td>${sensor.sensor_ip}</td>
                <td>${sensor.sensor_unit}</td>
                <td><input type="button" value="编辑"
   onclick="location.href='${pageContext.request.contextPath}/querySensorById.action?id=${sensor.sensor_id}'"/></td>
                <td><input type="button" value="删除"
   onclick="location.href='${pageContext.request.contextPath}/deleteSensorById.action?id=${sensor.sensor_id}'"/></td>


            </tr>
        </c:forEach>

    </table>
</div>
<div id="but">
    <input type="button" value="添加" onclick="location.href='addSensor.jsp'"/>
</div>

</body>
</html>
