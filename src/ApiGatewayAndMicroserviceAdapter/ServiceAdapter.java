package ApiGatewayAndMicroserviceAdapter;


// Each question blends core Java, design patterns, system design, and distributed infra concepts — all in an LLD-to-HLD escalation format.

// 1️⃣ API Gateway & Microservice Adapter (Adapter Pattern + AWS + Spring Boot)

// Goal: Design an API Gateway that connects multiple microservices with different response formats.

// Requirements:

// Gateway receives requests from clients (JSON/XML).

// Uses Adapter pattern to normalize data from different downstream services (e.g., AuthService, ProductService).

// Add rate limiting using Redis.

// Use AWS Lambda to simulate one downstream service.

// Add logging via an asynchronous logger (ExecutorService or CompletableFuture).
public interface ServiceAdapter {
      UnifiedResponse adaptRequest(Object request);
}
