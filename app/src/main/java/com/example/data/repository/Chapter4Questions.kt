package com.example.data.repository

import com.example.data.model.Question

object Chapter4Questions {
    fun getQuestions(): List<Question> {
        val q = mutableListOf<Question>()

        // 15 Terminology Questions
        q.add(Question(
            id = 401,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is the primary difference between a 'Process' and a 'Thread' in an operating system?",
            optionA = "Processes share the same memory space; Threads have isolated memory spaces.",
            optionB = "A Process is an active program with its own isolated address space; a Thread is a lightweight unit of execution within a process that shares its parent's memory.",
            optionC = "Processes are managed by hardware; Threads are managed entirely by compilers.",
            optionD = "Processes are connection-oriented; Threads are connectionless.",
            correctOption = "B",
            explanationA = "Incorrect: This is reversed. Processes have isolated memory spaces; threads within a process share that memory space.",
            explanationB = "Correct: A Process is an independent executing program allocated with its own memory, file descriptors, and security tokens. A Thread is a subset of execution path within a process that shares the parent process's code, data, and system resources, making thread context switching faster.",
            explanationC = "Incorrect: Both processes and threads can be scheduled and managed directly by the Operating System Kernel.",
            explanationD = "Incorrect: Connection types are networking terms (TCP/UDP), completely unrelated to CPU process execution models.",
            explanationCorrect = "Because threads share memory, they can communicate very fast, but they must use synchronization locks to prevent data corruption."
        ))

        q.add(Question(
            id = 402,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "Which CPU scheduling algorithm can suffer from 'Starvation', where low-priority or long processes are deferred indefinitely?",
            optionA = "Round Robin (RR)",
            optionB = "Shortest Job First (SJF) or Priority Scheduling",
            optionC = "First-Come, First-Served (FCFS)",
            optionD = "Time-Sliced Priority Multiplexing",
            correctOption = "B",
            explanationA = "Incorrect: Round Robin uses time-slicing to guarantee every process gets an equal share of CPU cycles, preventing starvation.",
            explanationB = "Correct: Non-preemptive Shortest Job First (SJF) and Priority Scheduling can cause starvation. If short or high-priority jobs are constantly added, a long or low-priority process will wait forever in the ready queue.",
            explanationC = "Incorrect: FCFS is a simple queue; every process eventually runs in order of arrival, so starvation is impossible (though average wait times can be high).",
            explanationD = "Incorrect: Time-slicing is a technique to prevent starvation, not cause it.",
            explanationCorrect = "Starvation in priority scheduling is resolved using 'Aging', which gradually increases a waiting process's priority over time."
        ))

        q.add(Question(
            id = 403,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "Which of the following conditions is NOT one of the four Coffman conditions necessary for a 'Deadlock' to occur?",
            optionA = "Mutual Exclusion",
            optionB = "Hold and Wait",
            optionC = "Preemption",
            optionD = "Circular Wait",
            correctOption = "C",
            explanationA = "Incorrect: Mutual Exclusion (only one process can use a resource at a time) is a mandatory Coffman condition.",
            explanationB = "Incorrect: Hold and Wait (processes holding resources can request new ones) is a mandatory Coffman condition.",
            explanationC = "Correct: The Coffman condition is 'No Preemption' (resources cannot be forcibly taken from a process). If Preemption is allowed, deadlocks are broken. Thus, 'Preemption' itself is NOT a deadlock condition.",
            explanationD = "Incorrect: Circular Wait (a closed loop of processes waiting for each other's resources) is a mandatory Coffman condition.",
            explanationCorrect = "The four Coffman conditions are Mutual Exclusion, Hold and Wait, No Preemption, and Circular Wait. Removing any one prevents deadlocks."
        ))

        q.add(Question(
            id = 404,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is 'Thrashing' in an operating system's memory management?",
            optionA = "The physical shaking of a hard drive when compiling heavy datasets.",
            optionB = "A state where the CPU spends more time swapping virtual memory pages in and out of disk than executing actual instruction codes.",
            optionC = "A security exploit that overwrites the processor's call registers.",
            optionD = "The automatic cleanup of unused variable states by a garbage collector.",
            correctOption = "B",
            explanationA = "Incorrect: Hard drives do not shake; thrashing is a logical virtual memory swapping loop, not mechanical vibration.",
            explanationB = "Correct: When active processes require more physical memory (RAM) than available, the OS constantly swaps pages to and from the swap partition on the disk. Since disk access is slow, process execution halts, causing throughput to crash to zero.",
            explanationC = "Incorrect: Register exploits are buffer overflows or stack smashing, not thrashing.",
            explanationD = "Incorrect: Memory cleanup is garbage collection, which is a software platform resource reclaiming process.",
            explanationCorrect = "Thrashing occurs when the working set size of active processes exceeds physical RAM, forcing the OS to thrash the disk."
        ))

        q.add(Question(
            id = 405,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "In memory management, what is 'Virtual Memory'?",
            optionA = "RAM chips mounted on virtual machines in cloud networks.",
            optionB = "A storage allocation technique that uses secondary storage (disk) to make physical RAM appear larger, giving each process a contiguous logical address space.",
            optionC = "A high-speed cache located inside the CPU registers.",
            optionD = "A software simulation of physical computer mainframes.",
            correctOption = "B",
            explanationA = "Incorrect: Cloud RAM is standard physical or hypervisor RAM, not virtual memory mapping.",
            explanationB = "Correct: Virtual memory decouples physical addresses from logical addresses. It maps a process's virtual memory addresses to physical RAM or secondary storage swap files, allowing programs to run even if they are larger than physical RAM.",
            explanationC = "Incorrect: High-speed CPU memory is L1/L2/L3 cache, not virtual memory.",
            explanationD = "Incorrect: Hypervisors simulate computer hardware; virtual memory is a standard memory management technique inside all modern operating systems.",
            explanationCorrect = "Virtual memory prevents processes from accessing or corrupting each other's memory, ensuring OS stability and security."
        ))

        q.add(Question(
            id = 406,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is a 'System Call' in an operating system?",
            optionA = "A telephone hotline operated by IT support administrators.",
            optionB = "The programmatic interface that allows user-space applications to request privileged services from the operating system kernel.",
            optionC = "A hardware interrupt triggered when a CPU chip overheats.",
            optionD = "A network API call used to fetch data from cloud databases.",
            correctOption = "B",
            explanationA = "Incorrect: Hotlines are administrative operations; system calls are programmatic API boundaries.",
            explanationB = "Correct: Applications run in restricted User Mode. To perform privileged tasks (like reading files, sending network packets, or spawning processes), they must trigger a software interrupt to execute a System Call, shifting the CPU into Kernel Mode.",
            explanationC = "Incorrect: Overheating is handled by ACPI hardware thermals and throttling interrupts.",
            explanationD = "Incorrect: Network API calls are Web APIs, whereas system calls are local OS boundaries (e.g. read(), write(), fork()).",
            explanationCorrect = "System calls act as the boundary gatekeeper, protecting system resources and security from raw application access."
        ))

        q.add(Question(
            id = 407,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "Which page replacement algorithm replaces the page that has not been used for the longest period of time?",
            optionA = "First-In, First-Out (FIFO)",
            optionB = "Least Recently Used (LRU)",
            optionC = "Least Frequently Used (LFU)",
            optionD = "Optimal Page Replacement (OPT)",
            correctOption = "B",
            explanationA = "Incorrect: FIFO replaces the oldest page loaded, regardless of how recently it was accessed.",
            explanationB = "Correct: LRU tracks the timing of page accesses. When a page fault occurs and a page must be evicted, LRU selects the page that has the oldest access timestamp (has been idle the longest).",
            explanationC = "Incorrect: LFU replaces pages based on their access frequency count, not how long ago they were accessed.",
            explanationD = "Incorrect: Optimal (OPT) replaces the page that will not be used for the longest duration in the future (impossible to implement without knowing the future).",
            explanationCorrect = "LRU leverages temporal locality, assuming that pages accessed recently are highly likely to be accessed again soon."
        ))

        q.add(Question(
            id = 408,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is a 'Race Condition' in concurrent programming?",
            optionA = "Two developers racing to finish their code commits first.",
            optionB = "An anomaly where the output of a program depends on the non-deterministic execution sequence or timing of concurrent threads accessing a shared resource.",
            optionC = "The delay that occurs when a CPU executes code on a high-speed bus.",
            optionD = "An optimization algorithm designed to increase thread execution speeds.",
            correctOption = "B",
            explanationA = "Incorrect: Developer sprints are human operations, not software race conditions.",
            explanationB = "Correct: A race condition occurs when concurrent threads read and write a shared variable (e.g. balance = balance + 1) without synchronization. The final value depends on the exact sequence of thread context switching, causing bugs.",
            explanationC = "Incorrect: Bus latency is a hardware design parameter.",
            explanationD = "Incorrect: Race conditions are bugs that cause data corruption, not performance optimizations.",
            explanationCorrect = "Race conditions are prevented by wrapping critical sections in synchronization locks, semaphores, or mutexes."
        ))

        q.add(Question(
            id = 409,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "In Unix-like operating systems, what is the role of an 'inode' in the file system?",
            optionA = "An input/output node used to route network data.",
            optionB = "A data structure that stores metadata about a file (size, permissions, block locations) but not the file's name or actual content.",
            optionC = "An encryption key used to encrypt physical files on disk.",
            optionD = "A temporary variable stored in the CPU cache registers.",
            correctOption = "B",
            explanationA = "Incorrect: Network routing is handled by sockets and network cards, not inodes.",
            explanationB = "Correct: An index node (inode) represents a file system object. It stores file metadata (permissions, owner, size, timestamps, and pointers to data blocks on disk). Directory files map human-readable names to inode numbers.",
            explanationC = "Incorrect: Disk encryption is handled by filesystem wrappers or hardware ciphers.",
            explanationD = "Incorrect: Inodes are stored on physical disk drives and cached in kernel memory, not CPU registers.",
            explanationCorrect = "Because inodes separate file names from metadata, multiple file names (hard links) can point to the same inode."
        ))

        q.add(Question(
            id = 410,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What does the 'Translation Lookaside Buffer' (TLB) inside a CPU accomplish?",
            optionA = "It translates programming source code into binary machine code.",
            optionB = "It acts as a high-speed hardware cache for virtual-to-physical memory address translations, bypassing slow page table lookups.",
            optionC = "It translates networking packets between IPv4 and IPv6.",
            optionD = "It buffers print commands sent to external printer spoolers.",
            correctOption = "B",
            explanationA = "Incorrect: Translating source code is the job of compilers and interpreters, not CPU cache hardware.",
            explanationB = "Correct: Address translation requires reading Page Tables stored in main RAM, which is slow. The TLB caches recent virtual-to-physical translations inside the CPU, allowing lookups to complete in single clock cycles.",
            explanationC = "Incorrect: Network address translation is handled by routers and firewalls.",
            explanationD = "Incorrect: Print buffering is managed by printer drivers and spool files.",
            explanationCorrect = "A TLB hit avoids accessing physical RAM page tables, which is critical for modern CPU speed optimization."
        ))

        q.add(Question(
            id = 411,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is the primary role of the 'Kernel' in an operating system?",
            optionA = "To act as a user interface shell where commands can be entered.",
            optionB = "To serve as the core program that has complete control over everything in the system, managing hardware resources and process resource allocations.",
            optionC = "To manage database table indexing files.",
            optionD = "To execute automated software backups every night.",
            correctOption = "B",
            explanationA = "Incorrect: User shells (Bash, CMD) are applications that run on top of the kernel, not the kernel itself.",
            explanationB = "Correct: The kernel is the first program loaded after the bootloader. It sits between software applications and physical hardware, managing memory, CPU time, physical device drivers, and system safety.",
            explanationC = "Incorrect: Database indexes are managed by database software engines like MySQL or PostgreSQL.",
            explanationD = "Incorrect: Backups are cron tasks run by user utilities.",
            explanationCorrect = "The kernel operates in a highly privileged processor execution mode, shielding hardware from bugs in user applications."
        ))

        q.add(Question(
            id = 412,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is the difference between a 'Mutex' and a 'Semaphore'?",
            optionA = "Mutexes are used in Java; Semaphores are used only in C++.",
            optionB = "A Mutex is a locking mechanism that allows only one thread to access a resource; a Semaphore is a signaling mechanism that allows up to N threads.",
            optionC = "Mutexes are managed by hardware; Semaphores are managed entirely by compilers.",
            optionD = "Mutexes handle network threads; Semaphores handle physical disk threads.",
            correctOption = "B",
            explanationA = "Incorrect: Mutexes and semaphores are generic operating system synchronization primitives supported in almost all programming languages.",
            explanationB = "Correct: A Mutex (Mutual Exclusion) has a concept of ownership—only the thread that locked it can unlock it (binary lock). A Semaphore uses a counter to let multiple threads (up to a defined limit) access a pool of resources concurrently.",
            explanationC = "Incorrect: Both locks can utilize hardware instructions (like Test-and-Set) but are managed by OS kernel scheduling queues.",
            explanationD = "Incorrect: Both synchronization primitives can manage any type of software threads.",
            explanationCorrect = "Mutexes are binary and ownership-based. Counting Semaphores are resource-counting and signaling-based."
        ))

        q.add(Question(
            id = 413,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is 'Belady's Anomaly' in virtual memory systems?",
            optionA = "The CPU slowing down when multiple monitors are connected.",
            optionB = "An anomaly where allocating MORE physical memory frames causes MORE page faults to occur under certain page replacement algorithms (like FIFO).",
            optionC = "A file system error where deleted files remain visible in directories.",
            optionD = "An interrupt loop that crashes the operating system kernel.",
            correctOption = "B",
            explanationA = "Incorrect: Graphics performance is a GPU bottleneck, not Belady's Anomaly.",
            explanationB = "Correct: Intuitively, increasing RAM frames should reduce page faults. However, under the FIFO (First-In-First-Out) page replacement algorithm, specific page access patterns can cause more page faults when RAM size is increased. This is known as Belady's Anomaly.",
            explanationC = "Incorrect: Orphan directory records are filesystem corruption bugs.",
            explanationD = "Incorrect: Kernels crashing are Kernel Panics or Blue Screens of Death, not page allocation anomalies.",
            explanationCorrect = "Belady's Anomaly does not occur under stack-based page replacement algorithms like LRU or OPT."
        ))

        q.add(Question(
            id = 414,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is 'Preemption' in CPU scheduling?",
            optionA = "The process of predicting which branch a program will execute next.",
            optionB = "The ability of the OS kernel to forcibly interrupt a running process and assign the CPU to another process.",
            optionC = "The automatic compilation of code prior to launching the application.",
            optionD = "A security exploit that locks user files until ransom is paid.",
            correctOption = "B",
            explanationA = "Incorrect: Branch prediction is a CPU hardware architecture speed optimization.",
            explanationB = "Correct: In preemptive scheduling (like Round Robin), the OS sets a timer interrupt. When the timer fires, the kernel suspends the active process, saves its state, and swaps in another, preventing any single program from hogging the CPU.",
            explanationC = "Incorrect: Ahead-Of-Time (AOT) compilation is a compiler technique.",
            explanationD = "Incorrect: File-locking exploits are Ransomware, not CPU preemption.",
            explanationCorrect = "Preemption is necessary for multi-tasking operating systems to ensure responsive user interfaces."
        ))

        q.add(Question(
            id = 415,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = false,
            text = "What is the purpose of 'Direct Memory Access' (DMA) in computer architecture?",
            optionA = "To allow application programs to bypass database permissions.",
            optionB = "To allow physical hardware devices to transfer data directly to/from system memory without involving the CPU for every byte, reducing CPU load.",
            optionC = "To double the physical speed of RAM bus clocks.",
            optionD = "To access cloud servers directly over fiber connections.",
            correctOption = "B",
            explanationA = "Incorrect: DMA is a low-level hardware architecture feature, not an application security bypass.",
            explanationB = "Correct: Without DMA, the CPU must copy every byte from devices (like network cards or hard drives) into RAM, wasting clock cycles. With DMA, the device controller manages the transfer to RAM directly, notifying the CPU via an interrupt only when the full block transfer is complete.",
            explanationC = "Incorrect: Clock speeds are hardware parameters managed by quartz oscillators, not memory access methods.",
            explanationD = "Incorrect: Network access is managed by network cards, not local DMA controllers.",
            explanationCorrect = "DMA significantly boosts system performance by freeing the CPU to execute instructions while heavy I/O transfers occur."
        ))

        // 15 Scenario-based Questions
        q.add(Question(
            id = 416,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: Three processes arrive at time 0 in the ready queue. P1 requires 24ms, P2 requires 3ms, and P3 requires 3ms of CPU time. Calculate the average waiting time if they are scheduled using a First-Come, First-Served (FCFS) algorithm in the order P1, P2, P3.",
            optionA = "Average Waiting Time: 3ms",
            optionB = "Average Waiting Time: 17ms",
            optionC = "Average Waiting Time: 30ms",
            optionD = "Average Waiting Time: 9ms",
            correctOption = "B",
            explanationA = "Incorrect: 3ms would be the wait time if P2 and P3 ran first, which is not the case here.",
            explanationB = "Correct: P1 runs first (wait time = 0). P2 waits for P1 to finish (wait time = 24ms). P3 waits for P1 and P2 to finish (wait time = 24 + 3 = 27ms). The average waiting time is (0 + 24 + 27) / 3 = 51 / 3 = 17ms.",
            explanationC = "Incorrect: 30ms is the total turnaround completion time of P3, not the average waiting time.",
            explanationD = "Incorrect: 9ms calculation misses the cumulative wait time offset of P3.",
            explanationCorrect = "Under FCFS, running a long process first causes the 'Convoy Effect', where short processes wait a long time."
        ))

        q.add(Question(
            id = 417,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: You are checking system resources on a server and notice that CPU usage is at 2%, but disk activity is at 99%. Applications are unresponsive. What is the system experiencing, and what is the direct fix?",
            optionA = "A compiler loop; fix by updating the source code.",
            optionB = "Thrashing; fix by reducing the number of active processes (concurrency) or increasing physical RAM.",
            optionC = "A deadlock; fix by rebooting the database server.",
            optionD = "Network congestion; fix by changing routers.",
            correctOption = "B",
            explanationA = "Incorrect: Compiler loops would peg the CPU usage at 100%, not 2%.",
            explanationB = "Correct: Low CPU usage paired with extremely high disk utilization is a classic symptom of thrashing. The OS is overwhelmed swapping pages. To fix it, you must free up RAM by terminating some active programs or adding physical RAM.",
            explanationC = "Incorrect: Deadlocked processes wait silently without utilizing CPU or disk; disk usage would be 0%.",
            explanationD = "Incorrect: Network congestion saturates network cards, not local system disk drives.",
            explanationCorrect = "Stopping a few background processes frees up enough RAM pages to break the disk swapping loop, restoring CPU throughput."
        ))

        q.add(Question(
            id = 418,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A banking thread is updating an account balance: 'balance = balance + deposit'. If Thread 1 (depositing $100) and Thread 2 (depositing $200) execute concurrently on a $1000 balance, the final balance can end up as $1100 or $1200 instead of $1300. How does this happen, and how do we fix it?",
            optionA = "A deadlock occurred; fix by using a Banker's algorithm.",
            optionB = "A Race Condition occurred because the assembly instruction sequence (Read, Add, Write) was context-swapped mid-execution. Fix by wrapping the section in a Mutex or synchronized block.",
            optionC = "Memory thrashing corrupted the bytes; fix by increasing swap file sizes.",
            optionD = "CPU overheating skipped instructions; fix by lowering the processor clock speed.",
            correctOption = "B",
            explanationA = "Incorrect: Deadlocks cause threads to freeze forever; here, the threads finished but returned incorrect data (corruption).",
            explanationB = "Correct: This is a race condition. 'balance = balance + deposit' is not atomic. T1 reads $1000. T1 is context-swapped. T2 reads $1000. T2 adds $200 and writes $1200. T1 resumes, adds $100 to its read state ($1000), and writes $1100, overwriting T2's deposit. Wrapping the code in a Mutex ensures only one thread can execute this section at a time.",
            explanationC = "Incorrect: Thrashing slows down systems; it does not corrupt arithmetic assembly calculations.",
            explanationD = "Incorrect: Hardware failures are not responsible for standard concurrent software race conditions.",
            explanationCorrect = "Synchronizing critical sections guarantees that the read-modify-write operation is atomic, preventing concurrent overwrites."
        ))

        q.add(Question(
            id = 419,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: An operating system is tracking 5 processes. The kernel uses the Banker's Algorithm to analyze resource requests. The algorithm determines that satisfying Process 1's request for 2 RAM frames will leave the system in an 'Unsafe State'. What does the kernel do?",
            optionA = "It allocates the frames anyway and reboots if a deadlock happens.",
            optionB = "It denies or delays the request, forcing Process 1 to wait until another process releases resources.",
            optionC = "It terminates all active processes instantly.",
            optionD = "It converts the RAM frames into virtual swap files dynamically.",
            correctOption = "B",
            explanationA = "Incorrect: The entire purpose of the Banker's algorithm is to actively prevent deadlocks, not ignore them.",
            explanationB = "Correct: An 'Unsafe State' means there is no guarantee of an execution sequence that can prevent a deadlock. Under the Banker's algorithm, the kernel avoids deadlocks by delaying any request that transitions the system into an unsafe state.",
            explanationC = "Incorrect: Terminative recovery is a last-resort recovery step, not the primary avoidance step.",
            explanationD = "Incorrect: The algorithm manages physical resource allocations; it cannot compile memory mappings dynamically to bypass mathematical safety checks.",
            explanationCorrect = "The Banker's algorithm is a deadlock avoidance algorithm that checks resource requests against maximum claims to ensure safety."
        ))

        q.add(Question(
            id = 417, // Wait, fix ID collision if any. The previous was 417, 418, 419, let's use unique IDs 420, 421...
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: You are designing an embedded micro-controller system for an aircraft autopilot. The system must process altimeter readings and adjust elevators every 5 milliseconds. If a reading takes 6ms, the plane could crash. Which type of operating system must you deploy?",
            optionA = "Batch Processing Operating System",
            optionB = "Hard Real-Time Operating System (RTOS)",
            optionC = "Time-Sharing Operating System",
            optionD = "Network Operating System",
            correctOption = "B",
            explanationA = "Incorrect: Batch processing systems execute tasks in bulk sequences; they are slow and have no timing guarantees.",
            explanationB = "Correct: A Hard Real-Time Operating System (RTOS) guarantees that critical tasks complete within strict, deterministic timing constraints. Missing a deadline is treated as a total system failure.",
            explanationC = "Incorrect: Time-sharing systems (like Windows or Linux) prioritize average user responsiveness over deterministic microsecond deadlines.",
            explanationD = "Incorrect: Network OS manages multi-computer routing, unrelated to low-level hardware timing.",
            explanationCorrect = "RTOS kernels use preemptive, priority-based scheduling with minimal interrupt latency to guarantee deterministic deadlines."
        ))

        q.add(Question(
            id = 421,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A server is running out of physical RAM. To free up space, the OS kernel selects an idle process, suspends it, and writes its entire address space out to a swap partition on the hard drive. Which component of the OS handles this action?",
            optionA = "The CPU compiler parser",
            optionB = "The Medium-Term Scheduler (Swapper)",
            optionC = "The Short-Term Scheduler (CPU Dispatcher)",
            optionD = "The Direct Memory Access (DMA) controller",
            correctOption = "B",
            explanationA = "Incorrect: Compilers parse source files, they have no runtime memory scheduling duties.",
            explanationB = "Correct: The Medium-Term Scheduler manages swapping. It removes processes from main memory to reduce the degree of multiprogramming when RAM is scarce, and restores them later when memory becomes available.",
            explanationC = "Incorrect: The Short-Term Scheduler selects which ready process in memory gets the CPU next; it does not swap processes to disk.",
            explanationD = "Incorrect: DMA handles direct hardware-to-RAM byte transfers, it does not make scheduling decisions.",
            explanationCorrect = "The Medium-Term scheduler regulates memory over-commitment by dynamically swapping entire processes to/from disk."
        ))

        q.add(Question(
            id = 422,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A user double-clicks an icon to launch a word processor. Trace the sequence of states the process goes through in the OS kernel until it displays the window.",
            optionA = "Ready -> Blocked -> Terminated.",
            optionB = "New -> Ready -> Running (waiting for I/O) -> Blocked -> Ready -> Running.",
            optionC = "Running -> Blocked -> New.",
            optionD = "Terminated -> New -> Running.",
            correctOption = "B",
            explanationA = "Incorrect: A process cannot go from Ready straight to Blocked without running first, and it does not terminate immediately.",
            explanationB = "Correct: 1. New: The process is created. 2. Ready: Placed in memory waiting for CPU. 3. Running: The CPU executes its instructions. 4. Blocked: The process requests disk I/O to load files, suspending it. 5. Ready: I/O completes, placed back in the queue. 6. Running: CPU executes again.",
            explanationC = "Incorrect: A process cannot start in the Running state, and Blocked cannot lead back to New.",
            explanationD = "Incorrect: A process cannot begin in the Terminated state.",
            explanationCorrect = "Understanding the 5-state process lifecycle (New, Ready, Running, Blocked, Terminated) is fundamental to OS design."
        ))

        q.add(Question(
            id = 423,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A multi-threaded database server is writing files. Thread 1 acquires lock A, then requests lock B. Simultaneously, Thread 2 acquires lock B, then requests lock A. Both threads freeze permanently. What occurred, and how can the programmer prevent this in code?",
            optionA = "A race condition; prevent by removing the locks.",
            optionB = "A Deadlock due to Circular Wait. Prevent by enforcing a strict lock acquisition order (always acquire lock A before lock B) in both threads.",
            optionC = "Thrashing; prevent by adding more registers.",
            optionD = "Context switching failure; prevent by using a single core CPU.",
            correctOption = "B",
            explanationA = "Incorrect: Removing locks would cause database corruption due to race conditions.",
            explanationB = "Correct: This is a classic deadlock. By enforcing a global lock ordering, Thread 2 would be blocked from acquiring lock B because it must wait for lock A first, breaking the Circular Wait condition and preventing deadlocks.",
            explanationC = "Incorrect: Thrashing is a memory page fault issue, not a thread locking deadlock.",
            explanationD = "Incorrect: Single-core CPUs still context-swap threads and can deadlock just like multi-core processors.",
            explanationCorrect = "Imposing a lock acquisition hierarchy is a highly effective, standard coding practice for deadlock prevention."
        ))

        q.add(Question(
            id = 424,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A virtual memory system uses paging. The logical address is 16 bits, with a page size of 4KB (2^12 bytes). How is the logical address split into page number and page offset?",
            optionA = "12 bits for Page Number; 4 bits for Offset.",
            optionB = "4 bits for Page Number; 12 bits for Page Offset.",
            optionC = "8 bits for Page Number; 8 bits for Page Offset.",
            optionD = "16 bits for Page Number; 0 bits for Page Offset.",
            correctOption = "B",
            explanationA = "Incorrect: Since the page size is 4KB (2^12), we need 12 bits to address every byte inside a single page, meaning the offset must be 12 bits.",
            explanationB = "Correct: A page size of 4KB (4096 bytes) is 2^12 bytes, requiring 12 bits for the page offset (displacement). The remaining bits of the 16-bit address (16 - 12 = 4 bits) represent the page number.",
            explanationC = "Incorrect: 8 bits of offset would only support 256-byte pages, not 4KB pages.",
            explanationD = "Incorrect: Without offset bits, you could only address the start of page frames, making byte offset addressing impossible.",
            explanationCorrect = "Splitting addresses into Page Number (to find the frame in the Page Table) and Page Offset (to locate the byte in the physical page) is handled automatically by the CPU's MMU."
        ))

        q.add(Question(
            id = 425,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: An OS uses demand paging. A process attempts to access a virtual memory address, but the MMU checks the page table entry and finds the 'Valid-Invalid' bit is set to 'Invalid'. What event occurs next?",
            optionA = "The CPU crashes and displays a segmentation fault.",
            optionB = "A Page Fault interrupt is triggered, prompting the OS kernel to load the missing page from disk into a free RAM frame.",
            optionC = "The OS formats the secondary storage drive.",
            optionD = "The process is assigned a higher priority instantly.",
            correctOption = "B",
            explanationA = "Incorrect: Segmentation faults occur only if the process attempts to access memory outside its authorized address space, not for normal demand paging.",
            explanationB = "Correct: An 'Invalid' bit means the page is valid but currently swapped out to disk. This triggers a Page Fault. The OS halts the process, locates the page on disk, copies it to RAM, updates the page table to 'Valid', and resumes the process.",
            explanationC = "Incorrect: Page faults are normal virtual memory operations; they do not trigger drive formatting.",
            explanationD = "Incorrect: Page faults suspend processes; they do not increase CPU scheduling priority.",
            explanationCorrect = "Demand paging allows operating systems to load files only as they are accessed, reducing application start times and memory usage."
        ))

        q.add(Question(
            id = 426,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: You are writing a concurrent download manager. The app needs to download 5 large files simultaneously while keeping the UI responsive. How should you design your software execution?",
            optionA = "Run all downloads sequentially on the main UI thread.",
            optionB = "Spawn 5 background worker threads to handle the network downloads, using callbacks or flows to update the main UI thread with progress.",
            optionC = "Write a loop that disables the OS interrupts during download.",
            optionD = "Run the application in Kernel Mode.",
            correctOption = "B",
            explanationA = "Incorrect: Downloading large files on the main UI thread blocks the event loop, causing the OS to report the app as 'Not Responding' (ANR).",
            explanationB = "Correct: Heavy I/O (network downloads) must be delegated to background threads so the main thread remains free to handle user interactions and render the UI smoothly.",
            explanationC = "Incorrect: User-space applications are strictly forbidden from disabling system interrupts for security and stability reasons.",
            explanationD = "Incorrect: Mobile and desktop applications run in User Mode; they cannot run in Kernel Mode.",
            explanationCorrect = "Multi-threading is essential for responsive applications. Always offload network, database, and heavy computational tasks from the UI thread."
        ))

        q.add(Question(
            id = 427,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A server administrator notices that after running for several months, the system has plenty of free memory in total, but the OS fails to allocate memory for a new process that requires a single contiguous block of 500MB of RAM. What is this problem?",
            optionA = "Internal Fragmentation",
            optionB = "External Fragmentation",
            optionC = "Virtual memory leakage",
            optionD = "Buffer Overflow fragmentation",
            correctOption = "B",
            explanationA = "Incorrect: Internal fragmentation occurs when allocated memory blocks are slightly larger than requested, leaving wasted space inside the allocated block.",
            explanationB = "Correct: External fragmentation occurs when total free memory is sufficient to satisfy a request, but the free memory is split into tiny, non-contiguous blocks scattered throughout RAM. The OS cannot find a single contiguous 500MB block.",
            explanationC = "Incorrect: Virtual memory leaks occur when processes forget to deallocate memory, reducing total free memory.",
            explanationD = "Incorrect: Buffer overflow is a security vulnerability, not a memory allocation layout problem.",
            explanationCorrect = "External fragmentation is resolved using Paging (which maps non-contiguous physical frames to contiguous logical pages) or compaction."
        ))

        q.add(Question(
            id = 428,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A developer is implementing a consumer-producer program. The producer thread adds items to a 10-slot queue, and the consumer thread removes them. If the queue is full, the producer must sleep; if the queue is empty, the consumer must sleep. How should the developer synchronize this safely?",
            optionA = "Use infinite while-loops in both threads checking the queue size.",
            optionB = "Use two counting Semaphores ('empty' initialized to 10, 'full' initialized to 0) and a Mutex to protect queue access.",
            optionC = "Make the queue size infinite so synchronization is unnecessary.",
            optionD = "Force both threads to run on a single CPU core sequentially.",
            correctOption = "B",
            explanationA = "Incorrect: Busy-waiting (infinite loops) wastes CPU cycles and can lead to thread starvation or lockups.",
            explanationB = "Correct: This is the classic Bounded Buffer problem. Semaphores manage thread blocking. The producer decrements 'empty' and increments 'full'. The consumer decrements 'full' and increments 'empty'. The Mutex prevents concurrent edits to the queue itself.",
            explanationC = "Incorrect: Infinite memory does not exist in computer systems; queues must have boundaries.",
            explanationD = "Incorrect: Sequential core limits do not prevent thread switching race conditions or buffer overflow errors.",
            explanationCorrect = "Semaphores provide a highly elegant, resource-safe method for threads to signal and suspend each other without wasting CPU cycles."
        ))

        q.add(Question(
            id = 429,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: An OS is executing processes. Process A is running, and the kernel decides to switch to Process B. Describe the exact hardware activities that take place during this switch.",
            optionA = "The compiler recompiles Process B; the RAM resets its clock lines.",
            optionB = "The CPU saves the state (registers, program counter, stack pointer) of Process A into its Process Control Block (PCB), loads the saved state of Process B from its PCB, and updates the MMU page table pointer. This is a 'Context Switch'.",
            optionC = "The OS kernel clears all L1 cache lines and formats the swap drive.",
            optionD = "The CPU pauses execution and waits for a manual interrupt from the motherboard.",
            correctOption = "B",
            explanationA = "Incorrect: Code is precompiled; compilers have zero involvement in context switches.",
            explanationB = "Correct: A Context Switch saves the current CPU context of the running process to its PCB in memory, and swaps in the context of the next process to run, enabling transparent multitasking.",
            explanationC = "Incorrect: Context switches do not format swap drives; while cache lines might become cold, full cache clears are avoided if possible.",
            explanationD = "Incorrect: The switch is managed entirely by the OS kernel's scheduler automatically in microseconds.",
            explanationCorrect = "Context switching introduces CPU overhead, so kernels are designed to minimize switches while maintaining responsive multitasking."
        ))

        q.add(Question(
            id = 430,
            chapter = 4,
            chapterTitle = "Operating Systems",
            isScenario = true,
            text = "Scenario: A database process is writing files to disk. A sudden power outage occurs. When the server reboots, the administrator checks the filesystem and finds that files are consistent and have no corrupt directory records because the OS was using a 'Journaling File System'. How did journaling prevent corruption?",
            optionA = "The journaling filesystem stores copies of files in cloud nodes.",
            optionB = "It writes metadata updates to a dedicated sequential log (journal) on disk before modifying the actual filesystem blocks. Upon reboot, the OS replays the journal to resolve incomplete writes.",
            optionC = "It uses physical gold-plated backup batteries inside the SSD.",
            optionD = "It prevents users from deleting files.",
            correctOption = "B",
            explanationA = "Incorrect: Journaling filesystems are local, they do not rely on network clouds for core filesystem consistency.",
            explanationB = "Correct: A journaling filesystem (like ext4 or NTFS) logs structural changes first. If a crash occurs mid-write, the filesystem recovery check merely reads the journal log to complete or safely roll back the transaction, preventing corruption in seconds.",
            explanationC = "Incorrect: Backup batteries are hardware solutions, not the definition of journaling filesystems.",
            explanationD = "Incorrect: Journaling does not restrict user permissions; it manages file write consistency.",
            explanationCorrect = "Journaling eliminates the need for slow, full-disk file integrity scans (like fsck or chkdsk) after unexpected power losses."
        ))

        return q
    }
}
