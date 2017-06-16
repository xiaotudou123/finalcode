<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="commForm" method="post">
        <div style="margin-top: 40px;">
            id:<input name="id" readonly class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            评分:<input name="score" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            内容:<input name="content" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            创建时间:<input name="createtime" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>


    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        //console.log("${param.id}");
        $("#commForm").form('load','/baizhi_jw_sys/order/showComment?id=${param.id}');
    });



</script>