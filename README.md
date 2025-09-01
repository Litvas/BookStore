## 1) Requirements
- Install **Docker** (with Docker Compose v2).
    - Check: `docker --version` and `docker compose version`

## 2) Fill the `.env` file in the project root
Put your own credentials. Example:

## 3) Open a terminal and go to the compose folder
```bash
cd Docker/docker-compose
docker compose --env-file ../../.env up -d
docker compose --env-file ../../.env up -d bookstore-service
docker compose --env-file ../../.env down
::contentReference[oaicite:0]{index=0}
