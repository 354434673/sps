document.addEventListener('DOMContentLoaded', function () {
alert(2)
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
            var shopTel = document.getElementById('shopTel');
            var supplierTel = document.getElementById('supplierTel');
            var qrcode = new QRCode("qrcode", {
                width: 150,
                height: 150
            });
            createCode.addEventListener('click', function () {
                alert(1)
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
                    var setUrl = 'http://www.baidu.com?sTel=' + shopTel.value + '&supplierTel=' + supplierTel.value;
                    qrcode.makeCode(setUrl);
                }
            }, false);
        }
    }
    loadApp.init();
});