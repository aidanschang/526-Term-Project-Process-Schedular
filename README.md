# 526-Term-Project-Process-Schedular

## Overview
The CS 526 Term Project's goal is to simulate a process schedular that feeds a file of raw process datas as input, then systematically processing each processes based on system parameters by using PriorityQUeue and other data structures.

## Class Breakdowns

### process.java
Process.java is a custom class that defines what a process consist of. Each process was given thier ids, arrival times, priorities, and duration, according to the assignment in a raw data text file format. In addition to given attributes, I added waitTime attribute to keep a count of amount of time each process has been waiting. Lastly, I also created some custom set and get methods to further access and modify the appropriate attributes.


### printMessage.java
In order to log any transactions or changes to process objects, I realized that there is a way to systemacially allocate all logging messages to simplify the codes. Therefore, I consolidated all the logs and created custom methods in order to be called at its appropriate time.

### processScheduling.java
Within each process objects, assignment gave each with corresponded id, priority, arrival time, and duration. In addition, the priority will increase by 1 if the process has been waiting in Q for every 30 unit time. For that reason, I gave each process objects an additional attribute waitTIme, with 0 as default. As results, a process's waitTime will be increased by 1 in each virtual time and increase priority by 1 for every 30 unit time.

All process objects were sorted by id and initially stored in a text file given by assignment. Process objects were then read and stored into another PriorityQueue named D, as it has to be sorted by arrivalTime in ascending arrangement so D will remove the least arrivalTime and send it to Q at its corresponding virtual time. Due to process objects being a custom class, a comparator was implemented

Since a PriorityQueue can only access to the first object and cannot modify the rest of the objects without removing the previous object. To overcome this problem, I added a step at the end of while loops to remove all process object while incrementing the waitTime, and adding to an ArrayList to temporarily storing the process objects. Once Q has emptied,I implemented a for loop to add back all modified processes back to Q.
