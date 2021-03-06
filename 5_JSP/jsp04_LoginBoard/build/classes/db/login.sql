CREATE SEQUENCE MYNOSEQ NOCACHE;

CREATE TABLE MYMEMBER(
	MYNO NUMBER NOT NULL,
	MYID VARCHAR2(500) NOT NULL,
	MYPW VARCHAR2(500) NOT NULL,
	MYNAME VARCHAR2(1000) NOT NULL,
	MYADDR VARCHAR2(4000) NOT NULL,
	MYPHONE VARCHAR2(20) NOT NULL,
	MYEMAIL VARCHAR2(100) NOT NULL,
	MYENABLED VARCHAR2(2) NOT NULL,
	MYROLE VARCHAR2(50) NOT NULL,
	CONSTRAINT MYMEMBER_PK PRIMARY KEY(MYNO),
	CONSTRAINT MYMEMBER_UQ_ID UNIQUE(MYID),
	CONSTRAINT MYMEMBER_UQ_PHONE UNIQUE(MYPHONE),
	CONSTRAINT MYMEMBER_UQ_EMAIL UNIQUE(MYEMAIL),
	CONSTRAINT MYMEMBER_CHK_ENABLED CHECK(MYENABLED IN ('Y','N'))
);

INSERT INTO MYMEMBER
VALUES(MYNOSEQ.NEXTVAL,'ADMIN','ADMIN1234','관리자','관리시 관리구 관리동','010-1234-5678',
		'ADMIN@MYMEMBER.COM','Y','ADMIN');

INSERT INTO MYMEMBER
VALUES(MYNOSEQ.NEXTVAL,'USER1','USER1234','이창진','경기도 화성시','010-4321-1234',
		'USER1@MYMEMBER.COM','Y','USER');

INSERT INTO MYMEMBER
VALUES(MYNOSEQ.NEXTVAL,'USER2','USER1234','박창진','경기도 수성시','010-4321-3432',
		'USER2@MYMEMBER.COM','Y','USER');

INSERT INTO MYMEMBER
VALUES(MYNOSEQ.NEXTVAL,'USER3','USER1234','김창진','경기도 안양시','010-4321-2222',
		'USER3@MYMEMBER.COM','Y','ADMIN');

INSERT INTO MYMEMBER
VALUES(MYNOSEQ.NEXTVAL,'USER4','USER1234','최창진','경기도 평택시','010-4321-3333',
		'USER4@MYMEMBER.COM','N','USER');

SELECT * FROM MYMEMBER;