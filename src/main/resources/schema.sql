DROP TABLE IF EXISTS wedstrijdticket;
DROP TABLE IF EXISTS stadium;
DROP TABLE IF EXISTS wedstrijd;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

create table wedstrijdticket (
  id bigint not null primary key AUTO_INCREMENT,
  tickets int,
  stadium_id bigint,
  wedstrijd_id bigint
);

create table stadium (
  id bigint not null primary key AUTO_INCREMENT,
  naam varchar(255)
);

create table wedstrijd (
  id bigint not null primary key AUTO_INCREMENT,
  datum timestamp,
  landA varchar(255),
  landB varchar(255)
);

create table users (   
  username varchar(50) not null primary key,
  password varchar(255) not null,
  enabled boolean not null
);

create table authorities (
  username varchar(50) not null,
  authority varchar(50) not null,
  foreign key (username) references users (username),
  unique index authorities_idx_1 (username, authority)
);
