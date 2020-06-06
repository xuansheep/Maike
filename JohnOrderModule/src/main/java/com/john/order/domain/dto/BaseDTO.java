package com.john.order.domain.dto;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xuhang
 * @date 2020/6/6 14:05
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;

}
