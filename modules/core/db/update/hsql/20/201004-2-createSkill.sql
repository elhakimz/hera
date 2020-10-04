alter table HERA_SKILL add constraint FK_HERA_SKILL_ON_PERSON foreign key (PERSON_ID) references HERA_PARTY(ID);
create index IDX_HERA_SKILL_ON_PERSON on HERA_SKILL (PERSON_ID);
