<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $dg = $("#xxx");

        $dg.datagrid({
            url: '/baizhi_jw_sys/lawertype/showLawerTypes?id=${param.id}',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "专精项", field: "name", width: 200, align: 'center'}
            ]]
        });
    });
</script>

<table id="xxx"></table>


