-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE studentregistration;
-- 使用数据库
use studentregistration;

DROP TABLE IF EXISTS academy;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS course_select;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS student_course;
DROP TABLE IF EXISTS teacher;


CREATE TABLE academy(
  academy_id varchar(64) NOT NULL COMMENT '班级专业id',
  academy_name varchar(64) NOT NULL COMMENT '学院名称',
  class_Name varchar(64) NOT NULL COMMENT '专业班级名称',
  status char(1) NOT NULL DEFAULT 0 COMMENT '状态（0在用 1删除 2）',
  PRIMARY KEY (academy_id),
  key idx_academy_name(academy_name),
  key idx_class_Name(class_Name),
  key idx_status(status)
)CHARSET=utf8 COMMENT='学院专业';


CREATE TABLE course(
  course_id varchar(64) NOT NULL COMMENT '课程id',
  academy_id varchar(64) NOT NULL COMMENT '学院专业id',
  teacher_id varchar(64) NOT NULL COMMENT '教师id',
  cno varchar(64) NOT NULL COMMENT '课程编码',
  course_name varchar(100) NOT NULL COMMENT '课程名称',
  grade varchar(64) NOT NULL COMMENT '学期',
  credit int NOT NULL COMMENT '学分',
  room varchar(64) NOT NULL COMMENT '教室',
  lesson varchar(64) NOT NULL COMMENT '节次',
  week varchar(64) NOT NULL COMMENT '周次',
  status char(1) NOT NULL DEFAULT 0 COMMENT '状态（0在上 1删除 2已过）',
  remarks varchar(500) COMMENT '备注信息',
  PRIMARY KEY (course_id)
)CHARSET=utf8 COMMENT='课程信息';


CREATE TABLE course_select(
  course_select_id varchar(64) NOT NULL COMMENT '选课id',
  max_num int NOT NULL COMMENT '上限人数',
  left_num int NOT NULL COMMENT '剩余',
  `start_time` TIMESTAMP  NOT NULL COMMENT '选课开始时间',
  `end_time`   TIMESTAMP   NOT NULL COMMENT '选课结束时间',

  course_id varchar(64) NOT NULL COMMENT '课程id',
  academy_id varchar(64) NOT NULL COMMENT '学院专业id',
  teacher_id varchar(64) NOT NULL COMMENT '教师id',
  teacher_name varchar(100) NOT NULL COMMENT '教师姓名',

  cno varchar(64) NOT NULL COMMENT '课程编码',
  course_name varchar(100) NOT NULL COMMENT '课程名称',
  grade varchar(64) NOT NULL COMMENT '学期',
  credit int NOT NULL COMMENT '学分',
  room varchar(64) NOT NULL COMMENT '教室',
  lesson varchar(64) NOT NULL COMMENT '节次',
  week varchar(64) NOT NULL COMMENT '周次',
  status char(1) NOT NULL DEFAULT 0 COMMENT  '状态（0在上 1删除 2已过）',

  PRIMARY KEY (course_select_id)
)CHARSET=utf8 COMMENT='选课安排';

CREATE TABLE student(
  student_id varchar(64) NOT NULL COMMENT '学生id',
  academy_id varchar(64) NOT NULL COMMENT '学院专业编码',
  sno varchar(64) NOT NULL COMMENT '学生编码',
  student_name varchar(100) NOT NULL COMMENT '学生姓名',
  phone varchar(100) COMMENT '电话',
  email varchar(300) COMMENT '电子邮箱',
  pw varchar(64) NOT NULL COMMENT '密码',
  status char(1) NOT NULL DEFAULT 0 COMMENT '状态（0在读 1删除 2毕业）',
  remarks varchar(500) COMMENT '备注信息',
  PRIMARY KEY (student_id)
)CHARSET=utf8 COMMENT='学生信息';

CREATE TABLE student_course(
  student_id varchar(64) NOT NULL COMMENT '学生id',
  course_id varchar(64) NOT NULL COMMENT '课程id',
  score int COMMENT '成绩',
  status char(1) NOT NULL DEFAULT 0 COMMENT '状态（0在职 1删除 2离职）',
  PRIMARY KEY (student_id,course_id)
)CHARSET=utf8 COMMENT='学生课程关联';

CREATE TABLE teacher(
  teacher_id varchar(64) NOT NULL COMMENT '教师id',
  academy_id varchar(64) NOT NULL COMMENT '学院专业编码',
  tno varchar(64) NOT NULL COMMENT '教师编码',
  teacher_name varchar(100) NOT NULL COMMENT '教师姓名',
  phone varchar(100) COMMENT '电话',
  email varchar(300) COMMENT '电子邮箱',
  pw varchar(64) NOT NULL COMMENT '密码',
  status char(1) NOT NULL DEFAULT 0 COMMENT '状态（0在职 1删除 2离职）',
  remarks varchar(500) COMMENT '备注信息',
  PRIMARY KEY (teacher_id)
)CHARSET=utf8 COMMENT='教师信息';



  -- SHOW CREATE TABLE seckill;#显示表的创建信息



-- 初始化数据
INSERT into academy(academy_id,academy_name,class_Name)
VALUES
  ('1','信息学院','计算机一班'),
  ('8','经济学院','投资学一班'),
  ('6','管理学院','酒店管理一班');

INSERT into course(course_id,academy_id,teacher_id,cno,course_name,grade,credit,room,lesson,week)
VALUES
  ('1','1','1','20180601','信息技术','第二学期','2','一教201','0304','1-16'),
  ('8','8','8','20190601','计算机网络','第一学期','3','二教101','03040506','1-8'),
  ('6','6','6','20170301','面对对象','大一第一学期','2','实验楼666','1112','8-16');

INSERT into course_select(course_select_id,max_num,left_num,end_time,start_time,course_id,academy_id,teacher_id,cno,course_name,grade,credit,room,lesson,week)
VALUES
  (1,54,44,'2016-01-01 00:00:00','2016-01-02 00:00:00','1','1','1','20180601','信息技术','大二第二学期','2','一教201','0304','1-16'),
  (3,34,24,'2016-01-01 00:00:00','2016-01-02 00:00:00','8','8','8','20190601','计算机网络','大三第一学期','3','二教101','03040506','1-8'),
  (5,64,33,'2016-01-01 00:00:00','2016-01-02 00:00:00','6','6','6','20170301','面对对象','大一第一学期','2','实验楼666','1112','8-16');

INSERT INTO `teacher` VALUES ('1', '1', '11', 'tea1', '', null, '111111', '0', null);
INSERT INTO `teacher` VALUES ('2', '2', '22', 'tea2', null, null, '222222', '0', null);
INSERT INTO `teacher` VALUES ('3', '3', '33', 'tea3', null, null, '333333', '0', null);

INSERT INTO `student` VALUES ('1', '1', '11', 'stu1', '1', null, '111111', '0', null);
INSERT INTO `student` VALUES ('2', '2', '22', 'stu2', '2', null, '222222', '0', null);
INSERT INTO `student` VALUES ('3', '3', '33', 'stu3', '3', null, '333333', '0', null);