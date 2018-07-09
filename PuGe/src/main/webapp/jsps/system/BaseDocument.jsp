<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Bootstrap-Table</title>
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="../../layer-v3.1.1/layer/mobile/need/layer.css" rel="stylesheet" type="text/css">
    
    <script src="../../bootstrap-3.3.7-dist/jquery_3.2.1/jquery.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script src="../../layer-v3.1.1/layer/layer.js"></script>

	<base href="<%=basePath%>" />
</head>
<body>
<div>
    <div class="layer_notice"></div>
<div class="col-*-12">
    
    <%--工具栏--%>
        <div id="toolbar">
            <div id="toolbar_a" class="search" style="padding-top: 20px;padding-left: 10px;">
	            <form class="form-inline">
				  <div class="form-group">
				    <label for="exampleInputEmail2">是否分级：</label>
				    <select class="form-control" id="scale2">
					  <option value="" selected >全部</option>
					  <option value="Y">是</option>
					  <option value="N">否</option>
					</select>				  
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail2">基础档案名：</label>
				    <input type="text" class="form-control" id="baseDocumentName2" placeholder="基础档案名">
				  </div>
				  <button type="button" class="btn btn-success glyphicon glyphicon-search" id="btn_search_b">查询</button>
				  <button type="button" class="btn btn-primary glyphicon glyphicon-pencil" id="btn_add">添加记录</button>
				</form>
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
                            <label for="txt_baseDocumentNo">基础档案编号</label>
                            <input type="text" name="baseDocumentNo" data-bind="value:orderprice" class="form-control"
                                   id="txt_baseDocumentNo"
                                   placeholder="基础档案编号">
                        </div>
                        <div class="form-group">
                            <label for="txt_baseDocumentName">基础档案名</label>
                            <input type="text" name="baseDocumentName" data-bind="value:ordertime" class="form-control"
                                   id="txt_baseDocumentName"
                                   placeholder="基础档案名">
                        </div>
                        <div class="form-group">
                            <label for="txt_scale">是否分级</label>
                            <input type="text" name="scale" data-bind="value:orderuser" class="form-control"
                                   id="txt_scale"
                                   placeholder="是否分级">
                        </div>
                        <div class="form-group">
                            <label for="txt_description">描述</label>
                            <input type="text" name="description" data-bind="value:orderdescribe" class="form-control"
                                   id="txt_description"
                                   placeholder="描述">
                        </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                        <button type="button" id="addRecord" class="btn btn-primary" data-dismiss="modal"><span
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
                            <input type="text" hidden="hidden" name="id" id="id">
                            <div class="form-group" hidden="hidden" >
                                <input type="text" class="form-control" name="baseDocumentId" id="baseDocumentId">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="baseDocumentNo" id="baseDocumentNo">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="baseDocumentName" id="baseDocumentName">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="scale" id="scale">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="description" id="description">
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
            url: "baseDocument/baseDocumentpageQuery.action",//这个接口需要处理bootstrap table传递的固定参数
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
            height: document.body.clientHeight - 200, //自定义表格的高度
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
                    var edit =
                        '<button type="button" style="margin-right: 8px;" class="btn btn-info" onclick="javascript:showUpdateModal(\'' +
                        row.baseDocumentId + '\',\'' + row.baseDocumentNo + '\',\'' + row.baseDocumentName + '\',\'' + row.scale +
                        '\',\'' +
                        row.description +
                        '\')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>更新</button>';
                    var del = '<button type="button" style="margin-right: 8px;" class="btn btn-danger" onclick="javascript:dels(\'' +
                        row.baseDocumentId +
                        '\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';
                    var look= '<button type="button" style="margin-right: 8px;" class="btn btn-success" onclick="javascript:look(\'' +
                    row.baseDocumentId +
                    '\')"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>查看</button>';
                    return edit + del + look;
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
        
        //添加数据
        $("#addRecord").click(function(){
        	console.log("123456");
            var data = $("#addForm").serializeArray();
            alert(data);
            $.ajax({
                url: "baseDocument/addDocument.action",
                dataType:"json",
                type: "post",
                data: data,
                success: function(data){
                	console.log("123");
                    if (data) {
                        $('#addModal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                        layer.msg('添加成功', {time: 3000, icon:6});
                        
                        $('#txt_baseDocumentNo')[0].value = ""; 
                        $('#txt_baseDocumentName')[0].value = "";
                        $('#txt_scale')[0].value = "";
                        $('#txt_description')[0].value = "";
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
                url: "baseDocument/updateDocument.action",
                dataType: "json",
                type: "post",
                data: data,
                success: function (req){
                    if (req) {
                        $('#updateModal').modal('hide');
                        $('#table').bootstrapTable('refresh');
                    } else {
                        alert("更新失败");
                    }
                },
                error: function(req){}
            });
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

    //获取选择ID
    function getIdSelections() {
        return $.map($('#table').bootstrapTable('getSelections'), function(row) {
            return row.baseDocumentId
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
</script>
</body>
</html>
