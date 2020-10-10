create table HERA_NAME_DESCRIPTION (
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
    DESCRIPTION varchar(255),
    VALIDFROM date,
    VALIDUNTIL date,
    LANG varchar(10),
    --
    primary key (ID)
);