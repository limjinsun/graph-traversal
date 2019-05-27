import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class GreenTestDemo {

    private static final String input = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
    private static final String[] inputArray = input.split(", ");

    private static Graph myGraph = new Graph();
    private static GraphUtils gu = new GraphUtils((HashMap) myGraph.getIrishRailStationsInfoMap());

    public static void main(String[] args) {

        populateInputToGraphs(inputArray);
        
        LinkedList<Vertex> visited = new LinkedList<>();
        
        Vertex v11 = new Vertex("C");
        Vertex v12 = new Vertex("C");

       
        System.out.println(gu.getNumberOfEveryTrip(v11,v12, visited, 0));

//        welcome();
//        init();
    }

    private static void init() {

        boolean flag = true;

        while (flag) {
            enter();
            PRINT("\uD83C\uDD7F\uD83C\uDD7B\uD83C\uDD74\uD83C\uDD70\uD83C\uDD82\uD83C\uDD74 \uD83C\uDD82\uD83C\uDD74\uD83C\uDD7B\uD83C\uDD74\uD83C\uDD72\uD83C\uDD83 \uD83C\uDD7C\uD83C\uDD74\uD83C\uDD7D\uD83C\uDD84. \uD83C\uDD7D\uD83C\uDD84\uD83C\uDD7C\uD83C\uDD71\uD83C\uDD74\uD83C\uDD81 \uD83C\uDD78\uD83C\uDD7D\uD83C\uDD7F\uD83C\uDD84\uD83C\uDD83 \uD83C\uDD7E\uD83C\uDD7D\uD83C\uDD7B\uD83C\uDD88 \uD83C\uDD85\uD83C\uDD70\uD83C\uDD7B\uD83C\uDD78\uD83C\uDD73." );
            enter();
            PRINT("1. ᖴIᑎᗪ TᕼE ᗪIᔕTᗩᑎᑕE Oᖴ TᕼE ᖇOᑌTE ᗩ-ᗷ-ᑕ.");
            PRINT("2. ᖴIᑎᗪ TᕼE ᗪIᔕTᗩᑎᑕE Oᖴ TᕼE ᖇOᑌTE ᗩ-ᗪ.");
            PRINT("3. ᖴIᑎᗪ TᕼE ᗪIᔕTᗩᑎᑕE Oᖴ TᕼE ᖇOᑌTE ᗩ-ᗪ-ᑕ..");
            PRINT("4. ᖴIᑎᗪ TᕼE ᗪIᔕTᗩᑎᑕE Oᖴ TᕼE ᖇOᑌTE ᗩ-E-ᗷ-ᑕ-ᗪ.");
            PRINT("5. ᖴIᑎᗪ TᕼE ᗪIᔕTᗩᑎᑕE Oᖴ TᕼE ᖇOᑌTE ᗩ-E-ᗪ");
            PRINT("5. ᖴIᑎᗪ TᕼE ᗪIᔕTᗩᑎᑕE Oᖴ TᕼE ᖇOᑌTE ᗩ-E-ᗪ");
            PRINT("6. ᖴIᑎᗪ TᕼE ᑎᑌᗰᗷEᖇ Oᖴ TᖇIᑭᔕ ᔕTᗩᖇTIᑎG ᗩT \"ᑕ\" ᗩᑎᗪ EᑎᗪIᑎG ᗩT \"ᑕ\" ᗯITᕼ ᗩ ᗰᗩ᙭Iᗰᑌᗰ Oᖴ 3 ᔕTOᑭᔕ.");
            PRINT("7. ᖴIᑎᗪ TᕼE ᑎᑌᗰᗷEᖇ Oᖴ TᖇIᑭᔕ ᔕTᗩᖇTIᑎG ᗩT ᗩ ᗩᑎᗪ EᑎᗪIᑎG ᗩT ᑕ ᗯITᕼ E᙭ᗩᑕTᒪY 4 ᔕTOᑭᔕ");
            PRINT("8. ᖴIᑎᗪ TᕼE ᒪEᑎGTᕼ Oᖴ TᕼE ᔕᕼOᖇTEᔕT ᖇOᑌTE ᖴᖇOᗰ ᗩ TO ᑕ");
            PRINT("9. ᖴIᑎᗪ TᕼE ᒪEᑎGTᕼ Oᖴ TᕼE ᔕᕼOᖇTEᔕT ᖇOᑌTE ᖴᖇOᗰ ᗷ TO ᗷ.");
            PRINT("10. ᖴIᑎᗪ TᕼE ᑎᑌᗰᗷEᖇ Oᖴ ᗪIᖴᖴEᖇEᑎT ᖇOᑌTEᔕ ᖴᖇOᗰ ᑕ TO ᑕ ᗯITᕼ ᗩ ᗪIᔕTᗩᑎᑕE Oᖴ ᒪEᔕᔕ Tᕼᗩᑎ 30");
            PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
            PRINT("11. E᙭IT.");

            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) sc.next();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 8:
                    task8();
                    break;
                case 9:
                    task9();
                    break;
                case 10:
                    task10();
                    break;
                case 11:
                    flag = false;
                    break;
                default:
                    break;

            }
        }

        goodbye();

    }

    public static void populateInputToGraphs(String[] array) {
        //System.out.println("populating...");
        for (String str : array) {
            char[] chars = str.toCharArray();
            Vertex v1 = new Vertex(String.valueOf(chars[0]));
            Vertex v2 = new Vertex(String.valueOf(chars[1]));
            int distance = Integer.valueOf(String.valueOf(chars[2]));

            myGraph.addStation(v1);
            myGraph.addStation(v2);
            myGraph.addWeightedEdge(v1, v2, distance);
        }
    }

    private static void welcome() {
        enter();
        PRINT("█▀▀▀ █▀▀█ █▀▀ █▀▀ █▀▀▄ █▀▀ ░▀░ █▀▀▄ █▀▀ █░░█   █▀▀ █▀▀█ █▀▀ ▀▀█▀▀\n" +
                "█░▀█ █▄▄▀ █▀▀ █▀▀ █░░█ █▀▀ ▀█▀ █░░█ █░░ █▀▀█   ▀▀█ █░░█ █▀▀ ░░█░░\n" +
                "▀▀▀▀ ▀░▀▀ ▀▀▀ ▀▀▀ ▀░░▀ ▀░░ ▀▀▀ ▀░░▀ ▀▀▀ ▀░░▀   ▀▀▀ ▀▀▀▀ ▀░░ ░░▀░░");
        enter();
    }

    private static void goodbye() {
        enter();
        PRINT("▀▀█▀▀ █░░█ █▀▀█ █▀▀▄ █░█ █▀▀\n" +
                "░░█░░ █▀▀█ █▄▄█ █░░█ █▀▄ ▀▀█\n" +
                "░░▀░░ ▀░░▀ ▀░░▀ ▀░░▀ ▀░▀ ▀▀▀");
        enter();
        PRINT("Greenfinch coding test. 2019.");
        PRINT("If you have anything to ask, Don't hesitate to contact me.");
        PRINT("All works has been done solely by myself.");
        PRINT("Jin Lim. 087 2119 531. limjinsun@gmail.com");
    }

    private static void task1() {
        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getDistanceOfROUTE("A-B-C"));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task2() {
        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getDistanceOfROUTE("A-D"));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task3() {
        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getDistanceOfROUTE("A-D-C"));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task4() {
        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getDistanceOfROUTE("A-E-B-C-D"));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task5() {
        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getDistanceOfROUTE("A-E-D"));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task6() {
        Vertex v1 = new Vertex("C");
        Vertex v2 = new Vertex("C");
        LinkedList<Vertex> visited = new LinkedList<>();

        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getNumberOfTripsMaxHop(v1, v2, visited, 3));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task7() {
        Vertex v3 = new Vertex("A");
        Vertex v4 = new Vertex("C");
        LinkedList<Vertex> visited = new LinkedList<>();

        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getNumberOfTripExactHop(v3, v4, visited, 4));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task8() {
        Vertex v5 = new Vertex("A");
        Vertex v6 = new Vertex("C");

        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getShortestPath(v5,v6));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task9() {
        Vertex v7 = new Vertex("B");
        Vertex v8 = new Vertex("B");

        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getShortestPath(v7,v8));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }

    private static void task10() {
        enter();
        enter();
        PRINT("TᕼE ᗩᑎᔕᗯEᖇ Iᔕ..");
        System.out.println(gu.getDistanceOfROUTE("A-E-D"));
        PRINT("︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽︽");
    }





    /**helper method **/

    public static void enter() {
        System.out.println("");
    }

    static void PRINT(String str) {
        System.out.println(str);
    }

}
