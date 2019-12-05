package com.mapper;

/**
 * 用户模块的持久层接口
 */

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    /**
     * 获取用户信息(ByUserID)
     * @param telephone 传入userID
     * @return 返回用户信息
     */
    User getUserByTel(@Param("telephone") String telephone);

    /**
     * 获取用户信息(ByUserID)
     * @param userID 传入userID
     * @return 返回用户信息
     */
    User getUserByUserID(@Param(value = "userID") Long userID);

    /**
     * 编辑用户信息
     * @param user 传入更改的用户信息
     * @return int 返回数据更新条数
     */
    int changeUserInfo(User user);

    /**
     * 注册用户
     * @param user 传入用户信息
     * @return 返回注册结果
     */
    int addUser(User user);

    /**
     * 删除用户信息
     * @param userID 传入userID
     * @return 返回删除结果
     */
    int deleteUser(@Param(value = "userID") Long userID);

}
