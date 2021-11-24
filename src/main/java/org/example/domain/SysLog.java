package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class SysLog {
    private int id;   //id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date visitTime;   //访问时间
    private String visitTimeStr;
    private String username;  //用户名
    private String ip;    //id地址
    private String url;   //访问url
    private Long executionTime;   //执行时间
    private String method;     //访问方法

    public String getVisitTimeStr(){
        if(visitTime != null){
            visitTimeStr = DateUtils.dateToString(visitTime,"yyyy-MM-dd HH:mm:ss");
        }
        return visitTimeStr;
    }
}
