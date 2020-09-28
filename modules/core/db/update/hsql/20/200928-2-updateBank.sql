-- update HERA_BANK set ORGANIZATION_ID = <default_value> where ORGANIZATION_ID is null ;
alter table HERA_BANK alter column ORGANIZATION_ID set not null ;
