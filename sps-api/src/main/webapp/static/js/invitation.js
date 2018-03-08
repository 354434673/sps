document.addEventListener('DOMContentLoaded', function () {
   
    var loadApp = {
        init: function () {
            var _this = this;
            _this.bindEvent();
        },
        bindEvent: function(){
            var getaArray = document.querySelectorAll('.cur');
            for(var i = 0; i < getaArray.length; i++){
                getaArray[i].index = i;
                getaArray[i].addEventListener('click', function(){
                    this.href = 'details.html?id=' + this.index;
                }, false);
            }
        },
        loadAppRun: function(){

        }
    }
    loadApp.init();
});