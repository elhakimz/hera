alter table HERA_COURSE add constraint FK_HERA_COURSE_ON_PERSON foreign key (PERSON_ID) references HERA_PARTY(ID);
create index IDX_HERA_COURSE_ON_PERSON on HERA_COURSE (PERSON_ID);
