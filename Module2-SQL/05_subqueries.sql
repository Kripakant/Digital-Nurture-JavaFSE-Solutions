-- ============================================================
-- Module 2 : ANSI SQL using MySQL
-- File 5 : Subqueries & Set operations
-- ============================================================
USE dn_company;

-- 1. Scalar subquery: employees earning above company average
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- 2. Subquery with IN: employees in departments located in Bangalore
SELECT first_name, last_name
FROM employees
WHERE dept_id IN (
    SELECT dept_id FROM departments WHERE location = 'Bangalore'
);

-- 3. Correlated subquery: employees earning the max salary within their dept
SELECT e.first_name, e.salary, e.dept_id
FROM employees e
WHERE e.salary = (
    SELECT MAX(e2.salary)
    FROM employees e2
    WHERE e2.dept_id = e.dept_id
);

-- 4. EXISTS: departments that have at least one project
SELECT d.dept_name
FROM departments d
WHERE EXISTS (
    SELECT 1 FROM projects p WHERE p.dept_id = d.dept_id
);

-- 5. Subquery in FROM (derived table): avg salary per dept, then filter
SELECT dept_id, avg_sal
FROM (
    SELECT dept_id, AVG(salary) AS avg_sal
    FROM employees
    GROUP BY dept_id
) AS dept_avg
WHERE avg_sal > 70000;

-- 6. UNION: combine names from two filtered sets (no duplicates)
SELECT first_name FROM employees WHERE dept_id = 1
UNION
SELECT first_name FROM employees WHERE salary > 90000;

-- 7. UNION ALL: keep duplicates
SELECT 'High earner' AS category, first_name FROM employees WHERE salary >= 90000
UNION ALL
SELECT 'Recent hire', first_name FROM employees WHERE hire_date >= '2021-01-01';
