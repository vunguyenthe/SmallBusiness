package com.small.business.service.bidjob;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.bidjob.BidJobFeedbackDao;
import com.small.business.model.bidjob.BidJobFeedback;


@Service("BidJobFeedbackService")
public class BidJobFeedbackServiceImpl implements BidJobFeedbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidJobFeedbackServiceImpl.class);

    private static List<BidJobFeedback> partnerList = new ArrayList<BidJobFeedback>();

    @Autowired
    BidJobFeedbackDao bidJobFeedbackDao;

    public List<BidJobFeedback> getAllBidJobFeedback() {

        List<BidJobFeedback> BidJobFeedbackList = bidJobFeedbackDao.getAllBidJobFeedback();
        return BidJobFeedbackList;
    }
    public BidJobFeedback getBidJobFeedbackById(Long id) {

        return bidJobFeedbackDao.getBidJobFeedbackById(id);
    }
    
    public long addBidJobFeedback(BidJobFeedback bidJobFeedback) {

        return bidJobFeedbackDao.addBidJobFeedback(bidJobFeedback);
    }

    public boolean deleteBidJobFeedbackById(Long id) {

        boolean ret;
        ret = bidJobFeedbackDao.deleteBidJobFeedbackById(id);
        return ret;
    }

    
    public boolean deleteAll() {

        return bidJobFeedbackDao.deleteAll();
    }

    public List<BidJobFeedback> getAllBidJobFeedbackByUserId(Long userId) {
        List<BidJobFeedback> bidJobFeedbackList = bidJobFeedbackDao.getAllBidJobFeedbackByUserId(userId);
        return bidJobFeedbackList;
    }
    
    public boolean updateBidJobFeedback(BidJobFeedback bidJobFeedback) {

        return bidJobFeedbackDao.updateBidJobFeedback(bidJobFeedback);

    }

}
