# 🎯 Technical Event Management System (MVP)

A full-stack **Technical Event Management Application** built as an assessment project using:

- ⚙️ Spring Boot (Backend)
- ⚛️ React + Tailwind CSS (Frontend)
- 🗄️ PostgreSQL (Database)
- 🔐 JWT Authentication & Role-Based Access

The application follows a complete workflow-based architecture including Admin, Vendor, and User modules.

---

## 📌 Project Overview

This system allows:

- Admin management of users, vendors, and memberships
- Vendors to manage products and update order status
- Users to browse vendors, shop products, manage cart, checkout, and track orders

The implementation follows the provided flowchart and includes all major modules required for an MVP assessment.

---

## 🧱 Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT Authentication
- Lombok
- Hibernate

### Frontend
- React (Vite)
- React Router DOM
- Tailwind CSS
- Axios

### Database
- PostgreSQL

---

## 🧩 Application Modules

### 🔐 Authentication Module
- Admin Login
- Vendor Login
- User Login
- Vendor Signup
- User Signup
- JWT-based session handling
- Role-based authorization

---

### 🛠 Admin Module
- Admin Dashboard
- Maintenance Menu
- Add / Update Users
- Add / Update Vendors
- Membership Management
  - Add Membership
  - Extend Membership
  - Cancel Membership

---

### 🏪 Vendor Module
- Vendor Dashboard
- Add Products
- View / Update / Delete Products
- Product Status Management
- Update Order Status
  - RECEIVED
  - READY FOR SHIPPING
  - OUT FOR DELIVERY

---

### 👤 User Module
- User Dashboard
- Vendor Browsing by Category
- Product Browsing / Shop
- Guest List Management
- Order Tracking

---

### 🛒 Cart & Checkout
- Add to Cart
- Quantity Update
- Remove Item
- Delete All
- Checkout Form
- Payment Method Selection (Cash / UPI)
- Order Success Popup

---
