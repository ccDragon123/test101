package com.ccl.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Boys {
    private int id;
    private String boyName;
    private List<Beauty> beauties;
}
