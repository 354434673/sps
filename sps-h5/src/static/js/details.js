document.addEventListener('DOMContentLoaded', function () {
    var tabAjax = {
        init: function () {
            var _this = this;
            _this.tabRun();
        },
        tabRun: function () {
            var _this = this;
            var tabList = document.querySelectorAll('.info-list');
            var tabLi = document.querySelectorAll('.details-tab li');
            var getId = aspenLib.getQueryString('id');
            if (tabLi && tabList) {
                for (var k = 0; k < tabLi.length; k++) {
                    tabLi[k].classList.remove('hover');
                    tabList[k].style.display = 'none';
                }
                tabLi[getId].classList.add('hover');
                tabList[getId].style.display = 'block';
                
            }
            if (tabLi && tabList) {
                for (var i = 0; i < tabLi.length; i++) {
                    tabLi[i].index = i;
                    tabLi[i].addEventListener('click', function () {
                        var tabList = document.querySelectorAll('.info-list');
                        for (var k = 0; k < tabLi.length; k++) {
                            tabLi[k].classList.remove('hover');
                            tabList[k].style.display = 'none';
                        }
                        this.classList.add('hover');
                        tabList[this.index].style.display = 'block';
                    }, false);
                }
            }
        }
    }
    tabAjax.init();
});