
# Helldivers API 

Simulated PostgreSQL database and REST API built with Spring Boot, modelling the backend of a multiplayer game like Helldivers 2 — players, accounts, helldivers, missions, stratagems and more. Built as a learning project for backend development and database design.

> 🚧 **Work in progress**: This project is currently under active development. Endpoints, data models and features may change at any time. New functionality will be added progressively.

## Requirements
 
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running
- Git

## Seed Data
 
On first startup the database is automatically initialized with the following test data:
 
- 14 user accounts (bcrypt hashed passwords)
- 13 helldivers with stats
- 10 planets across different factions
- 11 stratagems (Eagle, Orbital, Support, Sentry...)
- 10 weapons (primary, secondary, grenades, support)
- 10 missions with objectives and stats
- Ship upgrades, loadouts, squads and more
 
---
 
## Getting Started
 
### 1. Clone the repository
 
```bash
git clone https://github.com/adriguerre/HelldiversJava.git
cd .\HelldiversJava\
```
 
### 2. Run the project
 
```bash
docker compose up --build
```
 
This will automatically:
 
1. Build the Spring Boot application image
2. Start PostgreSQL and initialize it with the schema and seed data (`docker/init/init.sql`)
3. Start the application once the database is ready
 
The API will be available at: **`http://localhost:8080/helldivers/api/v1`**
 
---
 
## Stopping the project
 
```bash
# Stop containers but keep the data
docker compose down
 
# Stop containers and wipe the database (fresh start on next up)
docker compose down -v
```
 
---

# Table of Contents

* [Tech Stack](#tech-stack)
* [Database Modules](#database-modules)
* [UML Diagram](#uml-diagram)

---

# Tech Stack

* **Java 21**
* **Spring Boot**
* **PostgreSQL**
* **JPA / Hibernate**
* **Maven**
* **Docker**

## Local Development (without Docker)
 
If you want to run the application directly from the IDE without Docker, you need a local PostgreSQL instance running. In this mode Hibernate manages the schema automatically (`ddl-auto=update`), so the database is created and updated on startup — no manual steps needed.
 
Under normal circumstances the project connects to a real external database. However, for the purpose of showcasing the full behaviour of the API, a snapshot of the database at a specific point in time has been included in the repository (`docker/init/init.sql`). This allows anyone to run the project locally with realistic data without needing access to the original database.
 
---
 
## Security
 
The API has **JWT (JSON Web Tokens)** authentication fully implemented. When active, all protected endpoints require a valid token in every request header:
 
```
Authorization: Bearer <token>
```
 
> ⚠️ **Test mode**: JWT security is currently disabled to allow full visibility of the API behaviour during testing and demonstration. This means endpoints that would otherwise be restricted — such as account data — are publicly accessible. Re-enabling Spring Security would immediately restrict access to those endpoints again.
 
---

# Database Modules

> 🚧 **Subject to change**

## Accounts

<img width="1857" height="357" alt="hd_module1" src="https://github.com/user-attachments/assets/220cfc85-b14f-42bf-9083-7a5743dcd149" />
<img width="1217" height="142" alt="hd_module1 2" src="https://github.com/user-attachments/assets/ccb89419-fb27-43b7-ae1f-fa9a6e8fc353" />

## Loadouts

<img width="1830" height="310" alt="hd_module2" src="https://github.com/user-attachments/assets/0c0708bf-92be-44ad-9ab5-ba074d2bd6a4" />

## Stratagems

<img width="1842" height="656" alt="hd_module3" src="https://github.com/user-attachments/assets/45b18548-f31e-491a-88b2-579c0ec5e045" />


## Operations & Planets

<img width="1830" height="328" alt="hd_module4" src="https://github.com/user-attachments/assets/6bf4a49f-b86b-49d0-8efa-4f62c029511f" />

## Enemies & Warbonds & Progression

<img width="1795" height="849" alt="module56" src="https://github.com/user-attachments/assets/e5a26832-cf20-4f58-befe-cbdfa69ea1d5" />

---

# UML Diagram

<img width="1102" height="909" alt="hd_module_uml" src="https://github.com/user-attachments/assets/a745cdc7-54ec-44bc-8e9f-a86413f89f03" />

---
 
## API Endpoints

> All query parameters can be combined in a single request to apply multiple filters at once (e.g. `/armor?armor_slot=body&shop=true`).
Base URL: `http://localhost:8080/helldivers/api/v1`

> ⚠️ **Note:** The API calls documented in this README reflect the current state of the **`main`** branch. New and modified endpoints are being developed in the **`develop`** branch and will be merged upon release.             
> 🔐 **Endpoints marked with * require a valid JWT token.** After logging in via `POST /accounts/login`,
> copy the token from the response and add it to Postman under **Authorization → Bearer Token**.
> Keep in mind that certain operations are restricted to the authenticated user — for example,
> you can only update the helldiver linked to your own account.

### Accounts
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/accounts` | Get all accounts |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/accounts/{id}` | Get account by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/accounts/register` | Create a new account |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/accounts/login` | Login with email and password |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/accounts/{id}` | Update an account |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/accounts/{id}` | Delete an account |

### Helldivers
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers` | Get all helldivers |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers?callsign={callsign}` | Filter by call sign |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers?level={level}` | Filter by level |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers?medals={medals}` | Filter by medals count |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers?missions={missions}` | Filter by missions completed |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers?sc={sc}` | Filter by super credits |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers/{id}` | Get helldiver by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/helldivers/create` | Create a new helldiver (linked to an account) |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/helldivers/update/{id}` * | Update a helldiver |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/helldivers/delete/{id}` * | Delete a helldiver |

### Planets
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/planets` | Get all planets |

### Weapons
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons` | Get all weapons |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons?weapon_type=primary` | Get primary weapons |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons?weapon_type=secondary` | Get secondary weapons |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons?weapon_type=grenade` | Get grenades |

### Armor
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor` | Get all armor |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor?armor_slot=head` | Get head armor |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor?armor_slot=body` | Get body armor |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor?armor_slot=cape` | Get capes |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor?passive_id={id}` | Get armor by passive bonus |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor?shop=true` | Get premium armor (shop) |

### Stratagems
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems` | Get all stratagems |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems?name={name}` | Search stratagems by name |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems?type={type}` | Filter by category (orbital, airstrike, support...) |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems?backpack_slot={bool}` | Filter by backpack slot |

### Missions
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/missions/{missionId}/pickups/{pickupId}/collect` * | Collect a super credit pickup — distributes credits to all squad members |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/mstats/{missionId}/saveStats` * | Save mission stats for a helldiver |

