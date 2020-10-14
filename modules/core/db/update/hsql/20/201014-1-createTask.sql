create table HERA_TASK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(255),
    TODO longvarchar,
    FROM_DATE date,
    TO_DATE date,
    PRIORITY_TYPE varchar(50),
    --
    -- from hera_EmployeeTask
    EMPLOYEE_ID varchar(36),
    --
    primary key (ID)
);