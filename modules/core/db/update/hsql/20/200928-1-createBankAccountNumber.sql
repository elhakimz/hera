create table HERA_BANK_ACCOUNT_NUMBER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BANK_ACCOUNT_ID varchar(36),
    NUMBER_TYPE varchar(50),
    ACCOUNT_NO varchar(100),
    COMPACT_ACCOUNT_NO varchar(100),
    EXPIRE_DATE date,
    --
    primary key (ID)
);