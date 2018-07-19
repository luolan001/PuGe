<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>客户表</title>

<link href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.css" rel="stylesheet" type="text/css">
<link href="../../layer-v3.1.1/layer/theme/default/layer.css" rel="stylesheet" type="text/css">
<link href="../../bootstrap-3.3.7-dist/sweetalert/sweetalert.css" rel="stylesheet" type="text/css">
<link href="../../bootstrap-3.3.7-dist/toastr/toastr.min.css" rel="stylesheet" type="text/css">
<link href="../../bootstrap-3.3.7-dist/css/bootstrap-validator_0.5.3_css_bootstrapValidator.css" rel="stylesheet" type="text/css">

<script src="../../bootstrap-3.3.7-dist/jquery_3.2.1/jquery.min.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
<script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script src="../../layer-v3.1.1/layer/layer.js"></script>
<script src="../../bootstrap-3.3.7-dist/sweetalert/sweetalert.min.js"></script>
<script src="../../bootstrap-3.3.7-dist/toastr/toastr.min.js"></script>
<script src="../../bootstrap-3.3.7-dist/js/bootstrap-validator_0.5.3_js_bootstrapValidator.js"></script>

<base href="<%=basePath%>" />
</head>
<body>
	<div>
		<div class="layer_notice"></div>
		<div class="col-*-12">

			<%--工具栏--%>
			<div id="toolbar">
				<div id="toolbar_a" class="search"
					style="padding-top: 20px; padding-left: 10px;">
					<form class="form-inline">
						<div class="form-group">
							<label for="exampleInputEmail2">是否分级：</label> <select
								class="form-control" id="useable2">
								<option value="" selected>全部</option>
								<option value="Y">是</option>
								<option value="N">否</option>
							</select>
						</div>

						<div class="form-group">
							<label for="exampleInputEmail2">客户名：</label> <input type="text"
								class="form-control" id="customerNames" placeholder="客户名">
						</div>
						<button type="button"
							class="btn btn-success glyphicon glyphicon-search"
							id="btn_search_b">查询</button>
						<button type="button"
							class="btn btn-primary glyphicon glyphicon-pencil" id="btn_add">添加记录</button>
					</form>
				</div>
			</div>

			<%--表格--%>
			<table id="table"></table>

			<%--弹出层-增加--%>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel_add">添加操作</h4>
						</div>
						<div class="modal-body">
							<form role="form" action="javascript:void(0)" id="addForm">
									<div class="form-group">
									<label for="txt_customerNo">客户编号</label> <input type="text"
										name="customerNo" data-bind="value:orderprice"
										class="form-control" id="txt_customerNo" placeholder="客户编号">
								</div>
								<div class="form-group">
									<label for="txt_customerNo">联系人</label> <input type="text"
										name="connectMan" data-bind="value:orderprice"
										class="form-control" id="txt_connectMan" placeholder="联系人">
								</div>
								<div class="form-group">
									<label for="txt_connectPhone">联系人手机号</label> <input type="text"
										name="connectPhone" data-bind="value:orderprice"
										class="form-control" id="txt_connectPhone"
										placeholder="联系人手机号">
								</div>
								<div class="form-group">
									<label for="txt_connectAddress">联系人地址</label> <input
										type="text" name="connectAddress" data-bind="value:orderprice"
										class="form-control" id="txt_connectAddress"
										placeholder="联系人地址">
								</div>
								<div class="form-group">
									<label for="txt_customerName">客户名</label> <input type="text"
										name="customerName" data-bind="value:ordertime"
										class="form-control" id="txt_customerName" placeholder="客户名">
								</div>
								<div class="form-group">
									<label for="txt_phoneNumber">客户手机号</label> <input type="text"
										name="phoneNumber" data-bind="value:ordertime"
										class="form-control" id="txt_phoneNumber" placeholder="客户手机号">
								</div>
								<div class="form-group">
									<label for="txt_address">客户地址</label> <input type="text"
										name="address" data-bind="value:ordertime"
										class="form-control" id="txt_address" placeholder="客户地址">
								</div>
								<div class="form-group">
									<label for="txt_scale">是否分级</label> <input type="text"
										name="useable" data-bind="value:orderuser"
										class="form-control" id="txt_scale" placeholder="是否分级">
								</div>
								<div class="form-group">
									<label for="txt_description">描述</label> <input type="text"
										name="description" data-bind="value:orderdescribe"
										class="form-control" id="txt_description" placeholder="描述">
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
							</button>
							<button type="button" id="addRecord" class="btn btn-primary"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
							</button>
						</div>
					</div>
				</div>
			</div>

			<%--弹出层-修改--%>
			<!-- 更新 -->
			<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel_update">更新记录</h4>
						</div>
						<div class="modal-body">
							<form role="form" action="javascript:void(0)" id="updateForm">
								<input type="text" hidden="hidden" name="id" id="id">
								<div class="form-group" hidden="hidden">
									<input type="text" class="form-control" name="customerId"
										id="customerId">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="customerNo"
										id="customerNo">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="connectMan"
										id="connectMan">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="connectPhone"
										id="connectPhone">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="connectAddress"
										id="connectAddress">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="customerName"
										id="customerName">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="phoneNumber"
										id="phoneNumber">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="address"
										id="address">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="useable"
										id="useable">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="description"
										id="description">
								</div>
								<%--<div class="form-group">--%>
								<%--<label class="checkbox-inline">--%>
								<%--<input type="radio" name="useable" id="used" value="1" checked>可用--%>
								<%--</label>--%>
								<%--<label class="checkbox-inline">--%>
								<%--<input type="radio" name="useable" id="unused"  value="0">禁用--%>
								<%--</label>--%>
								<%--</div>--%>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary" id="updateRecord">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
			toastr.options= {  
					closeButton: false,  //是否显示关闭按钮
					debug: false,   //是否为调试
					progressBar: true,  //是否显示进度条
					positionClass: "toast-top-center",  //在页面中显示的位置
					onclick: null,  //点击事件
					showDuration: "3000",  //显示动作时间
					hideDuration: "3000",  //隐藏动作时间
					timeOut: "3000",  //自动关闭超时时间
					extendedTimeOut: "1000",   //加长展现时间
					showEasing: "swing",  
					hideEasing: "linear",  
					preventDuplicates: true ,
					preventOpenDuplicates: true, //重复内容的提示框在开启时只出现一个
					showMethod: "fadeIn",  //显示的方式
					hideMethod: "fadeOut" //隐藏的方式
				};  

		$(function() {
			var height = $(window).height();
			$('#table')
					.bootstrapTable(
							{
								url : "customer/customerpageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
								method : 'post',
								toolbar : '#toolbar', //工具按钮用哪个容器
								striped : true, //是否显示行间隔色
								cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
								pagination : true, //是否显示分页
								dataType : "json",
								direction : 'asc',
								contentType : "application/x-www-form-urlencoded",
								pageNumber : 1, //初始化加载第一页，默认第一页
								pageSize : 5, //每页的记录行数
								pageList : [ 5, 10, 25, 50, 100 ], //可供选择的每页的行数
								//queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
								sidePagination : "server", //分页方式：client客户端分页，server服务端分页
								showColumns : true, //显示下拉框勾选要显示的列
								showRefresh : true, //是否显示刷新按钮
								clickToSelect : true, //是否启用点击选中行
								buttonsAlign : "right", //按钮位置
								showToggle : true, //是否显示详细视图和列表视图的切换按钮

								width : document.body.clientWidth,
								sortName : "customerId",
								locale : 'zh-CN',//中文支持,
								queryParamsType : '',
								singleSelect : true,
								queryParams : function queryParams(params) {
									var param = {
										pageNumber : params.pageNumber,
										pageSize : params.pageSize
									};
									return param;
								},

								columns : [
										{
											title : "全选",
											field : "select",
											radio : true,
											width : 20,
											align : "center",
											valign : "middle"//垂直
										},
										{
											field : 'customerId',
											title : ' 客户id',
											align : "center",
										},
										{
											field : 'customerNo',
											title : ' 客户编号',
											align : "center",
										},
										{
											field : 'connectMan',
											title : '联系人',
											align : "center",
										},
										{
											field : 'connectPhone',
											title : '联系人手机号',
											align : "center",
											visible : false
										},
										{
											field : 'connectAddress',
											title : ' 联系人地址',
											align : "center",
										},
										{
											field : 'customerName',
											title : '客户名',
											align : "center",
										},
										{
											field : 'phoneNumber',
											title : '客户手机号',
											align : "center",
											visible : false
										},
										{
											field : 'address',
											title : '客户地址',
											align : "center",
										},
										{
											field : 'useable',
											title : '是否可用',
											align : "center",
											formatter : function(value, row,
													index) {
												if (value == "N"
														|| value == "n") {
													var judge = "<font color='red'>否</font>";

												} else if (value = "Y"
														|| value == "y") {
													var judge = "<font color='green'>是</font>";
												}
												return judge;
											}

										},
										{
											field : 'description',
											title : '描述',
											align : "center",
										},
										{
											field : "operation",
											title : "操作",
											formatter : function(value, row,
													index) {
												var edit = '<button type="button" style="margin-right: 8px;" class="btn btn-info" onclick="javascript:showUpdateModal(\''
														+ row.customerId
														+ '\',\''
														+ row.customerNo
														+ '\',\''
														+ row.connectMan
														+ '\',\''
														+ row.connectPhone
														+ '\',\''
														+ row.connectAddress
														+ '\',\''
														+ row.customerName
														+ '\',\''
														+ row.phoneNumber
														+ '\',\''
														+ row.address
														+ '\',\''
														+ row.useable
														+ '\',\''
														+ row.description
														+ '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
												var del = '<button type="button" style="margin-right: 8px;" class="btn btn-danger" onclick="javascript:dels(\''
														+ row.customerId
														+ '\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';
												var look = '<button type="button" style="margin-right: 8px;" class="btn btn-success" onclick="javascript:look(\''
														+ row.customerId
														+ '\')"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>查看</button>';
												return edit + del;
											},
											align : "center"
										} ],
								paginationPreText : "上一页",
								paginationNextText : "下一页",
							});

			$('#btn_add').on("click", function() {
				$("#myModal").modal().on("shown.bs.modal", function() {
				}).on('hidden.bs.modal', function() {
				});
			});

			$("#btn_search_b").click(function() {
				var obj = {
					url : "customer/customerpageQuery.action",
					queryParams : function queryParams(params) {
						return {
							pageSize : params.pageSize,
							pageNumber : params.pageNumber,
							useable : $("#useable2").val(),
							customerName : $("#customerNames").val(),
							direction : 'asc'
						};
					},
					sidePagination : "server",
				};
				$('#table').bootstrapTable('refreshOptions', obj);
			});
			
 			//给客户表增加添加验证
			$("#addForm").bootstrapValidator({
				message:'输入值不合法',//好像从来没出现过
				feedbackIcons:{//根据验证结果显示的各种图标
					valid:'glyphicon glyphicon-ok',
					invalid:'glyphicon glyphicon-remove',
					validating:'glyphicon glyphicon-refresh',
				},
				fields:{
					customerNo:{
						message:'客户编号不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'客户编号必须输入'
							},
							regexp:{//检测长度
								regexp:  /^([-+]?\d{1,10})(\.\d{1,5})?$/,
								message:'只能输入5-10以内的纯数字'
							}
						}
					},
					connectMan:{
						message:'联系人名不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'联系人名必须输入'
							}
						}
					},
					connectPhone:{
						message:'手机格式不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'手机号必须输入'
							},
							regexp:{//检测长度
								regexp:  /^1\d{10}$/,
								message:'所输入的字符不符合要求'
							}
						}
					},
					connectAddress:{
						message:'联系人地址不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'联系人地址必须输入'
							}
						}
					},
					customerName:{
						message:'客户名不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'客户名必须输入'
							}
						}
					},
					phoneNumber:{
						message:'手机格式不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'手机号必须输入'
							},
							regexp:{//检测长度
								regexp: /^1\d{10}$/,
								message:'所输入的字符不符合要求'
							}
						}
					},
					address:{
						message:'客户地址不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'客户地址必须输入'
							}
						}
					},
					useable:{
						message:'是否可用不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'是否可用必须输入'
							},
							regexp:{//检测长度
								regexp:  /^[Y|N|y|n]$/,
								message:'只能输入y-n或Y-N'
							}
						}
					}
				}
			});
 
			//添加数据
			$("#addRecord").click(function() {
					$("#addForm").data('bootstrapValidator').validate();//提交验证
					if($("#addForm").data('bootstrapValidator').isValid()){
					var data = $("#addForm").serializeArray();
					$.ajax({
						url : "customer/addCustomer.action",
						dataType : "json",
						type : "post",
						data : data,
						success : function(data) {
							console.log("123");
							if (data) {
								$('#addModal').modal('hide');
								$('#table').bootstrapTable('refresh');
								$('#addForm')[0].reset();
								toastr.success('添加成功',{time:3000,icon:6});
								$("#addForm").data('bootstrapValidator').resetForm();
								$("#addForm").data('bootstrapValidator').destroy();
								$("#addForm").data('bootstrapValidator',null);

								return;
							}
								//捕获页
								toastr.success('添加失败',{time:3000,icon:6});										
							},
						error : function(data) {console.log("我出错了");}
					});
				}
			});
			
			//视频学习网站
			/* www.37jv.com
			www.susu57.com
			www.woyaodizhi.com
			www.186sihu.com */
 			//给客户表增加添加验证
			$("#updateForm").bootstrapValidator({
				message:'输入值不合法',//好像从来没出现过
				feedbackIcons:{//根据验证结果显示的各种图标
					valid:'glyphicon glyphicon-ok',
					invalid:'glyphicon glyphicon-remove',
					validating:'glyphicon glyphicon-refresh',
				},
				fields:{
					customerNo:{
						message:'客户编号不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'客户编号必须输入'
							},
							regexp:{//检测长度
								regexp:  /^([-+]?\d{1,10})(\.\d{1,5})?$/,
								message:'只能输入5-10以内的纯数字'
							}
						}
					},
					connectMan:{
						message:'联系人名不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'联系人名必须输入'
							}
						}
					},
					connectPhone:{
						message:'手机格式不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'手机号必须输入'
							},
							regexp:{//检测长度
								regexp:  /^1\d{10}$/,
								message:'所输入的字符不符合要求'
							}
						}
					},
					connectAddress:{
						message:'联系人地址不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'联系人地址必须输入'
							}
						}
					},
					customerName:{
						message:'客户名不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'客户名必须输入'
							}
						}
					},
					phoneNumber:{
						message:'手机格式不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'手机号必须输入'
							},
							regexp:{//检测长度
								regexp: /^1\d{10}$/,
								message:'所输入的字符不符合要求'
							}
						}
					},
					address:{
						message:'客户地址不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'客户地址必须输入'
							}
						}
					},
					useable:{
						message:'是否可用不合法',
						validators:{
							notEmpty:{//检测非空，radio也可用
								message:'是否可用必须输入'
							},
							regexp:{//检测长度
								regexp:  /^[Y|N|y|n]$/,
								message:'只能输入y-n或Y-N'
							}
						}
					}
				}
			});


			//更新数据
			$("#updateRecord").click(function() {
				$("#updateForm").data('bootstrapValidator').validate();//提交验证
				var data = $("#updateForm").serialize();
				$.ajax({
					url : "customer/updateCustomer.action",
					dataType : "json",
					type : "post",
					data : data,
					success : function(req) {
						if (req) {
							$('#updateModal').modal('hide');
							$('#table').bootstrapTable('refresh');
							$("#updateForm").data('bootstrapValidator').resetForm();
							toastr.success('更新成功');	
						} else {
							toastr.success('更新失败');	
						}
					},
					error : function(req) {
					}
				});
			});

		});

		//显示更新模态框
		function showUpdateModal(customerId, customerNo, connectMan, connectPhone,
				connectAddress,customerName,phoneNumber,address,useable,description) {
			$("#customerId").val(customerId);
			$("#customerNo").val(customerNo);
			$("#connectMan").val(connectMan);
			$("#connectPhone").val(connectPhone);
			$("#connectAddress").val(connectAddress);
			$("#customerName").val(customerName);
			$("#phoneNumber").val(phoneNumber);
			$("#address").val(address);
			$('#useable').val(useable);
			$("#description").val(description);
			$("#updateModal").modal('show');
		}

		//获取选择ID
		function getIdSelections() {
			return $.map($('#table').bootstrapTable('getSelections'), function(
					row) {
				return row.customerId
			});
		}

		//删除记录
		function dels(ids) {
			if (confirm("确定删除选中记录吗?")) {
				console.log("我11111");
				if (undefined == ids) {
					ids = getIdSelections();
					//捕获页
					layer.msg('请选择一行及以上的数据', {
						time : 3000,
						icon : 6
					});
				}

				$.ajax({
					url : "customer/deleteCustomer.action?ids=" + ids,
					type : "post",
					traditional : true, //traditional 为true阻止深度序列化
					dataType : "json",
					success : function(req) {
						console.log("123");
						if (req) {
							$('#table').bootstrapTable('refresh');
							toastr.success('删除成功', {
								time : 3000,
								icon : 6
							});
							return;
						}
						layer.msg('删除失败', {
							time : 3000,
							icon : 6
						});

					},
					error : function(req) {
						console.log("我出错了" + req);
					}
				});
			}
		}
	</script>
</body>
</html>
