package com.sps.service.merchant;


import com.sps.entity.merchant.SpsChannelOpenAccount;

import java.util.List;
import java.util.Map;

public interface ChannelOpenAccountService {
    SpsChannelOpenAccount findByCustomerNum(String channelNum);
}
