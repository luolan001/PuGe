 $(function(){
    	var height = $(window).height();
        $('#table').bootstrapTable({
            url: "areapageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
            method: 'get',
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页
            dataType: "json", // 数据类型
            direction: 'asc', // 用法说明
            contentType:"application/x-www-form-urlencoded", // 内容/目录类型
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
            height: document.body.clientHeight - 200, //自定义表格的高度
            width: document.body.clientWidth, //自定义表格的宽度
            sortName : "areaId", // 主键Id
            locale: 'zh-CN',//中文支持,
            queryParamsType:'', // 参数类型
            singleSelect:false, 
            queryParams: function queryParams(params) {
                var param = {
                    pageNumber: params.pageNumber,
                    pageSize: params.pageSize
                };
                return param;
            },

            columns: [{
                title: "全选", field: "select", radio: true, width: 20,align: "center",valign: "middle"//垂直
            }, {
                field: 'province',
                title: '省份',
                align: "center",
            }, {
            	field: 'city',
                title: '市(区)',
                align: "center",
                
            }, {
                field: 'county',
                title: '县',
                align: "center",
            }, {
            	field: 'postCode',
                title: '邮政编码',
                align: "center",
            }, {
            	field: 'simpleCode',
                title: '简码',
                align: "center",
            }, {
            	field: 'cityCode',
                title: '城市简码',
                align: "center",
            }, {
				field : 'useable',
				title : '是否可操作',
				align: "center",
				formatter:function(value,row,index){
					if(row.useable == '1'){
						return '是';
					}else{
						return '否';
					}
				}
			}, {
                field: "operation",
                title: "操作",
                formatter: function (value, row, index) {
                    var edit =
                        '<button type="button" style="margin-right: 8px;" class="btn btn-info" onclick="javascript:showUpdateModal(\'' +
                        row.areaId + '\',\'' + row.province + '\',\'' + row.city + '\',\'' + row.county +
                        '\',\'' +
                        row.postCode +'\',\''+row.simpleCode+'\',\''+row.cityCode+
                        '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
                     var del = '<button type="button" style="margin-right: 8px;" class="btn btn-danger" onclick="javascript:dels(\'' +
                        row.areaId +'\',\''+row.useable+
                        '\')"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>禁用</button>'; 
                    return edit+del;
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
	    			url:"areapageQuery.action",
	    			queryParams:function queryParams(params){
	    				return{
	    					pageSize:params.pageSize,
	    					pageNumber:params.pageNumber,
	    					province : $("#provinces").val(), 
	    					city : $("#citys").val(),
	    					county : $("#countys").val(),
	    					direction: 'asc' 
	    				};
	    		    },
	    		    sidePagination: "server",
	    		}; 
			$('#table').bootstrapTable('refreshOptions', obj);
        });
        
        //添加数据
        $("#addRecord").click(function(){
        	console.log("123456");
            var data = $("#addForm").serializeArray();
            $.ajax({
                url: "addArea.action",
                dataType:"json",
                type: "get",
                data: data,
                success: function(data){
                	console.log("123");
                    if (data) {
                        $('#addModal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                        layer.msg('添加成功', {time: 3000, icon:6});
                        return;
                    }
                        //捕获页
                        layer.msg('添加失败', {time: 3000, icon:6});
                },
                error: function(data){console.log("我出错了");}
            });
        });

        //更新数据
        $("#updateRecord").click(function(){
            var data = $("#updateForm").serialize();
            $.ajax({
                url: "updateArea.action",
                dataType: "json",
                type: "get",
                data: data,
                success: function (req){
                    if (req) {
                        $('#updateModal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                        layer.msg('更新成功', {time: 3000, icon:6});
                    } else {
                    	layer.msg('更新失败', {time: 3000, icon:6});
                    }
                },
                error: function(req){}
            });
        });
    });
    

    //显示更新模态框
    function showUpdateModal(areaId, province, city, county, postCode,simpleCode,cityCode){
        $("#areaId").val(areaId);
        $("#province").val(province);
        $("#city").val(city);
        $("#county").val(county);
        $("#postCode").val(postCode);
        $("#simpleCode").val(simpleCode);
        $("#cityCode").val(cityCode);
        $('#updateModal').modal('show');
    }

    //获取选择ID
    function getIdSelections() {
        return $.map($('#table').bootstrapTable('getSelections'), function(row) {
            return row.areaId
            });
    }

 
    function dels(ids) {
    	var select = $('#table').bootstrapTable('getSelections');
    	var useable = [];
    	var areaId = [];
    	for(var i=0;i<select.length;i++){
    		areaId[i]=select[i]['areaId'];
    		useable[i]=select[i]['useable'];
    	}
    	 if(useable[0]==='0'){
    		toastr.warning("该区域不可操作!");
    	}else{
    		swal({
    				title:"操作提示",//弹出框的title
    				text: "确定禁用吗？",  //弹出框里面的提示文本  
					type: "warning",    //弹出框类型  
					showCancelButton: true, //是否显示取消按钮  
					confirmButtonColor: "#DD6B55",//确定按钮颜色  
					cancelButtonText: "关闭",//取消按钮文本  
					confirmButtonText: "是的，确定！",//确定按钮上面的文档  
					closeOnConfirm: true
    		},function(){
    			var arrs = [];
    			for (var i=0; i<select.length;i++){
    				arrs[i] = select[i]['areaId'];
    			}
    			$('#table').bootstrapTable('remove',{
    				field:'areaId',
    				values:arrs
    			});
    			$.ajax({
    				type:"get",
    				url:"/PUGE/deleteArea.action",
    				data:{areaIds:arrs},
    				success:function(result){
    					if(result == "success"){
    						toastr.success('禁用成功！');
    					}else{
    						toastr.error('禁用失败');
    					}
    					$('#table').bootstrapTable('refresh');
    				}
				});
			});
		}
    } 
		