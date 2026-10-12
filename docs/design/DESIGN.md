---
name: Warm Culinary Modern
colors:
  surface: '#fff8f5'
  surface-dim: '#e9d7c8'
  surface-bright: '#fff8f5'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#fff1e8'
  surface-container: '#feeadc'
  surface-container-high: '#f8e5d6'
  surface-container-highest: '#f2dfd1'
  on-surface: '#231a11'
  on-surface-variant: '#5a4138'
  inverse-surface: '#392e25'
  inverse-on-surface: '#ffeee1'
  outline: '#8e7166'
  outline-variant: '#e2bfb2'
  surface-tint: '#a63b00'
  primary: '#a23a00'
  on-primary: '#ffffff'
  primary-container: '#cb4a00'
  on-primary-container: '#fffbff'
  inverse-primary: '#ffb598'
  secondary: '#2e6a3e'
  on-secondary: '#ffffff'
  secondary-container: '#b1f2ba'
  on-secondary-container: '#347044'
  tertiary: '#005da8'
  on-tertiary: '#ffffff'
  tertiary-container: '#0076d2'
  on-tertiary-container: '#fdfcff'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#ffdbce'
  primary-fixed-dim: '#ffb598'
  on-primary-fixed: '#370e00'
  on-primary-fixed-variant: '#7f2b00'
  secondary-fixed: '#b1f2ba'
  secondary-fixed-dim: '#96d5a0'
  on-secondary-fixed: '#00210b'
  on-secondary-fixed-variant: '#125128'
  tertiary-fixed: '#d4e3ff'
  tertiary-fixed-dim: '#a4c9ff'
  on-tertiary-fixed: '#001c39'
  on-tertiary-fixed-variant: '#004883'
  background: '#fff8f5'
  on-background: '#231a11'
  surface-variant: '#f2dfd1'
typography:
  display-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 40px
    fontWeight: '700'
    lineHeight: 48px
    letterSpacing: -0.02em
  display-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: -0.01em
  headline-lg:
    fontFamily: Plus Jakarta Sans
    fontSize: 28px
    fontWeight: '700'
    lineHeight: 36px
    letterSpacing: -0.01em
  headline-lg-mobile:
    fontFamily: Plus Jakarta Sans
    fontSize: 24px
    fontWeight: '700'
    lineHeight: 32px
  headline-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 22px
    fontWeight: '600'
    lineHeight: 28px
  headline-sm:
    fontFamily: Plus Jakarta Sans
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 24px
  title-md:
    fontFamily: Plus Jakarta Sans
    fontSize: 16px
    fontWeight: '600'
    lineHeight: 22px
  body-lg:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  body-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
  body-sm:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '400'
    lineHeight: 16px
  label-lg:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.01em
  label-md:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '600'
    lineHeight: 16px
    letterSpacing: 0.02em
  label-sm:
    fontFamily: Inter
    fontSize: 10px
    fontWeight: '600'
    lineHeight: 14px
    letterSpacing: 0.04em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1rem
  gutter-tablet: 1.5rem
  gutter-desktop: 2rem
  margin: 1rem
  margin-tablet: 2rem
  margin-desktop: 3rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2rem
---

## Brand & Style

The design system projects warmth, culinary delight, and functional clarity. Designed primarily for mobile-first culinary exploration, it captures an appetizing, inviting kitchen ambiance through soft, food-inspired neutrals, balanced geometric warmth, and modern Material 3 expressive sensibilities.

The visual style blends modern tactile warmth with clean utilitarian clarity. Displays and titles feature approachable, open geometric typography, while recipes, ingredients, and instructions rely on highly legible neutral typography. Surfaces evoke natural ceramics and parchment, grounded by warm drop shadows and subtle tonal layering rather than harsh digital borders.

## Colors

The color system centers around comforting warmth and natural freshness:
- **Primary (`#E8590C`)**: A roasted citrus and terracotta hue driving call-to-actions, active indicators, and high-visibility touchpoints.
- **Secondary (`#2F6B3F`)**: An herbaceous deep botanical green applied to dietary tags, healthy filter chips, success confirmations, and prep indicators.
- **Neutrals & Surfaces (Light Mode)**: Canvas begins at creamy off-white (`#FFF8F1`), elevated by crisp white surface cards (`#FFFFFF`) and warm cream container tiers (`#FDF2E7`). Typography establishes high legibility using deep espresso dark brown (`#2B2118`) for headings and body, alongside warm taupe (`#6C5D53`) for secondary metadata and icons. Outlines use soft dough-toned borders (`#EBDCCF`).
- **Dark Mode Support**: Deep charcoal-espresso canvas (`#1A1412`), roasted chestnut surfaces (`#241C18`), container layers (`#2F2520`), bone white high-contrast text (`#F5EBE1`), warm muted stone secondary copy (`#B8A99E`), and cocoa outline accents (`#3D312A`).

## Typography

Typography balances appetite-stimulating friendliness with utilitarian culinary precision.
- **Headlines & Titles (`Plus Jakarta Sans`)**: Soft, geometric curves evoke modern editorial cookbooks. Used for recipe titles, section headers, hero callouts, and numerical cook times.
- **Body & Labels (`Inter`)**: Engineered for absolute legibility in step-by-step cooking flows, dense ingredient lists, nutrition stats, and metadata labels.
- **Hierarchy Rules**: Recipe titles on cards use `headline-sm` or `title-md`. Ingredient quantities prioritize medium weights for immediate scanning in busy environments.

