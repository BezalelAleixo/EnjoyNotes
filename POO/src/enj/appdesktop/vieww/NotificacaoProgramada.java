package enj.appdesktop.vieww;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class NotificacaoProgramada {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            agendarNotificacao(15, 44, "Notificação Recebida");
        });
    }

    private static void agendarNotificacao(int hora, int minuto, String mensagem) {
        Timer timer = new Timer();

        // Obter a hora atual
        Calendar agora = Calendar.getInstance();
        int horaAtual = agora.get(Calendar.HOUR_OF_DAY);
        int minutoAtual = agora.get(Calendar.MINUTE);

        // Calcular a diferença de tempo até a próxima notificação
        long delay = calcularDelay(hora, minuto, horaAtual, minutoAtual);

        // Agendar a tarefa de notificação para o tempo especificado
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                exibirNotificacao(mensagem);
            }
        }, delay);
    }

    private static long calcularDelay(int horaAlvo, int minutoAlvo, int horaAtual, int minutoAtual) {
        Calendar alvo = Calendar.getInstance();
        alvo.set(Calendar.HOUR_OF_DAY, horaAlvo);
        alvo.set(Calendar.MINUTE, minutoAlvo);
        alvo.set(Calendar.SECOND, 0);
        alvo.set(Calendar.MILLISECOND, 0);

        long delay = alvo.getTimeInMillis() - System.currentTimeMillis();

        // Se o horário-alvo já passou, ajustar para o próximo dia
        if (delay < 0) {
            alvo.add(Calendar.DAY_OF_MONTH, 1);
            delay = alvo.getTimeInMillis() - System.currentTimeMillis();
        }

        return delay;
    }

    private static void exibirNotificacao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Notificação", JOptionPane.INFORMATION_MESSAGE);
    }
}

