CREATE TABLE subscriptions (
  id VARCHAR(36) PRIMARY KEY,
  transaction_id VARCHAR(255),
  user_id VARCHAR(255),
  status_subscription VARCHAR(50),
 FOREIGN KEY (user_id) REFERENCES users(id)
)
