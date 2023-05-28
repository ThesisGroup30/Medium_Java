package Medium_Java;

import java.util.Arrays;

public class _853 {
	public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }
        
        Arrays.sort(cars, (a, b) -> Double.compare(a.position, b.position));
        
        int fleets = 0;
        double maxTime = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i].time > maxTime) {
                maxTime = cars[i].time;
                fleets++;
            }
        }
        
        return fleets;
    }
    
    class Car {
        int position;
        double time;
        
        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}
