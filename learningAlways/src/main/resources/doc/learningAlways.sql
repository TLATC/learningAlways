DROP TABLE T_SHAWN_EXAMPLE;
create table T_SHAWN_EXAMPLE
(
  ID           VARCHAR2(100),
  CREATER      VARCHAR2(100),
  CREATETIME   VARCHAR2(100),
  MODIFIER     VARCHAR2(100),
  MODIFIEDTIME VARCHAR2(100),
  DELTAG       VARCHAR2(100),
  NAME         VARCHAR2(100),
  AGE          VARCHAR2(100)
);
comment on table T_SHAWN_EXAMPLE
  is '示例表';
comment on column T_SHAWN_EXAMPLE.ID
  is '主键ID';
comment on column T_SHAWN_EXAMPLE.CREATER
  is '创建人';
comment on column T_SHAWN_EXAMPLE.CREATETIME
  is '创建时间';
comment on column T_SHAWN_EXAMPLE.MODIFIER
  is '修改人';
comment on column T_SHAWN_EXAMPLE.MODIFIEDTIME
  is '修改时间';
comment on column T_SHAWN_EXAMPLE.DELTAG
  is '软删标识（0表示未删除，1表示已删除）';
comment on column T_SHAWN_EXAMPLE.NAME
  is '姓名';
comment on column T_SHAWN_EXAMPLE.AGE
  is '年龄';

insert into T_SHAWN_EXAMPLE (ID, CREATER, CREATETIME, MODIFIER, MODIFIEDTIME, DELTAG, NAME, AGE)
values ('f3501bd3a0994feb999ea0fcf30594a1', 'shawn', '2018-04-26 09:47:19', 'shawn', '2018-04-26 09:47:19', '0', '钱二', '16');
insert into T_SHAWN_EXAMPLE (ID, CREATER, CREATETIME, MODIFIER, MODIFIEDTIME, DELTAG, NAME, AGE)
values ('f3501bd3a0994feb999ea0fcf30594a2', 'shawn', '2018-04-27 09:44:59', 'shawn', '2018-04-27 09:44:59', '0', '孙三', '14');
insert into T_SHAWN_EXAMPLE (ID, CREATER, CREATETIME, MODIFIER, MODIFIEDTIME, DELTAG, NAME, AGE)
values ('f3501bd3a0994feb999ea0fcf30594a3', 'shawn', '2018-05-01 09:44:19', 'shawn', '2018-05-01 09:44:19', '0', '李四', '14');
insert into T_SHAWN_EXAMPLE (ID, CREATER, CREATETIME, MODIFIER, MODIFIEDTIME, DELTAG, NAME, AGE)
values ('f3501bd3a0994feb999ea0fcf30594a4', 'shawn', '2018-05-01 14:04:33', 'shawn', '2018-05-01 14:04:33', '0', '周五', '16');
insert into T_SHAWN_EXAMPLE (ID, CREATER, CREATETIME, MODIFIER, MODIFIEDTIME, DELTAG, NAME, AGE)
values ('f3501bd3a0994feb999ea0fcf30594a5', 'shawn', '2018-05-03 13:23:11', 'shawn', '2018-05-03 13:23:11', '0', '吴六', '16');
insert into T_SHAWN_EXAMPLE (ID, CREATER, CREATETIME, MODIFIER, MODIFIEDTIME, DELTAG, NAME, AGE)
values ('f3501bd3a0994feb999ea0fcf30594a6', 'shawn', '2018-05-04 16:34:41', 'shawn', '2018-05-04 16:34:41', '0', '郑七', '14');
insert into T_SHAWN_EXAMPLE (ID, CREATER, CREATETIME, MODIFIER, MODIFIEDTIME, DELTAG, NAME, AGE)
values ('f3501bd3a0994feb999ea0fcf30594ac', 'shawn', '2018-04-25 09:44:19', 'shawn', '2018-04-25 09:45:55', '0', '赵一', '14');



commit;