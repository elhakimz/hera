create table HERA_PARTY_ADDRESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PARTY_ID varchar(36),
    ADDRESS_LINE1 varchar(100),
    ADDRESS_LINE2 varchar(100),
    CITY varchar(100),
    PROVINCE varchar(100),
    POSTAL_CODE varchar(25),
    --
    primary key (ID)
);