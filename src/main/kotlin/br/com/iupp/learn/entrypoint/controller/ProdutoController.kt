package br.com.iupp.learn.entrypoint.controller

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.port.ProdutoServicePort
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.transaction.Transactional
import javax.validation.Valid
import kotlin.IllegalArgumentException

@Validated
@Controller("/produtos")
class ProdutoController(private val service: ProdutoServicePort) {

    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    @Post
    @Transactional
    fun create(@Body @Valid produto: ProdutoDto): HttpResponse<ProdutoDto> {
        return HttpResponse.created(service.create(ProdutoConverter.produtoDtoToProduto(produto)))
    }

    @Get("/{id}")
    @Transactional
    fun getById(@QueryValue id: Long): HttpResponse<ProdutoDto> {
        try {
            return HttpResponse.ok(service.getById(id))
        } catch (e: Exception) {
            throw IllegalArgumentException("Id não encontrado") // dúvidas sobre como lidar com exceptions
        }
    }

    @Put("/{id}")
    @Transactional
    fun update(@QueryValue id: Long, @Body @Valid dto: ProdutoDto): HttpResponse<ProdutoDto> {
        val serviceResponse = service.update(id, dto)
        return HttpResponse.ok(serviceResponse)
    }

    @Delete("/{id}")
    @Transactional
    fun delete(@QueryValue id: Long): HttpResponse<ProdutoDto> {
        return HttpResponse.ok(service.delete(id))
    }
}