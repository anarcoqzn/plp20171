
insere(X, L, [X|L]).

insereFim(N, [], [N]).
insereFim(T, [H], L) :- insere(H, [T], L).
insereFim(N, [H|T], L) :- insereFim(N, T, X), insere(H, X, L).

lista1(0, L).
lista1(N, L) :-  read_line_to_codes(user_input, A3),
				string_to_atom(A3,A12),
				atom_number(A12,N1),
				insereFim(N1, L, L1),
				lista1(Z, L1), Z is N - 1 .
				



:- initialization main.

main :-
	read_line_to_codes(user_input, A2),
	string_to_atom(A2,A1),
	atom_number(A1,N),
	
	lista1(N, L1),
	
	write(L1), nl.
