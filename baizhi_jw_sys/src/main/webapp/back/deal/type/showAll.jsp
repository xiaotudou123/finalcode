<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    var $dg,$da;
    $(function () {
        $dg = $("#dealtypeDg");
        $da = $("#dealtypeDa");
        $dg.datagrid({
            url: '/baizhi_jw_sys/dealtype/showAll',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "名称", field: "name", width: 200, align: 'center'},
                {title: "标识", field: "flag", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>"+
                                "<a class='edit' onClick=\"showDealTypes('" + row.id + "')\"  href='javascript:;'>查看类别</a>";
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
            toolbar:'#tdealtype',


        });
    });

    //添加的操作
    function addDealType() {
        $da.dialog({
            width:600,
            height:300,
            title:"请填写分类的详细信息",
            iconCls:"icon-man",
            href:'/baizhi_jw_sys/back/deal/type/addDealtype.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveDealtype,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

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

    //查看类别的操作
    function showDealTypes(id){
        $da.dialog({
            width:600,
            height:300,
            title:"类别分类的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/deal/type/showDealType.jsp?id="+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //保存用户saveDeal
    function saveDealtype(){
        $("#dealtypeForm").form('submit',{
            url:'/baizhi_jw_sys/deal/add',
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
        $dg.datagrid('reload');
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
        <table id="dealtypeDg" ></table>


        <div id="dealtypeDa"></div>

        <div id="tdealtype">
            <a href="javascript:;" onClick="addDealType()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>




