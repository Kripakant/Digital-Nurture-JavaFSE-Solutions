-- ============================================================
-- Module 2 : ANSI SQL using MySQL
-- File 1 : Schema & Sample Data (DDL + INSERTs)
-- Creates a small Company/Sales database used by all queries.
-- ============================================================

DROP DATABASE IF EXISTS dn_company;
CREATE DATABASE dn_company;
USE dn_company;

-- ---------- Departments ----------
CREATE TABLE departments (
    dept_id     INT PRIMARY KEY AUTO_INCREMENT,
    dept_name   VARCHAR(50) NOT NULL UNIQUE,
    location    VARCHAR(50)
);

-- ---------- Employees ----------
CREATE TABLE employees (
    emp_id      INT PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    email       VARCHAR(100) UNIQUE,
    hire_date   DATE NOT NULL,
    salary      DECIMAL(10,2) NOT NULL CHECK (salary > 0),
    dept_id     INT,
    manager_id  INT,
    CONSTRAINT fk_emp_dept    FOREIGN KEY (dept_id)    REFERENCES departments(dept_id),
    CONSTRAINT fk_emp_manager FOREIGN KEY (manager_id) REFERENCES employees(emp_id)
);

-- ---------- Projects ----------
CREATE TABLE projects (
    project_id   INT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(100) NOT NULL,
    budget       DECIMAL(12,2),
    dept_id      INT,
    CONSTRAINT fk_proj_dept FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

-- ---------- Employee-Project assignment (many-to-many) ----------
CREATE TABLE emp_projects (
    emp_id      INT,
    project_id  INT,
    hours       INT DEFAULT 0,
    PRIMARY KEY (emp_id, project_id),
    FOREIGN KEY (emp_id)     REFERENCES employees(emp_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);

-- ============================================================
-- Sample data
-- ============================================================
INSERT INTO departments (dept_name, location) VALUES
('Engineering', 'Bangalore'),
('Sales',       'Mumbai'),
('HR',          'Delhi'),
('Finance',     'Pune');

INSERT INTO employees (first_name, last_name, email, hire_date, salary, dept_id, manager_id) VALUES
('Asha',   'Rao',     'asha.rao@dn.com',     '2018-03-15', 120000, 1, NULL),
('Vikram', 'Singh',   'vikram.singh@dn.com', '2019-07-01',  85000, 1, 1),
('Neha',   'Gupta',   'neha.gupta@dn.com',   '2020-01-20',  78000, 1, 1),
('Ravi',   'Kumar',   'ravi.kumar@dn.com',   '2017-11-05',  95000, 2, NULL),
('Pooja',  'Mehta',   'pooja.mehta@dn.com',  '2021-06-10',  60000, 2, 4),
('Arjun',  'Nair',    'arjun.nair@dn.com',   '2022-02-14',  55000, 2, 4),
('Sara',   'Khan',    'sara.khan@dn.com',    '2019-09-30',  70000, 3, NULL),
('Manish', 'Verma',   'manish.verma@dn.com', '2023-04-01',  50000, 4, NULL);

INSERT INTO projects (project_name, budget, dept_id) VALUES
('Payment Gateway', 500000, 1),
('Mobile App',      300000, 1),
('CRM Rollout',     200000, 2),
('Payroll System',  150000, 4);

INSERT INTO emp_projects (emp_id, project_id, hours) VALUES
(1, 1, 120), (2, 1, 200), (3, 2, 160),
(2, 2,  80), (4, 3, 150), (5, 3, 100),
(8, 4, 140), (1, 2,  40);
