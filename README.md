## This is Late Pos API Project ##

## Setup Database ##

1. Run postgresql in docker

- windows
```
docker run --rm --name late-pos-api-db -e POSTGRES_DB=late-pos-api-db -e POSTGRES_USER=late-pos-api -e POSTGRES_PASSWORD=TdRju8A4xpaT7zdCMzhc -e PGDATA=/var/lib/postgresql/data/pgdata -v /late-pos-api-db:/var/lib/postgresql/data -p 5432:5432 postgres:13
```

- linux or macos
```
docker run --rm \
    --name late-pos-api-db \
    -e POSTGRES_DB=late-pos-api-db \
    -e POSTGRES_USER=late-pos-api \
    -e POSTGRES_PASSWORD=TdRju8A4xpaT7zdCMzhc \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v /late-pos-api-db:/var/lib/postgresql/data \
    -p 5432:5432 \
    postgres:13
```