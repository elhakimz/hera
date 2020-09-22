alter table HERA_PARTY_ROLE add constraint FK_HERA_PARTY_ROLE_ON_PARTY foreign key (PARTY_ID) references HERA_PARTY(ID);
create index IDX_HERA_PARTY_ROLE_ON_PARTY on HERA_PARTY_ROLE (PARTY_ID);
