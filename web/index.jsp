<%--
  Created by IntelliJ IDEA.
  User: darius
  Date: 2018/9/22
  Time: 上午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    /*$(function(){

        setInterval(autoReflesh,1000);
        function autoReflesh(){
            var str = "";
            $.ajax({
                url : "${pageContext.request.contextPath }/getMessage.action",
                // data : params,
                contentType : "application/json;charset=UTF-8",//发送数据的格式
                type : "post",
                dataType : "json",//回调
                success : function(data){
                    // str += data.sensorMsg + "\n";
                    $("#sensorMessage_name").html(data.name);
                    $("#sensorMessage_message").html(data.message);
                    // alert(data);
                }
            });
        }
    });*/
</script>
<body>
<form action="${pageContext.request.contextPath}/createPort.action" method="post">
    传感器端口：<input type="text" name="sensorPort" value="${sensorPort}"><br>
    手机端口：<input type="text" name="mobilePort" value="${mobilePort}"><br>
    <input type="submit" value="确定">
</form>
<a href="${pageContext.request.contextPath}/createSensorConnection.action">建立传感器连接</a>
<br>
<a href="${pageContext.request.contextPath}/closeSensorConnection.action">关闭传感器连接</a>
<br>
当前传感器ip:${sensorConnectionIp}
<br>
<a href="${pageContext.request.contextPath}/createMobileConnection.action">建立手机连接</a>
<br>
<a href="${pageContext.request.contextPath}/closeMobileConnection.action">关闭手机连接</a>
<br>
当前手机ip:${mobileConnectionIp}
<br>
<br>
传感器信息：<br>
编号：
<div id="sensorMessage_name">

</div>
消息：
<br>

<div id="sensorMessage_message">

</div>
<br>
<br>
手机信息：
<div id="mobileMessage">

</div>

<a href="${pageContext.request.contextPath }/queryCurrentSensorInformation.action">测试按钮</a>
</body>
</html>
