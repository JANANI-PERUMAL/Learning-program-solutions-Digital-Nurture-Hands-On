DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (
        SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        LEFT JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            -- Reduce interest only if loan exists
            IF rec.LoanID IS NOT NULL THEN
                UPDATE Loans
                SET InterestRate = rec.InterestRate - 1
                WHERE LoanID = rec.LoanID;

                INSERT INTO Loan_Update_Logs (CustomerID, Age, LoanChanged)
                VALUES (rec.CustomerID, v_age, 'Loan Rate Reduced');
            ELSE
                INSERT INTO Loan_Update_Logs (CustomerID, Age, LoanChanged)
                VALUES (rec.CustomerID, v_age, 'Eligible - No Loan Found');
            END IF;
        ELSE
            INSERT INTO Loan_Update_Logs (CustomerID, Age, LoanChanged)
            VALUES (rec.CustomerID, v_age, 'No Change in Loan');
        END IF;
    END LOOP;

    COMMIT;
END;
/
select *from loan_update_logs