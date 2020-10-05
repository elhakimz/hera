create table HERA_EMPLOYMENT_APPLICATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(10),
    APPLYDATE date,
    POSITION_ID varchar(36),
    FROMPERSON_ID varchar(36),
    REFERPERSON_ID varchar(36),
    SOURCETYPE_ID varchar(36),
    DESCRIPTION varchar(255),
    PROCESS_STATE varchar(255),
    PROCESS_DATE date,
    --
    primary key (ID)
);