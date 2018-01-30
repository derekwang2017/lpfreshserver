package com.lpfresh.service;

import com.lpfresh.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 87831 on 2018/1/29/0029.
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;


}
