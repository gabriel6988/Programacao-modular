import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
public class BibliotecaTest{
    @Test
    public void testRegistrarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "Aventuras de Sherlock Holmes", "Arthur Conan Doyle", false);
        biblioteca.registrarLivro(livro);
        assertTrue(biblioteca.getLivros().contains(livro));
    }
    @Test
    public void testEmprestarLivroParaMembro(){
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "Aventuras de Sherlock Holmes", "Arthur Conan Doyle", false);
        Membro membro = new Membro(1, "João");
        biblioteca.registrarLivro(livro);//Registrar livro na biblioteca;
        biblioteca.registrarMembro(membro);//Registrar membro na biblioteca;
        biblioteca.emprestarLivro(livro.getID(), membro.getId());
        //Verifica se o livro está marcado com emprestado;
        assertTrue(livro.getEmprestado());
        //Verifica se o livro foi adicionado a lista de livros emprestados do membro;
        assertTrue(membro.getLivrosEmprestados().contains(livro));
    }
    @Test
    public void testRetornarLivroDeMembro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(7, "The King in Yellow", "Robert William Chambers", false);
        Membro membro = new Membro(4, "Maria");
        biblioteca.registrarLivro(livro);//Registrar livro na biblioteca;
        biblioteca.registrarMembro(membro);//Registrar membro na biblioteca;
        biblioteca.emprestarLivro(livro.getID(), membro.getId());
        assertTrue(livro.getEmprestado());//Verifica se foi emprestado;
        biblioteca.retornarLivro(livro.getID(), membro.getId());
        assertFalse(livro.getEmprestado());//Verifica se foi retornado;
        //Verifica se foi removido da lista de livros emprestados do membro;
        assertFalse(membro.getLivrosEmprestados().contains(livro));
    }
    @Test
    public void testEmprestarLivroNaoDisponivel(){
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(9, "Recipes of the 15th century", "Ser Andérs", false);
        Membro membro1 = new Membro(8, "Marcos");
        Membro membro2 = new Membro(9, "Ana");
        biblioteca.registrarLivro(livro);//Registra o livro;
        //Registra membros;
        biblioteca.registrarMembro(membro1);
        biblioteca.registrarMembro(membro2);
        //Empresta o livro para o membro1 (disponível);
        biblioteca.emprestarLivro(livro.getID(), membro1.getId());
        //Empresta o livro para o membro2 (não disponível);
        biblioteca.emprestarLivro(livro.getID(), membro2.getId());
        //Verifica se o livro está marcado como emprestado;
        assertTrue(livro.getEmprestado());
        //Verifica as listas de livros de membro1 e membro2;
        assertTrue(membro1.getLivrosEmprestados().contains(livro));
        assertFalse(membro2.getLivrosEmprestados().contains(livro));
    }
}
