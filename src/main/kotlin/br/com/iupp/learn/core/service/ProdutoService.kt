package br.com.iupp.learn.core.service

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.entrypoint.dto.NovoProdutoRequest
import io.micronaut.http.HttpResponse

interface ProdutoService {
    fun create(produto: NovoProdutoRequest):HttpResponse<Produto>

    fun getById(id: Long): HttpResponse<Produto>

    fun update(id: Long, request: NovoProdutoRequest): HttpResponse<Produto>

    fun delete(id: Long) : HttpResponse<Produto>

}