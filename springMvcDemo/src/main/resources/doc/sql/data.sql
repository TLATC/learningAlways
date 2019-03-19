create table T_SHAWN_EXAMPLE
(
  EXAMPLEID    NUMBER not null,
  NAME         VARCHAR2(100),
  AGE          NUMBER,
  GENDER       NUMBER,
  CREATER      VARCHAR2(100),
  CREATETIME   VARCHAR2(100),
  MODIFIER     VARCHAR2(100),
  MODIFIEDTIME VARCHAR2(100)
);
comment on table T_SHAWN_EXAMPLE
  is '示例表';
comment on column T_SHAWN_EXAMPLE.EXAMPLEID
  is '主键id';
comment on column T_SHAWN_EXAMPLE.NAME
  is '姓名';
comment on column T_SHAWN_EXAMPLE.AGE
  is '年龄';
comment on column T_SHAWN_EXAMPLE.GENDER
  is '性别（0为女，1为男）';
comment on column T_SHAWN_EXAMPLE.CREATER
  is '创建人';
comment on column T_SHAWN_EXAMPLE.CREATETIME
  is '创建时间';
comment on column T_SHAWN_EXAMPLE.MODIFIER
  is '修改人';
comment on column T_SHAWN_EXAMPLE.MODIFIEDTIME
  is '修改时间';





COMMIT;