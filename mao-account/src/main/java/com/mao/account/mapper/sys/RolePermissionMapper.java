package com.mao.account.mapper.sys;

import com.mao.account.entity.sys.Permission;
import com.mao.account.entity.sys.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

/**
 * @author : create by zongx at 2020/11/10 10:46
 */
@Repository
@Mapper
public interface RolePermissionMapper {

    List<String> getPermissionByRoleId(@Param("id") long id);

    List<Long> getPermissionIdByRoleId(@Param("id") long id);

    Role getRoleById(@Param("id") long id);

    List<Role> getRolesByNameLike(@Param("keyword") String keyword);

    List<Role> getRoles(Query query);

    int getRolesTotal(Query query);

    int checkExistRole(@Param("name") String name);

    void saveRole(Role role);

    int updateRole(Role role);

    void increasePermissions(@Param("role") Long role, @Param("list") List<Long> list);

    void decreasePermissions(@Param("role") Long role, @Param("list") List<Long> list);

    int deleteRole(@Param("id") long id);

    void deleteRolePermissions(@Param("id") long id);

    List<Permission> getPermissions();

}
