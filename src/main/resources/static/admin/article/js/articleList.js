var ind;

layui.use(['form', 'table','tree'], function(){
    var table = layui.table,
        form = layui.form;

    tableIns = table.render({
        elem: '#table'
        ,url: basePath + 'admin/queryRoleList'
        ,method: 'post'
        ,contentType: "application/json; charset=utf-8"
        ,dataType:"json"
        ,skin:'nob'// 无边框风格
        ,loading: true
        // 是否开启字段筛选的记忆功能，支持true/false/'local'/'session'/其他 开启的情况下默认是session，除非显式的指定为'local'
        ,colFilterRecord: true
        // 是否开启智能reload的模式
        ,smartReloadModel: true
        ,cols: [[
            {checkbox: true, id:"idTest", width:'2%'}
            ,{field:'rk', title:'序号', width:'6%', align:'center'}
            ,{field:'rolename', title:'文章名称', width:'20%', align:'center'}
            ,{field:'valid', title:'文章分类', width:'13%', align:'center'}
            ,{field:'valid', title:'来源方式', width:'13%', align:'center'}
            ,{field:'founder', title:'发布人', width:'16%', align:'center'}
            ,{field:'createtime', title:'发布时间', width:'15%', align:'center'}
            ,{field:'right', title:'操作', width:'15.4%', align:'center', toolbar: '#barDemo'},
        ]]
        ,id:"idTest"
        ,done:function(res,curr,count){
            $('th').css({ 'color': 'black', 'font-weight': 'bold'})//用于设置表头的样式，th即代表表头
            $(".layui-table-box").css("border-width","0px");
            $(".layui-table-header tr").css("height","25px");
            $(".layui-table-header tr span").css("color","#666666");
            $(".layui-table-body tr").css("height","25px");
            $(".layui-form-checkbox").css("style","margin-top: 5px;");
        }
        ,height : "full-195"
        ,page: false
    });

});

$("#releaseArticle").click(function(){
    layer.open({
        type: 2,
        title: "文章发布",
        shadeClose: true,
        shade: 0.5,
        closeBtn:1,
        area: ['100%', '100%'],
        content: basePath + '/article/releaseArticle',
        end: function () {//层消失回调
            //layReload1();
        }
    });
});