SELECT
id as id,
username as username,
password as password,
email as email,
role as role
FROM ministeriodb.usuario
WHERE dataExclusao IS NULL
    AND username = :username AND password = :password;