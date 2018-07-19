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
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap-validator_0.5.3_css_bootstrapValidator.css" rel="stylesheet" type="text/css">

    <script src="../../bootstrap-3.3.7-dist/jquery_3.2.1/jquery.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
    <script src="../../bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script src="../../layer-v3.1.1/layer/layer.js"></script>
	<script src="../../bootstrap-3.3.7-dist/js/bootstrap-validator_0.5.3_js_bootstrapValidator.js"></script>
	<script type="text/javascript" src="../../js/base/PickStandard.js"></script>
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
				    <label for="exampleInputEmail2">是否可用：</label>
				    <select class="form-control" id="useable">
					  <option value="" selected >全部</option>
					  <option value="Y">是</option>
					  <option value="N">否</option>
					</select>				  
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputEmail2">取派标准名：</label>
				    <input type="text" class="form-control" id="pickStandardName" placeholder="取派标准名">
				  </div>
				   <div class="form-group">
				    <label for="exampleInputEmail2">重量：</label>
				    <input type="text" class="form-control" id="minWeights" placeholder="最小重量">
				  </div>
				   <div class="form-group">
				    <label for="exampleInputEmail2">~</label>
				    <input type="text" class="form-control" id="maxWeights" placeholder="最大重量">
				  </div>
				  	<button type="button" class="btn btn-success glyphicon glyphicon-search" id="btn_search_b">查询</button>
				</form>
				<div>
					<button type="button" class="btn btn-primary glyphicon glyphicon-pencil" id="btn_add">添加记录</button>
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
                            <label for="txt_pickStandardName">取派标准名</label>
                            <input type="text" name="pickStandardName" data-bind="value:ordertime" class="form-control"
                                   id="txt_pickStandardName" placeholder="取派标准名">
                        </div>
                        <div class="form-group">
                            <label for="txt_minWeight">最小重量</label>
                            <input type="text" name="minWeight" data-bind="value:orderdescribe" class="form-control"
                                   id="txt_minWeight" placeholder="最小重量">
                        </div>
                        <div class="form-group">
                            <label for="txt_maxWeight">最大重量</label>
                            <input type="text" name="maxWeight" data-bind="value:orderdescribe" class="form-control"
                                   id="txt_maxWeight" placeholder="最大重量">
                        </div>
                        <div class="form-group">
                            <label for="txt_useable">是否可用</label>
                            <input type="text" name="useable" data-bind="value:orderuser" class="form-control"
                                   id="txt_useable" placeholder="是否可用">
                        </div>
                        <div class="form-group">
                            <label for="txt_description">描述</label>
                            <input type="text" name="description" data-bind="value:orderdescribe" class="form-control"
                                   id="txt_description" placeholder="描述">
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
                                <input type="text" class="form-control" name="pickStandardId" id="pickStandardId">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="pickStandardName" id="pickStandardName2"
                                placeholder="取派标准名">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="minWeight" id="minWeight"
                                placeholder="最小重量">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="maxWeight" id="maxWeight"
                                placeholder="最大重量">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="useable" id="useable2"
                                placeholder="是否可用">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="description" id="description"
                                placeholder="描述">
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
                        <button type="button" class="btn btn- primary" id="updateRecord">提交</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
