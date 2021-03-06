package br.com.iupp.learn.core.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
data class Produto (
    @Column(nullable = false)
    var nome: String = "",

    var descricao: String= "",

    @Column(nullable = false)
    var preco: Double = 0.0,

    @Column(nullable = false)
    var emailDono: String = "",

    @Id
    @GeneratedValue
    var id: Long? = null,
    val criadoEm: LocalDateTime = LocalDateTime.now()
)
