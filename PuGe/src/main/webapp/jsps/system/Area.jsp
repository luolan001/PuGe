<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
    <title>区域表</title>
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="../../layer-v3.1.1/layer/mobile/need/layer.css" rel="stylesheet" type="text/css">
   	<link rel="stylesheet" href="../../bootstrap-3.3.7-dist/toastr/toastr.min.css">
    <script src="../../bootstrap-3.3.7-dist/toastr/toastr.min.js"></script>
    <link rel="stylesheet" href="../../bootstrap-3.3.7-dist/sweetalert/sweetalert.css">
    <script src="../../bootstrap-3.3.7-dist/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript"  src="../../bootstrap-3.3.7-dist/jquery_3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script  type="text/javascript" src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
    <script type="text/javascript" src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="../../layer-v3.1.1/layer/layer.js"></script>
 	<script type="text/javascript" src="../../js/system/Area.js"></script>
    
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
				    <label for="exampleInputEmail2">省份：</label>
				    <input type="text" class="form-control" id="provinces" placeholder="省份">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail2">城市：</label>
				    <input type="text" class="form-control" id="citys" placeholder="城市">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail2">区(县)：</label>
				    <input type="text" class="form-control" id="countys" placeholder="区(县)">
				  </div>
				  <button type="button" class="btn glyphicon glyphicon-search" id="btn_search_b">查询</button>
				  <button type="button" class="btn glyphicon glyphicon-pencil" id="btn_add">添加记录</button>
				  <!-- <button type="button" class="btn glyphicon glyphicon-ban-circle" id="btn_delete">操作</button> -->
				  <button type="button" class="btn glyphicon glyphicon-log-in" id="btn_add">导入</button>
				  <button type="button" class="btn glyphicon glyphicon-log-out" id="btn_add">导出</button>
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
                        <div class="form-group" hidden="true">
                            <label for="txt_areaId">区域Id</label>
                            <input type="text" name="areaId" data-bind="value:areaId" class="form-control"
                                   id="txt_areaId"
                                   placeholder="区域Id">
                        </div>
                        <div class="form-group">
                            <label for="txt_province">省份</label>
                            <input type="text" name="province" data-bind="value:province" class="form-control"
                                   id="txt_province"
                                   placeholder="省份">
                        </div>
                        <div class="form-group">
                            <label for="txt_city">市</label>
                            <input type="text" name="city" data-bind="value:city" class="form-control"
                                   id="txt_city"
                                   placeholder="市">
                        </div>
                        <div class="form-group">
                            <label for="txt_county">县(区)</label>
                            <input type="text" name="county" data-bind="value:county" class="form-control"
                                   id="txt_county"
                                   placeholder="县(区)">
                        </div>
                        <div class="form-group">
                            <label for="txt_postCode">邮政编码</label>
                            <input type="text" name="postCode" data-bind="value:postCode" class="form-control"
                                   id="txt_postCode"
                                   placeholder="邮政编码">
                        </div>
                        <div class="form-group">
                            <label for="txt_simpleCode">简码</label>
                            <input type="text" name="simpleCode" data-bind="value:simpleCode" class="form-control"
                                   id="txt_simpleCode"
                                   placeholder="简码">
                        </div>
                        <div class="form-group">
                            <label for="txt_cityCode">城市简码</label>
                            <input type="text" name="cityCode" data-bind="value:cityCode" class="form-control"
                                   id="txt_cityCode"
                                   placeholder="城市简码">
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
                            <div class="form-group" hidden="hidden">
                            	<label for="txt_areaId">区域Id</label>
                                <input type="text" class="form-control"  name="areaId" id="areaId"
                                placeholder="区域Id">
                            </div>
                            <div class="form-group">
                            	<label for="txt_province">省份</label>
                                <input type="text" class="form-control" name="province" id="province"
                                placeholder="省份">
                            </div>
                            <div class="form-group">
                            	<label for="txt_city">市</label>
                                <input type="text" class="form-control" name="city" id="city"
                                placeholder="市">
                            </div>
                            <div class="form-group">
                            	<label for="txt_county">县(区)</label>
                                <input type="text" class="form-control" name="county" id="county"
                                placeholder="县(区)">
                            </div>
                            <div class="form-group">
                            	<label for="txt_postCode">邮政编码</label>
                                <input type="text" class="form-control" name="postCode" id="postCode"
                                placeholder="邮政编码">
                            </div>
                            <div class="form-group">
                            	<label for="txt_simpleCode">简码</label>
                                <input type="text" class="form-control" name="simpleCode" id="simpleCode"
                                placeholder="简码">
                            </div>
                            <div class="form-group">
                            	<label for="txt_cityCode">城市简码</label>
                                <input type="text" class="form-control" name="cityCode" id="cityCode"
                                placeholder="城市简码">
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

</body>
</html>
