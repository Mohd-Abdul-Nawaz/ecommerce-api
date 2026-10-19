# E-Commerce REST API

A scalable e-commerce backend API built with Java, Spring Boot, PostgreSQL, and Redis — part of the Enterpret Backend SDE Intern portfolio.

## 🚀 Quick Start

### Docker (Recommended)
```bash
docker-compose up --build
```
API available at `http://localhost:8080`

### Local Java
```bash
# Start dependencies
docker-compose up -d postgres redis

# Build and run
./mvnw spring-boot:run
```

## 📖 API Endpoints

### Products
```http
GET    /api/products                    # List all products (cached)
GET    /api/products/{id}               # Get product by ID
GET    /api/products/category/{category} # Filter by category
GET    /api/products/search?q=laptop    # Search products
POST   /api/products                    # Create product
PUT    /api/products/{id}               # Update product
DELETE /api/products/{id}               # Delete product
```

### Orders
```http
GET    /api/orders?customerId=cust_123           # Customer orders
GET    /api/orders/{id}                          # Order details
POST   /api/orders?customerId=cust_123           # Create order
PUT    /api/orders/{id}/status?status=CONFIRMED  # Update status
```

## ☁️ Deploy to AWS

### ECS / EC2
```bash
aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin <account>.dkr.ecr.ap-south-1.amazonaws.com
docker build -t ecommerce-api .
docker tag ecommerce-api:latest <account>.dkr.ecr.ap-south-1.amazonaws.com/ecommerce-api:latest
docker push <account>.dkr.ecr.ap-south-1.amazonaws.com/ecommerce-api:latest
```

### RDS + ElastiCache
Replace localhost PostgreSQL/Redis with AWS RDS and ElastiCache instances.

## 🧪 Run Tests
```bash
./mvnw test
```

---
**Built for Enterpret Backend SDE Intern application.**