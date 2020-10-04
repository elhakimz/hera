alter table HERA_SKILL alter column TO_DATE rename to TO_DATE__U99949 ^
alter table HERA_SKILL alter column FROM_DATE rename to FROM_DATE__U40143 ^
alter table HERA_SKILL add column YEARS_EXPERIENCE integer ;
alter table HERA_SKILL add column SKILL_TYPE_ID varchar(36) ;
