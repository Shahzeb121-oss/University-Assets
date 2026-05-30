# 🖧 Campus Network Project – IT & VC Office

## 📌 Overview
This project represents the Campus Network Infrastructure connecting multiple departments, labs, and offices.  
The design uses routers, switches, servers, and end devices with proper IP addressing and segmentation.

---

## 👥 Group Members
1. Muhammad Shahzaib  
2. Ali Usama
3. Musawir Saddique  
4. Salar Ahmed

---

## 🏢 Departments & Network Blocks

### MMG Department (192.168.1.0/24)
- Devices: PCs (PC4–PC10), Laptop  
- Switch: Switch7  
- Gateway: 192.168.1.1  

### AI Department (192.168.2.0/24)
- Devices: IT LAB PCs (1–4), Printer, Cabin PC  
- Switch: Switch6  
- Gateway: 192.168.2.1  

### Computer Science Department (192.168.3.0/24)
- Devices: CS LAB PCs (1–4), Cabin PC  
- Switch: Switch4  
- Gateway: 192.168.3.1  

### PG Lab (192.168.4.0/24)
- Devices: PCs (PC1–PC5), Printers  
- Switch: Switch5  
- Gateway: 192.168.4.1  

### Other Offices (192.168.5.0/24)
- Devices: Office PC, Exam Cell PC, Engineering PC, Printers  
- Switch: Switch3  
- Gateway: 192.168.5.1  

### Server Room (192.168.1.10/24)
- FTP Server: 192.168.1.5  
- Web Server: 192.168.1.4  
- DHCP Server: 192.168.1.6  
- DNS Server: 192.168.1.7  
- Switch: Switch1  
- Gateway: 192.168.1.1  

### VC Office (192.168.6.0/24)
- Devices: PCs, Laptop  
- Switch: Switch8 (with firewall rules)  
- Gateway: 192.168.6.1  

#### Firewall Rules
- Block communication between VC Office (192.168.6.0/24) and Block C (192.168.3.0/24).  
- Block communication between VC Office (192.168.6.0/24) and Block D (192.168.4.0/24).  
- Allow communication with other departments and external router.

---

## 🌐 Routers
- Router1 (Cisco 2911): Internal routing – IP 201.151.11.10  
- Router2 (Cisco 1941): External connectivity – IP 201.151.12.0  
