package com.clem.service;

import com.clem.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by laileon on 2017/3/11.
 */
@CacheConfig(cacheNames = "users") //配置了该数据访问对象中返回的内容将存储于名为users的缓存对象中
public interface UserRepository extends JpaRepository<User, Long> {

//    @Cacheable(key = "#p0", condition = "#p0.length() < 3")

    @Cacheable(key = "#p0")
    User findByName(String name);

    @CachePut(key = "#p0.name")
    User save(User user);

    User findByNameAndAge(String name, Integer age);

    //通过类似“:name”来映射@Param指定的参数
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
