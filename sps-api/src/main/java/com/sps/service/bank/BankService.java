package com.sps.service.bank;

import com.sps.entity.bank.SpsBank;
import com.sps.entity.order.SpsOrderGoods;

import java.util.List;
import java.util.Map;

public interface BankService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsBank bank);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsBank  findEntityById(Integer id);
    /**
     * 查看详情
     * @param channlNum
     * @return
     */
    SpsBank  findEntityByNo(String channlNum);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsBank> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

}
