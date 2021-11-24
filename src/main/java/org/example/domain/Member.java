package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
