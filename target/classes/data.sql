-- Insertar en la tabla users solo si no existen los registros
INSERT INTO users (name, email, password)
SELECT 'John Doe', 'john.doe@example.com', 'password123'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'john.doe@example.com');

INSERT INTO users (name, email, password)
SELECT 'Jane Smith', 'jane.smith@example.com', 'password456'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'jane.smith@example.com');

INSERT INTO users (name, email, password)
SELECT 'Alice Johnson', 'alice.johnson@example.com', 'password789'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'alice.johnson@example.com');

-- Insertar en la tabla posts solo si no existen los registros
INSERT INTO posts (user_id, title, content)
SELECT 1, 'First Post', 'This is the content of the first post.'
WHERE NOT EXISTS (SELECT 1 FROM posts WHERE user_id = 1 AND title = 'First Post');

INSERT INTO posts (user_id, title, content)
SELECT 1, 'Second Post', 'This is another post by the first user.'
WHERE NOT EXISTS (SELECT 1 FROM posts WHERE user_id = 1 AND title = 'Second Post');

INSERT INTO posts (user_id, title, content)
SELECT 2, 'Hello World', 'A post from the second user.'
WHERE NOT EXISTS (SELECT 1 FROM posts WHERE user_id = 2 AND title = 'Hello World');