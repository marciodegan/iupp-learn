package br.com.iupp.learn.core.port

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import io.micronaut.http.HttpResponse
import javax.inject.Singleton

@Singleton
interface  ProdutoRepositoryPort {
    fun create(produtoEntity: ProdutoEntity): Produto

    fun getById(id: Long): Produto

    fun update(id: Long, dto: ProdutoDto): Produto

    fun delete(id: Long): Produto
}