alter table HERA_PARTY alter column PARTY_TYPE rename to PARTY_TYPE__U57225 ^
alter table HERA_PARTY add column GENDER varchar(50) ;
alter table HERA_PARTY add column BIRTH_DATE date ;
alter table HERA_PARTY add column BIRTH_PLACE varchar(100) ;
alter table HERA_PARTY add column FULL_NAME varchar(100) ;
alter table HERA_PARTY add column SALUTATION varchar(50) ;
alter table HERA_PARTY add column MIDDLE_NAME varchar(100) ;
alter table HERA_PARTY add column DTYPE varchar(31) ;
alter table HERA_PARTY add column LAST_NAME varchar(100) ;
alter table HERA_PARTY add column FIRST_NAME varchar(100) ;
