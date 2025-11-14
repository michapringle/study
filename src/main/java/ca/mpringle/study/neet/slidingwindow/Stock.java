package ca.mpringle.study.neet.slidingwindow;

final class Stock {

    private Stock() {
    }

    /**
     * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
     * <p>
     * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
     * <p>
     * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case
     * the profit would be 0.
     * <p>
     * 3:50 -> 4:30
     */
    static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 1) {
            return 0;
        }

        Window window = new Window(0, 0, 0);

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > window.value) {
                    window = new Window(i, j, prices[j] - prices[i]);
                }
            }
        }

        return window.value;
    }

    private static class Window {

        private final int min;
        private final int max;
        private final int value;

        public Window(final int min, final int max, final int value) {
            this.min = min;
            this.max = max;
            this.value = value;
        }
    }
}
