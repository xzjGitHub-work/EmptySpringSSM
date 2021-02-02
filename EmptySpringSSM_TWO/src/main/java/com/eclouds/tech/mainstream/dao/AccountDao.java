package com.eclouds.tech.mainstream.dao;

import com.eclouds.tech.model.Account;

/**
 * @describe:
 *
 * @author:xzj
 * @createDate:2021/2/2 11:10
 * @param:
 * @return:
 */
public interface AccountDao {
    /**
     * @describe:
     *
     * @author:xzj
     * @createDate:2021/2/2 11:10
     * @param:[name]
     * @return:com.eclouds.tech.model.Account
     */
    Account findByName(String name);

    /**
     * @describe:
     *
     * @author:xzj
     * @createDate:2021/2/2 11:10
     * @param:[account]
     * @return:void
     */
    void update(Account account);
}