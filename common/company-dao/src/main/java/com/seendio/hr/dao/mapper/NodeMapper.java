package com.seendio.hr.dao.mapper;

import com.seendio.hr.dao.pojo.Node;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 */
public interface NodeMapper {
    /**
     * 查询树结构
     * @return
     */
    @Select("select id,name,depid from department")
    List<Node> selectDepTree();
}
