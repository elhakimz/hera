create table HERA_EMPLOYMENT_APPL_STEP (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYMENTAPPLICATION_ID varchar(36),
    STEPDATE date,
    HIRINGSTEPTYPE varchar(50),
    DESCRIPTION varchar(255),
    --
    primary key (ID)
);