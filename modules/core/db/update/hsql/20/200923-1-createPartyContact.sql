create table HERA_PARTY_CONTACT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CONTACT_TYPE varchar(50),
    CONTACT_NUMBER varchar(100),
    IS_ACTIVE boolean,
    PARTY_ID varchar(36),
    --
    primary key (ID)
);