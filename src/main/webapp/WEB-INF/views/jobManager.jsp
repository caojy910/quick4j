<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
                        <span class="caption-subject font-blue-madison bold uppercase">工单列表</span>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="table-toolbar">
                        <div class="row">
                            <div class="col-md-6">
                                <shiro:hasAnyRoles name="super_admin,admin">
                                <div class="btn-group">
                                    <a id="sample_editable_1_new" class="btn sbold green" href="#addjob" data-toggle="modal"> 新建工单
                                        <i class="fa fa-plus"></i>
                                    </a>
                                </div>
                                </shiro:hasAnyRoles>
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
                    <div class="modal fade" id="addjob" tabindex="-1" role="addjob" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal Title</h4>
                                </div>
                                <div class="modal-body">
                                    <form id="addjobsub" class="form-horizontal form-bordered" action="rest/page/addjob" method="post" onsubmit="return ajaxsubmitaddjob();">
                                        <div class="form-body">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">工单类型</label>
                                                <div class="col-md-4">
                                                    <select name="type" id="form_job_type">
                                                        <option value="0">日常维护</option>
                                                        <option value="1">设备维修</option>
                                                    </select>
                                                    <%--<input type="text" class="form-control" maxlength="25" name="type" id="form_job_type">--%>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">设备名称</label>
                                                <div class="col-md-4">
                                                    <select name="device" id="form_job_device">
                                                        <c:forEach items="${devices}" var="device">
                                                            <option value="${device.id}">${device.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <%--<input type="text" class="form-control" maxlength="25" name="device" id="form_job_device">--%>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">设备代码</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" maxlength="25" name="devicecode" id="form_job_devicecode">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">所属企业</label>
                                                <div class="col-md-9">
                                                    <select name="company" id="form_job_company">
                                                        <c:forEach items="${companies}" var="company">
                                                            <option value="${company.id}">${company.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <%--<input type="text" class="form-control" maxlength="25" name="company" id="form_job_company">--%>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">任务描述</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="desc" id="form_job_desc">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">分配的现场工程师</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="localengineer" id="form_job_localengineer">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">分配的专家工程师</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="remoteengineer" id="form_job_remoteengineer">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">设备状态</label>
                                                <div class="col-md-9">
                                                    <input type="text" class="form-control" maxlength="25" name="devicestate" id="form_job_devicestate">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3">计划完成时间</label>
                                                <div class="col-md-9">
                                                    <%--<script>--%>
                                                    <%--$(function() {--%>
                                                    <%--$('#date-picker').datepicker({--%>
                                                    <%--language: 'pt-BR'--%>
                                                    <%--});--%>
                                                    <%--});--%>
                                                    <%--</script>--%>
                                                    <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
                                                        <input type="text" class="form-control" readonly="" name="finishtime" id="form_job_finishtime">
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
                            <th> 工单号 </th>
                            <th> 创建时间 </th>
                            <th> 工单类型 </th>
                            <th> 设备名称 </th>
                            <th> 设备代码 </th>
                            <th> 所属企业 </th>
                            <th> 任务描述 </th>
                            <th> 现场工程师 </th>
                            <th> 专家工程师 </th>
                            <th> 设备状态 </th>
                            <%--<shiro:hasAnyRoles name="user">--%>
                                <th> 操作 </th>
                                <th> 记录 </th>
                            <%--</shiro:hasAnyRoles>--%>
                            <th> 远程协助 </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${jobList}" var="job">
                            <tr class="odd gradeX">
                                <td>
                                    <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                        <input type="checkbox" class="checkboxes" value="1" />
                                        <span></span>
                                    </label>
                                </td>
                                <td>${job.id}</td>
                                <td>${job.createTime}</td>
                                <td>${job.type}</td>
                                <td>${job.deciveid}</td>
                                <td>${job.deciveid}</td>
                                <td>${job.deciveid}</td>
                                <td>${job.description}</td>
                                <td>${job.localengineerName}</td>
                                <td>${job.remoteengineerName}</td>
                                <td>${job.jobStateName}</td>
                                <td><button id="job_operator" onclick="operateJob(this,${job.jobstate})">${job.oprationName}</button></td>
                                <td>
                                    <button id="job_showrecord" onclick="showjobrecord(this,${job.localengineerid})">查看</button>
                                    <button id="job_record" href="#jobrecord" data-toggle="modal" data-jobid=${job.id}>记录</button>
                                </td>
                                <td><a href="rest/page/rtc?jobid=${job.id}" target="_blank">开始协助</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="jobrecord" tabindex="-1" role="" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">Modal Title</h4>
            </div>
            <div class="modal-body">
                <form id="jobrecordsub" class="form-horizontal form-bordered" action="rest/page/addjobrecord" method="post" onsubmit="return ajaxsubmitaddjobrecord();">
                    <div class="form-body">
                        <div class="form-group">
                            <label class="control-label col-md-3">工单id</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" maxlength="25" name="desc" readonly id="form_job_id_unchanged">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">操作类型</label>
                            <div class="col-md-4">
                                <select name="type" id="form_job_optype">
                                    <option value="0">运维操作</option>
                                    <option value="1">更换耗材</option>
                                </select>
                                <%--<input type="text" class="form-control" maxlength="25" name="type" id="form_job_type">--%>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">操作内容</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" maxlength="25" name="desc" id="form_job_operate_content">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">操作时间</label>
                            <div class="col-md-9">
                                <div class="input-group input-medium date date-picker" data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
                                    <input type="text" class="form-control" readonly="" name="finishtime" id="form_job_operatetime">
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

<div id="dialogSelect" style="padding-top:20px;"></div>

<script src="assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<script src="assets/pages/scripts/profile.min.js" type="text/javascript"></script>
<script src="assets/pages/scripts/table-datatables-managed.js" type="text/javascript"></script>

<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>

<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>

<script src="assets/global/plugins/moment.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>


<script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
<script src="assets/pages/scripts/components-date-time-pickers.min.js" type="text/javascript"></script>

<script>
    $('#jobrecord').on('show.bs.modal', function (event) {
    var a = $(event.relatedTarget) // relatedTarget 事件属性返回与事件的目标节点相关的节点。
    var jobid = a.context.dataset.jobid;
    /*title = a.data('title'), description = a.data('description');*/
    var modal = $(this)
    modal.find('#form_job_id_unchanged').val(jobid);
    /* modal.find('#cm-modal-title').val(title);
    modal.find('#cm-modal-content').val(description);*/
    });
</script>