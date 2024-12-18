# Resolving Threads exercices from web in Java
1) Do a program to calculates the sum of each row of a matrix using threads.

# Java Threads: Basic Explanation 🧵 ☕

In Java, a thread is the smallest unit of execution. It allows programs to perform multiple tasks concurrently, making
it possible to perform operations like I/O, computations, and background tasks without blocking the main thread.

## How Threads Work

* Each thread runs a separate path of execution inside the same program.
* Java provides the Thread class and the Runnable interface to create and manage threads.

## Types of Threads

Threads in Java are broadly classified into two categories:

### User Threads:

* These are the standard threads created by the application for specific tasks.
* They remain active until they complete their tasks or are explicitly terminated.
* Examples: Threads for handling client requests in a server, background computation threads, etc.

### Daemon Threads:

* These are low-priority threads designed to run in the background and provide services to user threads.
* They terminate automatically when all user threads have finished execution.
* Examples: Garbage collection thread, background monitoring threads, etc.
* To set a thread as a daemon thread
  <br/>` Thread thread = new Thread(task);`
  <br/>` thread.setDaemon(true);`

## Traditional Threads vs. Virtual Threads

With Java's Project Loom (introduced in Java 19 as a preview), Virtual Threads were introduced to simplify thread
management and improve scalability. Here's a comparison:

| Aspect         | Traditional (Platform) Threads                            | Virtual Threads                                  |
|----------------|-----------------------------------------------------------|--------------------------------------------------|
| Implementation | Backed by the OS threads.                                 | Managed entirely by the JVM, not the OS.         |
| Resource Usage | Limited by the number of OS threads.                      | Lightweight, can have millions of threads.       |
| Blocking       | 	Blocking a thread blocks an OS thread.                   | Blocking is handled by the JVM scheduler.        |
| Scalability    | Heavy and resource-intensive for large-scale concurrency. | Highly scalable due to their lightweight nature. |
| Creation Time  | 	Expensive and time-consuming.                            | Fast and efficient to create.                    |
| Use Cases      | Suitable for CPU-intensive tasks.                         | Ideal for high-concurrency I/O tasks.	           |


### Key Features of Virtual Threads
* They are lightweight threads managed by the JVM.
* Each virtual thread has its own stack but shares the OS thread pool.
* Makes it easy to write code for high-concurrency applications (like servers) without worrying about the limitations of OS threads.

Generated with ChatGPT 🤖#
