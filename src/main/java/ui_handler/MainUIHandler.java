package ui_handler;

import connection.ConnectionUtil_HikariCP;
import dto.CitalacStatsDTO;
import dto.SerijalStatsDTO;
import dto.SerijalZanrStatsDTO;
import model.Serijal;
import model.Strip;
import service.ComplexFunctionalityService;
import service.DataSeedingService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MainUIHandler {
    public static Scanner sc = new Scanner(System.in);
    private static final ComplexFunctionalityService complexFunctionalityService = new ComplexFunctionalityService();
    private static final DataSeedingService dataSeedingService = new DataSeedingService();
    public void handleMainMenu() {
        String answer;

        do {
            printMenu();
            answer = sc.nextLine();
            handleAnswer(answer);

        }
        while (!answer.equalsIgnoreCase("X"));

        sc.close();
    }

    private void printMenu(){
        System.out.println("\nOdaberite opciju:");
        System.out.println("1 - Inicijalizovanje baze i podataka (DDL i DML)");
        System.out.println("2 - Izvestaj o serijalu i broju zanrova"); // jednostavan upit
        System.out.println("3 - Izvestaj o serijalima sa vise od jednog stripa (info o autorima i prosecnom broju delova)"); // kompleksan upit
        System.out.println("4 - Izvestaj o procitanom broju delova stripa po korisniku"); // kompleksan upit
        System.out.println("5 - Direktan unos stripa i serijala sa istim naslovom (napravi se Serijal sa istim naslovom, kao i red u poveznoj tabeli Pripada)"); // transakcija
        System.out.println("X - Izlazak iz programa");
    }

    private void handleAnswer(String answer){
        switch(answer) {
            case "1":
                try {
                    dataSeedingService.runDDL();
                    dataSeedingService.runDML();
                }
                catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                    ConnectionUtil_HikariCP.closeDataSource();
                }
                break;
            case "2":
                showSerijalZanrStats();
                break;
            case "3":
                showSerijalStats();
                break;
            case "4":
                System.out.println("Username (mivanovic, ajovanovic, ptomic): ");
                String usrnm = sc.nextLine();
                showCitalacStats(usrnm);
                break;
            case "5":
                createStripWithSerijal();
                break;
            case "x":
            case "X":
                break;
            default:
                System.out.println("Pogresan broj. Aj ponovo.");
        }
    }

    private void createStripWithSerijal() {
        try {
            String naslov = null; // za testiranje transakcije

            System.out.println("Unesite naslov stripa: ");
            String naslovInput = sc.nextLine();
            if(!naslovInput.isBlank()){
                naslov = naslovInput;
            }

            System.out.println("Unesite datum pocetka (format: yyyy-MM-dd): ");
            String datumPocetkaInput = sc.nextLine();

            System.out.println("Unesite datum zavrsetka (format: yyyy-MM-dd): ");
            String datumZavrsetkaInput = sc.nextLine();

            LocalDate datumPocetka = LocalDate.parse(datumPocetkaInput);
            LocalDate datumZavrsetka = LocalDate.parse(datumZavrsetkaInput);

            Strip strip = new Strip(naslov, datumPocetka, datumZavrsetka);

            complexFunctionalityService.createStripWithSerijal(strip);

        } catch (DateTimeParseException e) {
            System.out.println("Neispravan format datuma! Koristite: yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showCitalacStats(String usrnm) {
        try {
            List<CitalacStatsDTO> dtos = complexFunctionalityService.getCitalacStats(usrnm);

            System.out.println("============");
            System.out.println("Izvestaj o stripovima koje je procitao korisnik: " + usrnm);
            System.out.println("============");

            if (!dtos.isEmpty()) {
                System.out.printf("%-40s | %-20s | %-15s%n", "Naslov stripa", "Procitanih delova", "Ukupno delova");
                System.out.println("-------------------------------------------------------------------------------");

                for (CitalacStatsDTO dto : dtos) {
                    System.out.printf("%-40s | %-20d | %-15d%n",
                            dto.getNaslovStripa(),
                            dto.getBrojProcitanihDelova(),
                            dto.getMaxDelova());
                }
            } else {
                System.out.println("Korisnik " + usrnm + " nije procitao nijedan strip.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void showSerijalZanrStats() {
        try{
            List<SerijalZanrStatsDTO> dtos = complexFunctionalityService.getSerijalZanrStats();

            System.out.println("============");
            System.out.println("Izvestaj o serijalima i broju zanrova po serijalu.");
            System.out.println("============");
            if(!dtos.isEmpty()){
                System.out.printf("%-30s | %-15s%n", "Naslov serijala", "Broj žanrova");
                System.out.println("-----------------------------------------------");
                for(SerijalZanrStatsDTO dto : dtos){
                    System.out.printf("%-30s | %-15d%n", dto.getNaslov(), dto.getBrojZanrova());
                }
            }
            else{
                System.out.println("Nema serijala.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSerijalStats() {
        try {
            List<SerijalStatsDTO> dtos = complexFunctionalityService.getSerijalStats();
            System.out.println("============");
            System.out.println("Izvestaj o serijalima: naziv serijala, lista glavnih autora,\nkoliko ima stripova po serijalu, koliko prosecno ima delova po stripu,\nsortirano po broju stripova opadajuce.");
            System.out.println("============");
            if (!dtos.isEmpty()) {
                System.out.printf("%-30s | %-60s | %-15s | %-20s%n",
                        "Naslov serijala", "Glavni autori", "Broj stripova", "Prosek delova po stripu");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (SerijalStatsDTO dto : dtos) {
                    String autori = String.join(", ", dto.getGlavniAutori());

                    System.out.printf("%-30s | %-60s | %-15d | %-20d%n",
                            dto.getNaslov(), autori, dto.getBrojStripova(), dto.getBrojDelovaPoStripu());
                }
            } else {
                System.out.println("Nema serijala sa više od jednog stripa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
