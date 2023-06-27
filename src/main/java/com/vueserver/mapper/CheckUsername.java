package com.vueserver.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface CheckUsername {
    Integer CheckUsername(String username);
}
