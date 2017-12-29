package com.seendio.hr.dao.mapper;


import com.seendio.hr.dao.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Administrator
 */
public interface EmployeeMapper {
    /**
     * 查找部门中的员工
     * @param depid
     * @depid：部门的id
     * @return
     *
     */
    @Select("SELECT * FROM employee WHERE depid = #{depid}")
    Employee[] selectEmployeeInDepartment(int depid);

    /**
     * 修改员工的部门
     * @param name 姓名
     * @param departid 部门id
     * @param id  员工id
     */
    @Update("update employ set name = #{name},departid=#{departid} where id = #{id}")
    void updateEmployName(@Param("name") String name,@Param("departid") int departid,@Param("id") int id);


    /**
     * 添加员工
     * @param name
     * @param camid
     * @param depid
     * @param empid
     */
    @Insert("INSERT INTO employee(name,camid,depid,empid) VALUES(#{name},#{camid},#{depid},#{empid})")
    void insertEmployee(@Param(value = "name" )String name,@Param(value = "camid")int camid,@Param(value = "depid")int depid,@Param(value = "empid")int empid);



}
