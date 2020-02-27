procedure TEST is

    COLUMN_MAX : constant := 10;

    ROW_MAX : constant := COLUMN_MAX;

    A : MATRIX;

    I : INTEGER;

    procedure INIT_MATRIX(X : INTEGER; Y : out MATRIX) is
         
         I, J : INTEGER;
         
        procedure INIT_MATRIX1(X : INTEGER; Y : out MATRIX) is
              
              I, J : INTEGER;
              
              begin
              I := 1;
              while I <= COLUMN_MAX loop
                   J := 1;
                   while J <= ROW_MAX loop
                        Y := X;
                        J := J + 1;
                        end loop;
                   I := I + 1;
                   end loop;
              
               end INIT_MATRIX1;
           begin
             I := 1;
           end INIT_MATRIX;

    begin
    I := 1;
    INIT_MATRIX(I, A);
    end TEST;
