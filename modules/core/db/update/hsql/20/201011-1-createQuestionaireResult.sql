create table HERA_QUESTIONAIRE_RESULT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PERSON_ID varchar(36),
    EMPLOYEE_ID varchar(36),
    QUESTIONAIREITEM_ID varchar(36),
    RESULT_ANSWER varchar(255),
    ON_DATE date,
    --
    primary key (ID)
);