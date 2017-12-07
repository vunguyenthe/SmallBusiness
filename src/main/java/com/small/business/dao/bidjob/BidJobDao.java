package com.small.business.dao.bidjob;

import java.util.List;

import com.small.business.model.bidjob.BidJob;

public interface BidJobDao {

    public List<BidJob> getAllBidJob();

    public List<BidJob> getAllBidJobByUserId(Long userId);
    
    public BidJob getBidJobById(Long id);
    
    public Long addBidJob(BidJob bidJob);

    public boolean deleteBidJobById(Long id);

    public boolean deleteAll();

    public boolean updateBidJob(BidJob bidJob);

    public boolean setIsExpired(Long id, Integer isExpired);
    
    public List<BidJob> getAllBidJobActivated();
    
    public List<BidJob> getBidJobDetailId(Long jobDetailId);
}
