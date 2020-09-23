alter table HERA_PARTY_ROLE add column EMP_CODE varchar(11) ^
update HERA_PARTY_ROLE set EMP_CODE = '' where EMP_CODE is null ;
alter table HERA_PARTY_ROLE alter column EMP_CODE set not null ;
alter table HERA_PARTY_ROLE add column FROM_DATE date ;
alter table HERA_PARTY_ROLE add column DTYPE varchar(31) ;
alter table HERA_PARTY_ROLE add column THRU_DATE date ;
