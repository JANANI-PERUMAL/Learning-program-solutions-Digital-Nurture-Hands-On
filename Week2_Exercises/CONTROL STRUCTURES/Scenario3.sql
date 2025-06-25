SET SERVEROUTPUT ON;

DECLARE
   CURSOR due_loans_cur IS
      SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
      FROM Loans l
      JOIN Customers c ON l.CustomerID = c.CustomerID
      WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
   FOR rec IN due_loans_cur LOOP
      DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name ||
                           ', your loan (Loan ID: ' || rec.LoanID ||
                           ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY') ||
                           '. Please ensure timely payment.');
   END LOOP;
END;
/
