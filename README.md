# 🛒 Composite Catalog Manager

This project is a web application that implements the **Composite Design Pattern** to model and manage a hierarchical catalog for an online store. Users can add and remove product groups and products, each uniquely identified by a hierarchical code. The structure is persisted to and read from XML files, supporting flexible and scalable data organization.

## ✨ Features

- 🌳 **Composite Pattern** implementation for nested category/product structure
- 💾 **XML Persistence** using XStream and DOM parsers
- 📂 Add/remove groups (categories) and products via a web interface
- 📊 Dynamic tree-like catalog management
- 🧪 Supports save/load operations for XML catalogs
- 🔍 View the entire catalog hierarchy
- 🛠 Built with Java + Spring MVC

## 🧩 Composite Design Pattern Roles

- `IComponent` – Interface for common operations
- `Node` – Composite class representing product groups (categories)
- `Product` – Leaf class representing individual products
- `Manager` – Root controller handling tree operations and XML I/O
- `CatalogController` – Spring MVC controller for web interaction

## 🔧 Technologies Used

- **Java 17+**
- **Spring MVC**
- **XStream** – for XML serialization
- **DOM Parser** – for XML parsing
- **Thymeleaf** – (if frontend is included)
- **Lombok** – for boilerplate code reduction

