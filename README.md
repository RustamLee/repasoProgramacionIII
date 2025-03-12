# Video Game Library Management System (11/03/2025)

## Overview
This project is an exercise from the Programming-3 course at UTN University, aimed at reviewing concepts from Programming-2.

### Topics Reviewed:
- Interfaces
- Abstract Classes
- Generics
- Collections
- Packages
- User Interface (Menu)

## Objective
Develop a system for managing a video game library, prioritizing flexibility for future types of media.

## Key Principles
- **Interface-Oriented Programming**: Manipulate objects through interfaces.
- **Generic Repositories**: Manage persistence and data access with repositories.

## Scenario
You have been hired by a client to develop software for managing their video game collections, including both games and expansions.

## Functional Requirements

### Entity Definitions
- **Entities**: Games and Expansions.
- **Attributes**:
  - Title, Creator, Genre, Unique Identifier.
  - Game: Version number.
  - Expansion: Release date.
  
### Data Validation
- Ensure unique identifiers are not duplicated (throw `IdentificadorDuplicadoException` if they are).
- Validate:
  - Game version is positive.
  - Expansion release date is not null.

### Collection Management Operations
1. Add a new game or expansion.
2. Remove an object by its identifier.
3. Display all objects sorted by title.
4. Filter objects by genre.
5. Modify a single attribute of an object.

### User Interaction
- Create a class for menu handling and user interaction.
- Include proper validations and exception handling.

## Project Organization
Organize classes into packages:
- **model/**: Entity definitions (interfaces & implementations).
- **exceptions/**: Custom exceptions.
- **ui/**: User interface logic (menu).
- **repositories/**: Generic repositories (interfaces & implementations).
- `Main.java`: Main entry point outside any package.

## OOP Principles
Apply OOP concepts:
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction

### Best Practices
- Write modular, clean, and well-documented code.
- Follow best practices in exception handling and collection management.
