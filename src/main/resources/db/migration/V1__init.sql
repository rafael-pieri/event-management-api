use event_management;

create table organizer
(
  id int not null auto_increment,name varchar(20) not null,
  created timestamp default current_timestamp,
  primary key (id)
);


create table venue
(
  id int not null auto_increment,
  created timestamp default current_timestamp,
  name varchar(256),
  street_address varchar(256),
  street_address2 varchar(256),
  city varchar(256),
  state varchar(256),
  country varchar(256),
  postal_code varchar(256),
  primary key (id)
);


create table event
(
  id int not null auto_increment,
  created timestamp default current_timestamp,
  name varchar(256),
  description varchar(2048),
  start_time timestamp default current_timestamp,
  end_time timestamp default current_timestamp,
  zone_id blob,
  started int,
  organizer_id int not null,
  venue_id int,
  primary key (id),
  foreign key (organizer_id) references organizer(id) on delete cascade,
  foreign key (venue_id) references venue(id)
);


create table participant
(
  id int not null auto_increment,
  created timestamp default current_timestamp,
  name varchar(256) not null,
  email varchar(256) not null,
  checked_in int,
  event_id int not null,
  primary key (id),
  foreign key (event_id) references event(id),
  unique (event_id, email)
);