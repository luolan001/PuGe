<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width,initial-scale=1.0" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<meta content="email=no" name="format-detection">
<title>角色资源管理</title>
<link href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.css"
	rel="stylesheet" type="text/css">
<link href="../../layer-v3.1.1/layer/mobile/need/layer.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="../../jqwidgets-ver5.7.2/jqwidgets/styles/jqxbase.css"
	type="text/css" />
<link rel="stylesheet"
	href="../../jqwidgets-ver5.7.2/jqwidgets/styles/jqx.energyblue.css"
	type="text/css" />
<link href="../../bootstrap-3.3.7-dist/css/bootstrapValidator.css"
	rel="stylesheet" type="text/css">
<link href="../../bootstrap-3.3.7-dist/css/bootstrap-select.min.css"
	rel="stylesheet" type="text/css">


<script src="../../bootstrap-3.3.7-dist/jquery_3.2.1/jquery.min.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script
	src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
<script
	src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script src="../../layer-v3.1.1/layer/layer.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap-select.min.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrapValidator.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bringins.js"></script>
<script src="../../layer-v3.1.1/layer/layer.js"></script>

<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxcore.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxdata.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxdatatable.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxtreegrid.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/scripts/demos.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/generatedata.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxdropdownlist.js"></script>
<script type="text/javascript"
	src="../../jqwidgets-ver5.7.2/jqwidgets/jqxlistbox.js"></script>

<base href="<%=basePath%>" />
</head>
<body>
	<div>
		<!-- 角色表html -->
		<div class="col-md-6">
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
						<div id="toolbar_a" class="search"
							style="margin-top: 20px; margin-left: 10px;">
							<form class="form-inline">
								<div class="form-group">
									<label for="roleName2">角色名：</label> <input type="text"
										class="form-control" id="roleName2" placeholder="角色">
								</div>
								&nbsp;
								<div class="form-group">
									<label for="organizationTypeName2">组织结构名：</label> <input
										type="text" class="form-control" id="organizationTypeName2"
										placeholder="组织结构名">
								</div>
								<button type="button"
									class="btn btn-success glyphicon glyphicon-search"
									id="btn_search_role">查询</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<%--表格--%>
			<table id="table"></table>
		</div>

		<!-- 资源表html -->
		<div id="resourceHTML"
			class="col-md-5 panel panel-default bringins-content">
			<div class="panel-heading">
				<label id="jueseName">资源</label>
			</div>
			<%--工具栏--%>
			<div id="toolbar_a" class="search">
				<div style="margin-top: 20px;">
					<button type="button"
						class="btn btn-info glyphicon glyphicon-ok-circle"
						id="btn_RoleResourceAdd">确定分配</button>
				</div>
			</div>
			<div id="treegrid"></div>
		</div>
	</div>
</body>



<script type="text/javascript">
	var roleIdGlobal;
	$(function() {
		var height = $(window).height();
		$('#table')
				.bootstrapTable(
						{
							url : "role/rolePageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
							method : 'post',
							striped : true, //是否显示行间隔色
							cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
							pagination : true, //是否显示分页
							dataType : "json",
							direction : 'asc',
							contentType : "application/x-www-form-urlencoded",
							pageNumber : 1, //初始化加载第一页，默认第一页
							pageSize : 15, //每页的记录行数
							pageList : [ 15, 30, 60, 100 ], //可供选择的每页的行数
							//queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
							sidePagination : "server", //分页方式：client客户端分页，server服务端分页
							clickToSelect : true, //是否启用点击选中行
							height : 597, //自定义表格的高度
							sortName : "baseDocumentId",
							locale : 'zh-CN',//中文支持,
							queryParamsType : '',
							queryParams : function queryParams(params) {
								var param = {
									pageNumber : params.pageNumber,
									pageSize : params.pageSize
								};
								return param;
							},

							columns : [
									{
										field : 'operation',
										title : '操作',
										formatter : function(value, row, index) {
											var addResource = '<button type="button" style="margin-right: 8px;" class="btn btn-warning" onclick="javascript:roleAddResource(\''
													+ row.roleId
													+ '\',\''
													+ row.roleName
													+ '\')"><span class="glyphicon glyphicon-warning glyphicon-eye-open aria-hidden="true"></span>分配资源</button>';
											return addResource;
										},
										align : "center"
									}, {
										field : 'roleName',
										title : '角色名称',
										align : "center"
									}, {
										field : 'keyword',
										title : '关键字',
										align : "center"
									}, {
										field : 'organizationTypeName',
										title : '组织结构类型',
										align : "center"
									} ],
							paginationPreText : "上一页",
							paginationNextText : "下一页",
						});

		//分配资源按钮点击事件
		/*   $("#btn_RoleAddAuthorization").click(function(){
		  	var rows = $('#table').bootstrapTable('getSelections');
			if(rows.length < 1 ){
				layer.msg('请选择一位角色', {time: 2500, icon:6});
				return ;
			}
			if(rows.length >1){
				layer.msg('每次只能选择一位角色进行资源分配', {time: 2500, icon:6});
				return ;
			}
			var roleId = rows[0].roleId;
			$.ajax({
				url:'resource/findResourceWithRoleId.action',
				type:'post',
				dataType:'json',
				data: {'roleId':roleId},
				success:function(resourceList){
					var rowsArray = $("#treegrid").jqxTreeGrid('getRows');
		        for(var i = 0; i < rowsArray.length; i++)
		        {
		        	$("#treegrid").jqxTreeGrid('uncheckRow',rowsArray[i].resourceId);
		        }

					for(var i = 0; i < resourceList.length; i++){
						if(resourceList[i].parentId != 'null'){
							$("#treegrid").jqxTreeGrid('checkRow',resourceList[i].resourceId);
						}
					}
					$("#resourceHTML").attr("class","col-md-5 panel panel-warning");
					$("#jueseName").hide().html('<span class="label label-default" id="spanRoleName">'+rows[0].roleName+'</span>').show(200);
					$("#btn_RoleResourceAdd").removeAttr("disabled");
				},
				error:function(){
					layer.msg('异常', {time: 3000, icon:6});
				}
			});
		  }); */

		$("#btn_search_role").click(
				function() {
					var obj = {
						url : "role/rolePageQuery.action",
						queryParams : function queryParams(params) {
							return {
								pageSize : params.pageSize,
								pageNumber : params.pageNumber,
								roleName : $("#roleName2").val(),
								organizationTypeName : $(
										"#organizationTypeName2").val(),
								direction : 'asc'
							};
						},
						sidePagination : "server",
					};
					$('#table').bootstrapTable('refreshOptions', obj);
				});
	});

	function roleAddResource(roleId, roleName) {
		roleIdGlobal = roleId;
		$.ajax({
			url : 'resource/findResourceWithRoleId.action',
			type : 'post',
			dataType : 'json',
			data : {
				'roleId' : roleId
			},
			success : function(resourceList) {
				var rowsArray = $("#treegrid").jqxTreeGrid('getRows');
				for (var i = 0; i < rowsArray.length; i++) {
					$("#treegrid").jqxTreeGrid('uncheckRow',
							rowsArray[i].resourceId);
				}

				for (var i = 0; i < resourceList.length; i++) {
					if (resourceList[i].parentId != 'null') {
						$("#treegrid").jqxTreeGrid('checkRow',
								resourceList[i].resourceId);
					}
				}
				$("#jueseName").hide().html(
						'<span class="label label-default">' + roleName
								+ '</span>').show(200);
				$("#btn_RoleResourceAdd").removeAttr("disabled");
				$('#resourceHTML').bringins({
					"width":"50%",
					"closeButton":"white",
					"color":"#e3e1e1"
				});
			},
			error : function() {
				layer.msg('异常', {
					time : 3000,
					icon : 6
				});
			}
		});
	}
	
