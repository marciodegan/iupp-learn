package br.com.iupp.learn.core.port

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import io.micronaut.http.HttpResponse
import javax.inject.Singleton

@Singleton
interface  ProdutoRepositoryPort {
    fun create(produto: ProdutoEntity): Produto

    fun getById(id: Long): HttpResponse<Produto>

    fun update(id: Long, dto: ProdutoDto): HttpResponse<Produto>

    fun delete(id: Long) : HttpResponse<Produto>
}