# Module 1 — JavaScript (Local Community Event Portal)

A single-page Community Event Portal demonstrating JavaScript exercises 1–14.
**No build step** — everything runs directly in the browser.

## How to view
1. Open the folder `04-JavaScript`.
2. Double-click **`index.html`** (or right-click → Open with → your browser).
3. Open **DevTools → Console** to see the `console.log` output from the exercises.
4. For Exercise 14, open **`jquery-demo.html`**.

> Note: on load the page shows an `alert` ("Page fully loaded") — that is Exercise 1.

## Files
| File | Purpose |
|------|---------|
| `index.html` | Portal page: event list, registration form, category/location filters, results area |
| `main.js` | Implements Exercises 1–12 (each labeled with `// Exercise N: Title`) |
| `jquery-demo.html` | Exercise 14 — jQuery `.click()`, `.fadeIn()`, `.fadeOut()` |

## Exercise coverage
| # | Exercise | Where |
|---|----------|-------|
| 1 | Basics & setup (script tag, console.log, load alert) | `main.js` top + `index.html` |
| 2 | Syntax, data types, operators (const/let, template literals, ++/--) | `main.js` |
| 3 | Conditionals, loops, error handling (if-else, forEach, try-catch) | `main.js` `getDisplayableEvents()` |
| 4 | Functions, scope, closures, HOF (addEvent/registerUser/filterEventsByCategory) | `main.js` |
| 5 | Objects & prototypes (`CommunityEvent` class, `checkAvailability`, `Object.entries`) | `main.js` |
| 6 | Arrays & methods (push/filter/map/reduce) | `main.js` |
| 7 | DOM manipulation (querySelector, createElement, append) | `main.js` `renderEvents()` |
| 8 | Event handling (onclick, onchange, keydown) | `main.js` filters + register |
| 9 | Async/promises/async-await + loading spinner | `main.js` `fetchEventsFromMockApi`/`initEvents` |
| 10 | Modern JS (let/const, default params, destructuring, spread, arrow) | `main.js` |
| 11 | Forms (form.elements, preventDefault, inline validation) | `main.js` form submit |
| 12 | AJAX & Fetch API (POST + GET to jsonplaceholder, setTimeout) | `main.js` |
| 13 | Debugging & testing | documented below |
| 14 | jQuery & frameworks | `jquery-demo.html` + notes below |

> `Object.entries()` (Exercise 5 requirement) is demonstrated in the console — run
> `Object.entries(communityEvents[0])` in DevTools to list an event's keys and values.

---

## Exercise 13 — Debugging and Testing (notes)
The scenario: *"Registration is failing silently."* How to debug with Chrome DevTools:

1. **Console tab** — read errors and the `console.log`/`console.warn` traces already
   emitted by `main.js` (e.g. "Hidden (past/full)", registration counts).
2. **Network tab** — watch the `POST https://jsonplaceholder.typicode.com/posts`
   request when you submit the form. Inspect:
   - **Status** (200/201 = success).
   - **Payload** — confirm `name`, `email`, `event` were sent as JSON.
   - **Response** — the returned object (with an `id`).
3. **Breakpoints (Sources tab)** — set a breakpoint inside `submitRegistration()` and
   step through (F10/F11) to inspect the `payload` variable before it is sent.
4. **Logging submission steps** — add temporary `console.log("step:", payload)` lines,
   or use **Logpoints** (right-click a line number → Add logpoint) to avoid editing code.
5. **Common silent-failure causes**: form `preventDefault()` missing, a thrown error
   swallowed by `.catch`, or a typo in an element selector returning `null`.

**Testing idea:** pure functions like `capitalize`, `formatEvent`, `getValidUpcomingEvents`
and `filterEventsByCategory` are easy to unit-test (e.g. with Jest):
```js
expect(capitalize("music")).toBe("Music");
```

## Exercise 14 — jQuery and JS Frameworks (notes)
See **`jquery-demo.html`** for a working example using:
- `$('#registerBtn').click(...)` to handle clicks
- `.fadeIn()` / `.fadeOut()` to animate an event card

**One benefit of moving to a framework (React/Vue):** frameworks provide a
**declarative, component-based, reactive UI** — you describe *what* the UI should look
like for a given state and the framework efficiently updates the DOM (via a virtual DOM)
when state changes. This removes the manual, error-prone DOM updates (the `createElement`/
`innerHTML` juggling in `main.js`) and makes large apps far easier to maintain, test and scale.
