package com.sps.service.order.impl;
import com.sps.dao.order.SpsExpressMapper;
import com.sps.entity.express.SpsExpress;
import com.sps.service.order.ExpressService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class ExpressServiceImpl implements ExpressService {
    @Resource
    private SpsExpressMapper spsExpressMapper;
    @Override
    public void saveOrUpdate(SpsExpress express) {

    }

    @Override
    public SpsExpress findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsExpress> findList(Map<String, Object> map) {
        return spsExpressMapper.findListAllWithMap(map);
    }

    @Override
    public void falseDeletion(Integer id) {

    }
}
