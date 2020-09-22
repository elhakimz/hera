-- begin HERA_PARTY_ADDRESS
alter table HERA_PARTY_ADDRESS add constraint FK_HERA_PARTY_ADDRESS_ON_PARTY foreign key (PARTY_ID) references HERA_PARTY(ID)^
alter table HERA_PARTY_ADDRESS add constraint FK_HERA_PARTY_ADDRESS_ON_COUNTRY foreign key (COUNTRY_ID) references HERA_COUNTRY(ID)^
create index IDX_HERA_PARTY_ADDRESS_ON_PARTY on HERA_PARTY_ADDRESS (PARTY_ID)^
create index IDX_HERA_PARTY_ADDRESS_ON_COUNTRY on HERA_PARTY_ADDRESS (COUNTRY_ID)^
-- end HERA_PARTY_ADDRESS
-- begin HERA_PARTY_ROLE
alter table HERA_PARTY_ROLE add constraint FK_HERA_PARTY_ROLE_ON_PARTY foreign key (PARTY_ID) references HERA_PARTY(ID)^
create index IDX_HERA_PARTY_ROLE_ON_PARTY on HERA_PARTY_ROLE (PARTY_ID)^
-- end HERA_PARTY_ROLE
