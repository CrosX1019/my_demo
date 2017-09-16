package com.crosx.repository;

import com.crosx.model.TUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<TUserEntity, Integer> {

    @Modifying  //说明该方法是修改操作
    @Transactional  //说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update TUserEntity user set user.userPhone=:qUserPhone,user.userPwd=:qUserPwd,user.nickName=:qNickName where user.uid=:qUid")
    void updateUser(@Param("qUserPhone") String userPhone,
                    @Param("qUserPwd") String userPwd,
                    @Param("qNickName") String nickName,
                    @Param("qUid") String uid);
}
