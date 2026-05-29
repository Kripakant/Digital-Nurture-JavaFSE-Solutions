-- ============================================================
-- Module 2 : ANSI SQL using MySQL
-- File 3 : Aggregate functions & GROUP BY / HAVING
-- ============================================================
USE dn_company;

-- 1. COUNT, SUM, AVG, MIN, MAX
SELECT
    COUNT(*)      AS total_employees,
    SUM(salary)   AS total_payroll,
    AVG(salary)   AS avg_salary,
    MIN(salary)   AS lowest_salary,
    MAX(salary)   AS highest_salary
FROM employees;

-- 2. GROUP BY department: headcount & average salary
SELECT
    dept_id,
    COUNT(*)    AS headcount,
    AVG(salary) AS avg_salary
FROM employees
GROUP BY dept_id;

-- 3. GROUP BY with JOIN to show department names
SELECT
    d.dept_name,
    COUNT(e.emp_id) AS headcount,
    ROUND(AVG(e.salary), 2) AS avg_salary
FROM departments d
LEFT JOIN employees e ON e.dept_id = d.dept_id
GROUP BY d.dept_name;

-- 4. HAVING: departments whose average salary exceeds 75000
SELECT
    dept_id,
    AVG(salary) AS avg_salary
FROM employees
GROUP BY dept_id
HAVING AVG(salary) > 75000;

-- 5. Total hours worked per project
SELECT
    p.project_name,
    SUM(ep.hours) AS total_hours
FROM projects p
JOIN emp_projects ep ON ep.project_id = p.project_id
GROUP BY p.project_name
ORDER BY total_hours DESC;

-- 6. Count of projects per department
SELECT
    d.dept_name,
    COUNT(p.project_id) AS num_projects
FROM departments d
LEFT JOIN projects p ON p.dept_id = d.dept_id
GROUP BY d.dept_name;