</script>

<!-- 资源表JS -->
<script type="text/javascript">
	/**
	 * 资源表js
	 */
	$(function() {
		var unResourceId = new Array();
		var i = 0;
		//初始化操作消息提示框
		jqxTreeGrid();

		$("#btn_RoleResourceAdd").attr("disabled", true);

		$("#btn_RoleResourceAdd").click(
				function() {
					console.log(roleIdGlobal);
					var rowsTreegrid = $("#treegrid").jqxTreeGrid(
							'getCheckedRows');
					var resourceIdData = "";
					for (var i = 0; i < rowsTreegrid.length; i++) {
						resourceIdData += rowsTreegrid[i].resourceId + ",";
					}
					$.ajax({
						url : 'roleResource/addRoleResource.action',
						type : 'post',
						dataType : 'json',
						data : {
							'roleId' : roleIdGlobal,
							'resourceIdData' : resourceIdData
						},
						success : function(res) {
							$("#btn_RoleResourceAdd").attr("disabled", true);
							layer.msg('资源分配成功', {
								time : 2900,
								icon : 1
							});
						},
						error : function() {
							layer.msg('异常', {
								time : 2900,
								icon : 1
							});
						}
					});
				});
	});

	function jqxTreeGrid() {
		var source = {
			dataType : "json",
			dataFields : [ {
				name : "resourceId",
				type : "string"
			}, {
				name : "resourceName",
				type : "string"
			}, {
				name : "keyword",
				type : "string"
			}, {
				name : "parentId",
				type : "string"
			}, {
				name : "parentName",
				type : "string"
			}, {
				name : "resourceType",
				type : "string"
			}, {
				name : "resourceUrl",
				type : "string"
			}, {
				name : "description",
				type : "string"
			}, {
				name : "indexs",
				type : "integer"
			}, {
				name : "useable",
				type : "string"
			} ],
			hierarchy : {
				keyDataField : {
					name : 'resourceId'
				},
				parentDataField : {
					name : 'parentId'
				}
			},
			id : 'resourceId',
			url : 'resource/findAll.action'
		};
		var dataAdapter = new $.jqx.dataAdapter(source);

		$("#treegrid").jqxTreeGrid({
			height : '500', //自定义表格的高度
			width : document.clientWidth,
			source : dataAdapter,
			sortable : true, //可分类的
			theme : 'energyblue',
			filterable : true, //开启过滤
			filterMode : 'advanced', //过滤模式
			pageable : true,
			pageSize : 18,
			pagerPosition : "bottom",
			ready : function() {
				$("#treegrid").jqxTreeGrid('expandRow', '2');
			},
			hierarchicalCheckboxes : true,
			checkboxes : true,
			columns : [ {
				text : '资源ID',
				dataField : 'resourceId',
				width : 200,
				hidden : true
			}, {
				text : '资源名',
				dataField : 'resourceName',
				width : 150
			}, {
				text : '简称',
				dataField : 'keyword',
				hidden : true
			}, {
				text : '父ID',
				dataField : 'parentId',
				hidden : true
			}, {
				text : '父资源名',
				dataField : 'parentName',
				width : 120
			}, {
				text : '资源级别',
				dataField : 'resourceType',
				width : 120
			}, {
				text : '资源路径',
				dataField : 'resourceUrl',
				hidden : true
			}, {
				text : '描述',
				dataField : 'description',
				hidden : true
			}, {
				text : '索引',
				dataField : 'indexs'
			}, {
				text : '是否可用(Y/N)',
				dataField : 'useable',
				width : 110
			} ]
		});
	}
</script>
</html>
