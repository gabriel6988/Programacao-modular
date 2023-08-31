import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RelogioTestSucesso{
    @Test
    //Pode ser programado com horas, minutos e segundos.
    public void programarHorarioTest(){
        Relogio.RelogioDigital relogio = new Relogio.RelogioDigital(0, 0, 0);
        Relogio.programarHorario(relogio, 8, 30, 0);
    }

    @Test
    //Pode ser reiniciado para meia noite a pedido do usuário.
    public void reiniciarMeiaNoiteTest(){
        Relogio.RelogioDigital relogio = new Relogio.RelogioDigital(1, 1, 1);
        Relogio.reiniciarMeiaNoite(relogio);
        assertEquals(0, relogio.getHoras());
        assertEquals(0, relogio.getMinutos());
        assertEquals(0, relogio.getSegundos());
    }

    @Test
    /*Pode marcar um intervalo de tempo. O usuário informa 
    quando se inicia e quando termina a marcação (função cronômetro) 
    e o relógio responde o tempo decorrido.*/
    public void marcarIntervaloTest(){
        //Tempo Inicial;
        int inicioHoras = 3;
        int inicioMinutos = 50;
        int inicioSegundos = 25;
        //Tempo Final;
        int fimHoras = 5;
        int fimMinutos = 55;
        int fimSegundos = 40;
        
        int expectedInterval = (fimHoras - inicioHoras) * 3600 + (fimMinutos - inicioMinutos) * 60
            + (fimSegundos - inicioSegundos);
        
        int intervalo = Relogio.marcarIntervalo(inicioHoras, inicioMinutos, inicioSegundos, fimHoras, fimMinutos, fimSegundos);
        
        assertEquals(expectedInterval, intervalo);//Compara o valor esperado com o valor da função marcarIntervalo();
    }
    
    @Test
    //Pode imprimir a hora no formato 24h ou AM/PM
    public void imprimirHoraTest(){
        Relogio.RelogioDigital relogio = new Relogio.RelogioDigital(0, 0, 0);
        Relogio.programarHorario(relogio, 8, 30, 0);
        Relogio.imprimirHora(true, relogio);
        Relogio.imprimirHora(false, relogio);
    }

    @Test
    /*Não passa o tempo sozinho, mas atualiza corretamente 
    o horário quando recebe indicação de passagem do tempo do 
    Sistema Operacional.*/
    public void atualizarHorarioTest(){
        Relogio.RelogioDigital relogio = new Relogio.RelogioDigital(0, 0, 0);
        Relogio.atualizarHorario(relogio);
    }
}