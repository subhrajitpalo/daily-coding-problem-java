package palo.mantu.practice.dailycodingproblem.dcp061;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.abs;

/*
This problem was asked by Google.

Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.
Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.
*/
public class IntegerExponentiation {
    public double pow(int a, int b) {
        if (a == 0 && b == 0) {
            return MIN_VALUE;
        }
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        double answer;
        if ((b & 1) != 0) {
            answer = abs(a) * pow(abs(a), abs(b) - 1);
        } else {
            answer = pow(abs(a) * abs(a), abs(b) / 2);
        }
        if (b < 0) {
            answer = 1.0 / answer;
        }
        if (a < 0 && (b & 1) != 0) {
            answer *= -1;
        }
        return answer;
    }
}