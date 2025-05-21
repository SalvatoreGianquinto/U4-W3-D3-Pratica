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
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        EventoDao dao = new EventoDao();
        PersonaDao personaDao = new PersonaDao();
        LocationDao locationDao = new LocationDao();
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao();


        Evento ev = new Evento("Concerto",
                LocalDate.of(2025, 5,25), "Concerto a Roma", TipoEvento.PUBBLICO, 15000);

        Persona p1 = new Persona("Salvatore", "Gianquinto", "turutu@gmail.com",
                LocalDate.of(2001,12,11), Sesso.M, new ArrayList<>());

        Location l1 = new Location("Colosseo", "Roma");

        Partecipazione par1 = new Partecipazione(ev, p1, Stato.CONFERMATA);


        locationDao.save(l1);

        ev.setLocation(l1);
        dao.save(ev);

        personaDao.save(p1);
        partecipazioneDao.save(par1);

        p1.getPartecipazioni().add(par1);
        personaDao.save(p1);


    }
}
