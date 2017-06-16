<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    var $dg,$da;
    $(function () {
        $dg = $("#lawerDg");
        $da = $("#lawerDa");
        $dg.datagrid({
            url: '/baizhi_jw_sys/lawer/showAll',
            //fit:true,
            width:'100%',
            height:'100%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "头像", field: "photo", width: 200, align: 'center',
                    formatter:function(value,row,index){
                        return "<img width='30px' height='30px' src=\"http://localhost:8989//baizhi_jw_sys/"+row.photo+" \"/>"
                    }
                },
                {title: "姓名", field: "name", width: 200, align: 'center'},
                {title: "地址", field: "address", width: 200, align: 'center'},
                {title: "执业年限", field: "year", width: 200, align: 'center'},
                {title: "电话咨询价格", field: "phoneprice", width: 200, align: 'center'},
                {title: "文字咨询价格", field: "wordprice", width: 200, align: 'center'},

                {
                    title: "操作", field: "options", width: 600, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>"+
                                "<a class='edit' onClick=\"stRow('" + row.id + "')\"  href='javascript:;'>查看类别详细</a>"+
                                "<a class='edit' onClick=\"showCommentRow('" + row.id + "')\"  href='javascript:;'>查看评价详细</a>"+
                                "<a class='edit' onClick=\"showRedRow('" + row.id + "')\"  href='javascript:;'>查看心意详细</a>";
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
            toolbar:'#lawer',


        });
    });

    //添加的操作
    function addLawer() {
        $da.dialog({
            width:600,
            height:300,
            title:"请填写律师的详细信息",
            iconCls:"icon-man",
            href:'/baizhi_jw_sys/back/lawer/lawer/addLawer.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:savelawer,
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
                $.get('/baizhi_jw_sys/lawer/delete',{"id":id});
                $dg.datagrid('reload');
            }
        });
    }


    //修改的操作
    function editRow(id){
        $da.dialog({
            width:400,
            height:500,
            title:"律师分类的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/lawer/lawer/editLawer.jsp?id="+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:upLawer,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }




    //查看类别的操作
    function stRow(id){
        $da.dialog({
            width:400,
            height:500,
            title:"律师分类的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/lawer/lawer/showLawerTypes.jsp?id="+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }

    //查看评价的操作
    function showCommentRow(id){
        $da.dialog({
            width:700,
            height:500,
            title:"律师评价的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/lawer/lawer/lawerComments.jsp?id="+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //查看心意的操作
    function showRedRow(id){
        $da.dialog({
            width:700,
            height:500,
            title:"律师红包的详细信息",
            iconCls:"icon-man",
            href:"${pageContext.request.contextPath}/back/lawer/lawer/showAllRed.jsp?id="+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }

    //保存用户
    function savelawer(){
        $("#lawerForm").form('submit',{
            url:'/baizhi_jw_sys/lawer/add',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }

    //修改用户
    function upLawer(){
        $("#inputForm").form('submit',{
            url:'/baizhi_jw_sys/lawer/update',
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
        <table id="lawerDg" ></table>


        <div id="lawerDa"></div>



        <div id="lawer">
            <a href="javascript:;" onClick="addLawer()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>




