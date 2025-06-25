CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  -- Apply 1% interest to all non-VIP customers
  UPDATE Customers
  SET 
    Balance = Balance + (Balance * 0.01),
    LASTMODIFIED = SYSDATE
  WHERE ISVIP = 'FALSE';

  COMMIT;
END;
/
call ProcessMonthlyInterest();
select *from Customers;
