package com.seendio.hr.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CompanyMapper {
    /**
     * 修改公司名字
     * @param name 公司名
     * @param id 公司id
     */
    @Update("update campany set name =#{name} where id = #{id}")
    void updateCompanyName(@Param(value="name") String name, @Param(value="id") int id);

    /**
     * 新增公司
     * @param name
     *
     */
    @Insert("INSERT INTO campany(name) VALUES(#{name})")
    void insertCompany(@Param(value = "name" )String name);
}
