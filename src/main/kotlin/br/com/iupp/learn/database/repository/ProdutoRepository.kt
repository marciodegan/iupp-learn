package br.com.iupp.learn.database.repository

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.database.entity.ProdutoEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ProdutoRepository : JpaRepository<ProdutoEntity, Long> {
}