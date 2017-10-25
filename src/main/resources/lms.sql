--
-- LMS Schema capturing information on Users, Books and their usage.
--

-- =================================================================================================
-- Users registered to use the Library.

create table if not exists users (
id varchar(20) primary key,
name varchar(50) not null,
age int,
max_book_borrow_count int default 10
);

-- Books available in the Library.

create table if not exists books (
id varchar(20) primary key,
name varchar(300) not null,
author varchar(100),
edition varchar(30) not null,
price bigint not null
);

-- Books in use by the Users.

create table if not exists book_users (
book_id varchar(20) references books(id) not null,
user_id varchar(20) references users(id) not null,
borrowed_date bigint not null, -- in Epoch milli seconds.
expiry_date bigint not null, -- same as above.
status char(1) not null, -- possible values are B (for Borrowed), and R (for Returned).
primary key(book_id, user_id)
);