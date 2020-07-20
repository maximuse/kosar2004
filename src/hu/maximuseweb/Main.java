package hu.maximuseweb;

public class Main {
    public static void main(String[] args) {
	    Actions.fileToList("eredmenyek.csv");
        System.out.println(Actions.task3("Real Madrid"));
        System.out.println(Actions.task4());
        System.out.println(Actions.task5("barcelona"));
        Actions.task6("2004-11-21");
    }
}