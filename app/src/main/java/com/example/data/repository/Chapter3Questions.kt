package com.example.data.repository

import com.example.data.model.Question

object Chapter3Questions {
    fun getQuestions(): List<Question> {
        val q = mutableListOf<Question>()

        // 15 Terminology Questions
        q.add(Question(
            id = 301,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "Which OSI layer is responsible for logical IP addressing, packet routing, and path determination?",
            optionA = "Data Link Layer (Layer 2)",
            optionB = "Network Layer (Layer 3)",
            optionC = "Transport Layer (Layer 4)",
            optionD = "Physical Layer (Layer 1)",
            correctOption = "B",
            explanationA = "Incorrect: Data Link handles physical MAC addressing, framing, and local hop-to-hop delivery.",
            explanationB = "Correct: The Network Layer (Layer 3) handles end-to-end packet routing, logical addressing (IP addresses), and routing protocols.",
            explanationC = "Incorrect: Transport handles port addressing, error-free segmentation, and flow control (TCP/UDP).",
            explanationD = "Incorrect: Physical handles bit-level transmission over copper, fiber, or wireless media.",
            explanationCorrect = "Routers operate at Layer 3 (Network Layer) because they analyze packet IP headers to determine the next path hop."
        ))

        q.add(Question(
            id = 302,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What is the primary difference between TCP (Transmission Control Protocol) and UDP (User Datagram Protocol)?",
            optionA = "TCP is a fast, connectionless protocol; UDP is a slow, connection-oriented protocol.",
            optionB = "TCP guarantees delivery, ordering, and flow control; UDP is connectionless and does not guarantee delivery.",
            optionC = "TCP operates at the Network Layer; UDP operates at the Session Layer.",
            optionD = "TCP uses physical MAC addresses; UDP uses logical IP addresses.",
            correctOption = "B",
            explanationA = "Incorrect: This is reversed. TCP is connection-oriented and slower due to overhead; UDP is connectionless and fast.",
            explanationB = "Correct: TCP establishes a connection via a 3-way handshake and uses sequence numbers, ACKs, and retransmissions to guarantee delivery and order. UDP is a lightweight protocol that sends packets ('fire and forget') without verifying delivery.",
            explanationC = "Incorrect: Both TCP and UDP operate at Layer 4 (Transport Layer).",
            explanationD = "Incorrect: Both TCP and UDP use ports at the Transport Layer; MAC addresses are Layer 2, IP is Layer 3.",
            explanationCorrect = "TCP is ideal for reliable tasks like HTTP and email; UDP is preferred for real-time streaming and gaming."
        ))

        q.add(Question(
            id = 303,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What is the purpose of 'DNS' (Domain Name System) on the Internet?",
            optionA = "To encrypt web traffic between browser clients and servers.",
            optionB = "To dynamically assign IP addresses to device hosts on a local network.",
            optionC = "To translate human-readable domain names (e.g. google.com) into machine-readable IP addresses.",
            optionD = "To block unauthorized incoming network packets as a firewall.",
            correctOption = "C",
            explanationA = "Incorrect: Encrypting traffic is handled by SSL/TLS protocols.",
            explanationB = "Incorrect: Dynamically assigning local IP addresses is the job of DHCP (Dynamic Host Configuration Protocol).",
            explanationC = "Correct: DNS acts as the 'phone book' of the Internet, resolving domain strings into IP addresses so browsers can load internet resources.",
            explanationD = "Incorrect: Packet filtering is done by Firewalls, not DNS.",
            explanationCorrect = "When you visit a URL, your system sends a DNS query to find the server's IP address before initiating a TCP connection."
        ))

        q.add(Question(
            id = 304,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "In public-key cryptography (Asymmetric Encryption), which key is used to encrypt a message, and which is used to decrypt it?",
            optionA = "Encrypt with Private key; Decrypt with Public key.",
            optionB = "Encrypt with Public key; Decrypt with Private key.",
            optionC = "Encrypt with Shared key; Decrypt with Session key.",
            optionD = "Encrypt with MAC key; Decrypt with Router key.",
            correctOption = "B",
            explanationA = "Incorrect: Encrypting with a private key is used for Digital Signatures (verifying identity), not confidential message encryption.",
            explanationB = "Correct: In asymmetric encryption (e.g., RSA), anybody can encrypt a message using the recipient's widely shared Public Key, but only the recipient can decrypt it using their secret, matching Private Key.",
            explanationC = "Incorrect: Shared keys are used in symmetric encryption, where the same key is used for both steps.",
            explanationD = "Incorrect: MAC addresses and routers are network elements, completely unrelated to cryptographic key types.",
            explanationCorrect = "Asymmetric encryption solves the key-distribution problem because the private key never needs to be sent over the network."
        ))

        q.add(Question(
            id = 305,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What is the function of the 'ARP' (Address Resolution Protocol) in a local area network?",
            optionA = "To resolve domain names into IPv4 addresses.",
            optionB = "To map a known logical IP address to a physical MAC hardware address.",
            optionC = "To securely authenticate users trying to connect to a VPN router.",
            optionD = "To split a single physical network into multiple logical subnets.",
            correctOption = "B",
            explanationA = "Incorrect: Resolving domain names is DNS.",
            explanationB = "Correct: Within a local subnet, devices need to package IP packets into Layer 2 Ethernet frames. ARP broadcasts a query ('Who has IP X?') to discover the physical MAC address of the target device.",
            explanationC = "Incorrect: VPN authentication is handled by protocols like IPSec or OpenVPN.",
            explanationD = "Incorrect: Splitting networks into logical subnets is VLAN tagging or subnetting.",
            explanationCorrect = "ARP acts as the bridge between logical Layer 3 (IP addresses) and physical Layer 2 (MAC addresses) on local networks."
        ))

        q.add(Question(
            id = 306,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "Which of the following routing protocols is classified as an 'Exterior Gateway Protocol' (EGP) used to route traffic between Autonomous Systems on the Internet?",
            optionA = "OSPF (Open Shortest Path First)",
            optionB = "RIP (Routing Information Protocol)",
            optionC = "BGP (Border Gateway Protocol)",
            optionD = "EIGRP (Enhanced Interior Gateway Routing Protocol)",
            correctOption = "C",
            explanationA = "Incorrect: OSPF is an Interior Gateway Protocol (IGP) used for link-state routing within a single organization's Autonomous System.",
            explanationB = "Incorrect: RIP is an IGP using distance-vector algorithms within a single local network.",
            explanationC = "Correct: BGP is the Exterior Gateway Protocol that binds the Internet together. It manages routing paths between different Autonomous Systems (AS) operated by ISPs, universities, and corporations.",
            explanationD = "Incorrect: EIGRP is a proprietary IGP hybrid routing protocol owned by Cisco for internal enterprise routing.",
            explanationCorrect = "BGP uses path-vector routing and policy-based controls to handle the scale, security, and routing stability of the global Internet."
        ))

        q.add(Question(
            id = 307,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What is the primary function of a 'TLS/SSL' handshake when initiating an HTTPS connection?",
            optionA = "To allocate local IP addresses to connecting users.",
            optionB = "To authenticate the server, negotiate cryptographic algorithms, and securely establish a symmetric session key.",
            optionC = "To compress web content and image sizes for faster load times.",
            optionD = "To query DNS servers for target database addresses.",
            correctOption = "B",
            explanationA = "Incorrect: IP allocation is handled by DHCP.",
            explanationB = "Correct: The TLS handshake uses asymmetric cryptography to authenticate the server's identity (via SSL certificate) and securely agree on a shared symmetric key, which is then used to encrypt all subsequent communication fast.",
            explanationC = "Incorrect: Web content compression is handled by Gzip/Brotli, not TLS.",
            explanationD = "Incorrect: DNS queries occur before the TCP connection and TLS handshake begin.",
            explanationCorrect = "By using asymmetric encryption only for the handshake, TLS can establish secure symmetric communication without heavy CPU overhead."
        ))

        q.add(Question(
            id = 308,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "In network security, what is a 'Man-in-the-Middle' (MITM) attack?",
            optionA = "A physical attack where an intruder cuts ethernet cables inside a server room.",
            optionB = "An attacker secretly intercepts, relays, and alters communication between two parties who believe they are talking directly.",
            optionC = "flooding a server with fake requests until it crashes.",
            optionD = "An administrator configuring a server with insecure default passwords.",
            correctOption = "B",
            explanationA = "Incorrect: Physical cable cutting is sabotage, not a cryptographic MITM attack.",
            explanationB = "Correct: In a MITM attack, the attacker sits between the client and server (e.g. on an unencrypted public Wi-Fi). By intercepting the connection, they can steal login credentials and session tokens in real-time.",
            explanationC = "Incorrect: Flooding a server to cause a crash is a Distributed Denial of Service (DDoS) attack.",
            explanationD = "Incorrect: Standard credential security misconfiguration is a vulnerability, not an active intercept attack.",
            explanationCorrect = "HTTPS and TLS prevent MITM attacks because they encrypt data and verify the server's identity via cryptographic certificates."
        ))

        q.add(Question(
            id = 309,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What is the main benefit of 'IPv6' compared to the traditional 'IPv4' addressing standard?",
            optionA = "IPv6 packets travel at the speed of light, while IPv4 is limited by copper wire resistance.",
            optionB = "IPv6 provides a vastly larger address space (128-bit) to prevent IP address exhaustion, alongside built-in security and auto-configuration.",
            optionC = "IPv6 does not require routers to transmit packets.",
            optionD = "IPv6 is backward compatible and automatically loads older IPv4 networks without adapters.",
            correctOption = "B",
            explanationA = "Incorrect: IP protocols are logical; they have zero impact on physical electromagnetic propagation speeds.",
            explanationB = "Correct: IPv4 uses 32-bit addresses, allowing only 4.3 billion unique IPs, which are exhausted. IPv6 uses 128-bit addresses (allowing 340 undecillion IPs), eliminating the need for NAT and improving routing efficiency.",
            explanationC = "Incorrect: IPv6 still requires Layer 3 routers to forward packets between different networks.",
            explanationD = "Incorrect: IPv6 is not directly backward compatible; bridging requires transition mechanisms like dual-stacking, tunneling, or NAT64.",
            explanationCorrect = "IPv6's massive address space ensures that every IoT device, phone, and computer on earth can have a unique, globally routable IP."
        ))

        q.add(Question(
            id = 310,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What does 'Three-Way Handshake' in TCP accomplish?",
            optionA = "It authenticates the user's password, username, and biometric keys.",
            optionB = "It establishes a reliable virtual connection by synchronizing Sequence Numbers (SYN) and Acknowledgment Numbers (ACK) between client and server.",
            optionC = "It routes packets across three physical routers simultaneously to balance loads.",
            optionD = "It compresses data streams across three separate compression channels.",
            correctOption = "B",
            explanationA = "Incorrect: TCP handles byte transport; application-level authentication (passwords) is done at Layer 7.",
            explanationB = "Correct: The TCP handshake steps are: 1. Client sends SYN (Synchronize), 2. Server replies with SYN-ACK (Synchronize-Acknowledge), 3. Client replies with ACK (Acknowledge). This establishes session sequence tracking.",
            explanationC = "Incorrect: TCP does not manage network-layer routing pathways or load balancing.",
            explanationD = "Incorrect: TCP does not perform data compression; it is purely a byte delivery protocol.",
            explanationCorrect = "The 3-way handshake ensures that both hosts are active, ready to receive data, and have synchronized their sequence counters."
        ))

        q.add(Question(
            id = 311,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "In network routing, what is 'CIDR' (Classless Inter-Domain Routing)?",
            optionA = "A secure encryption standard for local routing tables.",
            optionB = "An addressing scheme that replaces rigid Class A, B, and C networks with flexible variable-length subnet masks.",
            optionC = "A wireless network transmission protocol.",
            optionD = "A backup system for DNS lookup zones.",
            correctOption = "B",
            explanationA = "Incorrect: CIDR is a routing allocation standard, not an encryption framework.",
            explanationB = "Correct: CIDR allows network administrators to allocate IP addresses with arbitrary subnet mask lengths (e.g., /22, /26) instead of being locked into inflexible 8, 16, or 24-bit class boundaries. This dramatically reduces IP address waste.",
            explanationC = "Incorrect: CIDR is a logical IP network definition, not a physical layer wireless protocol.",
            explanationD = "Incorrect: CIDR belongs to Layer 3 IP addressing, unrelated to DNS lookup infrastructure.",
            explanationCorrect = "CIDR uses slash notation (e.g., 192.168.1.0/24) to denote the number of fixed network bits, simplifying IP allocation."
        ))

        q.add(Question(
            id = 312,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What is the primary objective of 'NAT' (Network Address Translation)?",
            optionA = "To encrypt web packets traveling through public ISP networks.",
            optionB = "To map multiple private local IP addresses to a single public IP address, conserving public IPv4 addresses.",
            optionC = "To automatically speed up DNS domain lookups.",
            optionD = "To distribute network traffic across multiple load-balanced web servers.",
            correctOption = "B",
            explanationA = "Incorrect: Encryption is handled by IPsec or TLS, not NAT.",
            explanationB = "Correct: NAT allows a home or business router to present thousands of internal devices (e.g., using private 192.168.x.x IPs) to the internet under a single public IP address, masking the internal structure and saving public IPv4 addresses.",
            explanationC = "Incorrect: NAT has no role in DNS name resolution.",
            explanationD = "Incorrect: Traffic distribution is managed by load balancers and reverse proxies, not NAT routers.",
            explanationCorrect = "While NAT helped delay IPv4 exhaustion, it breaks the end-to-end peer-to-end model of the internet, which is restored by IPv6."
        ))

        q.add(Question(
            id = 313,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "What is the role of a 'Digital Certificate' in web security?",
            optionA = "An online diploma confirming a developer passed secure coding tests.",
            optionB = "A cryptographic file issued by a trusted Certificate Authority (CA) that binds a public key to an organization's identity.",
            optionC = "An administrative system that blocks spam emails.",
            optionD = "A network key used to access encrypted enterprise Wi-Fi networks.",
            correctOption = "B",
            explanationA = "Incorrect: Digital certificates are technical identity proofs, not human educational credentials.",
            explanationB = "Correct: When you connect to HTTPS, the server sends its digital certificate. Your browser verifies this certificate against pre-installed trusted root certificates to confirm that google.com is indeed owned by Google, preventing spoofing.",
            explanationC = "Incorrect: Spam filtering is handled by email exchange protocols and filters.",
            explanationD = "Incorrect: Wi-Fi passwords are pre-shared keys (WPA2-PSK) or RADIUS authenticators.",
            explanationCorrect = "Digital certificates form the foundation of the web's Public Key Infrastructure (PKI), ensuring trust on the Internet."
        ))

        q.add(Question(
            id = 314,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "Which TCP/IP protocol is used to automatically assign IP addresses, subnet masks, default gateways, and DNS servers to local devices?",
            optionA = "DHCP (Dynamic Host Configuration Protocol)",
            optionB = "ICMP (Internet Control Message Protocol)",
            optionC = "SNMP (Simple Network Management Protocol)",
            optionD = "SMTP (Simple Mail Transfer Protocol)",
            correctOption = "A",
            explanationA = "Correct: DHCP automates network setup. When a device joins a network, it requests configuration from a DHCP server, which leases it an IP, gateway, and DNS info automatically.",
            explanationB = "Incorrect: ICMP is used for network diagnostics and error messages (e.g. Ping, Traceroute), not configuration.",
            explanationC = "Incorrect: SNMP is used by network administrators to monitor and manage network devices, not configure device IP pools.",
            explanationD = "Incorrect: SMTP is used for sending emails, not network addressing.",
            explanationCorrect = "DHCP eliminates the need for manual, error-prone static IP configurations on end-user devices."
        ))

        q.add(Question(
            id = 315,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = false,
            text = "In network security, what is a 'Firewall'?",
            optionA = "A physical concrete wall built to protect server rooms from structural fires.",
            optionB = "A security device or software that monitors and filters incoming and outgoing network traffic based on established security rules.",
            optionC = "A database cache designed to protect tables from SQL injection.",
            optionD = "An automated script that updates operating system security patches.",
            correctOption = "B",
            explanationA = "Incorrect: While the term is borrowed from physical firewalls, in IT it is a logical network security system.",
            explanationB = "Correct: Firewalls act as barriers. They inspect packet headers and payloads against defined ACLs (Access Control Lists) or stateful rules, blocking unauthorized ports and malicious traffic.",
            explanationC = "Incorrect: Web Application Firewalls (WAF) can block web exploits, but general firewalls filter network ports, not database injections directly.",
            explanationD = "Incorrect: Patch management is an OS administrative tool, not a firewall.",
            explanationCorrect = "Firewalls can be packet-filtering (stateless), stateful (tracking active connections), or Next-Generation (analyzing application-layer traffic)."
        ))

        // 15 Scenario-based Questions
        q.add(Question(
            id = 316,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: An IT manager is assigned an IP block of 192.168.1.0/24. They need to divide this network into 4 separate logical departments (HR, Sales, IT, Admin) of equal size. What subnet mask should they use, and how many usable host IPs will each department have?",
            optionA = "Mask: 255.255.255.0 (/24); 254 hosts per subnet.",
            optionB = "Mask: 255.255.255.192 (/26); 62 usable hosts per subnet.",
            optionC = "Mask: 255.255.255.240 (/28); 14 usable hosts per subnet.",
            optionD = "Mask: 255.255.255.128 (/25); 126 usable hosts per subnet.",
            correctOption = "B",
            explanationA = "Incorrect: A /24 mask represents a single network of 254 hosts; it does not split the network into 4 departments.",
            explanationB = "Correct: A /24 network has 256 total IP addresses. Splitting it into 4 equal subnets means each subnet gets 256/4 = 64 IPs. Since 2^6 = 64, we need 6 host bits, leaving 32-6 = 26 network bits. A /26 subnet mask is 255.255.255.192. Each subnet has 64 total IPs, minus 2 (network address and broadcast address), giving 62 usable host IPs.",
            explanationC = "Incorrect: A /28 mask splits the network into 16 subnets of 14 usable hosts, which is too small.",
            explanationD = "Incorrect: A /25 mask splits the network into 2 subnets of 126 usable hosts, not 4 departments.",
            explanationCorrect = "To split a network into 4 equal subnets, borrow 2 bits from the host portion, increasing the CIDR mask by 2 (from /24 to /26)."
        ))

        q.add(Question(
            id = 317,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: You are designing a fast-paced multiplayer online shooting game. Game state updates (player positions, shooting actions) must be transmitted to players in real-time. If a packet is lost, it is better to skip it than delay gameplay with retransmissions. Which Transport protocol is best?",
            optionA = "TCP, because guaranteed packet delivery is critical to prevent game hacking.",
            optionB = "UDP, because low-latency transmission is prioritized and stale updates are discarded.",
            optionC = "HTTP/HTTPS, to leverage web caching for fast rendering.",
            optionD = "ICMP, because ping requests measure latency perfectly.",
            correctOption = "B",
            explanationA = "Incorrect: TCP's overhead (retrying lost packets) causes 'lag spikes'. By the time a lost coordinate is resent, the player has already moved, making the packet useless.",
            explanationB = "Correct: UDP has zero connection handshake and zero retransmission rules. It sends position packets instantly. If one is lost, the next packet (sent 30ms later) will refresh the coordinates anyway, keeping the game smooth and low-latency.",
            explanationC = "Incorrect: HTTP is built on top of TCP and is text-oriented, introducing massive latency overhead.",
            explanationD = "Incorrect: ICMP is a control protocol used for ping and traceroute diagnostics; it cannot transport custom game data payloads.",
            explanationCorrect = "Real-time games use UDP for game state coordinates, and might use TCP separately for reliable operations like log-ins and purchases."
        ))

        q.add(Question(
            id = 318,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: A user connects to their bank's website. They notice that the browser URL bar displays HTTP instead of HTTPS, and a warning pops up saying the certificate has expired. They proceed anyway. A hacker on the same public coffee-shop Wi-Fi intercepts their login credentials. What type of attack has occurred?",
            optionA = "SQL Injection",
            optionB = "Man-in-the-Middle (MITM) Sniffing",
            optionC = "DDoS overload",
            optionD = "Cross-Site Scripting (XSS)",
            correctOption = "B",
            explanationA = "Incorrect: SQL injection exploits input boxes on websites to run database queries; it does not intercept network packets.",
            explanationB = "Correct: Since HTTP is unencrypted, all packets travel in plain text over the air. An attacker running packet sniffing software on the same Wi-Fi can easily intercept the HTTP request headers and read the username and password in cleartext.",
            explanationC = "Incorrect: DDoS attempts to crash a server, not read private transaction credentials.",
            explanationD = "Incorrect: XSS injects malicious scripts into web pages viewed by other users, not sniffing local Wi-Fi packets directly.",
            explanationCorrect = "Never transmit sensitive data over unencrypted HTTP. HTTPS encrypts packets, rendering sniffed Wi-Fi data unreadable."
        ))

        q.add(Question(
            id = 319,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: Your company's web server in London suddenly crashes because it is flooded with 5 million concurrent requests originating from compromised smart-refrigerators, cameras, and IoT devices located worldwide. What is this attack?",
            optionA = "Phishing campaign",
            optionB = "Distributed Denial of Service (DDoS) via a Botnet",
            optionC = "Symmetric key sniffing",
            optionD = "Buffer Overflow attack",
            correctOption = "B",
            explanationA = "Incorrect: Phishing uses social engineering emails to trick users into entering credentials, not network floods.",
            explanationB = "Correct: A DDoS attack uses a network of infected devices (a 'Botnet') scattered globally to flood a target server with garbage traffic, saturating its bandwidth or CPU, causing it to crash and deny service to real users.",
            explanationC = "Incorrect: Key sniffing intercepts cryptographic handshakes, it does not flood servers.",
            explanationD = "Incorrect: Buffer overflow is a memory exploit in programming languages, not a global network flood.",
            explanationCorrect = "DDoS attacks are mitigated using traffic scrubbing networks, rate-limiting, and web application firewalls (like Cloudflare)."
        ))

        q.add(Question(
            id = 320,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: You type 'facebook.com' into your browser. Your local computer has never connected to this site before. Trace the exact sequence of systems your computer queries to load the server IP.",
            optionA = "Browser Cache -> Local Router ARP table -> Gateway Firewall.",
            optionB = "Local Hosts File -> Local DNS Cache -> Recursive Resolver -> Root Server -> TLD Server -> Authoritative Name Server.",
            optionC = "Gateway DHCP -> TCP handshake -> ISP routing table.",
            optionD = "Google.com search engine -> VPN tunnel -> BGP router.",
            correctOption = "B",
            explanationA = "Incorrect: ARP resolves MAC addresses, not domain names; firewalls filter but do not resolve IPs.",
            explanationB = "Correct: First, the system checks local static hosts and local DNS cache. If not found, it queries the Recursive DNS Resolver (usually ISP or 1.1.1.1). The resolver queries the Root Server (.), which points to the .com TLD Server. The TLD server points to Facebook's Authoritative Name Server, which finally returns the specific IP.",
            explanationC = "Incorrect: DHCP assigns local IPs, and TCP handshakes require an IP to already be resolved.",
            explanationD = "Incorrect: Search engines are for indexing web pages; domain name resolution occurs purely at the DNS protocol layer.",
            explanationCorrect = "DNS resolution is a hierarchical recursive process that translates domain names into routable IP addresses."
        ))

        q.add(Question(
            id = 321,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: You connect your laptop to an Ethernet port in a corporate office. Immediately, your laptop gets the IP address 10.15.42.109, a default gateway of 10.15.42.1, and DNS server 8.8.8.8. Which protocol made this automatic configuration possible?",
            optionA = "DNS",
            optionB = "DHCP",
            optionC = "ARP",
            optionD = "BGP",
            correctOption = "B",
            explanationA = "Incorrect: DNS resolves domain names to IPs but does not configure a device's local network settings.",
            explanationB = "Correct: The Dynamic Host Configuration Protocol (DHCP) automatically assigns IP configuration parameters to devices connecting to a network, eliminating manual setup.",
            explanationC = "Incorrect: ARP discovers MAC addresses of local IPs, it does not assign IP addresses to hosts.",
            explanationD = "Incorrect: BGP routes traffic between autonomous internet systems, it does not configure local ethernet devices.",
            explanationCorrect = "DHCP servers lease IP configurations from a defined pool, ensuring no duplicate IPs are assigned to the same local subnet."
        ))

        q.add(Question(
            id = 322,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: A network engineer is trying to diagnose why users in Europe are experiencing slow loading times for an image-heavy website hosted on a server in New York. The network bandwidth is high. What is the diagnosis, and what is the best technical solution?",
            optionA = "Low bandwidth; increase the ethernet line size in NY.",
            optionB = "High propagation latency due to physical distance; implement a Content Delivery Network (CDN) to cache images in European edge servers.",
            optionC = "The European browsers are incompatible; force users to update Chrome.",
            optionD = "The DNS server is slow; migrate from BGP to OSPF.",
            correctOption = "B",
            explanationA = "Incorrect: If bandwidth is high, the issue is not data carrying capacity; it is speed of light round-trip latency.",
            explanationB = "Correct: Light taking time to travel back and forth across the Atlantic introduces round-trip delay. By using a CDN, static assets like images are stored in edge servers close to the users in Europe, reducing the round-trip distance to milliseconds.",
            explanationC = "Incorrect: Image rendering is standard; distance latency affects all modern browsers equally.",
            explanationD = "Incorrect: OSPF is an internal routing protocol; you cannot route traffic across the Atlantic using OSPF.",
            explanationCorrect = "CDNs bypass geographic distance limits by caching static files close to the target consumers."
        ))

        q.add(Question(
            id = 323,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: A system administrator wants to protect their internal corporate servers from external internet hackers. They set up a system that inspects all incoming packet headers and blocks any packets sent to ports other than 80 (HTTP) and 443 (HTTPS). What did they configure?",
            optionA = "A Virtual Private Network (VPN)",
            optionB = "A Packet-Filtering Firewall",
            optionC = "A DHCP IP pool",
            optionD = "A symmetric encryption key",
            correctOption = "B",
            explanationA = "Incorrect: VPNs establish secure, encrypted tunnels for remote access; they do not filter public ports.",
            explanationB = "Correct: A packet-filtering firewall inspects packets at the network and transport layers. It checks source/destination IPs and ports against Access Control Lists (ACLs), dropping unauthorized packets.",
            explanationC = "Incorrect: DHCP assigns local IP configurations, unrelated to security firewalls.",
            explanationD = "Incorrect: Symmetric encryption locks data payloads, it does not control network port access.",
            explanationCorrect = "Packet filtering is a fast, cost-effective first line of network defense, though it does not inspect packet payloads."
        ))

        q.add(Question(
            id = 324,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: An enterprise network is constantly dropping packets. The engineer suspects there is a routing loop where routers are passing a packet back and forth infinitely. Which field in the IP header will eventually prevent this packet from traveling forever?",
            optionA = "Source IP Address",
            optionB = "Time to Live (TTL)",
            optionC = "Header Checksum",
            optionD = "Window Size",
            correctOption = "B",
            explanationA = "Incorrect: Source IP identifies the sender; it is not altered by routers to stop loops.",
            explanationB = "Correct: The TTL field is an 8-bit counter in the IP header. Every router that forwards a packet decrements this value by 1. If TTL reaches 0, the router discards the packet and sends an ICMP 'Time Exceeded' message to the sender, preventing infinite loops.",
            explanationC = "Incorrect: The Checksum detects packet corruption; it does not count hops or stop routing loops.",
            explanationD = "Incorrect: Window Size is a TCP field used for flow control, not an IP routing field.",
            explanationCorrect = "In IPv4, this is called TTL (Time to Live). In IPv6, it has been renamed to 'Hop Limit' to accurately reflect its function."
        ))

        q.add(Question(
            id = 325,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: A bank wants to send a sensitive transaction file to a tax office. They need to ensure two things: 1. The tax office can verify that the file actually came from the bank (Authenticity), and 2. The file was not altered in transit (Integrity). What should the bank attach to the file?",
            optionA = "An unencrypted backup copy of the file.",
            optionB = "A Digital Signature, created by hashing the file and encrypting the hash with the bank's Private Key.",
            optionC = "A symmetric AES key shared over a public Slack channel.",
            optionD = "The MAC address of the bank's gateway router.",
            correctOption = "B",
            explanationA = "Incorrect: Sending unencrypted backups is insecure and does not verify authenticity or integrity.",
            explanationB = "Correct: A digital signature provides both authenticity and integrity. The recipient decrypts the signature using the bank's public key (proving authenticity), hashes the file independently, and compares the hashes. If they match, integrity is proven.",
            explanationC = "Incorrect: Sharing keys over public networks is a critical security breach; symmetric keys do not verify non-repudiation.",
            explanationD = "Incorrect: MAC addresses can be easily spoofed and do not provide cryptographic integrity or proof of origin.",
            explanationCorrect = "Digital signatures utilize asymmetric keypairs to guarantee authenticity, integrity, and non-repudiation."
        ))

        q.add(Question(
            id = 326,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: A user is connected to a public Wi-Fi network and types 'http://mybank.com'. They are suddenly redirected to a page that looks identical to their bank, but has a slightly different domain 'http://mybank-login.com'. They log in, and their account is cleaned out. What happened?",
            optionA = "DNS Spoofing / Cache Poisoning",
            optionB = "DDoS attack",
            optionC = "Port scanning",
            optionD = "Symmetric key decay",
            correctOption = "A",
            explanationA = "Correct: In DNS spoofing or cache poisoning, an attacker injects false IP mappings into a DNS cache (or manipulates local DNS settings). When the user requests the bank's site, they are resolved to the attacker's server IP.",
            explanationB = "Incorrect: DDoS crashes servers; it does not host phishing clones or spoof DNS entries.",
            explanationC = "Incorrect: Port scanning is a network exploration technique to find open ports, not a user redirect exploit.",
            explanationD = "Incorrect: Keys do not 'decay' over time; this is a pure DNS spoofing and phishing attack.",
            explanationCorrect = "DNSSEC (DNS Security Extensions) helps protect against DNS spoofing by cryptographically signing DNS records."
        ))

        q.add(Question(
            id = 327,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: A company wants to connect its NY office network to its Tokyo office network securely over the public Internet. They want employees in both offices to communicate as if they were on a single secure private local network. What technology should they implement?",
            optionA = "A public DNS recursive resolver",
            optionB = "A Site-to-Site VPN (Virtual Private Network) tunnel using IPsec",
            optionC = "A classful BGP router array",
            optionD = "A DHCP server spanning the Atlantic",
            correctOption = "B",
            explanationA = "Incorrect: DNS recursive resolvers handle name lookup; they cannot securely bridge office network packets.",
            explanationB = "Correct: A Site-to-Site VPN connects the entire network in one location to the network in another. IPsec encrypts all traffic at the IP layer before sending it over the public Internet, ensuring absolute privacy.",
            explanationC = "Incorrect: BGP routes packets between ISPs; it does not encrypt or establish private internal corporate bridges.",
            explanationD = "Incorrect: DHCP is a local protocol; you cannot lease IPs across the ocean over broadcast packets safely.",
            explanationCorrect = "VPNs use encryption and tunneling protocols to build secure logical networks over insecure physical public infrastructure."
        ))

        q.add(Question(
            id = 328,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: A web browser sends an HTTP request to load an image. The TCP packet arrives, but one of the data segments is corrupted. How does TCP handle this at the receiver side?",
            optionA = "The receiver ignores the corruption and loads the pixelated image.",
            optionB = "The receiver calculates the checksum, detects the error, discards the packet, and does not send an ACK for that segment, forcing the sender to retransmit (sliding window timeout).",
            optionC = "The receiver requests the DNS server to change the IP path.",
            optionD = "The receiver crashes the browser with a blue screen.",
            correctOption = "B",
            explanationA = "Incorrect: UDP might ignore packet drops, but TCP is a strict reliable protocol that never permits corrupted bytes to reach the application.",
            explanationB = "Correct: TCP headers contain a Checksum field. If the checksum fails at the receiver, the segment is thrown away. Since TCP uses a sliding window, the sender realizes the ACK for that sequence number was never received and retransmits.",
            explanationC = "Incorrect: DNS handles name mapping; it has zero involvement in real-time TCP segment error recovery.",
            explanationD = "Incorrect: Segment drops are normal network occurrences; TCP handles them silently without crashing the OS.",
            explanationCorrect = "TCP's reliance on sequence tracking, timeouts, and checksums guarantees that a file is downloaded bit-perfect."
        ))

        q.add(Question(
            id = 329,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: Your network router is overwhelmed with incoming packets. It cannot process them fast enough, and its internal buffer queue overflows. What does the router do, and which protocol will notify the sender about the congestion?",
            optionA = "The router compresses the packets; DHCP notifies the sender.",
            optionB = "The router drops the excess packets; ICMP (Internet Control Message Protocol) sends a 'Source Quench' or TCP congestion control reduces the window size.",
            optionC = "The router sends packets backwards; ARP tracks the route.",
            optionD = "The router halts all local network computers.",
            correctOption = "B",
            explanationA = "Incorrect: Routers do not compress transit packets; DHCP has no role in congestion control or notifications.",
            explanationB = "Correct: When a router's queue overflows, it must discard packets (this is known as congestion tail-drop). ICMP or TCP congestion windows will detect this loss, prompting the sender to slow down their transmission rate.",
            explanationC = "Incorrect: Routers discard overflow packets; they do not reverse routing pathways.",
            explanationD = "Incorrect: Routers are standalone network nodes; they cannot turn off or freeze end-user laptops directly.",
            explanationCorrect = "Congestion control algorithms (like TCP Slow Start and Congestion Avoidance) actively adjust packet output rates to prevent network collapse."
        ))

        q.add(Question(
            id = 330,
            chapter = 3,
            chapterTitle = "Computer Networks",
            isScenario = true,
            text = "Scenario: You want to deploy an e-commerce API. You need to protect your payment database from SQL injection, cross-site scripting (XSS), and automated bot scraping, but your network firewall only filters ports 80 and 443. What security layer should you add?",
            optionA = "A DHCP relay agent",
            optionB = "A Web Application Firewall (WAF)",
            optionC = "An IPv6 routing table",
            optionD = "A symmetric AES block cipher",
            correctOption = "B",
            explanationA = "Incorrect: DHCP relay agents forward IP allocation requests; they provide zero application security filtering.",
            explanationB = "Correct: A WAF operates at Layer 7 (Application Layer). It analyzes HTTP payloads, looking for patterns like `' OR '1'='1` (SQL injection) or `<script>` tags (XSS), blocking malicious web requests before they hit your API server.",
            explanationC = "Incorrect: IPv6 routing tables merely forward packets; they cannot inspect HTTP web payloads for exploits.",
            explanationD = "Incorrect: Ciphers encrypt data to prevent sniffing, but they cannot block active SQL injection strings sent by authorized HTTPS clients.",
            explanationCorrect = "WAFs protect web APIs by acting as application-layer proxies that filter and block malicious web payloads."
        ))

        return q
    }
}
