alter table HERA_PARTY add constraint FK_HERA_PARTY_ON_PHOTO_IMAGE foreign key (PHOTO_IMAGE_ID) references SYS_FILE(ID);
create index IDX_HERA_PARTY_ON_PHOTO_IMAGE on HERA_PARTY (PHOTO_IMAGE_ID);
