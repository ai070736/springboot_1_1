package com.simk.controller;

import com.simk.entities.Bill;
import com.simk.entities.BillProvider;
import com.simk.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CacheController {
    @Autowired
    BillService billService;

    @GetMapping("/getBills")
    public List<BillProvider> getBills() {
        BillProvider billProvider = new BillProvider();
        List<BillProvider> bills = billService.getBills(billProvider);
        return bills;
    }

    @GetMapping("/getBillByBid/{bid}")
    public Bill getBills(@PathVariable("bid") Integer bid) {
        Bill bill = billService.getBillByBid(bid);
        return bill;
    }

//    http://localhost:8080/updateBill?bid=1&billName=simk1 ，直接修改后，缓存不会发生变化
    @GetMapping("updateBill")
    public Bill updateBill(Bill bill) {
        Bill bill1 = billService.updateBill(bill);
        return bill1;
    }


    @GetMapping("/deteleBillByBid/{pid}")
    public boolean deteleBillByBid(@PathVariable("pid") Integer pid){
        int i = billService.deteleBillByBid(pid);
        return i>0;
    }

}
