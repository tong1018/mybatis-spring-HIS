package com.ct.model;

import javax.validation.constraints.NotBlank;

public class HisUserModel {
    private String username;
    private String password;

    public HisUserModel(){

    }

    public HisUserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @NotBlank(message = "Username Not Null")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Password Not Null")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
