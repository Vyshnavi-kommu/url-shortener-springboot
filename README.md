# url-shortener-springboot
# Scalable URL Shortener with Analytics

## Overview
A backend system built using Spring Boot that generates short URLs, handles redirection, and optimizes performance using Redis caching and rate limiting.

---

## Tech Stack
- Java
- Spring Boot
- PostgreSQL
- Redis

---

## Features
- URL shortening and redirection
- Redis caching (cache-aside pattern)
- Rate limiting (100 requests/min/IP)
- Click tracking and analytics

---

## System Design
- Cache-aside pattern for fast reads
- Indexed database for efficient lookup
- Fixed window rate limiting using Redis

---

## How to Run
1. Start PostgreSQL and Redis
2. Run Spring Boot application
3. Use:
   - POST /shorten
   - GET /{shortCode}

---

## Performance
- <50ms response time for cached requests
- Reduced DB load using Redis caching
