package br.com.iupp.learn.core.service

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.port.ProdutoRepositoryPort
import br.com.iupp.learn.core.port.ProdutoServicePort
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import io.micronaut.http.HttpResponse
import javax.inject.Singleton

@Singleton
class ProdutoService(private val produtoRepositoryPort: ProdutoRepositoryPort): ProdutoServicePort {
    override fun create(produto: Produto): ProdutoDto {
        produtoRepositoryPort.create(ProdutoConverter.produtoToProdutoEntity(produto))
        return ProdutoConverter.produtoToProdutoDto(produto)
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