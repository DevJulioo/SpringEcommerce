package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.Usuario;

public class UserLoginDTO {


    private String email;
    private String senha;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UserLoginDTO(Usuario entity){
        email = entity.getEmail();
        senha = entity.getSenha();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
