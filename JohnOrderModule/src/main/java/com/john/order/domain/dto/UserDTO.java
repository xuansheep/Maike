package com.john.order.domain.dto;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_user")
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private Date lastLoginTime;
}
