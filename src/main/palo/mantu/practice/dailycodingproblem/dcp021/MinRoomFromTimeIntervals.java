package palo.mantu.practice.dailycodingproblem.dcp021;

import static java.util.Comparator.comparing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Daily Coding Problem: Problem #21

This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/
public class MinRoomFromTimeIntervals {
    public int count(List<TimeInterval> times) {
        if (times == null || times.isEmpty()) {
            return 0;
        }
        times.sort(comparing(TimeInterval::beg));

        int num = 1;
        Set<TimeInterval> ti = new HashSet<>();
        for (TimeInterval t : times) {
            if (isAvailable(ti, t.beg)) {
                num++;
            }
            ti.add(t);
        }
        return num;
    }

    private boolean isAvailable(Set<TimeInterval> ti, int beg) {
        for (TimeInterval t : ti) {
            if (t.end < beg) {
                ti.remove(t);
                return true;
            }
        }
        return false;
    }

    public class TimeInterval {
        private int beg;
        private int end;

        public TimeInterval(int beg, int end) {
            this.beg = beg;
            this.end = end;
        }

        private int beg() {
            return beg;
        }
    }
}