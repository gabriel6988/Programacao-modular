import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class MembroTest{
    @Test
    public void testCriarMembro(){
        //Cria um novo membro;
        Membro membro = new Membro(1, "João");
        assertNotNull(membro);
        assertEquals(1, membro.getId());
        assertEquals("João", membro.getNome());
        assertEquals(0, membro.getLivrosEmprestados().size());
    }
    @Test
    public void testMembroPegaEmprestado(){
        Membro membro = new Membro(2, "Maria");
        Livro livro = new Livro(1, "Aventuras de Sherlock Holmes", "Arthur Conan Doyle", false);
        Livro livro2 = new Livro(2, "The Call of Cthulhu", "H.P. Lovecraft", false);
        membro.emprestarLivro(livro);
        membro.emprestarLivro(livro2);
        assertEquals(2, membro.getLivrosEmprestados().size());
        //Verifica se os livros estão na lista do membro;
        assertTrue(membro.getLivrosEmprestados().contains(livro));
        assertTrue(membro.getLivrosEmprestados().contains(livro2));
        //Verifica se os livros estão marcados como emprestados;
        assertTrue(livro.getEmprestado());
        assertTrue(livro2.getEmprestado());
    }
    @Test
    public void testMembroRetornaLivro(){
        Membro membro = new Membro(3, "Carlos");
        Livro livro = new Livro(1, "Aventuras de Sherlock Holmes", "Arthur Conan Doyle", false);
        Livro livro2 = new Livro(2, "The Call of Cthulhu", "H.P. Lovecraft", false);
        membro.emprestarLivro(livro);
        membro.emprestarLivro(livro2);
        membro.devolverLivro(livro);
        assertEquals(1, membro.getLivrosEmprestados().size());
        assertFalse(membro.getLivrosEmprestados().contains(livro));
        assertTrue(membro.getLivrosEmprestados().contains(livro2));
        //Verifica se os livros estão marcados como não emprestados;
        assertFalse(livro.getEmprestado());
        assertTrue(livro2.getEmprestado());
    }
}
