package com.example.data.repository

import com.example.data.model.Question

object Chapter2Questions {
    fun getQuestions(): List<Question> {
        val q = mutableListOf<Question>()

        // 15 Terminology Questions
        q.add(Question(
            id = 201,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "In database transaction management, what does the 'I' in ACID properties stand for?",
            optionA = "Inconsistency",
            optionB = "Isolation",
            optionC = "Integrity",
            optionD = "Idempotency",
            correctOption = "B",
            explanationA = "Incorrect: ACID properties prevent inconsistency; it is not a property itself.",
            explanationB = "Correct: 'I' stands for Isolation, which ensures that the concurrent execution of transactions results in a system state equivalent to if they were executed serially.",
            explanationC = "Incorrect: Integrity is a general database concept, but the 'C' in ACID stands for Consistency, and 'I' is Isolation.",
            explanationD = "Incorrect: Idempotency is an API or operation concept (performing a task multiple times has the same outcome), not part of ACID.",
            explanationCorrect = "Isolation levels (Read Uncommitted, Read Committed, Repeatable Read, Serializable) control the visibility of changes made by concurrent transactions."
        ))

        q.add(Question(
            id = 202,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "What is the primary difference between a 'Primary Key' and a 'Unique Key' constraint in a relational database?",
            optionA = "A table can have multiple Primary Keys but only one Unique Key.",
            optionB = "Primary Keys allow null values; Unique Keys strictly forbid null values.",
            optionC = "A table can have only one Primary Key, while it can have multiple Unique Keys; also, Primary Keys cannot be NULL.",
            optionD = "Primary Keys are used for security; Unique Keys are used for performance indexing.",
            correctOption = "C",
            explanationA = "Incorrect: This is reversed. A table can have only one Primary Key but multiple Unique Keys.",
            explanationB = "Incorrect: Primary Keys cannot be null, whereas Unique Keys typically allow one or more null values depending on the DBMS.",
            explanationC = "Correct: Relational databases permit only a single Primary Key per table to uniquely identify records. Multiple Unique Keys are allowed to enforce uniqueness on secondary columns, and Unique columns can support NULL values.",
            explanationD = "Incorrect: Both constraints automatically create indexes for performance and enforce data integrity; neither is specifically for security permissions.",
            explanationCorrect = "Primary keys are the main logical identifiers. Unique keys are secondary constraints to prevent duplicate entries (e.g., Email, Username)."
        ))

        q.add(Question(
            id = 203,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "Which normal form requires removing transitive functional dependencies to ensure data consistency?",
            optionA = "First Normal Form (1NF)",
            optionB = "Second Normal Form (2NF)",
            optionC = "Third Normal Form (3NF)",
            optionD = "Boyce-Codd Normal Form (BCNF)",
            correctOption = "C",
            explanationA = "Incorrect: 1NF requires atomic values and no repeating groups.",
            explanationB = "Incorrect: 2NF requires 1NF and removing partial key dependencies (where non-prime attributes depend on part of a composite key).",
            explanationC = "Correct: 3NF requires 2NF and that no transitive functional dependencies exist (meaning non-prime attributes cannot determine other non-prime attributes; X -> Y, Y -> Z where Y and Z are non-prime).",
            explanationD = "Incorrect: BCNF is a stronger version of 3NF that handles overlapping composite keys (every determinant must be a candidate key).",
            explanationCorrect = "Transitive dependencies cause anomalies; for instance, if Department determines DeptManager, storing this in an Employee table creates redundant manager data."
        ))

        q.add(Question(
            id = 204,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "What is the purpose of the SQL 'GROUP BY' clause?",
            optionA = "To filter rows individually based on logical conditions prior to sorting.",
            optionB = "To aggregate rows that have the same values in specified columns into summary rows.",
            optionC = "To combine columns from two or more tables based on join predicates.",
            optionD = "To create temporary indexes on query execution pathways dynamically.",
            correctOption = "B",
            explanationA = "Incorrect: Filtering individual rows is done using the WHERE clause.",
            explanationB = "Correct: GROUP BY is used to group rows with identical column values so aggregate functions like COUNT, SUM, AVG, MAX, or MIN can compute statistics for each group.",
            explanationC = "Incorrect: Combining columns from multiple tables is done using JOIN clauses.",
            explanationD = "Incorrect: Creating indexes is done using CREATE INDEX statements, not query clauses.",
            explanationCorrect = "When using GROUP BY, every column in the SELECT list that is not part of an aggregate function must be listed in the GROUP BY clause."
        ))

        q.add(Question(
            id = 205,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "In database concurrency control, what is a 'Deadlock'?",
            optionA = "A physical hard drive failure that causes database files to become corrupt.",
            optionB = "A state where two or more transactions are permanently blocked because each is waiting for a resource locked by the other.",
            optionC = "The delay that occurs when a query is executed on a table without an index.",
            optionD = "An unauthorized access attempt that locks the database administrator account.",
            correctOption = "B",
            explanationA = "Incorrect: Hard drive crashes are hardware failures, not concurrency deadlocks.",
            explanationB = "Correct: A deadlock occurs when Transaction A holds a lock on resource X and requests a lock on resource Y, while Transaction B holds a lock on Y and requests a lock on X. Neither can proceed.",
            explanationC = "Incorrect: Slow queries due to lack of indexes are performance issues, not deadlocks.",
            explanationD = "Incorrect: Security account lockouts are authentication controls, not database engine resource blocks.",
            explanationCorrect = "DBMS engines use deadlock detection algorithms (like wait-for graphs) to identify deadlocks and abort one of the transactions to break the loop."
        ))

        q.add(Question(
            id = 206,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "Which of the following database index structures is most optimal for range-based queries (e.g., WHERE age BETWEEN 20 AND 30)?",
            optionA = "Hash Index",
            optionB = "B+ Tree Index",
            optionC = "Bitmap Index",
            optionD = "Inverted Index",
            correctOption = "B",
            explanationA = "Incorrect: Hash Indexes are highly optimal for exact equality matches (O(1) lookups), but completely useless for range queries as they don't preserve sorting order.",
            explanationB = "Correct: B+ Trees store data in a balanced, sorted hierarchy. Since leaf nodes are linked in a sequential doubly-linked list, finding a range simply involves locating the start element and traversing leaf pointers directly.",
            explanationC = "Incorrect: Bitmap indexes are used for low-cardinality columns (e.g., Gender) in read-heavy data warehouses, not general range queries.",
            explanationD = "Incorrect: Inverted indexes are used for full-text search engines (mapping words to documents), not numeric range lookups.",
            explanationCorrect = "B+ Trees are the default indexing mechanism for relational databases because of their support for both equality and range lookups."
        ))

        q.add(Question(
            id = 207,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "In the context of the CAP theorem, which of the following is correct?",
            optionA = "A distributed system can guarantee Consistency, Availability, and Partition Tolerance simultaneously.",
            optionB = "Consistency means that every node in a distributed database returns the most recent write or an error.",
            optionC = "Availability means that all write operations are guaranteed to succeed even if nodes are down.",
            optionD = "Partition Tolerance is optional and can be turned off in internet-facing databases.",
            correctOption = "B",
            explanationA = "Incorrect: CAP theorem states a distributed system can guarantee at most two out of the three properties (C, A, P) at any given time.",
            explanationB = "Correct: Consistency in CAP means that all read operations across different nodes return the identical, newest data simultaneously, ensuring a unified state.",
            explanationC = "Incorrect: Availability means that every non-failing node returns a non-error response, but not necessarily the latest write. It does not guarantee write success on down nodes.",
            explanationD = "Incorrect: Network partitions (communication failures) are inevitable in real-world networks; thus, Partition Tolerance is mandatory and systems must choose between Consistency or Availability.",
            explanationCorrect = "When a partition occurs, a database must choose either Consistency (CP - block reads/writes until synchronized) or Availability (AP - allow stale operations)."
        ))

        q.add(Question(
            id = 208,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "What is the purpose of a 'Foreign Key' constraint in a relational database?",
            optionA = "To encrypt database tables when they are exported to foreign servers.",
            optionB = "To enforce referential integrity between tables by ensuring a column value matches a primary key in another table.",
            optionC = "To create a duplicate backup of critical tables in separate schemas.",
            optionD = "To allow foreign language characters to be stored in text columns.",
            correctOption = "B",
            explanationA = "Incorrect: Foreign keys are structural constraints, completely unrelated to cryptography or external transfers.",
            explanationB = "Correct: Foreign keys link tables together. It guarantees that the value in the child table always exists as a unique identifier in the parent table, preventing orphaned records.",
            explanationC = "Incorrect: Database replication handles backup tables, not foreign keys.",
            explanationD = "Incorrect: Storing international characters is handled by character encodings like UTF-8/UTF-16.",
            explanationCorrect = "Foreign keys can also enforce cascading behaviors, such as ON DELETE CASCADE, to clean up child rows automatically when a parent is deleted."
        ))

        q.add(Question(
            id = 209,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "Which of the following NoSQL database types is MongoDB classified as?",
            optionA = "Key-Value Store",
            optionB = "Document Store",
            optionC = "Column-Family Store",
            optionD = "Graph Database",
            correctOption = "B",
            explanationA = "Incorrect: Redis and DynamoDB are typical examples of key-value stores.",
            explanationB = "Correct: MongoDB is a document-oriented database that stores semi-structured data in JSON-like documents (BSON format), enabling flexible dynamic schemas.",
            explanationC = "Incorrect: Apache Cassandra and HBase are column-family stores.",
            explanationD = "Incorrect: Neo4j is a graph database which represents data as nodes, edges, and properties.",
            explanationCorrect = "Document databases allow nested structures, arrays, and sub-documents, aligning perfectly with object-oriented application models."
        ))

        q.add(Question(
            id = 210,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "What does the 'Two-Phase Locking' (2PL) protocol guarantee in transaction concurrency?",
            optionA = "It guarantees that deadlocks will never occur in the database.",
            optionB = "It guarantees the serializability of concurrent transactions.",
            optionC = "It ensures that transactions always execute in under two seconds.",
            optionD = "It replicates data across two physical databases synchronously.",
            correctOption = "B",
            explanationA = "Incorrect: Basic 2PL actually increases the chance of deadlocks. Deadlock prevention/detection is separate from 2PL.",
            explanationB = "Correct: 2PL is a concurrency control method that guarantees serializability. It consists of a growing phase (obtaining locks, releasing none) and a shrinking phase (releasing locks, obtaining none).",
            explanationC = "Incorrect: 2PL does not guarantee performance speeds, and can actually slow transactions due to lock contention.",
            explanationD = "Incorrect: Synchronous replication is a high-availability strategy, not a local concurrency transaction protocol.",
            explanationCorrect = "By ensuring transactions acquire all locks before releasing any, 2PL prevents conflicting concurrent schedules."
        ))

        q.add(Question(
            id = 211,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "In database systems, what is 'Normalization'?",
            optionA = "The process of scaling numeric database values to fit between 0 and 1.",
            optionB = "Structuring a relational database schema to reduce data redundancy and eliminate update anomalies.",
            optionC = "Upgrading the database software to match industry standard configurations.",
            optionD = "Converting NoSQL databases into relational tables automatically.",
            correctOption = "B",
            explanationA = "Incorrect: Numeric scaling is a feature normalization technique in machine learning/statistics, not database normalization.",
            explanationB = "Correct: Database normalization is the systematic decomposition of tables to ensure that dependencies are structured logically, which minimizes storage waste and prevents insert, update, and delete anomalies.",
            explanationC = "Incorrect: System configuration tuning is a DBA maintenance task, not normalization.",
            explanationD = "Incorrect: NoSQL to SQL conversion is data schema translation.",
            explanationCorrect = "Normalization splits fat, redundant tables into smaller tables and defines relationships between them using foreign keys."
        ))

        q.add(Question(
            id = 212,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "What is a 'Database View'?",
            optionA = "A graphical dashboard that displays live database throughput and resource usage.",
            optionB = "A virtual table based on the result-set of an active SQL SELECT query statement.",
            optionC = "A backup copy of a table stored in-memory for fast read access.",
            optionD = "The specific user permissions assigned to access specific tables.",
            correctOption = "B",
            explanationA = "Incorrect: Hardware/engine telemetry dashboards are monitoring tools, not views.",
            explanationB = "Correct: A view is a logical virtual table. It doesn't store physical data itself (unless it's a materialized view), but acts as a saved query that can be queried exactly like a real table.",
            explanationC = "Incorrect: Cached memory structures are indexes or redis stores, not basic database views.",
            explanationD = "Incorrect: Permissions are managed via Role-Based Access Controls (RBAC) and GRANT statements.",
            explanationCorrect = "Views are highly useful for simplifying complex queries, encapsulating legacy schemas, and restricting user access to specific rows/columns."
        ))

        q.add(Question(
            id = 213,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "What is the primary objective of a 'Data Warehouse' compared to an 'Operational Database'?",
            optionA = "Data warehouses process fast real-time online transaction inserts; Operational databases process bulk archival data.",
            optionB = "Data warehouses are structured for analytical query processing (OLAP); Operational databases are optimized for transactional updates (OLTP).",
            optionC = "Data warehouses store unstructured text; Operational databases store structured tables.",
            optionD = "Data warehouses run entirely in-memory; Operational databases write directly to tapes.",
            correctOption = "B",
            explanationA = "Incorrect: This is completely backwards. Operational databases (OLTP) handle fast daily transactions; data warehouses (OLAP) handle historic aggregate analyses.",
            explanationB = "Correct: Operational databases are designed for fast reads/writes of single business records (OLTP). Data Warehouses are specialized repositories designed to run heavy aggregates, reports, and analytical queries across historic data (OLAP).",
            explanationC = "Incorrect: Both store structured or semi-structured data; data warehouses frequently use star or snowflake relational schemas.",
            explanationD = "Incorrect: Both use modern high-performance SSD and memory architectures; tape writes are purely archival backups.",
            explanationCorrect = "Separating transactional databases from data warehouses ensures that analytical aggregates do not slow down active customer checkouts."
        ))

        q.add(Question(
            id = 214,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "What is an 'Anomaly' in an unnormalized database table?",
            optionA = "An error that occurs when the database engine runs out of physical memory.",
            optionB = "An unexpected data inconsistency or corruption resulting from inserts, updates, or deletes on redundant tables.",
            optionC = "A secure login attempt from an unknown external IP address.",
            optionD = "A query that executes in zero milliseconds due to caching rules.",
            correctOption = "B",
            explanationA = "Incorrect: Out of memory errors are OS/hardware level exceptions.",
            explanationB = "Correct: Redundancy causes anomalies. If a change occurs (e.g. customer address updates) and data is duplicated, updating only one row leads to an Update Anomaly where the customer has two different addresses in the database.",
            explanationC = "Incorrect: IP logins are network security audit logs.",
            explanationD = "Incorrect: Fast cache hit queries are ideal, not anomalies.",
            explanationCorrect = "The three database anomalies are Insert anomaly (inability to insert data because other unrelated data is missing), Update anomaly, and Delete anomaly."
        ))

        q.add(Question(
            id = 215,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = false,
            text = "Which of the following best describes the 'Consistency' property in ACID?",
            optionA = "It ensures that transactions are written to disk continuously without network delay.",
            optionB = "It guarantees that a transaction can only transition the database from one valid state to another, maintaining all schema constraints and rules.",
            optionC = "It ensures that the database returns identical values even if multiple clients read concurrently.",
            optionD = "It maintains a consistent connection pool to prevent timeout errors.",
            correctOption = "B",
            explanationA = "Incorrect: Fast disk writes are related to Durability and DBMS buffering, not Consistency.",
            explanationB = "Correct: Consistency ensures that a transaction cannot violate any defined database constraints (like foreign keys, check constraints, unique indexes). If a transaction attempts to violate a rule, the entire transaction is rolled back.",
            explanationC = "Incorrect: Concurrent read isolation is handled by Isolation ('I' in ACID), not Consistency.",
            explanationD = "Incorrect: Connection pooling is an application-level optimization, unrelated to ACID database transactions.",
            explanationCorrect = "ACID Consistency ensures that database invariants (rules that must always be true) are never violated by any transaction."
        ))

        // 15 Scenario-based Questions
        q.add(Question(
            id = 216,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A university database has a table 'StudentCourses(StudentID, StudentName, CourseID, CourseName, InstructorName, InstructorRoom)'. The primary key is a composite key: (StudentID, CourseID). StudentName depends only on StudentID. What normal form is violated, and what anomalies occur?",
            optionA = "1NF is violated; repeating groups cause null arrays.",
            optionB = "2NF is violated; partial dependencies exist where StudentName depends on only part of the composite key.",
            optionC = "3NF is violated; transitive dependencies exist because instructor room depends on the instructor name.",
            optionD = "BCNF is violated; the candidate keys overlap in secondary attributes.",
            correctOption = "B",
            explanationA = "Incorrect: The fields contain scalar values, so 1NF is not violated.",
            explanationB = "Correct: This schema violates 2NF. StudentID and CourseID are the composite primary key. StudentName depends strictly on StudentID alone, which is a partial dependency. To normalize to 2NF, StudentID and StudentName must be split into a separate Students table.",
            explanationC = "Incorrect: While InstructorRoom depending on InstructorName is a transitive dependency (violating 3NF), the most fundamental, first violation in the normal form chain is the 2NF partial dependency.",
            explanationD = "Incorrect: BCNF is checked after 3NF is established; we have fundamental 2NF violations.",
            explanationCorrect = "In a 2NF violation, if a student changes their name, you must update multiple rows across all their courses, risking an update anomaly."
        ))

        q.add(Question(
            id = 217,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: You are designing a database for a social media app where users can dynamically post photos, check-in to locations, tag friends, and post comments. The relationships are highly interconnected and flexible, and you need to query 'Friends of Friends who checked in to location X' fast. Which NoSQL type is best?",
            optionA = "Key-Value Store (Redis), for quick memory fetching.",
            optionB = "Document Database (MongoDB), for flexible nested tables.",
            optionC = "Column-Family Database (Cassandra), for wide distributed writes.",
            optionD = "Graph Database (Neo4j), for traversing direct entity nodes and relational edges.",
            correctOption = "D",
            explanationA = "Incorrect: Key-Value stores are poor for traversing complex relational networks.",
            explanationB = "Incorrect: While Document stores can save nested lists, traversing deep multi-level relational hops requires slow, manual application-level code loops.",
            explanationC = "Incorrect: Column-family databases are optimized for large-scale sequential timeseries or logs, not multi-hop pointer traversals.",
            explanationD = "Correct: Graph databases are specifically designed for highly interconnected datasets. They treat entities as nodes and relationships as first-class edges, allowing index-free adjacency to traverse deep connections (like friends of friends) in milliseconds.",
            explanationCorrect = "For deeply relational networks (e.g., social graphs, recommendation engines, fraud detection), Graph databases outperform relational JOINs."
        ))

        q.add(Question(
            id = 218,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A banking database is executing millions of tiny credit/debit transactions concurrently. A customer reports that their balance briefly dipped below zero during a concurrent transfer, even though the database eventually settled. What isolation level is likely configured, and what concurrency issue occurred?",
            optionA = "Serializable; a deadlock aborted the balance update.",
            optionB = "Read Uncommitted; a Dirty Read occurred where another transaction's incomplete state was visible.",
            optionC = "Read Committed; a Non-Repeatable Read occurred because of schema locks.",
            optionD = "Repeatable Read; a Phantom Read occurred due to newly inserted record sets.",
            correctOption = "B",
            explanationA = "Incorrect: Serializable is the highest isolation level and guarantees complete serial consistency; dirty reads are impossible.",
            explanationB = "Correct: Under Read Uncommitted isolation, transactions can read uncommitted, intermediate changes made by other active transactions. This is known as a Dirty Read. Transaction A subtracted money from balance, and Transaction B read this intermediate state before Transaction A committed.",
            explanationC = "Incorrect: Read Committed prevents dirty reads; you would never see another transaction's intermediate state.",
            explanationD = "Incorrect: Repeatable Read prevents dirty and non-repeatable reads, only allowing phantom inserts.",
            explanationCorrect = "To prevent dirty reads, the database isolation level must be raised to at least Read Committed, ensuring only finalized data is read."
        ))

        q.add(Question(
            id = 219,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: Your production SQL query 'SELECT * FROM orders WHERE customer_id = 9521 AND status = 'Pending'' is running extremely slow, taking 8 seconds. The table contains 10 million rows. You run EXPLAIN and see a full table scan. What is the immediate solution?",
            optionA = "Add more RAM to the database hardware controller.",
            optionB = "Create a composite index on (customer_id, status) columns.",
            optionC = "Convert the orders table to a NoSQL JSON document.",
            optionD = "Split the table into 10 smaller tables manually.",
            correctOption = "B",
            explanationA = "Incorrect: Throwing hardware at a bad query plan is expensive and doesn't fix the underlying O(N) lookup complexity.",
            explanationB = "Correct: A full table scan means the database must inspect all 10 million rows. By creating a composite index on customer_id and status, the database can do an O(log N) tree traversal to find matching rows instantly.",
            explanationC = "Incorrect: Converting database engines is an enormous, expensive architecture change that does not guarantee speed without indexing.",
            explanationD = "Incorrect: Manual table splitting is messy and unnecessary; indexing is the standard relational solution for fast lookups.",
            explanationCorrect = "Indexes turn costly linear database table scans into logarithmic tree lookups, reducing query times from seconds to milliseconds."
        ))

        q.add(Question(
            id = 220,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A ride-hailing company stores GPS coordinates of vehicles every second. They need to run queries like 'Find all active drivers within a 5km radius of this rider' in under 50ms. Which index type should they create on the vehicle coordinate columns?",
            optionA = "B-Tree Index, on latitude and longitude separately.",
            optionB = "Spatial Index (R-Tree / GiST), for indexing multi-dimensional geometric data.",
            optionC = "Bitmap Index, to index high-volume timeseries variables.",
            optionD = "Hash Index, for coordinate equality pairings.",
            correctOption = "B",
            explanationA = "Incorrect: B-Trees are 1-dimensional. Scanning latitude and longitude separately in B-Trees forces expensive index intersections and is slow for radius queries.",
            explanationB = "Correct: Spatial indexes like R-Trees or GiST indexes group points into bounding rectangles. This allows the database to perform spatial range and bounding box queries (e.g., coordinates within a circular range) very efficiently.",
            explanationC = "Incorrect: Bitmap indexes are for low-cardinality status columns, not floating-point coordinates.",
            explanationD = "Incorrect: Hash indexes only work for exact matching, not geographical coordinates within a radius.",
            explanationCorrect = "Spatial indexing is mandatory for geographic databases (GIS) to calculate distances, intersections, and containing areas."
        ))

        q.add(Question(
            id = 221,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A developer is building a high-volume financial accounting service. When transferring $100 from Account A to Account B, the code subtracts $100 from A, but then a network timeout crashes the app before it can add $100 to B. Which ACID property was violated?",
            optionA = "Consistency",
            optionB = "Durability",
            optionC = "Atomicity",
            optionD = "Isolation",
            correctOption = "C",
            explanationA = "Incorrect: While the resulting state is inconsistent, the primary transactional guarantee violated is the failure to roll back the partial change.",
            explanationB = "Incorrect: Durability ensures committed changes survive system crashes; here, the transfer was incomplete and should never have been saved.",
            explanationC = "Correct: Atomicity is the 'All-or-Nothing' property. It guarantees that if any part of a database transaction fails (like the second update), the entire transaction rolls back to the starting state.",
            explanationD = "Incorrect: Isolation handles visibility of concurrent states, not incomplete single transaction failures.",
            explanationCorrect = "To enforce Atomicity, the balance updates must be wrapped in a single database transaction block (BEGIN... COMMIT/ROLLBACK)."
        ))

        q.add(Question(
            id = 222,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: An e-commerce system uses a relational database to store products and order histories. During Black Friday, the database locks up because millions of users are writing and reading orders at the same time. The database administrator wants to scale out. What is the best immediate architectural scaling pattern?",
            optionA = "Convert all tables to a single massive CSV flat file.",
            optionB = "Implement Read Replicas (Primary-Replica replication) to offload search and read traffic from the write-active primary database.",
            optionC = "Turn off ACID transactions completely during checkout hours.",
            optionD = "Migrate to a single wider mainframe server.",
            correctOption = "B",
            explanationA = "Incorrect: Flat files lack concurrency controls, indexes, and ACID transactions, which would crash instantly.",
            explanationB = "Correct: In e-commerce, read traffic (searching, viewing products) outnumbers write traffic (placing orders) by 10:1. By setting up read replicas, all search queries can be offloaded, leaving the primary database dedicated to handling writes.",
            explanationC = "Incorrect: Turning off transactions would corrupt financial logs and inventory numbers, destroying the business integrity.",
            explanationD = "Incorrect: Mainframe migration is highly complex, slow, and expensive. Read replicas scale horizontally very easily.",
            explanationCorrect = "Primary-Replica scaling splits reads and writes, allowing cheap horizontal scaling of read capacity across multiple replica servers."
        ))

        q.add(Question(
            id = 223,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: In an enterprise inventory system, Transaction 1 locks Row A, then tries to update Row B. Simultaneously, Transaction 2 locks Row B, then tries to update Row A. The system hangs for 2 seconds, and then Transaction 1 is suddenly aborted by the DBMS. Why?",
            optionA = "Transaction 1 violated database constraints.",
            optionB = "A deadlock occurred, and the DBMS deadlock detector aborted Transaction 1 (victim) to resolve the block.",
            optionC = "Transaction 1 timed out because of physical network lag.",
            optionD = "The Row B data file was corrupted by Transaction 2.",
            correctOption = "B",
            explanationA = "Incorrect: This is a locking concurrency dependency loop, not a database constraint check failure.",
            explanationB = "Correct: This is a classic mutual deadlock scenario. To break the deadlock, the DBMS automatically detects the dependency cycle, selects one transaction as a 'victim', aborts it, and rolls it back, allowing the other to complete.",
            explanationC = "Incorrect: DBMS engines abort deadlocks immediately upon detection; it is an active engine intervention rather than random network lag.",
            explanationD = "Incorrect: No file corruption occurred. It is purely a concurrency locking issue.",
            explanationCorrect = "Deadlocks are resolved by rolling back one transaction so its locks are released, allowing other transactions to proceed."
        ))

        q.add(Question(
            id = 224,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: You are designing a data warehouse for retail sales analysis. The warehouse needs to support aggregate queries like 'Calculate total quarterly sales grouped by store location and product category'. Which relational schema model is most appropriate?",
            optionA = "A single massive unnormalized flat table.",
            optionB = "Star Schema, consisting of a central Fact table (sales) connected to multiple denormalized Dimension tables (stores, products, time).",
            optionC = "Highly normalized 3NF relational tables with 45 separate joint entities.",
            optionD = "A Key-Value schema using key names as query prefixes.",
            correctOption = "B",
            explanationA = "Incorrect: Unnormalized flat tables have huge storage footprints and slow search speeds for large datasets.",
            explanationB = "Correct: The Star Schema is the standard dimensional model for data warehouses. It contains a high-volume Fact table (storing numeric measurements and keys) surrounded by descriptive Dimension tables. This optimizes query performance and simplifies analytical reporting.",
            explanationC = "Incorrect: Highly normalized 3NF schemas require too many JOIN operations, making analytical aggregate queries extremely slow.",
            explanationD = "Incorrect: Key-Value stores are not designed for multi-dimensional aggregation and analytical queries.",
            explanationCorrect = "Star schemas optimize read performance for analytical queries by reducing the number of JOINs required to compile reports."
        ))

        q.add(Question(
            id = 225,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A banking system uses the following transaction sequence: BEGIN; SELECT balance FROM accounts WHERE id = 1; (some local code math); UPDATE accounts SET balance = 500 WHERE id = 1; COMMIT. If two users run this concurrently on the same account with $1000 balance, what anomaly can occur, and how do we prevent it?",
            optionA = "Phantom Read; prevent with read replicas.",
            optionB = "Lost Update; prevent by using SELECT FOR UPDATE (optimistic/pessimistic locking) or atomic SQL updates.",
            optionC = "Dirty Read; prevent by clearing the database buffer pool.",
            optionD = "Write Skew; prevent by setting the isolation level to Read Uncommitted.",
            correctOption = "B",
            explanationA = "Incorrect: Phantom read refers to newly inserted rows appearing in a range, not updates to an existing balance.",
            explanationB = "Correct: This is a Lost Update anomaly. Both transactions read balance=$1000. T1 updates balance to $900. T2 updates balance to $800, overwriting T1's update completely. Using pessimistic locking (SELECT FOR UPDATE) blocks T2 until T1 finishes.",
            explanationC = "Incorrect: Dirty reads are prevented by standard Read Committed isolation, but that isolation does not prevent lost updates.",
            explanationD = "Incorrect: Read Uncommitted makes concurrency anomalies worse, not better.",
            explanationCorrect = "Using 'UPDATE accounts SET balance = balance - 100' or SELECT FOR UPDATE prevents concurrent transactions from overwriting each other's changes."
        ))

        q.add(Question(
            id = 226,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: You are designing a globally distributed database for a flight booking app. If a network partition occurs between your US and EU servers, you must choose between consistency (refusing bookings until connection returns) or availability (letting users book and dealing with double-bookings later). This architectural choice is defined by which concept?",
            optionA = "ACID consistency",
            optionB = "The CAP Theorem",
            optionC = "The Star Schema",
            optionD = "Two-Phase Commit",
            correctOption = "B",
            explanationA = "Incorrect: ACID consistency is about local schema integrity rules, not distributed network partition trade-offs.",
            explanationB = "Correct: The CAP Theorem states that in the presence of a network Partition (P), you must choose either Consistency (C) or Availability (A). Choosing consistency prevents double bookings but makes the app unavailable in EU during the partition.",
            explanationC = "Incorrect: Star schema is a dimensional modeling pattern for analytics, unrelated to network partitioning.",
            explanationD = "Incorrect: Two-phase commit is a distributed transaction protocol, but it cannot override the CAP theorem's partition limitations.",
            explanationCorrect = "Real-world distributed systems must explicitly choose either CP (consistency) or AP (availability) to handle inevitable network failures."
        ))

        q.add(Question(
            id = 227,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A developer is querying a database: 'SELECT * FROM users WHERE state = 'CA' ORDER BY last_name'. The table has an index on 'state' and another index on 'last_name'. Explain why this query might still be slow.",
            optionA = "A table cannot have more than one index; the secondary index is ignored.",
            optionB = "The database can typically only use one single-column index per table access, forcing a scan or sort. A composite index on (state, last_name) is needed.",
            optionC = "Indexes cannot be used for sorting data.",
            optionD = "Sorting CA state records corrupts the database buffer cache.",
            correctOption = "B",
            explanationA = "Incorrect: Tables can have many indexes, but queries are generally planned to use only one index per table scan.",
            explanationB = "Correct: When executing this query, the query planner will use the index on 'state' to filter CA rows, but then it must perform an expensive, manual sorting operation on 'last_name' in memory. A composite index on (state, last_name) stores CA rows pre-sorted by last name.",
            explanationC = "Incorrect: Indexes absolutely can be used for sorting if they are composite indexes structured with the sort columns.",
            explanationD = "Incorrect: Sorting is a safe memory and disk operation; it does not corrupt DBMS caching engines.",
            explanationCorrect = "Composite indexes must be created with columns ordered from high selectivity to sorting order (Filter column first, Sort column second)."
        ))

        q.add(Question(
            id = 228,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: You are auditing a database schema and find a column 'tags' containing comma-separated strings (e.g. 'sports,news,health') in a 'NewsArticles' table. What design principle is violated, and what is the fix?",
            optionA = "3NF is violated; fix by normalizing tags to candidate keys.",
            optionB = "First Normal Form (1NF) is violated because 'tags' is not atomic. Fix by creating a separate 'ArticleTags' junction table.",
            optionC = "BCNF is violated; fix by creating an index on tags.",
            optionD = "None; comma-separated lists are the relational database standard.",
            correctOption = "B",
            explanationA = "Incorrect: You cannot check 3NF without first satisfying 1NF and 2NF.",
            explanationB = "Correct: 1NF requires that all column values be atomic (single-valued). Storing comma-separated lists in a single cell violates 1NF, making queries like 'find all sports articles' slow and complex. A separate junction table is needed.",
            explanationC = "Incorrect: BCNF is unrelated to non-atomic column groupings.",
            explanationD = "Incorrect: Comma-separated strings make querying, indexing, and updating tags extremely difficult, violating relational design rules.",
            explanationCorrect = "Satisfying 1NF by using normalized junction tables enables foreign key constraints and fast indexed lookups."
        ))

        q.add(Question(
            id = 229,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A DBA configures a database server with a Write-Ahead Log (WAL). During a power outage, the server crashes. Upon rebooting, what does the database engine do to guarantee Durability?",
            optionA = "It deletes all tables and restores them from a weekly tape backup.",
            optionB = "It reads the WAL to Redo committed transactions that weren't flushed to the main tables, and Undo uncommitted transactions.",
            optionC = "It ignores the crash because relational databases do not lose data on power loss.",
            optionD = "It prompts the administrator to manually rewrite the missing transactions.",
            correctOption = "B",
            explanationA = "Incorrect: Full tape restores are a last resort for catastrophic failures, not standard reboot crash recovery.",
            explanationB = "Correct: The WAL records all modifications before they are written to physical tables. Upon rebooting, the recovery manager replays the log (Redo) to apply changes from committed transactions, and rolls back (Undo) any transactions that were active but uncommitted when the power failed.",
            explanationC = "Incorrect: Memory buffers are volatile; without active WAL recovery, transactions stored in memory buffers but not flushed to disk would be permanently lost.",
            explanationD = "Incorrect: Recovery must be automatic, fast, and handled entirely by the DBMS.",
            explanationCorrect = "The Write-Ahead Log ensures that transactions are durable even if physical table files are not updated before a crash."
        ))

        q.add(Question(
            id = 230,
            chapter = 2,
            chapterTitle = "Database Systems",
            isScenario = true,
            text = "Scenario: A company is designing an online auction system. They need to ensure that when a bid is placed, the item status and current bid are updated simultaneously across 3 different microservice databases (Inventory, Bidding, Billing). If one database fails, all must fail. Which pattern should they use?",
            optionA = "Two-Phase Commit (2PC) protocol or the Saga Pattern.",
            optionB = "Database Replication with read-only replicas.",
            optionC = "A single composite index across all databases.",
            optionD = "A standard SQL VIEW linking the systems.",
            correctOption = "A",
            explanationA = "Correct: Ensuring atomicity across distributed databases requires distributed transactions (Two-Phase Commit, consisting of a prepare phase and a commit phase) or a Saga pattern (a sequence of local transactions with compensating actions to roll back failures).",
            explanationB = "Incorrect: Replication copies data to replicas but does not manage multi-database transactional consistency.",
            explanationC = "Incorrect: Indexes are local to individual databases; they cannot span separate database engines or services.",
            explanationD = "Incorrect: Standard SQL views cannot span independent microservice physical database boundaries.",
            explanationCorrect = "Modern microservices typically prefer the Saga pattern because 2PC is blocking and has poor performance over networks."
        ))

        return q
    }
}
