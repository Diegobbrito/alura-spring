package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {
    
    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
        String nomeCurso = "HTML 5";
        Curso curso = repository.findByNome(nomeCurso);
        assertNotNull(curso);
        assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
        String nomeCurso = "HTML 5";
        Curso curso = repository.findByNome(nomeCurso);
        assertNull(curso);
    }
}