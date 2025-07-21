package com.cStoreDtb.storage.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produtos")
public class Produtos extends Entidade{
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String codigoDeBarras;
    private String categoria;
    private String unidadeMedida; //UN, KG, L
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private boolean ativo;
}
