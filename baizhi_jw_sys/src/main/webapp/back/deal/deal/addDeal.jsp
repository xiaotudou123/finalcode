<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="dealForm" method="post">
        <div style="margin-top: 70px;">
            标题:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            内容:<input name="content" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            案例类别:<input id="dealtwotype" name="dealtypeid">
        </div>
    </form>
</div>

<script>
    $("#dealtwotype").combobox({
        url:'/baizhi_jw_sys/dealtype/showAllTwo',
        valueField:'id',
        textField:'name',
    });
</script>
