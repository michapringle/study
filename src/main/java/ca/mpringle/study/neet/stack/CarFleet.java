package ca.mpringle.study.neet.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CarFleet {

    private CarFleet() {
    }

    /**
     * There are n cars traveling to the same destination on a one-lane highway.
     * <p>
     * You are given two arrays of integers position and speed, both of length n.
     * <p>
     * position[i] is the position of the ith car (in miles)
     * speed[i] is the speed of the ith car (in miles per hour)
     * <p>
     * The destination is at position target miles.
     * <p>
     * A car can not pass another car ahead of it. It can only catch up to another car and
     * then drive at the same speed as the car ahead of it.
     * <p>
     * A car fleet is a non-empty set of cars driving at the same position and same speed.
     * A single car is also considered a car fleet.
     * <p>
     * If a car catches up to a car fleet the moment the fleet reaches the destination,
     * then the car is considered to be part of the fleet.
     * <p>
     * Return the number of different car fleets that will arrive at the destination.
     * <p>
     * 4:30 -> 5:47 - not hard, but took me a while to get the logic right
     */
    static int carFleet(final int target, final int[] positions, final int[] speeds) {

        if (positions.length == 1) {
            return 1;
        }
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            cars.add(new Car(target - positions[i], speeds[i]));
        }

        Collections.sort(cars);
        int numberOfFleets = 1;

        Car fleetLeader = cars.get(0);
        for (int i = 0; i < cars.size() - 1; i++) {
            if (!fleetLeader.isSameFleet(cars.get(i + 1))) {
                fleetLeader = cars.get(i + 1);
                numberOfFleets++;
            }
        }

        return numberOfFleets;
    }

    static class Car implements Comparable<Car> {
        private final int distanceToDestination;
        private final double timeToDestination;

        public Car(final int distanceToDestination, final int speed) {

            this.distanceToDestination = distanceToDestination;
            this.timeToDestination = distanceToDestination * 1.0D / speed;
        }

        public boolean isSameFleet(final Car car) {

            // this.car is the same time to destination or more
            return timeToDestination >= car.timeToDestination;
        }

        /**
         * Closest to destination are first.
         */
        @Override
        public int compareTo(final Car car) {
            return Double.compare(distanceToDestination, car.distanceToDestination);
        }

        @Override
        public String toString() {
            return String.format("o-o(%s m, %s h)", distanceToDestination, timeToDestination);
        }
    }
}
