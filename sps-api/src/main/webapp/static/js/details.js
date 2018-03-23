document.addEventListener('DOMContentLoaded', function () {
    var ajaxUrl = 'http://123.56.24.208:8480';
    var getTel = aspenLib.getQueryString('tel') || '';
    var setAllHTML = '';
    var setAcceptedHTML = '';
    var setUnacceptedHTML = '';
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
        ajaxDetailsList: function () {
            aspenLib.ajax({
                url: ajaxUrl + '/shopeeker/queryInvitationList',
                type: 'post',
                dataType: 'json',
                data: {
                    mobile: getTel
                },
                success: function (data) {
                    // if () {
                    //     aspenLib.tips(data.msg);
                    // } else {
                    //     aspenLib.tips(data.msg);
                    //     return;
                    // }
                    var ajaxListArr = [data.allAccepted, data.accepted, data.noAccepted];
                    console.log(ajaxListArr[0]);
                    var getListWrap = document.querySelectorAll('.info-list')[0];
                    for (var i = 0; i < ajaxListArr[1].length; i++) {
                        setAllHTML += '<li>' +
                            '<p><em>店主名称</em><i>' + + '</i></p>' +
                            '<p><em>手机号</em><i>' + + '</i></p>' +
                            '<p><em>地址</em><i>' + + '</i></p>' +
                            '<p><em>邀请时间</em><i>' + + '</i></p>' +
                            '</li>';
                    }
                    getListWrap.innerHTML = setAllHTML;
                },
                error: function () {
                    console.log('ajax error');
                }
            });
        }
    }
    tabAjax.init();
});