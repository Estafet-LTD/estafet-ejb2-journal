create sequence ENTRY_ID_SEQ start 1 increment 1;
create table JOURNAL_ENTRY (JOURNAL_ENTRY_ID int4 not null, ENTRY_DATE timestamp not null, ENTRY_TEXT varchar(255) not null, JOURNAL_USER_ID varchar(255) not null, primary key (JOURNAL_ENTRY_ID));
create table JOURNAL_USER (JOURNAL_USER_ID varchar(255) not null, NAME varchar(255) not null, primary key (JOURNAL_USER_ID));
alter table JOURNAL_ENTRY add constraint FKocbwlvn1s8kw0go6h9lc2744i foreign key (JOURNAL_USER_ID) references JOURNAL_USER;
