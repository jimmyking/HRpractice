package com.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Company {
    public static void main(String[] args) throws IOException {
        // write your code here

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(BlogMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(DepartmentMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(EmployeeMapper.class);
        SqlSession session = sqlSessionFactory.openSession();

        //添加部门
      //  add_Department(session,3,"策划部门",2,1);
        //添加员工
      //  add_Employee(session,1,"杜甫",1,1);
        //新建公司
      //   add_Company(session,"1","地表");
        //查找公司中的部门
      //  select_Depart_in_Company(session,1);
        //查找部门的子部门
      //  select_Depart_in_depart(session,1);
        //查找部门员工
      //  select_Employee_in_deaprt(session,1);
        //公司改名字
        update_Company_name(session,"腾讯",2);
    }
    public static void add_Company(SqlSession session,String id,String name){
        try {

            Blog blog = new Blog();
            blog.setName(name);
            blog.setId(id);
            session.update("mapper.BlogMapper.insertBlog",blog);
            session.commit();
        } finally {
            session.close();
        }
    }
    public static void add_Department(SqlSession session,int id,String name,int camid ,int empid){
        try {

            Department department = new Department();
            department.setName(name);
            department.setId(id);
            department.setCamid(camid);
            department.setEmpid(empid);
            session.insert("mapper.BlogMapper.insertDepartment",department);
            session.commit();
        } finally {
            session.close();
        }
    }
    public static void add_Employee(SqlSession session,int id,String name,int camid ,int empid){
        try {

            Employee employee = new Employee();
            employee.setName(name);
            employee.setId(id);
            employee.setDepid(camid);
            employee.setEmpid(empid);
            session.insert("mapper.BlogMapper.insertEmployee",employee);
            session.commit();
        } finally {
            session.close();
        }
    }
    public static void select_Depart_in_Company(SqlSession session ,int camid){
        try {

            //注解方式
//            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
//            Blog user = blogMapper.selectBlog("2");
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            Department[] department = departmentMapper.selectDepart_in_conpany(camid);
            for (int i = 0;i<department.length;i++){
                System.out.println(department[i].getName());
            }
        } finally {
            session.close();
        }
    }
    public static void select_Depart_in_depart(SqlSession session,int depid){
        try {

            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            Department[] department = departmentMapper.selectDepart_in_department(depid);
            for (int i = 0;i<department.length;i++){
                System.out.println(department[i].getName());
            }
        } finally {
            session.close();
        }

    }
    public static void select_Employee_in_deaprt(SqlSession session,int depid){
        try {

            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            Employee[] employees = employeeMapper.selectEmployee_in_department(depid);
            for (int i = 0;i<employees.length;i++){
                System.out.println(employees[i].getName());
            }
        } finally {
            session.close();
        }

    }
    public static void update_Company_name(SqlSession session,String name,int id){
        try {
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            blogMapper.update_Company_name(name,id);
            session.commit();


        } finally {
            session.close();
        }
    }
}
