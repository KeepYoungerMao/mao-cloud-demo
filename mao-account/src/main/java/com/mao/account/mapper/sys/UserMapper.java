package com.mao.account.mapper.sys;

import com.mao.account.entity.sys.User;
import com.mao.account.entity.sys.UserPass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

/**
 * sys_user
 * 用户数据处理
 * @author : create by zongx at 2020/11/10 10:44
 */
@Repository
@Mapper
public interface UserMapper {

    User getUserByUsername(@Param("username") String username);

    List<User> getUserByUsernameLike(@Param("username") String username);

    List<User> getUsers(Query query);

    Integer getUsersTotal(Query query);

    Integer checkExistUsername(@Param("username") String username);

    void saveUser(User user);

    Integer updateUser(User user);

    Integer updateUserPass(UserPass userPass);

    Integer deleteUser(@Param("username") String username);

}
