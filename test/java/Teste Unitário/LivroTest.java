import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class LivroTest{
    @Test
    public void testCriarLivro(){
        //Cria o livro;
        Livro livro = new Livro(1, "Aventuras de Sherlock Holmes", "Arthur Conan Doyle", false);
        assertEquals(1, livro.getID());
        assertEquals("Aventuras de Sherlock Holmes", livro.getTitulo());
        assertEquals("Arthur Conan Doyle", livro.getAutor());
        //Verifica se o livro não está emprestado;
        assertFalse(livro.getEmprestado());
    }
    @Test
    public void testEmprestarLivro(){
        Livro livro = new Livro(2, "Alice no País das Maravilhas", "Charles Lutwidge Dodgson", false);
        livro.emprestar();//Marca o livro como emprestado;
        //Verifica se o livro está emprestado;
        assertTrue(livro.getEmprestado());
    }
    @Test
    public void testRetornarLivro(){
        Livro livro = new Livro(3, "A Volta ao Mundo em 80 Dias", "Júlio Verne", true);
        livro.retornar();//Marca o livro como não emprestado;
        //Verifica se o livro está não emprestado;
        assertFalse(livro.getEmprestado());
    }
}
