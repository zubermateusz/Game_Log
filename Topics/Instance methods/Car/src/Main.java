
class Car {

    int yearModel;
    String make;
    int speed;

    void accelerate() {
        this.speed = this.speed + 5;
    }

    void brake() {
        this.speed = this.speed - 5;
        if (this.speed < 0) {
            this.speed = 0;
        }
    }
}