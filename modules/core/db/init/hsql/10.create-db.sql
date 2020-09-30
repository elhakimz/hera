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
    -- from hera_Company
    PARENT_COMPANY_ID varchar(36),
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
-- begin HERA_BANK
create table HERA_BANK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORGANIZATION_ID varchar(36) not null,
    BIC varchar(100),
    --
    primary key (ID)
)^
-- end HERA_BANK
-- begin HERA_TIME_ENTRY
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
)^
-- end HERA_TIME_ENTRY
-- begin HERA_TIMESHEET
create table HERA_TIMESHEET (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36),
    FROM_DATE date not null,
    THRU_DATE date,
    NOTE varchar(255),
    --
    primary key (ID)
)^
-- end HERA_TIMESHEET
-- begin HERA_WORKEFFORT
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
)^
-- end HERA_WORKEFFORT
-- begin HERA_BANK_ACCOUNT
create table HERA_BANK_ACCOUNT (
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
    BANK_ID varchar(36),
    CURRENCY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_BANK_ACCOUNT
-- begin HERA_CURRENCY
create table HERA_CURRENCY (
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
    CODE varchar(10),
    COUNTRY_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_CURRENCY
-- begin HERA_PAYCHECK
create table HERA_PAYCHECK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end HERA_PAYCHECK
-- begin HERA_POSITION_STRUCTURE
create table HERA_POSITION_STRUCTURE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    POSITION_ID varchar(36) not null,
    REPORT_TO_NAME varchar(100),
    MANAGED_BY_ID varchar(36),
    FROM_DATE date,
    THRU_DATE date,
    IS_PRIMARY boolean,
    STATUS varchar(50),
    --
    primary key (ID)
)^
-- end HERA_POSITION_STRUCTURE
-- begin HERA_ATTENDANCE
create table HERA_ATTENDANCE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36),
    FROM_DATE_TIME timestamp,
    TO_DATE_TIME timestamp,
    ATTENDANCE_TYPE varchar(50),
    HAS_PERMIT boolean,
    LEAVE_TIME time,
    LEAVE_PERMITTED_BY_ID varchar(36),
    EXTRA_HOUR_PERMITTED_BY_ID varchar(36),
    EXTRA_HOURS_REASON varchar(255),
    TIMESHEET_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_ATTENDANCE
-- begin HERA_SALARY_STEP
create table HERA_SALARY_STEP (
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
    DATE_MODIFIED date,
    PAY_GRADE_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_SALARY_STEP
-- begin HERA_POSITION_TYPE_RATE
create table HERA_POSITION_TYPE_RATE (
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
    RATE decimal(19, 2),
    RATE_TYPE varchar(50),
    POSITION_TYPE_ID varchar(36),
    PERIOD_TYPE varchar(50),
    SALARY_STEP_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_POSITION_TYPE_RATE
-- begin HERA_PAY_HISTORY
create table HERA_PAY_HISTORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FRON_DATE date,
    THRU_DATE date,
    AMOUNT decimal(19, 2),
    DESCRIPTION varchar(255),
    EMPLOYMENT_ID varchar(36),
    PERIOD_TYPE varchar(50),
    SALARY_STEP_ID varchar(36),
    --
    primary key (ID)
)^
-- end HERA_PAY_HISTORY
-- begin HERA_PAY_GRADE
create table HERA_PAY_GRADE (
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
-- end HERA_PAY_GRADE
-- begin HERA_BANK_ACCOUNT_NUMBER
create table HERA_BANK_ACCOUNT_NUMBER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BANK_ACCOUNT_ID varchar(36),
    NUMBER_TYPE varchar(50),
    ACCOUNT_NO varchar(100),
    COMPACT_ACCOUNT_NO varchar(100),
    EXPIRE_DATE date,
    IS_ACTIVE boolean,
    --
    primary key (ID)
)^
-- end HERA_BANK_ACCOUNT_NUMBER
-- begin HERA_EMPLOYEE_RANK
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
)^
-- end HERA_EMPLOYEE_RANK
-- begin HERA_RANK
create table HERA_RANK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end HERA_RANK
