package kk.spybackend.locations.service;

import kk.spybackend.locations.model.Location;
import org.springframework.stereotype.Component;

@Component
public class DefaultLocationsManager {
    private static final String DEFAULT_LOCATIONS = """
    [
      {"number":0,"name":"Samolot","roles":["Pasażer pierwszej klasy","Agent ochrony","Mechanik","Pasażer klasy ekonomicznej","Stewardessa","Pierwszy oficer","Kapitan"],"isActive":true},
      {"number":1,"name":"Bank","roles":["Kierowca samochodu opancerzonego","Menadżer","Konsultant","Klient","Rabuś","Ochroniarz","Kasjer"],"isActive":true},
      {"number":2,"name":"Plaża","roles":["Kelnerka","Surfer","Ratownik","Złodziej","Plażowicz","Fotograf","Kierowca furgonetki z lodami","Zboczeniec"],"isActive":true},
      {"number":3,"name":"Teatr","roles":["Szatniarka","Sufler","Kasjer","Gość","Dyrektor","Aktor","Członek ekipy"],"isActive":true},
      {"number":4,"name":"Kasyno","roles":["Barman","Szef ochrony","Bramkarz","Menadżer","Kanciarz","Krupier","Hazardzista"],"isActive":true},
      {"number":5,"name":"Katedra","roles":["Ksiądz","Żebrak","Grzesznik","Parafianin","Turysta","Sponsor","Chórzysta"],"isActive":true},
      {"number":6,"name":"Cyrk","roles":["Akrobata","Treser zwierząt","Magik","Gość","Połykacz ogni","Klaun","Żongler"],"isActive":true},
      {"number":7,"name":"Impreza firmowa","roles":["Artysta","Menadżer","Niechciany gość","Właściciel","Sekretarka","Księgowy","Kurier"],"isActive":true},
      {"number":8,"name":"Spa","roles":["Klient","Stylista","Masażysta","Manicurzysta","Makijażysta","Kosmetyczna"],"isActive":true},
      {"number":9,"name":"Ambasada","roles":["Ochroniarz","Sekretarka","Ambasador","Oficjel rządowy","Turysta","Uchodźca","Dyplomata"],"isActive":true},
      {"number":10,"name":"Szpital","roles":["Pielęgniarka","Doktor","Anestezjolog","Stażysta","Pacjent","Terapeuta","Chirurg"],"isActive":true},
      {"number":11,"name":"Hotel","roles":["Portier","Ochroniarz","Menadżer","Sprzątaczka","Klient","Barman"],"isActive":true},
      {"number":12,"name":"Baza wojskowa","roles":["Dezerter","Pułkownik","Medyk","Żołnierz","Snajper","Oficer","Inżynier czołgowy"],"isActive":true},
      {"number":13,"name":"Studio filmowe","roles":["Kaskader","Dźwiękowiec","Kamerzysta","Reżyser","Kostriumograf","Aktor","Producent"],"isActive":true},
      {"number":14,"name":"Statek rejsowy","roles":["Bogaty pasażer","Kapitan","Barman","Muzyk","Kelner","Mechanik"],"isActive":true},
      {"number":15,"name":"Pociąg pasażerski","roles":["Maszynista","Straż Graniczna","Konduktor","Pasażer","Szef kuchni","Palacz"],"isActive":true},
      {"number":16,"name":"Statek piracki","roles":["Marynarz","Niewolnik","Kanonier","Związany jeniec","Chłopiec kabinowy","Odważny kapitan"],"isActive":true},
      {"number":17,"name":"Stacja polarna","roles":["Medyk","Geolog","Dowódca wyprawy","Biolog","Radiooperator","Hydrolog","Meteorolog"],"isActive":true},
      {"number":18,"name":"Posterunek policji","roles":["Detektyw","Prawnik","Dziennikarz","Kryminalista","Archiwista","Funkcjonariusz patrolu","Przestępca"],"isActive":true},
      {"number":19,"name":"Restauracja","roles":["Muzyk","Klient","Bramkarz","Kelnerka","Szef kuchni","Krytyk kulinarny"],"isActive":true},
      {"number":20,"name":"Szkoła","roles":["Nauczyciel","Uczeń","Dyrektor","Ochroniarz","Woźny","Kucharka"],"isActive":true},
      {"number":21,"name":"Stacja kosmiczna","roles":["Inżynier","Obcy","Kosmiczny turysta","Pilot","Dowódca","Naukowiec","Doktor"],"isActive":true},
      {"number":22,"name":"Łódź podwodna","roles":["Dowódca","Technik sonarowy","Technik elektroniki","Marynarz","Radiooperator","Nawigator"],"isActive":true},
      {"number":23,"name":"Super market","roles":["Klient","Kasjer","Rzeźnik","Woźny","Ochroniarz","Demonstator próbek jedzenia","Układający na półkach"],"isActive":true},
      {"number":24,"name":"Uniwersytet","roles":["Absolwent","Profesor","Dziekan","Psycholog","Obsługa techniczna","Student","Woźny"],"isActive":true},
      {"number":25,"name":"Park Rozrywki","roles":["Operator karuzeli","Rodzic","Sprzedawca jedzenia","Kasjer","Szczęśliwe dziecko","Wkurzające dziecko","Nastolatek"],"isActive":true},
      {"number":26,"name":"Muzeum sztuki","roles":["Sprzedawca biletów","Gość","Ochroniarz","Malarz","Kolekcjoner sztuki","Krytyk","Fotograf","Turysta"],"isActive":true},
      {"number":27,"name":"Cmentarz","roles":["Ksiądz","Hiena Cmentarna","Poeta","Osoba w żałobie","Trup","Sprzedawca Kwiatów","Grabarz"],"isActive":true},
      {"number":28,"name":"Plac Budowlany","roles":["Dziecko bez nadzoru","Operator dźwigu","Oficer Bezpieczeństwa","Elektryk","Inżynier","Architekt","Pracownik Budowy"],"isActive":true},
      {"number":29,"name":"Konwent Gier","roles":["Blogger","Cosplayer","Gracz","Wystawca","Kolekcjoner","Dziecko","Ochroniarz","Geek","Znana osobowość"],"isActive":true},
      {"number":30,"name":"Więzienie","roles":["Niesłusznie oskarżona osoba","Operator kamer ochrony","Strażnik więzienny","Gość","Prawnik","Woźny","Dozorca","Przestępca"],"isActive":true},
      {"number":31,"name":"Biblioteka","roles":["Staruszek","Student","Pisarz","Bibliotekarz","Gaduła","Fanatyk książek"],"isActive":true},
      {"number":32,"name":"Klub nocny","roles":["Bywalec","Barman","Ochroniarz","Tancerka","Podrywacz","Imprezowiczka","Modelka","Pijany"],"isActive":true},
      {"number":33,"name":"Koncert","roles":["Tancerz","Wokalista","Fan","Gitarzysta","Perkusista","Obsługa techniczna","Ochroniarz"],"isActive":true},
      {"number":34,"name":"Autobus krajoznawczy","roles":["Staruszek","Samotny turysta","Kierowca","Irytujący dzieciak","Turysta","Przewodnik","Fotograf","Turysta","Zagubiona osoba"],"isActive":true},
      {"number":35,"name":"Stadion","roles":["Sanitariusz","Młociarz","Atleta","Komentator","Widz","Ochroniarz","Sędzia","Sprzedawca jedzenia","Tyczkarz"],"isActive":true},
      {"number":36,"name":"Metro","roles":["Turysta","Maszynista","Kontroler biletów","Ciężarna kobieta","Kieszonkowiec","Biznesman","Staruszka"],"isActive":true},
      {"number":37,"name":"Wesele","roles":["Pan młody","Panna młoda","Fotograf","Ojciec panny młodej","Nieproszony gość","Świadek","Najebany wujek","DJ"],"isActive":true},
      {"number":38,"name":"Zoo","roles":["Opiekun zwierząt","Zwiedzający","Fotograf","Dziecko","Weterynarz","Turysta","Sprzedawca jedzenia","Kasjer","Opiekun zwierząt"],"isActive":true}
    ]
    """;
    public final String NAME = "default";
    private Long defaultId;

    public Location loadDefaultLocations() {
        Location location = new Location();
        location.setLocations(DEFAULT_LOCATIONS);
        location.setName(NAME);
        return location;
    }

    public void setDefaultId(Long id) {
        defaultId = id;
    }

    public Long getDefaultId() {
        return defaultId;
    }
}
