CREATE TABLE "users" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE "projects" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE "time_spent" (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    time TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id SERIAL REFERENCES users(id) ON DELETE CASCADE,
    project_id SERIAL REFERENCES projects(id) ON DELETE CASCADE
);
