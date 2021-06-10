package br.com.iupp.learn.database.service

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.port.ProdutoRepositoryPort
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.database.repository.ProdutoRepository
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import io.micronaut.http.HttpResponse
import javax.inject.Singleton

@Singleton
class ProdutoService(private val produtoRepository: ProdutoRepository): ProdutoRepositoryPort {
    override fun create(produtoEntity: ProdutoEntity): Produto {
        //TODO Enity
        produtoRepository.save(produtoEntity)
        return ProdutoConverter.produtoEntityToProduto(produtoEntity)
    }

    override fun getById(id: Long): HttpResponse<Produto> {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, dto: ProdutoDto): HttpResponse<Produto> {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): HttpResponse<Produto> {
        TODO("Not yet implemented")
    }
}