CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
AS
BEGIN
    -- Update salaries by adding bonus
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;
    
    DBMS_OUTPUT.PUT_LINE('Bonus applied successfully to ' || p_department || ' department.');
END;
/
call UpdateEmployeeBonus('IT', 10);
call UpdateEmployeeBonus('HR', 40);
COLUMN EMPLOYEEID FORMAT 999
COLUMN NAME FORMAT A20
COLUMN POSITION FORMAT A15
COLUMN SALARY FORMAT 99999
COLUMN DEPARTMENT FORMAT A15
COLUMN HIREDATE FORMAT A10

SELECT * FROM Employees;

