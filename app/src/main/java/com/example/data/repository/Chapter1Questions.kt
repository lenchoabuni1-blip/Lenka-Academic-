package com.example.data.repository

import com.example.data.model.Question

object Chapter1Questions {
    fun getQuestions(): List<Question> {
        val q = mutableListOf<Question>()

        // 15 Terminology Questions
        q.add(Question(
            id = 101,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "In Agile software development, what is the primary purpose of the 'Daily Stand-up' meeting?",
            optionA = "To demo completed software features to the project stakeholders and client.",
            optionB = "To perform detailed code review and resolve complex technical architectural conflicts.",
            optionC = "To synchronize activities, discuss progress on sprint goals, and identify blockers.",
            optionD = "To estimate user story points and plan tasks for the next upcoming sprint cycle.",
            correctOption = "C",
            explanationA = "Incorrect: Stakeholder demos occur during the Sprint Review at the end of a sprint, not in daily stand-ups.",
            explanationB = "Incorrect: In-depth technical discussions and code reviews are too long for a 15-minute stand-up and should be handled in separate technical meetings.",
            explanationC = "Correct: The Daily Stand-up is a quick, 15-minute time-boxed event for the development team to align, share what they did, what they will do, and identify impediments.",
            explanationD = "Incorrect: Estimations and sprint planning occur during backlog grooming and Sprint Planning sessions, not in daily standups.",
            explanationCorrect = "The Daily Stand-up is designed for team synchronization on the sprint goal and highlighting blocks immediately."
        ))

        q.add(Question(
            id = 102,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "Which of the following best describes the difference between 'Verification' and 'Validation' in software testing?",
            optionA = "Verification ensures we are building the product right; Validation ensures we built the right product.",
            optionB = "Verification ensures the product meets security standards; Validation ensures performance is optimal.",
            optionC = "Verification is performed by developers; Validation is performed exclusively by automated QA tools.",
            optionD = "Verification occurs only during post-release maintenance; Validation happens during the requirements phase.",
            correctOption = "A",
            explanationA = "Correct: Verification checks if the software conforms to specifications (building it right). Validation checks if the software meets user needs and expectations (building the right thing).",
            explanationB = "Incorrect: Security and performance are non-functional testing aspects that can be verified and validated, but they do not define the core distinction between verification and validation.",
            explanationC = "Incorrect: Both developers and QA engineers can perform verification and validation throughout the lifecycle. It is not constrained by role or tool type.",
            explanationD = "Incorrect: Verification and validation occur throughout the entire software development lifecycle, not just at the start or post-release.",
            explanationCorrect = "Verification evaluates intermediate work products (e.g., designs, specs, code reviews), while validation evaluates the final compiled product against user needs."
        ))

        q.add(Question(
            id = 103,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "What is the key characteristic of the 'Observer' design pattern?",
            optionA = "It restricts a class to a single instance and provides a global access point to it.",
            optionB = "It defines a one-to-many dependency so that when one object changes state, its dependents are notified.",
            optionC = "It decouples an abstraction from its implementation so that the two can vary independently.",
            optionD = "It uses a factory method to create objects without specifying the exact class to create.",
            correctOption = "B",
            explanationA = "Incorrect: Restricting a class to a single instance is the Singleton design pattern.",
            explanationB = "Correct: The Observer pattern establishes a publish-subscribe mechanism where an observable subject automatically notifies all registered observer objects of state changes.",
            explanationC = "Incorrect: Decoupling abstraction from implementation is the Bridge design pattern.",
            explanationD = "Incorrect: Creating objects without specifying the exact class is the Factory Method design pattern.",
            explanationCorrect = "The Observer pattern is ideal for event-driven systems where changes in one component need to trigger updates in others dynamically."
        ))

        q.add(Question(
            id = 104,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "In Clean Architecture, which layer should contain the core business rules and entities that are independent of external frameworks?",
            optionA = "The Presentation layer (UI and ViewModels).",
            optionB = "The Data/Infrastructure layer (databases, API clients).",
            optionC = "The Domain layer (Entities and Use Cases).",
            optionD = "The Configuration/Framework layer (routers, DI containers).",
            correctOption = "C",
            explanationA = "Incorrect: Presentation is an outer layer that handles visual layout and user interactions, which depend on external UI frameworks.",
            explanationB = "Incorrect: Data/Infrastructure handles persistent engines and network calls, which depend on external libraries.",
            explanationC = "Correct: The Domain layer is the innermost layer in Clean Architecture, containing core enterprise business models (Entities) and application business rules (Use Cases) that remain completely isolated from UI, database, or network changes.",
            explanationD = "Incorrect: Configuration/Framework is the outermost layer of details where third-party SDKs and configuration hooks reside.",
            explanationCorrect = "By placing business rules in the domain layer, you protect them from being broken by changes in databases or UI toolkits."
        ))

        q.add(Question(
            id = 105,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "What is the difference between 'Cohesion' and 'Coupling' in software design?",
            optionA = "Cohesion is the degree to which a module relies on other modules; Coupling is the focus of a single module.",
            optionB = "High cohesion means a module does one thing well; Low coupling means modules are highly independent.",
            optionC = "High cohesion means modules are highly dependent; Low coupling means a module has scattered responsibilities.",
            optionD = "Cohesion applies to object inheritance; Coupling applies only to microservices architectures.",
            correctOption = "B",
            explanationA = "Incorrect: This is reversed. Coupling is the degree of reliance on other modules; cohesion is the focus within a single module.",
            explanationB = "Correct: Cohesion refers to how closely related and focused the responsibilities within a single module are. Coupling is the strength of relationships between modules. High cohesion and low coupling are ideal.",
            explanationC = "Incorrect: High cohesion leads to single-focused, self-contained modules, not high dependencies. Low coupling keeps modules independent.",
            explanationD = "Incorrect: Cohesion and coupling are fundamental design principles that apply at all levels of software engineering, from classes to services.",
            explanationCorrect = "High Cohesion and Low Coupling make code modular, testable, maintainable, and highly resilient to modifications."
        ))

        q.add(Question(
            id = 106,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "Which UML diagram is most suitable for modeling the dynamic, sequential interaction between objects over time?",
            optionA = "Class Diagram",
            optionB = "Use Case Diagram",
            optionC = "Sequence Diagram",
            optionD = "Component Diagram",
            correctOption = "C",
            explanationA = "Incorrect: A Class Diagram models the static structural design of classes and their associations, not interactions over time.",
            explanationB = "Incorrect: A Use Case Diagram models system actors and their high-level goals or interactions with system boundaries, not detailed object interactions.",
            explanationC = "Correct: A Sequence Diagram is an interaction diagram that details how operations are carried out, showing objects and the messages exchanged between them ordered in time.",
            explanationD = "Incorrect: A Component Diagram displays the structural organization of physical software components, not runtime dynamic messages.",
            explanationCorrect = "Sequence Diagrams are excellent for tracing call stacks, API call sequences, and lifecycle events between objects."
        ))

        q.add(Question(
            id = 107,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "What does the 'L' stand for in the SOLID principles of Object-Oriented Design?",
            optionA = "Loose Coupling Principle",
            optionB = "Liskov Substitution Principle",
            optionC = "Law of Demeter",
            optionD = "Late Binding Principle",
            correctOption = "B",
            explanationA = "Incorrect: Loose coupling is an important general concept, but it is not one of the five SOLID principles.",
            explanationB = "Correct: Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of its subclasses without breaking the correctness of the application.",
            explanationC = "Incorrect: The Law of Demeter is a design guideline for loose coupling (talk only to immediate friends), but not part of SOLID.",
            explanationD = "Incorrect: Late binding is a runtime polymorphism concept, not a SOLID principle.",
            explanationCorrect = "LSP ensures that inheritance hierarchies are designed correctly so that sub-types do not violate the contracts of their parents."
        ))

        q.add(Question(
            id = 108,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "What is the primary benefit of 'Continuous Integration' (CI) in modern DevOps pipelines?",
            optionA = "It automates the deployment of software directly to production servers instantly on every change.",
            optionB = "It allows stakeholders to manually approve features before they are packaged into releases.",
            optionC = "It automatically integrates code changes from multiple contributors into a shared repository frequently, running automated builds and tests.",
            optionD = "It generates comprehensive user documentation and test reports automatically.",
            correctOption = "C",
            explanationA = "Incorrect: Direct automatic deployment to production is Continuous Deployment (CD), which is the next stage after CI.",
            explanationB = "Incorrect: Manual approval workflows are characteristic of continuous delivery release pipelines, not the core automatic integration step of CI.",
            explanationC = "Correct: Continuous Integration focuses on automatically merging, building, and testing code branches frequently to detect integration errors as early as possible.",
            explanationD = "Incorrect: While CI can run documentation tools, generating user-facing documentation is not its primary system purpose.",
            explanationCorrect = "CI prevents 'integration hell' by ensuring that the codebase is always in a building, functional state as developers commit code."
        ))

        q.add(Question(
            id = 109,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "In requirements engineering, what is the distinction between 'Functional' and 'Non-Functional' requirements?",
            optionA = "Functional requirements describe what the system must do; Non-functional requirements describe how well it must do it.",
            optionB = "Functional requirements are critical to the system; Non-functional requirements are entirely optional extras.",
            optionC = "Functional requirements are written by developers; Non-functional requirements are written by stakeholders.",
            optionD = "Functional requirements cover GUI components; Non-functional requirements cover database engines.",
            correctOption = "A",
            explanationA = "Correct: Functional requirements specify system behaviors, features, and inputs/outputs (e.g., 'system must send an email on signup'). Non-functional requirements specify quality attributes and constraints (e.g., 'system must load within 2 seconds' or 'must be encrypted').",
            explanationB = "Incorrect: Non-functional requirements (security, availability, performance) are highly critical and are not optional features.",
            explanationC = "Incorrect: Both types are collaborative specifications created by product managers, business analysts, and architects together.",
            explanationD = "Incorrect: Both frontend and backend components have functional features and non-functional performance/security characteristics.",
            explanationCorrect = "Functional requirements are the direct features, while non-functional requirements are the operational parameters of those features."
        ))

        q.add(Question(
            id = 110,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "What is 'Technical Debt' in software project management?",
            optionA = "The financial debt a company incurs to license development tools and cloud servers.",
            optionB = "The implied cost of additional future rework caused by choosing an easy, quick solution now instead of a better, systematic design.",
            optionC = "The loss of productivity when developers leave the team during active sprint cycles.",
            optionD = "The hours spent debugging logical errors introduced by junior software engineers.",
            correctOption = "B",
            explanationA = "Incorrect: Technical debt is a structural software design metaphor, not an actual financial or licensing ledger liability.",
            explanationB = "Correct: Technical debt represents the long-term code complexity and maintenance overhead that builds up when code is rushed or hacked to meet short-term deadlines instead of engineered cleanly.",
            explanationC = "Incorrect: Team attrition is a project risk and resource issue, not technical debt.",
            explanationD = "Incorrect: While debugging buggy code takes time, technical debt is specifically about structural design decay rather than isolated syntax bugs.",
            explanationCorrect = "Just like financial debt, technical debt must be 'paid down' through refactoring, or the accumulation of 'interest' (complexity) will slow development to a crawl."
        ))

        q.add(Question(
            id = 111,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "Which of the following software testing methodologies is known as 'Glass Box' or 'White Box' testing?",
            optionA = "Testing software interfaces without any knowledge of internal code or system logic.",
            optionB = "Testing with full visibility and access to the internal source code, logic paths, and structures.",
            optionC = "Beta testing performed directly by end-users in a live production environment.",
            optionD = "Testing done using visual accessibility aids to analyze UI design contrast ratios.",
            correctOption = "B",
            explanationA = "Incorrect: Testing without internal structural knowledge is known as Black Box testing.",
            explanationB = "Correct: White Box (or Glass Box) testing uses knowledge of the program's internal control structures, logic paths, statements, and branches to design test cases.",
            explanationC = "Incorrect: Beta testing is a form of black box acceptance testing.",
            explanationD = "Incorrect: UI contrast and accessibility audits are specialized usability tests, not structural white box tests.",
            explanationCorrect = "White box testing allows developers to verify unit path coverage, ensuring every branch and conditional loop is executed and tested."
        ))

        q.add(Question(
            id = 112,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "What is the primary objective of the 'Refactoring' process in software engineering?",
            optionA = "Adding new user features to an application to meet marketing goals without changing the UI layout.",
            optionB = "Rewriting the entire application in a brand-new programming language to modernize the tech stack.",
            optionC = "Modifying the internal structure of code to make it easier to understand and cheaper to modify without changing its observable behavior.",
            optionD = "Converting functional code to test cases to increase the code coverage metrics automatically.",
            correctOption = "C",
            explanationA = "Incorrect: Refactoring explicitly forbids adding new functional features; it is strictly about modifying existing code structures.",
            explanationB = "Incorrect: Full rewrites are distinct migration projects, whereas refactoring is an incremental cleanup of the current codebase.",
            explanationC = "Correct: Refactoring is a disciplined technique for restructuring existing code, altering its internal structure without changing its external behavior, in order to improve non-functional attributes (readability, complexity, maintainability).",
            explanationD = "Incorrect: Refactoring is not about converting code into tests, but rather cleaning code while existing tests verify that no bugs are introduced.",
            explanationCorrect = "Refactoring improves code health, reduces technical debt, and prepares code to support future feature additions cleanly."
        ))

        q.add(Question(
            id = 113,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "In requirements engineering, what does 'Traceability' refer to?",
            optionA = "The ability to track which developer wrote which line of code using version control systems.",
            optionB = "The capability to associate and follow requirements forward and backward throughout the system lifecycle, from source to implementation.",
            optionC = "Monitoring network packets to locate where data is being sent by the application.",
            optionD = "Calculating the CPU cycle time of various execution threads to locate runtime bottlenecks.",
            correctOption = "B",
            explanationA = "Incorrect: Tracking line authors in git is 'git blame' or revision history, not requirements traceability.",
            explanationB = "Correct: Requirements Traceability is the ability to map requirements to user stories, design specifications, specific source code components, test cases, and deployment configurations.",
            explanationC = "Incorrect: Packet tracing is a network diagnostic process, not requirements engineering.",
            explanationD = "Incorrect: CPU profiling is a performance optimization technique.",
            explanationCorrect = "Traceability ensures that every requirement is actually tested and implemented, and that no unrequested features are built into the system."
        ))

        q.add(Question(
            id = 114,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "Which of the following describes the 'Single Responsibility Principle' (SRP) from SOLID?",
            optionA = "Each software engineer on a team should only work on one isolated user story at a time.",
            optionB = "A class or module should have only one reason to change, meaning it has only one major job or responsibility.",
            optionC = "An application should be deployed on only a single physical hardware server for safety.",
            optionD = "A system should contain exactly one database table to avoid relational complexity.",
            correctOption = "B",
            explanationA = "Incorrect: SRP is a software design rule for code modules, not an agile developer resource management rule.",
            explanationB = "Correct: SRP states that a class should have one, and only one, reason to change. This ensures classes are cohesive and highly focused.",
            explanationC = "Incorrect: This is a deployment architecture issue (single-point-of-failure), unrelated to SRP.",
            explanationD = "Incorrect: Database normalization is separate; SRP applies to OOP design and code structures.",
            explanationCorrect = "By enforcing SRP, you prevent modifications in one aspect of a business rule from accidentally breaking unrelated code elsewhere in the system."
        ))

        q.add(Question(
            id = 115,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = false,
            text = "What is the primary focus of 'System Testing' in the software testing hierarchy?",
            optionA = "Testing individual software methods or classes in absolute isolation using mock objects.",
            optionB = "Evaluating how different standalone sub-systems and integrated packages communicate with one another.",
            optionC = "Verifying the behavior of the complete, fully integrated software product as a whole against the original requirements.",
            optionD = "Letting actual business clients run through the application to sign off on contract payments.",
            correctOption = "C",
            explanationA = "Incorrect: Isolating individual methods is Unit Testing.",
            explanationB = "Incorrect: Verifying integration points between packages is Integration Testing.",
            explanationC = "Correct: System Testing takes place on a fully integrated system. It tests the end-to-end functionality, performance, and compliance against system-level requirements.",
            explanationD = "Incorrect: Final stakeholder sign-offs are part of User Acceptance Testing (UAT).",
            explanationCorrect = "System Testing is a black-box testing phase that validates that all modules work together harmoniously to meet the initial product specification."
        ))

        // 15 Scenario-based Questions
        q.add(Question(
            id = 116,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: You are designing a software control system for an automated radiotherapy cancer treatment device where system failure could cause a fatal radiation overdose. Which software development process model should you adopt?",
            optionA = "Agile Scrum, because it allows the team to deploy features quickly and iterate on patient feedback.",
            optionB = "Extreme Programming (XP), so developers can code in pairs and refactor the interface continuously.",
            optionC = "The Waterfall or V-Model, because of their rigorous documentation, pre-planned verification, and safety validations.",
            optionD = "Rapid Application Development (RAD), because it emphasizes quick prototype builds using visual tools.",
            correctOption = "C",
            explanationA = "Incorrect: Agile Scrum's rapid feedback loops and tolerance of 'failing fast' are highly dangerous for medical hardware where failures are catastrophic.",
            explanationB = "Incorrect: Continuously refactoring without massive, rigid validation cycles can introduce unexpected bugs in hardware controllers.",
            explanationC = "Correct: The V-Model is a highly structured process model that pairs each development phase with a corresponding testing and verification phase. Safety-critical systems require complete, rigorous upfront requirements, extensive validation, and formal sign-offs.",
            explanationD = "Incorrect: RAD focuses on speed and rapid prototyping, skipping formal safety specifications and comprehensive system testing.",
            explanationCorrect = "Safety-critical systems value predictability, safety compliance, and comprehensive verification over development speed and flexible scopes."
        ))

        q.add(Question(
            id = 117,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: A developer is implementing an e-commerce checkout class. They write code that connects to the database to update inventory, calls a third-party PayPal API to charge a card, and formats an email to send to the customer. What structural problem does this code possess?",
            optionA = "Poor execution speed due to API limits.",
            optionB = "Violation of the Single Responsibility Principle, leading to tight coupling and poor testability.",
            optionC = "Failure to implement polymorphism correctly.",
            optionD = "Excessive use of design patterns, over-complicating the simple database updates.",
            correctOption = "B",
            explanationA = "Incorrect: While speed might be an issue, the primary architectural flaw is structural, regarding design and maintenance.",
            explanationB = "Correct: This checkout class has multiple responsibilities: database logic, external payment API connection, and email formatting. It violates SRP. If the email format changes, the database updates could be broken. It should be refactored into separate classes (PaymentService, InventoryRepository, NotificationService).",
            explanationC = "Incorrect: Polymorphism is not required for a simple checkout flow, but SRP and separation of concerns are critical.",
            explanationD = "Incorrect: The developer used no design patterns here; they wrote a single monolithic procedural routine.",
            explanationCorrect = "Separating database logic, API integrations, and notification format rules makes each part independently mockable and unit-testable."
        ))

        q.add(Question(
            id = 118,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: During a sprint, a client requests a 'small modification' to an active feature. The developer immediately implements the change without consulting the product owner or recording it in the backlog. What project management risk has occurred?",
            optionA = "Refactoring debt",
            optionB = "Scope Creep",
            optionC = "Integration conflict",
            optionD = "Daily impediment",
            correctOption = "B",
            explanationA = "Incorrect: Refactoring is done to clean existing code, not to add unauthorized features.",
            explanationB = "Correct: Scope Creep occurs when project features or requirements are added without official approval, estimation, or control, blowing out timelines and budgets.",
            explanationC = "Incorrect: While integration conflicts may happen in code, the organizational/project risk here is scope creep.",
            explanationD = "Incorrect: Impediments are blocks that slow a developer down, not an unauthorized feature implementation.",
            explanationCorrect = "To prevent scope creep, all changes must pass through the Product Owner to be estimated, prioritized, and added to the backlog."
        ))

        q.add(Question(
            id = 119,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: You are building an analytical dashboard. The dashboard needs to pull data from a legacy Database, an XML config file, and a modern JSON Web API, representing them as uniform 'DataPoint' models. Which design pattern solves this?",
            optionA = "Singleton pattern, to restrict access to a single config reader.",
            optionB = "Strategy pattern, to switch between algorithms dynamically.",
            optionC = "Adapter pattern, to convert the incompatible interfaces of different sources into a uniform model.",
            optionD = "Observer pattern, to listen to changes on the dashboard screen directly.",
            correctOption = "C",
            explanationA = "Incorrect: Singleton limits class instantiation but does not resolve data structure incompatibilities.",
            explanationB = "Incorrect: Strategy changes functional algorithms at runtime, rather than bridging incompatible data shapes.",
            explanationC = "Correct: The Adapter pattern allows incompatible interfaces to work together by wrapping their diverse APIs in an adapter that conforms to the expected standard interface.",
            explanationD = "Incorrect: Observer pattern is for state change notifications, not data interface adaptation.",
            explanationCorrect = "Creating adapters for the Legacy DB, XML, and Web API allows the dashboard client to consume all of them via a single interface."
        ))

        q.add(Question(
            id = 120,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: A development team is working on a complex mobile application. They notice that adding a feature in the Payment module frequently breaks code in the Profile module. What is the diagnosis of this system architecture?",
            optionA = "High Cohesion and High Coupling",
            optionB = "Low Cohesion and Low Coupling",
            optionC = "Low Cohesion and High Coupling",
            optionD = "High Cohesion and Low Coupling",
            correctOption = "C",
            explanationA = "Incorrect: High Cohesion is a good design aspect; if they had high cohesion, the responsibilities would be neatly separated and focus-oriented.",
            explanationB = "Incorrect: Low Coupling is a good aspect; if coupling were low, Payment changes wouldn't affect the Profile module.",
            explanationC = "Correct: Low Cohesion means modules are unfocused and perform scattered duties. High Coupling means modules are heavily dependent on each other, meaning changes in one cause a ripple effect of bugs in others.",
            explanationD = "Incorrect: High Cohesion and Low Coupling is the target ideal state where systems do not break collaterally.",
            explanationCorrect = "To fix high coupling and low cohesion, the team needs to separate dependencies using interfaces and refactor shared states."
        ))

        q.add(Question(
            id = 121,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: A team wants to implement an undo-redo history buffer in a graphic editing tool. Every time a user draws a shape, they need to save the state of the canvas so it can be restored. Which design pattern should they use?",
            optionA = "Factory Pattern",
            optionB = "Memento Pattern",
            optionC = "Proxy Pattern",
            optionD = "Decorator Pattern",
            correctOption = "B",
            explanationA = "Incorrect: Factory is a creational pattern for instantiating objects, not for capturing state.",
            explanationB = "Correct: The Memento pattern captures and externalizes an object's internal state without violating encapsulation, so the object can be restored to this state later (ideal for Undo features).",
            explanationC = "Incorrect: Proxy provides a placeholder or surrogate control wrapper for another object.",
            explanationD = "Incorrect: Decorator adds behaviors to objects dynamically, rather than saving historic states.",
            explanationCorrect = "The Memento pattern stores state snapshots in a caretaker history list, allowing a clean restore whenever 'undo' is clicked."
        ))

        q.add(Question(
            id = 122,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: Your team has discovered that a third-party networking library used throughout your codebase has been deprecated. Replacing it will require changing over 150 class files. What design mistake was made?",
            optionA = "Using a third-party library in the first place.",
            optionB = "Failing to abstract the library behind a custom gateway interface or repository, leading to direct tight coupling.",
            optionC = "Not writing enough unit tests to catch the deprecation warning early.",
            optionD = "Choosing an agile methodology that didn't specify third-party deprecation timelines.",
            correctOption = "B",
            explanationA = "Incorrect: Using libraries is normal and efficient; you should not reinvent the wheel for standard features like HTTP clients.",
            explanationB = "Correct: By directly importing and using a third-party library inside your business classes, you tightly couple your system to it. Instead, you should wrap the library behind a custom wrapper interface. If the library changes, only the single wrapper class needs modification.",
            explanationC = "Incorrect: Unit tests verify functional behavior; they cannot prevent static code import coupling issues.",
            explanationD = "Incorrect: Project methodology cannot prevent technical dependency coupling; this is a pure architectural design failure.",
            explanationCorrect = "This is a classic violation of the Dependency Inversion Principle. Always depend on abstractions rather than concrete external frameworks."
        ))

        q.add(Question(
            id = 123,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: An international bank is designing a core transaction processing system. The architect demands that 'all software unit tests must execute in memory with zero external database or network calls'. What is the primary justification for this demand?",
            optionA = "To save cloud execution and data billing costs during developer builds.",
            optionB = "To ensure unit tests remain fast, deterministic, repeatable, and completely isolated from external environment failures.",
            optionC = "Because network operations are insecure and might leak customer transaction data.",
            optionD = "Because database drivers do not support unit testing frameworks.",
            correctOption = "B",
            explanationA = "Incorrect: While cost is a minor factor, developer productivity and testing integrity are the primary engineering drivers.",
            explanationB = "Correct: Unit tests must be fast and reliable. If unit tests rely on a live database or network, they become slow, fragile (failing due to connection blips), and lose isolation. External systems must be mocked.",
            explanationC = "Incorrect: Security is managed in staging/prod; testing isolation is about design correctness, not live leakage.",
            explanationD = "Incorrect: Database drivers work in testing, but integration tests (which use them) are separate from unit tests.",
            explanationCorrect = "Failing to isolate unit tests turns them into slow integration tests, making developers skip running tests frequently."
        ))

        q.add(Question(
            id = 124,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: Your project manager is concerned that developers are writing duplicate code across several screens to format currency strings. Which practice should you suggest to resolve this?",
            optionA = "Tell developers to copy-paste the code but add comments explaining the logic.",
            optionB = "Code Refactoring to extract the formatting logic into a single shared utility module or extension function.",
            optionC = "Implement a database trigger to store pre-formatted currency strings in tables.",
            optionD = "Hire a specialized QA tester to check every screen's currency display accuracy.",
            correctOption = "B",
            explanationA = "Incorrect: Copy-pasting violates the DRY (Don't Repeat Yourself) principle, creating massive maintenance issues.",
            explanationB = "Correct: Extracting duplicate code into a single reusable helper component is a standard refactoring technique that improves maintainability and guarantees format consistency.",
            explanationC = "Incorrect: Formatting is a presentation layer responsibility; forcing the database to store formatted strings violates layered architecture rules.",
            explanationD = "Incorrect: Testers find issues but do not fix structural code duplication. The solution must occur in development.",
            explanationCorrect = "Extracting common formatting to a single utility means if currency rules change, you edit only one file instead of twenty."
        ))

        q.add(Question(
            id = 125,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: A company wants to build a new flight booking system. They decide to adopt 'Test-Driven Development' (TDD). What sequence of activities must their developers follow when building a feature?",
            optionA = "Write code, write automated tests, run tests, deploy.",
            optionB = "Write a failing test, write minimal code to make it pass, refactor the code, and repeat.",
            optionC = "Write UML models, generate code skeleton, write tests, execute tests.",
            optionD = "Run QA tests on legacy system, copy code, fix failed assertions.",
            correctOption = "B",
            explanationA = "Incorrect: This is traditional testing (test-after), not Test-Driven Development (test-first).",
            explanationB = "Correct: TDD follows the 'Red-Green-Refactor' cycle: 1. Write a small test that fails (Red), 2. Write the simplest code to make the test pass (Green), 3. Refactor and clean up the code without breaking behavior.",
            explanationC = "Incorrect: This represents classic waterfall development with automated generation, not TDD loop.",
            explanationD = "Incorrect: This is code migration debugging, completely unrelated to TDD.",
            explanationCorrect = "TDD ensures high test coverage, clean functional interfaces, and forces developers to think through specifications before coding."
        ))

        q.add(Question(
            id = 126,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: You are developing a document editing suite. Users can add comments to text. Some comments are plain text, others have colored text (Markdown), and others have custom links. You want to add features dynamically to comments without modifying the base Comment class. Which pattern fits?",
            optionA = "Proxy Pattern",
            optionB = "Decorator Pattern",
            optionC = "Facade Pattern",
            optionD = "Command Pattern",
            correctOption = "B",
            explanationA = "Incorrect: Proxy controls access to an object, rather than adding styling behaviors dynamically.",
            explanationB = "Correct: The Decorator pattern attaches additional responsibilities to an object dynamically, providing a flexible alternative to subclassing for extending functionality.",
            explanationC = "Incorrect: Facade provides a simplified interface to a large body of class subsystems.",
            explanationD = "Incorrect: Command encapsulates requests as objects to support undoable queues.",
            explanationCorrect = "A Decorator allows you to wrap a base Comment with a MarkdownDecorator or LinkDecorator at runtime based on the comment's content."
        ))

        q.add(Question(
            id = 127,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: In an agile team, the velocity of the developers is dropping over several sprints. In the retrospective, developers complain that a particular class has grown to 5000 lines of code, and editing anything in it requires hours of debugging. What is this file, and what is the fix?",
            optionA = "A 'God Object' that must be broken down into small, cohesive classes conforming to SRP.",
            optionB = "A normal infrastructure client that should be moved to a faster server.",
            optionC = "A database entity that should be normalized using SQL trigger rules.",
            optionD = "An automated test suite that should be split into multiple thread execution channels.",
            correctOption = "A",
            explanationA = "Correct: A class that does too much is known as a 'God Object' or 'Blob' anti-pattern. It violates SRP, has low cohesion, and must be decomposed into smaller, specialized classes that handle single responsibilities.",
            explanationB = "Incorrect: Code design is a compiler and architecture issue, moving servers has zero effect on developer debugging speeds.",
            explanationC = "Incorrect: Normalization fixes database tables; a 5000-line class file is a programming language code issue.",
            explanationD = "Incorrect: The complaint mentions a production class file that is edited, not test files.",
            explanationCorrect = "Decomposing God Objects into modular classes improves comprehensibility, testability, and parallel development capacity."
        ))

        q.add(Question(
            id = 128,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: You are designing a notification center. When an order is placed, you must send an Email, SMS, Slack ping, and Push Notification. Some customers want all, some want only SMS. If you add a new notify channel (e.g. WhatsApp) in the future, you want to do it without changing the checkout class. What design pattern should you apply?",
            optionA = "Abstract Factory Pattern",
            optionB = "Observer Pattern",
            optionC = "Bridge Pattern",
            optionD = "Flyweight Pattern",
            correctOption = "B",
            explanationA = "Incorrect: Abstract Factory is for creating families of related objects, not notifying dependents.",
            explanationB = "Correct: The Observer pattern is perfect here. The checkout is the Subject. Notification channels are Observers. The checkout publishes an 'OrderPlaced' event, and any registered notification observers handle their respective channels.",
            explanationC = "Incorrect: Bridge decouples abstractions from implementations, not for publish-subscribe models.",
            explanationD = "Incorrect: Flyweight is used to share fine-grained object state to reduce memory footprints.",
            explanationCorrect = "Using Observer, you can register a WhatsAppNotification class at runtime without touching a single line of checkout code."
        ))

        q.add(Question(
            id = 129,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: During code review, a senior engineer points out that a subclass overrides a parent class method and throws an 'UnsupportedOperationException' because the subclass doesn't support that parent feature. Which design principle is violated?",
            optionA = "Dependency Inversion Principle (DIP)",
            optionB = "Liskov Substitution Principle (LSP)",
            optionC = "Interface Segregation Principle (ISP)",
            optionD = "Open-Closed Principle (OCP)",
            correctOption = "B",
            explanationA = "Incorrect: DIP says depend on abstractions, not concretions; it is not about inheritance breaking.",
            explanationB = "Correct: LSP is violated. If a subclass cannot substitute its parent class because it throws exceptions for inherited methods, the inheritance structure is incorrect. Subclasses must fulfill the parent's contract.",
            explanationC = "Incorrect: ISP states clients shouldn't be forced to depend on interfaces they don't use. It applies to wide interfaces, not subclass inheritance contracts.",
            explanationD = "Incorrect: OCP states classes should be open for extension but closed for modification. While related, throwing exceptions in sub-classes is a direct violation of substitution.",
            explanationCorrect = "To fix this violation, remove the inheritance relationship and use composition, or segregate the parent class into smaller interfaces."
        ))

        q.add(Question(
            id = 130,
            chapter = 1,
            chapterTitle = "Software Engineering",
            isScenario = true,
            text = "Scenario: A team is building a system that processes payments. The payment gateways are constantly changing based on the country (e.g. Stripe in USA, Adyen in Europe, M-Pesa in Kenya). The payment processing engine should switch the gateway algorithm dynamically at runtime based on the user's IP. Which design pattern matches?",
            optionA = "Template Method Pattern",
            optionB = "Strategy Pattern",
            optionC = "State Pattern",
            optionD = "Command Pattern",
            correctOption = "B",
            explanationA = "Incorrect: Template Method defines steps of an algorithm in a base class, letting subclasses override specific steps, but doesn't swap entire algorithms dynamically.",
            explanationB = "Correct: The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it (perfect for swapping payment gateways).",
            explanationC = "Incorrect: The State pattern changes object behaviors based on its internal state, whereas here the algorithm is chosen based on external config (user country).",
            explanationD = "Incorrect: The Command pattern encapsulates actions as objects but is not meant for switching algorithms dynamically.",
            explanationCorrect = "By wrapping Stripe, Adyen, and M-Pesa in a common 'PaymentStrategy' interface, you can swap them dynamically at runtime."
        ))

        return q
    }
}
