    $(function(){
    	var height = $(window).height();
        $('#table').bootstrapTable({
            url: "pickStandard/pickStandardpageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
            method: 'post',
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页
            dataType: "json",
            direction: 'asc',
            contentType:"application/x-www-form-urlencoded",
            pageNumber: 1,      //初始化加载第一页，默认第一页
            pageSize: 5,      //每页的记录行数
            pageList: [5, 10, 25, 50, 100],  //可供选择的每页的行数
            //queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页
            showColumns: true,  //显示下拉框勾选要显示的列
            showRefresh: true,     //是否显示刷新按钮
            clickToSelect: true,    //是否启用点击选中行
            buttonsAlign:"right",  //按钮位置
            showToggle:true,       //是否显示详细视图和列表视图的切换按钮
            height: document.body.clientHeight - 150, //自定义表格的高度
            width: document.body.clientWidth,
            sortName : "pickStandardId",
            locale: 'zh-CN',//中文支持,
            queryParamsType:'',
            singleSelect:true,
            queryParams: function queryParams(params) {
                var param = {
                    pageNumber: params.pageNumber,
                    pageSize: params.pageSize
                };
                return param;
            },

            columns: [{
                title: "全选", field: "select", checkbox: true, width: 20,align: "center",valign: "middle"//垂直
            }, {
                field: 'pickStandardId',
                title: '取派标准编号',
                align: "center",
                hidden:false,
            }, {
                field: 'pickStandardName',
                title: '取派标准名',
                align: "center",
            }, {
                field: 'minWeight',
                title: '最小重量',
                align: "center",
            }, {
                field: 'maxWeight',
                title: '最大重量',
                align: "center",
            }, {
                field: 'useable',
                title: '是否可用',
                align: "center",
                formatter:function(value, row, index){
                	if(value=="N" || value=="n"){
                		var judge="<font color='red'>否</font>";
                		
                	}else if(value="Y" || value=="y"){
                		var judge="<font color='green'>是</font>";
                	}
                	return judge;
                }
                
                
            }, {
                field: 'description',
                title: '描述',
                align: "center",
            }, {
				field:'operation',
				title:'操作',
                formatter: function (value, row, index) {
                    var edit =
                        '<button type="button" style="margin-right: 8px;" class="btn btn-info" onclick="javascript:showUpdateModal(\'' +
                        row.pickStandardId + '\',\'' + row.pickStandardName + '\',\'' + row.minWeight + '\',\'' + row.maxWeight + '\',\'' + row.useable +
                        '\',\'' +
                        row.description +
                        '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
                    var del = '<button type="button" style="margin-right: 8px;" class="btn btn-danger" onclick="javascript:dels(\'' +
                        row.pickStandardId +
                        '\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';
                    return edit + del;
                },
                align: "center"
            }],
            paginationPreText: "上一页",
            paginationNextText: "下一页",
        });

        $('#btn_add').on("click", function () {
            $("#myModal").modal().on("shown.bs.modal", function () {
            }).on('hidden.bs.modal', function () {
            });
        });
        
        $("#btn_search_b").click(function(){
        	 var obj = {
	    			url:"pickStandard/pickStandardpageQuery.action",
	    			queryParams:function queryParams(params){
	    				return{
	    					pageSize:params.pageSize,
	    					pageNumber:params.pageNumber,
	    					useable : $("#useable").val(), 
	    					pickStandardName : $("#pickStandardName").val(),
	    					minWeight : $("#minWeights").val(),
	    					maxWeight : $("#maxWeights").val(),
	    					direction: 'asc' 
	    				};
	    		    },
	    		    sidePagination: "server",
	    		}; 
			$('#table').bootstrapTable('refreshOptions', obj);
        });
        $("#addForm").bootstrapValidator({
            message: '输入值不合法',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
          		 pickStandardName: {
	        		message: '取派标准名不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '取派标准名必须输入'
	                    }
	                }
	            },
	            minWeight: {
	        		message: '最小重量不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '最小重量必须输入'
	                    },
	                    regexp: {
                            regexp:  /^[0-9]+(.[0-9]{1,2})?$/,
                            message: '只能是数字'
                        },
                        stringLength: {/*长度提示*/
                            min: 1,
                            max: 12,
                            message: '长度必须在1到12之间'
                        }
	                }
	            },
	           maxWeight: {
	        		message: '最大重量不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '最大重量必须输入'
	                    },regexp: {
                            regexp:  /^[0-9]+(.[0-9]{1,2})?$/,
                            message: '只能是数字'
                        },
                        stringLength: {/*长度提示*/
                            min: 1,
                            max: 12,
                            message: '长度必须在1到12之间'
                        }
	                }
	            },useable: {
        		message: '未输入是否可用',
                validators: {
                	notEmpty: {//检测非空,radio也可用
                        message: '是否可用必须输入'
                    },regexp: {//检测长度
                   	 regexp: /^[y|n|Y|N]$/,
                  	 message: '请输入n-N或y-Y'
                   }
                }
            	}
            }
        });
        //添加数据
        $("#addRecord").click(function(){
        	$("#addForm").data('bootstrapValidator').validate();//提交验证
            if ($("#addForm").data('bootstrapValidator').isValid()) {
            var data = $("#addForm").serializeArray();
            $.ajax({
                url: "pickStandard/addDocument.action",
                dataType:"json",
                type: "post",
                data: data,
                success: function(data){
                	console.log("123");
                    if (data) {
                        $('#addModal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                        $('#addForm')[0].reset();
                        layer.msg('添加成功', {time: 3000, icon:6});
                        $("#addForm").data('bootstrapValidator').resetForm();
                        return;
                    }
                        //捕获页
                        layer.msg('添加失败', {time: 3000, icon:6});
                },
                error: function(data){console.log("我出错了");}
            });
            }
        });

        
        $("#updateForm").bootstrapValidator({
            message: '输入值不合法',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
          		 pickStandardName: {
	        		message: '取派标准名不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '取派标准名必须输入'
	                    }
	                }
	            },
	            minWeight: {
	        		message: '最小重量不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '最小重量必须输入'
	                    },
	                    regexp: {
                            regexp:  /^[0-9]+(.[0-9]{1,2})?$/,
                            message: '只能是数字'
                        },
                        stringLength: {/*长度提示*/
                            min: 1,
                            max: 12,
                            message: '长度必须在1到12之间'
                        }
	                }
	            },
	           maxWeight: {
	        		message: '最大重量不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '最大重量必须输入'
	                    },regexp: {
                            regexp:  /^[0-9]+(.[0-9]{1,2})?$/,
                            message: '只能是数字'
                        },
                        stringLength: {/*长度提示*/
                            min: 1,
                            max: 12,
                            message: '长度必须在1到12之间'
                        }
	                }
	            },useable: {
        		message: '未选择是否可用',
                validators: {
                	notEmpty: {//检测非空,radio也可用
                        message: '是否可用必须输入'
                    },regexp: {//检测长度
                   	 regexp: /^[y|n|Y|N]$/,
                  	 message: '请输入n-N或y-Y'
                   }
                }
            	}
            }
        });
        //更新数据
        $("#updateRecord").click(function(){
        	$("#updateForm").data('bootstrapValidator').validate();//提交验证
            if ($("#updateForm").data('bootstrapValidator').isValid()) {
            var data = $("#updateForm").serialize();
	            $.ajax({
	                url: "pickStandard/updateDocument.action",
	                dataType: "json",
	                type: "post",
	                data: data,
	                success: function (req){
	                    if (req) {
	                        $('#updateModal').modal('hide');
	                        $('#table').bootstrapTable('refresh');
	                        layer.msg('更新成功', {time: 3000, icon:6});
	                        $("#updateForm").data('bootstrapValidator').resetForm();
	                    } else {
	                        alert("更新失败");
	                    }
	                },
	                error: function(req){}
	            });
            }
        });
    });

    
    //显示更新模态框
    function showUpdateModal(pickStandardId, pickStandardName, minWeight, maxWeight, useable, description){
        $("#pickStandardId").val(pickStandardId);
        $("#pickStandardName2").val(pickStandardName);
        $("#minWeight").val(minWeight);
        $("#maxWeight").val(maxWeight);
        $("#useable2").val(useable);
        $("#description").val(description);
        $('#updateModal').modal('show');
    }

    //获取选择ID
    function getIdSelections() {
        return $.map($('#table').bootstrapTable('getSelections'), function(row) {
            return row.pickStandardId
        });
    }


    //删除记录
    function dels(ids) {
        if(confirm("确定删除选中记录吗?")){
        	console.log("我11111");
            if(undefined == ids){
                ids = getIdSelections();
                //捕获页
                layer.msg('请选择一行及以上的数据', {time: 3000, icon:6});
            }

            $.ajax({
                url : "pickStandard/deleteDocument.action?ids=" + ids,
                type : "post",
                traditional: true, //traditional 为true阻止深度序列化
                dataType : "json",
                success : function(req) {
                	console.log("123");
                    if (req) {
                        $('#table').bootstrapTable('refresh');
                        layer.msg('删除成功', {time: 3000, icon:6});
                        return;
                    }
                    layer.msg('删除失败', {time: 3000, icon:6});

                },
                error : function(req) {console.log("我出错了"+req);}
            });
        }
    }