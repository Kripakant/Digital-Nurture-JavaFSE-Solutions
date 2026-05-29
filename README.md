# Digital Nurture – Java FSE (Upskilling Solutions)

Solutions for the Cognizant **Digital Nurture – Java Full Stack Engineering** upskilling program.

## 📦 Modules

| Module | Topic | Folder | Status |
|--------|-------|--------|--------|
| **1** | Frontend – HTML5, CSS3, Bootstrap 5, JavaScript | [`Module1-Frontend/`](./Module1-Frontend) | ✅ Complete |
| **2** | ANSI SQL using MySQL | [`Module2-SQL/`](./Module2-SQL) | ✅ Complete |
| **3** | Core Java | [`Module3-CoreJava/`](./Module3-CoreJava) | ✅ Complete |

## 📂 Repository Structure

```
Digital-Nurture-JavaFSE/
├── Module1-Frontend/
│   ├── 01-HTML5/        # Semantic HTML, forms, media, tables
│   ├── 02-CSS3/         # Flexbox, Grid, transitions, animations
│   ├── 03-Bootstrap5/   # Navbar, grid, cards, modal (CDN)
│   └── 04-JavaScript/   # DOM, events, ES6
├── Module2-SQL/         # 7 ordered .sql scripts (schema → advanced)
└── Module3-CoreJava/
    └── src/             # basics, oop, collections, exceptions,
                         #   strings, generics, functional
```

## ▶️ Quick Start

- **Module 1:** open any topic's `index.html` in a browser.
- **Module 2:** `mysql -u root -p < Module2-SQL/01_schema_and_data.sql` (then run the rest in order).
- **Module 3:** `cd Module3-CoreJava && javac -d out $(find src -name "*.java")` then `java -cp out <package>.<Class>`.

Each module folder has its own detailed `README.md`.

---
*Completed as part of the Digital Nurture Java FSE upskilling track.*
