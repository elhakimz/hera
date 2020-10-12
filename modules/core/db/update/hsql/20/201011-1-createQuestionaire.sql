create table HERA_QUESTIONAIRE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    QUESTIONAIRETYPE_ID varchar(36),
    FROM_DATE date,
    TO_DATE date,
    NAME varchar(100),
    DESCRIPTION varchar(255),
    MAKER_ID varchar(36),
    PROCESS_STATE varchar(25),
    PROCESS_DATE date,
    --
    primary key (ID)
);