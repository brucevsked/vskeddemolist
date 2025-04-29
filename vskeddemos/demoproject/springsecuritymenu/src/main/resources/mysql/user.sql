CREATE DATABASE IF NOT EXISTS `springsecuritytest`;

ALTER DATABASE `springsecuritytest`
  DEFAULT CHARACTER SET 'utf8mb4'
  DEFAULT COLLATE 'utf8mb4_unicode_ci';

GRANT ALL PRIVILEGES ON springsecuritytest.* TO 'springsecuritytest@%' IDENTIFIED BY 'springsecuritytest';
