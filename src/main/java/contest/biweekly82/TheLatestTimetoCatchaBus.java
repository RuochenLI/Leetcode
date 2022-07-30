package contest.biweekly82;

import java.util.Arrays;

public class TheLatestTimetoCatchaBus {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int ptBus = 0;
        int ptPassanger = 0;
        int cap = capacity;
        while (ptBus < buses.length) {
            cap = capacity;
            while (ptPassanger < passengers.length && passengers[ptPassanger] <= buses[ptBus] && cap > 0) {
                ptPassanger++;
                cap--;
            }
            ptBus++;
        }
        ptPassanger--;
        int time = cap > 0 ? buses[buses.length - 1] : passengers[ptPassanger];
        while (ptPassanger >= 0 && time == passengers[ptPassanger]) {
            time--;
            ptPassanger--;
            if (ptPassanger < 0) {
                return time;
            }
        }
        return time;
    }
}
