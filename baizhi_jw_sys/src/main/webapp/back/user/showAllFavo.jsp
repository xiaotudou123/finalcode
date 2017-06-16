<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $dg = $("#favo");

        $dg.datagrid({
            url: '/baizhi_jw_sys/user/showFavo?id=${param.id}',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "姓名", field: "name", width: 200, align: 'center'},
                {title: "地址", field: "addredss", width: 200, align: 'center'},
                {title: "描述", field: "description", width: 200, align: 'center'},
            ]],
    });
    });
</script>

<table id="favo"></table>


