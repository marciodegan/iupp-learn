package br.com.iupp.learn.core.mapper

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.database.entity.ProdutoEntity
import br.com.iupp.learn.entrypoint.dto.ProdutoDto

class ProdutoConverter {
    companion object{
        fun produtoDtoToProduto(produtoDto: ProdutoDto) =
            Produto(produtoDto.nome,produtoDto.descricao,produtoDto.preco,produtoDto.emailDono)
        fun produtoToProdutoEntity(produto: Produto)=
            ProdutoEntity(produto.nome,produto.descricao,produto.preco,produto.emailDono,null)
        fun produtoEntityToProduto(produtoEntity: ProdutoEntity)=
            Produto(produtoEntity.nome,produtoEntity.descricao,produtoEntity.preco,produtoEntity.emailDono)
        fun produtoToProdutoDto(produto: Produto)=
            ProdutoDto(produto.nome,produto.descricao,produto.preco,produto.emailDono)
    }
}