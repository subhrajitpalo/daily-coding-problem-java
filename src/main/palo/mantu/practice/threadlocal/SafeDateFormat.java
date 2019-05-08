package palo.mantu.practice.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class SafeDateFormat {
    private static ThreadLocal<SimpleDateFormat> df = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        IntStream.range(0, 100000)
                .forEach(i -> pool.submit(() -> System.out.println(i + " -> " + df.get().format(new Date(i)))));
    }
}