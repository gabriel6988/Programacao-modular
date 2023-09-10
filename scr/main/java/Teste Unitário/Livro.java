public class Livro{
    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;
    //Construtor;
    public Livro(int id, String titulo, String autor, boolean emprestado){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
    }
    //gets;
    public int getID(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public boolean getEmprestado(){
        return emprestado;
    }
    //sets;
    public void setID(int id){
        this.id = id;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }
    //Muda o status de um livro para emprestado;
    public void emprestar(){
        this.emprestado = true;
    }    
    //Muda o status de um livro para não emprestado;
    public void retornar(){
        this.emprestado = false;
    }
}
