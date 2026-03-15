# API Testing Fundamentals Project

## Overview

This project is part of my learning journey in **API testing and automation**.

The goal of the project is to practice and understand the fundamentals of testing REST APIs using Java and modern testing tools.

The project focuses on testing the **INV.BG API** and validating different operations such as retrieving and updating firm information.

## Technologies Used

* Java
* RestAssured
* JUnit 5
* Maven

## What This Project Demonstrates

* Building a simple API testing framework
* Working with HTTP methods (GET, PATCH, PUT, DELETE)
* Creating DTO objects for request bodies
* Extracting and validating response data
* Using assertions to verify API behavior
* Understanding API response codes (200, 204, 400, etc.)
* Structuring tests in a clean and maintainable way

## Learning Approach

During the development of this project I used AI tools to **assist my learning**, but I follow a strict rule:

1. I first ask for an **explanation of the concept**.
2. I try to **implement the solution myself**.
3. If I cannot solve the problem, I ask **why it works that way**.
4. Only after understanding the concept do I **rewrite the code myself**, instead of copy-pasting.

This approach helps me focus on **understanding the principles of API testing**, not just producing code.

## Project Structure

```
src
 ├── api
 │   ├── base
 │   ├── clients
 │   └── utils
 ├── dto
 └── test
```

* **BaseService** – common HTTP methods
* **FirmClient** – API client for firm endpoints
* **DTO classes** – request body models
* **Tests** – API validation tests

## Example Tests

The project includes tests for:

* Retrieving firm information
* Updating firm data
* Validating API responses
* Handling API validation errors

## Purpose

This project is intended for **learning and practicing API automation testing fundamentals** and building a **QA portfolio project**.

