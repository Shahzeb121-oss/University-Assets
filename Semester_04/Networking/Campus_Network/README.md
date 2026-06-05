1| # 🖧 Campus Network Project – IT & VC Office
2| 
3| ## 📌 Overview
4| This project represents the Campus Network Infrastructure connecting multiple departments, labs, and offices.  
5| The design uses routers, switches, servers, and end devices with proper IP addressing and segmentation.
6| 
7| ---
8| 
9| ## 👥 Author
10| Muhammad Shahzaib
11| 
12| ---
13| 
14| ## 🏢 Departments & Network Blocks
15| 
16| ### MMG Department (192.168.1.0/24)
17| - Devices: PCs (PC4–PC10), Laptop  
18| - Switch: Switch7  
19| - Gateway: 192.168.1.1  
20| 
21| ### AI Department (192.168.2.0/24)
22| - Devices: IT LAB PCs (1–4), Printer, Cabin PC  
23| - Switch: Switch6  
24| - Gateway: 192.168.2.1  
25| 
26| ### Computer Science Department (192.168.3.0/24)
27| - Devices: CS LAB PCs (1–4), Cabin PC  
28| - Switch: Switch4  
29| - Gateway: 192.168.3.1  
30| 
31| ### PG Lab (192.168.4.0/24)
32| - Devices: PCs (PC1–PC5), Printers  
33| - Switch: Switch5  
34| - Gateway: 192.168.4.1  
35| 
36| ### Other Offices (192.168.5.0/24)
37| - Devices: Office PC, Exam Cell PC, Engineering PC, Printers  
38| - Switch: Switch3  
39| - Gateway: 192.168.5.1  
40| 
41| ### Server Room (192.168.1.10/24)
42| - FTP Server: 192.168.1.5  
43| - Web Server: 192.168.1.4  
44| - DHCP Server: 192.168.1.6  
45| - DNS Server: 192.168.1.7  
46| - Switch: Switch1  
47| - Gateway: 192.168.1.1  
48| 
49| ### VC Office (192.168.6.0/24)
50| - Devices: PCs, Laptop  
51| - Switch: Switch8 (with firewall rules)  
52| - Gateway: 192.168.6.1  
53| 
54| #### Firewall Rules
55| - Block communication between VC Office (192.168.6.0/24) and Block C (192.168.3.0/24).  
56| - Block communication between VC Office (192.168.6.0/24) and Block D (192.168.4.0/24).  
57| - Allow communication with other departments and external router.
58| 
59| ---
60| 
61| ## 🌐 Routers
62| - Router1 (Cisco 2911): Internal routing – IP 201.151.11.10  
63| - Router2 (Cisco 1941): External connectivity – IP 201.151.12.0  
64| 