package com.cStoreDtb.storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vendas")
public class Vendas extends Entidade{
    @ManyToOne
    @JoinColumn(name = "cliente_cpf_id")
    private ClienteCpf clienteCpf;

    @ManyToOne
    @JoinColumn(name = "cliente_cnpj")
    private ClienteCnpj clienteCnpj;

    @Column(nullable = false)
    private LocalDate dataVenda;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private String formaPagamento;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens = new ArrayList<>();
}
