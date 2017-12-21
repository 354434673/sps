$(function(){
    var setAgenment = {}
    /* 设置查询版式 */
    JZFQpublicRun.pageHead([
        /* 查询表单 */
        [{
            name:'用户',
            type: 'text',
            value: '用户ID'
        },{
            name:'起始时间',
            type: 'time',
            value: '请选择时间'
        },{
            name:'结束时间',
            type: 'time',
            value: '请选择时间'
        },{
            name:'权限',
            type: 'select',
            option: ['北京','上海','广州'],
            value:['1','2','3']
        }],
        /* 操作按钮 */
        [{
            type: 'button',
            value:'查询',
            id:'queryInformation'
        },{
            type: 'button1',
            value:'重置',
            id:'resetInpt'
        },{
            type: 'button',
            value:'增加',
            id:'addInformation'
        }]
    ]);
    /* 加载表格数据 */
    ;function structureHtml(data){
        if(data.success == true){
            var indexList = '';
            var dataMains = $('#dataMains');
            dataMains.find('.public-table').remove();
            dataMains.find('#jzfqPageWrap').remove();
            dataMains.find('#cmpager').remove();
            var setDataContent = data.result.content;
            indexList += '<table class="public-table" id="publicTable">'+
                '<thead>'+
                    '<tr>'+
                        '<th>ID</th>'+
                        '<th>姓名</th>'+
                        '<th>年龄</th>'+
                        '<th>地址</th>'+
                        '<th>业务</th>'+
                        '<th>操作</th>'+
                    '</tr>'+
                '</thead>'+
                '<tbody>';
                    for(var i = 0; i < setDataContent.length; i++){
                        indexList += '<tr>'+
                            '<td>'+ setDataContent[i].id +'</td>'+
                            '<td>'+ setDataContent[i].name + '</td>'+
                            '<td>'+ setDataContent[i].age +'</td>'+
                            '<td>'+ setDataContent[i].address  +'</td>'+
                            '<td>'+ setDataContent[i].sss +'</td>'+
                            '<td><a href="javascirpt:;" class="updata-btna">修改</a><a href="javascirpt:;" class="del-btna">删除</a></td>'+
                        '</tr>';
                    }
                indexList += '</tbody>'+
            '</table>';
            indexList += '<div id="cmpager"></div>';
            dataMains.append(indexList);
            JZFQpublicRun.trbgColor($('#publicTable'));
            /* load page */
            if(data.result.totalElements >= 10){
                JZFQpublicRun.initPageHtml({
                    curPage: data.result.number,
                    allPage: data.result.totalPages, 
                    allNumber: data.result.totalElements,
                    curNumber: data.result.size
                });
            }
        }else{
            JZFQpublicRun.nodataTips(data.msg);
        }
    };
    /* 初始化加载 */
    setAgenment = {
        page: 1,
        pageSize: 10,
        name: '',
    }
    JZFQpublicRun.publicAjax('post','http://systemplate.juzifenqi.cn/cap/c/test/getAllUser', setAgenment, function(data){
        structureHtml(data);
    });
    /* 运行分页方法 */
    JZFQpublicRun.loadPageMainRun('post','http://systemplate.juzifenqi.cn/cap/c/test/getAllUser', setAgenment,structureHtml);
    /* 绑定事件方法 */
    var indexMainEvent = {
        init: function(){
            this.delCurStrip();
            this.addInformation();
            this.updateInformation();
            this.queryTell();
        },
        queryTell: function(){
            $('#dataMains').on('click','#queryInformation',function(){
                var inpt = $('.inpt');
                if($.trim(inpt.eq(0).val()) == ''){
                    JZFQpublicRun.addError(0, '用户ID不能为空', inpt);
                    return false;
                }else if($.trim(inpt.eq(1).val()) == ''){
                    JZFQpublicRun.addError(1, '请选择开始时间', inpt);
                    return false;
                }else if($.trim(inpt.eq(2).val()) == ''){
                    JZFQpublicRun.addError(2, '请选择结束时间', inpt);
                    return false;
                }else{
                    inpt.removeClass('add-error');
                    JZFQpublicRun.nodataTips('客官，查询中请稍候！');
                }
            });
            $('#dataMains').on('click','#resetInpt',function(){
                $('.inpt').removeClass('add-error').val('');
            });
        },
        addInformation: function(){
            var _this = this;
            $('#dataMains').on('click','#addInformation',function(){
                var $this = $(this);
                $('body').newJZFQDialog({
                    width: 800,
                    title: '添加信息',
                    html: '<ul class="pop-cont-list clearfix"><li class="pcl-wa">姓名：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写姓名" /></li><li class="pcl-wa">地址：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写地址" /></li><li class="pcl-wa">手机：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写手机号" /></li><li class="pcl-wa">主营业务：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写主营业务" /></li></ul>',
                    confirmBtn: '增加',
                    cancelBtn:'取消',
                    confirmBtnRun: function(){
                        var getInpts = $('.pop-cont-list .inpt');
                        var regPhone = /^1[34578]\d{9}$/;
                        if($.trim(getInpts.eq(0).val()) == ''){
                            JZFQpublicRun.addError(0, '请填写姓名', getInpts);
                            return false;
                        }else if($.trim(getInpts.eq(1).val()) == ''){
                            JZFQpublicRun.addError(1, '请填写地址', getInpts);
                            return false;
                        }else if($.trim(getInpts.eq(2).val()) == ''){
                            JZFQpublicRun.addError(2, '请填写电话', getInpts);
                            return false;
                        }else if(!regPhone.test($.trim(getInpts.eq(2).val()))){
                            JZFQpublicRun.addError(2, '电话格式不正确', getInpts);
                            return false;
                        }else if($.trim(getInpts.eq(3).val()) == ''){
                            JZFQpublicRun.addError(3, '请填写主营业务', getInpts);
                            return false;
                        }else{
                            JZFQpublicRun.popCallbackClose();
                            JZFQpublicRun.nodataTips('添加成功！');
                            return;
                        }
                    },
                    cancelBtnRun: function(){
                        return;
                    },
                    callback: function(){
                        return true;
                    }
                });
            });
        },
        updateInformation: function(){
            var _this = this;
            $('#dataMains').on('click','.updata-btna',function(){
                var $this = $(this);
                $('body').newJZFQDialog({
                    width: 800,
                    title: '修改信息',
                    html: '<ul class="pop-cont-list clearfix"><li class="pcl-wa">姓名：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写姓名" /></li><li class="pcl-wa">地址：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写地址" /></li><li class="pcl-wa">手机：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写手机号" /></li><li class="pcl-wa">主营业务：</li><li class="pcl-wb"><input type="text" class="inpt pcl-maxw" placeholder="请添写主营业务" /></li></ul>',
                    confirmBtn: '确认',
                    cancelBtn:'取消',
                    confirmBtnRun: function(){
                        var getInpts = $('.pop-cont-list .inpt');
                        var regPhone = /^1[34578]\d{9}$/;
                        if($.trim(getInpts.eq(0).val()) == ''){
                            JZFQpublicRun.addError(0, '请填写姓名', getInpts);
                            return false;
                        }else if($.trim(getInpts.eq(1).val()) == ''){
                            JZFQpublicRun.addError(1, '请填写地址', getInpts);
                            return false;
                        }else if($.trim(getInpts.eq(2).val()) == ''){
                            JZFQpublicRun.addError(2, '请填写电话', getInpts);
                            return false;
                        }else if(!regPhone.test($.trim(getInpts.eq(2).val()))){
                            JZFQpublicRun.addError(2, '电话格式不正确', getInpts);
                            return false;
                        }else if($.trim(getInpts.eq(3).val()) == ''){
                            JZFQpublicRun.addError(3, '请填写主营业务', getInpts);
                            return false;
                        }else{
                            JZFQpublicRun.popCallbackClose();
                            JZFQpublicRun.nodataTips('修改成功！');
                            return;
                        }
                    },
                    cancelBtnRun: function(){
                        return;
                    },
                    callback: function(){
                        return true;
                    }
                });
            });
        },
        delCurStrip: function(){
            var _this = this;
            $('#dataMains').on('click','.del-btna',function(){
                var $this = $(this);
                $('body').newJZFQDialog({
                    width: 900,
                    title: '系统提示',
                    html: '<p style="text-align:center;">确认要删除当条信息吗？</p>',
                    confirmBtn: '确认',
                    confirmBtnRun: function(){
                        $this.parents('tr').remove();
                        JZFQpublicRun.popCallbackClose();
                        return;
                    },
                    cancelBtnRun: function(){
                        return;
                    },
                    callback: function(){
                        return true;
                    }
                });
            });
        }
    }
    indexMainEvent.init();
});