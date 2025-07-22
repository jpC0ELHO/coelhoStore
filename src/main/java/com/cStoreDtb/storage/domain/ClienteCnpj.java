package com.cStoreDtb.storage.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente_cnpj")
public class ClienteCnpj extends Entidade {
    @CNPJ
    @Column(name = "cnpj",length = 14,unique = true)
    private String cnpj;
    @Column(length = 15,unique = true)
    private String razaoSocial;
    @Column(name = "nome_fantasia",length = 15,unique = true)
    private String nomeFantasia;
    @Column(length = 30,unique = true)
    private String responsavel;
    @Column(length = 100,unique = true)
    private Set<String> email;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "entidade_cnpj_telefones",referencedColumnName = "telefones")
    @Column(nullable = false)
    private Set<Telefone> telefone;
    @Column(name = "atividade")
    private String status;
    @Embedded
    private Endereco endereco;
}
