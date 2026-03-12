
# Helldivers API 

This repository contains a simulated PostgreSQL database designed to replicate the kind of backend data structure a game like Helldivers 2 might use. It includes entities such as players, accounts, and helldivers, 
modeling relationships and data typical of a live-service multiplayer game. Built with Spring Boot and Java, this project serves as a learning and experimentation environment for backend development and database design in a gaming context.

# Table of Contents

* [Tech Stack](#tech-stack)
* [Project Structure](#project-structure)
* [Database Modules](#database-modules)
* [UML Diagram](#uml-diagram)

---

# Tech Stack

* **Java 17+**
* **Spring Boot**
* **PostgreSQL**
* **JPA / Hibernate**
* **Maven**

---

# Project Structure

```
helldivers-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.helldivers
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── model
│   │   │       └── config
│   │   └── resources
│   │       ├── application.properties
│   │       └── db
│   │           └── schema.sql
└── pom.xml
```

---

# Database Modules

## Accounts

<img width="1820" height="705" alt="module1" src="https://github.com/user-attachments/assets/4701e279-bb58-4bbd-b776-00333a38d941" />

## Loadouts

<img width="1785" height="504" alt="module2" src="https://github.com/user-attachments/assets/06bb7584-4c03-4369-a76d-defc871aac37" />

## Stratagems

<img width="1793" height="544" alt="module3" src="https://github.com/user-attachments/assets/84a59245-b3de-4595-9d21-1db16f8b6685" />

## Operations & Planets

<img width="1792" height="542" alt="module4" src="https://github.com/user-attachments/assets/9f15e2bd-97aa-4691-b64b-8f14ba8c95d7" />

## Enemies & Warbonds & Progression

<img width="1795" height="849" alt="module56" src="https://github.com/user-attachments/assets/e5a26832-cf20-4f58-befe-cbdfa69ea1d5" />

---

# UML Diagram

<img width="1746" height="927" alt="uml_diagram_helldiver" src="https://github.com/user-attachments/assets/21b9b5cd-bd68-4ceb-b758-b00e2cff91d6" />

---

