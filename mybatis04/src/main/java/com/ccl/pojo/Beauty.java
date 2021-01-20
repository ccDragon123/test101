package com.ccl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
public class Beauty {
    private  int id;
    private String name;
    private String sex;
    private Date bornDate;
    private String phone;
    private Boys boys;
}
