package com.bean;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customermodel {

	private String id;
    private String type ;
    private String name;
    private String email;
    private String password;
    @JsonIgnore
    private LocalDate createdate;
    @JsonIgnore
    private LocalDate accessdate ;
    @JsonIgnore
    private LocalDate modifieddate  ;
    public Customermodel() {
        super();
        
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDate getCreatedate() {
        return createdate;
    }
    public void setCreatedate(LocalDate createdate) {
        this.createdate = createdate;
    }
    public LocalDate getAccessdate() {
        return accessdate;
    }
    public void setAccessdate(LocalDate accessdate) {
        this.accessdate = accessdate;
    }
    public LocalDate getModifieddate() {
        return modifieddate;
    }
    public void setModifieddate(LocalDate modifieddate) {
        this.modifieddate = modifieddate;
    }

}
