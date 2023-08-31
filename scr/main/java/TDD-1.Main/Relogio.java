import java.util.Calendar;
public class Relogio{
    //Class RelogioDigital;
    public static class RelogioDigital{
        private int horas;
        private int minutos;
        private int segundos;
        //Construtor;
        public RelogioDigital(int horas, int minutos, int segundos){
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        }
        //Getters e Setters;
        public int getHoras(){return horas;}
        public void setHoras(int horas){this.horas = horas;}
        public int getMinutos(){return minutos;}
        public void setMinutos(int minutos){this.minutos = minutos;}
        public int getSegundos(){return segundos;}
        public void setSegundos(int segundos){this.segundos = segundos;}
    }
    //Pode ser programado com horas, minutos e segundos;
    public static void programarHorario(RelogioDigital relogio, int horas, int minutos, int segundos){
        //Define o horário programado pelo usuário;
        if(60 <= segundos){//Caso passe de 60 segundos;
            segundos -= 60;
            minutos += 1;
        }
        if(60 <= minutos){//Caso passe de 60 minutos;
            minutos -= 60;
            horas += 1;
        }
        if(24 <= horas){
            horas = 0;
            minutos = 0;
            segundos = 0;
        }
        relogio.setHoras(horas);
        relogio.setMinutos(minutos);
        relogio.setSegundos(segundos);
    }
    //Pode ser reiniciado para meia noite a pedido do usuário;
    public static void reiniciarMeiaNoite(RelogioDigital relogio){
        //Reinicia o relógio para meia-noite (0:00:00);
        relogio.setHoras(0);
        relogio.setMinutos(0);
        relogio.setSegundos(0);
    }
    /*Pode marcar um intervalo de tempo. O usuário informa quando se inicia e quando
    termina a marcação (função cronômetro) e o relógio responde o tempo decorrido.*/
    public static int marcarIntervalo(int inicioHoras, int inicioMinutos, int inicioSegundos,
    int fimHoras, int fimMinutos, int fimSegundos){
        //Calcula o tempo decorrido entre o início e o fim do intervalo;
        int segundosDecorridos = (fimHoras - inicioHoras) * 3600 + (fimMinutos - inicioMinutos) * 60
        + (fimSegundos - inicioSegundos);
        System.out.println("Tempo decorrido: " + segundosDecorridos + " segundos");
        return segundosDecorridos;
    }
    //Pode imprimir a hora no formato 24h ou AM/PM;
    public static void imprimirHora(boolean formato24h, RelogioDigital relogio){
        //Imprime a hora no formato especificado;
        if(formato24h){
            System.out.printf("%02d:%02d:%02d\n", relogio.getHoras(), 
            relogio.getMinutos(), relogio.getSegundos());
        } 
        else{
            String amPm = (relogio.getHoras() < 12) ? "AM" : "PM";
            int hora12h = (relogio.getHoras() == 0 || relogio.getHoras() == 12) ? 12 : relogio.getHoras() % 12;
            System.out.printf("%02d:%02d:%02d %s\n", hora12h, relogio.getMinutos(), relogio.getSegundos(), amPm);
        }
    }
    /*Não passa o tempo sozinho, mas atualiza corretamente o horário quando recebe
    indicação de passagem do tempo do Sistema Operacional.*/
    public static void atualizarHorario(RelogioDigital relogio){
        //Método para atualizar o horário com base no tempo do sistema operacional;
        Calendar calendario = Calendar.getInstance();
        relogio.setHoras(calendario.get(Calendar.HOUR_OF_DAY));
        relogio.setMinutos(calendario.get(Calendar.MINUTE));
        relogio.setSegundos(calendario.get(Calendar.SECOND));
    }
    //Main do programa;
    public static void main(String[] args){
        RelogioDigital relogio = new RelogioDigital(0,0,0);
        programarHorario(relogio, 5, 59, 60);
        imprimirHora(true, relogio);
        
        atualizarHorario(relogio);
        imprimirHora(false, relogio);
        
        int intervalo = marcarIntervalo(10, 15, 0, 11, 45, 30);
        
        reiniciarMeiaNoite(relogio);
        imprimirHora(true, relogio);
    }
}
