document.addEventListener('DOMContentLoaded', function () {
    var getTel = aspenLib.getQueryString('tel');
    var tabAjax = {
        init: function () {
            var _this = this;
            _this.tabRun();
            _this.ajaxDetailsList();
        },
        tabRun: function () {
            var _this = this;
            var tabList = document.querySelectorAll('.info-list');
            var tabLi = document.querySelectorAll('.details-tab li');
            var createSpan = document.createElement('span');
            var getId = aspenLib.getQueryString('pageId');
            if (tabLi && tabList) {
                for (var k = 0; k < tabLi.length; k++) {
                    tabList[k].style.display = 'none';
                }
                tabList[getId].style.display = 'block';
                tabLi[getId].appendChild(createSpan);
            }
            if (tabLi && tabList) {
                for (var i = 0; i < tabLi.length; i++) {
                    tabLi[i].index = i;
                    tabLi[i].addEventListener('click', function () {
                        var tabList = document.querySelectorAll('.info-list');
                        for (var k = 0; k < tabLi.length; k++) {
                            tabList[k].style.display = 'none';

                        }
                        tabList[this.index].style.display = 'block';
                        this.appendChild(createSpan);
                    }, false);
                }
            }
        },
        ajaxDetailsList: function(){
            aspenLib.ajax({
                url: 'http://123.56.24.208:8480/shopeeker/queryInvitationList',
                type: 'post',
                dataType: 'json',
                data: {
                    mobile: getTel
                },
                success: function (data) {
                    if (data.result == 1) {
                        _this.countDown('getCheckCode');
                    } else {
                        aspenLib.tips(data.msg);
                        return;
                    }
                },
                error: function () {
                    console.log('ajax error');
                }
            });
        }
    }
    tabAjax.init();
});