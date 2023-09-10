import java.util.ArrayList;
import java.util.List;
public class Biblioteca{
    private List<Livro> livros;
    private List<Membro> membros;
    //Construtor;
    public Biblioteca(){
        livros = new ArrayList<>();
        membros = new ArrayList<>();
    }
    //Gets;
    public List<Livro> getLivros(){
        return livros;
    }
    //Registrar livro;
    public void registrarLivro(Livro livro){
        livros.add(livro);
    }
    //Registrar membro;
    public void registrarMembro(Membro membro){
        membros.add(membro);
    }
    //Emprestar livro;
    public void emprestarLivro(int livroId, int membroId){
        Livro livro = buscarLivroPorId(livroId);
        Membro membro = buscarMembroPorId(membroId);
        if(livro == null || membro == null){//Caso o livro ou o membro não exista;
            System.out.println("Livro ou membro não encontrado.");
            return;
        }
        else if(livro.getEmprestado()){//Caso o livro esteja já emprestado;
            System.out.println("O livro já está emprestado.");
        }
        else{
            //Adicona o livro na lista de livros emprestados do membro;
            membro.emprestarLivro(livro);
            System.out.println("Livro emprestado com sucesso para " + membro.getNome());
        }
    }
    //Retornar Livro;
    public void retornarLivro(int livroId, int membroId){
        Livro livro = buscarLivroPorId(livroId);
        Membro membro = buscarMembroPorId(membroId);
        if(livro == null || membro == null){//Caso o livro ou o membro não exista;
            System.out.println("Livro ou membro não encontrado.");
            return;
        }
        else if(!livro.getEmprestado()){//Caso o livro não esteja emprestado;
            System.out.println("O livro não está emprestado.");
        } 
        else{
            //Remove o livro da lista de livros emprestados do membro;
            membro.devolverLivro(livro);
            System.out.println("Livro retornado com sucesso por " + membro.getNome());
        }
    }
    //Procura o livro por ID;
    private Livro buscarLivroPorId(int livroId){
        for(Livro livro : livros){
            if(livro.getID() == livroId){
                return livro;
            }
        }
        return null;
    }
    //Procura o Membro por ID;
    private Membro buscarMembroPorId(int membroId){
        for(Membro membro : membros){
            if(membro.getId() == membroId){
                return membro;
            }
        }
        return null;
    }
}
