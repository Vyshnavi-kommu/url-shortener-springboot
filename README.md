# Scalable URL Shortener with Analytics

A production-oriented backend system that generates short URLs and handles high-volume redirection efficiently using caching, rate limiting, and optimized database access. Built with Spring Boot, PostgreSQL, and Redis, this project demonstrates real-world backend engineering principles focused on performance, scalability, and system reliability.

---

## Key Highlights

- Achieved low-latency redirection using Redis caching (cache-aside pattern)  
- Reduced database load significantly by serving repeated requests from cache  
- Implemented rate limiting (100 requests/min/IP) to handle high traffic safely  
- Designed analytics tracking for monitoring URL usage  
- Integrated expiry mechanism to manage data lifecycle  
- Used Base62 encoding for compact, scalable short URL generation  

---

## Tech Stack

Java, Spring Boot, PostgreSQL, Redis, Maven  

---

## System Design Overview

Client → Controller → Service → Redis Cache → Database  

Flow:  
Request → Check Redis → If miss → Fetch DB → Store in Redis → Return response  

---

## API Endpoints

Create Short URL  
POST /api/shorten  

Request:
{
  "url": "https://google.com"
}

Response:
b

---

Redirect  
GET /api/{code}  

Example:
http://localhost:8081/api/b  

Returns HTTP 302 redirect to the original URL  

---

Analytics  
GET /api/analytics/{code}  

Provides original URL, click count, creation time, and expiry  

---

## Performance Optimizations

- Cache-aside pattern reduces database calls  
- O(1) lookup using indexed short codes  
- Redis ensures faster response for frequently accessed URLs  

---

## Rate Limiting

- Implemented using Redis counters  
- Limits each IP to 100 requests per minute  
- Prevents system abuse and overload  

---

## Expiry Handling

- Each URL has a defined expiration time  
- Expired URLs are blocked at service level  

---

## Setup

1. Start PostgreSQL and Redis  
2. Create database: createdb urlshortener  
3. Configure database credentials in application.properties  
4. Run application: mvn spring-boot:run  

---

## Testing

POST /api/shorten  
GET /api/{code}  
GET /api/analytics/{code}  

---

## Project Structure

src/main/java/com/example/demo  
controller  
service  
repository  
model  

---

## Why This Project Stands Out

- Demonstrates backend system design beyond CRUD applications  
- Incorporates caching, rate limiting, and performance optimization  
- Designed with scalability and real-world use cases in mind  
- Reflects strong understanding of distributed system fundamentals  

---

## Author

Vyshnavi Kommu  
Email: kommuvyshnavi28@gmail.com
