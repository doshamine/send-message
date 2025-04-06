create table if not exists Message
(id identity primary key, date timestamp, text varchar(200), author varchar(50), receiver varchar(50));