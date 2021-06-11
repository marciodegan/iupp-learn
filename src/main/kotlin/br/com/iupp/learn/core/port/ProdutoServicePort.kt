package br.com.iupp.learn.core.port

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.entrypoint.dto.ProdutoDto

interface ProdutoServicePort {
    fun create(produto: Produto) : ProdutoDto

    fun getById(id: Long): ProdutoDto

    fun update(id: Long, dto: ProdutoDto): ProdutoDto

    fun delete(id: Long) : ProdutoDto
}