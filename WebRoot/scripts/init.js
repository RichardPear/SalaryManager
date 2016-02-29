(function($){
    $(function(){

        $('.button-collapse').sideNav();//滑出左侧导航菜单
        $('.parallax').parallax();
        $('select').material_select();//下拉框
        $('.collapsible').collapsible({
            accordion : false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
        });
        $(".dropdown-button").dropdown({
            hover: false
        });//滑动菜单
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });
        //模态
        $('.modal-trigger').leanModal({
            dismissible: false, // Modal can be dismissed by clicking outside of the modal
            opacity: .5, // Opacity of modal background
            in_duration: 300, // Transition in duration
            out_duration: 200, // Transition out duration
            ready: function () {

            }, // Callback for Modal open
            complete: function () {

            } // Callback for Modal close
        });
        //view_week and view_list 切换
        var icon = $("i[class~='material-icons']");//找到含有这个class的元素
        for(var i = 1,len = icon.length;i < len;i ++){
            var $parent = $(icon[i].parentNode);
            $parent.click(function(){
                var i = $(this).find("i")[0];
                var text = $(i).text();
                if(text == "view_list"){
                    $(i).text("view_week");
                }else if(text == "view_week")
                    $(i).text("view_list");
            });
        }

    });

})(jQuery);
