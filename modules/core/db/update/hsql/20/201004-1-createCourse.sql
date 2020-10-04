create table HERA_COURSE (
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
    NAME varchar(100),
    DESCRIPTION varchar(255),
    FROM_DATE date,
    TO_DATE date,
    QUALIFICATION_TYPE varchar(50),
    --
    primary key (ID)
);