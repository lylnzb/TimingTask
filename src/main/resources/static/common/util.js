var basePath="http://127.0.0.1/";//业务系统basePath

/**
 * 获取url参数的方法
 * @param name 参数名称
 * @returns
 */
function GetQueryString(name) {
    var query = window.location.search.substring(1); //获取url中"?"符后的字串，截取？后的字符串
    var vars = query.split("&");  //字符串按照&拆分
    for(var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");  //获取每一个参数
        if(pair[0] == name) {
            return pair[1];   //获取参数值
        }
    }
    return(false);
}



/**
 *	打开窗口的方法
 * openWin(url,title,type,funName,width,height) 在top层中使用
 **/
function openWin(url, title, funName, widths, heights) {
    var height = null != heights ? heights : document.documentElement.clientHeight;
    var height_v = null != heights ? heights : parent.$(document).height();
    var width = null != widths ? widths : parent.$(document).width();
    var index = top.layer.open({
        type: 2
        , area: [width + 'px', (height_v == height ? height : height + 40) + 'px']
        //,offset: [0,0]
        , shade: 0.3
        , maxmin: false
        , title: title
        , content: url
        , end: function () {//层消失回调
            if (undefined != funName) {
                callback(funName);
            } else {

            }
        }
    });
}

/**
 * 初始化下拉框的方法
 * @param ele
 * @param code
 * @param form
 */
function loadSelect(ele,code,form){
    $.ajax({
        url:basePath+'/common/queryCodeValue',
        type:"POST",
        data:{"dictType":code},
        async:false,
        success:function(data){
            for(var i = 0; i<data.data.length;i++){
                $(ele).append(new Option(data.data[i].dictlabel , data.data[i].dictvalue));
                //下拉菜单渲染 把内容加载进去
                form.render();
            }
        },
        error:function(){
            alert("初始化选项失败");
        }
    });
}
/**
 * 初始化单选框的方法
 * @param ele
 * @param code
 * @param form
 */
function loadRadio(ele,code,form){
    $.ajax({
        url:basePath+'/common/queryCodeValue',
        type:"POST",
        data:{"dictType":code},
        async:false,
        success:function(data){
            for(var i = 0; i<data.data.length;i++){
                var checked = "";
                if(data.data[i].isDefault == 'Y'){
                    checked = "checked=''";
                }
                $(ele).append("<input type=\"radio\" name=\""+code+"\" value=\""+data.data[i].dictValue+"\" title=\""+data.data[i].dictLabel+"\" "+checked+"\">");
                //下拉菜单渲染 把内容加载进去
                form.render();
            }
        },
        error:function(){
            alert("初始化选项失败");
        }
    });
}

function Cancel() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}