import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation();

        ArrayList<Item> phase1 = (ArrayList<Item>) sim.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = (ArrayList<Item>) sim.loadItems("phase-2.txt");


        ArrayList<Rocket> u1FleetPhase1 = sim.loadU1(phase1);
        ArrayList<Rocket> u1FleetPhase2 = sim.loadU1(phase2);


        System.out.println("\nU1 rocket cost = 100");
        int budgetU1phase1 = sim.runSimulation(u1FleetPhase1);
        System.out.println("Budget of U1 fleet for phase 1 = " + budgetU1phase1 + " (millions)");

        int budgetU1phase2 = sim.runSimulation(u1FleetPhase2);
        System.out.println("Budget of U1 fleet for phase 2 = " + budgetU1phase2 + " (millions)");

        System.out.println("Total budget of U1 fleet = " + (budgetU1phase1 + budgetU1phase2) + " (millions)\n");


        ArrayList<Rocket> u2FleetPhase1 = sim.loadU2(phase1);
        ArrayList<Rocket> u2FleetPhase2 = sim.loadU2(phase2);
        System.out.println("\nU2 rocket cost = 120");
        int budgetU2phase1 = sim.runSimulation(u2FleetPhase1);
        System.out.println("Budget of U2 fleet for phase 1 = " + budgetU2phase1 + " (millions)");

        int budgetU2phase2 = sim.runSimulation(u2FleetPhase2);
        System.out.println("Budget of U2 fleet for phase 2 = " + budgetU2phase2 + " (millions)");

        System.out.println("Total budget of U1 fleet = " + (budgetU2phase1 + budgetU2phase2) + " (millions)\n");

    }
}
