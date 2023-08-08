package com.github.cuifuan.mp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MybatisTest implements Serializable {

    private static final long serialVersionUID = 8897018268303812871L;

    private Long id;

    private String firstName;

    private String enName;
}
