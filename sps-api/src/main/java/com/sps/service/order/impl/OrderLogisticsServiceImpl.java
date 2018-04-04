package com.sps.service.order.impl;
import com.sps.dao.order.SpsOrderLogisticsMapper;
import com.sps.entity.order.SpsOrderLogistics;
import com.sps.service.order.OrderLogisticsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderLogisticsServiceImpl implements OrderLogisticsService {
    @Resource
    private SpsOrderLogisticsMapper spsOrderLogisticsMapper;
    @Override
    public void saveOrUpdate(SpsOrderLogistics log) {
        if(log.getLogisticsId()==null){
            log.setLogisticsCreatTime(new Date());
            spsOrderLogisticsMapper.insert(log);
        }

    }

    @Override
    public SpsOrderLogistics findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsOrderLogistics> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }
}
