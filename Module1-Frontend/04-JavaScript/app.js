/* ===========================================================
   Module 1 - JavaScript Fundamentals
   Demonstrates: DOM selection, events, functions,
   arrays, ES6 (let/const, arrow functions, template literals)
   =========================================================== */

"use strict";

/* ---------- 1. Counter: events & state ---------- */
let count = 0;
const countEl = document.getElementById("count");
const render = () => (countEl.textContent = count);

document.getElementById("incBtn").addEventListener("click", () => {
  count++;
  render();
});
document.getElementById("decBtn").addEventListener("click", () => {
  count--;
  render();
});

/* ---------- 2. Calculator: functions ---------- */
function calc(operator) {
  const a = parseFloat(document.getElementById("numA").value);
  const b = parseFloat(document.getElementById("numB").value);
  const out = document.getElementById("output");

  if (Number.isNaN(a) || Number.isNaN(b)) {
    out.textContent = "Please enter two valid numbers.";
    return;
  }

  let result;
  switch (operator) {
    case "+": result = a + b; break;
    case "-": result = a - b; break;
    case "*": result = a * b; break;
    case "/": result = b !== 0 ? a / b : "Cannot divide by zero"; break;
    default:  result = "Unknown operator";
  }
  out.textContent = `Result: ${result}`;
}

/* ---------- 3. To-Do list: arrays & ES6 ---------- */
const todos = [];
const todoInput = document.getElementById("todoInput");
const todoList = document.getElementById("todoList");

function renderTodos() {
  todoList.innerHTML = "";
  todos.forEach((todo, index) => {
    const li = document.createElement("li");
    li.textContent = todo.text;
    if (todo.done) li.classList.add("done");

    // toggle done on click
    li.addEventListener("click", () => {
      todos[index].done = !todos[index].done;
      renderTodos();
    });

    // delete button
    const del = document.createElement("button");
    del.textContent = "✕";
    del.addEventListener("click", (e) => {
      e.stopPropagation();
      todos.splice(index, 1);
      renderTodos();
    });

    li.appendChild(del);
    todoList.appendChild(li);
  });
}

document.getElementById("addBtn").addEventListener("click", () => {
  const text = todoInput.value.trim();
  if (text) {
    todos.push({ text, done: false });
    todoInput.value = "";
    renderTodos();
  }
});

// Allow Enter key to add a task
todoInput.addEventListener("keydown", (e) => {
  if (e.key === "Enter") document.getElementById("addBtn").click();
});
