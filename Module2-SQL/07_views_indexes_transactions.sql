-- ============================================================
-- Module 2 : ANSI SQL using MySQL
-- File 7 : Views, Indexes, Transactions, Stored Procedure
-- ============================================================
USE dn_company;

-- ---------- VIEW ----------
CREATE OR REPLACE VIEW v_employee_details AS
SELECT
    e.emp_id,
    CONCAT(e.first_name, ' ', e.last_name) AS full_name,
    e.salary,
    d.dept_name,
    d.location
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id;

-- Query the view
SELECT * FROM v_employee_details WHERE salary > 70000;

-- ---------- INDEX ----------
-- Speeds up lookups/filtering on salary
CREATE INDEX idx_emp_salary ON employees(salary);
-- Composite index for department + salary queries
CREATE INDEX idx_emp_dept_salary ON employees(dept_id, salary);

-- ---------- TRANSACTION ----------
-- Give everyone in Engineering a 10% raise atomically
START TRANSACTION;

UPDATE employees
SET salary = salary * 1.10
WHERE dept_id = 1;

-- COMMIT to save, or ROLLBACK to undo
COMMIT;

-- ---------- STORED PROCEDURE ----------
DROP PROCEDURE IF EXISTS get_employees_by_dept;

DELIMITER //
CREATE PROCEDURE get_employees_by_dept(IN p_dept_id INT)
BEGIN
    SELECT first_name, last_name, salary
    FROM employees
    WHERE dept_id = p_dept_id
    ORDER BY salary DESC;
END //
DELIMITER ;

-- Call the procedure
CALL get_employees_by_dept(1);

-- ---------- Window function (ANSI SQL): rank salaries within dept ----------
SELECT
    first_name,
    dept_id,
    salary,
    RANK() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS salary_rank
FROM employees;
