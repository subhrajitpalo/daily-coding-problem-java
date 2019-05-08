package palo.mantu.practice.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class UserSession {
    static ThreadLocal<User> session = new ThreadLocal<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        IntStream.range(0, 100000).forEach(i -> pool.submit(() -> {
            new Service1().process(i);
            new Service2().process();
            new Service3().process();
        }));
    }
}

class User {
    String id;

    User(int id) {
        this.id = "User " + id;
    }
}

class Service1 {
    void process(int id) {
        UserSession.session.set(new User(id));
    }
}

class Service2 {
    void process() {
        System.out.println("Service2: " + UserSession.session.get().id);
    }
}

class Service3 {
    void process() {
        System.out.println("Service3: " + UserSession.session.get().id);
    }
}