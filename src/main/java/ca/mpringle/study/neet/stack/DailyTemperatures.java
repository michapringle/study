package ca.mpringle.study.neet.stack;

final class DailyTemperatures {

    private DailyTemperatures() {
    }

    /**
     * You are given an array of integers temperatures where temperatures[i] represents the
     * daily temperatures on the ith day.
     * <p>
     * Return an array result where result[i] is the number of days after the ith day
     * before a warmer temperature appears on a future day. If there is no day in the
     * future where a warmer temperature will appear for the ith day,
     * set result[i] to 0 instead.
     * <p>
     * 2:00 -> ? less than an hour
     */
    static int[] dailyTemperatures(final int[] temperatures) {

        final int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i; j < temperatures.length && temperatures[i] >= temperatures[j]; j++) {
                result[i] = j == temperatures.length - 1 ? 0 : result[i] + 1;
            }
        }

        return result;
    }

}