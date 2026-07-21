# hangman-spring-nextjs
## Local Setup (Backend)
This project uses Docker to ensure a consistent environment across all machines.

1. Clone the repository.
2. Navigate to the `hangman-api` directory.
3. Copy `.env.example` to a new file named `.env` and add your secure local MySQL password.
4. Run the following command to build the database and start the Spring Boot API:
   `docker-compose up -d`

The API will be available at `http://localhost:8080` and the database will automatically seed itself with 1,000 Spanish vocabulary words.