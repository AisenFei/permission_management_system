package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Traveller {
    private int id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;

    public String getCredentialsTypeStr(){
        //证件类型 0 身份证 1护照 2军官证
        if(credentialsType != null){
            if(credentialsType == 0){
                credentialsTypeStr = "身份证";
            }else if(credentialsType == 1){
                credentialsTypeStr = "护照";
            }else if(credentialsType == 2){
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public String getTravellerTypeStr(){
        // 旅客类型(人群) 0 成人 1 儿童
        if(travellerType != null){
            if(travellerType == 0){
                travellerTypeStr = "成人";
            }else if(travellerType == 1){
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }
}
