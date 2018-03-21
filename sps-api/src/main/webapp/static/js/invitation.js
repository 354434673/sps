document.addEventListener('DOMContentLoaded', function () {

    var loadApp = {
        init: function () {
            var _this = this;
            _this.bindEvent();
            _this.createCode();
        },
        bindEvent: function () {
            var getaArray = document.querySelectorAll('.cur');
            for (var i = 0; i < getaArray.length; i++) {
                getaArray[i].index = i;
                getaArray[i].addEventListener('click', function () {
                    this.href = 'details.html?pageId=' + this.index;
                }, false);
            }
        },
        createCode: function () {
            var createCode = document.getElementById('createCode');
            var shopname = document.getElementById('shopname');
            var shopTel = document.getElementById('shopTel');
            var supplierTel = document.getElementById('supplierTel');
            var qrcode = new QRCode("qrcode", {
                width: 150,
                height: 150
            });
            createCode.addEventListener('click', function () {
                if (!shopTel || shopTel.value == '') {
                    aspenLib.tips('请输入店主手机号！');
                    shopTel.focus();
                } else if (!/^[1][3,4,5,7,8][0-9]{9}$/.test(shopTel.value)) {
                    aspenLib.tips('手机号格式不正确！');
                    shopTel.focus();
                } else if (!supplierTel || supplierTel.value == '') {
                    aspenLib.tips('请输入供应商店主手机号！');
                    supplierTel.focus();
                } else if (!/^[1][3,4,5,7,8][0-9]{9}$/.test(supplierTel.value)) {
                    aspenLib.tips('供应商手机号格式不正确！');
                    supplierTel.focus();
                } else {
                    //var setUrl = 'http://www.baidu.com?sTel=' + shopTel.value + '&supplierTel=' + supplierTel.value;
                    var setUrl = 'http://123.56.24.208:8480/register.html?source=1&channelPhone='+supplierTel.value;
                    aspenLib.ajax({
                        url: location.protocol + "//" + location.host+ "/sps-api/shopeeker/invitation",
                        //url: location.protocol + "//" + location.host + "/api/user/getPhoneCode/regist",
                        type: 'POST',
                        dataType: 'json',
                        data: {
                        	invitationName : shopname.value,
                            invitationPhone: shopTel.value,
                            invitationAddress: supplierTel.value
                        },
                        success: function (data) {
                            if (data.code == 1) {
                            	aspenLib.tips(data.msg);
                                qrcode.makeCode(setUrl);
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
            }, false);
        }
    }
    loadApp.init();
});