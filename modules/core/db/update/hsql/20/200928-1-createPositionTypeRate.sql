create table HERA_POSITION_TYPE_RATE (
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
    RATE decimal(19, 2),
    RATE_TYPE varchar(50),
    POSITION_TYPE_ID varchar(36),
    SALARY_STEP_ID varchar(36),
    --
    primary key (ID)
);