<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <title>资源管理</title>
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="../../layer-v3.1.1/layer/mobile/need/layer.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../../jqwidgets-ver5.7.2/jqwidgets/styles/jqxbase.css" type="text/css" />
	<link rel="stylesheet" href="../../jqwidgets-ver5.7.2/jqwidgets/styles/jqx.energyblue.css" type="text/css" />
	
    <script src="../../bootstrap-3.3.7-dist/jquery_3.2.1/jquery.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script src="../../layer-v3.1.1/layer/layer.js"></script>
	
	<script type="text/javascript" src="../../jqwidgets-ver5.7.2/jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="../../jqwidgets-ver5.7.2/jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="../../jqwidgets-ver5.7.2/jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="../../jqwidgets-ver5.7.2/jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="../../jqwidgets-ver5.7.2/jqwidgets/jqxdatatable.js"></script>
    <script type="text/javascript" src="../../jqwidgets-ver5.7.2/jqwidgets/jqxtreegrid.js"></script>
    <script type="text/javascript" src="../../jqwidgets-ver5.7.2/scripts/demos.js"></script>
    <script type="text/javascript" src="../../jqwidgets-ver5.7.2/generatedata.js"></script>
<base href="<%=basePath%>" />
</head>
<body>
<div>
    <div class="layer_notice"></div>
<div class="col-*-12">
    
    <%--工具栏--%>
        <div id="toolbar" style="margin-left:40px;">
            <div id="toolbar_a" class="search" style="padding-top: 20px;padding-left: 10px;">
	            <form class="form-inline">
				  <div class="form-group">
				    <label for="exampleInputEmail2">资源名：</label>
				    <input type="text" class="form-control" id="resourceName" placeholder="资源名">
				  </div>
				  
				  <div class="form-group" style="margin-left:20px;">
				    <label for="exampleInputEmail2">索引：</label>
				    <input type="text" class="form-control" id="indexs" placeholder="索引">
				  </div>
				  
				  <div class="form-group" style="margin-left:20px;">
				    <label for="exampleInputEmail2">父菜单：</label>
				    <input type="text" class="form-control" id="parentResourceName" placeholder="父菜单">
				  </div>
				  <div class="form-group" style="margin-left:20px;">
				    <label for="exampleInputEmail2">菜单级别：</label>
				    <input type="text" class="form-control" id="resourceType" placeholder="菜单级别">
				  </div>
				  
				  <button type="button" class="btn btn-success glyphicon glyphicon-search" id="btn_search_b">查询</button>
				</form>
				<div style="margin-top:10px;margin-left:-3px;">
					<button type="button" class="btn btn-warning glyphicon glyphicon-pencil" id="btn_update">修改资源</button>
					<button type="button" class="btn btn-danger glyphicon glyphicon-ban-circle" id="btn_delete" >禁用</button>
					<button type="button" class="btn btn-info glyphicon glyphicon-ok-circle" id="btn_enable" >启用</button>
				</div>
    		</div>
        </div>
	    
	    <div id="treegrid" style="margin-left:45px;margin-top:7px;"> </div>
	    
	    <%--弹出层-修改--%>
        <!-- 更新 -->
        <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-hidden="true" >
            <div class="modal-dialog" >
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel_update">修改资源</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" id="updateForm" class="form-horizontal">
                            <div class="form-group">
                            	<label for="resourceId" class="col-sm-3 control-label">resourceId:</label>
							    <div class="col-sm-9">
							      <input type="text" class="form-control" name="resourceId" id="resourceId" readonly>
							    </div>
                            </div>
                            <div class="form-group">
                            	<label for="resourceName" class="col-sm-3 control-label">resourceName:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="resourceName" id="resourceName2">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="keyword" class="col-sm-3 control-label">keyword:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="keyword" id="keyword">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="parentId" class="col-sm-3 control-label">parentId:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="parentId" id="parentId">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="parentName" class="col-sm-3 control-label">parentName:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="parentName" id="parentName">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="resourceType" class="col-sm-3 control-label">resourceType:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="resourceType" id="resourceType2">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="resourceUrl" class="col-sm-3 control-label">resourceUrl:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="resourceUrl" id="resourceUrl">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="description" class="col-sm-3 control-label">description:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="description" id="description">
                                </div>
                            </div>
                            <div class="form-group">
                            	<label for="indexs" class="col-sm-3 control-label">indexs:</label>
                            	<div class="col-sm-9">
                                	<input type="text" class="form-control" name="indexs" id="indexs2">
                                </div>
                            </div>
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
</body>
<script type="text/javascript">
/**
 * 主方法
 */
