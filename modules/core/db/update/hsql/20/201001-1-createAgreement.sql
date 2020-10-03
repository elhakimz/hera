create table HERA_AGREEMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(100),
    AGREEMENT_DATE date,
    FROM_DATE date,
    THRU_DATE date,
    DESCRIPTION varchar(255),
    AGREEMENT_TYPE varchar(50),
    PARTY_RELATIONSHIP_ID varchar(36),
    TEXTUAL varchar(255),
    --
    primary key (ID)
);