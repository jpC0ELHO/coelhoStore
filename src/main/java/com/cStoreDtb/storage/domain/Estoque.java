package com.cStoreDtb.storage.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "estoque")
public class Estoque extends Entidade {

    @OneToOne
    private Produtos produtos;

    private int quantidadeAtual;
    private int quantidadeMinima;
    private int quantidadeMaxima;
    private LocalDate dataUltimaEntrada;
    private LocalDate dataUltimaSaida;
}
