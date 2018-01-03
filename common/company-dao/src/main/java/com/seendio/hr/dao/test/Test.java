package com.seendio.hr.dao.test;


import com.seendio.hr.dao.mapper.CompanyMapper;
import com.seendio.hr.dao.mapper.DepartmentMapper;
import com.seendio.hr.dao.mapper.EmployeeMapper;
import com.seendio.hr.dao.mapper.NodeMapper;
import com.seendio.hr.dao.pojo.Company;
import com.seendio.hr.dao.pojo.Department;
import com.seendio.hr.dao.pojo.Employee;
import com.seendio.hr.dao.pojo.Node;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        //com.seendio.hr.dao.pojo.Blog
        //com.seendio.hr.dao.mapper.BlogMapper
        //com.seendio.hr.dao.test.Test
        // write your code here
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(CompanyMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(DepartmentMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(EmployeeMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(NodeMapper.class);
        SqlSession session = sqlSessionFactory.openSession();

        //添加部门
        //  addDepartment(session,3,"策划部门",2,1);
        //添加员工
        //  addEmployee(session,1,"杜甫",1,1);
        //新建公司
        //  addCompany(session,"1","地表");
        //查找公司中的部门
       //selectDepartInCompany(session,1);
        //查找部门的子部门
        //  selectDepartInDepart(session,1);
        //查找部门员工
        //  selectEmployeeInDeaprt(session,1);
        //公司改名字
        //  updateCompanyName(session,"哈哈哈",2);
        //树查找测试
        selectTree(session);

    }
    public static void addCompany(SqlSession session,String id,String name){
        try {

            Company blog = new Company();
            blog.setName(name);
            blog.setId(id);
            session.update("mapper.BlogMapper.insertBlog",blog);
            session.commit();
        } finally {
            session.close();
        }
    }
    public static void addDepartment(SqlSession session,int id,String name,int camid ,int empid){
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
    public static void addEmployee(SqlSession session,int id,String name,int camid ,int empid){
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
    public static void selectDepartInCompany(SqlSession session ,int camid){
        try {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            List<Department> department = departmentMapper. selectDepartInCompany(camid);

            for (Department d:department){
                System.out.println(d.getName());
            }
        } finally {
            session.close();
        }
    }
    public static void selectDepartInDepart(SqlSession session,int depid){
        try {

            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            Department[] department = departmentMapper.selectDepartInDepartment(depid);
            for (int i = 0;i<department.length;i++){
                System.out.println(department[i].getName());
            }
        } finally {
            session.close();
        }

    }
    public static void selectEmployeeInDeaprt(SqlSession session,int depid){
        try {

            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            Employee[] employees = employeeMapper.selectEmployeeInDepartment(depid);
            for (int i = 0;i<employees.length;i++){
                System.out.println(employees[i].getName());
            }
        } finally {
            session.close();
        }

    }
    public static void updateCompanyName(SqlSession session,String name,int id){
        try {
            CompanyMapper blogMapper = session.getMapper(CompanyMapper.class);
            blogMapper.updateCompanyName(name,id);
            session.commit();


        } finally {
            session.close();
        }
    }
    public static void updateEmployeeDepartment(SqlSession session,int depid){

    }
    public static void selectTree(SqlSession session){
        try {


        NodeMapper nodeMapper = session.getMapper(NodeMapper.class);
        List<Node> nodes = nodeMapper.selectDepTree();
        List<Node> nodes1 = new TreeBuilder(nodes).buildTree();
        int i= 0;
            for (Node d:nodes1){
                i++;
                System.out.println(d.getName()+"--"+i);
                for (Node m:d.getChildren()){
                    System.out.println(m.getName()+"--");
                    if (m.getChildren()!=null){
                    for (Node n:m.getChildren()){
                        System.out.println(n.getName()+"-");
                    }
                    }
                }
            }

        }finally {
            session.close();
        }
    }
}
