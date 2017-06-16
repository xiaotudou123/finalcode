<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="dealtypeForm" method="post">
        <div style="margin-top: 70px;">
            名称:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            案例类别:<input id="dealtypes" name="parentid">
        </div>
    </form>
</div>

<script>
    $("#dealtypes").combobox({
        url:'/baizhi_jw_sys/dealtype/showAlll',
        valueField:'id',
        textField:'name',
    });
</script>





