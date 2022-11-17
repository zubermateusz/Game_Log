class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me
        this.minutes += 1;
        if (this.minutes == 60) {
            this.minutes = 0;
            this.hours++;
        }
        if (this.hours > 12) {
            this.hours = 1;
        }
    }
}