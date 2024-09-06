
-- Sample data for bank account


CREATE DATABASE BANK;
USE BANK;

CREATE TABLE accounts(
name VARCHAR(20),
account_no VARCHAR(20),
type VARCHAR(10),
balance VARCHAR(10)
);

INSERT INTO accounts (name,account_no,type,balance)
VALUES 
('sam','11111','saving','100'),
('om','22222','student','2500'),
('kiran','33333','saving','10000'),
('vivek','44444','student','8100'),
('bheem','55555','saving','1500'),
('raju','12345','saving','5000'),
('mike','99999','student','56100');

UPDATE accounts
SET balance = balance + 13300 where name ='kiran';




select * from accounts;

select * from accounts where account_no = 22222;


