package com.github.cuifuan.mp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * TableName user_info
 */
@TableName(value = "user_info")
@Data
public class UserInfo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String fullName;

    private String address;

    private String cardNo;

    private String email;

    private String sex;

    private LocalDateTime inTime;

    private Boolean isMember;

    private String password;

    /**
     *
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}