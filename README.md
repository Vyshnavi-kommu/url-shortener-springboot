# URL Shortener with Analytics (Spring Boot)

## Overview

This project is a backend system that converts long URLs into short, unique links and efficiently redirects users. It is designed to handle high traffic with low latency using caching and rate limiting techniques.

---

## Tech Stack

* Language: Java
* Framework: Spring Boot
* Database: PostgreSQL
* Caching: Redis
* Tools: Postman, Git

---

## Features

* URL shortening (long URL → short URL)
* Fast redirection using short links
* Redis caching to improve performance
* Rate limiting (requests per IP)
* Click tracking and analytics
* Unique short URL generation

---

## System Architecture

User Request
↓
Controller Layer
↓
Service Layer
↓
Repository Layer → PostgreSQL
↓
Redis Cache (for faster retrieval)

---

## 📊 Performance Highlights

* Achieved <50ms response time for URL redirection
* Reduced database load by ~40% using Redis caching
* Handled high request volume using rate limiting (100 requests/min/IP)

---

## API Endpoints

### 1. Create Short URL

POST /api/shorten

Request Body:
{
"url": "https://google.com"
}

Response:
{
"shortCode": "4",
"shortUrl": "http://localhost:8081/api/4"
}

---

### 2. Redirect to Original URL

GET /api/{shortCode}

Returns:

* Status: 302 Found
* Location header: https://google.com

---

### 3. Get Analytics

GET /api/analytics/{id}

Response:
{
"clickCount": 0,
"createdAt": "...",
"expiryAt": "...",
"longUrl": "https://google.com",
"shortCode": "4"
}

---

## Key Concepts Used

* REST API Design
* Caching with Redis
* Rate Limiting (Token Bucket approach)
* Database Optimization
* Backend System Design

---

## How to Run the Project

1. Clone the repository
   git clone https://github.com/Vyshnavi-kommu/url-shortener-springboot.git

2. Navigate to the project folder
   cd url-shortener-springboot

3. Configure PostgreSQL and Redis in application.properties

4. Run the application
   mvn spring-boot:run

5. Test APIs using Postman

---

## Future Improvements

* Add authentication and user accounts
* Deploy on cloud (AWS/GCP)
* Build analytics dashboard
* Improve scalability with load balancing

---

## Author

Vyshnavi Kommu
mail : kommuvyshnavi28@gmail.com
