# Module 1 — Bootstrap 5 (Local Community Event Portal)

A set of static HTML pages demonstrating **Bootstrap 5** (loaded via CDN, no build step).
Open any `.html` file directly in a browser — start with **`index.html`**.

## How to view
1. Open the folder `03-Bootstrap5`.
2. Double-click **`index.html`** (or right-click → Open with → your browser).
3. Use the navbar to move between pages.

## Files
| File | Purpose |
|------|---------|
| `index.html` | Main page: responsive navbar, hero, responsive 3-col event card grid, buttons, badges, social icons |
| `grid.html` | Grid layout exercises (3, 4, 5) |
| `components.html` | Flexbox (6), typography (7), forms (8), buttons (9), nav tabs/pills (10.2), cards & media (11) |
| `utilities.html` | Spacing (12), colors/bg (13), display/visibility (14), borders/shadows/rounded (15), positioning (16), icons (17) |
| `plugins.html` | Bootstrap JS plugins (18): modal, carousel, tooltip/popover, accordion |

## CDN links used
- CSS: `bootstrap@5.3.3/dist/css/bootstrap.min.css`
- JS:  `bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js` (bundle includes Popper)
- Icons: `bootstrap-icons@1.11.3/font/bootstrap-icons.css`

## Exercise coverage
| # | Exercise | Where |
|---|----------|-------|
| 1.1 | Link Bootstrap 5 via CDN | every page `<head>` |
| 1.2 | Project via npm / downloaded files | documented below |
| 2.1 | Bootstrap directory structure (css/js/icons) | documented below |
| 2.2 | Include `bootstrap.bundle.min.js` plugins | every page bottom |
| 3.1/3.2 | Responsive grid container/row/col | `index.html`, `grid.html` |
| 4.1 | Sidebar col-md-3 + content col-md-9 | `grid.html` |
| 4.2 | Four equal cols (col-sm-3) | `grid.html` |
| 5.1 | justify-content-center / align-items-center | `grid.html` |
| 5.2 | Reorder with order-md-* | `grid.html` |
| 6.1 | Flexbox navbar d-flex/flex-column/flex-md-row | `components.html` |
| 6.2 | justify-content-between / align-items-center card | `components.html` |
| 7.1 | Typography display-1/lead/text-muted/fw-bold | `components.html` |
| 7.2 | text-uppercase/lowercase/capitalize | `components.html` |
| 8.1 | Registration form (form-control/form-check/input-group) | `components.html` |
| 8.2 | Login form (form-floating) | `components.html` |
| 9.1 | Contextual buttons (incl. outline) | `components.html` |
| 9.2 | btn-group + toggle checkbox buttons | `components.html` |
| 10.1 | Responsive navbar w/ logo, links, search | every page (full on `index.html`) |
| 10.2 | nav-tabs / nav-pills | `components.html` |
| 11.1 | Profile card (card-img-top/card-body/card-title) | `components.html` |
| 11.2 | Media object (image left of content) | `components.html` |
| 12.1 | Spacing m-3/mt-4/p-2/py-5 | `utilities.html` |
| 12.2 | Pricing section spacing | `utilities.html` |
| 13.1 | Contextual bg + text colors dashboard | `utilities.html` |
| 13.2 | bg-gradient + bg-dark + white text | `utilities.html` |
| 14.1 | d-none / d-md-block / d-lg-flex | `utilities.html` |
| 14.2 | Tablet+ responsive sidebar | `utilities.html` |
| 15.1 | border/border-primary/border-3/rounded-circle | `utilities.html` |
| 15.2 | shadow/shadow-lg/rounded-pill | `utilities.html` |
| 16.1 | Fixed footer position-fixed bottom-0 | `utilities.html` |
| 16.2 | position-relative + position-absolute badge overlay | `utilities.html` |
| 17.1 | Social icons in footer | `utilities.html`, `index.html` |
| 17.2 | Icon-only buttons | `utilities.html` |
| 18.1 | Modal | `plugins.html` |
| 18.2 | Accordion (collapse) | `plugins.html` |
| (plugins) | Carousel + Tooltip + Popover | `plugins.html` |
| 19.1/19.2 | Sass customization | documented below |

---

## Exercise 1.2 — Project via npm / downloaded files (documentation)
This project intentionally uses the **CDN** so it runs with no build step. To instead use npm or downloaded files:

**Option A — npm**
```bash
npm init -y
npm install bootstrap@5.3.3 bootstrap-icons@1.11.3
```
Then reference the local copies in your HTML:
```html
<link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
<script src="node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
```

**Option B — downloaded files**
Download the compiled ZIP from https://getbootstrap.com/docs/5.3/getting-started/download/,
unzip into a `bootstrap/` folder, and link the files in `bootstrap/css/` and `bootstrap/js/`.

## Exercise 2.1 — Bootstrap directory structure
The compiled download contains:
```
bootstrap/
├── css/   → compiled stylesheets (bootstrap.min.css, bootstrap.css, *.map, *.rtl.css)
├── js/    → compiled scripts (bootstrap.bundle.min.js [+ Popper], bootstrap.min.js)
```
Bootstrap Icons ships separately:
```
bootstrap-icons/
├── font/  → bootstrap-icons.css + woff/woff2 font files
├── icons/ → individual .svg files
```
- **css/** — all the layout, component and utility styles.
- **js/** — interactive plugins (modal, dropdown, carousel, tooltip, etc.). `*.bundle.*` includes Popper.
- **icons (font/)** — the icon font + CSS so `<i class="bi bi-..."></i>` works.

## Exercise 2.2 — JavaScript plugins
Every page loads `bootstrap.bundle.min.js` just before `</body>`, enabling the navbar toggler,
modal, carousel, tabs, accordion, tooltip and popover plugins.

## Exercise 19 — Customization with Sass (documentation)
The CDN ships **compiled** CSS, so Sass overrides need the **source** package + a compiler.

**19.1 — Set up the Sass project**
```bash
npm install bootstrap@5.3.3 sass --save-dev
```

**19.2 — Customize primary color and border radius**
Create `scss/custom.scss`:
```scss
// 1) Your variable overrides come BEFORE importing Bootstrap
$primary:        #6f42c1;   // custom purple primary
$border-radius:  1rem;      // larger rounded corners

// 2) Import all of Bootstrap (functions + variables + the rest)
@import "node_modules/bootstrap/scss/bootstrap";
```
Compile it:
```bash
npx sass scss/custom.scss css/custom.css
```
Then link `css/custom.css` **instead of** the CDN CSS. All `btn-primary`, `bg-primary`,
borders, etc. will now use the new color and radius.
