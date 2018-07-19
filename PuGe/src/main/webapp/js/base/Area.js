 $(function(){
    	var height = $(window).height();
        $('#table').bootstrapTable({
            url: "Area/areapageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
            method: 'get',
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页
            dataType: "json", // 数据类型
            direction: 'asc', // 用法说明
            contentType:"application/x-www-form-urlencoded", // 内容/目录类型
            pageNumber: 1,      //初始化加载第一页，默认第一页
            pageSize: 10,      //每页的记录行数
            pageList: [10, 20, 30, 50, 100],  //可供选择的每页的行数
            //queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页
            showColumns: true,  //显示下拉框勾选要显示的列
            showRefresh: true,     //是否显示刷新按钮
            clickToSelect: true,    //是否启用点击选中行
            buttonsAlign:"right",  //按钮位置
            showToggle:true,       //是否显示详细视图和列表视图的切换按钮
            height: document.body.clientHeight - 100, //自定义表格的高度
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
					console.log(value);
					if(value){
						return "<font color='green'>是</font>";
					}else{
						return "<font color='red'>否</font>";
					}
				}
			}, {
                field: "operation",
                title: "操作",
                formatter: function (value, row, index) {
                    var edit =
                        '<button type="button" style="margin-right: 8px;" class="btn btn-info btn-xs"  onclick="javascript:showUpdateModal(\'' +
                        row.areaId + '\',\'' + row.province + '\',\'' + row.city + '\',\'' + row.county +
                        '\',\'' +
                        row.postCode +'\',\''+row.simpleCode+'\',\''+row.cityCode+
                        '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
                     var disable = '<button type="button" style="margin-right: 8px;" class="btn btn-danger btn-xs"  onclick="javascript:disable(\'' +
                        row.areaId +'\')"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>禁用</button>'; 
                     var useable = '<button type="button" style="margin-right: 8px;" class="btn btn-success btn-xs"  onclick="javascript:useable(\'' +
                     row.areaId +'\')"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>启用</button>'; 
                    return edit+disable+useable;
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
	    			url:"Area/areapageQuery.action",
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
                url: "Area/addArea.action",
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
                url: "Area/updateArea.action",
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

 
    function disable(ids) {
   	 if(confirm("确定禁用选中记录吗?")){
         if(undefined == ids){
        	 ids = getIdSelections();
             //捕获页
             layer.msg('请选择一行及以上的数据', {time: 3000, icon:6});
         }

	 $.ajax({
			url:"Area/UpdateDisable.action?ids="+ids,
			type:"post",
			traditional: true, //traditional 为true阻止深度序列化
			dataType : "json",
			success : function(req) {
             if (req) {
                 $('#table').bootstrapTable('refresh');
                 layer.msg('禁用成功', {time: 3000, icon:6});
                 return;
             }
             layer.msg('禁用失败', {time: 3000, icon:6});

         },
         error : function(req) {console.log("我出错了"+req);}
	 	});	
	 }
   } 
   
    function useable(areaId){
    	 if(confirm("确定启用选中记录吗?")){
             if(undefined == areaId){
            	 areaId = getIdSelections();
                 //捕获页
                 layer.msg('请选择一行及以上的数据', {time: 3000, icon:6});
             }

    	 $.ajax({
    			url:"Area/UpdateUseable.action?areaId="+areaId,
    			type:"post",
    			traditional: true, //traditional 为true阻止深度序列化
    			dataType : "json",
    			success : function(req) {
                 if (req) {
                     $('#table').bootstrapTable('refresh');
                     layer.msg('启用成功', {time: 3000, icon:6});
                     return;
                 }
                 layer.msg('启用失败', {time: 3000, icon:6});

             },
             error : function(req) {console.log("我出错了"+req);}
    	 	});	
    	 }
    }
		
	