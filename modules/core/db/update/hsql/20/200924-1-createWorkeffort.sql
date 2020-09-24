create table HERA_WORKEFFORT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    DESCRIPTION varchar(255),
    SCHEDULED_START date not null,
    SCHEDULED_COMPLETION date not null,
    TOTAL_AMOUNT_ALLOWED decimal(19, 2),
    TOTAL_HOURS_ALLOWED double precision,
    ESTIMATED_HOURS double precision,
    ACTUAL_START date,
    ACTUAL_COMPLETION date,
    ACTUAL_HOURS double precision,
    SPECIAL_TERMS varchar(255),
    --
    primary key (ID)
);