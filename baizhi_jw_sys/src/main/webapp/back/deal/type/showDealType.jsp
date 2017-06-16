<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $dg = $("#dealtype");

        $dg.datagrid({
            url: '/baizhi_jw_sys/dealtype/showAll2?id=${param.id}',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "名称", field: "name", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>"
                    }
                }

            ]]
        });
    });

    //修改的操作
    function editRow(id){
        $da.dialog({
            width:600,
            height:300,
            title:"案例分类的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/deal/type/editDealType.jsp?id="+id,
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

    //修改用户
    function upLt(){
        $("#dtype").form('submit',{
            url:'/baizhi_jw_sys/dealtype/update',
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


</script>

<table id="dealtype"></table>
