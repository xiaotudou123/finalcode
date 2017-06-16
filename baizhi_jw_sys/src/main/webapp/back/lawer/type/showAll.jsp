<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    var $dg,$da;
    $(function () {
        $dg = $("#lawertypeDg");
        $da = $("#lawertypeDa");
        $dg.datagrid({
            url: '/baizhi_jw_sys/lawertype/showAll',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "名称", field: "name", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>";
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $(".del").linkbutton({
                    plain: true,
                    iconCls: 'icon-remove',

                });
                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
            },
            pagination:true,
            pageNumber:1,
            pageSize:2,
            pageList:[2,4,6,8,10],
            toolbar:'#lawertype',


        });
    });

    //添加的操作
    function addLawertype() {
        $da.dialog({
            width:600,
            height:300,
            title:"请填写分类的详细信息",
            iconCls:"icon-man",
            href:'/baizhi_jw_sys/back/lawer/type/addLawertype.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveltype,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('/baizhi_jw_sys/lawertype/delete',{"id":id});
                $dg.datagrid('reload');
            }
        });
    }


    //修改的操作
    function editRow(id){
        $da.dialog({
            width:600,
            height:300,
            title:"律师分类的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/lawer/type/editLawertype.jsp?id="+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:upLt,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //保存用户
    function saveltype(){
        $("#ltypeForm").form('submit',{
            url:'/baizhi_jw_sys/lawertype/add',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }

    //修改用户
    function upLt(){
        $("#inputForm").form('submit',{
            url:'/baizhi_jw_sys/lawertype/update',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }

    //关闭对话框
    function closeDa(){
        $da.dialog('close',true);
    }

    //搜索的处理程序
    function search(value,name){
        console.log(value);
        console.log(name);
        $dg.datagrid('load',{
            name:value
        });
    }

</script>


<div  class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north'," style="height:50px;">
        <div style="text-align: center;margin: 10px 0px 10px 0px;">
            <input id="ss" class="easyui-searchbox" style="width:300px"
                   data-options="searcher:search,prompt:'Please Input Value',menu:'#mm'"/>
            <div id="mm" style="width:120px">
                <div data-options="name:'name',iconCls:'icon-ok'">名称</div>
                <div data-options="name:'age'">年龄</div>
            </div>
        </div>
    </div>
    <div data-options="region:'center',">
        <table id="lawertypeDg" ></table>


        <div id="lawertypeDa"></div>

        <div id="lawertype">
            <a href="javascript:;" onClick="addLawertype()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>




