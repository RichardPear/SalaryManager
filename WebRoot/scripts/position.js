/**
 * Created by Administrator on 2015/9/22.
 */
$(function(){
    tree();

});
//树展开收缩切换
function tree(){
    var icon = $("i[class~='tree']");//找到含有这个class的元素
    for(var a = 0,len = icon.length;a < len;a ++){
        var $parent = $(icon[a].parentNode);

        $parent.click(function(a){
            return function(){
                if($(icon[a]).hasClass("material-icons")){
                    $(icon[a]).removeClass("material-icons");
                    $(icon[a]).text("—");
                }else{
                    $(icon[a]).addClass("material-icons");
                    $(icon[a]).text("add");
                }
            }
        }(a));
    }
}