# Module 2 — ANSI SQL Using MySQL

**Cognizant Digital Nurture — Java FSE Program**
**Project:** Community Event Portal (Event Management)
**Target:** MySQL 8.0+ (window functions allowed)

A relational schema and 25 analytical SQL queries for a community event
management portal, where users register for events, attend sessions,
leave feedback, and access event resources.

---

## 📁 Files

| File | Purpose |
|------|---------|
| `01_schema.sql`      | Creates the `event_portal` database and all 6 tables with full constraints. |
| `02_sample_data.sql` | Populates the spec's sample dataset plus a few extra rows for meaningful results. |
| `03_exercises.sql`   | The 25 query exercises, each with a commented header. |
| `README.md`          | This document. |

---

## 🗄️ Schema Overview

### Tables

**1. Users** — registered portal members.
| Column | Type | Constraints |
|--------|------|-------------|
| user_id | INT | PK, AUTO_INCREMENT |
| full_name | VARCHAR(100) | NOT NULL |
| email | VARCHAR(100) | UNIQUE, NOT NULL |
| city | VARCHAR(100) | NOT NULL |
| registration_date | DATE | NOT NULL |

**2. Events** — events hosted on the portal.
| Column | Type | Constraints |
|--------|------|-------------|
| event_id | INT | PK, AUTO_INCREMENT |
| title | VARCHAR(200) | NOT NULL |
| description | TEXT | |
| city | VARCHAR(100) | NOT NULL |
| start_date | DATETIME | NOT NULL |
| end_date | DATETIME | NOT NULL |
| status | ENUM('upcoming','completed','cancelled') | |
| organizer_id | INT | FK → Users(user_id) |

**3. Sessions** — talks/sessions within an event.
| Column | Type | Constraints |
|--------|------|-------------|
| session_id | INT | PK, AUTO_INCREMENT |
| event_id | INT | FK → Events(event_id) |
| title | VARCHAR(200) | NOT NULL |
| speaker_name | VARCHAR(100) | NOT NULL |
| start_time | DATETIME | NOT NULL |
| end_time | DATETIME | NOT NULL |

**4. Registrations** — user ↔ event sign-ups.
| Column | Type | Constraints |
|--------|------|-------------|
| registration_id | INT | PK, AUTO_INCREMENT |
| user_id | INT | FK → Users(user_id) |
| event_id | INT | FK → Events(event_id) |
| registration_date | DATE | NOT NULL |

**5. Feedback** — ratings & comments left by users.
| Column | Type | Constraints |
|--------|------|-------------|
| feedback_id | INT | PK, AUTO_INCREMENT |
| user_id | INT | FK → Users(user_id) |
| event_id | INT | FK → Events(event_id) |
| rating | INT | CHECK (rating BETWEEN 1 AND 5) |
| comments | TEXT | |
| feedback_date | DATE | NOT NULL |

**6. Resources** — files/links attached to events.
| Column | Type | Constraints |
|--------|------|-------------|
| resource_id | INT | PK, AUTO_INCREMENT |
| event_id | INT | FK → Events(event_id) |
| resource_type | ENUM('pdf','image','link') | |
| resource_url | VARCHAR(255) | NOT NULL |
| uploaded_at | DATETIME | NOT NULL |

### Relationships

```
Users 1───* Events        (organizer_id)
Users 1───* Registrations  (user_id)
Users 1───* Feedback       (user_id)

Events 1───* Sessions       (event_id)
Events 1───* Registrations  (event_id)
Events 1───* Feedback       (event_id)
Events 1───* Resources      (event_id)
```

A user can organize many events and register for / give feedback on many
events. An event has many sessions, registrations, feedback entries, and
resources.

---

## 📝 Exercises

| # | Title | Description |
|---|-------|-------------|
| 1 | User Upcoming Events | Upcoming events a user is registered for in their city, sorted by date. |
| 2 | Top Rated Events | Highest average rating among events with ≥ 10 feedback submissions. |
| 3 | Inactive Users | Users with no registrations in the last 90 days. |
| 4 | Peak Session Hours | Count of sessions between 10 AM–12 PM per event. |
| 5 | Most Active Cities | Top 5 cities by distinct registered users. |
| 6 | Event Resource Summary | Count of PDFs / images / links per event. |
| 7 | Low Feedback Alerts | Users who rated < 3, with comments and event names. |
| 8 | Sessions per Upcoming Event | Session count for each upcoming event. |
| 9 | Organizer Event Summary | Event counts per organizer broken down by status. |
| 10 | Feedback Gap | Events with registrations but no feedback. |
| 11 | Daily New User Count | New users per day over the last 7 days. |
| 12 | Event with Maximum Sessions | Event(s) with the most sessions. |
| 13 | Average Rating per City | Average feedback rating per city. |
| 14 | Most Registered Events | Top 3 events by total registrations. |
| 15 | Event Session Time Conflict | Overlapping sessions within the same event. |
| 16 | Unregistered Active Users | Users joined in last 30 days with no registrations. |
| 17 | Multi-Session Speakers | Speakers handling more than one session. |
| 18 | Resource Availability Check | Events with no resources uploaded. |
| 19 | Completed Events with Feedback Summary | Completed events: total registrations & avg rating. |
| 20 | User Engagement Index | Per user: events attended & feedbacks submitted. |
| 21 | Top Feedback Providers | Top 5 users by feedback count. |
| 22 | Duplicate Registrations Check | Users registered more than once for the same event. |
| 23 | Registration Trends | Month-wise registration count over the last 12 months. |
| 24 | Average Session Duration per Event | Average session duration (minutes) per event. |
| 25 | Events Without Sessions | Events with no sessions scheduled. |

---

## ▶️ How to Run

From the `Module2-SQL` directory, using the MySQL command-line client:

```bash
# 1. Create the database and tables
mysql -u root -p < 01_schema.sql

# 2. Load the sample data
mysql -u root -p < 02_sample_data.sql

# 3. Run the exercise queries
mysql -u root -p event_portal < 03_exercises.sql
```

Or, from inside the `mysql>` shell:

```sql
SOURCE 01_schema.sql;
SOURCE 02_sample_data.sql;
SOURCE 03_exercises.sql;
```

> **Note:** Several queries are date-relative (`CURDATE() - INTERVAL …`).
> The sample data includes recent rows (dated around May 2026) so these
> queries return meaningful results.
