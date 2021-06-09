package br.com.iupp.learn.entrypoint.controller

import br.com.iupp.learn.core.model.Produto
import br.com.iupp.learn.core.repository.ProdutoRepository
import br.com.iupp.learn.entrypoint.dto.NovoProdutoRequest
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class ProdutoControllerTest {

    @field:Inject
    lateinit var produtoRepository: ProdutoRepository

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    lateinit var produto: Produto

    @BeforeEach
    internal fun setup() {
        produto = Produto(
            nome = "Produto XYZ",
            descricao = "Produto muito bom",
            preco = 10.9,
            emailDono = "teste@testes.com.br"
        )
        produtoRepository.save(produto)
    }

    @AfterEach
    internal fun tearDown() {
        produtoRepository.deleteAll()
    }

    @Test
    internal fun `deve inserir um produto`() {
        // cenário
        val novoProdutoRequest = NovoProdutoRequest(
            nome = "Produto 1",
            descricao = "Produto muito bom",
            preco = 10.9,
            emailDono = "teste@testes.com.br"
        )

        val request: HttpRequest<Any> = HttpRequest.POST("/produtos", novoProdutoRequest)

        val response = client.toBlocking().exchange(request, Any::class.java)

        assertEquals(HttpStatus.CREATED, response.status)
    }


    @Test
    internal fun `deve retornar os detalhes de um produto`() {

        val request: HttpRequest<Any> = HttpRequest.GET("/produtos/1")
        val response = client.toBlocking().exchange(request, Produto::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertEquals("Produto XYZ", response.body()!!.nome)
    }

    @Test
    internal fun `deve deletar um produto`() {

        val request: HttpRequest<Any> = HttpRequest.DELETE("/produtos/2")
        val response = client.toBlocking().exchange(request, Produto::class.java)

        assertEquals(HttpStatus.OK, response.status)

    }

    @Test
    internal fun `deve atualizar um produto`() {

        val novoProdutoRequest = NovoProdutoRequest(
            nome = "Produto Atualizado",
            descricao = "Produto muito bom",
            preco = 10.9,
            emailDono = "teste@testes.com.br"
        )

        val request: HttpRequest<Any> = HttpRequest.PUT("/produtos/3", novoProdutoRequest)
        val response = client.toBlocking().exchange(request, Produto::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertEquals("Produto Atualizado", response.body()!!.nome)
    }
}