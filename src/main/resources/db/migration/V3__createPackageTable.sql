CREATE TABLE packages (
    id VARCHAR(36) PRIMARY KEY,
    transaction_id VARCHAR(255),
    subscription_id varchar(255),
    FOREIGN KEY (subscription_id) REFERENCES subscriptions(id)
)
