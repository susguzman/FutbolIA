% Autor: jguzman
% Fecha: 08/04/2015

%HECHOS
%movimientos de jugadores equipo, rol, x1, y1, x2, y2
%equipo a
mov_jugador(a,por,0,3,1,7).
mov_jugador(a,def1,0,0,1,2).
mov_jugador(a,def1,0,8,1,10).
mov_jugador(a,def1,2,0,8,10).
mov_jugador(a,def2,0,0,1,2).
mov_jugador(a,def2,0,8,1,10).
mov_jugador(a,def2,2,0,8,10).
mov_jugador(a,del1,8,0,16,10).
mov_jugador(a,del2,8,0,16,10).

%equipo b
mov_jugador(b, por, 15,3,16,7).
mov_jugador(b, def1, 15,0,16,2).
mov_jugador(b, def1, 15,8,16,10).
mov_jugador(b, def1, 8,0,14,10).
mov_jugador(b, def2, 15,0,16,2).
mov_jugador(b, def2, 15,8,16,10).
mov_jugador(b, def2, 8,0,14,10).
mov_jugador(b, del1, 0,0,8,10).
mov_jugador(b, del2, 0,0,8,10).

%seting posiciones iniciales
:- dynamic(pos_jugador/4).
pos_jugador(a, por, 0, 5).
pos_jugador(a, def1, 2, 2).
pos_jugador(a, def2, 2, 8).
pos_jugador(a, del1, 8, 1).
pos_jugador(a, del2, 8, 6).

pos_jugador(b, por, 16, 5).
pos_jugador(b, def1, 14, 2).
pos_jugador(b, def2, 14, 8).
pos_jugador(b, del1, 8, 3).
pos_jugador(b, del2, 8, 9).

:- dynamic(pos_balon/2).
pos_balon(8,5).

:- dynamic(marcador/2).
marcador(0,0).

:- dynamic(l_dis/2).

:- dynamic(new_dir/2).

:- dynamic(mov_turno/1).
mov_turno(0).

:- dynamic(parte/1).
parte(1).

%REGLAS
set_pos_jugador(E,R,_,_) :- retract(pos_jugador(E,R,_,_)), fail.
set_pos_jugador(E,R,X,Y) :- assert(pos_jugador(E,R,X,Y)).

set_pos_balon(_,_) :- retract(pos_balon(_,_)), fail.
set_pos_balon(X,Y) :- assert(pos_balon(X,Y)).

set_marcador(_,_) :- retract(marcador(_,_)), fail.
set_marcador(X,Y) :- assert(marcador(X,Y)).

set_l_dis(J,D) :- assert(l_dis(J,D)).
clear_l_dis :- retract(l_dis(_,_)), fail.
clear_l_dis.

set_new_dir(_,_) :- retract(new_dir(_,_)), fail.
set_new_dir(X,Y) :- assert(new_dir(X,Y)).

set_mov_turno(_) :- retract(mov_turno(_)), fail.
set_mov_turno(X) :- assert(mov_turno(X)).

set_parte(_) :- retract(parte(_)), fail.
set_parte(X) :- assert(parte(X)).


set_gol_a :- marcador(X,Y), parte(P), P == 1, plus(X,1,Z), set_marcador(Z,Y).
set_gol_a :- marcador(X,Y), parte(P), P \== 1, plus(Y,1,Z), set_marcador(X,Z).
set_gol_b :- marcador(X,Y), parte(P), P == 1, plus(Y,1,Z), set_marcador(X,Z).
set_gol_b :- marcador(X,Y), parte(P), P \== 1, plus(X,1,Z), set_marcador(Z,Y).

minl([Only], Only).
minl([Head|Tail], Minimum) :- minl(Tail, TailMin),
                              Minimum is min(Head, TailMin), !.

can_mov_jugador(E,R,X,Y) :- mov_jugador(E,R,X1,Y1,X2,Y2),
                            X >= X1,
                            X =< X2,
                            Y >= Y1,
                            Y =< Y2.

/*can_mov_jugador(b,R,X,Y) :- mov_jugador(b,R,X1,Y1,X2,Y2),
                            X >= X2,
                            X =< X1,
                            Y >= Y1,
                            Y =< Y2.*/


do_mov_jugador(E,R,X,Y) :- can_mov_jugador(E,R,X,Y),
                           set_pos_jugador(E,R,X,Y),
                           !.

tengo_balon(E) :- pos_jugador(E,_,X,Y), pos_balon(X1,Y1), X == X1, Y == Y1.

crear_l_dis(E,X,Y) :- clear_l_dis,
	            pos_jugador(E,R,X1,Y1),
                    can_mov_jugador(E,R,X,Y),
                    DX is abs(X-X1),
                    DY is abs(Y-Y1),
                    D is sqrt((DX*DX) + (DY*DY)),
                    set_l_dis(R,D),
		    fail.

