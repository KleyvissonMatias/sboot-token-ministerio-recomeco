INSERT INTO ministeriodb.usuarios
(username, password, email, `role`, dataInclusao)
VALUES(:username, :password, :email, :role, NOW());