<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求方式</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<%--    给按钮绑定事件--%>
    <script type="text/javascript">
        $(function(){
            $("#btnAjax").on("click",function () {
                $.ajax({
                    url:"return-void-ajax1.do",
                    method:"post",
                    data:{
                        name:"张三ajax",
                        age:20
                    },
                    dataType:"json",
                    success:function (resp) {
                        // resp = XMLHttpRequest.responseText;
                        alert("resp=="+resp+":"+"name="+resp.name+"-"+resp.age);

                    }
                })
            })
        })
    </script>
    <script type="text/javascript">
        $(function () {
            $("#btnAjax1").on("click",function () {
                $.ajax({
                    url:"doStudentJson.do",
                    method: "post",
                    data: {
                        name:"李四",
                        age:40
                    },
                    dataType: "json",
                    success:function (resp) {
                        alert("resp=="+resp+":"+"name="+resp.name+"-"+resp.age);
                    }

                })
            })
        })
    </script>
    <script type="text/javascript">
        $(function () {
            $("#btnAjax2").on("click",function () {
                $.ajax({
                    url:"doAjaxJsonArray.do",
                    method: "post",
                    data: {
                        name:"李四",
                        age:40
                    },
                    dataType: "json",
                    success:function (resp) {
                       $.each(resp,function (i,n) {
                       //     i 是循环变量
                       //    n 是成员 ,
                           alert("resp:=="+i+"=:="+"name="+n.name+"-"+n.age);
                       })
                    }

                })
            })
        })
    </script>
    <script type="text/javascript">
        $(function () {
            $("#btnAjax3").on("click",function () {
                $.ajax({
                    url:"doStringData.do",
                    method: "post",
                    data: {
                        name:"李四",
                        age:40
                    },
                    dataType: "text",
                    success:function (resp) {
                      alert("返回的数据"+resp);
                    }

                })
            })
        })
    </script>
</head>
<body>
    <p>控制器方法返回String-逻辑视图名称</p>
    <form action="return-string-view1.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
    <p>控制器方法返回String-完整视图路径,项目中不需要配置视图解析器</p>
    <form action="return-string-view2.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
    <hr/>
    <p>发起ajax请求:void</p>
    <button id="btnAjax" type="button">发起ajax请求</button>
    <p>发起ajax请求:返回对象Student</p>
    <button id="btnAjax1" type="button">发起ajax请求</button>
    <p>发起ajax请求:返回对象List</p>
    <button id="btnAjax2" type="button">发起ajax请求</button>
    <p>发起ajax请求:返回String数据</p>
    <button id="btnAjax3" type="button">发起ajax请求</button>

</body>
</html>
