create table HERA_PARTY_RELATIONSHIP (
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
    FROM_PARTY_ROLE_ID varchar(36),
    TO_PARTY_ROLE_ID varchar(36),
    FROM_DATE date,
    THRU_DATE date,
    NAME varchar(100),
    DESCRIPTION varchar(255),
    --
    primary key (ID)
);