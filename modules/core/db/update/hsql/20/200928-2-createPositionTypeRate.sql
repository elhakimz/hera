alter table HERA_POSITION_TYPE_RATE add constraint FK_HERA_POSITION_TYPE_RATE_ON_POSITION_TYPE foreign key (POSITION_TYPE_ID) references HERA_POSITION_TYPE(ID);
alter table HERA_POSITION_TYPE_RATE add constraint FK_HERA_POSITION_TYPE_RATE_ON_SALARY_STEP foreign key (SALARY_STEP_ID) references HERA_SALARY_STEP(ID);
create index IDX_HERA_POSITION_TYPE_RATE_ON_POSITION_TYPE on HERA_POSITION_TYPE_RATE (POSITION_TYPE_ID);
create index IDX_HERA_POSITION_TYPE_RATE_ON_SALARY_STEP on HERA_POSITION_TYPE_RATE (SALARY_STEP_ID);
