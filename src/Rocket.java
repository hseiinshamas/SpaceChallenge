/*

Created by hussein shamas on june 15, 2022


 */

public class Rocket implements SpaceShip{
    int weight;
    int cost ;
    int maxWeightWithCargo;
    double launchExplosion;
    double landExplosion;
    int currentWeight;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return this.currentWeight + item.weight > maxWeightWithCargo;
    }

    @Override
    public void carry(Item item) {
        this.currentWeight = currentWeight + item.weight;
    }
}
