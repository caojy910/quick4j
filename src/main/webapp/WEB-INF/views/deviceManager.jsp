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
                        <span class="caption-subject font-blue-madison bold uppercase">设备列表</span>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <a id="sample_editable_1_new" class="btn sbold green" href="#adddevice" data-toggle="modal"> 添加设备
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
                    <div class="modal fade" id="adddevice" tabindex="-1" role="adddevice" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal Title</h4>
                                </div>
                                <div class="modal-body">
                                    <form id="adddevicesub" class="form-horizontal form-bordered" action="rest/page/adddevice" method="post" onsubmit="return ajaxsubmitadddevice();">
                                        <div class="form-body">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">设备代码</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" maxlength="25" name="code" id="form_code">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">设备名称</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" maxlength="25" name="name" id="form_name">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">所属企业</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="company" id="form_company">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">交付时间</label>
                                                <div class="col-md-9">
                                                    <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
                                                        <input type="text" class="form-control" readonly="" name="deliverytime" id="form_deliverytime">
                                                        <span class="input-group-btn">
                                                            <button class="btn default" type="button">
                                                                <i class="fa fa-calendar"></i>
                                                            </button>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group last">
                                                <label class="control-label col-md-3">运维期限</label>
                                                <div class="col-md-9">
                                                    <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd">
                                                        <input type="text" class="form-control" readonly="" name="deliverytime" id="form_endtime">
                                                        <span class="input-group-btn">
                                                            <button class="btn default" type="button">
                                                                <i class="fa fa-calendar"></i>
                                                            </button>
                                                        </span>
                                                    </div>
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
                            <th> 设备代码 </th>
                            <th> 设备名称 </th>
                            <th> 所属企业 </th>
                            <th> 交付时间 </th>
                            <th> 运行状态 </th>
                            <th> 运维期限 </th>
                            <th> 设备品牌 </th>
                            <th> 设备型号 </th>
                            <th> 操作 </th>
                        </tr>
                        </thead>
                        <tbody>
                                <c:forEach items="${devices}" var="device">
                                    <tr class="odd gradeX">
                                        <td>
                                            <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                                <input type="checkbox" class="checkboxes" value="1" />
                                                <span></span>
                                            </label>
                                        </td>
                                        <td>${device.id}</td>
                                        <td>${device.name}</td>
                                        <td>${device.companyid}</td>
                                        <td>${device.deliverydate}</td>
                                        <td>${device.state}</td>
                                        <td>${device.enddate}</td>
                                        <td>${device.brand}</td>
                                        <td>${device.version}</td>
                                        <td><button id="device_update" onclick="modifydevice(this)">修改</button>
                                            <button id="device_delete" onclick="deletedevice(this)">删除</button></td>
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

<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>

<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>


<script src="assets/global/plugins/moment.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>


<script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
<script src="assets/pages/scripts/components-date-time-pickers.min.js" type="text/javascript"></script>

<script src="assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
