var pagesClass = {
    init: function() {
        this.loadHtml();
    },
    loadHtml: function() {
        var _this = this;
        var crealEventDiv = document.createElement('div');
        crealEventDiv.id = 'zproPageWrap';
        crealEventDiv.innerHTML = '<a href="javascript:;" class="zpro-page-first">首页</a><a href="javascript:;" class="zpro-page-prev">上一页</a>' +
            '<span class="zpro-page-information">当前第<strong id="zproCursPage">1</strong>页/共<i id="zproAllPage">0</i>页</span>' +
            '<a href="javascript:;" class="zpro-page-next">下一页</a><a href="javascript:;" class="zpro-page-last">尾页</a><span class="zpro-page-goopen">' +
            '<input type="text" class="zpro-go-inpt" /><a href="javascript:;" id="zproGoopen">GO</a></span><em id="zproPageInfor">当前页0条/共0条</em>' +
            '<span class="zpro-page-selnum"><select id="zproSelectNumber"><option value="5">5</option><option value="8">8</option><option value="10">10</option>' +
            '<option value="20">20</option><option value="50">50</option><option value="100">100</option></select></span>';
        document.getElementById('cmpager').appendChild(crealEventDiv);
        _this.LoadInitHtml();
    },
    LoadInitHtml: function(){
        var opts = {
            pageSize: $('#zproSelectNumber').val(),
            pageNo: $('#zproCursPage').html()
        };
        search(opts, function(data) {
            $('#zproAllPage').html(data.totalPage);
            $('#zproPageInfor').html('当前页' + data.pageSize + '条/共' + data.totalCount + '条');
        });
        this.bindEvent();
    },
    bindEvent: function() {
        var pageWraps = $('#zproPageWrap');
        var curPages = $('#zproCursPage'),
            allNum = $('#zproAllPage'),
            selNum = $('#zproSelectNumber');
        /* go link */
        pageWraps.on('click', '#zproGoopen', function() {
            var zproGoInpt = $('.zpro-go-inpt');
            var isNum = /^[0-9]*$/;
            if ($.trim(zproGoInpt.val()) == '') {
                zproGoInpt.addClass('add-errors');
                zproGoInpt.focus();
                return false;
            } else if (!isNum.test($.trim(zproGoInpt.val()))) {
                zproGoInpt.addClass('add-errors');
                zproGoInpt.focus();
                return false;
            } else if (parseInt($.trim(zproGoInpt.val())) > parseInt($('#zproAllPage').html())) {
                zproGoInpt.addClass('add-errors');
                zproGoInpt.focus();
                return false;
            } else if (parseInt($.trim(zproGoInpt.val())) < 1) {
                zproGoInpt.addClass('add-errors');
                zproGoInpt.focus();
                return false;
            } else {
                zproGoInpt.removeClass('add-errors');
                search({
                    pageNo: parseInt($.trim(zproGoInpt.val())),
                    pageSize: parseInt(selNum.val())
                });
                curPages.html(zproGoInpt.val());
                zproGoInpt.val('');
            }
        });
        pageWraps.on('blur', '.zpro-go-inpt', function() {
            $(this).removeClass('add-errors');
        });
        /* prev */
        pageWraps.on('click', '.zpro-page-prev', function() {
            var getCursPage = parseInt(curPages.html());
            getCursPage--;
            if (getCursPage < 1) {
                return false;
            } else {
                curPages.html(getCursPage);
                search({
                    pageNo: parseInt(curPages.html()),
                    pageSize: parseInt(selNum.val())
                });
            }
        });
        /* next */
        pageWraps.on('click', '.zpro-page-next', function() {
            var getCursPage = parseInt(curPages.html());
            getCursPage++;
            if (getCursPage > parseInt($('#zproAllPage').html())) {
                return false;
            } else {
                curPages.html(getCursPage);
                search({
                    pageNo: parseInt(curPages.html()),
                    pageSize: parseInt(selNum.val())
                });
            }
        });
        /* first */
        pageWraps.on('click', '.zpro-page-first', function() {
            curPages.html(1);
            search({
                pageNo: parseInt(curPages.html()),
                pageSize: parseInt(selNum.val())
            });
        });
        /* last */
        pageWraps.on('click', '.zpro-page-last', function() {
            curPages.html(allNum.html());
            search({
                pageNo: parseInt(curPages.html()),
                pageSize: parseInt(selNum.val())
            });
        });
        /* select num */
        pageWraps.on('change', '#zproSelectNumber', function() {
            var frfminput = $('.frfminput');
            var stateSel = $('.state-sel');
            dataObj = {
                'keyword_type': '',
                'keyword': '',
                'start_time': $.trim(frfminput.eq(1).val()),
                'end_time': $.trim(frfminput.eq(2).val()),
                'p': typeof curPage != 'undefined' ? parseInt(curPage) : 1,
                'num': parseInt($('#zproSelectNumber').val()),
                'show': parseInt(stateSel.val())
            }
            curPages.html(1);
            var opts = {
                pageNo: 1,
                pageSize: parseInt(selNum.val())
            };
            search(opts, function(data) {
                $('#zproAllPage').html(data.totalPage);
                $('#zproPageInfor').html('当前页' + data.pageSize + '条/共' + data.totalCount + '条');
            });
        });
    }
};
pagesClass.init();