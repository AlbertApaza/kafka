#!/bin/bash
echo "Setting up MySQL for Debezium..."
docker-compose exec mysql mysql -uroot -ppassword -e "SET GLOBAL binlog_format = 'ROW'; SET GLOBAL binlog_row_image = 'FULL';"