//创建用户表  Default_ schema下
create table Default_.users
(
    user_id      int primary key auto_increment,
    phone_number char(11) unique,
    password     varchar(8),
    car_id       varchar(15)
);

//创建运输单表
create table Default_.transports
(
    t_id               int primary key auto_increment,
    uid                int references Defalut_.users (user_id),
    origin             varchar(20),
    destination        varchar(20),
    open_time          Datetime,
    close_time         Datetime,
    covid_test         boolean,
    covid_test_customs varchar(20),
    covid_test_delay   int,
    order_state        int
);

//修改表结构
alter table Default_.transports change column state order_state int;

//查找所有的订单信息
select * from Default_.transports;
