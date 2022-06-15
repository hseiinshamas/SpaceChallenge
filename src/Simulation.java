import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

Created by hussein shamas on june 15, 2022


 */

// this class is responsible for reading item data and filling up the rockets
public class Simulation {
    List<Item> loadItems(String fileName) {
        File file = new File(fileName);
        Scanner s = new Scanner(System.in);
        ArrayList<Item> itemArrayList = new ArrayList<>();

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] item = line.split("=");
            itemArrayList.add(new Item(item[0], Integer.parseInt(item[1])));

        }
        System.out.println(fileName + "contains" + itemArrayList.size() + " items");
        return itemArrayList;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> rockets = new ArrayList<>();
        Rocket rocketU1 = new rocketU1();
        int itemsCounter = 1;
        int rocketsCounter = 1;
        System.out.println("\nRocket U1 weighs :  " + rocketU1.weight + ", Max weight : " + rocketU1.maxWeightWithCargo);

        for (Item item : list) {
            while (rocketU1.canCarry(item)) {
                System.out.println(" Adding next Item " + itemsCounter + ": " + item.name + " = " + item.weight + " failed -> No." + rocketsCounter + " U1 full");
                rocketsCounter++;
                rockets.add(rocketU1);
                rocketU1 = new rocketU1();
            }
            rocketU1.carry(item);
            itemsCounter++;
        }
        rockets.add(rocketU1);
        System.out.println("U1 feet contains " + rockets.size() + " rockets");

        return rockets;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> list) {
        ArrayList<Rocket> rockets = new ArrayList<>();
        Rocket rocketU2 = new rocketU2();
        int itemsCounter = 1;
        int rocketsCounter = 1;
        System.out.println("\nRocket U2 weighs :  " + rocketU2.weight + ", Max weight : " + rocketU2.maxWeightWithCargo);

        for (Item item : list) {
            while (rocketU2.canCarry(item)) {
                System.out.println(" Adding next Item " + itemsCounter + ": " + item.name + " = " + item.weight + " failed -> No." + rocketsCounter + " U1 full");
                rocketsCounter++;
                rockets.add(rocketU2);
                rocketU2 = new rocketU2();
            }
            rocketU2.carry(item);
            itemsCounter++;
        }
        rockets.add(rocketU2);
        System.out.println("U1 feet contains " + rockets.size() + " rockets");

        return rockets;
    }
        int runSimulation(ArrayList<Rocket> list) {
            int num = 0; //failed trials of launch/land
            int indexSuccess = 1;
            for (Rocket r : list) {

                while (!r.launch()) {
                    r.launch();
                    num++;
                }

                while (!r.land()) {
                    r.land();
                    num++;
                }
                indexSuccess++;
            }
            int budget = list.get(0).cost * (list.size() + num);
            System.out.println(list.size() + " rockets and " + num + " extra trials = "
                    + (list.size() + num) + " in total");
            return budget;
        }
    }
