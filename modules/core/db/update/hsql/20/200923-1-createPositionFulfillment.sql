create table HERA_POSITION_FULFILLMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FROM_DATE date,
    THRU_DATE date,
    NOTE longvarchar,
    ACCEPTED_BY_ID varchar(36),
    FULFILLMENT_OF_ID varchar(36),
    --
    primary key (ID)
);