package com.lingxiao.oa.dao;

import com.lingxiao.oa.entity.ClaimVoucher;
import com.lingxiao.oa.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {
    void insert(ClaimVoucherItem claimVoucherItem);
    void delete(int id);
    void update(ClaimVoucherItem claimVoucherItem);
    //ClaimVoucherItem selectById(String createSn);
    List<ClaimVoucherItem> selectByClaimVoucher(int cvId);
}
