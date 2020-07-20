package hu.maximuseweb;

public class Main {
    public static void main(String[] args) {
	    Actions.fileToList("eredmenyek.csv");
        System.out.println(Actions.task3("Real Madrid"));
        System.out.println(Actions.task4());
    }
}