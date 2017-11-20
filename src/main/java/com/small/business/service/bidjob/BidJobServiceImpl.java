package com.small.business.service.bidjob;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.bidjob.BidJobDao;
import com.small.business.model.bidjob.BidJob;

@Service("BidJobService")
public class BidJobServiceImpl implements BidJobService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidJobServiceImpl.class);

    private static List<BidJob> bidJobList = new ArrayList<BidJob>();

    @Autowired
    BidJobDao bidJobDao;

    public List<BidJob> getAllBidJob() {
        List<BidJob> categoryList = bidJobDao.getAllBidJob();
        return categoryList;
    }

    public List<BidJob> getAllBidJobByUserId(Long userId) {
        List<BidJob> categoryList = bidJobDao.getAllBidJobByUserId(userId);
        return categoryList; 	
    }
    public BidJob getBidJobById(Long id) {
        return bidJobDao.getBidJobById(id);
    }
    
    public long addBidJob(BidJob BidJob) {

        return bidJobDao.addBidJob(BidJob);
    }

    public boolean deleteAll() {
    	bidJobList.clear();
        return bidJobDao.deleteAll();
    }

    public boolean updateBidJob(BidJob BidJob) {
        return bidJobDao.updateBidJob(BidJob);
    }
	@Override
	public boolean deleteBidJobById(Long id) {
        boolean ret = bidJobDao.deleteBidJobById(id);
        return ret;
	}

}
