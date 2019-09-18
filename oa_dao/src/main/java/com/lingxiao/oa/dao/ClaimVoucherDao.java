package com.lingxiao.oa.dao;

import com.lingxiao.oa.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherDao")
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void delete(int id);
    void update(ClaimVoucher claimVoucher);
    ClaimVoucher selectById(int id);
    List<ClaimVoucher> selectByCreateSn(String createSn);
    List<ClaimVoucher> selectByNextDealSn(String nextDealSn);
}
