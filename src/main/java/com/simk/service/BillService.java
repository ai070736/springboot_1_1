package com.simk.service;

import com.simk.entities.Bill;
import com.simk.entities.BillProvider;
import com.simk.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillMapper billMapper;

    @Cacheable(cacheNames = "bills")
    public List<BillProvider> getBills(BillProvider billProvider) {
        List<BillProvider> bills = billMapper.getBills(billProvider);
        return bills;
    }
    @Cacheable(cacheNames = "bills#60",key = "#bid")
    public Bill getBillByBid(Integer bid) {
        Bill bill = billMapper.getBillByBid(bid);
        return bill;
    }
    @CachePut(cacheNames = "bills",key = "#bill.bid")
    public Bill updateBill(Bill bill){
        int i = billMapper.updateBill(bill);
        return bill;
    }
    @CacheEvict(cacheNames = "bills",key = "#bid")
    public int deteleBillByBid(Integer bid){
        int i = billMapper.deteleBillByBid(bid);
        return i;
    }

}
