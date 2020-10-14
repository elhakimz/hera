create table HERA_EMPLOYEE_USER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    user_ID varchar(36),
    EMPLOYEE_ID varchar(36),
    IS_ACTIVE boolean,
    REGISTER_DATE date,
    --
    primary key (ID)
);