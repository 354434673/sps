document.addEventListener('DOMContentLoaded', function () {
    var _this = this;
    var telNum = document.getElementById('telNum');
    var getCheckCode = document.getElementById('getCheckCode');
    var checkCode = document.getElementById('checkCode');
    var password = document.getElementById('password');
    var passwordNum = document.getElementById('passwordNum');
    var isCheckbox = document.querySelectorAll('.is-checkbox')[0];
    var isCheckboxCur = document.querySelectorAll('.is-checkbox')[0].querySelectorAll('span')[0];
    var submitBtn = document.getElementById('submitBtn');
    var getInput = document.querySelectorAll('input');
    var protocol = document.querySelectorAll('.protocol')[0];
    var register = {
        init: function () {
            // this.keyFocus();
            this.checkbox();
            this.getPhoneCode();
            this.submitInformation();
        },
        keyFocus: function () {
            for (var i = 0; i < getInput.length; i++) {
                getInput[i].index = i;
                getInput[i].addEventListener('focus', function () {
                    var getbody = document.querySelector('body');
                    submitBtn.style.position = 'static';
                    submitBtn.style.marginTop = '.4rem';
                }, false);
                getInput[i].addEventListener('blur', function () {
                    var getbody = document.querySelector('body');
                    submitBtn.style.position = 'absolute';
                    submitBtn.style.marginTop = '0';
                }, false);
            }
        },
        toggleClassRun: {
            hasClass: function (ele, cls) {
                return ele.className.match(new RegExp("(\\s|^)" + cls + "(\\s|$)"));
            },
            addClass: function (ele, cls) {
                if (!this.hasClass(ele, cls)) ele.className += "" + cls;
            },
            removeClass: function (ele, cls) {
                if (this.hasClass(ele, cls)) {
                    var reg = new RegExp("(\\s|^)" + cls + "(\\s|$)");
                    ele.className = ele.className.replace(reg, " ");
                }
            },
            toggleClass: function (ele, cls) {
                if (this.hasClass(ele, cls)) {
                    this.removeClass(ele, cls);
                } else {
                    this.addClass(ele, cls);
                }
            },
            toggleClassTest: function () {
                var ele = isCheckbox.querySelectorAll('span')[0];
                this.toggleClass(ele, 'active');
            }
        },
        checkbox: function () {
            var _this = this;
            protocol.addEventListener('click', function () {

                _this.toggleClassRun.toggleClassTest();

            }, false);
        },
        getPhoneCode: function () {
            var _this = this;
            var getCheckCode = document.getElementById('getCheckCode');
            if (getCheckCode) {
                getCheckCode.addEventListener('click', function () {
                    var self = this;
                    var telNum = document.getElementById('telNum');
                    if (telNum.value == '' || telNum.value.length == 0) {
                        aspenLib.tips('请先输入手机号！');
                        return;
                    } else if (!/^1\d{10}$/.test(telNum.value)) {
                        aspenLib.tips('手机号格式不正确！');
                        return;
                    } else {
                        var telNum = document.getElementById('telNum');
                        aspenLib.ajax({
                            //url: location.protocol + "//" + location.hostname + ":8080/sps-api/user/getPhoneCode/regist",
                            url: location.protocol + "//" + location.hostname + "/user/getPhoneCode/regist",
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                category : 1,
                                mobile: telNum.value
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
                }, false);
            }
        },
        countDown: function (id) {
            var _this = this;
            if (typeof id != 'undefined') {
                var getCode = document.getElementById(id.toString()) || document.querySelectorAll('.' + id.toString())[0];
                if (getCode) {
                    var setTimes;
                    var s = 60;
                    if (getCode.innerHTML == '获取验证码') {
                        setTimes = setInterval(function () {
                            s--;
                            getCode.innerHTML = s + '秒';
                            if (s < 10) {
                                getCode.innerHTML = '0' + s + '秒';
                            }
                            if (s == 0) {
                                getCode.innerHTML = '获取验证码';
                                clearTimeout(setTimes);
                                return false;
                            }
                        }, 1000);
                    } else {
                        aspenLib.tips('请等待有效时间获取！');
                        return false;
                    }
                }
            }
        },
        submitInformation: function () {
            var setClear = null;
            submitBtn.addEventListener('click', function () {
                var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,21}$/;
                if (telNum.value == '' || telNum.value.length == 0) {
                    aspenLib.tips('手机号不能为空！');
                    return;
                } else if (!/^1\d{10}$/.test(telNum.value)) {
                    aspenLib.tips('手机号格式不正确！');
                    return;
                } else if (checkCode.value == '' || checkCode.value.length == 0) {
                    aspenLib.tips('验证码不能为空！');
                    return;
                } else if (password.value == '' || password.value.length == 0) {
                    aspenLib.tips('密码不能为空！');
                    return;
                } else if (password.value.length < 8) {
                    aspenLib.tips('密码长度必须大于8位！');
                    return;
                } else if (!reg.test(password.value)) {
                    aspenLib.tips('密码必须由数字和字母组成！');
                    return;
                } else if (passwordNum.value == '') {
                    aspenLib.tips('请再次输入密码！');
                    return;
                } else if (passwordNum.value != password.value) {
                    aspenLib.tips('密码不一致！');
                    return;
                } else if (isCheckboxCur.className.indexOf('active') == -1) {
                    aspenLib.tips('请阅读协议！');
                    return;
                } else {
                    var getTerminalType = document.querySelectorAll('body')[0].className.indexOf('ios') != -1 ? '3' : '2';
                    aspenLib.ajax({
                        url: location.protocol + "//" + location.hostname + "/termi/doregister.html",
                        type: 'post',
                        dataType: 'json',
                        data: {
                            accurate: '',
                            channelID: '',
                            equipmentName: '',
                            identity: '',
                            latitude: '',
                            longitude: '',
                            recommendCode: '',
                            time: '',
                            mobile: telNum.value,
                            password: password.value,
                            terminalType: getTerminalType,
                            yzm: checkCode.value
                        },
                        success: function (data) {
                            if (data.result == 1) {
                                aspenLib.tips('您已注册成功！');
                                try {
                                    _hmt.push(['_trackEvent', aspenLib.getQueryString('channel') + 'zhuce', 'dianfu_register', 'click', aspenLib.getQueryString('channel') + 'zhuce']);
                                } catch (e) { }
                                setClear = setTimeout(function () {
                                    location.href = 'http://mall.juzifenqi.com/top.html';
                                    clearTimeout(setClear);
                                    setClear = null;
                                }, 1000);
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
    register.init();
});