# Swipezy

Swipezy is a modern, scalable Tinder clone application designed for seamless user experiences in discovering and connecting with people. Built with a robust microservices architecture, Swipezy leverages cutting-edge technologies such as Spring Boot, React (TypeScript), MongoDB, JWT, AWS, Docker, Kafka, and CI/CD with GitHub Actions.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Architecture](#architecture)  
- [Getting Started](#getting-started)  
- [Environment Variables](#environment-variables)  
- [Running the Application](#running-the-application)  
- [Testing](#testing)  
- [Deployment](#deployment)  
- [Contributing](#contributing)  
- [License](#license)

---

## Features

- Swipe-based matching system  
- User authentication & authorization with JWT  
- Real-time notifications using Kafka  
- Highly scalable microservices architecture  
- Responsive React frontend with TypeScript  
- Persistent data storage with MongoDB  
- Dockerized services for easy deployment  
- Continuous Integration and Deployment with GitHub Actions  
- Cloud hosting on AWS  

---

## Tech Stack

| Layer               | Technology                         |
|---------------------|----------------------------------|
| Backend             | Spring Boot, Java, JUnit          |
| Frontend            | React, TypeScript, Redux (optional) |
| Database            | MongoDB                          |
| Messaging           | Apache Kafka                     |
| Authentication      | JWT (JSON Web Tokens)            |
| Containerization    | Docker                          |
| Cloud Hosting       | AWS                             |
| CI/CD               | GitHub Actions                   |
| Other               | Microservices architecture       |

---

## Architecture

Swipezy follows a microservices architecture with loosely coupled services communicating via REST APIs and Kafka for asynchronous messaging and event streaming. Each service is containerized using Docker to ensure consistency and ease of deployment.

---

## Getting Started

### Prerequisites

- Java 17+  
- Node.js 22+  
- Docker & Docker Compose  
- MongoDB (local or cloud)  
- Kafka (local or cloud)  
- AWS account (for deployment)  
- GitHub account (for CI/CD)

### Clone the repository

```bash
git clone https://github.com/saurabhjojare/Tinder-Clone.git
cd swipezy
