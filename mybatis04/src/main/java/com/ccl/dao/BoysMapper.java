package com.ccl.dao;

import com.ccl.pojo.Boys;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BoysMapper {

    @Select("select * from boys where id = #{Id}")
    Boys getBoyId(@Param("Id") int id);

    public Boys getBoys(@Param("id") int id);
}
