package com.omfine.controller;

import com.alibaba.fastjson.JSON;
import com.omfine.bean.*;
import com.omfine.bean.out.ClassificationData;
import com.omfine.service.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillApiController extends BaseController{

    @Resource
    private AccountBillService accountBillService = null;
    @Resource
    private PrimaryClassificationService primaryClassificationService = null;
    @Resource
    private SecondaryClassificationService secondaryClassificationService = null;
    @Resource
    private MerchantService merchantService = null;
    @Resource
    private MerchandiseService merchandiseService = null;
    @Resource
    private AccountBookService accountBookService = null;

    @RequestMapping("/addBill")
    public String addBill(AccountBill accountBill ,@RequestHeader("uniqueId") String uniqueId){
        System.err.println("=====收到数据===: " + JSON.toJSONString(accountBill) + "     uniqueId: " + uniqueId);

        accountBill.setCTime(System.currentTimeMillis());
        accountBill.setUid(10000000);
        accountBill.setUniqueId(uniqueId);
        int result = accountBillService.insert(accountBill);
        if (1 == result){
            //success
            AccountBill accountBillNew = accountBillService.selectOne(accountBill);
            return onSuccess(accountBillNew);
        }
        return onFailed("Failed to add new bill");
    }

    @RequestMapping("/getBill")
    public String getBill(){
        AccountBill accountBill = accountBillService.selectOne(new AccountBill());
        if (null == accountBill){
            return "No data found";
        }
        return JSON.toJSONString(accountBill);
    }

    @RequestMapping("/getBills")
    public String getBills(){
        List<AccountBill> bills = accountBillService.selectList();
        return onSuccess(bills);
    }

    @RequestMapping("/getBillByPage/{page}")
    public String getBillByPage(@PathVariable int page){
        List<AccountBill> bills = accountBillService.selectPage(page , 10);
        return onSuccess(bills);
    }

    @RequestMapping("/getBillByPage/{page}/{startTimeStamp}/{endTimeStamp}")
    public String getBillByPage(@PathVariable int page , @PathVariable long startTimeStamp , @PathVariable long endTimeStamp){
        List<AccountBill> bills = accountBillService.selectPage(page , 10 , startTimeStamp , endTimeStamp);
        return onSuccess(bills);
    }

    @RequestMapping("/getMerChants")
    public String getMerChants(){
        List<Merchant> merchants = merchantService.selectList();
        return onSuccess(merchants);
    }

    @RequestMapping("/getClassificationData")
    public String getClassificationData(){
        List<PrimaryClassification> primaryClassificationList = primaryClassificationService.selectList();
        List<SecondaryClassification> secondaryClassificationList = secondaryClassificationService.selectList();

        ClassificationData classificationData = new ClassificationData();
        classificationData.setPrimaryClassifications(primaryClassificationList);
        classificationData.setSecondaryClassifications(secondaryClassificationList);

        String data = JSON.toJSONString(classificationData);

        System.err.println("================getClassificationData==data: " + data);
        return data;
    }

    @RequestMapping("/getAccountBooks")
    public String getAccountBooks(){
        List<AccountBook> accountBooks = accountBookService.selectAll();
        return onSuccess(accountBooks);
    }

    @RequestMapping("/getAllBills")
    public String getAllBills(){
        List<AccountBill> accountBills = accountBillService.getAllBills();
        return onSuccess(accountBills);
    }

}
