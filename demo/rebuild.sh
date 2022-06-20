docker-compose down
rm src/main/docker/demo-0.0.1-SNAPSHOT.jar
./mvnw clean package -DskipTests
cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker
docker rmi demo:latest
