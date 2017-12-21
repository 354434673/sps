$(function(){
    var data = {
        data: [{
            name: 'Aspen'
        }]
    };

    var headContent = 
    '{{each data as title}}' +
        '<a href="javascript:;" class="sys-logo"></a>'+
        '<a class="head-and-name" href="javascript:;"><i><img src="../static/images/head.jpg" /></i><em>{{title.name}}</em><b></b></a><a href="javascript:;" id="newsTips">公告<i>20</i></a><a href="javascript:;" id="signOutSys">退出</a>'+
    '{{/each}}';

    var render = template.compile(headContent);
    var html = render(data);
    var sysHead = $('#sys-head');
    sysHead.html(html);
    sysHead.on("click", "#signOutSys", function() {
        $("body").newJZFQDialog({
            width:300,
            title:"系统提示",
            html:'<p style="text-align:center;">确认要退出系统吗？</p>',
            confirmBtn:"确认",
            cancelBtn:"取消",
            confirmBtnRun:function() {
                JZFQpublicRun.popCallbackClose();
                location.href = 'login.html';
            },
            cancelBtnRun:function() {},
            callback:function() {
                return !0;
            }
        });
    });
});