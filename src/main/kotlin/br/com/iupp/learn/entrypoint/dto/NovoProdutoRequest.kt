package br.com.iupp.learn.entrypoint.dto

import br.com.iupp.learn.core.model.Produto
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

@Introspected
data class NovoProdutoRequest(@field:NotBlank val nome: String,
                              @field:Size(max=100) val descricao: String,
                              @field:Positive val preco: Double,
                              @field:NotBlank @field:Email val emailDono: String) {
    fun toModel(): Produto {
        return Produto(nome, descricao, preco, emailDono)
    }

}
