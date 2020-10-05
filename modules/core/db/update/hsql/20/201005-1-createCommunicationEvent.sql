create table HERA_COMMUNICATION_EVENT (
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
    TO_DATE date,
    NOTE varchar(255),
    PARTYRELATIONSHIP_ID varchar(36),
    STATUS_TYPE varchar(255),
    CONTACTMECHTYPE_ID varchar(36),
    --
    primary key (ID)
);