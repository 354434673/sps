/* data ajax get */ 
$(function(){
    var data = {
        data: [{
            name:'经营报告',
            script:'index',
            subMenu:[
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'}
            ]
        },{
            name:'数据中心',
            script:'index',
            subMenu:[
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'} 
            ]
        },{
            name:'商家中心',
            script:'index',
            subMenu:[
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'},
                {name:'整体经营概括',script:'index',url:'javascript:;'}
            ]
        }]
    };

    var barList =
    '<h1>数据中心</h1>'+
    '<ul class="bar-menu clearfix">'+
        '{{each data as title}}' +
        '<li>'+
            '<a href="javascript:;" class="bar-init-link" data-script="{{title.script}}"><i class="bar-icon-b"></i><em>{{title.name}}</em></a>'+
            '<div class="bar-sub-menu clearfix" style="display:none;">'+
                '{{each title.subMenu as subnav}}' +
                '<a href="{{subnav.url}}" data-script="{{subnav.script}}" class="bar-sub-link">{{subnav.name}}</a>'+
                '{{/each}}' +
            '</div>'+
        '</li>'+
        '{{/each}}' +
    '</ul>';

    var render = template.compile(barList);
    var html = render(data);
    var leftBar = $('#left-bar');
    leftBar.html(html);
    leftBar.find('.bar-init-link').eq(0).addClass('curs');
    leftBar.find('.bar-sub-menu').eq(0).css({display: 'block'});
});