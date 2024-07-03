package homework2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        PriorityQueue<Process> queue = new PriorityQueue<>();
        int currentTime = 0;
        int index = 0;


        processes.sort((p1, p2) -> Integer.compare(p1.arrivalTime, p2.arrivalTime));
        while (index < processes.size() || !queue.isEmpty()) {

            while (index < processes.size() && processes.get(index).arrivalTime <= currentTime) {
                queue.add(processes.get(index));
                index++;
            }

            if (!queue.isEmpty()) {
                Process currentProcess = queue.poll();
                System.out.println("t = " + currentTime + " → " + currentProcess.name + " is running");
                currentProcess.remainingTime--;


                if (currentProcess.remainingTime > 0) {
                    queue.add(currentProcess);
                }
            } else {
                System.out.println("t = " + currentTime + " → No process is running");
            }
            currentTime++;


            if (queue.isEmpty() && index >= processes.size()) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 3, 3, 0));
        processes.add(new Process("P2", 2, 4, 1));
        processes.add(new Process("P3", 4, 6, 2));
        processes.add(new Process("P4", 6, 4, 3));
        processes.add(new Process("P5", 10, 2, 5));

        scheduleAndRun(processes);

    }
}
