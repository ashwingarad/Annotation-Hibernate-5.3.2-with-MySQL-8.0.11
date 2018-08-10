# Annotation-Hibernate-5.3.2-with-MySQL-8.0.11
Using annotations

# Changes in hibernate.cfg.xml
Replace hibernate.dialect property org.hibernate.dialect.MySQL5Dialect to org.hibernate.dialect.MySQL8Dialect

# Hibernate 5 - What's new in Hibernate 5 Framework?

Hibernate ORM 5.2.10 Final is just released with many new features and improvements. In generate what are the new features which is added to the Hibernate 5 and how to use these features in making applications?

In Hibernate 5 many news features and improvements are present. Developers using Hibernate Framework should know all these features of Hibernate 5. Let's see the new features and changes made in Hibernate 5.

1. Hibernate Search
  Hibernate search come with great features in Hibernate 5. It automatically indexes the objects and offers full-text search along with fast search. It also comes with the clustering features and using Hibernate Search features is very easy now.

2. Hibernate Validator in ORM 5
  Hibernate validator comes with re ready to use validation functions like Email, Length, Not blank etc..

3. Java 8 Support in Hibernate ORM 5
  Hibernate 5 fully supports Java 8 features and you can use the features of Java 8 in your Hibernate 5 applications. It support Java 8 date/time types in Hibernate 5 based applications. It supports:

  DATE: java.time.LocalDate
  TIME: java.time.LocalTime, java.time.OffsetTime
  TIMESTAMP: java.time.Instant, java.time.LocalDateTime, java.time.OffsetDateTime and java.time.ZonedDateTime

4. OGM
  Hibernate 5 supports OGM and through this you can use Hibernate to persist data into NoSQL databases.

5. New Bootstrap API
  Hibernate 5 comes with new Bootstrap API which improves performance and helps in better integration.

  You can use the Hibernate 5 without persistence.xml through new bootstrap API. Hibernate JPA environment can be configured programmatically in runtime.

6. Ad-hoc Joins
  The ad-hoc joins feature is added in Hibernate 5.1 release.

7. Multi-entity loader
  This feature is also added in Hibernate 5.1.

8. Features added in Hibernate 5.2
  Following new features are added in Hibernate 5.2:

    Query.stream() can be used in Hibernate 5.2
    All the JPA methods can be accessed from Session Object
    It supports JCache
    Support for Session-level batch size
    Global timezone setting (e.g. UTC
    Now it supports Distinct pass-through hint
    More efficient HQL and JPQL
     hibernate.connection.provider_disables_autocommit resource-local transaction optimization in Hibernate 5.2. Old behavior can be switched on by setting hibernate.id.new_generator_mapping to false
