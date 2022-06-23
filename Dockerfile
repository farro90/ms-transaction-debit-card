FROM openjdk:11
VOLUME /tmp
EXPOSE 8117
ADD ./target/ms-transaction-debit-card-0.0.1-SNAPSHOT.jar ms-transaction-debit-card.jar
ENTRYPOINT ["java","-jar","ms-transaction-debit-card.jar"]