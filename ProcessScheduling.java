import java.io.*;
import java.sql.*;
import java.util.*;

public class ProcessScheduling {
    public static void main(String[] args) {
        //find the directory and read the file
        Scanner fileInput = null;
        String curDirc = System.getProperty("user.dir");
        System.out.println(curDirc);

        try {
            fileInput = new Scanner(new File("process_scheduling_input.txt"));
        } catch (FileNotFoundException var8) {
            System.out.println("Input file not found");
        }

        //creating an ArrayList D and add custom object, process, by split the file input as attributes
        //Setting Comparator for the process object
        class DComparator implements Comparator<process> {
            @Override
            public int compare(process p1, process p2) {
                return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
            }
        }

        PriorityQueue<process> D = new PriorityQueue<>(new DComparator());

        //adding nextLine as parameters of newProcess, then add to Priority Queue D
        while(fileInput.hasNext()) {
            String nextLine = fileInput.nextLine();
            String[] splitLine = nextLine.split(" ");
            process newProcess = new process(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), 0);
            D.add(newProcess);
        }

        //Print D by removing the data from a D's clone
        PriorityQueue<process> printOut = new PriorityQueue<>(D);

        System.out.println("\nAll processes:");
        while(printOut.iterator().hasNext()) {
            System.out.println(printOut.remove());
        }

        //Setting Comparator for the process object
        class ProcessComparator implements Comparator<process> {

            @Override
            public int compare(process p1, process p2) {
                return Integer.compare(p1.getPriority(), p2.getPriority());
            }
        }

        //instantiate variables for the main program
        int curTime = 0;
        int maxWaitingTime = 30;
        boolean isRunning = false;
        int totalWaitTime = 0;
        int nextRunningTime = 0;
        int numberOfProcesses= D.size();

        //instantiate the priority queue, Q
        PriorityQueue<process> Q = new PriorityQueue<>(new ProcessComparator());


        //* MAIN PROGRAM- Each iteration of the while loop represents what occurs during one time unit

        while(!D.isEmpty() || !Q.isEmpty()) {
            //if D is not empty, prepare earliest process object and add to Q.
            // If D is empty, only have to execute all processes in Q
            if(!D.isEmpty()) {
                process earliestProcess = D.peek();
                int earliestProcessArrivalTime = earliestProcess.getArrivalTime();

                //if earliest process' arrival time is less than current time, check if isRunning is true
                if (curTime < earliestProcessArrivalTime) {
                    if (nextRunningTime == curTime && !Q.isEmpty()) {
                        process highestPriority = Q.remove(); //return the process that is ready to be executed
                        nextRunningTime = curTime + highestPriority.getDuration(); //calculating when the process will be finished
                        totalWaitTime = totalWaitTime + highestPriority.getWaitTime(); //sum up all the wait times
                        printMessage.toPintProcess(highestPriority, curTime, nextRunningTime); //custom method to print executed process
                        isRunning = true; //set isRunning to true
                    }
                    curTime++;
                // if earliest process' arrival time is the same as current time, remove from D, add to Q, and
                    // execute the process
                } else {
                    //if program is not running, execute a process if Q is not empty. If program is running, calculating
                    // wait time
                    if (curTime >= nextRunningTime) isRunning = false;
                    D.remove();

                    //once we removed the last process in D, prints out a message below
                    if (D.isEmpty()) {
                        System.out.println("D becomes empty at time " + curTime + "\n");
                    }

                    //when Q has no process waiting, add the earliest process to Q, then remove from Q, and calc the run time.
                    if (!isRunning && Q.isEmpty()) {
                        Q.add(earliestProcess);
                        process highestPriority = Q.remove();

                        nextRunningTime = curTime + highestPriority.getDuration();
                        totalWaitTime = totalWaitTime + highestPriority.getWaitTime();
                        printMessage.toPintProcess(highestPriority, curTime, nextRunningTime); //custom method to print executed process
                        isRunning = true;
                        curTime++;

                        //when Q has processes waiting, add the earliest process then remove the process with least
                        // priority, then calculate the run time
                    } else if (!isRunning && !Q.isEmpty()) {
                        Q.add(earliestProcess);
                        process highestPriority = Q.remove();
                        totalWaitTime = totalWaitTime + highestPriority.getWaitTime();
                        printMessage.toPintProcess(highestPriority,curTime, nextRunningTime); //custom method to print executed process
                        nextRunningTime = nextRunningTime + highestPriority.getDuration();
                        isRunning = true;
                        curTime++;
                    } else {
                        //if isRunning is true, while D is not empty, add process to Q, curTime++
                        Q.add(earliestProcess);
                        curTime++;
                    }
                }
                //when D becomes empty, process all processes in Q
            } else {
                //if earliest process' arrival time is less than current time, check if isRunning is true
                if (nextRunningTime == curTime && !Q.isEmpty()) {
                    process highestPriority = Q.remove();
                    nextRunningTime = curTime + highestPriority.getDuration();
                    totalWaitTime = totalWaitTime + highestPriority.getWaitTime();
                    printMessage.toPintProcess(highestPriority,curTime,nextRunningTime); //custom method to print executed process
                    isRunning = true;
                }
                curTime++;
            }

            //Below codes is to track waiting time for each process inside Q by removing each process one by one,
            // then modify the waited time attribute, and add it to a tempArray
            ArrayList<process> tempArray = new ArrayList<>();

            while(!Q.isEmpty()) {
                process waitedProcess = Q.remove(); //instantiate the first process inside the Q
                int processWaitTime = waitedProcess.getWaitTime();
                waitedProcess.setWaitTime(curTime-waitedProcess.getArrivalTime()); //

                if (processWaitTime != 0 && processWaitTime% maxWaitingTime==0) {
                    printMessage.toPrintUpdate(waitedProcess); //custom method to print updated information
                }
                tempArray.add(waitedProcess); //add processes to tempArray
            }

            //Adding all processes from tempArray back to Q
            for (int t = 0; t < tempArray.size(); t++) {
                process toAdd = tempArray.get(t);
                Q.add(toAdd);
            }
        }

        System.out.println("Total Wait Time = " + totalWaitTime + "\nAverage Wait Time = " +
                totalWaitTime/numberOfProcesses);
    }
}