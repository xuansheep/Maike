package com.john.order.domain.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_user")
public class UserDTO extends BaseDTO {

    @Column(length = 32, unique = true)
    private String username;

    private String password;

    private Date lastLoginTime;
}
