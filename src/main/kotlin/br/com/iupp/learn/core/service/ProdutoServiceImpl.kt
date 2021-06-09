package br.com.iupp.learn.core.service

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.repository.ProdutoRepository
import br.com.iupp.learn.entrypoint.dto.NovoProdutoRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import javax.inject.Singleton

@Singleton
class ProdutoServiceImpl(val repository: ProdutoRepository) : ProdutoService {

    override fun create(produto: NovoProdutoRequest): HttpResponse<Produto> {
        val produtoNovo = produto.toModel()
        return HttpResponse.created(HttpStatus.CREATED).body(repository.save(produtoNovo))
    }

    override fun getById(id: Long): HttpResponse<Produto> {
        val produto = repository.findById(id)
        if (produto.isEmpty) {
            return HttpResponse.notFound()
        }
        return HttpResponse.ok(produto.get())
    }

    override fun update(id: Long, request: NovoProdutoRequest): HttpResponse<Produto> {
        val produto = repository.findById(id)
        if (produto.isEmpty) {
            return HttpResponse.notFound()
        }
        val produtoUpdate = produto.get()
        produtoUpdate.nome = request.nome
        produtoUpdate.preco = request.preco
        produtoUpdate.emailDono = request.emailDono
        produtoUpdate.descricao = request.descricao

        repository.save(produtoUpdate)

        return HttpResponse.ok(produtoUpdate)
    }

    override fun delete(id: Long) : HttpResponse<Produto> {
        val produto = repository.findById(id)
        if (produto.isEmpty) {
            return HttpResponse.notFound()
        }
        repository.delete(produto.get())
        return HttpResponse.ok()
    }
}

