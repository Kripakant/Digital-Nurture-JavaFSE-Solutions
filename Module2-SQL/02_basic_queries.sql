-- ============================================================
-- Module 2 : ANSI SQL using MySQL
-- File 2 : Basic SELECT, WHERE, ORDER BY, DISTINCT, LIMIT
-- Run 01_schema_and_data.sql first.
-- ============================================================
USE dn_company;

-- 1. Select all employees
SELECT * FROM employees;

-- 2. Select specific columns
SELECT first_name, last_name, salary FROM employees;

-- 3. Filter with WHERE
SELECT first_name, salary
FROM employees
WHERE salary > 70000;

-- 4. Multiple conditions (AND / OR)
SELECT first_name, dept_id, salary
FROM employees
WHERE dept_id = 1 AND salary >= 80000;

-- 5. BETWEEN
SELECT first_name, salary
FROM employees
WHERE salary BETWEEN 50000 AND 80000;

-- 6. IN
SELECT first_name, dept_id
FROM employees
WHERE dept_id IN (1, 2);

-- 7. LIKE (pattern match)
SELECT first_name, email
FROM employees
WHERE email LIKE '%@dn.com';

-- 8. IS NULL (employees with no manager = top level)
SELECT first_name, last_name
FROM employees
WHERE manager_id IS NULL;

-- 9. ORDER BY (descending salary)
SELECT first_name, salary
FROM employees
ORDER BY salary DESC;

-- 10. DISTINCT department locations
SELECT DISTINCT location FROM departments;

-- 11. LIMIT (top 3 highest paid)
SELECT first_name, salary
FROM employees
ORDER BY salary DESC
LIMIT 3;

-- 12. Aliases & computed column (annual salary)
SELECT
    first_name AS name,
    salary AS monthly,
    salary * 12 AS annual_salary
FROM employees;
