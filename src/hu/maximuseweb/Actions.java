package hu.maximuseweb;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Actions {
    private static ArrayList<Match> list;

    private static ArrayList<Match> getList() {
        return list;
    }

    private static void setList(ArrayList<Match> list) {
        Actions.list = list;
    }

    static void fileToList(String fileName) {
        ArrayList<Match> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            row = raf.readLine();

            String[] slice;

            while (row != null) {
                slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

                list.add(new Match(slice[0], slice[1], Integer.parseInt(slice[2]), Integer.parseInt(slice[3]), slice[4], slice[5]));

                row = raf.readLine();
            }

            raf.close();

            setList(list);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static String task3(String teamName) {
        String tn = new String(teamName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        int home = 0;
        int guest = 0;

        for (Match match : Actions.getList()) {
            if (match.getHomeName().equals(tn)) {
                home++;
            }
            else if (match.getGuestName().equals(tn)) {
                guest++;
            }
        }

        return "3. feladat: " + teamName + ": Hazai: " + home + ", Idegen: " + guest;
    }

    static String task4() {
        boolean result = false;

        for (Match match : Actions.getList()) {
            if (match.getHomePoints() == match.getGuestPoints()) {
                result = true;
                break;
            }
        }

        return "4. feladat: Volt döntetlen? " + ((result) ? "igen" : "nem");
    }

    static String task5(String search) {
        String s = new String(search.toLowerCase().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String name = "";

        for (Match match : Actions.getList()) {
            if (match.getHomeName().toLowerCase().contains(s)) {
                name = match.getHomeName();
                break;
            }
            else if (match.getGuestName().toLowerCase().contains(s)) {
                name = match.getGuestName();
                break;
            }
        }

        return "5. feladat: barcelonaicsapat neve: " + name;
    }

    static void task6(String date) {
        ArrayList<String> result = new ArrayList<>();

        for (Match match : Actions.getList()) {
            if (match.getDate().equals(date)) {
                result.add(match.getHomeName() + " - " + match.getGuestName() + " (" + match.getHomePoints() + ":" + match.getGuestPoints() + ")");
            }
        }

        System.out.println("6. feladat: ");
        result.forEach((value) -> System.out.println("\t" + value));
    }

    static void task7(int min) {
        TreeSet<String> stadiums = new TreeSet<>();
        Map<String, Integer> matchPerStadium = new HashMap<>();
        int counter;

        for (Match match : Actions.getList()) {
            stadiums.add(match.getVenue());
        }


        for (String stadium : stadiums) {
            counter = 0;

            for (Match match : Actions.getList()) {
                if (stadium.equals(match.getVenue())) {
                    counter++;
                }
            }

            matchPerStadium.put(stadium, counter);
        }

        System.out.print("7. feladat: ");
        matchPerStadium.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach((value) -> System.out.print((value.getValue() > min) ? "\n\t" + value.getKey() + ": " + value.getValue() : ""));
    }
}