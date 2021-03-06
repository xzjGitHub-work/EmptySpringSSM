package com.eclouds.tech.traditional.server;

/**
 * @describe:service接口
 * @author:xzj
 * @createDate:2021/2/2 11:11
 * @param:
 * @return:
 */
public interface AccountByTraditionalService {
    /**
     * @describe:
     *
     * @author:xzj
     * @createDate:2021/2/2 11:11
     * @param:[fromUser, toUser, money]
     * @return:void
     */
    void transfer(String fromUser, String toUser, Double money);
}
