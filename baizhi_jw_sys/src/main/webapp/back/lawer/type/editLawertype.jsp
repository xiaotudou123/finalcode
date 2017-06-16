<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="inputForm" method="post">
        <div style="margin-top: 70px;">
            id:<input name="id" readonly class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            姓名:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        //console.log("${param.id}");
        $("#inputForm").form('load','/baizhi_jw_sys/lawertype/queryOne?id=${param.id}');

    });



</script>