$(function(){
	//初始化操作消息提示框
	jqxTreeGrid();
            
    $("#btn_search_b").click(function(){
		jqxTreeGrid();
	});
    
    $("#btn_delete").click(function(){
    	var rows = $("#treegrid").jqxTreeGrid("getCheckedRows");
		if(rows.length <=0 ){
			layer.msg('请选择一行及以上的数据', {time: 2500, icon:6});
			return ;
		}
		
		/* var useableStatus = "";
		for (var i = 0; i < rows.length; i++) {
			useableStatus+=rows[i].useable+",";
	    }
		if(useableStatus.indexOf("N") != -1 || useableStatus.indexOf("n") != -1){
			layer.msg('您的选择存在已禁用的数据 , 请取消已禁用数据后再操作.', {time: 3800, icon:6});
			return ;
		} */
		
		var resArray = "";
		for (var i = 0; i < rows.length; i++) {
			resArray+=rows[i].resourceId+",";
	    }
        $.ajax({
            url : "resource/deleteUseableTx.action",
            type : "post",
            traditional: true, //traditional 为true阻止深度序列化
            dataType : "json",
            data:{"resourceIdArray":resArray},
            success : function(req) {
                if (req) {
                    layer.msg('禁用成功', {time: 2500, icon:6});
            		jqxTreeGrid();
                    return;
                }
                layer.msg('禁用失败', {time: 2500, icon:6});

            },
            error : function(req) {console.log("我出错了"+req);}
        });
    });
    
    $("#btn_enable").click(function(){
    	var rows = $("#treegrid").jqxTreeGrid("getCheckedRows");
		if(rows.length <=0 ){
			layer.msg('请选择一行及以上的数据', {time: 2500, icon:6});
			return ;
		}
		
		var resArray = "";
		for (var i = 0; i < rows.length; i++) {
			resArray+=rows[i].resourceId+",";
	    }
        $.ajax({
            url : "resource/enableUseableTx.action",
            type : "post",
            traditional: true, //traditional 为true阻止深度序列化
            dataType : "json",
            data:{"resourceIdArray":resArray},
            success : function(req) {
                if (req) {
                    layer.msg('启用成功', {time: 2500, icon:6});
            		jqxTreeGrid();
                    return;
                }
                layer.msg('启用失败', {time: 2500, icon:6});

            },
            error : function(req) {console.log("我出错了"+req);}
        });
    });
    
    
    $("#btn_update").click(function(){
    	var rows = $("#treegrid").jqxTreeGrid("getCheckedRows");
		if(rows.length < 1 ){
			layer.msg('请选择一行数据', {time: 2500, icon:6});
			return ;
		}
		if(rows.length >1){
			layer.msg('数据选择不要过多', {time: 2500, icon:6});
			return ;
		}
		showUpdateModal(rows);
		$("#updateRecord").click(function(){
			var data = $("#updateForm").serialize();
			$.ajax({
                url: "resource/updateParentIdTx.action",
                dataType: "json",
                type: "post",
                data: data,
                success: function (req){
                    if (req) {
                        $('#updateModal').modal('hide');
                        layer.msg('修改成功', {time: 2500, icon:6});
                        jqxTreeGrid();
                    } else {
                    	layer.msg('修改失败', {time: 2500, icon:6});
                    }
                },
                error: function(req){layer.msg('未知错误', {time: 2500, icon:6});}
            });
		});
    });
    
});

function showUpdateModal(rows){
	$("#resourceId").val(rows[0].resourceId);
	$("#resourceName2").val(rows[0].resourceName);
	$("#keyword").val(rows[0].keyword);
	$("#parentId").val(rows[0].parentId);
	$("#parentName").val(rows[0].parentName);
	$("#resourceType2").val(rows[0].resourceType);
	$("#resourceUrl").val(rows[0].resourceUrl);
	$("#description").val(rows[0].description);
	$("#indexs2").val(rows[0].indexs);
	$('#updateModal').modal('show');
}

function jqxTreeGrid(){
	var resourceName = $("#resourceName").val();
	var indexs = $("#indexs").val();
	var resourceType = $("#resourceType").val();
	var parentResourceName = $("#parentResourceName").val();
	var source =
    {
        dataType: "json",
        data:{"resourceName":resourceName,"indexs":indexs,"resourceType":resourceType,"parentResourceName":parentResourceName},
        dataFields: [
            { name: "resourceId", type: "string" },
            { name: "resourceName", type: "string" },
            { name: "keyword", type: "string" },
            { name: "parentId", type: "string" },
            { name: "parentName", type: "string" },
            { name: "resourceType", type: "string" },
            { name: "resourceUrl", type: "string" },
            { name: "description", type: "string" },
            { name: "indexs", type: "integer" },
            { name: "useable", type: "string" }
        ],
        hierarchy:
        {
            keyDataField: { name: 'resourceId' },
            parentDataField: { name: 'parentId' }
        },
        id: 'resourceId',
        url: 'resource/findAll.action'
    };
    var dataAdapter = new $.jqx.dataAdapter(source);
    $("#treegrid").jqxTreeGrid(
    {
    	height: '408', //自定义表格的高度
        width: document.body.clientWidth-50,
        source: dataAdapter,
        sortable: true,
        theme: 'energyblue',
        pageable: true,
        pageSize:12,
        pagerPosition:"bottom",
        ready: function()
        {
            $("#treegrid").jqxTreeGrid('expandRow', '3');
        },
        hierarchicalCheckboxes:true,
        checkboxes: true,
        columns: [
          { text: '资源Id', dataField: 'resourceId',width:200},
		      { text: '资源名', dataField: 'resourceName',width:100},
		      { text: '关键字', dataField: 'keyword',width:65},
		      { text: '父ID', dataField: 'parentId',width:160},
		      { text: '父子源名', dataField: 'parentName',width:100},
		      { text: '资源级别', dataField: 'resourceType',width:150},
		      { text: '资源路径', dataField: 'resourceUrl',width:140},
		      { text: '描述', dataField: 'description',width:140},
		      { text: '索引', dataField: 'indexs',width:100},
		      { text: '可用(Y/N)', dataField: 'useable',width:75}
        ]
    });
}

</script>
</html>
