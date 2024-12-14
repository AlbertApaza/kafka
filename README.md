# Building an Application with Debezium

## Overview
This project demonstrates how to set up and use Debezium for Change Data Capture (CDC) with Kafka.

## Prerequisites
- Docker
- Docker Compose

## Installation
1. Clone this repository:
   git clone (https://github.com/AlbertApaza/kafka.git)
   cd kafka
2. Start the services:
   docker-compose up -d

## Configuration
- MySQL is set up to log transactions.
- Debezium connector is configured in `debezium-config/mysql-connector.json`.

## Usage
- To see Debezium in action, insert, update, or delete data in the MySQL database. Events will be streamed to Kafka.
- Use the Java consumer in `src/DebeziumEventConsumer.java` to process these events.

## Monitoring
- Use the `scripts/setup.sh` script to enable necessary MySQL configurations for Debezium.

## Troubleshooting
- Check logs with `docker-compose logs` for any service.

## Cleanup
- Stop and remove containers:
  docker-compose down
