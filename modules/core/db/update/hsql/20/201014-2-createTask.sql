alter table HERA_TASK add constraint FK_HERA_TASK_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references HERA_PARTY_ROLE(ID);
create index IDX_HERA_TASK_ON_EMPLOYEE on HERA_TASK (EMPLOYEE_ID);
