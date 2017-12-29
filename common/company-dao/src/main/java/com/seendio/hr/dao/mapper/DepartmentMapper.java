package com.seendio.hr.dao.mapper;

import com.dao.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {
    /**
     * 1.查找公司中的部门
     * @param camid
     * @camid：公司的id
     * @return
     *
     */
    @Select("SELECT * FROM department WHERE camid = #{camid}")
    List<com.seendio.hr.dao.pojo.Department> selectDepartInCompany(@Param("camid") int camid);
    /**
     * 1.查找公司中的部门
     * @param name
     * @name：公司的名字
     * @return
     *
     */
    @Select("select * from department where camid =(select id from campany where name = #{name})")
    Department[] selectDepartInCompanyByName(@Param("name") String name);
    /**
     * 1.查找公司中的部门
     * @param depid
     * @depid：部门id
     * @return
     *
     */
    @Select("SELECT * FROM department WHERE depid = #{depid}")
    com.seendio.hr.dao.pojo.Department[] selectDepartInDepartment(@Param("depid") int depid);
    /**
     * 1.查找公司中的部门
     * @param name
     * @name：部门名字
     * @return
     *
     */
    @Select("select * from department where depid =(select id from department where name = #{name})")
    Department[] selectDepartInDepartmentByName(String name);

    /**
     * 新增部门
     * @param name  部门名字
     * @param camid 公司id
     * @param depid 上级部门id
     * @param empid 负责人id
     */
    @Insert("INSERT INTO department(name,camid,depid,empid) VALUES(#{name},#{camid},#{depid},#{empid})")
    void insertDepartment(@Param(value = "name" )String name,@Param(value = "camid")int camid,@Param(value = "depid")int depid,@Param(value = "empid")int empid);

}
