$(function(){
    /**
     * 如果用户未登录，则弹出登录框
     */
    if(is == 'no' && isLogin == 'false'){
        $(".bg").show();
        $(".login").show();
        $(".userLogin").show();
        $(".userRegister").hide();
        $(".userRetrievePas").hide();
    }
});

/**
 * 点击事件
 */
$(".isLogin").click(function(){
    if(isLogin == 'false'){
        $(".bg").show();
        $(".login").show();
        $(".userLogin").show();
        $(".userRegister").hide();
        $(".userRetrievePas").hide();
    }else{
        window.open("/user/userCenter");
    }
});

/**
 * 发送邮箱验证码
 */
function sendemail() {
    var obj = new Object();
    obj.tos = $(".email").val();
    $.ajax({
        url: 'http://127.0.0.1/commom/toEmail',
        type: "POST",
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: 'application/json;charset=utf-8',
        success: function (resultData) {
            var obj = $("#btn");
            settime(obj);
            console.log('发送邮件');
        },
        error: function () {

        }
    });
}

/**
 * 邮箱验证码一分钟倒计时
 * @param obj
 */
var countdown = 60;
function settime(obj) {
    if (countdown == 0) {
        obj.attr('onclick','sendemail();');
        obj.text("重新发送");
        countdown = 60;
        return;
    } else {
        obj.removeAttr('onclick');
        obj.text(countdown+"S");
        countdown--;
    }
    setTimeout(function() {
        settime(obj);
    }, 1000);
}

/**
 * 用户注册点击事件
 */
$("#register").click(function(){
    var obj = new Object();
    obj.email = $(".email").val();
    obj.password = $("#password").val();
    obj.vCode = $("#code").val();
    $.ajax({
        url: 'http://127.0.0.1/registerUser',
        type: "POST",
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: 'application/json;charset=utf-8',
        success: function (resultData) {
            if(resultData.code == 0){
                layui.layer.msg("注册成功");
            }else{
                layui.layer.msg(resultData.msg);
            }
        },
        error: function () {

        }
    });
});

/**
 * 登录输入框失焦事件
 */
$("#loginForm .required").blur(function(){
    var value = $(this).val();
    if(value != null && value != ''){
        var falg = 0;
        if($(this).attr("id") == 'userEmail'){
            falg = vailEmail(this,value);
        }
        if(falg == 0){
            $(this).parents(".field").siblings(".error").hide();
        }
    }
});

function vailEmail(elem,value){
    var myreg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    if(!myreg.test(value)){
        $(elem).parents(".field").siblings(".error").find(".transition").text("邮箱格式不正确");
        $(elem).parents(".field").siblings(".error").show();
        return 1;
    }
    return 0;
}

$("#login").click(function(){
    var obj = new Object();
    obj.email = $("#userEmail").val();
    obj.password = $("#userPwd").val();

    /**
     * 用户邮箱和密码是否为空验证
     * @type {number}
     */
    var traverse = 0;
    $("#loginForm .required").each(function(index,result){
        var value = $(this).val();
        if(value == null || value == ''){
            $(this).parents(".field").siblings(".error").show();
            traverse += 1;
        }else{
            if($(this).attr("id") == 'userEmail'){
                traverse += vailEmail(this,value);
            }
        }
    });
    if(traverse == 0){
        $.ajax({
            url: 'http://127.0.0.1/login',
            type: "POST",
            data: JSON.stringify(obj),
            dataType: "json",
            contentType: 'application/json;charset=utf-8',
            success: function (resultData) {
                if(resultData.code == 0){
                    location.reload();
                }else{
                    layui.layer.msg(resultData.msg);
                }

            },
            error: function () {

            }
        });
    }
});

$(".loginOut").click(function(){
    $.ajax({
        url: 'http://127.0.0.1/loginOut',
        type: "POST",
        dataType: "json",
        contentType: 'application/json;charset=utf-8',
        success: function (resultData) {
            if(resultData.code == 0){
                location.reload();
            }else{
                layui.layer.msg(resultData.msg);
            }

        },
        error: function () {

        }
    });
});

$("#adminlogin").click(function(){
    $(".bg").show();
    $(".login").show();
    $(".userLogin").show();
    $(".userRegister").hide();
    $(".userRetrievePas").hide();
});

$("#registerlogin").click(function(){
    $(".bg").show();
    $(".login").show();
    $(".userLogin").hide();
    $(".userRegister").show();
    $(".userRetrievePas").hide();
});

$(".loginBtn").click(function(){
    $(".userLogin").show();
    $(".userRegister").hide();
    $(".userRetrievePas").hide();
});

$(".registerBtn").click(function(){
    $(".userRetrievePas").hide();
    $(".userLogin").hide();
    $(".userRegister").show();
});

$(".forgotPasBtn").click(function(){
    $(".userRetrievePas").show();
    $(".userLogin").hide();
    $(".userRegister").hide();
});

$(".close.icon").click(function(){
    $(".bg").hide();
    $(".login").hide();
});


