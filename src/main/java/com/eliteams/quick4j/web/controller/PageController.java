package com.eliteams.quick4j.web.controller;

import com.alibaba.druid.util.Base64;
import com.eliteams.quick4j.core.util.SessionUtils;
import com.eliteams.quick4j.web.model.*;
import com.eliteams.quick4j.web.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author StarZou
 * @since 2014年5月28日 下午4:00:49
 **/
@Controller
@RequestMapping("/page")
public class PageController {

    @Resource
    private DeviceService deviceService;
    @Resource
    private EngineerService engineerService;
    @Resource
    private JobService jobService;
    @Resource
    private UserService userService;
    @Resource
    private CompanyService companyService;
    @Resource
    private OprecordService oprecordService;

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * dashboard页
     */
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * dashboard页
     */
    @RequestMapping("/deviceManager")
    public ModelAndView deviceManager() {
        User user = (User) SessionUtils.getSession().getAttribute("userInfo");
        List<Device> list = deviceService.getDevices();
        setDeviceCompanyName(list);
        List<Company> companyList = companyService.getCompanyList();

        ModelAndView mav=new ModelAndView("deviceManager");
        mav.addObject("devices", list);
        mav.addObject("companies", companyList);
        return mav;
    }


    @RequestMapping("/mainInfo")
    public ModelAndView mainInfo() {
        int deviceCount = deviceService.getDeviceCount();
        int invalidDeviceCount = deviceService.getDeviceCountByState(1);
        int finishJobCount = jobService.getJobCountByType(0);
        int todoJobCount = jobService.getJobCountByType(1);
        ModelAndView mav=new ModelAndView("mainInfo");
        mav.addObject("deviceCount", deviceCount);
        mav.addObject("invalidDeviceCount", invalidDeviceCount);
        mav.addObject("finishJobCount", finishJobCount);
        mav.addObject("todoJobCount", todoJobCount);

        return mav;
    }

    @RequestMapping(value = "/adddevice", method = RequestMethod.POST)
    public ModelAndView adddevice(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("company") String company,
                          @RequestParam("deliverytime") String deliverytime, @RequestParam("endtime") String endtime) {
        Device device = new Device();
        device.setName(name);
        if (company != null)
            device.setCompanyid(Long.parseLong(company));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            device.setDeliverydate(sdf.parse(deliverytime));
            device.setEnddate(sdf.parse(endtime));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        User user = (User) SessionUtils.getRequest().getSession().getAttribute("userInfo");
        if (user != null && user.getCompanyid() != null)
            device.setCompanyid(user.getCompanyid());

        deviceService.insert(device);
        List<Device> list = deviceService.getDevices();
        setDeviceCompanyName(list);

        ModelAndView mav=new ModelAndView("deviceManager");
        mav.addObject("devices", list);
        return mav;
    }

    @RequestMapping("/engineerManager")
    public ModelAndView engineerManager() {
        List<Engineer> locallist = engineerService.getLocalEngineers();
        processEngineerList(locallist);
        List<Engineer> remotelist = engineerService.getRemoteEngineers();
        processEngineerList(remotelist);
        ModelAndView mav=new ModelAndView("engineerManager");
        mav.addObject("localengineers", locallist);
        mav.addObject("remoteengineers", remotelist);
        List<User> engineers = userService.getEngieerUsers();
        mav.addObject("allengineers", engineers);
        return mav;
    }

    @RequestMapping(value = "/getEngineerHeadImg", method = RequestMethod.POST)
    @ResponseBody
    public String getEngineerHeadImg(@RequestParam("engineerid") Long id) {
        byte[] headImg = engineerService.getHeadImgByEngieerId(id);
        return Base64.byteArrayToBase64(headImg);
    }

    @RequestMapping(value = "/addlocalengineer", method = RequestMethod.POST)
    public ModelAndView adddlocalengineer(@RequestParam("name") String name, @RequestParam("headimg") MultipartFile headimg, @RequestParam("number") String number, @RequestParam("company") String company,
                                          @RequestParam("partment") String partment, @RequestParam("level") String level) {
        return addengineer(name, headimg, number, company, partment, level, 0);

    }

    @RequestMapping(value = "/addremoteengineer", method = RequestMethod.POST)
    public ModelAndView adddremoteengineer(@RequestParam("name") String name, @RequestParam("headimg") MultipartFile headimg, @RequestParam("number") String number, @RequestParam("company") String company,
                                          @RequestParam("partment") String partment, @RequestParam("level") String level) {
        return addengineer(name, headimg, number, company, partment, level, 1);
    }

