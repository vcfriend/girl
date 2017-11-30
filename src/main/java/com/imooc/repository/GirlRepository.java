package com.imooc.repository;

import com.imooc.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 向亚林
 * 2017/11/29
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    /**
     * 通过年龄查询女生列表
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
