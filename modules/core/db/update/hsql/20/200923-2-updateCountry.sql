update HERA_COUNTRY set NAME = '' where NAME is null ;
alter table HERA_COUNTRY alter column NAME set not null ;