crear_l_dis2(E,X,Y) :- clear_l_dis,
	            pos_jugador(E,R,X1,Y1),
                    %can_mov_jugador(E,R,X,Y),
                    DX is abs(X-X1),
                    DY is abs(Y-Y1),
                    D is sqrt((DX*DX) + (DY*DY)),
                    set_l_dis(R,D),
		    fail.


add_mov_turno :- mov_turno(X), Y is X + 1, set_mov_turno(Y).

buscar(E) :- \+tengo_balon(E),
		   pos_balon(X,Y),
		   \+crear_l_dis(E,X,Y),
		   findall(D, l_dis(_,D), L),
		   minl(L,MIN),
		   l_dis(J,MIN),
		   do_mov_jugador(E,J,X,Y).

pasar(E) :-  tengo_balon(E),
	           pos_jugador(E,R,X_J,Y_J),
		   pos_balon(X_B,Y_B),
		   not((X_J == X_B, Y_J == Y_B)),
		   R\==por,
		   \+crear_l_dis2(E, X_B, Y_B),
		   l_dis(J,D), J == R,
		   D =< 3,
		   set_pos_balon(X_J,Y_J),
		   add_mov_turno,
		   !.

cacl_new_dir(0,X,Y,D) :- Y2 is Y-D, set_new_dir(X,Y2).
cacl_new_dir(1,X,Y,D) :- X2 is X+3, Y2 is Y - round(sqrt(abs((D*D)- 9))), set_new_dir(X2,Y2).
cacl_new_dir(2,X,Y,D) :- X2 is X+D, set_new_dir(X2,Y).
cacl_new_dir(3,X,Y,D) :- X2 is X+3, Y2 is Y + round(sqrt(abs((D*D)- 9))), set_new_dir(X2,Y2).
cacl_new_dir(4,X,Y,D) :- Y2 is Y+D, set_new_dir(X,Y2).
cacl_new_dir(5,X,Y,D) :- X2 is X-3, Y2 is Y + round(sqrt(abs((D*D)- 9))), set_new_dir(X2,Y2).
cacl_new_dir(6,X,Y,D) :- X2 is X-D, set_new_dir(X2,Y).
cacl_new_dir(7,X,Y,D) :- X2 is X-3, Y2 is Y - round(sqrt(abs((D*D)-9))),set_new_dir(X2,Y2).

avanzar(E) :- tengo_balon(E),
	      pos_balon(X_B,Y_B),
	      pos_jugador(E,R,X_B,Y_B),
	      random(0,8,DIR),
	      random(3,7,DIS),
	      cacl_new_dir(DIR,X_B,Y_B,DIS),
	      new_dir(X1,Y1),
	      do_mov_jugador(E,R,X1,Y1),
	      set_pos_balon(X1,Y1),
	      add_mov_turno,
	      !.

tirar(E) :-  tengo_balon(E),
	     pos_balon(X_B,Y_B),
	     pos_jugador(E,R,X_B,Y_B),
	     (R==del1; R==del2),
	     random(0,8,DIR),
	     random(1,6,DIS),
	     cacl_new_dir(DIR,X_B,Y_B,DIS),
	     new_dir(X1,Y1),
	     X1 >= 0,
	     X1 =< 16,
	     Y1 >= 0,
	     Y1 =< 10,
	     set_pos_balon(X1,Y1),
	     add_mov_turno,
	     !.

es_gol(a) :- pos_balon(X,Y), pos_jugador(E,por,X1,Y1), E\==a, X\==X1, Y\==Y1, X==15, Y>=4, Y=<6, set_gol_a, set_mov_turno(3), !.
es_gol(b) :- pos_balon(X,Y), pos_jugador(E,por,X1,Y1), E\==b, X\==X1, Y\==Y1, X==0, Y>=4, Y=<6, set_gol_b, set_mov_turno(3), !.

tiene_enemigo(a) :- pos_balon(X,Y), pos_jugador(E,_,X,Y), E\==a, set_mov_turno(3), !.
tiene_enemigo(b) :- pos_balon(X,Y), pos_jugador(E,_,X,Y), E\==b, set_mov_turno(3), !.

acciones(0,E) :- buscar(E), write(buscar).
acciones(1,E) :- pasar(E), write(pasar).
acciones(2,E) :- avanzar(E), write(avanzar).
acciones(3,E) :- tirar(E), write(tirar).

es_turno :- mov_turno(M), M < 3.

turno(E) :- es_turno, random(0,4,X), acciones(X,E), es_gol(E), tiene_enemigo(E).
