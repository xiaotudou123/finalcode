<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $dg = $("#redPackage");

        $dg.datagrid({
            url: '/baizhi_jw_sys/red/showAllByLid?id=${param.id}',
            //fit:true,
            width:'100%',
            height:'100%',
            fitColumns:true,
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "用户名", field: "uname", width: 200, align: 'center'},
                {title: "红包", field: "redpackage", width: 200, align: 'center'},
                {title: "内容", field: "content", width: 200, align: 'center'},

            ]]
        });
    });
</script>

<table id="redPackage"></table>
