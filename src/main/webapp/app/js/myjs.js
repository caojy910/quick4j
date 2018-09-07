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