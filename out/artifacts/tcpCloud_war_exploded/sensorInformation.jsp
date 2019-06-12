<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>表格隔行换色</title>
    <style>
        #biao {
            border: 0px solid #f7f8f8;
            margin-top: 15px;
            text-align: center;
        }

        #sumt {
            border: 0px solid black;
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function(){
        setInterval(autoReflesh,1000);
        var $tab1 = $("#mytab");

        function autoReflesh(){
            $.ajax({
                url : "${pageContext.request.contextPath }/queryCurrentSensorInformation.action",
                // data : params,
                contentType : "application/json;charset=UTF-8",//发送数据的格式
                type : "post",
                dataType : "json",//回调
                success: function (data) {
                    var obj=eval(data);
                    var tbody=$('<tbody></tbody>');
                    $(obj).each(function (index) {
                        var val = obj[index];
                        var tr = $('<tr></tr>');
                        tr.append(
                            '<td>'+val.sensor.sensor_name+'</td>'+
                            '<td>'+val.sensor.isOnLine+'</td>'+
                            '<td>'+val.message+'</td>'+
                            '<td>'+val.sensor.sensor_unit+'</td>'+
                            '<td>'+val.sensor.sensor_ip+'</td>'+
                            '<td>'+val.time+'</td>'
                        );
                        tbody.append(tr);
                    });
                    $('#myTable tbody').replaceWith(tbody);
                }
            });
        }
    });
</script>
<body>
<div id="biao">
    <table id="myTable" border="1px" width="100%" height="400px" align="center" cellspacing="0px" bordercolor="gray"
           style="background-color: #f7f8f8;">
        <thead>
        <tr>
            <th>设备编号</th>
            <th>是否开启</th>
            <th>实时信息</th>
            <th>单位</th>
            <th>备注</th>
            <th>时间</th>
        </tr>
        </thead>
        <tbody>

        </tbody>

    </table>

</div>

</body>
</html>