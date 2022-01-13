# 526-Term-Project-Process-Schedular

## Overview
The CS 526 Term Project's goal is to simulate a process schedular that scans a file of raw process datas as input, then systematically processing each processes based on system parameters through the implementation of PriorityQueue and other generic data structures.

## Project Breakdowns

### process.java
Process.java is a custom class that defines what a process consist of. Each process was given thier ids, arrival times, priorities, and duration by the assignment through text file format. <b>Each object's duration determine how much time it has to take before the system can process the next process-object.</b>

In addition to the attributes that mentioned above, I added waitTime attribute to keep a count of time each process has been waiting. Lastly, I created some custom set and get methods to eaisly access and modify the appropriate attributes.

### PriorityQueue D
All process class objects were sorted by id and stored in a text file given by assignment. The data is then interpreted into process class objects and stored within a data structure named D. <b>It is important that the data structure itself has to be efficient at sorting the data by any given values since the process-object with least arrival time will be first sending to the Process Schedular.</b> For that reason, I used PriorityQueue for D because it will automatically sort the process-objects by arrival time and both insert and remove's time complexity are both O(logn).
  
### PriorityQueue Q
PriorityQueue Q is implemented and appointed by the requirement of the assignmnet. <b>Its main function is to provide a waiting space for all process-objects that were sent from D until the system has finished previous process according to their duration attributes.</b>

Now, the priority attribute of each process-objects will increase by 1 if they have been waiting in Q for every 30 unit time. For that reason, I also gave each process-objects an additional attribute waitTIme, with 0 as default. As results, a process's waitTime will be increased by 1 in each virtual time so that priority will increase by 1 for every 30 virtual time.

### processScheduling.java
This is the main program for the Processor Schedular assignment. It includes: 
  * reading and scanning the text file includeing a try/error block
  * instantiate process class objects
  * creating PriorityQueue D and Q
  * constructing a comparator for custom class, process
  * a while loop( each loop represents one unit time) that consist of all the logical expression to process process-objects provided by the text file.

The most challenging part of this assignment is to consider all possible outcomes within each unit time. Fortunately, I was able to apply some of the basic coding techniques that I have mastered during the course such as coding and testing in a small area of codes before move-on, debugging tools, and ability to efficiently search the answers from online. 

The other challenge that I faced in this assignment was that since a PriorityQueue can only access to the first object and cannot modify the rest of the objects without removing the previous object. To overcome this problem, I added a step at the end of while loops to remove all process-object while incrementing the waitTime, and adding to an ArrayList to temporarily storing the process-objects. Once Q has emptied,I implemented a for loop to add back all modified processes back to Q.

### printMessage.java
In order to log any transactions of process updates, I realized that there is a way to systemacially allocate all logging templates to simplify the codes. Therefore, I consolidated all the templates and created two custom methods to keep my mian program cleaner.


