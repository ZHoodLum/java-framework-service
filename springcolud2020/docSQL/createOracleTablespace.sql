--创建表空间
CREATE TABLESPACE SPRINGCLOUD DATAFILE 'SPRINGCLOUD.dbf' SIZE 100M
AUTOEXTEND OFF;

--查看表空间
SELECT * FROM Dba_Data_Files ddf WHERE ddf.tablespace_name = 'SPRINGCLOUD';