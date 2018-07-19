<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>角色管理</title>
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="../../layer-v3.1.1/layer/mobile/need/layer.css" rel="stylesheet" type="text/css">
	<link href="../../bootstrap-3.3.7-dist/css/bootstrapValidator.css" rel="stylesheet" type="text/css">
	<link href="../../bootstrap-3.3.7-dist/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
	
    <script src="../../bootstrap-3.3.7-dist/jquery_3.2.1/jquery.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
	<script src="../../bootstrap-3.3.7-dist/js/bootstrap-select.min.js"></script>
	<script src="../../bootstrap-3.3.7-dist/js/bootstrapValidator.js"></script>
    <script src="../../layer-v3.1.1/layer/layer.js"></script>

	<base href="<%=basePath%>" />
</head>
<body>
<div>
    <div class="layer_notice"></div>
<div class="col-*-12">
    
    <%--工具栏--%>
    <div class="panel panel-default">
    	<div class="panel-heading">
			<h4 class="panel-title">
				<a id="a" data-toggle="collapse" data-parent="#accordion"
					href="#collapseOne"> 查询角色 </a>
			</h4>
		</div>
		<div id="collapseOne" class="panel-collapse collapse ">
			<div class="panel-body">
		            <div id="toolbar_a" class="search" style="padding-top: 20px;padding-left: 10px;">
			            <form class="form-inline">
						  <div class="form-group">
						    <label for="roleName2">角色名：</label>
						    <input type="text" class="form-control" id="roleName2" placeholder="角色">
						  </div>
						  <div class="form-group">
						    <label for="organizationTypeName2">组织结构名：</label>
						    <input type="text" class="form-control" id="organizationTypeName2" placeholder="组织结构名">
						  </div>
						  <button type="button" class="btn btn-success glyphicon glyphicon-search" id="btn_search_b">查询</button>
						  <button type="button" class="btn btn-primary glyphicon glyphicon-pencil" id="btn_add">添加记录</button>
						</form>
		    		</div>
	        </div>
        </div>
	 </div>
        <%--表格--%>
        <table id="table"></table>

        <%--弹出层-增加--%>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel_add">添加操作</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" action="javascript:void(0)" id="addForm">
                        <div class="form-group">
                            <label for="txt_roleName">角色名:</label>
                            <input type="text" name="roleName" data-bind="value:orderprice" class="form-control"
                                   id="txt_roleName"
                                   placeholder="角色名">
                        </div>
                        <div class="form-group">
                            <label for="txt_keyword">关键字:</label>
                            <input type="text" name="keyword" data-bind="value:ordertime" class="form-control"
                                   id="txt_keyword"
                                   placeholder="关键字">
                        </div>
                        <div class="form-group">
                            <label for="txt_organizationTypeId">组织结构ID:</label>
                            <input type="text" name="organizationTypeId" data-bind="value:orderuser" class="form-control"
                                   id="txt_organizationTypeId"
                                   placeholder="组织结构ID">
                        </div>
                        <div class="form-group">
                            <label for="txt_organizationTypeName">组织结构名:</label>
                            <input type="text" name="organizationTypeName" data-bind="value:orderdescribe" class="form-control"
                                   id="txt_organizationTypeName"
                                   placeholder="组织结构名">
                        </div>
                        <div class="form-group">
                            <label for="txt_description">描述:</label>
                            <input type="text" name="description" data-bind="value:orderdescribe" class="form-control"
                                   id="txt_description"
                                   placeholder="描述">
                        </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                    	<span id="returnMessage" class="glyphicon"></span>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                        <button type="button" id="addRecord" class="btn btn-primary"><span
                                class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
                    </div>
                </div>
            </div>
        </div>

        <%--弹出层-修改--%>
        <!-- 更新 -->
        <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel_update">更新记录</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" action="javascript:void(0)" id="updateForm">
                            <input type="text" hidden="hidden" name="roleId" id="roleId" >
                            <div class="form-group">
                                <input type="text" class="form-control" name="roleName" id="roleName" placeholder="角色名">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="keyword" id="keyword" placeholder="关键字">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="organizationTypeId" id="organizationTypeId" placeholder="组织结构ID">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="organizationTypeName" id="organizationTypeName" placeholder="组织结构名">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="description" id="description" placeholder="描述">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                    	<span id="returnMessage2" class="glyphicon"></span>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="updateRecord">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
    	var height = $(window).height();
        $('#table').bootstrapTable({
            url: "role/rolePageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
            method: 'post',
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页
            dataType: "json",
            direction: 'asc',
            contentType:"application/x-www-form-urlencoded",
            pageNumber: 1,      //初始化加载第一页，默认第一页
            pageSize: 9,      //每页的记录行数
            pageList: [9, 15, 25, 50, 100],  //可供选择的每页的行数
            //queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页
            clickToSelect: true,    //是否启用点击选中行
            height: document.body.clientHeight - 187, //自定义表格的高度
            width: document.body.clientWidth,
            sortName : "baseDocumentId",
            locale: 'zh-CN',//中文支持,
            queryParamsType:'',
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
                field: 'roleName',
                title: '角色名称',
                align: "center"
            }, {
                field: 'keyword',
                title: '关键字',
                align: "center"
            }, {
                field: 'organizationTypeId',
                title: '组织结构ID',
                align: "center"
            }, {
                field: 'organizationTypeName',
                title: '组织结构名',
                align: "center"
            },{
                field: 'description',
                title: '描述',
                align: "center"
            },{
                field: "operation",
                title: "操作",
                formatter: function (value, row, index) {
                    var edit =
                        '<button type="button" style="margin-right: 8px;" class="btn btn-info" onclick="javascript:showUpdateModal(\'' +
                        row.roleId + '\',\'' + row.roleName + '\',\'' + row.keyword + '\',\'' + row.organizationTypeId +
                        '\',\'' +row.organizationTypeName + '\',\''+
                        row.description +
                        '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
                    var del = '<button type="button" style="margin-right: 8px;" class="btn btn-danger" onclick="javascript:dels(\'' +
                        row.roleId +
                        '\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';
                    return edit + del;
                },
                align: "center"
            }],
            paginationPreText: "上一页",
            paginationNextText: "下一页",
        });
        
        
        formValidator($("#addForm"));
        formValidator($("#updateForm"));
        
        $("#btn_search_b").click(function(){
        	 var obj = {
	    			url:"role/rolePageQuery.action",
	    			queryParams:function queryParams(params){
	    				return{
	    					pageSize:params.pageSize,
	    					pageNumber:params.pageNumber,
	    					roleName : $("#roleName2").val(), 
	    					organizationTypeName : $("#organizationTypeName2").val(),
	    					direction: 'asc' 
	    				};
	    		    },
	    		    sidePagination: "server",
	    		}; 
			$('#table').bootstrapTable('refreshOptions', obj);
        });
        
        $('#btn_add').on("click", function () {
            $("#myModal").modal("show");
        });
      
        //添加数据
        $("#addRecord").click(function(){
        	 //进行表单验证
            var bv = $("#addForm").data('bootstrapValidator');
            bv.validate();
            if (bv.isValid()) {
                var data = $("#addForm").serializeArray();
                $.ajax({
                    url: "role/addRole.action",
                    dataType:"json",
                    type: "post",
                    data: data,
                    success: function(data){
                        if (data) {
                        	$("#myModal").modal("hide");
                            $('#table').bootstrapTable('refresh');
                            layer.msg('添加成功', {time: 3000, icon:6});
                            bv.resetForm();
                            $("#addForm")[0].reset();
                            $("#returnMessage").hide();
                            return ;
                        }else{
                        	$("#returnMessage").hide().html('<label class="label label-danger">添加失败!</label>').show(230);
                        }
                    },
                    error: function(){$("#returnMessage").hide().html('<label class="label label-danger">修改失败!</label>').show(230);}
                });
            }
        });

        //更新数据
        $("#updateRecord").click(function(){
            var data = $("#updateForm").serialize();
            var bv = $("#updateForm").data('bootstrapValidator');
            bv.validate();
            if (bv.isValid()) {
	            $.ajax({
	                url: "role/updateRole.action",
	                dataType: "json",
	                type: "post",
	                data: data,
	                success: function (req){
	                    if (req) {
	                        $('#updateModal').modal('hide');
	                        layer.msg('更新成功', {time: 2500, icon:6});
	                        $('#table').bootstrapTable('refresh');
	                        bv.resetForm();
	                    } else {
	                    	$("#returnMessage2").hide().html('<label class="label label-danger">更新失败!</label>').show(230);
	                    }
	                },
	                error: function(){$("#returnMessage2").hide().html('<label class="label label-danger">更新失败!</label>').show(230);}
	            });
            }
        });
    });

    
    //显示更新模态框
    function showUpdateModal(roleId, roleName, keyword, organizationTypeId, organizationTypeName,description){
        $("#roleId").val(roleId);
        $("#roleName").val(roleName);
        $("#keyword").val(keyword);
        $("#organizationTypeId").val(organizationTypeId);
        $("#organizationTypeName").val(organizationTypeName);
        $("#description").val(description);
        $('#updateModal').modal('show');
    }

    //获取选择ID
    function getIdSelections() {
        return $.map($('#table').bootstrapTable('getSelections'), function(row) {
            return row.roleId
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
                url : "role/deleteRole.action?ids=" + ids,
                type : "post",
                traditional: true, //traditional 为true阻止深度序列化
                dataType : "json",
                success : function(req) {
                    if (req) {
                        $('#table').bootstrapTable('refresh');
                        layer.msg('删除成功', {time: 3000, icon:6});
                        return;
                    }
                    layer.msg('删除失败', {time: 3000, icon:6});

                },
                error : function() {layer.msg('异常', {time: 2100, icon:6});}
            });
        }
    }
    
    function formValidator(form){
    	form.bootstrapValidator({
            message: '输入值不合法',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	roleName: {
                    message: '角色名不合法',
                    validators: {
                        notEmpty: {
                            message: '角色名不能为空'
                        },
                        stringLength: {
                            min: 1,
                            max: 50,
                            message: '请输入1到50个字符'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                            message: '用户名只能由字母、数字、点、下划线和汉字组成 '
                        }
                    }
                }
                , keyword: {
                    validators: {
                        notEmpty: {
                            message: '不能为空'
                        },
                        stringLength: {
                        	min: 1,
                            max: 13,
                            message: '请输入1到10个字符'
                        }
                    }
                }, organizationTypeId: {
                    validators: {
                        notEmpty: {
                            message: '不能为空'
                        },
                        stringLength: {
                        	min: 1,
                            max: 16,
                            message: '请输入1到16个字符'
                        }
                    }
                }, organizationTypeName: {
                    validators: {
                        notEmpty: {
                            message: '不能为空'
                        }, stringLength: {
                            min: 1,
                            max: 100,
                            message: '请输入1到100个字符'
                        }
                    }
                }, description: {
                    validators: {
                         stringLength: {
                            min: 1,
                            max: 200,
                            message: '只能输入1到200个字符'
                        }
                    }
                }
            }
        });
    }
    
</script>
</body>
</html>
