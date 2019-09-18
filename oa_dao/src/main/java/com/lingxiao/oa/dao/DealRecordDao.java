package com.lingxiao.oa.dao;

import com.lingxiao.oa.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dealRecordDao")
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    DealRecord selectById(Integer id);
    List<DealRecord> selectByClaimVoucher(int cvid);
}
