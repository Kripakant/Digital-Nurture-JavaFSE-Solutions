/* ============================================================
   Community Event Portal — main.js
   Module 1 JavaScript exercises 1–12
   ============================================================ */

// Exercise 1: JavaScript Basics & Setup
console.log("Welcome to the Community Portal");
window.addEventListener("load", () => {
  alert("Page fully loaded — welcome to the Community Event Portal!");
});

/* ------------------------------------------------------------ */
// Exercise 2: Syntax, Data Types, and Operators
const portalName = "Local Community Event Portal"; // const for fixed value
const openingDate = "2026-06-01";                  // const for event date
let totalSeats = 50;                               // let — changeable seat count

// Template literal concatenation
console.log(`${portalName} opens on ${openingDate} with ${totalSeats} seats.`);

// Seat counter using ++ / -- on registration / cancellation
function bookSeat() { totalSeats--; return totalSeats; }   // decrement on registration
function freeSeat() { totalSeats++; return totalSeats; }   // increment on cancel

/* ------------------------------------------------------------ */
// Exercise 5: Objects and Prototypes (defined early so data can use it)
class CommunityEvent {
  constructor(name, category, location, date, seats) {
    this.name = name;
    this.category = category;
    this.location = location;
    this.date = date;          // ISO string
    this.seats = seats;        // available seats
  }
}
// Add checkAvailability() to the prototype
CommunityEvent.prototype.checkAvailability = function () {
  return this.seats > 0 && new Date(this.date) >= new Date(todayMidnight());
};
function todayMidnight() {
  const d = new Date(); d.setHours(0, 0, 0, 0); return d.toISOString();
}

/* ------------------------------------------------------------ */
// Exercise 6: Arrays and Methods — master event list
let communityEvents = [
  new CommunityEvent("Open Mic Night", "music", "Community Hall", "2026-07-10", 12),
  new CommunityEvent("Baking Workshop", "workshop", "Community Hall", "2026-07-15", 0),  // full
  new CommunityEvent("Summer Concert", "music", "City Park", "2026-08-01", 25),
  new CommunityEvent("Yoga in the Park", "sports", "City Park", "2026-06-20", 8),
  new CommunityEvent("5K Fun Run", "sports", "Sports Arena", "2026-05-01", 30),          // past
  new CommunityEvent("Pottery Class", "workshop", "Community Hall", "2026-09-05", 6)
];

// .push() to add a new event
communityEvents.push(
  new CommunityEvent("Jazz Evening", "music", "City Park", "2026-09-20", 15)
);

// .filter() — only music events
const musicEvents = communityEvents.filter(e => e.category === "music");
console.log("Music events:", musicEvents.map(e => e.name));

// .map() — format display labels e.g. "Workshop on Baking"
const displayLabels = communityEvents.map(e => `${capitalize(e.category)}: ${e.name}`);
console.log("Display labels:", displayLabels);

// .reduce() — total available seats across all events
const totalAvailable = communityEvents.reduce((sum, e) => sum + e.seats, 0);
console.log("Total available seats across events:", totalAvailable);

function capitalize(s) { return s.charAt(0).toUpperCase() + s.slice(1); }

/* ------------------------------------------------------------ */
// Exercise 4: Functions, Scope, Closures, Higher-Order Functions

// addEvent — adds a new event to the list
function addEvent(event) {
  if (!(event instanceof CommunityEvent)) throw new Error("Invalid event object");
  communityEvents.push(event);
  return communityEvents.length;
}

// Closure to track total registrations per category
function makeRegistrationCounter() {
  const counts = {}; // private state captured by closure
  return function (category) {
    counts[category] = (counts[category] || 0) + 1;
    return counts[category];
  };
}
const trackRegistration = makeRegistrationCounter();

// registerUser — books a seat & records the registration
function registerUser(event) {
  if (!event.checkAvailability()) throw new Error(`No seats / event passed: ${event.name}`);
  event.seats--;                          // decrement seats
  const count = trackRegistration(event.category);
  console.log(`Registered for ${event.name}. ${event.category} registrations: ${count}`);
  return event;
}

// Higher-order function — accepts a callback predicate for dynamic search
function filterEventsByCategory(events, predicate) {
  return events.filter(predicate); // predicate is a callback
}

/* ------------------------------------------------------------ */
// Exercise 10: Modern JavaScript Features
// Default parameters, destructuring, spread, arrow functions, template literals
const formatEvent = ({ name, location, date, seats = 0 }) =>
  `${name} @ ${location} on ${date} (${seats} seats left)`;

function getValidUpcomingEvents(events = communityEvents) {
  // spread to clone before filtering (no mutation of original)
  const clone = [...events];
  return clone.filter(e => e.checkAvailability());
}

/* ------------------------------------------------------------ */
// Exercise 3: Conditionals, Loops, Error Handling
// Build the list of valid events (upcoming + seats), with try/catch around logic
function getDisplayableEvents() {
  const result = [];
  communityEvents.forEach(e => {            // forEach loop
    try {
      // if-else: hide past or full events
      if (!e.checkAvailability()) {
        console.warn(`Hidden (past/full): ${e.name}`);
      } else {
        result.push(e);
      }
    } catch (err) {
      console.error("Error processing event:", err.message);
    }
  });
  return result;
}

/* ------------------------------------------------------------ */
// Exercise 7: DOM Manipulation — render events dynamically
const listEl     = document.querySelector("#eventList");
const spinnerEl  = document.querySelector("#spinner");
const selectEl   = document.querySelector("#eventSelect");

