package com.lingxiao.oa.service.Impl;

import com.lingxiao.oa.dao.ClaimVoucherDao;
import com.lingxiao.oa.dao.ClaimVoucherItemDao;
import com.lingxiao.oa.dao.DealRecordDao;
import com.lingxiao.oa.dao.EmployeeDao;
import com.lingxiao.oa.entity.ClaimVoucher;
import com.lingxiao.oa.entity.ClaimVoucherItem;
import com.lingxiao.oa.entity.DealRecord;
import com.lingxiao.oa.global.Contant;
import com.lingxiao.oa.service.ClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("claimVoucherService")
public class ClaimVoucherServiceImpl implements ClaimVoucherService {
    @Autowired
    private ClaimVoucherDao claimVoucherDao;
    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;
    @Autowired
    private DealRecordDao dealRecordDao;
    @Autowired
    private EmployeeDao employeeDao;

    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED);
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucherDao.insert(claimVoucher);
        for (ClaimVoucherItem item:items) {
            item.setClaimVoucherId(claimVoucher.getId());
            claimVoucherItemDao.insert(item);
        }
    }

    public ClaimVoucher get(int id) {
        return claimVoucherDao.selectById(id);
    }

    public List<ClaimVoucherItem> getItems(int cvid) {
        return claimVoucherItemDao.selectByClaimVoucher(cvid);
    }

    public List<DealRecord> getRecords(int cvid) {
        return dealRecordDao.selectByClaimVoucher(cvid);
    }

    public List<ClaimVoucher> getForSelf(String sn) {
        return claimVoucherDao.selectByCreateSn(sn);
    }

    public List<ClaimVoucher> getForDeal(String sn) {
        return claimVoucherDao.selectByNextDealSn(sn);
    }

    public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {

    }

    public void submit(int id) {

    }

    public void deal(DealRecord dealRecord) {

    }
}
