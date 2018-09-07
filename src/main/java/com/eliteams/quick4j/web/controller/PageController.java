package com.eliteams.quick4j.web.controller;

import com.eliteams.quick4j.web.model.Device;
import com.eliteams.quick4j.web.model.Engineer;
import com.eliteams.quick4j.web.model.Job;
import com.eliteams.quick4j.web.model.JobExample;
import com.eliteams.quick4j.web.service.DeviceService;
import com.eliteams.quick4j.web.service.EngineerService;
import com.eliteams.quick4j.web.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

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
        List<Device> list = deviceService.getDevices();
        ModelAndView mav=new ModelAndView("deviceManager");
        mav.addObject("devices", list);
        return mav;
    }


    @RequestMapping("/mainInfo")
    public ModelAndView mainInfo() {
        int deviceCount = deviceService.getDeviceCount();
        int invalidDeviceCount = deviceService.getDeviceCountByState(1);
        ModelAndView mav=new ModelAndView("mainInfo");
        mav.addObject("deviceCount", deviceCount);
        mav.addObject("invalidDeviceCount", invalidDeviceCount);

        return mav;
    }

    @RequestMapping(value = "/adddevice", method = RequestMethod.POST)
    public ModelAndView adddevice(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("company") String company,
                          @RequestParam("deliverytime") String deliverytime, @RequestParam("endtime") String endtime) {
        Device device = new Device();
        device.setName(name);
        deviceService.insert(device);
        List<Device> list = deviceService.getDevices();
        ModelAndView mav=new ModelAndView("deviceManager");
        mav.addObject("devices", list);
        return mav;
    }

    @RequestMapping("/engineerManager")
    public ModelAndView engineerManager() {
        List<Engineer> locallist = engineerService.getLocalEngineers();
        List<Engineer> remotelist = engineerService.getRemoteEngineers();
        ModelAndView mav=new ModelAndView("engineerManager");
        mav.addObject("localengineers", locallist);
        mav.addObject("remoteengineers", remotelist);
        return mav;
    }

    @RequestMapping(value = "/addlocalengineer", method = RequestMethod.POST)
    public ModelAndView adddlocalengineer(@RequestParam("name") String name, @RequestParam("headimg") String headimg, @RequestParam("number") String number, @RequestParam("company") String company,
                                  @RequestParam("partment") String partment, @RequestParam("level") String level) {
        return addengineer(name, headimg, number, company, partment, level, 0);

    }

    @RequestMapping(value = "/addremoteengineer", method = RequestMethod.POST)
    public ModelAndView adddremoteengineer(@RequestParam("name") String name, @RequestParam("headimg") String headimg, @RequestParam("number") String number, @RequestParam("company") String company,
                                          @RequestParam("partment") String partment, @RequestParam("level") String level) {
        return addengineer(name, headimg, number, company, partment, level, 1);
    }

    private ModelAndView addengineer(String name, String headimg, String number, String company,
                                     String partment, String level, int type) {
        Engineer engineer = new Engineer();
        engineer.setName(name);
        engineer.setHeadimg(headimg);
        engineer.setPartment(partment);
        engineer.setLevel(1);
        engineer.setType(type);
        engineerService.insert(engineer);
        List<Engineer> locallist = engineerService.getLocalEngineers();
        List<Engineer> remotelist = engineerService.getRemoteEngineers();
        ModelAndView mav=new ModelAndView("engineerManager");
        mav.addObject("localengineers", locallist);
        mav.addObject("remoteengineers", remotelist);
        return mav;
    }

    @RequestMapping("/historyJobManager")
    public ModelAndView historyJobManager() {
        List<Job> joblist = jobService.getHistoryJobs();
        ModelAndView mav=new ModelAndView("jobManager");
        mav.addObject("jobList", joblist);
        return mav;
    }

    @RequestMapping("/todoJobManager")
    public ModelAndView todoJobManager() {
        List<Job> joblist = jobService.getTodoJobs();
        ModelAndView mav=new ModelAndView("jobManager");
        mav.addObject("jobList", joblist);
        return mav;
    }

    @RequestMapping(value = "/addjob", method = RequestMethod.POST)
    public ModelAndView addjob(
//                        @RequestParam("type") String type, @RequestParam("device") String device, @RequestParam("devicecode") String devicecode,
//                       @RequestParam("company") String company, @RequestParam("desc") String desc, @RequestParam("localengineer") String localengineer,
//                       @RequestParam("remoteengineer") String remoteengineer, @RequestParam("devicestate") String devicestate,
//                       @RequestParam("finishtime") String finishtime
            @RequestParam("desc") String desc
                    ) {
        Job job = new Job();
        job.setCreateTime(new Date());
        job.setDescription(desc);
        job.setJobstate(1);
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

}