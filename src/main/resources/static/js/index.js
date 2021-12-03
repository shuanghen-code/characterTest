
$(function () {
    // 清空输入用户名点击事件
    $(".out").eq(0).on("click", function () {
        if ($(".text").eq(0).val() != "") {
            $(".text").eq(0).val(" ");
        }
    });
    // 点击隐藏显示密码操作
    var flag = 1;
    $(".out").eq(1).on("click", function () {
        if (flag == 0) {
            $(".text").eq(1).attr("type", "password")
            flag = 1
        } else {
            $(".text").eq(1).attr("type", "text")
            flag = 0
        }
        ;
    });
    // 点击登录按钮，判断账户和密码是否为空
    $(".btn-s").on("click", function () {
        if ($(".text").eq(0).val() == "" || $(".text").eq(1).val() == "") {
            $(".error-name").addClass("correct-name");
            // $(this).after("<span class='error-name'>用户名或密码不能为空</span>")
            console.log("a");
        } else {
            $.ajax({
                url: "/user/managerLogin",
                type: "post",
                data:JSON.stringify({loginName:$("#musername").val(),password:$("#mpassword").val()}),
                contentType:"application/json;charset=UTF-8",
                success:function (ret) {
                    if(ret.code==0){
                        window.location.href="/user/managerMenu?loginName="+ret.data.loginName;
                    }else {
                        // alert("账号密码错误")
                        $("#error-mes").text("用户名或密码错误").addClass("correct-name");
                        $("#musername").val("");
                        $("#mpassword").val("");

                    }
                }
            });
        }
        ;
    });
});