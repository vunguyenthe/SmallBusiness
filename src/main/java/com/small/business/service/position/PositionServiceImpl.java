package com.small.business.service.position;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.small.business.dao.position.PositionDao;
import com.small.business.model.user.Position;

@Service("PositionService")
public class PositionServiceImpl implements PositionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);

    private static List<Position> positionList = new ArrayList<Position>();

    @Autowired
    PositionDao positionDao;

    public List<Position> getAllPosition() {

        List<Position> positionList = positionDao.getAllPosition();
        return positionList;
    }

    public Position getPositionById(Long id) {

        return positionDao.getPositionById(id);
    }

    public boolean addPosition(Position Position) {

        return positionDao.addPosition(Position);
    }

    public boolean deleteAll() {

    	positionList.clear();
        return positionDao.deleteAll();
    }

    public boolean updatePosition(Position position) {
        return positionDao.updatePosition(position);
    }
	@Override
	public boolean deletePositionById(Long id) {
        boolean ret = positionDao.deletePositionById(id);
        return ret;
	}

}
