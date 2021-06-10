package br.com.iupp.learn.database.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class ProdutoEntity (
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
