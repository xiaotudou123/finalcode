<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $dg = $("#lawerComments");

        $dg.datagrid({
            url: '/baizhi_jw_sys/comment/showAllById?id=${param.id}',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "cid", width: 200, align: 'center'},
                {title: "用户名", field: "uname", width: 200, align: 'center'},
                {title: "内容", field: "content", width: 200, align: 'center'},
                {title: "创建时间", field: "createtime", width: 200, align: 'center'},
                {title: "评分", field: "score", width: 200, align: 'center'},

            ]]
        });
    });
</script>

<table id="lawerComments"></table>