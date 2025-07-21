package com.cStoreDtb.storage.domain;

import com.cStoreDtb.storage.domain.enums.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
public class Endereco extends Entidade{
    @Column(nullable = false, unique = false, length = 100)
    private String logradouro;
    @Column(nullable = false, unique = false, length = 10)
    private String numero;
    @Column(nullable = false, unique = false, length = 100 )
    private String complemento;
    @Column(nullable = false, unique = false, length = 100 )
    private String bairro;
    @Column(nullable = false, unique = false, length = 100)
    private String cidade;
    @Column(nullable = false, unique = false, length = 20)
    private Estado estado;
    @Column(nullable = false, unique = false, length = 10)
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O campo 'cep' deve ter o formato '12345-678'")
    private String cep;
}
