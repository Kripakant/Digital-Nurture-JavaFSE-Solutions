# Digital Nurture – Java FSE (Upskilling Solutions)

Solutions for the Cognizant **Digital Nurture – Java Full Stack Engineering** upskilling program.
All modules follow a common project theme: a **Local Community Event Portal**.

## 📦 Modules

| Module | Topic | Exercises | Folder |
|--------|-------|-----------|--------|
| **1** | Frontend – HTML5, CSS3, Bootstrap 5, JavaScript | 10 + 11 + 19 + 14 = **54** | [`Module1-Frontend/`](./Module1-Frontend) |
| **2** | ANSI SQL using MySQL (Event Portal schema) | **25** queries | [`Module2-SQL/`](./Module2-SQL) |
| **3** | Core Java | **41** | [`Module3-CoreJava/`](./Module3-CoreJava) |

## 📂 Repository Structure

```
Digital-Nurture-JavaFSE/
├── Module1-Frontend/
│   ├── 01-HTML5/        # 10 exercises – semantic pages, forms, media, geolocation, storage
│   ├── 02-CSS3/         # 11 exercises – selectors, box model, typography, responsive
│   ├── 03-Bootstrap5/   # 19 exercises – grid, components, utilities, JS plugins
│   └── 04-JavaScript/   # 14 exercises – DOM, events, async, fetch, ES6+
├── Module2-SQL/         # Event Portal schema + 25 analytical query exercises
│   ├── 01_schema.sql
│   ├── 02_sample_data.sql
│   └── 03_exercises.sql
└── Module3-CoreJava/
    ├── src/             # Exercise01..Exercise41 (one file each)
    └── modules-demo/    # Exercise 34 – Java module system project
```

## ▶️ Quick Start

**Module 1 (Frontend)** — open the `index.html` in each topic folder in a browser. No build step.

**Module 2 (SQL)** — MySQL 8.0+:
```bash
mysql -u root -p < Module2-SQL/01_schema.sql
mysql -u root -p < Module2-SQL/02_sample_data.sql
mysql -u root -p < Module2-SQL/03_exercises.sql
```

**Module 3 (Core Java)** — JDK 21+ (developed on JDK 26):
```bash
cd Module3-CoreJava
javac -d out src/*.java
java -cp out Exercise01_HelloWorld
```

Each module folder contains its own detailed `README.md` with the full exercise list.

---
*Completed as part of the Digital Nurture Java FSE upskilling track.*
