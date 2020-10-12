alter table HERA_EMPLOYEE_REQUEST add column AMOUNT decimal(19, 2) ;
alter table HERA_EMPLOYEE_REQUEST add column REASON varchar(255) ;
alter table HERA_EMPLOYEE_REQUEST add column ISSUEDATE date ;
alter table HERA_EMPLOYEE_REQUEST add column PROCESSDATE date ;
alter table HERA_EMPLOYEE_REQUEST add column PROCESSSTATE varchar(255) ;
alter table HERA_EMPLOYEE_REQUEST add column EMPLOYEEREQUESTTYPE varchar(50) ;
alter table HERA_EMPLOYEE_REQUEST add column MANAGER_ID varchar(36) ;
alter table HERA_EMPLOYEE_REQUEST add column REQUESTTODATE date ;
alter table HERA_EMPLOYEE_REQUEST add column REQUESTFROMDATE date ;
