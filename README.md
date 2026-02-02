🚀 API Rate Limiting with Spring Boot, Redis & JWT

This project demonstrates API rate limiting using Spring Boot, Spring Security, JWT, and Redis.
Rate limiting is applied per user (JWT-based) with a fixed window strategy.

---------------------------------------------------------------------------------------------------------------------------------------

🛠 Tech Stack

Java 17

Spring Boot 3.x

Spring Security

JWT (JJWT)

Redis

Docker / Docker Desktop

Maven

Postman

---------------------------------------------------------------------------------------------------------------------------------------

📦 Features

JWT-based authentication

Redis-backed rate limiting

Per-user & per-endpoint limits

Servlet filter using OncePerRequestFilter

Clean and extensible architecture

---------------------------------------------------------------------------------------------------------------------------------------

📁 Project Structure (Important)

src/main/java

 ├── controller        → AuthController
 
 ├── security          → JwtUtil
 
 ├── filter            → RateLimitFilter
 
 ├── ratelimit         → RateLimitService
 
 └── config            → SecurityConfig

 ---------------------------------------------------------------------------------------------------------------------------------------

 🔽 Clone the Repository

```
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
```

 ---------------------------------------------------------------------------------------------------------------------------------------

🐳 Prerequisite: Docker Desktop

Make sure Docker Desktop is installed and running.

👉 Download: https://www.docker.com/products/docker-desktop/

Verify:
```
docker --version
```
 ---------------------------------------------------------------------------------------------------------------------------------------

🧠 Start Redis using Docker

Run Redis container:
```
docker run -d \
  --name redis-rate-limit \
  -p 6379:6379 \
  redis
```

Verify Redis is running:
```
docker ps
```
 ---------------------------------------------------------------------------------------------------------------------------------------
 
⚙️ Application Configuration
application.properties

```
spring.main.web-application-type=servlet

spring.redis.host=localhost
spring.redis.port=6379
```

 ---------------------------------------------------------------------------------------------------------------------------------------

▶️ Run the Application

Using Maven:
```
mvn clean spring-boot:run
```

Or from IDE:

```
Run ApiRateLimitingApplication.java
```
 ---------------------------------------------------------------------------------------------------------------------------------------

🔐 API Endpoints
1️⃣ Login (Generate JWT)
POST
```
http://localhost:8080/auth/login
```
Body
```
{
  "username": "user1",
  "password": "password123"
}
```
✅ Response:
```
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```
 ---------------------------------------------------------------------------------------------------------------------------------------

❌ Rate Limit Exceeded Response

After 5 requests:
```
HTTP 429 Too Many Requests
```
 ---------------------------------------------------------------------------------------------------------------------------------------

🧠 Important Notes

JWT secret is generated at runtime (tokens reset on restart)

Redis must be running before starting the app

Rate limiting is applied before controller execution
 ---------------------------------------------------------------------------------------------------------------------------------------

🚀 Future Improvements

Sliding window / token bucket algorithm

Role-based rate limits

Rate-limit response headers

Distributed gateway-based rate limiting

 ---------------------------------------------------------------------------------------------------------------------------------------

👨‍💻 Author

Jaspreet Singh
Backend Developer | Java | Spring Boot | Redis

Refresh tokens
