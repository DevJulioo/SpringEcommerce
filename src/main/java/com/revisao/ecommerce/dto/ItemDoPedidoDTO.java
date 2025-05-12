package com.revisao.ecommerce.dto;

import com.revisao.ecommerce.entities.ItemDoPedido;

import java.util.ArrayList;
import java.util.List;

public class ItemDoPedidoDTO {

    private int quantidade;
    private double preco;
    private Long produtoId;
    private String nome;
    private String UrlImg;
    private List<ItemDoPedidoDTO> items = new ArrayList<>();

    public ItemDoPedidoDTO(){
    }

    public ItemDoPedidoDTO(int quantidade, double preco, Long produtoId, String nome, String urlImg) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produtoId = produtoId;
        this.nome = nome;
        this.UrlImg = urlImg;
    }

    public ItemDoPedidoDTO(ItemDoPedido entity) {
        this.quantidade = entity.getQuantidade();
        this.preco = entity.getPreco();
        this.produtoId = entity.getProduto().getId();
        this.nome = entity.getProduto().getNome();
        this.UrlImg = entity.getProduto().getImgUrl();
        for (ItemDoPedido item : entity.getPedido().getItems()){
            ItemDoPedidoDTO itemDto = new ItemDoPedidoDTO(item);
            items.add(itemDto);
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImg() {
        return UrlImg;
    }

    public void setUrlImg(String urlImg) {
        UrlImg = urlImg;
    }

    public Double getSubTotal(){
        return preco * quantidade;
    }
}
