alter table HERA_POSITION_STRUCTURE add column IS_PRIMARY boolean ;
-- update HERA_POSITION_STRUCTURE set POSITION_ID = <default_value> where POSITION_ID is null ;
alter table HERA_POSITION_STRUCTURE alter column POSITION_ID set not null ;
