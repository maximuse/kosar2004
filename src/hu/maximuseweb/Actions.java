package hu.maximuseweb;

import java.util.ArrayList;

class Actions {
    private static ArrayList<Match> list;

    private static ArrayList<Match> getList() {
        return list;
    }

    private static void setList(ArrayList<Match> list) {
        Actions.list = list;
    }
}