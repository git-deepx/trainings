package com.deep.DTO;

public class EmployeeDetailWsDTO {

    private Long id;
    private String name;

    public EmployeeDetailWsDTO() {
    }

    public EmployeeDetailWsDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeDetailWsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
