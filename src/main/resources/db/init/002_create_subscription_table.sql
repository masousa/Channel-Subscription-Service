CREATE TABLE subscription (
  id VARCHAR(36) PRIMARY KEY,
  sku_id VARCHAR(255),
  user_id VARCHAR(255),
  value DECIMAL(10,2),
  status_subscription VARCHAR(50),

  FOREIGN KEY (user_id) REFERENCES user(id)
)