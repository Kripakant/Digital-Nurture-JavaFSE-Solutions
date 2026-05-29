# Module 1 — Frontend · CSS3 Section

**Theme:** Styling the *Local Community Event Portal*

A single, fully-styled page (`index.html` + `styles.css`) that demonstrates every CSS3
concept from Module 1: the three CSS inclusion methods, selectors, color & background
theming, typography, link/list styling, tables, the box model, multi-column text, and
responsive media queries.

## How to View

No build step required. Open **`index.html`** in Chrome (or any modern browser):

- Double-click `index.html`, **or**
- Right-click → *Open with* → your browser.

`styles.css` loads automatically (linked in the `<head>`). Resize the window below
768px to see the responsive layout kick in.

## Files

- `index.html` — the styled portal page. Contains the **inline style** (red heading)
  and the **internal `<style>`** block (body background) required by Exercise 1; all
  other styles are linked from the external stylesheet.
- `styles.css` — well-commented external stylesheet with `/* Exercise N: ... */`
  headers throughout.

## Exercises Covered

| #  | Exercise                                  | Where Implemented                                            |
|----|-------------------------------------------|--------------------------------------------------------------|
| 1  | Inline vs. Internal vs. External CSS      | `index.html` inline red `<h1>`, internal `<style>` body bg, external `styles.css`; CSS section comments |
| 2  | CSS Syntax and Comments                   | `styles.css` — formatted rules, descriptive comments, `.cta-button` example |
| 3  | Selectors Playground                      | `styles.css` — `*`, `h2`, `#mainHeader`, `.eventCard`, grouped `h3, p` |
| 4  | Color & Background Styling                | `styles.css` — HEX + RGBA, body background image w/ fallback, `linear-gradient` headers |
| 5  | Typography: Fonts and Text                | `@import` + `<link>` Google Font (Poppins); `font-family/size/style/weight`; `text-align`, `text-transform`, `letter-spacing`, `line-height` |
| 6  | Link and List Styling                     | `:link/:visited/:hover/:active`; `list-style-type`/`position`; bullet-free nav; item padding/margin |
| 7  | Table Styling                             | `.events-table` borders, padding, header bg, `nth-child(even)` zebra, `border-collapse`, centered text |
| 8  | Box Model & Layout Control                | `.eventCard` border/padding/margin; focus `outline` on form fields; `visibility:hidden` vs `display:none` demo |
| 9  | Multiple Columns in Text                  | `.bulletin` — `column-count`, `column-gap`, `column-rule` |
| 10 | Responsive Web Design with Media Queries  | `@media (max-width:768px)` — vertical nav, smaller fonts/images, `%`/`vw` units; Flexbox card layout (bonus) |
| 11 | Debug and Test with DevTools & VS Code    | See **DevTools Notes** below |

## DevTools Notes (Exercise 11 — Debug and Test)

Open DevTools with **F12** or `Ctrl+Shift+I`.

1. **Device toolbar (responsive testing)**
   - Click the **Toggle device toolbar** icon (`Ctrl+Shift+M`).
   - Select *iPhone*, *iPad*, or set a custom width below **768px** and confirm the
     navigation stacks vertically, fonts shrink, and cards become full-width.

2. **Inspect & test styles live**
   - Right-click the banner → **Inspect**. In the **Styles** pane, toggle/edit
     properties (e.g. change `#mainHeader` `background`) and watch the page update.
   - Use the box-model diagram in the **Computed** tab to see margin/padding/border of
     `.eventCard`.

3. **Network tab (confirm CSS loads)**
   - Open the **Network** tab and reload. Confirm `styles.css` appears with status
     `200` and the Google Fonts request succeeds. Filter by **CSS** to isolate it.

4. **VS Code** — use the built-in linting, Emmet, and the *Live Server* extension to
   preview changes instantly while editing `styles.css`.
