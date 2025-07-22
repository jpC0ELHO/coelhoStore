package com.cStoreDtb.storage.domain;

import com.cStoreDtb.storage.domain.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente_cpf")
public class ClienteCpf extends Entidade{
    @CPF
    @Column(nullable = false, unique = true, length = 15)
    private String cpf;

    @Column(nullable = false,unique = true,length = 10)
    private String rg;

    @Column(nullable = false)
    private String primeiroNome;

    @Column(nullable = false)
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = false, length = 20)
    private Sexo sexo;

    @ElementCollection
    @CollectionTable(name = "tb_pessoafisica_email",
            joinColumns = @JoinColumn(name = "pessoafisica_cpf", referencedColumnName = "cpf"))
    @Column(name = "emails", nullable = false)
    private Set<String> email;

    @Column(nullable = false)
    @JoinColumn(name = "pessoafisica_cpf", referencedColumnName = "cpf")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Telefone> telefone;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Embedded
    private Endereco endereco;
}
