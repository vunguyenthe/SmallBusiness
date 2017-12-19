package com.small.business.service.position;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.model.user.Position;
import com.small.business.dao.position.PositionDao;

@Service("PositionService")
public class PositionServiceImpl implements PositionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);

    private static List<Position> PositionList = new ArrayList<Position>();

    @Autowired
    PositionDao PositionDao;

    public List<Position> getAllPosition() {
        List<Position> PositionList = PositionDao.getAllPosition();
        return PositionList;
    }

    public Position getPositionById(Long id) {
        return PositionDao.getPositionById(id);
    }
    
    public Position getPositionUserId(Long userId) {
    	return PositionDao.getPositionUserId(userId);
    }
    
    public boolean addPosition(Position Position) {

        return PositionDao.addPosition(Position);
    }

    public boolean deleteAll() {
    	PositionList.clear();
        return PositionDao.deleteAll();
    }

    public boolean updatePosition(Position Position) {
        return PositionDao.updatePosition(Position);
    }
	@Override
	public boolean deletePositionById(Long id) {
        boolean ret = PositionDao.deletePositionById(id);
        return ret;
	}

}
