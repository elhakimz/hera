alter table HERA_BANK_ACCOUNT add constraint FK_HERA_BANK_ACCOUNT_ON_PARTY foreign key (PARTY_ID) references HERA_PARTY(ID);
create index IDX_HERA_BANK_ACCOUNT_ON_PARTY on HERA_BANK_ACCOUNT (PARTY_ID);
