alter table HERA_EMPLOYMENT_APPL_STEP add constraint FK_HERA_EMPLOYMENT_APPL_STEP_ON_EMPLOYMENTAPPLICATION foreign key (EMPLOYMENTAPPLICATION_ID) references HERA_EMPLOYMENT_APPLICATION(ID);
create index IDX_HERA_EMPLOYMENT_APPL_STEP_ON_EMPLOYMENTAPPLICATION on HERA_EMPLOYMENT_APPL_STEP (EMPLOYMENTAPPLICATION_ID);
