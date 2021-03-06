# 526-Term-Project-Process-Schedular

## Overview
The CS 526 Term Project's goal is to simulate a process schedular that scans a file of raw process data as input, then systematically processing each process object based on system parameters through the implementation of PriorityQueue and other generic data structures.

## Project Breakdowns

### process.java
Process.java is a custom class that defines what a process consists of. Each process was given their ids, arrival times, priorities, and duration by the assignment through text file format. <b>Each object's duration determines how much time it has to take before the system can process the next process object.</b>

In addition to the attributes mentioned above, I added waitTime attribute to keep a count of time each process has been waiting. Lastly, I created some custom Set and Get methods to easily access and modify the appropriate attributes.

![Screen Shot 2022-01-13 at 6 48 37 PM](https://user-images.githubusercontent.com/84875731/149443102-fee269af-0e45-43af-b01c-bbbf9cd1300e.png)

### PriorityQueue D
All process class objects were sorted by id and stored in a text file given by the assignment. The data is then interpreted into process class objects and stored within a data structure named D. <b>It is important that the data structure itself has to be efficient at sorting the data by any given values since the process-object with the least arrival time will be first sent to the Process Scheduler.</b> For that reason, I used PriorityQueue for D because it will automatically sort the process objects by arrival time, and both insert and remove time complexity are both O(logn).

![Screen Shot 2022-01-13 at 6 46 53 PM](https://user-images.githubusercontent.com/84875731/149443030-77816727-a0d0-4025-b462-2e5fa6729dfc.png)

### PriorityQueue Q
PriorityQueue Q is implemented and appointed by the requirement of the assignment. <b>Its main function is to provide a waiting space for all process objects that were sent from D until the system has finished the previous process according to their duration attributes.</b>

Now, the priority attribute of each process-objects will increase by 1 if they have been waiting in Q for every 30 unit time. For that reason, I also gave each process-objects an additional attribute waitTIme, with 0 as the default. As result, a process's waitTime will be increased by 1 in each virtual time so priority will increase by 1 for every 30 virtual times. 

Since PriorityQueue can only insert or remove one data at a time, a separate data structure is required to temporarily store the process objects while increasing their waitTime. <b>Since we do not ask this data structure to run anything else but store data one at a time, I used ArrayList to fulfill the requirement in this case.</b>

![Screen Shot 2022-01-13 at 6 56 04 PM](https://user-images.githubusercontent.com/84875731/149443793-b366c46d-02c8-4312-91fd-9e7f2f9f2c6b.png)

### processScheduling.java
This is the main program for the Processor Schedular assignment. It includes: 
?? * reading and scanning the text file including a try/error block
?? * instantiate process class objects
?? * creating PriorityQueue D and Q
?? * constructing a comparator for custom class, process
?? * a while loop( each loop represents one unit time) that consist of all the logical expression to process process-objects provided by the text file.

The most challenging part of this assignment is to consider all possible outcomes within each unit time. Fortunately, I was able to apply some of the basic coding techniques that I have seasoned during the course such as coding and testing in a small area of codes before move-on, debugging tools, and the ability to efficiently search the answers online. 

![Screen Shot 2022-01-13 at 7 17 25 PM](https://user-images.githubusercontent.com/84875731/149446177-2c059bd1-d4cd-4daa-8ec0-660e83f8362f.png)

### printMessage.java
In order to log any transactions of process updates, I realized that there is a way to systematically allocate all logging templates to simplify the codes. Therefore, I consolidated all the templates and created two custom methods to keep my main program cleaner.

![Screen Shot 2022-01-13 at 7 23 33 PM](https://user-images.githubusercontent.com/84875731/149446299-982d2ef0-689f-4b08-bd9e-dacde8d3ea1a.png)

## Summary
It is an excellent project to conclude the basics of generic data structure, custom classes/methods, and a project-based algorithm problem set. In this project, I have learned how to test and debug in a big project, compare the time complexity of different data structures, write clean codes, add clear comments to my codes, and be better at logical expression. It was a fun project just like putting lego bricks together, and I enjoy??it further when I came back to fine-tune this project in order to be published on GitHub.??
