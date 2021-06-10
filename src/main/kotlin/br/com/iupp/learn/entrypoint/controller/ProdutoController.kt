package br.com.iupp.learn.entrypoint.controller

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.port.ProdutoServicePort
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/produtos")
class ProdutoController(private val service: ProdutoServicePort) {

    @Post
    @Transactional
    fun create(@Body @Valid produto: ProdutoDto): HttpResponse<ProdutoDto> {
        return HttpResponse.created(service.create(ProdutoConverter.produtoDtoToProduto(produto)))
    }

    @Get("/{id}")
    @Transactional
    fun getById(@QueryValue id: Long): HttpResponse<Produto> {

        return service.getById(id)
    }

    @Put("/{id}")
    @Transactional
    fun update(@QueryValue id: Long, @Body @Valid dto: ProdutoDto): HttpResponse<Produto> {

        return service.update(id, dto)
    }

    @Delete("/{id}")
    @Transactional
    fun delete(@QueryValue id: Long): HttpResponse<Produto> {

        return service.delete(id)
    }
}