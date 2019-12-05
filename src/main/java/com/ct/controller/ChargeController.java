package com.ct.controller;


import com.ct.entity.HisUser;
import com.ct.model.ChargeModel;
import com.ct.model.PayModel;
import com.ct.result.Result;
import com.ct.result.ResultCode;
import com.ct.service.implement.ChargeService;
import com.ct.utils.ResultUtil;
import com.ct.utils.annotations.CurrentUser;
import com.ct.utils.annotations.CurrentUserID;
import com.ct.utils.annotations.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/his_charges")
public class ChargeController {

    @Autowired
    ChargeService chargeService;

    @UserLogin
    @PostMapping("/addCharge")
    public Result addCharge(@CurrentUser HisUser user, @RequestBody ChargeModel chargeModel){
        return ResultUtil.success(chargeService.addCharge(chargeModel,user));
    }

    @GetMapping("/getTotal")
    public Result getCountPrice(int medRecID){
        return ResultUtil.success(chargeService.getCountPrice(medRecID));
    }

    @GetMapping("/getCharges")
    public Result getCharges(int medRecID){
        return ResultUtil.success(chargeService.getCharges(medRecID));
    }

    @UserLogin
    @GetMapping("/addInvoice")
    public Result addInvoice(@CurrentUserID int operatorID, int invoiceCode, int medRecID){
        BigDecimal account1 = new BigDecimal("324");
        return ResultUtil.success(chargeService.addInvoice(operatorID,account1,invoiceCode, medRecID));
    }

    @PostMapping("/test")
    public void test(@RequestBody PayModel testModel) {
        List<Integer> list = testModel.getList();
    }

    @UserLogin
    @PostMapping("/paycharge")
    public Result payCharges(@CurrentUserID int userID,@RequestBody PayModel payModel){
        chargeService.payCharge(payModel,userID);
        return ResultUtil.success(ResultCode.SUCCESS,"缴费成功");
    }
}
