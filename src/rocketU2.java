public class rocketU2 extends Rocket {


    public rocketU2() {
        weight = 18;
        cost = 120;
        maxWeightWithCargo = 29;
        landExplosion = 0.0;
        launchExplosion = 0.0;
        currentWeight = weight;
    }

    public boolean land() {
        int randomNumber = (int) (Math.random() * 100 + 1);
        this.landExplosion = 8.0 * (this.currentWeight - this.weight) / (this.maxWeightWithCargo - this.weight);
        return this.launchExplosion <= randomNumber;
    }

    @Override
    public boolean launch() {
        int randomNumber = (int) (Math.random() * 100 + 1);
        this.launchExplosion = 4.0 * (this.currentWeight - this.weight) / (this.maxWeightWithCargo - this.weight);


        return this.launchExplosion <= randomNumber;
    }
}
