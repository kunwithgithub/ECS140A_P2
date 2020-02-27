procedure Foo is
    I : integer;
Var : constant := 2;
    procedure Bar(x : integer; y : integer) is
z : integer;
    begin
I := 4;
while I < 7 loop
I := I + 1;
writeln(x);
end loop;
I := 4;
if I > y then
        x := 2 + 4 * 6;
writeln(x);
elseif I <= 5 then
I := 1;
else
I := 2;
endif;
    end Bar;
begin
    Bar(3,7);
Bar(0,0);
write(I);
    writeln(Var);
end Foo;
