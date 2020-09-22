-- begin HERA_PARTY
create table HERA_PARTY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(100),
    --
    -- from hera_Organization
    FULL_NAME varchar(100),
    --
    -- from hera_Person
    SALUTATION varchar(50),
    FIRST_NAME varchar(100),
    MIDDLE_NAME varchar(100),
    LAST_NAME varchar(100),
    BIRTH_DATE date,
    BIRTH_PLACE varchar(100),
    GENDER varchar(50),
    --
    primary key (ID)
)^
-- end HERA_PARTY
-- begin HERA_PARTY_ADDRESS
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
    COUNTRY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_PARTY_ADDRESS
-- begin HERA_PARTY_ROLE
create table HERA_PARTY_ROLE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100),
    DESCRIPTION varchar(255),
    PARTY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_PARTY_ROLE
-- begin HERA_COUNTRY
create table HERA_COUNTRY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    DESCRIPTION varchar(255),
    CODE varchar(20),
    --
    primary key (ID)
)^
-- end HERA_COUNTRY
