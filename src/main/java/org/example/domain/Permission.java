package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Permission {
    private int id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
