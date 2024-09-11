mvn compile
mvn package -DskipTests
docker build . -t questboard-api:1.0
docker run -d -p 8080:8080 -v h2-data:/data questboard-api:1.0