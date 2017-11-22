package com.pixel.ssm.service;

import com.pixel.ssm.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@Service("indexService")
public class IndexService {

    private static final Logger logger = LoggerFactory.getLogger(IndexService.class);

    public boolean login(User user) {
        logger.info("日志输出 IndexService " + user.toString());
        return false;
    }
}
