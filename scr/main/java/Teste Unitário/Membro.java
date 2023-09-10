import java.util.ArrayList;
import java.util.List;
public class Membro{
    private int id;
    private String nome;
    private List<Livro> livrosEmprestados;
    //Construtor;
    public Membro(int id, String nome){
        this.id = id;
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }
    //gets;
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public List<Livro> getLivrosEmprestados(){
        return livrosEmprestados;
    }
    //Emprestar Livro;
    public void emprestarLivro(Livro livro){
        livro.emprestar();
        livrosEmprestados.add(livro);
    }
    //Devolver Livro;
    public void devolverLivro(Livro livro){
        livro.retornar();
        livrosEmprestados.remove(livro);
    }
}
