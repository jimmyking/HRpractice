import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        // write your code here

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(BlogMapper.class);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //xml方式
        //    Blog blog = (Blog) session.selectOne("mapper.BlogMapper.selectBlog", 1);
            //注解方式
//            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
//            Blog user = blogMapper.selectBlog("2");
            Blog blog = new Blog();
            blog.setName("qq");
            blog.setId("2");
            session.update("mapper.BlogMapper.updateBlog",blog);
        //    session.insert("mapper.BlogMapper.insertBlog",blog);
            //插入更改一定不要忘了这句
            session.commit();
          //  System.out.println(blog.getName());
        } finally {
            session.close();
        }
    }
}
