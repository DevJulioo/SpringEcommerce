package com.revisao.ecommerce.controllers;

import com.revisao.ecommerce.dto.UserLoginDTO;
import com.revisao.ecommerce.dto.UsuarioDTO;
import com.revisao.ecommerce.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/new")
    public ResponseEntity<UsuarioDTO> cadastar(@RequestBody @Valid UsuarioDTO dto){
        dto = usuarioService.cadastrar(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody UsuarioDTO dto){
        boolean valid = usuarioService.login(dto);
        if(valid) {
            return  ResponseEntity.ok("Login realizado com sucesso");
        }
        return  ResponseEntity.status(401).body("Senha ou Email incorreto!");
    }

}
