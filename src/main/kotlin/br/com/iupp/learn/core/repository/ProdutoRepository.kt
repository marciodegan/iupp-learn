package br.com.iupp.learn.core.repository

import br.com.iupp.learn.core.model.Produto
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ProdutoRepository : JpaRepository<Produto, Long> {

}