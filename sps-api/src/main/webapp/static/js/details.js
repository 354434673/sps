document.addEventListener('DOMContentLoaded', function () {
    var getId = aspenLib.getQueryString('pageId');
    var ajaxUrl = 'http://123.56.24.208:8480';
    var getTel = aspenLib.getQueryString('tel') || '';
    var setAllHTML = '';
    var setAcceptedHTML = '';
    var setUnacceptedHTML = '';
    var tabAjax = {
        init: function () {
            var _this = this;
            _this.tabRun();
            _this.ajaxDetailsList(getId);
        },
        tabRun: function () {
            var _this = this;
            var tabList = document.querySelectorAll('.info-list');
            var tabLi = document.querySelectorAll('.details-tab li');
            var createSpan = document.createElement('span');
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
                        _this.ajaxDetailsList(this.index);
                    }, false);
                }
            }
        },
        ajaxDetailsList: function (num) {
            var keyHtml = '';
            aspenLib.ajax({
                url: ajaxUrl + '/shopeeker/queryInvitationList',
                type: 'post',
                dataType: 'json',
                data: {
                    salemanPhone: getTel
                },
                success: function (data) {
                    setAllHTML = '';
                    var dataMain = data['result'];
                    if (data.code == '1') {
                        var getListWrap = document.querySelectorAll('.info-list')[num];
                        switch(num){
                            case '0':
                                keyHtml = 'allList';
                            break;
                            case '1':
                                keyHtml = 'accept';
                            break;
                            case '2':
                                keyHtml = 'noAccept';
                            break;
                        }
                        if(dataMain[keyHtml] && dataMain[keyHtml].length > 0){
                            for (var i = 0; i < dataMain[keyHtml].length; i++) {
                                setAllHTML += '<li>' +
                                    '<p><em>店主名称</em><i>' + dataMain[keyHtml][i].invitationName + '</i></p>' +
                                    '<p><em>手机号</em><i>' + dataMain[keyHtml][i].invitationPhone + '</i></p>' +
                                    '<p><em>地址</em><i>' + dataMain[keyHtml][i].invitationAddress + '</i></p>' +
                                    '<p><em>邀请时间</em><i>' + dataMain[keyHtml][i].invitationTime + '</i></p>' +
                                    '</li>';
                            }
                        }else{
                            aspenLib.tips('没有数据');
                        }
                        getListWrap.innerHTML = setAllHTML;
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