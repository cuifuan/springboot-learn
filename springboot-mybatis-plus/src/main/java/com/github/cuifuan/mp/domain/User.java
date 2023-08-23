package com.github.cuifuan.mp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User {

    private String name;

    private Integer age;

    private LocalDateTime brithday;

    private String fullName;

}
