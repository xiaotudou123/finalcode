<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    var $dg,$da;
    $(function () {
        $dg = $("#userDg");
        $da = $("#userDa");
        $dg.datagrid({
            url: '/baizhi_jw_sys/user/showAll',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "姓名", field: "name", width: 200, align: 'center'},
                {title: "电话", field: "phone", width: 200, align: 'center'},
                {title: "余额", field: "money", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 600, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>"+
                                "<a class='edit' onClick=\"favoRow('" + row.id + "')\"  href='javascript:;'>收藏</a>";
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
            toolbar:'#tuser',


        });
    });

    //添加的操作
    function addStu() {
        $da.dialog({
            width:600,
            height:300,
            title:"请填写用户的详细信息",
            iconCls:"icon-man",
            href:'/baizhi_jw_sys/back/user/addUser.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveuser,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }

    //保存用户
    function saveuser(){
        $("#userForm").form('submit',{
            url:'/baizhi_jw_sys/user/add',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }


    //删除的操作
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('/baizhi_jw_sys/user/delete',{"id":id});
                $dg.datagrid('reload');
            }
        });
    }


    //修改的操作
    function editRow(id){
        $da.dialog({
            width:400,
            height:500,
            title:"用户的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/user/editUser.jsp?id="+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:upUser,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //收藏的律师的操作
    function favoRow(id){
        $da.dialog({
            width:400,
            height:500,
            title:"用户的收藏的律师详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/user/showAllFavo.jsp?id="+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }





    //修改用户
    function upUser(){
        $("#userForm").form('submit',{
            url:'/baizhi_jw_sys/user/update',
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
        <table id="userDg" ></table>


        <div id="userDa"></div>


        <div id="tuser">
            <a href="javascript:;" onClick="addStu()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>




