<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $("#lts").combobox({
        url:'/baizhi_jw_sys/lawertype/showAll1',
        valueField:'id',
        textField:'name',
        multiple:true,
    });
</script>


<div style="text-align: center;">
    <form id="lawerForm" method="post">
        <div style="margin-top: 40px;">
            姓名:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            地址:<input name="address" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            执业年限:<input name="year" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            执业证号:<input name="number" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            工作地:<input name="workspace" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            描述:<input name="description" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            文字咨询价钱:<input name="wordprice" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            电话咨询价钱:<input name="phoneprice" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            photo:<input name="photo" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            状态:<input name="status" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>

        <div style="margin-top: 10px;">
            律师类别:<input id="lts" name="lawerTypes">
        </div>

    </form>
</div>

