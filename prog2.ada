procedure Show_Increment is
   A, B, C : Integer;

   procedure Display_Result is
   begin
   end Display_Result;

begin
   A := 10;
   B := 3;
   C := Increment_By (A, B);
   Display_Result;
end Show_Increment;