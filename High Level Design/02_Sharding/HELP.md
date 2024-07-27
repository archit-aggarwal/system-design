# Getting Started

1. To start postgres container, run commands from postgres directory
2. <code> find . -type f -exec chmod +x {} + </code> to give execution permissions
3. <code> docker-compose up -d </code> to start postgres container
4. Build Gradle Project from base directory using command <code> ./gradlew clean build </code>
5. Start Main Application using command <code> ./gradlew bootRun </code>
6. Open Postman And Hit Different API endpoints (get, post, delete)
7. Confirm if sharding is working properly in postgres containers using psql command:
8. In shard1 container: <code> psql -h shard1 -U postgres_admin -d shard1_db </code>
9. In shard2 container: <code> psql -h shard2 -U postgres_admin -d shard2_db </code>
10. See all records are same in users table & products table and they are mutually exclusive.

Postgres Replication Streaming Tutorial: https://github.com/marcel-dempers/docker-development-youtube-series/blob/master/storage/databases/postgresql/3-replication/README.md

### Reference Documentation

For further reference, please consider the following sections:

- [Official Gradle documentation](https://docs.gradle.org)
- [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.2/gradle-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.2/gradle-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links

These additional references should also help you:

- [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
