
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
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers` | Get all helldivers — filters: `callsign`, `level`, `medals`, `missions`, `sc` |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/helldivers/{id}` | Get helldiver by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/helldivers` | Create a new helldiver (linked to an account) |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/helldivers/{id}` * | Update a helldiver |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/helldivers/{id}` * | Delete a helldiver |

### Planets
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/planets` | Get all planets — filters: `name` (partial), `sector`, `biome` (DESERT, TUNDRA, JUNGLE, URBAN), `faction` (TERMINIDS, AUTOMATONS, ILLUMINATE, FEDERATION), `cordX`, `cordY`, `maxhp` |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/planets/{id}` | Get planet by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/planets` | Create a new planet |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/planets/{id}` | Update a planet |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/planets/{id}` | Delete a planet |

### Weapons
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons` | Get all weapons — filters: `weapon_type` (PRIMARY, SECONDARY, SUPPORT, GRENADE) |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons/{id}` | Get weapon by ID |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons/{id}/ammo` | Get all ammo types compatible with a weapon |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons/{id}/attachments` | Get all attachments for a weapon |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons/{id}/stats` | Get combat stats summary for a weapon |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons/ammo/{ammoId}` | Get all weapons that use a specific ammo type |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/weapons/attachment/{attachmentId}` | Get all weapons compatible with a specific attachment |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/weapons` | Create a new weapon |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/weapons/{weaponId}/ammo/{ammoId}` | Link an ammo type to a weapon |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/weapons/{id}` | Update a weapon |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/weapons/{id}` | Delete a weapon |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/weapons/{weaponId}/ammo/{ammoId}` | Unlink an ammo type from a weapon |

### Ammo
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/ammo` | Get all ammo types — filters: `caliber` (partial), `pen` (Light, Medium, Heavy) |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/ammo/{id}` | Get ammo by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/ammo` | Create a new ammo type |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/ammo/{id}` | Update an ammo type |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/ammo/{id}` | Delete an ammo type |

### Attachments
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/attachments` | Get all attachments — filters: `category` (OPTICS, MAGAZINE, UNDERBARREL, MUZZLE...) |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/attachments/{id}` | Get attachment by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/attachments` | Create a new attachment |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/attachments/{attachmentId}/weapons/{weaponId}` | Link an attachment to a weapon |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/attachments/{id}` | Update an attachment |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/attachments/{id}` | Delete an attachment |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/attachments/{attachmentId}/weapons/{weaponId}` | Unlink an attachment from a weapon |

### Armor
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor` | Get all armor — filters: `armor_slot` (HEAD, BODY, CAPE), `passive_id`, `shop` (true/false) |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/armor/{id}` | Get armor by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/armor` | Create a new armor piece |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/armor/{id}` | Update an armor piece |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/armor/{id}` | Delete an armor piece |

### Stratagems
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems` | Get all stratagems — filters: `name` (partial), `type` (ORBITAL, AIRSTRIKE, SUPPORT, SENTRY...), `backpack` (true/false), `uses` |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems/{id}` | Get stratagem by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/stratagems` | Create a new stratagem |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/stratagems/{id}` | Update a stratagem |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/stratagems/{id}` | Delete a stratagem |

### Stratagem Attacks
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems/{id}/attacks` | Get all attacks for a stratagem |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems/{id}/attacks/{attackId}` | Get a specific attack by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/stratagems/{id}/attacks/create` | Add an attack to a stratagem |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/stratagems/{id}/attacks/update/{attackId}` | Update a stratagem attack |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/stratagems/{id}/attacks/delete/{attackId}` | Delete a stratagem attack |

### Stratagem Entity
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/stratagems/{id}/entity` | Get the deployed entity for a stratagem |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/stratagems/{id}/entity/create` | Create a deployed entity for a stratagem |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/stratagems/{id}/entity/update` | Update a stratagem entity |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/stratagems/{id}/entity/delete` | Delete a stratagem entity |

### Missions
| Method | Endpoint | Description |
|--------|----------|-------------|
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/missions` | Get all missions — filters: `missionType` (CIVILIANS, ISMC), `difficulty` (1–10), `enemyFaction`, `inProgress`, `started`, `ended`, `missionResult` (WIN, LOSE), `missionStatsSaved` |
| ![GET](https://img.shields.io/badge/GET-61affe?style=flat-square&logoColor=white) | `/missions/{id}` | Get mission by ID |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/missions` | Create a new mission |
| ![PUT](https://img.shields.io/badge/PUT-fca130?style=flat-square&logoColor=white) | `/missions/{id}` | Update a mission |
| ![DELETE](https://img.shields.io/badge/DELETE-f93e3e?style=flat-square&logoColor=white) | `/missions/{id}` | Delete a mission |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/missions/{missionId}/pickups/{pickupId}/collect` * | Collect a super credit pickup — distributes credits to all squad members |
| ![POST](https://img.shields.io/badge/POST-49cc90?style=flat-square&logoColor=white) | `/mstats/{missionId}/saveStats` * | Save mission stats for all helldivers in the mission |