function renderEvents(events) {
  listEl.innerHTML = "";
  if (events.length === 0) {
    listEl.innerHTML = "<p>No events match your filters.</p>";
    return;
  }
  events.forEach(e => {
    const card = document.createElement("div");   // createElement
    card.className = "event-card";
    card.innerHTML = `
      <span class="badge">${capitalize(e.category)}</span>
      <h3>${e.name}</h3>
      <p>${formatEvent(e)}</p>
    `;
    const btn = document.createElement("button");
    btn.textContent = "Register";
    // Exercise 8: onclick event handling for Register
    btn.onclick = () => handleRegister(e, btn);
    card.appendChild(btn);
    listEl.appendChild(card);                      // append
  });
}

// Update UI when user registers
function handleRegister(event, btn) {
  try {
    registerUser(event);
    btn.textContent = "Registered ✓";
    btn.disabled = true;
    refreshEventSelect();
    applyFilters(); // re-render to show updated seats
  } catch (err) {
    alert(err.message);
  }
}

// Populate the registration form's event dropdown
function refreshEventSelect() {
  const valid = getValidUpcomingEvents();
  selectEl.innerHTML = valid
    .map(e => `<option value="${e.name}">${e.name}</option>`)
    .join("");
}

/* ------------------------------------------------------------ */
// Exercise 8: Event Handling — filters & search
const categoryFilter = document.querySelector("#categoryFilter");
const locationFilter = document.querySelector("#locationFilter");
const searchBox      = document.querySelector("#searchBox");

function applyFilters() {
  const cat = categoryFilter.value;
  const loc = locationFilter.value;
  const term = searchBox.value.trim().toLowerCase();

  // Use higher-order filterEventsByCategory with a composed predicate
  const filtered = filterEventsByCategory(getDisplayableEvents(), e =>
    (cat === "all" || e.category === cat) &&
    (loc === "all" || e.location === loc) &&
    (term === "" || e.name.toLowerCase().includes(term))
  );
  renderEvents(filtered);
}

categoryFilter.addEventListener("change", applyFilters); // onchange
locationFilter.addEventListener("change", applyFilters);
searchBox.addEventListener("keydown", () => setTimeout(applyFilters, 0)); // keydown quick search

/* ------------------------------------------------------------ */
// Exercise 11: Working with Forms — validation
const form = document.querySelector("#registrationForm");
form.addEventListener("submit", (event) => {
  event.preventDefault(); // prevent default form behavior

  // Access inputs via form.elements
  const { userName, userEmail, eventSelect } = form.elements;
  let valid = true;

  setError("nameError", "");
  setError("emailError", "");
  setError("eventError", "");

  if (userName.value.trim().length < 2) {
    setError("nameError", "Please enter your name."); valid = false;
  }
  if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(userEmail.value)) {
    setError("emailError", "Please enter a valid email."); valid = false;
  }
  if (!eventSelect.value) {
    setError("eventError", "Please choose an event."); valid = false;
  }

  const msg = document.querySelector("#formMessage");
  if (!valid) {
    msg.className = "msg fail";
    msg.textContent = "Please fix the errors above.";
    return;
  }
  // valid — hand off to the (simulated) server in Exercise 12
  submitRegistration({
    name: userName.value,
    email: userEmail.value,
    event: eventSelect.value
  });
});

function setError(id, text) { document.querySelector("#" + id).textContent = text; }

/* ------------------------------------------------------------ */
// Exercise 9: Async JS, Promises, Async/Await — simulate data load
function fetchEventsFromMockApi() {
  // returns a Promise that resolves after a delay
  return new Promise((resolve) => {
    setTimeout(() => resolve(communityEvents), 800);
  });
}

// .then()/.catch() version (logged) + async/await version drives the UI
function loadWithThen() {
  fetchEventsFromMockApi()
    .then(events => console.log(".then() loaded", events.length, "events"))
    .catch(err => console.error(err));
}

async function initEvents() {
  spinnerEl.style.display = "block";        // show loading spinner
  try {
    const events = await fetchEventsFromMockApi(); // async/await
    console.log("async/await loaded", events.length, "events");
    refreshEventSelect();
    applyFilters();
  } catch (err) {
    console.error("Failed to load events:", err);
    listEl.innerHTML = "<p>Could not load events.</p>";
  } finally {
    spinnerEl.style.display = "none";
  }
}

/* ------------------------------------------------------------ */
// Exercise 12: AJAX & Fetch API
// (a) POST registration to a mock API, with setTimeout to simulate delay
function submitRegistration(payload) {
  const msg = document.querySelector("#formMessage");
  msg.className = "msg";
  msg.textContent = "Submitting…";

  setTimeout(() => { // simulate network latency
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload)
    })
      .then(res => {
        if (!res.ok) throw new Error("Server error " + res.status);
        return res.json();
      })
      .then(data => {
        msg.className = "msg success";
        msg.textContent = `Registration successful! (ticket #${data.id}) for ${payload.name}`;
        form.reset();
      })
      .catch(err => {
        msg.className = "msg fail";
        msg.textContent = "Registration failed: " + err.message;
      });
  }, 600);
}

// (b) GET sample data and show in the results area
const resultsEl = document.querySelector("#results");
document.querySelector("#loadApiBtn").addEventListener("click", async () => {
  resultsEl.innerHTML = "<p><em>Loading from API…</em></p>";
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts?_limit=3");
    if (!res.ok) throw new Error("HTTP " + res.status);
    const posts = await res.json();
    resultsEl.innerHTML = posts
      .map(p => `<div class="event-card"><h3>${p.title}</h3><p>${p.body}</p></div>`)
      .join("");
  } catch (err) {
    resultsEl.innerHTML = `<p class="msg fail">Fetch failed: ${err.message}</p>`;
  }
});

/* ------------------------------------------------------------ */
// Kick everything off
loadWithThen();
initEvents();
