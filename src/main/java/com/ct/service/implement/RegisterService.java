package com.ct.service.implement;

import com.ct.entity.Invoice;
import com.ct.entity.Patient;
import com.ct.entity.RegInfo;
import com.ct.exception.ResultException;
import com.ct.mapper.ChargeMapper;
import com.ct.mapper.RegisterMapper;
import com.ct.result.ResultCode;
import com.ct.service.inf.RegisterInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterService implements RegisterInterface{

   @Autowired
   private RegisterMapper registerMapper;

   @Autowired
   private ChargeMapper chargeMapper;


    //获取系统当前的时间yyyy-MM-dd 转为sql.data
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    java.sql.Date DateSql = java.sql.Date.valueOf(date.format(formatter));


//添加病人信息
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public Object test(String name, int sex, int age, Date birthDate, String address, String identityID){
        Patient patient = new Patient(name, 0, sex, birthDate, address, identityID,age);

        int newMedRec=-1;
        try {
            registerMapper.newPatient(patient);
        }catch (Exception e){
            return new ResultException(ResultCode.INSERT_FAIL);
        }
        newMedRec = registerMapper.getMedRecIDByIdentity(identityID);

        patient.setIdentityID(identityID);

        System.out.println("newMedRec "+newMedRec);
        return patient;
    }




//添加发票
    private Invoice addInvoice(int invoiceCode, int isNeedBook, int regLevelID,int operatorID, int regID){
        Invoice newInvoice = new Invoice();


        BigDecimal regLevelFee_bigDecimal =registerMapper.getRegLevelFee(regLevelID);
        BigDecimal bookFee_bigDecimal = new BigDecimal(Double.toString(isNeedBook));
        newInvoice.setAccount(regLevelFee_bigDecimal.add(bookFee_bigDecimal));


        newInvoice.setInvoiceCode(invoiceCode);
        newInvoice.setMedRecID(regID);
        newInvoice.setOperatorID(operatorID);
        newInvoice.setCheckStatus(0);
        newInvoice.setStatus(1);

        newInvoice.setOperationTime(DateSql);
        //获取当前系统日期


         chargeMapper.addInvoice(newInvoice);



        return newInvoice;


    }

   //通过身份证自动获取患者信息
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public Patient getPatientInfoByIdentity(String identityID) {
        Patient patient = registerMapper.getPatientByIdentity(identityID);
        if (patient==null)
            throw new ResultException(ResultCode.PATIENT_NOT_EXIST);
       return patient;
    }

    //添加挂号信息


    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public RegInfo insertRegInfo(int docID, int deptID, int medRecID, String noonType, int isNeedBook, Date diagTime,int regLevelID,int operatorID, String name, int sex, int age, Date birthDate, String address, String identityID,int invoiceCode) {
       //获得到了docID、deptID、regID、regFee
        int newMedRec  = medRecID;
        if (medRecID == -1) {

            Patient patient = new Patient(name, medRecID, sex, birthDate, address, identityID,age);

            try {
                registerMapper.newPatient(patient);
            }catch (Exception e){
                throw  new ResultException(ResultCode.INSERT_FAIL);
            }

            //获取新插入患者的病历号；
            newMedRec = registerMapper.getMedRecIDByIdentity(identityID);

            patient.setIdentityID(identityID);

            System.out.println("newMedRec "+newMedRec);

        }

        RegInfo regInfo = new RegInfo();

        regInfo.setDeptID(deptID);
        regInfo.setDiagTime(diagTime);
        regInfo.setDocID(docID);
        regInfo.setIsNeedBook(isNeedBook);
        regInfo.setMedRecID(newMedRec);
        regInfo.setNoonType(noonType);
        regInfo.setOperatorID(operatorID);
        regInfo.setRegTime(DateSql);//当前系统时间
        regInfo.setRegLevelID(regLevelID);
        //计算挂号费用
        BigDecimal regLevelFee_bigDecimal =registerMapper.getRegLevelFee(regLevelID);
        BigDecimal bookFee_bigDecimal = new BigDecimal(Integer.toString(isNeedBook));

        regInfo.setRegFee(regLevelFee_bigDecimal.add(bookFee_bigDecimal));
        regInfo.setStatus(1);//挂号状态：已挂号


        int id;

        try{
             registerMapper.insertRegInfo(regInfo);
             addInvoice(invoiceCode,isNeedBook,regLevelID,operatorID,newMedRec);


        }catch (Exception e){
            throw new ResultException(ResultCode.INSERT_FAIL);
        }
        //regInfo.setId(id);

        return regInfo;
        //获取系统当前的时间yyyy-MM-dd
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        java.sql.Date DateSql = java.sql.Date.valueOf(date.format(formatter));
        //regInfo.setRegTime(DateSql);//添加当前操作的时间

//        System.out.println(DateSql+date.format(formatter));
       // registerMapper.insertRegInfo(regInfo);


    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public Map<String, List<Object>> getDisplayItems() {
        Map<String,List<Object>> stringListMap = new HashMap<>();//最后返回的值
        Map<String,List<Object>> NameValueMap = new HashMap<>();//处理显示数据value：id name ：name
        stringListMap.clear();
        NameValueMap.clear();
        //获取从数据库数据
        List<Object> list1 = registerMapper.getAllDept();
        List<Object> list2 = registerMapper.getAllDoc();
        List<Object> list3 = registerMapper.getAllRegLevel();

        stringListMap.put("departments",list1);
        stringListMap.put("doctors",list2);
        stringListMap.put("regLevels",list3);

        if(stringListMap==null)
            throw new ResultException(ResultCode.DATA_READ_ERROR);

        return stringListMap;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Object> getDocsByDept(String name) {
        return registerMapper.getDocsByDeptName(name);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public Patient getPatientInfoByID(int medRecID){
        Patient patient = registerMapper.getPatient(medRecID);
        if (patient==null){
            throw new ResultException(ResultCode.USER_NOT_EXIST);
        }
        return patient;
    }



}
