<%@ page language="java" pageEncoding="utf-8"%>
<div class="row">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat blue">
            <div class="visual">
                <i class="fa fa-comments"></i>
            </div>
            <div class="details">
                <div class="number">${deviceCount}</div>
                <div class="desc">当前名下设备数量</div>
            </div>
            <a class="more" href="#"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat green">
            <div class="visual">
                <i class="fa fa-shopping-cart"></i>
            </div>
            <div class="details">
                <div class="number">${invalidDeviceCount}</div>
                <div class="desc">设备状态异常数量</div>
            </div>
            <a class="more" href="#"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat purple">
            <div class="visual">
                <i class="fa fa-globe"></i>
            </div>
            <div class="details">
                <div class="number">${finishJobCount}</div>
                <div class="desc">累计已完成工单数量</div>
            </div>
            <a class="more" href="#"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat yellow">
            <div class="visual">
                <i class="fa fa-bar-chart-o"></i>
            </div>
            <div class="details">
                <div class="number">${todoJobCount}</div>
                <div class="desc">待完成工单数量</div>
            </div>
            <a class="more" href="#"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
</div>
