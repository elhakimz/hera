create table HERA_PAY_HISTORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FRON_DATE date,
    THRU_DATE date,
    AMOUNT decimal(19, 2),
    DESCRIPTION varchar(255),
    EMPLOYMENT_ID varchar(36),
    PERIOD_TYPE varchar(50),
    SALARY_STEP_ID varchar(36),
    --
    primary key (ID)
);