# Module 2 – ANSI SQL using MySQL

SQL scripts for **Module 2** of the Digital Nurture Java FSE program. They build a
small **Company** database and demonstrate ANSI SQL from basics to advanced features.

## 📂 Files (run in order)

| # | File | Covers |
|---|------|--------|
| 1 | `01_schema_and_data.sql` | `CREATE DATABASE/TABLE`, PK/FK, constraints, sample `INSERT`s |
| 2 | `02_basic_queries.sql` | `SELECT`, `WHERE`, `BETWEEN`, `IN`, `LIKE`, `IS NULL`, `ORDER BY`, `DISTINCT`, `LIMIT`, aliases |
| 3 | `03_aggregates_groupby.sql` | `COUNT/SUM/AVG/MIN/MAX`, `GROUP BY`, `HAVING` |
| 4 | `04_joins.sql` | `INNER`, `LEFT`, `RIGHT`, `SELF`, multi-table & `CROSS JOIN` |
| 5 | `05_subqueries.sql` | Scalar / `IN` / correlated subqueries, `EXISTS`, derived tables, `UNION` |
| 6 | `06_functions_and_case.sql` | String, numeric & date functions, `CASE`, `COALESCE` |
| 7 | `07_views_indexes_transactions.sql` | `VIEW`, `INDEX`, `TRANSACTION`, stored procedure, window function (`RANK`) |

## 🗃️ Schema

```
departments (dept_id PK, dept_name, location)
employees   (emp_id PK, first_name, last_name, email, hire_date,
             salary, dept_id FK→departments, manager_id FK→employees)
projects    (project_id PK, project_name, budget, dept_id FK→departments)
emp_projects(emp_id FK, project_id FK, hours)   -- many-to-many
```

## ▶️ How to Run

```bash
mysql -u root -p < 01_schema_and_data.sql
mysql -u root -p < 02_basic_queries.sql
# ...and so on, or paste into MySQL Workbench
```

Requires **MySQL 8.0+** (window functions used in file 7).

---
*Module 2 completed as part of Digital Nurture Java FSE upskilling.*
