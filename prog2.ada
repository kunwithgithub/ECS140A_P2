procedure test2 is
	procedure Sum(A,B: Integer) is
	   begin
	   writeln(A + B);
	   end Sum;

begin
writeln("This is main");
Sum(3,5);
end; 
