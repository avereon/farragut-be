# AVN Farragut Database

## Database Platform

The AVN Farragut production database uses MariaDB [https://mariadb.org] version 10
or higher.

## Initial Configuration
* Log in to MariaDB as the root user:
  ```
  sudo mariadb
  ```
* Create the AVN Farragut database:
  ```
  create database farragut default character set utf8 default collate utf8_general_ci;
  ```
* Create the farragut user:
  ```
  grant all privileges on farragut.* to 'farragut'@'localhost' identified by '<password>' with grant option;
  ```
