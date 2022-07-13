package com.maikon.algafood;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {

//    @Autowired
//    private CadastroCozinhaService cadastroCozinha;
//
//    @Test
//    public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
//        // cenário
//        Cozinha novaCozinha = new Cozinha();
//        novaCozinha.setNome("Chinesa");
//
//        // ação
//        novaCozinha = cadastroCozinha.salvar(novaCozinha);
//
//        // validação
//        assertThat(novaCozinha).isNotNull();
//        assertThat(novaCozinha.getId()).isNotNull();
//    }
//
//    @Test
//    public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
//        Cozinha novaCozinha = new Cozinha();
//        novaCozinha.setNome(null);
//
//        ConstraintViolationException erroEsperado =
//                Assertions.assertThrows(ConstraintViolationException.class, () -> {
//                    cadastroCozinha.salvar(novaCozinha);
//                });
//
//        assertThat(erroEsperado).isNotNull();
//    }
//
//    @Test
//    public void deveFalhar_QuandoExcluirCozinhaEmUso() {
//        EntidadeEmUsoException entidadeEmUsoException =
//                Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
//                    cadastroCozinha.excluir(1L);
//                });
//    }
//
//    @Test
//    public void deveFalhar_QuandoExcluirCozinhaInexistente() {
//        CozinhaNaoEncontradaException cozinhaNaoEncontradaException =
//                Assertions.assertThrows(CozinhaNaoEncontradaException.class, () -> {
//                    cadastroCozinha.excluir(100L);
//                });
//    }


    @LocalServerPort
    private int port;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";

        flyway.migrate();
    }

    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

//    @Test
//    public void deveConter2Cozinhas_QuandoConsultarCozinhas() {
//        given()
//                .accept(ContentType.JSON)
//                .when()
//                .get()
//                .then()
//                .body("", hasSize(2));
//    }

    @Test
    public void deveRetornarStatus201_QuandoCadastrarCozinha() {
        given()
                .body("{ \"nome\": \"Chinesa\" }")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

//    @Test
//    public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaExistente() {
//        given()
//                .pathParam("cozinhaId", 2)
//                .accept(ContentType.JSON)
//                .when()
//                .get("/{cozinhaId}")
//                .then()
//                .statusCode(HttpStatus.OK.value())
//                .body("nome", equalTo("Americana"));
//    }

    @Test
    public void deveRetornarStatus404_QuandoConsultarCozinhaInexistente() {
        given()
                .pathParam("cozinhaId", 100)
                .accept(ContentType.JSON)
                .when()
                .get("/{cozinhaId}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}
