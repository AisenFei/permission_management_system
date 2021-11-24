package org.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.domain.SysLog;

import java.util.List;

public interface ISysLogDao {
    @Insert("insert into syslog(visit_time,username,ip,url,execution_time,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog)throws Exception;

    @Select("select * from syslog")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "visitTime",column = "visit_time"),
            @Result(column="username",property="username"),
            @Result(property = "ip",column = "ip"),
            @Result(property = "url",column = "url"),
            @Result(property = "executionTime",column = "execution_time"),
            @Result(property = "method",column = "method")
    })
    public List<SysLog> findAll() throws Exception;
}
