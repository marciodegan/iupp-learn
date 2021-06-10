package br.com.iupp.learn.core.port

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import io.micronaut.http.HttpResponse

interface ProdutoServicePort {
    fun create(produto: Produto):ProdutoDto

    fun getById(id: Long): HttpResponse<Produto>

    fun update(id: Long, dto: ProdutoDto): HttpResponse<Produto>

    fun delete(id: Long) : HttpResponse<Produto>
}