document.addEventListener('DOMContentLoaded', function () {

    var loadApp = {
        init: function () {
            // this.loadAppRun();
        },
        loadAppRun: function () {
            var getDownBtns = document.getElementById('downloadBtn');
            var downLink = {};
            aspenLib.ajax({
                url: '',
                type: 'post',
                dataType: 'json',
                data: {},
                success: function (data) {
                    var getVapk = data.data.version || '5.0.0';
                    var vBate = getQueryString('channel') || 'GW';
                    downLink = {
                        'ios': '',
                        'android': ''
                    };
                },
                error: function () {
                    console.log('ajax error');
                }
            });

            var getTips = document.querySelector('.tips-mask');
            getTips.style.display = 'none';
            function openApp(appUrl, url) {
                var hasApp = true;
                var speed = 1000;
                setTimeout(function () {
                    if (!hasApp) {
                        location.href = url;
                    }
                }, 2000);
                var timea = Date.now();
                location.href = appUrl;
                setTimeout(function () {
                    var timeb = Date.now();
                    hasApp = !(!timea || timeb - timea < speed + 150);
                }, speed);
            };
            getDownBtns.addEventListener('click', function () {
                var UA = window.navigator.userAgent,
                    IsAndroid = /Android|HTC/i.test(UA),
                    IsIPad = !IsAndroid && /iPad/i.test(UA),
                    IsIPhone = !IsAndroid && /iPod|iPhone/i.test(UA),
                    IsIOS = IsIPad || IsIPhone;
                if (UA.toLowerCase().match(/MicroMessenger/i) == "micromessenger") {
                    if (IsAndroid || IsIOS) {
                        getTips.style.display = 'block';
                    }
                } else {
                    getTips.style.display = 'none';
                    var getProductId = getQueryString('productId');
                    if (getProductId) {
                        if (IsIOS) {
                            openApp('juzifenqi://productDetail?productId=' + getProductId, downLink['ios']);
                        } else {
                            openApp('juzifenqi://productDetail?productId=' + getProductId, downLink['android']);
                        }
                    } else {
                        if (IsIOS) {
                            openApp('juzifenqi://', downLink['ios']);
                        } else {
                            openApp('juziapp://home', downLink['android']);
                        }
                    }
                }
            }, false);
        }
    }
    loadApp.init();
});