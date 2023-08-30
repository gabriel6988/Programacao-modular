import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RelogioTest{
    @Test
    /*Pode ser programado com horas, minutos e segundos.*/
    public void atualizarHorarioTest(){
        RelogioDigital relogio = new RelogioDigital();
        relogio.programarHorario(8, 30, 0);
    }
    /*Pode ser reiniciado para meia noite a pedido do usuário.*/
    public void ReiniciarTest(){
        RelogioDigital relogio = new RelogioDigital();
        int valor = 1;
        relogio.setHoras(valor);
        relogio.setMinutos(valor);
        relogio.setSegundos(valor);
        relogio.reiniciarMeiaNoite();
        assertEquals(0, relogio.getHoras());
        assertEquals(0, relogio.getMinutos());
        assertEquals(0, relogio.getSegundos());
    }
    /*Pode marcar um intervalo de tempo. O usuário informa 
    quando se inicia e quando termina a marcação (função cronômetro) 
    e o relógio responde o tempo decorrido.*/
    public void IntervaloTest(){
        RelogioDigital relogio = new RelogioDigital();
        //Tempo Inicial;
        int inicioHoras = 3;
        int inicioMinutos = 50;
        int inicioSegundos = 25;
        //Tempo Final;
        int fimHoras = 5;
        int fimMinutos = 55;
        int fimSegundos = 40;
        int intervalo = relogio.marcarIntervalo(inicioHoras, inicioMinutos, inicioSegundos, 
        fimHoras, fimMinutos, fimSegundos);
        //(2*3600) + (5*60) + (15) = 7515;
        assertEquals(7515, intervalo);//Marcado em segundos;
    }
    /*Pode imprimir a hora no formato 24h ou AM/PM*/
    public void imprimirHoraTest(){
        RelogioDigital relogio = new RelogioDigital();
        relogio.programarHorario(8, 30, 0);
        relogio.imprimirHora(true);
        relogio.imprimirHora(false);
    }
    /*Não passa o tempo sozinho, mas atualiza corretamente 
    o horário quando recebe indicação de passagem do tempo do 
    Sistema Operacional.*/
    public void atualizarTest(){
        RelogioDigital relogio = new RelogioDigital();
        relogio.atualizarHorario();
    }
}
