create table HERA_TIMESHEET (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36),
    FROM_DATE date not null,
    THRU_DATE date,
    NOTE varchar(255),
    --
    primary key (ID)
);