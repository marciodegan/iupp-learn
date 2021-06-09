package br.com.iupp.learn.entrypoint.controller

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.repository.ProdutoRepository
import br.com.iupp.learn.core.service.ProdutoService
import br.com.iupp.learn.entrypoint.dto.NovoProdutoRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/produtos")
class ProdutoController(private val service: ProdutoService) {

    @Post
    @Transactional
    fun create(@Body @Valid produto: NovoProdutoRequest): HttpResponse<Produto> {

        return service.create(produto)
    }

    @Get("/{id}")
    @Transactional
    fun getById(@QueryValue id: Long): HttpResponse<Produto> {

        return service.getById(id)
    }

    @Put("/{id}")
    @Transactional
    fun update(@QueryValue id: Long, @Body @Valid request: NovoProdutoRequest): HttpResponse<Produto> {

        return service.update(id, request)
    }

    @Delete("/{id}")
    @Transactional
    fun delete(@QueryValue id: Long): HttpResponse<Produto> {

        return service.delete(id)
    }
}