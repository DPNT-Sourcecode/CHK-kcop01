package io.accelerate.solutions.SUM;

import io.accelerate.runner.SolutionNotImplementedException;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        if (isPossitiveIntTo100(x) && isPossitiveIntTo100(y)) {
            return x + y;
        }
        return -1;
    }

    private boolean isPossitiveIntTo100(int i) {
        return i >= 0 && i <= 100;
    }

}

