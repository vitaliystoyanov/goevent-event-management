# GoEvent Event Management
## Running application:
1. Build PostgreSQL Docker image:
```
docker build -t goevent/goevent-postgres:1.0 src/main/posgtres-docker/
```
2. Run Docker container:
```
docker run -d --name=goevent-postgres -p 5432:5432 goevent/goevent-postgres:1.0
```
3. Wait until PostgreSQL finishes initialization. You can check status manually:
```
docker logs -f goevent-postgres
```

4. Run application:
```
./gradlew :bootRun
```
