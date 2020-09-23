-- begin HERA_PARTY
create table HERA_PARTY (
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
    NAME varchar(100),
    PHOTO_IMAGE_ID varchar(36),
    --
    -- from hera_Organization
    FULL_NAME varchar(100),
    --
    -- from hera_Person
    SALUTATION varchar(50),
    FIRST_NAME varchar(100),
    MIDDLE_NAME varchar(100),
    LAST_NAME varchar(100),
    BIRTH_DATE date,
    BIRTH_PLACE varchar(100),
    GENDER varchar(50),
    --
    primary key (ID)
)^
-- end HERA_PARTY
-- begin HERA_PARTY_ADDRESS
create table HERA_PARTY_ADDRESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PARTY_ID varchar(36),
    ADDRESS_LINE1 varchar(100),
    ADDRESS_LINE2 varchar(100),
    CITY varchar(100),
    PROVINCE varchar(100),
    POSTAL_CODE varchar(25),
    COUNTRY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_PARTY_ADDRESS
-- begin HERA_PARTY_ROLE
create table HERA_PARTY_ROLE (
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
    NAME varchar(100),
    DESCRIPTION varchar(255),
    PARTY_ID varchar(36),
    FROM_DATE date,
    THRU_DATE date,
    --
    -- from hera_Employee
    EMP_CODE varchar(11),
    --
    primary key (ID)
)^
-- end HERA_PARTY_ROLE
-- begin HERA_COUNTRY
create table HERA_COUNTRY (
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
    CODE varchar(20),
    --
    primary key (ID)
)^
-- end HERA_COUNTRY
-- begin HERA_PARTY_CONTACT
create table HERA_PARTY_CONTACT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CONTACT_TYPE varchar(50),
    CONTACT_NUMBER varchar(100),
    IS_ACTIVE boolean,
    PARTY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_PARTY_CONTACT
-- begin HERA_PARTY_IDENTIFIER
create table HERA_PARTY_IDENTIFIER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IDENT_TYPE varchar(50),
    IDENT_NUMBER varchar(100),
    FROM_DATE date,
    THRU_DATE date,
    PARTY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_PARTY_IDENTIFIER
-- begin HERA_PARTY_RELATIONSHIP
create table HERA_PARTY_RELATIONSHIP (
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
    FROM_PARTY_ROLE_ID varchar(36),
    TO_PARTY_ROLE_ID varchar(36),
    FROM_DATE date,
    THRU_DATE date,
    NAME varchar(100),
    DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end HERA_PARTY_RELATIONSHIP
-- begin HERA_POSITION
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
    ACT_THRU_DATE date,
    POSITION_TYPE_ID varchar(36) not null,
    BUDGET_ITEM_ID varchar(36),
    WITHIN_ORGANIZATION_ID varchar(36),
    STATUS_TYPE varchar(50),
    --
    primary key (ID)
)^
-- end HERA_POSITION
-- begin HERA_POSITION_CLASSIFICATION_TYPE
create table HERA_POSITION_CLASSIFICATION_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(100),
    DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end HERA_POSITION_CLASSIFICATION_TYPE
-- begin HERA_POSITION_FULFILLMENT
create table HERA_POSITION_FULFILLMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FROM_DATE date,
    THRU_DATE date,
    NOTE longvarchar,
    ACCEPTED_BY_ID varchar(36),
    FULFILLMENT_OF_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_POSITION_FULFILLMENT
-- begin HERA_POSITION_TYPE
create table HERA_POSITION_TYPE (
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
    CODE varchar(10),
    DESCRIPTION varchar(255),
    BENEFIT_PERCENT double precision,
    COMPANY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_POSITION_TYPE
-- begin HERA_BUDGET_ITEM
create table HERA_BUDGET_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SEQ_ID integer,
    AMOUNT decimal(19, 2),
    PURPOSE varchar(100),
    JUSTIFICATION longvarchar,
    --
    primary key (ID)
)^
-- end HERA_BUDGET_ITEM
-- begin HERA_POSITION_RESPONSIBILITY
create table HERA_POSITION_RESPONSIBILITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    POSITION_ID varchar(36),
    FROM_DATE date,
    THRU_DATE date,
    NOTE varchar(255),
    --
    primary key (ID)
)^
-- end HERA_POSITION_RESPONSIBILITY
-- begin HERA_POSITION_TYPE_CLASS
create table HERA_POSITION_TYPE_CLASS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FROM_DATE date,
    THRU_DATE date,
    STANDARD_HOURS_PER_WEEK double precision,
    CLASSIFICATION_TYPE_ID varchar(36),
    POSITION_TYPE_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_POSITION_TYPE_CLASS
