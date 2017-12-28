package com.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DepartmentMapper {
    //根据id查找公司中的部门
    @Select("SELECT * FROM department WHERE camid = #{camid}")
    Department[] selectDepart_in_conpany(int camid);
    //根据名字查找公司中的部门
    @Select("select * from department where camid =(select id from campany where name = #{name})")
    Department[] selectDepart_in_company_byname(String name);
    //根据id  查找部门的子部门
    @Select("SELECT * FROM department WHERE depid = #{depid}")
    Department[] selectDepart_in_department(int depid);
   //根据部门的名字查找子部门
    @Select("select * from department where depid =(select id from department where name = #{name})")
    Department[] selectDepart_in_department_byname(String depid);
   // @Update("")
}
