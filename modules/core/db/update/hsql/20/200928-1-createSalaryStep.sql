create table HERA_SALARY_STEP (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SEQ_ID integer,
    AMOUNT decimal(19, 2),
    DATE_MODIFIED date,
    PAY_GRADE_ID varchar(36),
    --
    primary key (ID)
);