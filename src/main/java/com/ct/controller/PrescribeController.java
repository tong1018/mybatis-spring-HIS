package com.ct.controller;


import com.ct.model.PresDetailsModel;
import com.ct.model.PrescribeModel;
import com.ct.result.Result;
import com.ct.result.ResultCode;
import com.ct.service.implement.PrescribeService;
import com.ct.utils.ResultUtil;
import com.ct.utils.annotations.CurrentUserID;
import com.ct.utils.annotations.UserLogin;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/his_prescribe")
public class PrescribeController {
    @Resource
    PrescribeService prescribeService;

    @GetMapping("/getAllDrugs")
    public Result getAllDrugs(){
        return ResultUtil.success(prescribeService.getAllDrugs());
    }

    @GetMapping("/getPrescription")
    public Result getPrescription(int regID){
        return ResultUtil.success(prescribeService.getPrescribe(regID));
    }

    @UserLogin
    @PostMapping("/addPrescribe")
    public Result addPrescribe(@CurrentUserID int id, @RequestBody PrescribeModel prescribeModel){
        return ResultUtil.success(prescribeService.addPrescribe(prescribeModel,id));
    }

    @GetMapping("/delPrescribe")
    public Result delPrescribe(int id){
        prescribeService.delPrescribe(id);
        return ResultUtil.success(ResultCode.SUCCESS,"删除成功");
    }

    @GetMapping("/subPrescribe")
    public Result subPrescribe(int id){
        prescribeService.subPrescribe(id);
        return ResultUtil.success(ResultCode.SUCCESS,"开立成功");
    }

    @GetMapping("/trashPrescribe")
    public Result trashPrescribe(int id){
        prescribeService.trashPrescribe(id);
        return ResultUtil.success(ResultCode.SUCCESS,"处方已作废");
    }

    @GetMapping("/getPrescribeDetails")
    public Result getPrescribeDetails(int id){
        //prescribeService.getPrescribeDetails(id);
        return ResultUtil.success(prescribeService.getPrescribeDetails(id));
    }

    @PostMapping("/addPresDetails")
    public Result addPresDetails(@RequestBody PresDetailsModel presDetailsModel){
        return ResultUtil.success(prescribeService.addPreDetails(presDetailsModel));
    }

    @GetMapping("/delPresDetail")
    public Result delPresDetails(int id){
        prescribeService.updatePresDetailStatus(id,"已删除");
        return ResultUtil.success(ResultCode.SUCCESS,"明细已删除");
    }

    @GetMapping("/subPresDetail")
    public Result subPresDetails(int preid){
        prescribeService.updatePresDetailStatus(preid,"已开立");
        return ResultUtil.success(ResultCode.SUCCESS,"明细已开立");
    }


}
