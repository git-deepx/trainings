package com.deep.DTO;

import java.math.BigDecimal;

public class EmployeeDetailWsDTO {

    private BigDecimal id;
    private String name;

    public EmployeeDetailWsDTO(String name, BigDecimal id) {
        this.name = name;
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
