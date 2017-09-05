# GoEvent Event Management
## Running application:
1. Build Docker image with PostgreSQL:
```
sudo docker build -t goevent/goevent-postgres:1.0 src/main/posgres-docker/
```
2. Run Docker container:
```
sudo docker run -d --name=goevent-postgres -p 5432:5432 goevent/goevent-postgres:1.0
```
3. Run application:
```
./gradlew :bootRun
```
