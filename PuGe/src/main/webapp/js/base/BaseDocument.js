   $(function(){
    	//基础档案表显示
	   var height = $(window).height();
        $('#table').bootstrapTable({
            url: "baseDocument/baseDocumentpageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
            method: 'post',
            //toolbar: '#toolbar',    //工具按钮用哪个容器
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
            clickToSelect: true,    //是否启用点击选中行
            buttonsAlign:"right",  //按钮位置
            height: document.body.clientHeight - 399, //自定义表格的高度
            width: document.body.clientWidth,
            sortName : "baseDocumentId",
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
                title: "全选", field: "select", radio: true, width: 20,align: "center",valign: "middle"//垂直
            },{
                field: 'baseDocumentNo',
                title: '基础档案编号',
                align: "center",
            }, {
                field: 'baseDocumentName',
                title: '基础档案名',
                align: "center",
            }, {
                field: 'scale',
                title: '是否分级',
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
                field: "operation",
                title: "操作",
                formatter: function (value, row, index) {
                    var edits =
                        '<button type="button" style="margin-right: 8px;" class="btn btn-info btn-xs" onclick="javascript:showUpdateModal(\'' +
                        row.baseDocumentId + '\',\'' + row.baseDocumentNo + '\',\'' + row.baseDocumentName + '\',\'' + row.scale +
                        '\',\'' +
                        row.description +
                        '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
                    var del = '<button type="button" style="margin-right: 8px;" class="btn btn-danger btn-xs" onclick="javascript:dels(\'' +
                        row.baseDocumentId +
                        '\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';
                    var look= '<button type="button" style="margin-right: 8px;" class="btn btn-success btn-xs" onclick="javascript:look(\'' +
                    row.baseDocumentNo +
                    '\')"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>查看</button>';
                    return edits + del + look;
                },
                align: "center"
            }],
            paginationPreText: "上一页",
            paginationNextText: "下一页",
        });
        //辅助档案表显示
    	var height = $(window).height();
        $('#tableTwo').bootstrapTable({
            url: "assistantDocument/assistantDocumentpageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
            method: 'post',
            toolbar: '#toolbartwo',    //工具按钮用哪个容器
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
            clickToSelect: true,    //是否启用点击选中行
            buttonsAlign:"right",  //按钮位置
            height: document.body.clientHeight - 379, //自定义表格的高度
            width: document.body.clientWidth,
            sortName : "assistantDocumentId",
            locale: 'zh-CN',//中文支持,
            queryParamsType:'',
            singleSelect:true,
            queryParams: function queryParams(params) {
                var param = {
                    pageNumber: params.pageNumber,
                    pageSize: params.pageSize,
                };
                return param;
            },

            columns: [{
                title: "全选", field: "select", radio: true, width: 20,align: "center",valign: "middle"//垂直
            },{
                field: 'assistantDocumentNo',
                title: '辅助档案编号',
                align: "center",
            }, {
                field: 'assistantDocumentName',
                title: '辅助档案名',
                align: "center",
            }, {
                field: 'baseDocumentNo',
                title: '基础档案编号',
                align: "center",
            }, {
                field: 'shortName',
                title: '助记码',
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
                field: "operation",
                title: "操作",
                formatter: function (value, row, index) {
                    var edit =
                        '<button type="button" style="margin-right: 8px;" class="btn btn-info btn-xs" onclick="javascript:showUpdateModalTwo(\'' +
                        row.assistantDocumentId + '\',\'' + row.assistantDocumentNo + '\',\'' + row.assistantDocumentName +
                        '\',\'' +row.baseDocumentNo +'\',\'' +row.shortName+'\',\'' +row.description+
                        '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
                    var deles = '<button type="button" style="margin-right: 8px;" class="btn btn-danger btn-xs" onclick="javascript:deles(\'' +
                        row.assistantDocumentId +
                        '\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';
                    var disable= '<button type="button" style="margin-right: 8px;" class="btn btn-warning btn-xs" onclick="javascript:disable(\'' +
                    row.assistantDocumentId +
                    '\')"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>禁用</button>';
                    var useable= '<button type="button" style="margin-right: 8px;" class="btn btn-success btn-xs" onclick="javascript:useable(\'' +
                    row.assistantDocumentId +
                    '\')"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>启用</button>';
                    return edit + deles + disable +useable;
                },
                align: "center"
            }],
            paginationPreText: "上一页",
            paginationNextText: "下一页",
        });
        
		//给基础档案表添加验证
        $("#addForm").bootstrapValidator({
            message: '输入值不合法',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	baseDocumentNo: {
            		message: '基础档案编号不合法',
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '基础档案编号必须输入'
                        },
                        regexp: {//检测长度
	                    	 regexp: /^[a-zA-Z]\w{5,17}$/,
                            message: '所输入的字符不符要求'
	                    }
                    }
                },
            baseDocumentName: {
	        		message: '基础档案名不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '基础档案名必须输入'
	                    }
	                }
	            },
	            scale: {
        		message: '未选择分级',
                validators: {
                	regexp: {//检测长度
                   	 regexp: /^[a-zA-Z]$/,
                       message: '请选择是否分级'
                   }
                }
            }
            }
        });
        $("#addRecord").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        	$("#addForm").data('bootstrapValidator').validate();//提交验证
            if ($("#addForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            	var data = $("#addForm").serializeArray();
                $.ajax({
                    url: "baseDocument/addDocument.action",
                    dataType:"json",
                    type: "post",
                    data: data,
                    success: function(data){
                        if (data) {
                            $('#table').bootstrapTable('refresh');
                            layer.msg('添加成功', {time: 3000, icon:6});
                            $('#txt_baseDocumentNo')[0].value = ""; 
                            $('#txt_baseDocumentName')[0].value = "";
                            $('#txt_scale')[0].value = "";
                            $('#txt_description')[0].value = "";
                            $("#addForm").data('bootstrapValidator').resetForm();
                            return;
                        }
                            //捕获页
                            layer.msg('添加失败', {time: 3000, icon:6});
                    },
                    error: function(data){ layer.msg('基础档案编号不能重复', {time: 3000, icon:6});}
                });
            }else{
            	 layer.msg('失败：信息未完善请重新填写！', {time: 3000, icon:6});
            }
        });
        
      //给辅助档案表添加验证
        $("#addFormTwo").bootstrapValidator({
            message: '输入值不合法',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	baseDocumentNo: {
            		message: '基础档案编号不合法',
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '基础档案编号必须输入'
                        },
                        regexp: {//检测长度
	                    	 regexp: /^[a-zA-Z]\w{5,17}$/,
                            message: '所输入的字符不符要求'
	                    }
                    }
                },
                assistantDocumentNo: {
            		message: '辅助档案编号不合法',
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '辅助档案编号必须输入'
                        },
                        regexp: {//检测长度
	                    	 regexp: /^[a-zA-Z]\w{5,17}$/,
                            message: '所输入的字符不符要求'
	                    }
                    }
                },
                assistantDocumentName: {
	        		message: '辅助档案名不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '辅助档案名必须输入'
	                    }
	                }
	            },
	            shortName: {
        		message: '助记码不合法',
                validators: {
                	notEmpty: {//检测非空,radio也可用
                        message: '辅助档案名必须输入'
                    },
                	regexp: {//检测长度
                   	 regexp: /^[A-Za-z]+$/,
                       message: '助记码全由字母组成'
                   }
                }
            }
            }
        });
        $("#addRecordTwo").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        	$("#addFormTwo").data('bootstrapValidator').validate();//提交验证
            if ($("#addFormTwo").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            	 var data = $("#addFormTwo").serializeArray();
                 $.ajax({
                     url: "assistantDocument/assistantDocumentAdd.action",
                     dataType:"json",
                     type: "post",
                     data: data,
                     success: function(req){
                     	if (req == false) {
                             $('#addModal').modal('hide');
                             $('#addFormTwo')[0].reset();
                             layer.msg('您添加的基础档案编号未找到', {time: 3000, icon:6});
                             return;
                         }
                         if (req) {
                             $('#addModal').modal('hide');
                             $('#tableTwo').bootstrapTable('refresh');
                             $('#addFormTwo')[0].reset();
                             layer.msg('添加成功', {time: 3000, icon:6});
                             $("#addFormTwo").data('bootstrapValidator').resetForm();
                             return;
                         }
                             //捕获页
                             layer.msg('添加失败', {time: 3000, icon:6});
                     },
                    error: function(data){ layer.msg('有唯一字段重复了！', {time: 3000, icon:6});}
                });
            }else{
            	 layer.msg('失败：信息未完善请重新填写！', {time: 3000, icon:6});
            }
        });
        
        
        
        
        //修改验证
        $("#updateFormTwo").bootstrapValidator({
              message: '输入值不合法',//好像从来没出现过
              feedbackIcons: {//根据验证结果显示的各种图标
                  valid: 'glyphicon glyphicon-ok',
                  invalid: 'glyphicon glyphicon-remove',
                  validating: 'glyphicon glyphicon-refresh'
              },
              fields: {
            	  assistantDocumentNo: {
              		message: '辅助档案编号不合法',
                      validators: {
                          notEmpty: {//检测非空,radio也可用
                              message: '辅助档案编号必须输入'
                          },
                          regexp: {//检测长度
  	                    	 regexp: /^[a-zA-Z]\w{5,17}$/,
                              message: '所输入的字符不符要求'
  	                    }
                      }
                  },
                  assistantDocumentName: {
  	        		message: '辅助档案名不合法',
  	                validators: {
  	                    notEmpty: {//检测非空,radio也可用
  	                        message: '辅助档案名必须输入'
  	                    }
  	                }
  	            },
  	          baseDocumentNo: {
          		message: '未选择基础档案编号',
                  validators: {
                	  notEmpty: {//检测非空,radio也可用
	                        message: '基础档案编号必须输入'
	                    }
                  }
              },
              shortName: {
          		message: '助记码不合法',
                  validators: {
                  	notEmpty: {//检测非空,radio也可用
                          message: '辅助档案名必须输入'
                      },
                  	regexp: {//检测长度
                     	 regexp: /^[A-Za-z]+$/,
                         message: '助记码全由字母组成'
                     }
                  }
              }
              }
          });
          $("#updateRecordTwo").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
          	$("#updateFormTwo").data('bootstrapValidator').validate();//提交验证
              if ($("#updateFormTwo").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
              	 var data = $("#updateFormTwo").serialize();
                   $.ajax({
                       url: "assistantDocument/assistantDocumentUpdate.action",
                       dataType: "json",
                       type: "post",
                       data: data,
                       success: function (req){
                           if (req) {
                               $('#updateModalTwo').modal('hide');
                               $('#tableTwo').bootstrapTable('refresh');
                               $("#updateFormTwo").data('bootstrapValidator').resetForm();
                           } else {
                               alert("更新失败");
                           }
                       },
                       error: function(data){ layer.msg('基础档案编号不能重复', {time: 3000, icon:6});}
                   });
              }else{
              	 layer.msg('失败：信息未完善请重新填写！', {time: 3000, icon:6});
              }
          });
        
      //修改验证
      $("#updateForm").bootstrapValidator({
            message: '输入值不合法',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	baseDocumentNo: {
            		message: '基础档案编号不合法',
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '基础档案编号必须输入'
                        },
                        regexp: {//检测长度
	                    	 regexp: /^[a-zA-Z]\w{5,17}$/,
                            message: '所输入的字符不符要求'
	                    }
                    }
                },
            baseDocumentName: {
	        		message: '基础档案名不合法',
	                validators: {
	                    notEmpty: {//检测非空,radio也可用
	                        message: '基础档案名必须输入'
	                    }
	                }
	            },
	            scale: {
        		message: '未选择分级',
                validators: {
                	regexp: {//检测长度
                   	 regexp: /^[a-zA-Z]$/,
                       message: '请选择是否分级'
                   }
                }
            }
            }
        });
        $("#updateRecord").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        	$("#updateForm").data('bootstrapValidator').validate();//提交验证
            if ($("#updateForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            	 var data = $("#updateForm").serialize();
                 $.ajax({
                     url: "baseDocument/updateDocument.action",
                     dataType: "json",
                     type: "post",
                     data: data,
                     success: function (req){
                         if (req) {
                             $('#updateModal').modal('hide');
                             $('#table').bootstrapTable('refresh');
                             $("#updateForm").data('bootstrapValidator').resetForm();
                         } else {
                             alert("更新失败");
                         }
                     },
                     error: function(data){ layer.msg('基础档案编号不能重复', {time: 3000, icon:6});}
                 });
            }else{
            	 layer.msg('失败：信息未完善请重新填写！', {time: 3000, icon:6});
            }
        });
        
        //添加基础档案表模态框打开
        $('#btn_add').on("click", function(){
            $("#myModal").modal().on("show.bs.modal", function(){}).on('hidden.bs.modal', function(){
            	
            });
        });
        
        //添加辅助档案表模态框打开
        $('#btn_addTwo').on("click", function(){
            $("#myModalTwo").modal().on("show.bs.modal", function(){}).on('hidden.bs.modal', function(){
            	
            });
        });
        //基础档案表条件查询
        $("#btn_search_b").click(function(){
        	 var obj = {
	    			url:"baseDocument/baseDocumentpageQuery.action",
	    			queryParams:function queryParams(params){
	    				return{
	    					pageSize:params.pageSize,
	    					pageNumber:params.pageNumber,
	    					scale : $("#scale2").val(), 
	    					baseDocumentName : $("#baseDocumentName2").val(),
	    					direction: 'asc' 
	    				};
	    		    },
	    		    sidePagination: "server",
	    		}; 
			$('#table').bootstrapTable('refreshOptions', obj);
        });
        
      //辅助档案表条件查询
        $("#btn_search_bTwo").click(function(){
       	 var obj = {
       			url:"assistantDocument/assistantDocumentpageQuery.action",
       			queryParams:function queryParams(params){
       				return{
       					pageSize:params.pageSize,
       					pageNumber:params.pageNumber,
       					useable : $("#form_useable").val(), 
       					assistantDocumentName : $("#form_assistantDocumentName").val(),
       					baseDocumentNo : $("#form_baseDocumentNo").val(),
       					direction: 'asc' 
       				};
       		    },
       		    sidePagination: "server",
       		}; 
     		$('#tableTwo').bootstrapTable('refreshOptions', obj);
       });
    });
   
    
    //显示更新模态框
    function showUpdateModal(baseDocumentId, baseDocumentNo, baseDocumentName, scale, description){
        $("#baseDocumentId").val(baseDocumentId);
        $("#baseDocumentNo").val(baseDocumentNo);
        $("#baseDocumentName").val(baseDocumentName);
        $("#scale").val(scale);
        $("#description").val(description);
        $('#updateModal').modal('show');
    }
    //显示更新模态框
    function showUpdateModalTwo(assistantDocumentId, assistantDocumentNo, assistantDocumentName, baseDocumentNos, shortName,description ,useable ,description){
        $("#assistantDocumentId").val(assistantDocumentId);
        $("#assistantDocumentNo").val(assistantDocumentNo);
        $("#assistantDocumentName").val(assistantDocumentName);
        $("#baseDocumentNos").val(baseDocumentNos);
        $("#shortName").val(shortName);
        $("#description").val(description);
        $('#updateModalTwo').modal('show');
    }
    //获取选择ID
    function getIdSelections() {
        return $.map($('#table').bootstrapTable('getSelections'), function(row) {
            return row.baseDocumentId
        });
    }
    //获取选择ID
    function getIdSelectiones() {
        return $.map($('#tableTwo').bootstrapTable('getSelections'), function(row) {
            return row.baseDocumentIds
        });
    }
    
    
    //删除记录
    function dels(ids) {
        if(confirm("确定删除选中记录吗?")){
            if(undefined == ids){
                ids = getIdSelections();
                //捕获页
                layer.msg('请选择一行及以上的数据', {time: 3000, icon:6});
            }

            $.ajax({
                url : "baseDocument/deleteDocument.action?ids=" + ids,
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
    //删除记录
    function deles(ids) {
        if(confirm("确定删除选中记录吗?")){
            if(undefined == ids){
                ids = getIdSelectiones();
                //捕获页
                layer.msg('请选择一行及以上的数据', {time: 3000, icon:6});
            }

            $.ajax({
                url : "assistantDocument/assistantDocumentdelete.action?ids=" + ids,
                type : "post",
                traditional: true, //traditional 为true阻止深度序列化
                dataType : "json",
                success : function(req) {
                    if (req) {
                        $('#tableTwo').bootstrapTable('refresh');
                        layer.msg('删除成功', {time: 3000, icon:6});
                        return;
                    }
                    layer.msg('删除失败', {time: 3000, icon:6});

                },
                error : function(req) {console.log("我出错了"+req);}
            });
        }
    }
    //基础档案表查看按钮
    function look(baseNo){
    	var obj = {
       			url:"assistantDocument/assistantDocumentpageQuery.action",
       			queryParams:function queryParams(params){
       				return{
       					pageSize:params.pageSize,
       					pageNumber:params.pageNumber,
       					baseNo :baseNo,
       					direction: 'asc' 
       				};
       		    },
       		    sidePagination: "server",
       		}; 
     		$('#tableTwo').bootstrapTable('refreshOptions', obj);
   }
    //辅助档案表禁用
    function disable(assId){
    	 if(confirm("确定禁用选中记录吗?")){
             if(undefined == assId){
            	 assId = getIdSelectiones();
                 //捕获页
                 layer.msg('请选择一行及以上的数据', {time: 3000, icon:6});
             }

    	 $.ajax({
       			url:"assistantDocument/assistantDocumentUpdateDisable.action?assId="+assId,
       			type:"post",
       			traditional: true, //traditional 为true阻止深度序列化
       			dataType : "json",
       			success : function(req) {
                    if (req) {
                        $('#tableTwo').bootstrapTable('refresh');
                        layer.msg('禁用成功', {time: 3000, icon:6});
                        return;
                    }
                    layer.msg('禁用失败', {time: 3000, icon:6});

                },
                error : function(req) {console.log("我出错了"+req);}
    	 	});	
    	 }
    }
    //辅助档案表启用
    function useable(useassId){
    	 if(confirm("确定启用选中记录吗?")){
             if(undefined == useassId){
            	 useassId = getIdSelectiones();
                 //捕获页
                 layer.msg('请选择一行及以上的数据', {time: 3000, icon:6});
             }

    	 $.ajax({
    			url:"assistantDocument/assistantDocumentUpdateUseable.action?useassId="+useassId,
    			type:"post",
    			traditional: true, //traditional 为true阻止深度序列化
    			dataType : "json",
    			success : function(req) {
                 if (req) {
                     $('#tableTwo').bootstrapTable('refresh');
                     layer.msg('启用成功', {time: 3000, icon:6});
                     return;
                 }
                 layer.msg('启用失败', {time: 3000, icon:6});

             },
             error : function(req) {console.log("我出错了"+req);}
    	 	});	
    	 }
    }
   