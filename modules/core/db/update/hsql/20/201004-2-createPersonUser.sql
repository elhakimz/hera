alter table HERA_PERSON_USER add constraint FK_HERA_PERSON_USER_ON_PERSON foreign key (PERSON_ID) references HERA_PARTY(ID);
alter table HERA_PERSON_USER add constraint FK_HERA_PERSON_USER_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_HERA_PERSON_USER_ON_PERSON on HERA_PERSON_USER (PERSON_ID);
create index IDX_HERA_PERSON_USER_ON_USER on HERA_PERSON_USER (USER_ID);
