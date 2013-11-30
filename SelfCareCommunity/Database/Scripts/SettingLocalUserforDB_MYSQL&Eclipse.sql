Create database test;
CREATE USER 'SCClocaluser'@'localhost' IDENTIFIED BY 'scc';
GRANT ALL PRIVILEGES ON * . * TO 'SCClocaluser'@'localhost';
FLUSH PRIVILEGES;