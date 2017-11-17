alter table JOURNAL_ENTRY drop constraint FKocbwlvn1s8kw0go6h9lc2744i;
drop table if exists JOURNAL_ENTRY cascade;
drop table if exists JOURNAL_USER cascade;
drop sequence if exists ENTRY_ID_SEQ;
