package com.dao;

import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE depid = #{depid}")
    Employee[] selectEmployee_in_department(int depid);

}
