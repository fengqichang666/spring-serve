package com.vueserver.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    Integer login(String username , String password);
}
