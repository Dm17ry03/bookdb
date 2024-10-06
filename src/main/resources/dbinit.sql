create table if not exists public.books
(
    id     serial
        primary key,
    title  varchar(100) not null,
    author varchar(100) not null
);