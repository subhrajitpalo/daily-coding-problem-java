package palo.mantu.practice.algorithm;

import java.security.SecureRandom;

public class ReservoirSampling {
    public int[] selectKItems(int[] stream, int k) {
        int i;
        int[] reservoir = new int[k];
        for (i = 0; i < k; i++) {
            reservoir[i] = stream[i];
        }
        for (; i < stream.length; i++) {
            int j = new SecureRandom().nextInt(i + 1);
            if (j < k) {
                reservoir[j] = stream[i];
            }
        }
        return reservoir;
    }
}