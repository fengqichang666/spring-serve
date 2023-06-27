package com.vueserver.mapper;

import com.vueserver.pojo.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
    Test getTest(@Param("test") String test);
}
