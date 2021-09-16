<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看学生</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            // 在页面加载后执行ajax,获取数据
            getStudentInfo();
            // 手动刷新加载数据.
            $("#doAjax").on("click",function () {
                getStudentInfo();
            })
        })
        function getStudentInfo() {
            $.ajax({
                url:"student/queryStudents.do",
                dataType:"json",
                success:function (resp) {
                    // 清空原来的数据域
                    alert(resp);
                    $("#stuInfo").empty();
                    $.each(resp,function (i,e) {
                        // alert(e.id+":"+e.name+":"+e.age)
                        $("#stuInfo").append("<tr><td>"+e.id+"</td><td>"+
                            e.name+"</td><td>"+
                            e.age+"</td></tr>");
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <p>浏览学生<button type="button" id="doAjax">获取学生数据</button> </p>
        <table>
            <thead>
                <tr>
                    <td>id</td>
                    <td>姓名</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="stuInfo">

            </tbody>
        </table>
    </div>
</body>
</html>
