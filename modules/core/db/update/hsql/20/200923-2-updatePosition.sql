-- update HERA_POSITION set POSITION_TYPE_ID = <default_value> where POSITION_TYPE_ID is null ;
alter table HERA_POSITION alter column POSITION_TYPE_ID set not null ;
