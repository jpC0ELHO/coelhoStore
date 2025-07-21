package com.cStoreDtb.storage.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fornecedor")
public class Fornecedor {
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String cnpj;
    @Column(nullable = false,unique = true)
    private String telefone;
    @Column(nullable = false,unique = true)
    private String email;
    @Embedded
    private Endereco endereco;
}
