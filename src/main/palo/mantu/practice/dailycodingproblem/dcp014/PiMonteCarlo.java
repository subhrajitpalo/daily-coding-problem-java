package palo.mantu.practice.dailycodingproblem.dcp014;

/*
Daily Coding Problem: Problem #14

This problem was asked by Google.

The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x2 + y2 = r2.
*/
public class PiMonteCarlo {
    public double pi() {
        int throwNum = 1000000;
        int success = 0;
        for (int i = 0; i < throwNum; i++) {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y <= 1) {
                success++;
            }
        }
        // new DecimalFormat("#.000").format(pi)
        return 4 * (double) success / (double) throwNum;
    }
}