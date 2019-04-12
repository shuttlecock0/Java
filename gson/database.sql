drop sensor;
create table sensor{
	sensor_id	number primary key,
	sensor_type	varchar2(20),
	value		number,
	regDate		date	default sysdate,
	owner		varchar2(30),
	place		varchar2(30)
};

drop sequence sensor_seq;
create sequence sensor_seq;