create table HERA_QUESTIONAIRE_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    QUESTIONAIRE_ID varchar(36),
    QUESTION varchar(255),
    LANG_CODE varchar(10),
    ANSWER varchar(255),
    QUESTION_TYPE varchar(50),
    WEIGHT double precision,
    --
    primary key (ID)
);