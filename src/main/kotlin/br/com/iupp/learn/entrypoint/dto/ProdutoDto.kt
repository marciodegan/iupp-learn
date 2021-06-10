package br.com.iupp.learn.entrypoint.dto

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

@Introspected
data class ProdutoDto(@field:NotBlank val nome: String,
                      @field:Size(max=100) val descricao: String,
                      @field:Positive val preco: Double,
                      @field:NotBlank @field:Email val emailDono: String)
