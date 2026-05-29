-- ============================================================
-- Module 2 : ANSI SQL using MySQL
-- File 4 : JOINS (INNER, LEFT, RIGHT, SELF, CROSS)
-- ============================================================
USE dn_company;

-- 1. INNER JOIN: employees with their department names
SELECT
    e.first_name, e.last_name, d.dept_name
FROM employees e
INNER JOIN departments d ON e.dept_id = d.dept_id;

-- 2. LEFT JOIN: all departments, even those with no employees
SELECT
    d.dept_name, e.first_name
FROM departments d
LEFT JOIN employees e ON e.dept_id = d.dept_id;

-- 3. RIGHT JOIN: all employees, ensuring department side preserved
SELECT
    e.first_name, d.dept_name
FROM departments d
RIGHT JOIN employees e ON e.dept_id = d.dept_id;

-- 4. SELF JOIN: employee with their manager's name
SELECT
    e.first_name AS employee,
    m.first_name AS manager
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.emp_id;

-- 5. Multi-table JOIN: who works on which project, and for which dept
SELECT
    e.first_name,
    p.project_name,
    ep.hours,
    d.dept_name
FROM emp_projects ep
JOIN employees e   ON ep.emp_id = e.emp_id
JOIN projects p    ON ep.project_id = p.project_id
JOIN departments d ON e.dept_id = d.dept_id
ORDER BY e.first_name;

-- 6. CROSS JOIN (Cartesian product) - every dept x every project
SELECT d.dept_name, p.project_name
FROM departments d
CROSS JOIN projects p;
