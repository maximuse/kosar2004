package hu.maximuseweb;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
}