create table nodes (
    nodes varchar(5) not null
);

insert into nodes values ('1');
insert into nodes values ('2');
insert into nodes values ('3');
insert into nodes values ('4');
insert into nodes values ('5');
insert into nodes values ('6');
insert into nodes values ('7');
insert into nodes values ('8');
insert into nodes values ('9');
insert into nodes values ('10');
insert into nodes values ('11');
insert into nodes values ('12');
insert into nodes values ('13');
insert into nodes values ('14');
insert into nodes values ('15');
insert into nodes values ('16');
insert into nodes values ('17');
insert into nodes values ('18');
insert into nodes values ('19');
insert into nodes values ('20');

create table edges (
    "from" varchar(5) not null,
    "to" varchar(5) not null,
    distance varchar(5) not null
);

insert into edges values ('1','11','1');
insert into edges values ('1','10','1');
insert into edges values ('1','2','1');
insert into edges values ('2','12','1');
insert into edges values ('2','1','1');
insert into edges values ('2','3','1');
insert into edges values ('3','13','1');
insert into edges values ('3','2','1');
insert into edges values ('3','4','1');
insert into edges values ('4','14','1');
insert into edges values ('4','3','1');
insert into edges values ('4','5','1');
insert into edges values ('5','15','1');
insert into edges values ('5','4','1');
insert into edges values ('5','6','1');
insert into edges values ('6','16','1');
insert into edges values ('6','5','1');
insert into edges values ('6','7','1');
insert into edges values ('7','17','1');
insert into edges values ('7','6','1');
insert into edges values ('7','8','1');
insert into edges values ('8','18','1');
insert into edges values ('8','7','1');
insert into edges values ('8','9','1');
insert into edges values ('9','19','1');
insert into edges values ('9','8','1');
insert into edges values ('9','10','1');
insert into edges values ('10','20','1');
insert into edges values ('10','9','1');
insert into edges values ('10','1','1');
insert into edges values ('11','1','1');
insert into edges values ('11','19','1');
insert into edges values ('11','13','1');
insert into edges values ('12','2','1');
insert into edges values ('12','20','1');
insert into edges values ('12','14','1');
insert into edges values ('13','3','1');
insert into edges values ('13','11','1');
insert into edges values ('13','15','1');
insert into edges values ('14','4','1');
insert into edges values ('14','12','1');
insert into edges values ('14','16','1');
insert into edges values ('15','5','1');
insert into edges values ('15','13','1');
insert into edges values ('15','17','1');
insert into edges values ('16','6','1');
insert into edges values ('16','14','1');
insert into edges values ('16','18','1');
insert into edges values ('17','7','1');
insert into edges values ('17','15','1');
insert into edges values ('17','19','1');
insert into edges values ('18','8','1');
insert into edges values ('18','16','1');
insert into edges values ('18','20','1');
insert into edges values ('19','9','1');
insert into edges values ('19','17','1');
insert into edges values ('19','11','1');
insert into edges values ('20','10','1');
insert into edges values ('20','18','1');
insert into edges values ('20','12','1');