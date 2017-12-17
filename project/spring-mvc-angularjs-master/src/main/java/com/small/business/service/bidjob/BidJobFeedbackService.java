package com.small.business.service.bidjob;

import java.util.List;

import com.small.business.model.bidjob.BidJobFeedback;

public interface BidJobFeedbackService {

    public List<BidJobFeedback> getAllBidJobFeedback();

    public BidJobFeedback getBidJobFeedbackById(Long id);
    
    public long addBidJobFeedback(BidJobFeedback bidJobFeedback);

    public boolean deleteBidJobFeedbackById(Long id);
    
    public boolean deleteAll();

    public boolean updateBidJobFeedback(BidJobFeedback bidJobFeedback);
    
    public List<BidJobFeedback> getAllBidJobFeedbackByUserId(Long userId);
}
