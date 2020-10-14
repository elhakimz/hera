alter table HERA_EMPLOYEE_RANK alter column RANK_TYPE_ID rename to RANK_TYPE_ID__U05909 ^
drop index IDX_HERA_EMPLOYEE_RANK_ON_RANK_TYPE ;
alter table HERA_EMPLOYEE_RANK add column RANK_TYPE_ID varchar(36) ;
