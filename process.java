import java.util.*;

public class process {
    private int id;
    private int priority;
    private int duration;
    private int arrivalTime;
    private int waitTime;

    public process(int id, int priority, int duration, int arrivalTime, int waitTime) {
        this.id = id;
        this.priority = priority;
        this.duration = duration;
        this.arrivalTime = arrivalTime;
        this.waitTime = waitTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public String toString() {
        String c =
                "\tid= " + id + "," +
                        "\tpriority= " + priority + "," +
                        "\tduration= " + duration + "," +
                        "\tarrivalTime= " + arrivalTime;
        return c;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}
