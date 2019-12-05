package com.ct.controller;

import com.ct.entity.RegInfo;
import com.ct.entity.Test;
import com.ct.model.RegInfoModel;
import com.ct.result.Result;
import com.ct.service.implement.RegisterService;
import com.ct.utils.ResultUtil;
import com.ct.utils.annotations.CurrentUserID;
import com.ct.utils.annotations.UserLogin;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/his_reg")
public class RegisterController {
    @Resource
    RegisterService registerService;


    /**
     * 通过前端填入身份证号码自动获取病历的基本信息；若没有提示新建
     * @param identityID
     * @return PatientInfo if null then提示新建
     */
    @GetMapping("/getpatientbyidentity")
    public Result getPatientByIdentityID(String identityID){
        return ResultUtil.success(registerService.getPatientInfoByIdentity(identityID));
    }

    @PostMapping("/test")
    public Result test(@RequestBody Test a){
//        Invoice invoice = registerService.addInvoice(invoiceModel.getInvoiceCode(),invoiceModel.getIsNeedBook(), invoiceModel.getRegLevelID(),invoiceModel.getOperatorID(),invoiceModel.getRegID());

       // return ResultUtil.success(registerService.test(patient.getName(),patient.getSex(),patient.getAge(),patient.getBirthDate(),patient.getAddress(),patient.getIdentityID()));
        return ResultUtil.success("fafafaaffa:::"+(a.getA()*2));
    }


    @UserLogin
    @PostMapping("/addRegInfo")
    public Result insertRegInfo(@CurrentUserID int userID , @RequestBody RegInfoModel regInfoModel){
        RegInfo regInfo = registerService.insertRegInfo(regInfoModel.getDocID(),regInfoModel.getDeptID(),regInfoModel.getMedRecID(),regInfoModel.getNoonType(),regInfoModel.getIsNeedBook(),regInfoModel.getDiagTime(),regInfoModel.getRegLevelID(),userID,regInfoModel.getName(),regInfoModel.getSex(),regInfoModel.getAge(),regInfoModel.getBirthDate(),regInfoModel.getAddress(),regInfoModel.getIdentityID(),regInfoModel.getInvoiceCode());
        return ResultUtil.success(regInfo);
    }


    /**
     * 获取展示网页的选项信息
     * @return department doctors regLevel
     */
    @PostMapping("/display")
    public Result display(){
        return ResultUtil.success(registerService.getDisplayItems());
    }

    /**
     * 通过部门获取其部门所有医生
     * @param name
     * @return
     */
    @GetMapping("/dept_doc")
    public List<Object> dept_doc(String name){
        return registerService.getDocsByDept(name);
    }

    @GetMapping("/getPatient")
    public Result getPatientByMed(int medRecID){
        return ResultUtil.success(registerService.getPatientInfoByID(medRecID));
    }


}
