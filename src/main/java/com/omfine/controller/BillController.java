package com.omfine.controller;

import com.alibaba.fastjson.JSON;
import com.omfine.bean.*;
import com.omfine.bean.out.ClassificationData;
import com.omfine.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Scope("session")//session 会话//prototype原型
@Controller
public class BillController {

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

    @RequestMapping("add")
    public String insert(Model model){

        List<PrimaryClassification> primaryClassificationList = primaryClassificationService.selectList();
        model.addAttribute("primaryClassificationList" , primaryClassificationList);

        List<SecondaryClassification> secondaryClassificationList = secondaryClassificationService.selectList();
        model.addAttribute("secondaryClassificationList" , secondaryClassificationList);

        List<Merchant> merchantList = merchantService.selectList();
        model.addAttribute("merchantList" , merchantList);

        return "addBill";
    }

    @RequestMapping("insertBill")
    public String insertBill(AccountBill accountBill ,Model model){
        System.err.println(JSON.toJSONString(accountBill));
        accountBill.setUid(10000000);
        accountBill.setBookId(10000000);
        accountBill.setBillId(System.currentTimeMillis());
        accountBill.setHappenedTimeStamp(System.currentTimeMillis());
        accountBill.setCTime(System.currentTimeMillis());

        System.err.println(JSON.toJSONString(accountBill));

        int result =accountBillService.insert(accountBill);
        System.err.println("================insertBill==result: " + result);
        String msg = 1 == result ? "添加成功" : "添加失败";
        model.addAttribute("result" , msg);
        return "result";
    }

    @RequestMapping("addAccountBill")
    @ResponseBody
    public String addAccountBill(AccountBill accountBill){
        System.err.println(JSON.toJSONString(accountBill));
        return "1";
    }

    @RequestMapping("all")
    @ResponseBody
    public String selectList(){
        List<AccountBill> list = accountBillService.selectList();
        return JSON.toJSONString(list);
    }

    @RequestMapping("addP")
    public String insertPrimaryClassification(Model model){
        PrimaryClassification primaryClassification = new PrimaryClassification();
        primaryClassification.name = "住";
        primaryClassification.uid = 10000000;

        int result = primaryClassificationService.insert(primaryClassification);
        System.err.println("================insert==result: " + result);
        String msg = 1 == result ? "添加成功" : "添加失败";
        model.addAttribute("result" , msg);

        return "result";
    }

    @RequestMapping("adds")
    public String insertSecondaryClassification(Model model){
        SecondaryClassification secondaryClassification = new SecondaryClassification();
        secondaryClassification.pid = 100002;
        secondaryClassification.name = "全部住";
        secondaryClassification.uid = 10000000;

        int result = secondaryClassificationService.insert(secondaryClassification);
        System.err.println("================insert==result: " + result);
        String msg = 1 == result ? "添加成功" : "添加失败";
        model.addAttribute("result" , msg);

        return "result";
    }

    @RequestMapping("addm")
    public String insertMerchant(Model model){
        Merchant merchant = new Merchant();
        merchant.name = "华润";
        merchant.uid = 10000000;
        merchant.cTime = System.currentTimeMillis();

        int result = merchantService.insert(merchant);
        System.err.println("================insert==result: " + result);
        String msg = 1 == result ? "添加成功" : "添加失败";
        model.addAttribute("result" , msg);

        return "result";
    }

    static int count = 0;

    @RequestMapping("addMer")
    public String insertMerchandise(Model model){
        for (int i = 0; i < 10000000; i ++){
            try {
                Thread.sleep(2);

                Merchandise merchandise = new Merchandise();
                merchandise.uid = 10000000;
                merchandise.name = "纯牛奶" + count;
                merchandise.cTime = System.currentTimeMillis();
                int result = merchandiseService.insert(merchandise);
                System.err.println("================insert==result: " + result);
                String msg = 1 == result ? "添加成功" + count : "添加失败";
                model.addAttribute("result" , msg);
                count ++;
                // return "result";
            }catch (Exception e){
                e.printStackTrace();
            }
        }
/*        Merchandise merchandise = new Merchandise();
        merchandise.uid = 10000000;
        merchandise.name = "纯牛奶" + count;
        merchandise.cTime = System.currentTimeMillis();
        int result = merchandiseService.insert(merchandise);
        System.err.println("================insert==result: " + result);
        String msg = 1 == result ? "添加成功" + count : "添加失败";
        model.addAttribute("result" , msg);*/
        return "result";
    }

    @RequestMapping("/selectAllMerchandise")
    @ResponseBody
    public void SelectAllMerchandise(){
        System.err.println("======================0=======");
        List<Merchandise> list = merchandiseService.selectAll();
        System.err.println("======================1=======" + list.size());
    }

    @RequestMapping("/insertAccountBook")
    public String insertAccountBook(Model model){
        AccountBook book = new AccountBook();
        book.uid = 10000000;
        book.name = "book1";
        book.cTime = System.currentTimeMillis();

        int result = accountBookService.insert(book);
        System.err.println("================insert==result: " + result);
        String msg = 1 == result ? "添加成功" : "添加失败";
        model.addAttribute("result" , msg);

        return "result";
    }

    @ResponseBody
    @PostMapping("/addAccountBook")
    public String insertAccountBook2(AccountBook book){
        book.cTime = System.currentTimeMillis();
        System.err.println("================insert: " + JSON.toJSONString(book));
        int result = accountBookService.insert(book);
        System.err.println("================insert==result: " + result);
        String msg = 1 == result ? "添加成功" : "添加失败";

        AccountBook accountBook = accountBookService.getAccountBook(book.getUid() , book.getCTime());

        System.err.println("================insert==data: " + JSON.toJSONString(accountBook));

        return msg;
    }

    @RequestMapping("/getClassificationData")
    @ResponseBody
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

    @RequestMapping("/getMerchants")
    @ResponseBody
    public String getMerchants(){
        List<Merchant> merchants = merchantService.selectList();

        ResultBean resultBean = new ResultBean();
        resultBean.setData(merchants);

        String data = JSON.toJSONString(resultBean);
        System.err.println("================getMerchants==data: " + data);
        return data;
    }

}
