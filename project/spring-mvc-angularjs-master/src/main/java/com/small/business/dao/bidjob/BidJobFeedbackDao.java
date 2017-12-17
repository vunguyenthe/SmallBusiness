package com.small.business.dao.bidjob;

import java.util.List;

import com.small.business.model.bidjob.BidJobFeedback;

public interface BidJobFeedbackDao {

    public List<BidJobFeedback> getAllBidJobFeedback();

    public BidJobFeedback getBidJobFeedbackById(Long id);

    public Long getNextBidJobFeedbackId();

    public long addBidJobFeedback(BidJobFeedback BidJobFeedback);

    public boolean deleteBidJobFeedbackById(Long id);

    public boolean deleteAll();

    public boolean updateBidJobFeedback(BidJobFeedback people);
    
    public List<BidJobFeedback> getAllBidJobFeedbackByUserId(Long userId);
}
