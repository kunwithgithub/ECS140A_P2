procedure Main is
      
      procedure Prime(x : integer) is
            
            I : integer;
            J : integer;
            
            begin
            
            I := 2;
            J := 1;
            
            while I < x loop 
                
               if x mod I = 0 then
                   
                  J := 0 * I;
               
               endif;
               I := I + 1;
            
            end loop;
            
            if J = 0 then
             
               write("0");
            
            elseif x <= 1 then
              
               write("0");
            
            else
                
               write("1");
            endif;
          end Prime;
          
          I : integer;
          begin
          
          I := 1;
          while I <= 100 loop
              if I = 100 then 
                Prime(I);
              else
                Prime(I);
                write(",");
              endif;
              I := I + 1;
          end loop;
      End Main; 
