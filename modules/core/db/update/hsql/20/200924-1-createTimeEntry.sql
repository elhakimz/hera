create table HERA_TIME_ENTRY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TIMESHEET_ID varchar(36),
    ENTRY_ID varchar(100),
    FROM_DATE_TIME timestamp not null,
    THRU_DATE_TIME timestamp,
    HOURS double precision,
    NOTE varchar(255),
    WORKEFFORT_ID varchar(36),
    --
    primary key (ID)
);