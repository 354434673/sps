document.addEventListener('DOMContentLoaded', function () {
    var ajaxUrl = 'http://123.56.24.208:8480';
    var salemanPhone = aspenLib.getQueryString('salemanPhone') || '';
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
                    this.href = 'details.html?pageId=' + this.index + '&tel=' + salemanPhone;
                }, false);
            }
        },
        createCode: function () {
            var createCode = document.getElementById('createCode');
            var shopName = document.getElementById('shopName');
            var shopTel = document.getElementById('shopTel');
            var getAddress = document.getElementById('address');
            var supplierTel = document.getElementById('supplierTel');
            var qrcode = new QRCode("qrcode", {
                width: 150,
                height: 150
            });
            createCode.addEventListener('click', function () {
                if (!shopName || shopName.value == '') {
                    aspenLib.tips('请输入店主名称！');
                    shopName.focus();
                } else if (!shopTel || shopTel.value == '') {
                    aspenLib.tips('请输入店主手机号！');
                    shopTel.focus();
                } else if (!/^[1][3,4,5,7,8][0-9]{9}$/.test(shopTel.value)) {
                    aspenLib.tips('手机号格式不正确！');
                    shopTel.focus();
                } else if (!getAddress || getAddress.value == '') {
                    aspenLib.tips('请输入地址！');
                    getAddress.focus();
                } else if (!supplierTel || supplierTel.value == '') {
                    aspenLib.tips('请输入供应商店主手机号！');
                    supplierTel.focus();
                } else if (!/^[1][3,4,5,7,8][0-9]{9}$/.test(supplierTel.value)) {
                    aspenLib.tips('供应商手机号格式不正确！');
                    supplierTel.focus();
                } else {
                    var setUrl = ajaxUrl + '/register.html?sTel=' + shopTel.value + '&supplierTel=' + supplierTel.value + '&salemanPhone=' + salemanPhone;
                    aspenLib.ajax({
                        url: ajaxUrl + "/shopeeker/invitation",
                        type: 'post',
                        dataType: 'json',
                        data: {
                        	invitationAddress: getAddress.value,
                        	invitationChannelPhone: supplierTel.value,
                        	invitationName: shopName.value,
                            invitationPhone: shopTel.value,
                            invitationSalemanPhone: salemanPhone
                        },
                        success: function (data) {
                            if(data.code == '1'){
                                aspenLib.tips(data.msg);
                                qrcode.makeCode(setUrl);
                                console.log(setUrl);
                            }else{
                                aspenLib.tips(data.msg);
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