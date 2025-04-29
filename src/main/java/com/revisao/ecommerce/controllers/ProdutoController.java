package com.revisao.ecommerce.controllers;

import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProdutoController {


    @Autowired
    ProdutoService produtoService;

    @GetMapping( value = "/all")
    public List<ProdutoDTO> findAll() {
        return produtoService.findAll();
    }

    @GetMapping(value = "/page")
    public Page<ProdutoDTO> findAll(Pageable pagina){
        return produtoService.findPagina(pagina);
    }

    @PostMapping( value = "/new")
    public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO dto){
        dto = produtoService.insert(dto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping( value = "/updt/{id}")
    public  ResponseEntity<ProdutoDTO> updateProduct(@RequestBody ProdutoDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.updateProduct(id, dto));
    }

    @DeleteMapping( value = "/dell/{id}")
    public  ResponseEntity<?> dellProduct(@PathVariable Long id){
       boolean deleted = produtoService.dellProduct(id);

        if(deleted){
            return ResponseEntity.ok().body("Produto deletado com sucesso");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
    }


}
