package enteties;

import dao.EventoDao;
import dao.LocationDao;
import dao.PartecipazioneDao;
import dao.PersonaDao;
import enumerations.Sesso;
import enumerations.Stato;
import enumerations.TipoEvento;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        EventoDao eventoDao = new EventoDao();
        PersonaDao personaDao = new PersonaDao();
        LocationDao locationDao = new LocationDao();
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao();


        Evento ev = new Evento("Concerto", LocalDate.of(2025, 5,25),
                "Concerto a Roma", TipoEvento.PUBBLICO, 15000);

        Evento ev2  = new Evento("fiera",
                LocalDate.of(2025, 5,25), "fiera di paese", TipoEvento.PUBBLICO, 1500);

        eventoDao.save(ev);
        eventoDao.save(ev2);

        Location l1 = new Location("Colosseo", "Roma");
        Location l2 = new Location("Piazzale Ilio", "Trapani");

       locationDao.save(l1);
       locationDao.save(l2);

       ev.setLocation(l1);
       ev2.setLocation(l2);

       eventoDao.save(ev);
       eventoDao.save(ev2);


        Persona p1 = new Persona("Giulio", "Cesare", "cesares@gmail.com",
                LocalDate.of(1924,5,21), Sesso.M);
        Persona p2 = new Persona("Salvatore", "Gianquinto", "turutu@gmail.com",
                LocalDate.of(2001,12,11), Sesso.M);

        personaDao.save(p1);
        personaDao.save(p2);


        Partecipazione par1 = new Partecipazione(Stato.CONFERMATA);
        Partecipazione par2 = new Partecipazione(Stato.CONFERMATA);

        partecipazioneDao.save(par1);
        partecipazioneDao.save(par2);

        par1.setEvento(ev);
        par2.setEvento(ev2);

        par1.setPersona(p1);
        par2.setPersona(p2);

        partecipazioneDao.save(par1);
        partecipazioneDao.save(par2);






    }
}
