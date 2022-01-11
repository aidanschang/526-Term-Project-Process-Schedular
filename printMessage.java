
//This is a simple class to print necessary information when a process is executed or changed priority
public class printMessage {
    //toPrintProcess prints necessary information of a process when executed
    static void toPintProcess(process leastPriority, int curTime, int nextRunningTime) {
        System.out.println("Process removed from queue is: id=" + leastPriority.getId() + ", at time = " +
                curTime + ", wait time = " + leastPriority.getWaitTime() + " Total wait time = " + leastPriority);
        System.out.println("Process id = " + leastPriority.getId() + "\n"
                + "\tPriority = " + leastPriority.getPriority() + "\n"
                + "\tArrival = " + leastPriority.getArrivalTime() + "\n"
                + "\tDuration = " + leastPriority.getDuration()
        );
        System.out.println("Process " + leastPriority.getId() + " finished at time " + nextRunningTime + "\n");
    }
    //toPrintUpdate prints necessary information of a process when priority is changed
    static void toPrintUpdate (process waitedProcess){
        System.out.println("Update Priority:");
        System.out.println("PID = " + waitedProcess.getId() + ", wait time = " + waitedProcess.getWaitTime()
                + " current priority = " + waitedProcess.getPriority());
        waitedProcess.setPriority(waitedProcess.getPriority() - 1);
        System.out.println("PID = " + waitedProcess.getId() + " new priority = " + waitedProcess.getPriority() + "\n");
    }

}
