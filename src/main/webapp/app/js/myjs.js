function ajaxsubmitadddevice() {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/adddevice",
            //提交的数据
            data: {
                code: $("#form_code").val(),
                name: $("#form_name").val(),
                company: $("#form_company").val(),
                deliverytime: $("#form_deliverytime").val(),
                endtime: $("#form_endtime").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                $("#adddevice").modal("hide");
                $(".modal-backdrop").remove();
                $('#main-content').html(data);
                // alert(data);
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return false;
}

function ajaxsubmitaddjob() {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/addjob",
            //提交的数据
            data: {
                desc: $("#form_job_desc").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                $("#addjob").modal("hide");
                $(".modal-backdrop").remove();
                $('#main-content').html(data);
                // alert(data);
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return false;
}
//
// $(function() {
//     $('#form_deliverytime').datepicker({
//         language: 'pt-BR'
//     });
// });

function ajaxregister() {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/user/registeruser",
            //提交的数据
            data: {
                // fullname: $("[name='fullname']").val(),
                // email: $("[name='email']").val(),
                // address: $("[name='address']").val(),
                // city: $("[name='city']").val(),
                // country: $("[name='country']").val(),
                username: $("[name='username']").val(),
                password: $("[name='password']").val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                alert("done");
                alert("success");
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
                alert("error");
            }
        }
    )

    return false;
}


function deletedevice(obj) {
    var res = confirm('确认要删除吗？');
    if(res == true)
    {
        var id = $(obj).parents('tr').children().eq(1).text();
        $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/deletedevice",
            //提交的数据
            data: {
                deviceid: id
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        })
        $(obj).parents("tr").remove();

    }
}

function modifydevice(obj) {
    var modifyState = false;
    if ($(obj).text() == "修改") {
        modifyState = true;
        $(obj).text("确定");
    }
    else {
        $(obj).text("修改");
    }
    var parent = $(obj).parents('tr').children();
    var nameView = parent.eq(2);
    var starttimeView = parent.eq(4);
    var statusView = parent.eq(5);
    var endtimeView = parent.eq(6);
    var id = $(obj).parents('tr').children().eq(1).text();

    if (modifyState) {
        var content = nameView.text();
        nameView.html("<input id=\"device_name\" type=\"text\" value='" + content + "' maxlength=\"25\" >");
        var starttime = starttimeView.text();
        starttimeView.html("<input id='device_starttime' type=\"text\" readonly=\"\"  value='" + starttime + "'>" +
            "<script>$(function() { $( \"#device_starttime\" ).datepicker({dateFormat: \"yy-mm-dd\"});  });</script>" +
            "</input>");
        var endtime = endtimeView.text();
        endtimeView.html("<input id='device_endtime' type=\"text\" readonly=\"\" value='" + endtime + "'>" +
            "<script>$(function() { $( \"#device_endtime\" ).datepicker({dateFormat: \"yy-mm-dd\"});  });</script>" +
            "</input>");
        statusView.html("<select id=\"device_status\">" +
            "<option value='0'>正常</option>" +
            "<option value='1'>异常</option></select>");
    }
    else {
        var text = nameView.find("input:text").val();//$("#device_name").val();
        nameView.html(text);

        var starttime = $("#device_starttime").val();
        starttimeView.html(starttime);
        var endtime = $("#device_endtime").val();
        endtimeView.html(endtime);
        var statusText = $("#device_status option:selected").text();
        var statusVal = $("#device_status option:selected").val();
        statusView.html(statusText);
        ajaxsubmitupdatedevice(id, text, starttime, endtime, statusVal);
    }

}

function ajaxsubmitupdatedevice(id, name, starttime, endtime, status) {
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/page/updatedevice",
            //提交的数据
            data: {
                deviceid: id,
                name: name,
                company: "",
                deliverytime: starttime,
                endtime: endtime,
                status: status
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return true;
}

var xhrequest;

function check_username(obj) {
    var username = $(obj).val();
    $("#username_check").text("检测中...");
    var path = '/rest/user/checkusername?username=' + username;
    xhrequest = new XMLHttpRequest();
    xhrequest.open('POST', path, true);
    xhrequest.onreadystatechange = checkusernamecallback;
    xhrequest.send();
}

function checkusernamecallback() {
    if (xhrequest.readyState===4 && xhrequest.status===200) {
        console.log(xhrequest.responseText);
        var result = xhrequest.responseText;
        if (result == 1)
            $("#username_check").text("用户名可以使用");
        else
            $("#username_check").text("用户名已被占用");
    }
}


function check_username2(obj) {
    if ($(obj).val().length == 0)
        return true;
    var label = $("#username_check");
    label.text("检测中...");
    label[0].setAttribute("uservalid", "false");
    $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"rest/user/checkusername2",
            //提交的数据
            data: {
                username: $(obj).val()
            },
            //返回数据的格式
            datatype: "html",
            //在请求之前调用的函数
            beforeSend:function(){},
            //成功返回之后调用的函数
            success:function(data){
                if (data == 1) {
                    $("#username_check").text("用户名可以使用");
                    $("#username_check")[0].setAttribute("uservalid", "true");
                }
                else {
                    $("#username_check").text("用户名已被占用");
                    $("#username_check")[0].setAttribute("uservalid", "false");
                }
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
                // $('#main-content').html(data);
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }
        }
    )

    return true;
}

function encryptPassword() {
    var password = $("[name='password']").val();
    var rpassword = $("[name='rpassword']").val();
    if (password.length > 0 && password == rpassword) {
        $("[name='password']").val(sha256_digest(password))
        $("[name='rpassword']").val(sha256_digest(rpassword))
    }
}

function checkusernamevalid() {
    var valid = $("#username_check")[0].getAttribute("uservalid");
    if (valid == "false") {
        return false;
    }

    return true;
}

function clickanother(ref) {
    var another = document.getElementById(ref);
    another.click();
}