## Layout & Spacing

The layout follows a mobile-first, generous spacing rhythm based on an 8pt system (with 4pt micro-steps for compact badges).
- **Mobile Grid**: 4 columns, `margin: 1rem` (16px), `gutter: 1rem` (16px). Content prioritizes vertical stack flows and horizontal scroll carousels for tag filters and recipe feeds.
- **Tablet / Large Mobile**: 8 columns, `margin: 2rem` (32px), `gutter: 1.5rem` (24px) accommodating dual-pane recipe inspection (ingredients on left, instructions on right).
- **Desktop / Web**: 12 columns, max-width 1280px centered container, `margin: 3rem` (48px).
- **Rhythm**: Generous internal component padding prevents crowded touch targets while fingers may be wet or busy cooking. Card padding standardizes on `space-md` (16px) or `space-lg` (24px).

## Elevation & Depth

Visual depth combines warm-tinted ambient shadows with Material 3 surface containers. Rather than harsh black drop shadows, shadows are tinted with deep umber (`rgba(43, 33, 24, 0.08)`) to maintain the sunny, organic culinary atmosphere.

- **Level 0 (Flat)**: Background canvas (`#FFF8F1`). Unselected tabs, input backdrops.
- **Level 1 (Card Default)**: Recipe cards, list items, search bars. Shadow: `0px 2px 8px -2px rgba(43, 33, 24, 0.06), 0px 1px 3px 0px rgba(43, 33, 24, 0.04)`. Outlined optionally with 1px `#EBDCCF` at 60% opacity.
- **Level 2 (Active / Hover / Filter Chips Active)**: Interactive cards on press/drag, elevated chips, dropdown sheets. Shadow: `0px 4px 16px -4px rgba(43, 33, 24, 0.10), 0px 2px 6px -1px rgba(43, 33, 24, 0.06)`.
- **Level 3 (Floating Controls / Modals)**: Bottom navigation bar, floating action timer, persistent ingredient tray. Shadow: `0px 8px 24px -6px rgba(43, 33, 24, 0.12), 0px 4px 12px -2px rgba(43, 33, 24, 0.08)`.

## Shapes

The design system employs a friendly, ergonomic shape architecture rooted in an intentional 16px (`rounded-lg` / `1rem`) foundation for core containers:
- **Base Elements (Buttons, Inputs, Standard Containers)**: 8px to 12px border radius.
- **Cards, Recipe Tiles, Bottom Sheets, Search Bars**: 16px (`rounded-lg` = 1rem), creating a smooth, handheld feel reminiscent of smooth ceramic dishes.
- **Full Pill (`9999px`)**: Interactive tags, Material 3 filter chips, star rating badges, toggle switches, and primary floating action buttons.

## Components

### Buttons & Toggle Pills
- **Primary Button**: Solid warm orange (`#E8590C`) with white text, minimum height 48px, rounded 12px or pill-shaped for floating actions. Focus and pressed states deepen into `#CC4A04`.
- **Secondary / Ghost Button**: Cream container tint (`#FDF2E7`) with `#E8590C` text or subtle `#EBDCCF` border.
- **Segmented Switches & Toggle Pills**: Housed within a `#FDF2E7` pill container. The active indicator transitions with a crisp white elevated pill card (`#FFFFFF`) with Level 1 shadow and espresso text.

### Search Bar
- Floating rounded container (16px radius) filled with `#FFFFFF` or `#FDF2E7`, featuring a leading terracotta magnifying glass icon and trailing filter configuration action. Outlined with 1px `#EBDCCF`. Height: 52px.

### Material 3 Chips & Badges
- **Filter Chips**: Pill shape (`rounded-full`), 32px height, 12px horizontal padding. Unselected: `#FFFFFF` or `#FDF2E7` background with `#6C5D53` text. Selected: `#E8590C` background with `#FFFFFF` text or `#2F6B3F` for dietary/green badges.
- **Difficulty Badges**: Mini capsule (`rounded-full`, 24px height, 8px padding), utilizing deep green tints for "Easy", warm amber for "Medium", and deep terracotta for "Advanced".
- **Star Ratings**: Compact pill pairing a warm golden-orange star icon (`#F59F00`) with semibold espresso numeric rating copy.

### Recipe Cards
- White surface (`#FFFFFF`) featuring 16px corner radius, overflowing food photography top-docked with an aspect ratio of 4:3 or 16:9, layered with a floating bookmark pill.
- Body area contains recipe title in `Plus Jakarta Sans`, preparation time metadata, difficulty pill badge, and star rating. 16px internal padding. Level 1 ambient warm shadow.

### Bottom Navigation Bar
- Docked bottom bar with 16px top border radii or floating capsule offset by 16px margins. Surface: `#FFFFFF` with Level 3 ambient shadow. Active destination highlighted using pill-shaped terracotta tinted backgrounds (`#FDF2E7`) and `#E8590C` icons.

### Form Inputs & Checkboxes
- **Input Fields**: 48px height, 12px radius, cream surface `#FDF2E7` with 1px `#EBDCCF` border, shifting to `#E8590C` border on focus.
- **Ingredient Checklist**: 22px rounded checkboxes (6px radius) transitioning from `#EBDCCF` outline to solid `#2F6B3F` fill with white checkmark upon completion, automatically dimming the recipe text to indicate completed steps.