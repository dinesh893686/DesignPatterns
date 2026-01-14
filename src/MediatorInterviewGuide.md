## Chat Room Mediator

- **Functional requirements**
  - Mediator coordinates message delivery between users; no direct user-to-user calls.
  - System must handle many users chatting simultaneously without message loss.
  - Mediator enforces ordering and broadcasts messages atomically.
  - Solution should support optimizing read-heavy broadcast traffic without sacrificing consistency.
- **Non-functional requirements**
  - Thread safety: prove how the mediator avoids race conditions.
  - Scalability: discuss how to add more users without contention spikes.
  - Observability: logging/tracing per message to debug delivery issues.
  - Extensibility: ability to plug in filters (profanity, spam) without touching clients.
- **Cross-questions**
  1. How do you guarantee message ordering when multiple senders post concurrently?
  2. What locking strategy minimizes contention as users scale from dozens to hundreds?
  3. How would you simulate network latency or failure in this setup?
  4. How could you persist chat history without coupling clients to storage?
- **Hints**
  - Correlate messages with sequence numbers or timestamps.
  - Mention thread pools, virtual threads, or messaging queues to simulate concurrency.
  - Consider `ReentrantReadWriteLock` or similar primitives for broadcast-heavy workloads.
  - Discuss pluggable interceptors or decorators.
  - Think about backing queue or append-only log for persistence.
- **Selection signals**
  - Presents clear mediator class diagram and threading model.
  - Addresses synchronization primitives and their trade-offs.
  - Plans for monitoring/logging to aid debugging.
  - Considers extensibility (filters, storage, metrics).
- **Rejection signals**
  - Ignores thread safety or downplays race conditions.
  - Hardcodes user interactions without mediator abstraction.
  - Leaves no strategy for scaling concurrent users.
  - Forgets observability or testing discussion.

---

## Ride-Hailing Dispatch System

- **Functional requirements**
  - Mediator accepts rider requests and assigns them to available drivers asynchronously.
  - Dispatcher must buffer pending requests and match them to drivers without direct rider-driver coupling.
  - Drivers process assignments independently and confirm acceptance or rejection.
  - System handles cancellations or timeouts when a match cannot be completed promptly.
- **Non-functional requirements**
  - Throughput: handle high request volume without starving drivers.
  - Fairness: avoid driver starvation; consider round-robin or priority rules.
  - Fault tolerance: design for driver thread failure and message redelivery.
  - Monitoring: track queue depth, assignment latency, failed assignments.
- **Cross-questions**
  1. How would you implement driver availability tracking?
  2. What strategies ensure riders are matched to nearby drivers (partitioning)?
  3. How do you handle retries when a driver rejects a ride?
  4. How can you simulate surge pricing in this mediator?
- **Hints**
  - Reference queues (e.g., blocking queues, Kafka topics) for distributing requests.
  - Use additional channels for driver status updates.
  - Partition by geographic zones or hashed rider ID.
  - Consider acknowledgment semantics similar to Kafka commits.
  - Introduce metrics (average wait time) to drive surge logic.
- **Selection signals**
  - Explains queue-based mediator clearly with concurrency considerations.
  - Identifies idempotent message handling for retries.
  - Details monitoring/metrics and prioritization policies.
  - Talks about scaling consumers (driver threads) safely.
- **Rejection signals**
  - Uses synchronous, single-threaded mediator.
  - Omits strategy for failed or timed-out assignments.
  - Ignores fairness or priority rules entirely.
  - No plan for instrumentation or failure recovery.

---

## Distributed Cache Synchronizer

- **Functional requirements**
  - Mediator routes cache `get`, `set`, and `invalidate` requests among collaborating services.
  - Shared cache state must remain consistent when accessed concurrently.
  - Writes and eviction updates should avoid race conditions while keeping latency low.
  - Design should account for eviction strategy when memory limits are reached.
- **Non-functional requirements**
  - Consistency: define read/write guarantees (eventual vs strong).
  - Latency: keep cache operations low-latency despite locking.
  - Observability: expose hit/miss metrics and eviction counters.
  - Recoverability: plan for cold-start repopulation and backup snapshots.
- **Cross-questions**
  1. How do you prevent stale reads when multiple services update the same key?
  2. What eviction policies work best under different workloads?
  3. How would you shard this cache mediator across multiple nodes?
  4. How can you integrate write-through or write-behind strategies?
- **Hints**
  - Mention shared data structures (`ConcurrentHashMap`, `LinkedHashMap`) or distributed caches.
  - Discuss versioning (timestamps) or compare-and-set semantics.
  - Consider using `ReadWriteLock`, `ReentrantLock`, or similar for managing contention.
  - Mention gossip or pub/sub invalidation for multi-node setups.
  - Think about persistence layer synchronization.
- **Selection signals**
  - Clearly explains locking strategy and its impact on throughput.
  - Addresses eviction complexity and data consistency trade-offs.
  - Highlights monitoring and recovery mechanisms.
  - Plans for horizontal scaling or sharding.
- **Rejection signals**
  - Assumes single-threaded access; ignores synchronization.
  - Leaves cache coherence and eviction unspecified.
  - No metrics or recovery discussion.
  - Cannot articulate scaling beyond a single JVM.

---

## Event-driven E-commerce Order System

- **Functional requirements**
  - Mediator ingests orders and fan-outs domain events to inventory, payment, and search services.
  - Events must travel through an asynchronous messaging backbone so services process work independently.
  - Payment service emits success/failure outcomes; failures route to a dedicated recovery stream.
  - Mediator correlates the order lifecycle and logs aggregate status without becoming a bottleneck.
- **Non-functional requirements**
  - Delivery semantics: at-least-once message handling with idempotent consumers.
  - Scalability: partition topics to scale services horizontally via consumer groups.
  - Resilience: design retries, DLQ processing, and partial failure handling.
  - Observability: metrics for topic lag, success rates, DLQ volumes; structured logs/traces.
- **Cross-questions**
  1. How do you keep the mediator stateless while tracking order status?
  2. Which key do you use for Kafka partitioning and why?
  3. How do you ensure idempotency if a consumer processes the same event twice?
  4. How is the dead-letter queue drained or reprocessed?
  5. What happens if the search indexer is offline during peak traffic?
- **Hints**
  - Reference event brokers (Kafka, Pulsar, RabbitMQ) and explain partitioning choices.
  - Use correlation IDs and external state stores for tracking.
  - Discuss schema versioning and contracts for topics.
  - Mention retries with exponential backoff and DLQ replay procedures.
  - Suggest monitoring stacks (Prometheus/Grafana, OpenTelemetry).
- **Selection signals**
  - Delivers a clear event flow with Kafka topics and consumer roles.
  - Shows command of idempotency, partitioning, and observability.
  - Plans for failure modes (partial outages, DLQs) and recovery.
  - Thinks ahead about extensibility (adding shipment/analytics services).
- **Rejection signals**
  - Treats mediator as monolithic processor without event semantics.
  - No plan for retries, DLQ handling, or consumer idempotency.
  - Ignores scaling strategy or monitoring requirements.
  - Cannot handle service outages gracefully.

