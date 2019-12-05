package com.ct.controller;

import com.ct.model.HrHomePageModel;
import com.ct.result.Result;
import com.ct.result.ResultCode;
import com.ct.service.implement.ConsultService;
import com.ct.utils.ResultUtil;
import com.ct.utils.annotations.CurrentUserID;
import com.ct.utils.annotations.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/his_consult")
public class ConsultController {

    @Autowired
    ConsultService consultService;

    @UserLogin
    @PostMapping("/get_non_consult_patient")
    public Result getNonConsultPatients(@CurrentUserID int userID){
        return ResultUtil.success(consultService.getNonConsultPatients(userID));
    }

    @UserLogin
    @PostMapping("/get_consulted_patient")
    public Result getConsultedPatients(@CurrentUserID int userID){
        System.out.println(userID);
        return ResultUtil.success(consultService.getConsultedPatients(userID));
    }

    @UserLogin
    @PostMapping("/addmrhomepage")
    public Result addHrHomePage(@CurrentUserID int userID, @RequestBody HrHomePageModel hrHomePageModel){
        System.out.println(userID);
        return ResultUtil.success(consultService.addHrHomePage(hrHomePageModel,userID));
    }

    @GetMapping("/consulted")
    public Result consulted(int regID){
        consultService.patientToConsulted(regID);
        return ResultUtil.success(ResultCode.SUCCESS,"已诊断");
    }
}
