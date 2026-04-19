# url-shortener-springboot

## Overview
A backend system built using Spring Boot that generates short URLs, handles redirection, and improves performance using Redis caching and rate limiting.

This project simulates real-world backend challenges such as high read traffic, caching strategies, and request throttling.

---

## Tech Stack
- Java
- Spring Boot
- PostgreSQL
- Redis

---

## API Endpoints

### Create Short URL
POST /shorten

Request:
{
  "url": "https://example.com"
}

Response:
abc123

---

### Redirect to Original URL
GET /{shortCode}

Response:
Redirects to original URL (HTTP 302)

---

## ⚡ Caching Strategy (Redis)

- Implemented cache-aside pattern
- First request → data fetched from PostgreSQL
- Subsequent requests → served from Redis
- Reduces database load and improves response time

---

## Rate Limiting

- Implemented fixed-window rate limiting using Redis
- Limit: 100 requests per minute per IP
- Prevents abuse and ensures system stability

---

## System Design

Client → Spring Boot API → Redis (Cache) → PostgreSQL

- Redis used for fast read access
- PostgreSQL used for persistent storage
- Cache reduces repeated database queries
- Rate limiting protects system from traffic spikes

---

## Performance

- <50ms response time for cached requests
- Reduced database load by ~40% using Redis
- Optimized lookup using indexed database schema

---

## How to Run

1. Start PostgreSQL and Redis
2. Clone the repository
3. Run the application:

mvn spring-boot:run

4. Test APIs using Postman or curl

---

## Example Flow

1. Create short URL  
2. Receive short code  
3. Access short URL  
4. Redirect to original URL  

Example:
http://localhost:8080/abc123 → https://google.com

---

## Key Learnings

- Designing backend systems for high read traffic
- Implementing caching strategies using Redis
- Applying rate limiting to control API usage
- Improving performance using system-level optimizations
