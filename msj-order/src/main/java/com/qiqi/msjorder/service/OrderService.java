package com.qiqi.msjorder.service;

import java.util.List;

public interface OrderService {
    void order(List<Integer> idList, Integer receivingAddressId);
}
