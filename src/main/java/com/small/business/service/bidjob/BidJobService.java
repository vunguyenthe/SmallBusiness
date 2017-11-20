package com.small.business.service.bidjob;

import java.util.List;

import com.small.business.model.bidjob.BidJob;


public interface BidJobService {

    public List<BidJob> getAllBidJob();
    
    public List<BidJob> getAllBidJobByUserId(Long userId);

    public BidJob getBidJobById(Long id);
    
    public long addBidJob(BidJob bidJob);

    public boolean deleteBidJobById(Long id);

    public boolean deleteAll();

    public boolean updateBidJob(BidJob bidJob);
}
