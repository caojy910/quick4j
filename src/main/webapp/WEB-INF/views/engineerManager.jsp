<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.eliteams.quick4j.web.dao.DeviceMapper" %>
<%@ page import="com.eliteams.quick4j.web.model.DeviceExample" %>
<%@ page language="java" pageEncoding="utf-8"%>
<div class="app-ticket app-ticket-list">
    <div class="row">
        <div class="col-md-12">
            <div class="portlet light ">
                <div class="portlet-title tabbable-line">
                    <div class="caption caption-md">
                        <i class="icon-globe theme-font hide"></i>
                        <span class="caption-subject font-blue-madison bold uppercase">工程师列表</span>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <a id="sample_editable_1_new" class="btn sbold green" href="#addlocalengineer" data-toggle="modal"> 添加现场工程师
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group pull-right">
                                    <button class="btn green  btn-outline dropdown-toggle" data-toggle="dropdown">Tools
                                        <i class="fa fa-angle-down"></i>
                                    </button>
                                    <ul class="dropdown-menu pull-right">
                                        <li>
                                            <a href="javascript:;">
                                                <i class="fa fa-print"></i> Print </a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                <i class="fa fa-file-pdf-o"></i> Save as PDF </a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                <i class="fa fa-file-excel-o"></i> Export to Excel </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="addlocalengineer" tabindex="-1" role="addlocalengineer" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal Title</h4>
                                </div>
                                <div class="modal-body">
                                    <script type="text/javascript">
                                        function sub() {
                                            // jquery 表单提交
                                            $("#addlocalengineersub").submit(function(message) {
                                                // 对于表单提交成功后处理，message为返回内容
                                            });

                                            return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
                                        }
                                    </script>
                                    <form id="addlocalengineersub" class="form-horizontal form-bordered" action="rest/page/addlocalengineer" enctype="multipart/form-data" method="post" target="id_iframe">
                                        <div class="form-body">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">姓名</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" maxlength="25" name="name" id="name">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">头像</label>
                                                <div class="col-md-7">
                                                    <%--<input type="text" class="form-control" maxlength="25" name="headimg" id="headimg">--%>
                                                    <input type="file" class="form-control" name="headimg" id="headimg" accept="image/jpeg,image/png">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">系统工号</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" maxlength="25" name="number" id="number">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">所属企业</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="company" id="company">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">所属部门</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="partment" id="partment">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">级别</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="level" id="level">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-actions">
                                            <div class="row">
                                                <div class="col-md-offset-3 col-md-9">
                                                    <button class="btn green" type="submit">
                                                        <i class="fa fa-check"></i> Submit</button>
                                                    <a href="javascript:;" class="btn btn-outline grey-salsa" data-dismiss="modal">Cancel</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>

                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                        <thead>
                        <tr>
                            <th>
                                <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                    <input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" />
                                    <span></span>
                                </label>
                            </th>
                            <th> 系统工号 </th>
                            <th> 姓名 </th>
                            <th> 头像 </th>
                            <th> 所属企业 </th>
                            <th> 所属部门 </th>
                            <th> 级别 </th>
                        </tr>
                        </thead>
                        <tbody>
                                <c:forEach items="${localengineers}" var="engineer">
                                    <tr class="odd gradeX">
                                        <td>
                                            <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                                <input type="checkbox" class="checkboxes" value="1" />
                                                <span></span>
                                            </label>
                                        </td>
                                        <td>${engineer.id}</td>
                                        <td>${engineer.name}</td>
                                        <td>${engineer.headimg}</td>
                                        <td>${engineer.companyid}</td>
                                        <td>${engineer.partment}</td>
                                        <td>${engineer.level}</td>
                                    </tr>
                                </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <a id="sample_editable_2_new" class="btn sbold green" href="#addremoteengineer" data-toggle="modal"> 添加专家工程师
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group pull-right">
                                    <button class="btn green  btn-outline dropdown-toggle" data-toggle="dropdown">Tools
                                        <i class="fa fa-angle-down"></i>
                                    </button>
                                    <ul class="dropdown-menu pull-right">
                                        <li>
                                            <a href="javascript:;">
                                                <i class="fa fa-print"></i> Print </a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                <i class="fa fa-file-pdf-o"></i> Save as PDF </a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                <i class="fa fa-file-excel-o"></i> Export to Excel </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="addremoteengineer" tabindex="-1" role="addremoteengineer" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal Title</h4>
                                </div>
                                <div class="modal-body">
                                    <script type="text/javascript">
                                        function sub() {
                                            // jquery 表单提交
                                            $("#addlocalengineersub").submit(function(message) {
                                                // 对于表单提交成功后处理，message为返回内容
                                            });

                                            return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
                                        }
                                    </script>
                                    <form id="addremoteengineersub" class="form-horizontal form-bordered" action="rest/page/addremoteengineer" enctype="multipart/form-data" method="post" target="id_iframe_1">
                                        <div class="form-body">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">姓名</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" maxlength="25" name="name" id="name1">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">头像</label>
                                                <div class="col-md-7">
                                                    <%--<input type="text" class="form-control" maxlength="25" name="headimg" id="headimg1">--%>
                                                    <input type="file" class="form-control" name="headimg" id="headimg1" accept="image/jpeg,image/png">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">系统工号</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" maxlength="25" name="number" id="number1">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">所属企业</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="company" id="company1">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">所属部门</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="partment" id="partment1">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">级别</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="level" id="level1">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-actions">
                                            <div class="row">
                                                <div class="col-md-offset-3 col-md-9">
                                                    <button class="btn green" type="submit">
                                                        <i class="fa fa-check"></i> Submit</button>
                                                    <a href="javascript:;" class="btn btn-outline grey-salsa" data-dismiss="modal">Cancel</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <iframe id="id_iframe_1" name="nm_iframe" style="display:none;"></iframe>

                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_2">
                        <thead>
                        <tr>
                            <th>
                                <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                    <input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" />
                                    <span></span>
                                </label>
                            </th>
                            <th> 系统工号 </th>
                            <th> 姓名 </th>
                            <th> 头像 </th>
                            <th> 所属企业 </th>
                            <th> 所属部门 </th>
                            <th> 级别 </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${remoteengineers}" var="engineer">
                            <tr class="odd gradeX">
                                <td>
                                    <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                        <input type="checkbox" class="checkboxes" value="1" />
                                        <span></span>
                                    </label>
                                </td>
                                <td>${engineer.id}</td>
                                <td>${engineer.name}</td>
                                <td>${engineer.headimg}</td>
                                <td>${engineer.companyid}</td>
                                <td>${engineer.partment}</td>
                                <td>${engineer.level}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<script src="assets/pages/scripts/profile.min.js" type="text/javascript"></script>
<script src="assets/pages/scripts/table-datatables-managed.js" type="text/javascript"></script>