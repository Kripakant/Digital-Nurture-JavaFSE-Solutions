-- ============================================================
-- Module 2 : ANSI SQL using MySQL
-- File 6 : Built-in functions (string, numeric, date), CASE
-- ============================================================
USE dn_company;

-- ---------- String functions ----------
SELECT
    first_name,
    UPPER(first_name)              AS upper_name,
    LOWER(last_name)               AS lower_name,
    CONCAT(first_name, ' ', last_name) AS full_name,
    LENGTH(first_name)             AS name_length,
    SUBSTRING(email, 1, 5)         AS email_prefix,
    REPLACE(email, '@dn.com', '')  AS username
FROM employees;

-- ---------- Numeric functions ----------
SELECT
    first_name,
    salary,
    ROUND(salary / 12, 2)  AS approx_monthly_part,
    CEIL(salary / 1000)    AS salary_in_k_ceil,
    FLOOR(salary / 1000)   AS salary_in_k_floor,
    MOD(emp_id, 2)         AS emp_id_parity
FROM employees;

-- ---------- Date functions ----------
SELECT
    first_name,
    hire_date,
    YEAR(hire_date)                          AS hire_year,
    MONTHNAME(hire_date)                     AS hire_month,
    DATEDIFF(CURDATE(), hire_date)           AS days_employed,
    TIMESTAMPDIFF(YEAR, hire_date, CURDATE()) AS years_of_service
FROM employees;

-- ---------- CASE expression: salary banding ----------
SELECT
    first_name,
    salary,
    CASE
        WHEN salary >= 100000 THEN 'A - Senior'
        WHEN salary >= 70000  THEN 'B - Mid'
        ELSE                       'C - Junior'
    END AS salary_band
FROM employees
ORDER BY salary DESC;

-- ---------- COALESCE / NULL handling ----------
SELECT
    e.first_name,
    COALESCE(m.first_name, 'No Manager') AS manager_name
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.emp_id;