    private ModelAndView addengineer(String name, MultipartFile headimg, String number, String company,
                                     String partment, String level, int type) {
        Engineer engineer = new Engineer();
        engineer.setName(name);

        try {
            if (headimg != null && headimg.getBytes().length < 65535)
                engineer.setHeadimg(headimg.getBytes());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        engineer.setPartment(partment);
        engineer.setLevel(1);
        engineer.setType(type);
        engineerService.insert(engineer);
        List<Engineer> locallist = engineerService.getLocalEngineers();
        processEngineerList(locallist);
        List<Engineer> remotelist = engineerService.getRemoteEngineers();
        processEngineerList(remotelist);
        ModelAndView mav=new ModelAndView("engineerManager");
        mav.addObject("localengineers", locallist);
        mav.addObject("remoteengineers", remotelist);
        return mav;
    }

    @RequestMapping("/historyJobManager")
    public ModelAndView historyJobManager() {
        List<Job> joblist = jobService.getHistoryJobs();
        setJobEngineerName(joblist);
        List<Company> companyList = companyService.getCompanyList();
        List<Device> devices = deviceService.getDevices();

        ModelAndView mav=new ModelAndView("jobManager");
        mav.addObject("jobList", joblist);
        mav.addObject("companies", companyList);
        mav.addObject("devices", devices);
        return mav;
    }

    @RequestMapping("/todoJobManager")
    public ModelAndView todoJobManager() {
        List<Job> joblist = jobService.getTodoJobs();
        setJobEngineerName(joblist);
        List<Company> companyList = companyService.getCompanyList();
        List<Device> devices = deviceService.getDevices();

        ModelAndView mav=new ModelAndView("jobManager");
        mav.addObject("jobList", joblist);
        mav.addObject("companies", companyList);
        mav.addObject("devices", devices);
        return mav;
    }

    @RequestMapping("/doingJobManager")
    public ModelAndView doingJobManager() {
        List<Job> joblist = jobService.getDoingJobs();
        setJobEngineerName(joblist);
        List<Company> companyList = companyService.getCompanyList();
        List<Device> devices = deviceService.getDevices();

        ModelAndView mav=new ModelAndView("jobManager");
        mav.addObject("jobList", joblist);
        mav.addObject("companies", companyList);
        mav.addObject("devices", devices);
        return mav;
    }

    private void setJobEngineerName(List<Job> joblist) {
        if (joblist != null) {
            for (Job job : joblist) {
                if (job != null) {
                    if (job.getLocalengineerid() != null)
                        job.setLocalengineerName(getUserFullNameById(job.getLocalengineerid()));
                    if (job.getRemoteengineerid() != null)
                        job.setRemoteengineerName(getUserFullNameById(job.getRemoteengineerid()));
                }
            }
        }
    }

    private void setDeviceCompanyName(List<Device> list) {
        if (list != null) {
            for (Device deviceItem : list) {
                if (deviceItem != null && deviceItem.getCompanyid() != null) {
                    deviceItem.setCompanyName(companyService.getComanyNameById(deviceItem.getCompanyid()));
                }
            }
        }
    }

    private void processEngineerList(List<Engineer> engineerList) {
        if (engineerList != null) {
            for (Engineer engineer : engineerList) {
                if (engineer != null) {
//                    if (engineer.getId() != null)
//                        engineer.setName(getUserFullNameById(engineer.getId()));
                    if (engineer.getCompanyid() != null) {
                        engineer.setCompanyName(companyService.getComanyNameById(engineer.getCompanyid()));
                    }
                }
            }
        }
    }

    private String getUserFullNameById(Long id) {
        String name = userService.selectFullNameById(id);
        if (name == null)
            name = userService.selectUserNameById(id);
        if (name == null)
            name = id + "";
        return name;
    }

    @RequestMapping(value = "/addjob", method = RequestMethod.POST)
    public ModelAndView addjob(
                        @RequestParam("type") Integer type, @RequestParam("device") Long deviceid, @RequestParam("devicecode") String devicecode
                      , @RequestParam("company") Long companyid, @RequestParam("desc") String desc, @RequestParam("localengineer") String localengineer,
                       @RequestParam("remoteengineer") String remoteengineer, @RequestParam("finishtime") String finishtime
//            @RequestParam("desc") String desc
                    ) {
        Job job = new Job();
        job.setCreateTime(new Date());
        job.setDescription(desc);
        job.setDeciveid(deviceid);
        job.setCompanyid(companyid);
        job.setType(type);
        job.setJobstate(1);
        User user = (User) SessionUtils.getRequest().getSession().getAttribute("userInfo");
        if (user != null && user.getCompanyid() != null)
            job.setCompanyid(user.getCompanyid());
        jobService.insert(job);

        List<Job> joblist = jobService.getTodoJobs();
        ModelAndView mav=new ModelAndView("jobManager");
        mav.addObject("jobList", joblist);
        return mav;
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }


    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String registeruser(
            @RequestParam("username") String username, @RequestParam("password") String password) {
//        User user = userService.selectByUsername(username);
//        if (user != null)
//            return false;

        return "";
    }

    @RequestMapping(value = "/deletedevice", method = RequestMethod.POST)
    public void deletedevice(@RequestParam("deviceid") Long id) {
        deviceService.delete(id);
    }

    @RequestMapping(value = "/updatedevice", method = RequestMethod.POST)
    public void updatedevice(@RequestParam("deviceid") Long id, @RequestParam("name") String name, @RequestParam("company") String company,
                             @RequestParam("deliverytime") String deliverytime, @RequestParam("endtime") String endtime,
                             @RequestParam("status") int status) {
        Device device = new Device();
        device.setId(id);
        device.setName(name);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            device.setDeliverydate(sdf.parse(deliverytime));
            device.setEnddate(sdf.parse(endtime));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        device.setState(status);
        deviceService.update(device);
    }

    @RequestMapping("/rtc")
    public ModelAndView rtc(@RequestParam("jobid") String jobid) {
        ModelAndView mav=new ModelAndView("rtc");
        mav.addObject("initiator", 1);
        mav.addObject("roomLink", "");
        mav.addObject("roomKey", 111);
        mav.addObject("user", 1111);
        mav.addObject("jobid", jobid);
        return mav;
    }

    @RequestMapping("/rtc2")
    public ModelAndView rtc2() {
        ModelAndView mav=new ModelAndView("rtc2");
        mav.addObject("initiator", 1);
        mav.addObject("roomLink", "");
        mav.addObject("roomKey", 111);
        mav.addObject("user", 1111);
        return mav;
    }

    @RequestMapping("/getoprecord")
    @ResponseBody
    public Map<String, Object> getoprecord(@RequestParam("deviceid")  Long deviceid, HttpServletRequest request) {
        Map<String, Object> resultMap =  new HashMap<String,Object>();
        List<Oprecord> list = oprecordService.getOprecordListByDeviceId(deviceid, null);
        resultMap.put("result", list);
        return resultMap;
    }

    @RequestMapping("/getoprecordByEngineer")
    @ResponseBody
    public Map<String, Object> getoprecordByEngineer(@RequestParam("deviceid")  Long deviceid,
                                                     @RequestParam("engineerid")  Long engineerid, HttpServletRequest request) {
        Map<String, Object> resultMap =  new HashMap<String,Object>();
        List<Oprecord> list = oprecordService.getOprecordListByDeviceId(deviceid, engineerid);
        resultMap.put("result", list);
        return resultMap;
    }


    @RequestMapping(value = "/updatejobState", method = RequestMethod.POST)
    public void updatejobState(@RequestParam("jobid") Long id, @RequestParam("jobstate") int jobstate) {
        jobService.updateJobstateById(id, jobstate);
    }

    @RequestMapping(value = "/addjobrecord", method = RequestMethod.POST)
    public void addjobrecord(@RequestParam("jobid") Long jobid, @RequestParam("optype") int optype,
                             @RequestParam("opContent") String opContent, @RequestParam("optime") String optime) {
        Job job = jobService.selectById(jobid);
        Oprecord oprecord = new Oprecord();
        oprecord.setJobid(jobid);
        oprecord.setDeciveid(job.getDeciveid());
        oprecord.setOpcontent(opContent);
        oprecord.setType(optype);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            oprecord.setOpdate(sdf.parse(optime));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        oprecord.setOpengineer(job.getLocalengineerid());
        oprecordService.insert(oprecord);
    }
}