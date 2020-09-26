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
);