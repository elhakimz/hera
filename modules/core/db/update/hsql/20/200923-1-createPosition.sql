create table HERA_POSITION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EST_FROM_DATE date,
    EST_THRU_DATE date,
    HAS_SALARY boolean,
    IS_EXEMPT boolean,
    IS_FULL_TIME boolean,
    IS_TEMPORARY boolean,
    ACT_FROM_DATE date,
    ACT_THRU_DATE boolean,
    POSITION_TYPE_ID varchar(36),
    BUDGET_ITEM_ID varchar(36),
    WITHIN_ORGANIZATION_ID varchar(36),
    STATUS_TYPE varchar(50),
    --
    primary key (ID)
);