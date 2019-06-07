package headfirst.designpatterns.factory.robofactory.params;

public class RobotParams {

    final Param Common = new Param(2, 2, 1.0f, 0);
    final Param War = new Param(10, 2, 1.0f, 0);
    final Param Nano = new Param(2, 2, 1.0f, 0);

    private class Param {
        int strength;
        int arms;
        float speed;
        int power;

        public Param(int strength, int arms, float speed, int power) {
            this.strength = strength;
            this.arms = arms;
            this.speed = speed;
            this.power = power;
        }

        public int getStrength() {
            return strength;
        }

        public int getArms() {
            return arms;
        }

        public float getSpeed() {
            return speed;
        }

        public int getPower() {
            return power;
        }
    }
}
