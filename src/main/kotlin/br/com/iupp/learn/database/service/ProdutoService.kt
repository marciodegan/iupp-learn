package br.com.iupp.learn.database.service

import br.com.iupp.learn.core.mapper.ProdutoConverter
import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.port.ProdutoRepositoryPort
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.database.repository.ProdutoRepository
import br.com.iupp.learn.entrypoint.dto.ProdutoDto
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class ProdutoService(private val produtoRepository: ProdutoRepository) : ProdutoRepositoryPort {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    override fun create(produtoEntity: ProdutoEntity): Produto {
        produtoRepository.save(produtoEntity)
        return ProdutoConverter.produtoEntityToProduto(produtoEntity)
    }

    override fun getById(id: Long): Produto {
        val produto = produtoRepository.findById(id).get()
        return ProdutoConverter.produtoEntityToProduto(produto)
    }

    override fun update(id: Long, dto: ProdutoDto): Produto {
        val produtoBuscado = produtoRepository.findById(id)

        val produto = produtoBuscado.get()
        produto.nome = dto.nome
        produto.descricao = dto.descricao
        produto.preco = dto.preco
        produto.emailDono = dto.emailDono

        produtoRepository.save(produto)

        return ProdutoConverter.produtoEntityToProduto(produto)
    }

    override fun delete(id: Long): Produto {
        val produtoBuscado = produtoRepository.findById(id)
        val produto = produtoBuscado.get()
        produtoRepository.delete(produto)

        return ProdutoConverter.produtoEntityToProduto(produto)
    }
}