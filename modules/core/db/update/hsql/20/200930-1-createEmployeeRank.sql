create table HERA_EMPLOYEE_RANK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLYEE_ID varchar(36),
    RANK_TYPE_ID varchar(36),
    PROMOTIONDATE date,
    --
    primary key (ID)
);