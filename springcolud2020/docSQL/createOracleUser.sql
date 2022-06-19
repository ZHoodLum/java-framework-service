--创建用户
CREATE USER springcloud IDENTIFIED BY springcloud
DEFAULT TABLESPACE SPRINGCLOUD
TEMPORARY TABLESPACE TEMP
QUOTA UNLIMITED ON SPRINGCLOUD;

--用户授权
GRANT CREATE SEQUENCE TO springcloud;
GRANT CREATE SESSION TO springcloud;
GRANT CREATE SYNONYM TO springcloud;
GRANT CREATE TRIGGER TO springcloud;
GRANT CREATE TYPE TO springcloud;

GRANT CREATE ANY PROCEDURE TO springcloud;
GRANT CREATE ANY TABLE TO springcloud;
GRANT CREATE ANY VIEW TO springcloud;
GRANT SELECT ANY DICTIONARY TO springcloud;

--管理员sysdba 账户查询当前所有用户
select username from dba_users order by created;


update user$ set name ='esbsg' where name='springcloud';
