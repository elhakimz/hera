create table HERA_POSITION_STRUCTURE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    POSITION_ID varchar(36),
    MANAGED_BY_ID varchar(36),
    DESCRIPTION varchar(255),
    FROM_DATE date,
    THRU_DATE date,
    STATUS varchar(50),
    --
    primary key (ID)
);