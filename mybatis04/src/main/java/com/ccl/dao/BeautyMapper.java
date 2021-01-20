package com.ccl.dao;

import com.ccl.pojo.Beauty;
import com.ccl.pojo.Boys;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BeautyMapper {

    @Select("select * from beauty where id = #{Id}")
    Boys getBeautyId(@Param("Id") int id);

    //查询右男朋友的女生的所有信息
    public List<Beauty> getBeauty();
}
