package com.clem.service;

import com.clem.domain.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by laileon on 2017/3/13.
 */
public interface UserService {
    User finaUserByName(String name);
}
