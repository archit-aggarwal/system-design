#!/bin/bash
set -e

# Set the password for the postgres_admin user (for pg_isready)
export PGPASSWORD=postgres_admin

# Wait for the master to be ready
until pg_isready -h master -p 5432 -U postgres_admin -d postgres_db; do
  echo "Waiting for master to be ready..."
  sleep 2
done

# Stop PostgreSQL if it's running
pg_ctl stop -D /data

# Clean the data directory
rm -rf /data/*

# Set the password for the replicator user
export PGPASSWORD=replication_password

# Base backup from master
pg_basebackup -h master -p 5432 -U replicator -D /data/ -Fp -Xs -R

# Set the password for the postgres_admin user
export PGPASSWORD=postgres_admin

# Start PostgreSQL
pg_ctl start -D /data
