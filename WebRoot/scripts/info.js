/**
 * Created by Administrator on 2015/9/21.
 */
$(function(){



    //全选
    var $selectAll = $("#head-check");
    var $selectAllLabel = $("#head-check + label");
    var checkbox = $("td input[type='checkbox']");

    $selectAll.change(function(){
        var res = $selectAll.is(':checked');
        checkbox.prop('checked',res);
        checkbox.change();
    });
    checkbox.change(function(){
        var flag = 1;
        for(var i = 0,len = checkbox.length;i < len;i ++){
            if(!($(checkbox[i]).is(":checked"))){
                flag =  0;
                $("#head-check").removeAttr("checked");
            }

        }
        if(flag){
            $("#head-check + label").click();
        }
    });



    //标记已阅
    $("#read-state-list").find(".read").click(function read(){
        var $span = $("#unreadMessages");
        var number = parseInt($span.text());
        var $checkbox = $("td input[type='checkbox']");
        for(var i = 0,len = $checkbox.length;i < len;i ++){
            var $td = $($checkbox[i]).parent();
            var $tr = $td.parent();
            if($($checkbox[i]).is(":checked") && $tr.hasClass("unread-bg")){
                $tr.removeClass("unread-bg");
                $span.text(--number);
                if(number <= 0){
                    $span.removeClass("new");
                    $span.text("");
                }
                if($("#head-check").is(":checked")){
                    $("#head-check").removeAttr("checked");
                }
            }
            $($checkbox[i]).removeAttr("checked");

        }
        if($("#head-check").is(":checked")){
            $("#head-check + label").click();
        }
    });
    //标记未读
    $("#read-state-list").find(".unread").click(function(){
        var $span = $("#unreadMessages");
        var number = parseInt($span.text()) || 0;
        var $checkbox = $("td input[type='checkbox']");
        for(var i = 0,len = $checkbox.length;i < len;i ++){
            var $td = $($checkbox[i]).parent();
            var $tr = $td.parent();
            if($($checkbox[i]).is(":checked") && !$tr.hasClass("unread-bg")){
                $tr.addClass("unread-bg");
                number ++;
                $span.text(number);
                if(number > 0){
                    $span.addClass("new");
                }

            }
            $($checkbox[i]).removeAttr("checked");

        }
        if($("#head-check").is(":checked")){
            $("#head-check + label").click();
        }
    });

});