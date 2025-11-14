package ca.mpringle.study.neet.binarysearch;

import java.util.Arrays;

final class Bananas {

    private Bananas() {
    }

    /**
     * You are given an integer array piles where piles[i] is the number of bananas in the
     * ith pile. You are also given an integer hours, which represents the number of hours you
     * have to eat all the bananas.
     * <p>
     * You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a
     * pile of bananas and eats k bananas from that pile. If the pile has less than k
     * bananas, you may finish eating the pile, but you can not eat from another pile
     * in the same hour.
     * <p>
     * Return the minimum integer k such that you can eat all the bananas within hours hours.
     * <p>
     * 3:15 -> 5:06
     */
    static int minEatingSpeed(final int[] piles, final int hours) {

        return minEatingSpeedNov10(piles, hours);
    }

    static int minEatingSpeedNov10(final int[] piles, final int hours) {

        if (hours < 1 || hours < piles.length) {
            return -1;
        }

        // the average of the entire pile is also the minimum
        int maxRate = Arrays.stream(piles).max().getAsInt();
        // the minimum rate can't be less than this
        int rate = Math.max(0, (maxRate / hours) - 1);

        long hoursSpentEating;
        do {
            hoursSpentEating = 0;
            rate++;
            for (int size : piles) {
                hoursSpentEating += (int) Math.ceil(size * 1.0D / rate);
            }

        } while (hoursSpentEating > hours);

        return rate;
    }

    static int minEatingSpeedOriginal(final int[] piles, final int hours) {

        if (hours < 1 || hours < piles.length) {
            return -1;
        }

        if (hours == piles.length) {
            return Arrays.stream(piles).max().getAsInt();
        }

        int maxRate = Arrays.stream(piles).max().getAsInt();
        // the minimum rate can't be less than this
        int rate = Math.max(0, (maxRate / hours) - 1);
        long totalTime;
        do {
            totalTime = 0;
            rate++;
            for (int pile : piles) {
                totalTime += Math.ceil(1.0D * pile / rate);
            }
        } while (totalTime > hours && rate < maxRate);

        return rate;
    }
}
