# Module 1 — Frontend · HTML5 Section

**Theme:** Local Community Event Portal

A lightweight, browser-based portal that lets residents register for events, check
locations, leave feedback, and access basic services. Built with semantic, valid HTML5.

## How to View

No build step required. Open **`index.html`** in Chrome (or any modern browser):

- Double-click `index.html`, **or**
- Right-click → *Open with* → your browser.

Use the navigation bar to reach every page. (Geolocation and `localStorage` work best
when served over `http://localhost` or `file://`; modern browsers allow geolocation on
`file://` after you grant permission.)

## Exercises Covered

| #  | Exercise                                  | Where Implemented                                   |
|----|-------------------------------------------|-----------------------------------------------------|
| 1  | HTML5 Base Template                       | `index.html` (DOCTYPE, `lang`, `charset`, section comments) |
| 2  | Navigation and Linking                    | `index.html` `<nav>` + `#home/#events/#contact` IDs, external `help.html` via `target="_blank"` |
| 3  | Welcome Message with Styling & ID/Class   | `index.html` `#welcomeBanner` (internal CSS), inline-styled `<span>`, `.highlight` class |
| 4  | Image Gallery for Community Events         | `index.html` `<table>` 2×3 of `<img>` with `alt`, `title`, bordered class, captions |
| 5  | Event Registration Form                   | `register.html` (text/email/date/select/textarea, `placeholder`, `required`, `autofocus`, `<output>`) |
| 6  | Event Feedback with Events Handling       | `feedback.html` (`onblur`, `onchange`, `onclick`, `ondblclick`, key events + char count) |
| 7  | Video Invite with Media Events            | `media.html` (`<video>` + `oncanplay`, `onbeforeunload`) |
| 8  | Saving User Preferences                   | `preferences.html` (`localStorage` save/restore, clear `localStorage` + `sessionStorage`) |
| 9  | Geolocation for Event Mapping             | `map.html` (`getCurrentPosition`, error handling, high-accuracy options) |
| 10 | Debugging with Chrome DevTools            | See **DevTools Notes** below |

## Files

- `index.html` — base template, navigation, welcome banner, image gallery (Ex 1–4)
- `help.html` — external help document opened in a new tab (Ex 2)
- `register.html` — registration form (Ex 5)
- `feedback.html` — feedback + event handling (Ex 6)
- `media.html` — promo video + media events (Ex 7)
- `preferences.html` — localStorage preferences (Ex 8)
- `map.html` — geolocation (Ex 9)

## DevTools Notes (Exercise 10 — Debugging with Chrome DevTools)

Open DevTools with **F12** or `Ctrl+Shift+I`.

1. **Inspect Element / live style edits**
   - Right-click any element (e.g. the welcome banner on `index.html`) → **Inspect**.
   - In the **Elements** panel, edit the `Styles` pane live — change the `background`
     of `#welcomeBanner` and watch the page update instantly.

2. **Console logs**
   - Open the **Console** tab.
   - On `feedback.html`, click **Submit Feedback** — you'll see the
     `console.log('Feedback submitted at …')` message appear.

3. **Breakpoints & watching variables**
   - Open the **Sources** tab and select the inline script of `map.html`.
   - Click the line number inside `onSuccess()` to set a breakpoint, then click
     **Find Nearby Events** and reload.
   - Execution pauses; hover over `position`, `latitude`, `longitude` or use the
     **Scope**/**Watch** panes to inspect their values, then **Step over** (F10).

4. **Network tab** — reload with the Network tab open to confirm each page and its
   image/video resources load (status `200`).
