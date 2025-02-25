package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    /**
     * Divide & conquer approach
     * @param n any number
     * @return nth fibonacci number
     */
    int fib(int n) {
        if(n==0 || n==1) return n;
        return fib(n-2) + fib(n-1);
    }

    /**
     * Dynamic programming approach
     * @param n any number
     * @return nth fibonacci number
     */
    int fibDynamic(int n) {
        Map<Integer, Integer> storage = new HashMap<>();
        storage.put(0, 0); storage.put(1, 1);
        if(n <= 0) return storage.get(0);
        else if(n == 1) return storage.get(1);
        else {
            storage.put(n, fib(n-1) + fib(n-2));
        }
        return storage.get(n);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 8;
        System.out.println("Fibonacci " + n + " = " + fibonacci.fibDynamic(n));
    }
}
