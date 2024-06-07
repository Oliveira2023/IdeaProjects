package map.Ordenacao;

import java.time.LocalDate;
import java.util.*;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, evento);
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
//        Set<LocalDate> dataSet = eventosMap.keySet();
//        System.out.println(dataSet);
//        Collection<Evento> values = eventosMap.values();
//        eventosMap.get();
//        System.out.println(values);
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (entry.getKey().isAfter(dataAtual) || entry.getKey().isEqual(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("Proximo Evento: " + proximoEvento + " acontecerá na data: " + proximaData);
                break;
            }


        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.parse("2024-06-30"), "visita vó", "muitas brincadeira");
        agendaEventos.adicionarEvento(LocalDate.parse("2024-06-07"), "Festa junina", "só diversão");
        agendaEventos.adicionarEvento(LocalDate.parse("2024-06-10"), "Niver Lo", "Novidade");
        agendaEventos.adicionarEvento(LocalDate.parse("2023-06-10"), "Evento passado", "Sem Novidade");

//        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();

    }
}
