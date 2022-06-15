
/*
Created by hussein shamas on June 15, 2022;
 */
public class rocketU1 extends Rocket {

    public rocketU1() {
        weight = 10;
        cost = 100;
        maxWeightWithCargo = 18; // tons
        landExplosion = 0.0;
        launchExplosion = 0.0;
        currentWeight = weight;
    }

    @Override
    public boolean land() {
        int randomNumber = (int) (Math.random() * 100 + 1);
        this.landExplosion = 1.0 * (this.currentWeight - this.weight)
                / (this.maxWeightWithCargo - this.weight);
        return this.launchExplosion <= randomNumber;
    }

    @Override
    public boolean launch() {
        int randomNumber = (int) (Math.random() * 100 + 1);
        this.launchExplosion = 5.0 * (this.currentWeight - this.weight)
                / (this.maxWeightWithCargo - this.weight);


        return this.launchExplosion <= randomNumber;
    }


}
