
import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
    @Select("SELECT * FROM t1 WHERE id = #{id}")
    Blog selectBlog(String id);

}
