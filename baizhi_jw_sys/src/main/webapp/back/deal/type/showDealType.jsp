<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $dg = $("#dealtype");

        $dg.datagrid({
            url: '/baizhi_jw_sys/dealtype/showAll2?id=${param.id}',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "名称", field: "name", width: 200, align: 'center'}
            ]]
        });
    });
</script>

<table id="dealtype"></table>
