package com.dao;

import org.apache.ibatis.annotations.Update;

public interface BlogMapper {
    @Update("update campany set name = #{arg0} where id = #{arg1}")
    void update_Company_name(String name,int id);
}
