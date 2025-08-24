CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_id      IN NUMBER,
    p_destination_id IN NUMBER,
    p_amount         IN NUMBER
)
AS
    v_source_balance NUMBER;
BEGIN
    -- Get source balance
    SELECT Balance INTO v_source_balance
    FROM Customers
    WHERE CustomerID = p_source_id;

    -- Check sufficient balance
    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Insufficient balance in source account.');
    ELSE
        -- Deduct from source
        UPDATE Customers
        SET Balance = Balance - p_amount
        WHERE CustomerID = p_source_id;

        -- Add to destination
        UPDATE Customers
        SET Balance = Balance + p_amount
        WHERE CustomerID = p_destination_id;

        DBMS_OUTPUT.PUT_LINE('Transfer of $' || p_amount || 
            ' from Customer ' || p_source_id || 
            ' to Customer ' || p_destination_id || ' completed.');
    END IF;
END;
/
call TransferFunds(8, 7, 200);
call TransferFunds(7, 8, 2000);


select *from Customers;