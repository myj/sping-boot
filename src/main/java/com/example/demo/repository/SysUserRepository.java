package com.example.demo.repository;

import com.example.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by myj on 2017/6/21.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {
}
